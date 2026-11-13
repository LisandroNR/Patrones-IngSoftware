package com.solid.ocp;

import com.solid.ocp.good.*;

public class OcpDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n>>> [2] OCP - Open/Closed Principle <<<");

        PaymentProcessor processor = new PaymentProcessor();

        // Podemos usar cualquier medio de pago sin alterar el procesador
        PaymentMethod tarjeta = new CreditCardPayment("4532111122223333");
        PaymentMethod paypal = new PayPalPayment("usuario@example.com");
        PaymentMethod cripto = new CryptoPayment("0x71C...B29");

        processor.checkout(tarjeta, 250.0);
        processor.checkout(paypal, 89.99);
        processor.checkout(cripto, 1200.0);
    }
}
