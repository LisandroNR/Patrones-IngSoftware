package com.solid.dip.bad;

/**
 * Módulo de bajo nivel (detalle de implementación de infraestructura).
 */
public class SmtpEmailSender {
    public void sendEmail(String toAddress, String body) {
        System.out.println("[SMTP Server] Enviando correo electrónico a " + toAddress + ": " + body);
    }
}
