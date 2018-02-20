package com.frontwit.barcode.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BarCodeRestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarCodeRestClientApplication.class, args);
    }
}
