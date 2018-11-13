package com.frontwit.barcode.restclient.barcode.impl;

public interface CommandHandler<T extends Command> {

    Class<T> getType();

    void handle(T command);
}
