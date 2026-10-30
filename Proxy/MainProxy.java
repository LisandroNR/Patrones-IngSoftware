package Proxy;

// probamos el funcionamiento

public class MainProxy {
    public static void main(String[] args) {
        System.out.println("1: creamos el objeto usando el Proxy");
        // se crea el proxy usando la interfaz imagen
        // todavia no se carga la imagen real
        Imagen miFoto = new ImagenProxy("paisaje_ultra_hd_4k.png");

        System.out.println("\n2: llamamos a mostrar() por primera vez");
        // el proxy detecta q es la primera vez y carga la imagen real
        miFoto.mostrar();

        System.out.println("\n3: llamamos a mostrar() por segunda vez");
        // el proxy se da cuenta de q ya la tiene cargada y la muestra directamente
        miFoto.mostrar();
    }
}
