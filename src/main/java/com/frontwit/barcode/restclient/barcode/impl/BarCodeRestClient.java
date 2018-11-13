package com.frontwit.barcode.restclient.barcode.impl;

import com.frontwit.barcode.restclient.barcode.api.BarCodeApp;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * Created by PWITIW on 2018-02-16.
 */
public class BarCodeRestClient {

    private BarCodeApp rest;

    @Value("${barcode-app.url}")
    private String barCodeAppUrl;

    @PostConstruct
    private void initialize() {
        rest = Feign.builder()
                .target(BarCodeApp.class, barCodeAppUrl);
    }

    public boolean sendBarCode(Collection<BarcodeCommand> barcodeCommands) {
        // FIXME here
//        try {
//            rest.sendState(barcodeCommands);
//        } catch (RetryableException e) {
//            logger.warning(SERVER_UNREACHABLE);
//            return false;
//        }
        return true;
    }
}
