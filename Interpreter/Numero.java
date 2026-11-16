package Interpreter;

// TerminalExpression
// hoja del arbol: un numero literal, no se descompone mas
public class Numero implements Expresion {
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    // un numero se interpreta como su propio valor
    @Override
    public int interpretar(Contexto contexto) {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
