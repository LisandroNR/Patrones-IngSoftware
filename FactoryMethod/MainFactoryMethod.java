package FactoryMethod;

// =====================================================================
//  PATRÓN FACTORY METHOD  –  Ejemplo: Sistema de Notificaciones
// =====================================================================
//
//  Estructura (según refactoring.guru):
//
//   Producto (interfaz)         →  Notificacion
//   Productos Concretos         →  NotificacionEmail, NotificacionSMS, NotificacionPush
//   Creador (clase abstracta)   →  CreadorNotificacion   (contiene el factoryMethod)
//   Creadores Concretos         →  CreadorEmail, CreadorSMS, CreadorPush
//
//  El cliente trabaja con el Creador sin saber qué producto concreto
//  se instancia; esa decisión queda delegada a las subclases.
// =====================================================================

// 1. Producto: Interfaz común que deben cumplir todos los tipos de notificación
interface Notificacion {
    void enviar(String mensaje);
}

// 2. Productos Concretos: Cada uno implementa la interfaz con su lógica particular

class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("  [EMAIL]  Enviando correo electrónico: " + mensaje);
    }
}

class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("  [SMS]    Enviando mensaje de texto: " + mensaje);
    }
}

class NotificacionPush implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("  [PUSH]   Enviando notificación push: " + mensaje);
    }
}

// 3. Creador: Clase abstracta que declara el Factory Method
//    También define la lógica de negocio que UTILIZA el producto,
//    sin conocer la clase concreta que se instanciará.

abstract class CreadorNotificacion {

    // Factory Method: las subclases deciden qué Notificación crear
    public abstract Notificacion crearNotificacion();

    // Lógica de negocio que trabaja con el producto creado por el factory method
    public void notificar(String mensaje) {
        // Se llama al factory method para obtener el producto
        Notificacion notificacion = crearNotificacion();
        // Se usa el producto sin saber su tipo concreto
        notificacion.enviar(mensaje);
    }
}

// 4. Creadores Concretos: Cada uno sobreescribe el factory method
//    para devolver un tipo distinto de Notificación

class CreadorEmail extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}

class CreadorSMS extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionSMS();
    }
}

class CreadorPush extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionPush();
    }
}

// 5. Cliente: Usa los creadores sin acoplarse a los productos concretos

public class MainFactoryMethod {
    public static void main(String[] args) {

        System.out.println("=== PATRÓN FACTORY METHOD ===\n");

        // El cliente recibe un creador, sin importarle cuál es la subclase concreta
        CreadorNotificacion creador;

        // --- Notificación por Email ---
        System.out.println("--- Usando CreadorEmail ---");
        creador = new CreadorEmail();
        creador.notificar("Bienvenido a la plataforma!");

        // --- Notificación por SMS ---
        System.out.println("\n--- Usando CreadorSMS ---");
        creador = new CreadorSMS();
        creador.notificar("Tu código de verificación es: 4821");

        // --- Notificación Push ---
        System.out.println("\n--- Usando CreadorPush ---");
        creador = new CreadorPush();
        creador.notificar("Tenés 3 mensajes nuevos");

        System.out.println("\n================================");
        System.out.println("El cliente usó distintos creadores sin conocer");
        System.out.println("las clases concretas de Notificación. Esa decisión");
        System.out.println("queda encapsulada en cada CreadorConcreto.");
    }
}
