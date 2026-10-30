package Command;

/**
 * Clase Receiver (Receptor).
 * Es el dispositivo o componente real que sabe cómo realizar el trabajo.
 * En este caso, la luz sabe prenderse y apagarse.
 */
public class Luz {
    private String ubicacion;

    public Luz(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void encender() {
        System.out.println("-> [Luz de " + ubicacion + "] Encendida (brilla en la habitación).");
    }

    public void apagar() {
        System.out.println("-> [Luz de " + ubicacion + "] Apagada (habitación a oscuras).");
    }
}
