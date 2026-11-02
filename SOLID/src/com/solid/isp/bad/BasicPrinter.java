package com.solid.isp.bad;

public class BasicPrinter implements MultiFunctionDevice {
    @Override
    public void print(String document) {
        System.out.println("Imprimiendo documento: " + document);
    }

    @Override
    public void scan(String document) {
        // VIOLACIÓN ISP: Esta impresora económica no tiene escáner,
        // pero la interfaz la obliga a implementarlo.
        throw new UnsupportedOperationException("Esta impresora no tiene hardware de escaneo.");
    }

    @Override
    public void fax(String document) {
        // VIOLACIÓN ISP: Tampoco tiene módulo de fax.
        throw new UnsupportedOperationException("Esta impresora no soporta fax.");
    }
}
