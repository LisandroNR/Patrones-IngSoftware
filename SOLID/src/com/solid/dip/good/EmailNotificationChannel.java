package com.solid.dip.good;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[Email Service] Enviando email a %s -> '%s'%n", recipient, message);
    }
}
