package com.solid.dip.good;

/**
 * APLICACIÓN DE DIP:
 * Abstracción de la que dependerán tanto los módulos de alto nivel
 * como los módulos de bajo nivel.
 */
public interface NotificationChannel {
    void send(String recipient, String message);
}
