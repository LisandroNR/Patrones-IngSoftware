package Proxy;

// intermediario, se hace pasar por ImagenReal
// no se crea el archivo pesado al inicio, espera a que alguien lo pida
// guarda la imagen en una variable para no tener que volver a cargarla

public class ImagenProxy implements Imagen { // implementa el metodo de la interfaz
    private String nombreArchivo; // guarda texto con el nombre de la foto
    private ImagenReal imagenReal;// variable q guarda la referencia al objeto pesado, empieza vacia

    // constructor, recibe el nombre del archivo
    public ImagenProxy(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        System.out.println("[Proxy] Objeto proxy creado para '" + nombreArchivo + "'. (Todavía NO se cargó nada pesado).");
    }

    @Override
    public void mostrar() { // metodo mostrar
        // si no hay imagen real
        if (imagenReal == null) {
            System.out.println("[Proxy] Es la primera vez que se pide mostrar. Creando y cargando ImagenReal...");
            imagenReal = new ImagenReal(nombreArchivo); // crea la imagen real y la guarda en la variable
        } else { // si ya había
            System.out.println("[Proxy] La imagen ya estaba cargada. Usamos la que ya tenemos en memoria (Caché).");
        }

        // Le pasamos la pelota al objeto real para que la muestre
        imagenReal.mostrar();
    }
}
