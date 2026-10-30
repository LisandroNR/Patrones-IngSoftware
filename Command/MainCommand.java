package Command;

// probamos el patron

public class MainCommand {
    public static void main(String[] args) {

        // creamos el receptor (luz)
        Luz luzLiving = new Luz("Living");

        // creamos los comandos (encender/apagar)
        Comando ordenEncender = new ComandoEncenderLuz(luzLiving);
        Comando ordenApagar = new ComandoApagarLuz(luzLiving);

        // creamos el invocador (control remoto)
        ControlRemoto control = new ControlRemoto();

        // programamos el boton para encender y apretamos
        System.out.println("\n--- Programamos el botón para ENCENDER ---");
        control.setComando(ordenEncender);
        control.presionarBoton();

        // cambiamos la orden para apagar
        System.out.println("\n--- Reprogramamos el botón para APAGAR ---");
        control.setComando(ordenApagar);
        control.presionarBoton();
    }
}
