package com.solid.srp.bad;

/**
 * VIOLACIÓN DEL PRINCIPIO DE RESPONSABILIDAD ÚNICA (SRP)
 *
 * Esta clase Invoice tiene múltiples razones para cambiar:
 * 1. Cambios en la lógica de cálculo de importes e impuestos (regla de negocio).
 * 2. Cambios en el formato o la forma de imprimir/mostrar la factura (presentación).
 * 3. Cambios en cómo y dónde se guarda la factura (persistencia / base de datos).
 */
public class Invoice {
    private String id;
    private double amount;
    private double taxRate;

    public Invoice(String id, double amount, double taxRate) {
        this.id = id;
        this.amount = amount;
        this.taxRate = taxRate;
    }

    // Razón 1: Lógica de cálculo
    public double calculateTotal() {
        return amount + (amount * taxRate);
    }

    // Razón 2: Presentación / Impresión
    public void printInvoice() {
        System.out.println("--- FACTURA #" + id + " ---");
        System.out.println("Subtotal: $" + amount);
        System.out.println("Impuestos: $" + (amount * taxRate));
        System.out.println("Total: $" + calculateTotal());
    }

    // Razón 3: Persistencia en base de datos
    public void saveToDatabase() {
        System.out.println("Guardando la factura #" + id + " en la base de datos MySQL...");
    }
}
