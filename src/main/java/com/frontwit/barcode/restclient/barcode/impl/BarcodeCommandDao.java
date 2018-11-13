package com.frontwit.barcode.restclient.barcode.impl;

import java.util.Collection;

// TODO komentarze
public interface BarcodeCommandDao {

    void save(BarcodeCommand barcodeCommand);

    Collection<BarcodeCommand> findAll();

    void clear();

}