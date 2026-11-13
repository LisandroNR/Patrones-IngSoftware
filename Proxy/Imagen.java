package Proxy;

// contrato donde definimos q los que quieran ser imagenes tienen que usar
// el metodo mostrar
// tanto ImagenReal como ImagenProxy implementan esta interfaz
// el cliente puede usar cualquiera de las 2
public interface Imagen {
    void mostrar();
}
