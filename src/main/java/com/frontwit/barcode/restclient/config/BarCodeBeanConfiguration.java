package com.frontwit.barcode.restclient.config;

import com.frontwit.barcode.restclient.barcode.*;
import com.frontwit.barcode.restclient.barcode.KeyboardListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class BarCodeBeanConfiguration {

    @Bean
    public BarcodeRestClient barCodeRestClient() {
        return new BarcodeRestClient();
    }

    @Bean
    public CommandGateway commandGateway(BarcodeHandler barcodeHandler) {
        CommandGateway commandGateway = new CommandGateway();
        commandGateway.register(barcodeHandler);
        return commandGateway;
    }

    @Bean
    public BarcodeHandler barcodeHandler(BarcodeRestClient barcodeRestClient, BarcodeCommandDao barcodeCommandDao,
                                         TaskScheduler taskScheduler) {
        return new BarcodeHandler(barcodeRestClient, barcodeCommandDao, taskScheduler);
    }

    @Bean
    public KeyboardListener keyListener(CommandGateway commandGateway) {
        return new KeyboardListener(commandGateway);
    }

    @Bean
    public BarcodeReaderService barCodeListenerService(KeyboardListener keyboardListener) {
        return new BarcodeReaderService(keyboardListener);
    }

    @Bean
    public TaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setThreadNamePrefix("Scheduler");
        return threadPoolTaskScheduler;
    }

    @Bean
    public BarcodeCommandDao barcodeCommandDao() {
        return new InMemoryBarcodeCommandDao();
    }
}
