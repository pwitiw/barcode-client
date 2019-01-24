package com.frontwit.barcode.restclient.barcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// todo komentarz
public class InMemoryBarcodeCommandDao implements BarcodeCommandDao {

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
    public void clear() {
        commands.clear();
    }
}
