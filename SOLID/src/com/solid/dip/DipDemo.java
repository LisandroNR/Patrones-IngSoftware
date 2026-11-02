package com.solid.dip;

import com.solid.dip.good.*;

public class DipDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n>>> [5] DIP - Dependency Inversion Principle <<<");

        // Creamos las implementaciones de bajo nivel (detalles)
        NotificationChannel emailChannel = new EmailNotificationChannel();
        NotificationChannel smsChannel = new SmsNotificationChannel();
        NotificationChannel slackChannel = new SlackNotificationChannel();

        // Inyectamos cualquier canal en el módulo de alto nivel sin tocar una sola línea de OrderService
        OrderService orderServiceConEmail = new OrderService(emailChannel);
        orderServiceConEmail.completeOrder("ORD-101", "juan.perez@empresa.com");

        System.out.println();

        OrderService orderServiceConSms = new OrderService(smsChannel);
        orderServiceConSms.completeOrder("ORD-102", "+5491122334455");

        System.out.println();

        OrderService orderServiceConSlack = new OrderService(slackChannel);
        orderServiceConSlack.completeOrder("ORD-103", "#notificaciones-ventas");
    }
}
