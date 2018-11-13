package com.frontwit.barcode.restclient;

import com.frontwit.barcode.restclient.barcode.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class BarCodeBeanConfiguration {

    @Bean
    public BarCodeRestClient barCodeRestClient() {
        return new BarCodeRestClient();
    }

    @Bean
    public CommandGateway commandGateway() {
        CommandGateway commandGateway = new CommandGateway();
        commandGateway.register(barcodeHandler());
        return new CommandGateway();

    }

    @Bean
    public BarcodeHandler barcodeHandler() {
        return new BarcodeHandler();
    }

    @Bean
    public KeyboardListener keyListener(CommandGateway commandGateway) {
        return new KeyboardListener(commandGateway);
    }

    @Bean
    public BarCodeListenerService barCodeListenerService(KeyboardListener keyboardListener) {
        return new BarCodeListenerService(keyboardListener);
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
