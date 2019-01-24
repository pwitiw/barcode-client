package com.frontwit.barcode.restclient.barcode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Logger;

import static com.frontwit.barcode.restclient.common.Messages.TASK_EXECUTED_NOT_SUCCESSFULLY;
import static com.frontwit.barcode.restclient.common.Messages.TASK_EXECUTED_SUCCESSFULLY;

public class BarcodeHandler implements CommandHandler<BarcodeCommand> {

    private static final Logger LOGGER = Logger.getLogger(BarcodeHandler.class.getName());

    @Value("${task-execution-delay}")
    private Integer executionDelay;

    private BarcodeRestClient rest;

    private BarcodeCommandDao barcodeCommandDao;

    private TaskScheduler scheduler;

    private ScheduledFuture<?> task;


    public BarcodeHandler(BarcodeRestClient rest, BarcodeCommandDao barcodeCommandDao, TaskScheduler scheduler) {
        this.rest = rest;
        this.barcodeCommandDao = barcodeCommandDao;
        this.scheduler = scheduler;
    }

    @Override
    public Class<BarcodeCommand> getType() {
        return BarcodeCommand.class;
    }

    @Override
    public void handle(BarcodeCommand command) {
        barcodeCommandDao.save(command);
        LOGGER.info(String.format("Persisted %s", command));
        if (task == null || task.isDone()) {
            Long scheduledTime = Instant.now().toEpochMilli() + executionDelay;
            task = scheduler.schedule(this::executeTask, Date.from(Instant.ofEpochMilli(scheduledTime)));
            LOGGER.info("Task scheduled.");
        }
    }

    private void executeTask() {
        Collection<BarcodeCommand> barcodeCommands = barcodeCommandDao.findAll();
        if (rest.sendBarCode(barcodeCommands)) {
            LOGGER.info(String.format(TASK_EXECUTED_SUCCESSFULLY, barcodeCommands.size()));
            barcodeCommandDao.clear();
        } else {
            LOGGER.info(String.format(TASK_EXECUTED_NOT_SUCCESSFULLY));
        }
    }
}