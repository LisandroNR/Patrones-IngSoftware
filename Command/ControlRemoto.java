package Command;

// es el control remoto
// pide q se ejecute una accion
// no le importa q hace el comando, solo lo ejecuta

public class ControlRemoto {
    private Comando comando; // guarda la orden

    // permite cambiar el comando (prendido / apagado)
    public void setComando(Comando comando) {
        this.comando = comando;
    }

    // al apretar el boton, se dispara la orden
    public void presionarBoton() {
        if (comando != null) { // si hay una orden asignada
            System.out.println("[Control Remoto] Botón presionado...");
            comando.ejecutar(); // ejecuta la orden
        } else { // si no hay una orden asignada
            System.out.println("[Control Remoto] No se programó el botón.");
        }
    }
}
