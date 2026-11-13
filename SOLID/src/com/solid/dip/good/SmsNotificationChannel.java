package com.solid.dip.good;

public class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[SMS Gateway] Enviando mensaje de texto al teléfono %s -> '%s'%n", recipient, message);
    }
}
