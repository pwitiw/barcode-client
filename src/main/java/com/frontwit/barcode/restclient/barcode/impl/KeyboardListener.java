package com.frontwit.barcode.restclient.barcode.impl;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Logger;

import static org.jnativehook.keyboard.NativeKeyEvent.VC_0;
import static org.jnativehook.keyboard.NativeKeyEvent.VC_1;

// TODO rozważyć na co nasłuchiwać (chyba na released) - przetestować pressed  vs released
public class KeyboardListener implements NativeKeyListener {

    private static final Logger LOGGER = Logger.getLogger(KeyboardListener.class.getName());

    private final StringBuilder input = new StringBuilder();

    private CommandGateway commandGateway;

    public KeyboardListener(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void nativeKeyPressed(NativeKeyEvent event) {
        if (isNumber(event)) {
            input.append(NativeKeyEvent.getKeyText(event.getKeyCode()));
        } else if (isEnter(event)) {
            commandGateway.fire(new BarcodeCommand(0, Long.valueOf(input.toString())));
            input.setLength(0);
        } else if (isExit(event)) {
            unregister();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        // do nothing
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        // do nothing
    }

    private boolean isNumber(NativeKeyEvent event) {
        return event.getKeyCode() >= VC_1 && event.getKeyCode() <= VC_0;
    }

    private boolean isEnter(NativeKeyEvent event) {
        return event.getKeyCode() == NativeKeyEvent.VC_ENTER;
    }

    private boolean isExit(NativeKeyEvent event) {
        return event.getKeyCode() == NativeKeyEvent.VC_ESCAPE;
    }

    private void unregister() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e1) {
            LOGGER.warning(e1.getMessage());
        }
    }

}