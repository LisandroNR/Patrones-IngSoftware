package Command;

// la orden especifica de prender la luz
// guarda la referencia al objeto luz
// en ejecutar() llama al metodo prender de la luz

public class ComandoEncenderLuz implements Comando {
    private Luz luz; // referencia a la luz

    // constructor
    public ComandoEncenderLuz(Luz luz) {
        this.luz = luz;
    }

    // ejecuta la orden de prender la luz
    @Override
    public void ejecutar() {
        luz.encender(); // llama al metodo prender de la luz
    }
}
