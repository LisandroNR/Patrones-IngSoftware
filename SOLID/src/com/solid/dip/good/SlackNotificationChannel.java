package com.solid.dip.good;

public class SlackNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[Slack Webhook] Publicando en canal %s -> '%s'%n", recipient, message);
    }
}
