package Command;

/**
 * Comando Concreto (ConcreteCommand).
 * Encapsula la orden específica de apagar la luz.
 */
public class ComandoApagarLuz implements Comando {
    private Luz luz;

    public ComandoApagarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.apagar();
    }
}
