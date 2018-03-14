package com.frontwit.barcode.restclient;

import com.frontwit.barcode.restclient.logic.impl.BarCodeListenerService;
import com.frontwit.barcode.restclient.logic.impl.BarCodeRestClient;
import com.frontwit.barcode.restclient.logic.impl.KeyboardListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarCodeBeanConfiguration {

    @Bean
    public BarCodeRestClient barCodeRestClient() {
        return new BarCodeRestClient();
    }

    @Bean
    public KeyboardListener keyListener(BarCodeRestClient barCodeRestClient) {
        return new KeyboardListener(barCodeRestClient);
    }

    @Bean
    public BarCodeListenerService barCodeListenerService(KeyboardListener keyboardListener) {
        return new BarCodeListenerService(keyboardListener);
    }
}
