package com.frontwit.barcode.restclient.barcode.storage;

import com.frontwit.barcode.restclient.barcode.BarcodeCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// todo komentarz
public class InMemoryBarcodeStorage implements BarcodeStorage {

    private Set<BarcodeCommand> commands = new HashSet<>();

    @Override
    public void save(BarcodeCommand barcodeCommand) {
        commands.add(barcodeCommand);
    }

    @Override
    public Collection<BarcodeCommand> findAll() {
        return new ArrayList<>(commands);
    }

    @Override
    public void delete(Collection<BarcodeCommand> barcodes) {
        commands.removeIf(barcodes::contains);
    }
}
