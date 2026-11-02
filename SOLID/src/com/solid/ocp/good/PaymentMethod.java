package com.solid.ocp.good;

/**
 * APLICACIÓN DE OCP:
 * Abstracción que define el contrato común para cualquier método de pago.
 */
public interface PaymentMethod {
    void pay(double amount);
    String getName();
}
