package Interpreter;

// TerminalExpression
// hoja del arbol: una variable, su valor se busca en el contexto
public class Variable implements Expresion {
    private String nombre;

    public Variable(String nombre) {
        this.nombre = nombre;
    }

    // consulta el contexto para saber cuanto vale la variable
    @Override
    public int interpretar(Contexto contexto) {
        return contexto.obtener(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
