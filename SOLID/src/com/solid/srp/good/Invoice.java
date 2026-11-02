package com.solid.srp.good;

/**
 * APLICACIÓN DE SRP:
 * La clase Invoice ahora tiene una única responsabilidad:
 * representar los datos de la factura y calcular sus totales según las reglas de negocio.
 */
public class Invoice {
    private final String id;
    private final double amount;
    private final double taxRate;

    public Invoice(String id, double amount, double taxRate) {
        this.id = id;
        this.amount = amount;
        this.taxRate = taxRate;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return amount * taxRate;
    }

    public double calculateTotal() {
        return amount + getTaxAmount();
    }
}
