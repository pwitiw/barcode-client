package com.frontwit.barcode.restclient.logic.impl;

import feign.Response;
import feign.RetryableException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import static org.jnativehook.keyboard.NativeKeyEvent.VC_0;
import static org.jnativehook.keyboard.NativeKeyEvent.VC_1;

public class KeyboardListener implements NativeKeyListener {

    private final StringBuilder input = new StringBuilder();

    private BarCodeRestClient restClient;

    public KeyboardListener(BarCodeRestClient barCodeRestClient) {
        this.restClient = barCodeRestClient;
    }

    public void nativeKeyPressed(NativeKeyEvent event) {
        performAction(event);
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        // do nothing
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        // do nothing
    }

    private void performAction(NativeKeyEvent event) {
        if (isNumber(event.getKeyCode())) {
            input.append(NativeKeyEvent.getKeyText(event.getKeyCode()));
        } else if (event.getKeyCode() == NativeKeyEvent.VC_ENTER) {
            sendAndClearInput();
        } else if (event.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void sendAndClearInput() {

        restClient.sendBarCode(input.toString());

        input.setLength(0);
    }

    private boolean isNumber(int code) {
        return code >= VC_1 && code <= VC_0;
    }
}