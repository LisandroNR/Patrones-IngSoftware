package Proxy;

/**
 * Clase Proxy (Intermediario).
 * Se hace pasar por la ImagenReal (porque implementa la interfaz Imagen).
 * 
 * ¿Cuál es su gracia?
 * Controla el acceso al objeto real:
 * 1. Carga perezosa (Lazy loading): No crea la foto pesada al inicio, 
 *    espera hasta que alguien realmente pida verla con mostrar().
 * 2. Memoria / Caché: Guarda la imagen en una variable para no tener que
 *    volver a leer del disco si nos piden verla de nuevo.
 */
public class ImagenProxy implements Imagen {
    private String nombreArchivo;
    
    // Esta variable guarda la referencia al objeto pesado real.
    // Al principio está en 'null' (vacía), no gastamos memoria en nada.
    private ImagenReal imagenReal;

    public ImagenProxy(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        System.out.println("[Proxy] Objeto proxy creado para '" + nombreArchivo + "'. (Todavía NO se cargó nada pesado).");
    }

    @Override
    public void mostrar() {
        // ¿Es la primera vez que piden mostrarla?
        if (imagenReal == null) {
            System.out.println("[Proxy] Es la primera vez que se pide mostrar. Creando y cargando ImagenReal...");
            imagenReal = new ImagenReal(nombreArchivo);
        } else {
            System.out.println("[Proxy] La imagen ya estaba cargada. Usamos la que ya tenemos en memoria (Caché).");
        }

        // Le pasamos la pelota al objeto real para que la muestre
        imagenReal.mostrar();
    }
}
