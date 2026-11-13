package com.solid.dip.bad;

/**
 * VIOLACIÓN DEL PRINCIPIO DE INVERSIÓN DE DEPENDENCIAS (DIP)
 *
 * Módulo de alto nivel (reglas de negocio para procesar órdenes) depende
 * DIRECTAMENTE de una clase concreta de bajo nivel (SmtpEmailSender).
 *
 * Problemas:
 * - Acoplamiento rígido: si queremos enviar WhatsApp o SMS, hay que reescribir esta clase.
 * - Difícil de testear: no se puede simular (mockear) el envío de correos en tests unitarios.
 */
public class OrderService {
    private final SmtpEmailSender emailSender;

    public OrderService() {
        // Creación interna de la dependencia acoplada
        this.emailSender = new SmtpEmailSender();
    }

    public void completeOrder(String orderId, String clientEmail) {
        System.out.println("Procesando pedido #" + orderId + "...");
        // Dependencia directa de método específico de bajo nivel
        emailSender.sendEmail(clientEmail, "Tu orden #" + orderId + " está lista.");
    }
}
