package Command;

// clase q sabe como realizar el trabajo
public class Luz {
    private String ubicacion; // guarda en q lugar está la luz, para diferenciarla de otras luces

    // constructor
    public Luz(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // metodo q prende la luz
    public void encender() {
        System.out.println("-> [Luz de " + ubicacion + "] prendida");
    }

    // metodo q apaga la luz
    public void apagar() {
        System.out.println("-> [Luz de " + ubicacion + "] apagada");
    }
}
