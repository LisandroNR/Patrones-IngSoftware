package com.solid.isp.good;

/**
 * APLICACIÓN DE ISP:
 * Solo implementa la interfaz que realmente le compete.
 * No se ve obligada a declarar métodos inútiles ni a lanzar excepciones.
 */
public class BasicPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("[BasicPrinter] Imprimiendo documento: " + document);
    }
}
