package Proxy;

/**
 * Interfaz común para el objeto real y para el proxy.
 * Define qué cosas se pueden hacer con una imagen.
 * Como el Proxy y el objeto Real implementan esta misma interfaz,
 * a quien los use le da exactamente igual cuál de los dos está usando.
 */
public interface Imagen {
    void mostrar();
}
