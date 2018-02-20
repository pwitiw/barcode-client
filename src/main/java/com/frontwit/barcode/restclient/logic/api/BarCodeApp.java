package com.frontwit.barcode.restclient.logic.api;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by PWITIW on 2018-02-16.
 */
@FeignClient("barCodeAppClient")
public interface BarCodeApp {

    @RequestLine("POST /account/{id}")
    void sendState();

}
