package Command;

/**
 * Clase Client (Main).
 * Es quien arma la escena: crea el receptor (la luz), crea los comandos
 * y se los pasa al invocador (el control remoto).
 */
public class MainCommand {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("DEMOSTRACIÓN DEL PATRÓN COMMAND");
        System.out.println("==================================================");

        // 1. Creamos el objeto Receptor (el que realmente sabe hacer las cosas)
        Luz luzLiving = new Luz("Living");

        // 2. Creamos los Comandos envolviendo las acciones de la luz
        Comando ordenEncender = new ComandoEncenderLuz(luzLiving);
        Comando ordenApagar = new ComandoApagarLuz(luzLiving);

        // 3. Creamos el Invocador (el control remoto)
        ControlRemoto control = new ControlRemoto();

        // 4. Le cargamos la orden de encender y apretamos el botón
        System.out.println("\n--- Programamos el botón para ENCENDER ---");
        control.setComando(ordenEncender);
        control.presionarBoton();

        // 5. Cambiamos la orden del botón para APAGAR y volvemos a apretar
        System.out.println("\n--- Reprogramamos el botón para APAGAR ---");
        control.setComando(ordenApagar);
        control.presionarBoton();

        System.out.println("\n==================================================");
        System.out.println("FIN DE LA DEMOSTRACIÓN");
        System.out.println("==================================================");
    }
}
