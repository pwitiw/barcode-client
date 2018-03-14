package com.frontwit.barcode.restclient.logic.api;

import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by PWITIW on 2018-02-16.
 */
@FeignClient("barCodeAppClient")
public interface BarCodeApp {

    @RequestLine("POST /barcode/{input}")
    void sendState(@Param("input") String input);
}
