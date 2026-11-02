package com.solid.srp.good;

/**
 * APLICACIÓN DE SRP:
 * Responsabilidad única: Persistencia de facturas (Base de datos, archivos, etc.).
 */
public class InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("[InvoiceRepository] Guardando factura #" + invoice.getId() + " en la base de datos.");
    }
}
