package Interpreter;

// NonterminalExpression
// regla compuesta: agrupa dos subexpresiones (agregacion) y las suma
public class Suma implements Expresion {
    private Expresion izquierda;
    private Expresion derecha;

    public Suma(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    // interpreta recursivamente cada lado y combina los resultados
    @Override
    public int interpretar(Contexto contexto) {
        return izquierda.interpretar(contexto) + derecha.interpretar(contexto);
    }

    @Override
    public String toString() {
        return "(" + izquierda + " + " + derecha + ")";
    }
}
