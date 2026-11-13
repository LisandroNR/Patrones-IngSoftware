package Command;

// la orden especifica de apagar la luz
// guarda la referencia al objeto luz
// en ejecutar() llama al metodo apagar de la luz

public class ComandoApagarLuz implements Comando {
    private Luz luz; // referencia a la luz

    // constructor
    public ComandoApagarLuz(Luz luz) {
        this.luz = luz;
    }

    // ejecuta la orden de apagar la luz
    @Override
    public void ejecutar() {
        luz.apagar();
    }
}
