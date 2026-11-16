package Interpreter;

// AbstractExpression
// interfaz comun para todos los nodos del arbol sintactico
// obliga a cada expresion a saber interpretarse usando el contexto
public interface Expresion {
    int interpretar(Contexto contexto);
}
