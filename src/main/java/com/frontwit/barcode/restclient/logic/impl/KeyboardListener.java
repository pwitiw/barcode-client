package com.frontwit.barcode.restclient.logic.impl;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

/**
 * Created by PWITIW on 2018-02-16.
 */
public class KeyboardListener extends GlobalKeyAdapter {

    StringBuilder barcode = new StringBuilder();

    @Override
    public void keyPressed(GlobalKeyEvent event) {
        barcode.append(event.getKeyChar());
        if (barcode.toString().toCharArray()[0] == event.getKeyChar()) {
//            System.out.println(barcode.toString());
        }
        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    @Override
    public void keyReleased(GlobalKeyEvent event) {
    }
}
