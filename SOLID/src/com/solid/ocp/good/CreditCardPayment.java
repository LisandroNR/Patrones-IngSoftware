package com.solid.ocp.good;

public class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        String masked = "****-****-****-" + cardNumber.substring(Math.max(0, cardNumber.length() - 4));
        System.out.printf("[Tarjeta de Crédito %s] Procesando cobro de $%.2f vía pasarela bancaria.%n", masked, amount);
    }

    @Override
    public String getName() {
        return "Tarjeta de Crédito";
    }
}
