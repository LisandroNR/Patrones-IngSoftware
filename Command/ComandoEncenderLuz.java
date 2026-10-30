package Command;

/**
 * Comando Concreto (ConcreteCommand).
 * Encapsula la orden específica de encender la luz.
 * Guarda una referencia al objeto receptor (la luz) y en ejecutar() llama al método correspondiente.
 */
public class ComandoEncenderLuz implements Comando {
    private Luz luz;

    public ComandoEncenderLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.encender();
    }
}
