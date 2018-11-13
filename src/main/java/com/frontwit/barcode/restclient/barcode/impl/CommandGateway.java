package com.frontwit.barcode.restclient.barcode.impl;

import java.util.HashMap;
import java.util.Map;

public class CommandGateway {

    private static final Map<Class<? extends Command>, CommandHandler> handlers = new HashMap<>();

    public CommandHandler register(CommandHandler commandHandler) {
        if (handlers.containsKey(commandHandler.getType())) {
            return handlers.get(commandHandler.getType());
        }
        return handlers.put(commandHandler.getType(), commandHandler);
    }

    public CommandHandler unregister(CommandHandler commandHandler) {
        return handlers.remove(commandHandler.getType());
    }

    public void fire(Command command) {
        CommandHandler handler = handlers.get(command.getClass());
        if (handler == null) {
            throw new CommandHandlerNotFoundException(command.getClass());
        }
        handler.handle(command);
    }

}
