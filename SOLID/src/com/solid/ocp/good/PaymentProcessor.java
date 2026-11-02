package com.solid.ocp.good;

/**
 * APLICACIÓN DE OCP:
 * Esta clase está CERRADA a la modificación (no necesitamos tocarla para añadir
 * un nuevo método de pago), pero está ABIERTA a la extensión (podemos pasarle
 * cualquier clase que implemente PaymentMethod).
 */
public class PaymentProcessor {
    public void checkout(PaymentMethod paymentMethod, double amount) {
        System.out.println("Iniciando checkout con método: " + paymentMethod.getName());
        paymentMethod.pay(amount);
        System.out.println("Checkout finalizado con éxito.\n");
    }
}
