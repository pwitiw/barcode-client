package com.frontwit.barcode.restclient.barcode;

import java.time.LocalTime;
import java.util.Objects;

public class BarcodeCommand implements Command {

    private final Integer readerId;
    private final Long barcode;
    private final LocalTime date;

    public BarcodeCommand(Integer readerId, Long barcode) {
        this.readerId = readerId;
        this.barcode = barcode;
        this.date = LocalTime.now();
    }

    public Integer getReaderId() {
        return readerId;
    }

    public Long getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "BarcodeCommand: reader=" + readerId + ", barcode=" + barcode + ", timestamp= " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarcodeCommand that = (BarcodeCommand) o;
        return Objects.equals(readerId, that.readerId) &&
                Objects.equals(barcode, that.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, barcode);
    }
}
