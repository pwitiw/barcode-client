package com.frontwit.barcode.restclient.logic.impl;

import lc.kra.system.keyboard.GlobalKeyboardHook;

import java.util.Map.Entry;

import javax.annotation.PostConstruct;

public class BarCodeListenerService {

    private static boolean run = true;

    private GlobalKeyboardHook globalKeyboardHook;

    private BarCodeRestClient barCodeRestClient;

    public BarCodeListenerService(GlobalKeyboardHook globalKeyboardHook, BarCodeRestClient barCodeRestClient) {
        this.globalKeyboardHook = globalKeyboardHook;
        this.barCodeRestClient = barCodeRestClient;
    }

    @PostConstruct
    public void listen() {
        KeyboardListener keyboardListener = new KeyboardListener();
        // might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        globalKeyboardHook = new GlobalKeyboardHook(false); // use false here to switch to hook instead of raw input
        for (Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
        }
        globalKeyboardHook.addKeyListener(keyboardListener);

        try {
            while (run) Thread.sleep(128);
        } catch (InterruptedException e) { /* nothing to do here */ } finally {
            globalKeyboardHook.shutdownHook();
        }
    }

}
