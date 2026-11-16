package Interpreter;

import java.util.HashMap;
import java.util.Map;

// Context
// guarda la informacion global q necesitan las expresiones al interpretarse
// en este caso, el valor de cada variable
public class Contexto {
    private Map<String, Integer> variables = new HashMap<>();

    // asigna un valor a una variable
    public void asignar(String nombre, int valor) {
        variables.put(nombre, valor);
    }

    // devuelve el valor de una variable
    public int obtener(String nombre) {
        if (!variables.containsKey(nombre)) {
            throw new IllegalArgumentException("Variable no definida: " + nombre);
        }
        return variables.get(nombre);
    }
}
