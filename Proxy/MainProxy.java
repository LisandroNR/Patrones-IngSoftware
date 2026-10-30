package Proxy;

/**
 * Clase Main (Cliente).
 * Prueba el funcionamiento del patrón Proxy.
 */
public class MainProxy {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("PASO 1: Creamos el objeto usando el Proxy");
        System.out.println("==================================================");
        // Fíjate que usamos el tipo de la interfaz (Imagen)
        // El programa cliente no sabe ni le importa si es el proxy o el objeto real
        Imagen miFoto = new ImagenProxy("paisaje_ultra_hd_4k.png");

        System.out.println("\n--------------------------------------------------");
        System.out.println("PASO 2: Llamamos a mostrar() por primera vez");
        System.out.println("--------------------------------------------------");
        // Acá el proxy detecta que es la primera vez y carga la foto real
        miFoto.mostrar();

        System.out.println("\n--------------------------------------------------");
        System.out.println("PASO 3: Llamamos a mostrar() por segunda vez");
        System.out.println("--------------------------------------------------");
        // Acá el proxy se da cuenta de que ya la tiene cargada y no pierde tiempo
        miFoto.mostrar();

        System.out.println("\n==================================================");
        System.out.println("FIN DE LA DEMOSTRACIÓN");
        System.out.println("==================================================");
    }
}
