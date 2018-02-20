package com.frontwit.barcode.restclient.logic.impl;

import com.frontwit.barcode.restclient.logic.api.BarCodeApp;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by PWITIW on 2018-02-16.
 */
public class BarCodeRestClient {

    private BarCodeApp rest;

    @Value("${barcode-app-url}")
    private String barCodeAppUrl;

    @PostConstruct
    private void initialize() {
        rest = Feign.builder()
                .target(BarCodeApp.class, barCodeAppUrl);
    }

    public void sendRequest() {
        rest.sendState();
    }


}
