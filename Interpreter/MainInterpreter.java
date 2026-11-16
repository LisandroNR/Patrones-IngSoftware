package Interpreter;

// Client
// construye el arbol sintactico (AST), configura el contexto y dispara interpretar()

public class MainInterpreter {
    public static void main(String[] args) {

        // inicializamos el contexto con los valores de las variables
        Contexto contexto = new Contexto();
        contexto.asignar("x", 5);
        contexto.asignar("y", 3);

        // construimos el arbol para la expresion: (x + 2) * y
        Expresion expresion = new Multiplicacion(
                new Suma(new Variable("x"), new Numero(2)),
                new Variable("y")
        );

        System.out.println("\n--- Interpretamos la expresión ---");
        System.out.println("Expresión: " + expresion);
        System.out.println("Con x = 5, y = 3 -> Resultado: " + expresion.interpretar(contexto));

        // cambiamos el contexto: el mismo arbol da otro resultado
        System.out.println("\n--- Cambiamos el contexto ---");
        contexto.asignar("x", 10);
        contexto.asignar("y", 2);
        System.out.println("Con x = 10, y = 2 -> Resultado: " + expresion.interpretar(contexto));
    }
}
