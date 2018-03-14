package com.frontwit.barcode.restclient.logic.impl;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.annotation.PostConstruct;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.frontwit.barcode.restclient.common.Messages.REGISTERING_HOOK_ERROR;

public class BarCodeListenerService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private KeyboardListener keyboardListener;

    public BarCodeListenerService(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }

    @PostConstruct
    public void listen() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            logger.warning(REGISTERING_HOOK_ERROR + ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(keyboardListener);
        Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.WARNING);
    }

}