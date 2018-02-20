package com.frontwit.barcode.restclient;

import com.frontwit.barcode.restclient.logic.impl.BarCodeListenerService;
import com.frontwit.barcode.restclient.logic.impl.BarCodeRestClient;
import lc.kra.system.keyboard.GlobalKeyboardHook;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarCodeBeanConfiguration {


    @Bean
    public BarCodeRestClient barCodeRestClient() {
        return new BarCodeRestClient();
    }

    @Bean
    public BarCodeListenerService barCodeListenerService(BarCodeRestClient restClient) {
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
        return new BarCodeListenerService(keyboardHook, restClient);
    }
}
