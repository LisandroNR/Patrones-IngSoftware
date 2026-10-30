package Command;

/**
 * Clase Invoker (Invocador).
 * Es quien pide que se ejecute una acción.
 * Por ejemplo: un control remoto con un botón.
 * Al control remoto no le importa qué hace el comando por dentro; solo sabe llamar a ejecutar().
 */
public class ControlRemoto {
    private Comando comando;

    // Permite cambiar el comando que tiene asignado el botón en cualquier momento
    public void setComando(Comando comando) {
        this.comando = comando;
    }

    // Cuando se aprieta el botón, se dispara la orden
    public void presionarBoton() {
        if (comando != null) {
            System.out.println("[Control Remoto] Botón presionado...");
            comando.ejecutar();
        } else {
            System.out.println("[Control Remoto] Ningún comando asignado.");
        }
    }
}
