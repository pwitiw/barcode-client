package com.frontwit.barcode.restclient.barcode.storage;

import com.frontwit.barcode.restclient.barcode.BarcodeCommand;

import java.util.Collection;

// TODO komentarze
public interface BarcodeStorage {

    void save(BarcodeCommand barcodeCommand);

    Collection<BarcodeCommand> findAll();

    void delete(Collection<BarcodeCommand> barcodes);
}