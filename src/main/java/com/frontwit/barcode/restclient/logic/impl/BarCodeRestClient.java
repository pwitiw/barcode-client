package com.frontwit.barcode.restclient.logic.impl;

import com.frontwit.barcode.restclient.logic.api.BarCodeApp;
import feign.Feign;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

import static com.frontwit.barcode.restclient.common.Messages.SERVER_UNREACHABLE;

/**
 * Created by PWITIW on 2018-02-16.
 */
public class BarCodeRestClient {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private BarCodeApp rest;

    @Value("${barcode-app-url}")
    private String barCodeAppUrl;

    @PostConstruct
    private void initialize() {
        rest = Feign.builder()
                .target(BarCodeApp.class, barCodeAppUrl);
    }

    public void sendBarCode(String barCode) {
        try {
            rest.sendState(barCode);
        } catch (RetryableException e) {
            //TODO add to QUEUE
            logger.warning(SERVER_UNREACHABLE);
        }
    }
}
