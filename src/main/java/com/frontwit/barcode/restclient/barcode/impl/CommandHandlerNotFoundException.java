package com.frontwit.barcode.restclient.barcode.impl;

public class CommandHandlerNotFoundException extends RuntimeException {

    public CommandHandlerNotFoundException(Class<? extends Command> aClass) {
        super(String.format("Handler for class %s not found.", aClass));
    }
}
