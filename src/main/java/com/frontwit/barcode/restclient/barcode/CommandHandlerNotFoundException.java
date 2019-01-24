package com.frontwit.barcode.restclient.barcode;

import com.frontwit.barcode.restclient.barcode.Command;

public class CommandHandlerNotFoundException extends RuntimeException {

    public CommandHandlerNotFoundException(Class<? extends Command> aClass) {
        super(String.format("Handler for class %s not found.", aClass));
    }
}
