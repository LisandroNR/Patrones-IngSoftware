package com.solid.ocp.good;

public class PayPalPayment implements PaymentMethod {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("[PayPal: %s] Procesando cobro de $%.2f vía API de PayPal.%n", email, amount);
    }

    @Override
    public String getName() {
        return "PayPal";
    }
}
