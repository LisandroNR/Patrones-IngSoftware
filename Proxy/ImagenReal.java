package Proxy;

/**
 * Objeto Real (RealSubject).
 * Esta es la clase que hace el trabajo pesado y costoso.
 * Imaginate que carga una foto gigante en 4K desde el disco duro o internet.
 * Tarda tiempo y gasta mucha memoria RAM.
 */
public class ImagenReal implements Imagen {
    private String nombreArchivo;

    // Al construir el objeto real, se simula que tarda en cargar
    public ImagenReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargarDesdeDisco();
    }

    // Método privado que simula la operación pesada
    private void cargarDesdeDisco() {
        System.out.println("-> [ImagenReal] Cargando archivo pesado del disco: '" + nombreArchivo + "'... (tarda tiempo y gasta memoria)");
    }

    // Muestra la imagen en pantalla
    @Override
    public void mostrar() {
        System.out.println("-> [ImagenReal] Mostrando la foto en pantalla: " + nombreArchivo);
    }
}
