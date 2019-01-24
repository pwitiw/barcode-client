package com.frontwit.barcode.restclient.barcode;

public interface CommandHandler<T extends Command> {

    Class<T> getType();

    void handle(T command);
}
