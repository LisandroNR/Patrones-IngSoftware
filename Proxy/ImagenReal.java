package Proxy;

// clase que hace el trabajo de verdad
public class ImagenReal implements Imagen { // implementa el metodo de la interfaz
    private String nombreArchivo;

    // constructor, se ejecuta en cuanto se crea el objeto
    public ImagenReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo; // guarda el nombre del archivo
        cargarDesdeDisco(); // se simula una carga pesada
    }

    // se simula una carga pesada
    private void cargarDesdeDisco() {
        System.out.println("-> [ImagenReal] Cargando archivo pesado del disco: '" + nombreArchivo + "'... (tarda tiempo y gasta memoria)");
    }

    // muestra la imagen en pantalla
    @Override
    public void mostrar() {
        System.out.println("-> [ImagenReal] Mostrando la foto en pantalla: " + nombreArchivo);
    }
}
