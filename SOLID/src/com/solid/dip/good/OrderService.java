package com.solid.dip.good;

/**
 * APLICACIÓN DE DIP:
 * Módulo de alto nivel.
 * No depende de implementaciones concretas como Email o SMS,
 * sino de la abstracción NotificationChannel.
 *
 * La dependencia se inyecta por constructor (Inversión de Control / DI).
 */
public class OrderService {
    private final NotificationChannel notificationChannel;

    public OrderService(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public void completeOrder(String orderId, String recipient) {
        System.out.println("Procesando pedido #" + orderId + "...");
        notificationChannel.send(recipient, "Tu orden #" + orderId + " ha sido confirmada con éxito.");
    }
}
