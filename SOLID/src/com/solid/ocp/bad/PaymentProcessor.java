package com.solid.ocp.bad;

/**
 * VIOLACIÓN DEL PRINCIPIO DE ABIERTO/CERRADO (OCP)
 *
 * Cada vez que la empresa desea soportar un nuevo medio de pago
 * (ej: MercadoPago, ApplePay, Cripto), esta clase debe ser modificada.
 * Esto viola OCP porque la clase NO está cerrada a la modificación.
 */
public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if ("CREDIT_CARD".equalsIgnoreCase(paymentType)) {
            System.out.println("Procesando pago de $" + amount + " con Tarjeta de Crédito vía pasarela bancaria.");
        } else if ("PAYPAL".equalsIgnoreCase(paymentType)) {
            System.out.println("Procesando pago de $" + amount + " redirigiendo al portal seguro de PayPal.");
        } else if ("CRYPTO".equalsIgnoreCase(paymentType)) {
            System.out.println("Procesando pago de $" + amount + " esperando confirmaciones en la blockchain.");
        } else {
            throw new IllegalArgumentException("Método de pago no soportado: " + paymentType);
        }
    }
}
