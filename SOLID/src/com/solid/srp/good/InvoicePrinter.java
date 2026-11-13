package com.solid.srp.good;

/**
 * APLICACIÓN DE SRP:
 * Responsabilidad única: Formato y visualización/impresión de la factura.
 */
public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("================================");
        System.out.println("         FACTURA #" + invoice.getId());
        System.out.println("================================");
        System.out.printf("Subtotal:  $%.2f%n", invoice.getAmount());
        System.out.printf("Impuestos: $%.2f%n", invoice.getTaxAmount());
        System.out.printf("Total:     $%.2f%n", invoice.calculateTotal());
        System.out.println("================================");
    }
}
