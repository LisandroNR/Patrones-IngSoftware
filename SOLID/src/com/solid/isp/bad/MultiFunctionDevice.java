package com.solid.isp.bad;

/**
 * VIOLACIÓN DEL PRINCIPIO DE SEGREGACIÓN DE INTERFACES (ISP)
 *
 * Esta interfaz es demasiado "pesada" (fat interface). Obliga a todos los implementadores
 * a tener métodos de impresión, escaneo y fax, incluso si el dispositivo físico no cuenta con ellos.
 */
public interface MultiFunctionDevice {
    void print(String document);
    void scan(String document);
    void fax(String document);
}
