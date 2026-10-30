package Command;

/**
 * Interfaz Command (Comando).
 * Define el contrato estándar para todas las órdenes.
 * Todos los comandos tienen que tener un método ejecutar().
 */
public interface Comando {
    void ejecutar();
}
