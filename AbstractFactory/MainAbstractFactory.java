package AbstractFactory;

// =====================================================================
//  PATRÓN ABSTRACT FACTORY  –  Ejemplo: Temas de Interfaz de Usuario
// =====================================================================
//
//  Contexto: Una app puede mostrar su UI en dos temas: Oscuro o Claro.
//  Cada tema tiene su propio conjunto de componentes (Botón y Checkbox).
//  El cliente construye la UI usando solo la fábrica abstracta,
//  sin saber qué tema concreto está usando.
//
//  Estructura (según refactoring.guru):
//
//   Productos Abstractos        →  Boton, Checkbox
//   Productos Concretos         →  BotonOscuro, BotonClaro,
//                                  CheckboxOscuro, CheckboxClaro
//   Fabrica Abstracta           →  FabricaUI
//   Fabricas Concretas          →  FabricaTemaOscuro, FabricaTemaClaro
//   Cliente                     →  Aplicacion
//
//  Diferencia clave con Factory Method:
//    Factory Method crea UN solo tipo de producto.
//    Abstract Factory crea una FAMILIA de productos relacionados.
// =====================================================================


// ── 1. PRODUCTOS ABSTRACTOS ──────────────────────────────────────────
//  Interfaces que definen qué debe poder hacer cada componente de UI

interface Boton {
    void renderizar();
    void alHacerClick();
}

interface Checkbox {
    void renderizar();
    void marcar();
}


// ── 2. PRODUCTOS CONCRETOS: Familia OSCURO ───────────────────────────

class BotonOscuro implements Boton {
    @Override
    public void renderizar() {
        System.out.println("  [OSCURO] Renderizando botón oscuro (fondo negro, texto blanco)");
    }
    @Override
    public void alHacerClick() {
        System.out.println("  [OSCURO] Click en botón oscuro");
    }
}

class CheckboxOscuro implements Checkbox {
    @Override
    public void renderizar() {
        System.out.println("  [OSCURO] Renderizando checkbox oscuro (borde gris, fondo negro)");
    }
    @Override
    public void marcar() {
        System.out.println("  [OSCURO] Checkbox oscuro marcado ✓");
    }
}


// ── 3. PRODUCTOS CONCRETOS: Familia CLARO ────────────────────────────

class BotonClaro implements Boton {
    @Override
    public void renderizar() {
        System.out.println("  [CLARO]  Renderizando botón claro (fondo blanco, texto negro)");
    }
    @Override
    public void alHacerClick() {
        System.out.println("  [CLARO]  Click en botón claro");
    }
}

class CheckboxClaro implements Checkbox {
    @Override
    public void renderizar() {
        System.out.println("  [CLARO]  Renderizando checkbox claro (borde azul, fondo blanco)");
    }
    @Override
    public void marcar() {
        System.out.println("  [CLARO]  Checkbox claro marcado ✓");
    }
}


// ── 4. FÁBRICA ABSTRACTA ─────────────────────────────────────────────
//  Define el contrato para crear cada tipo de componente de la familia.
//  No sabe qué familia concreta va a producir.

interface FabricaUI {
    Boton crearBoton();
    Checkbox crearCheckbox();
}


// ── 5. FÁBRICAS CONCRETAS ────────────────────────────────────────────
//  Cada fábrica produce TODA la familia de componentes de su tema.
//  Garantizan que los componentes creados sean compatibles entre sí.

class FabricaTemaOscuro implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonOscuro();
    }
    @Override
    public Checkbox crearCheckbox() {
        return new CheckboxOscuro();
    }
}

class FabricaTemaClaro implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonClaro();
    }
    @Override
    public Checkbox crearCheckbox() {
        return new CheckboxClaro();
    }
}


// ── 6. CLIENTE ───────────────────────────────────────────────────────
//  Trabaja SOLO con la fábrica abstracta e interfaces de productos.
//  No tiene ninguna referencia a clases concretas.

class Aplicacion {
    private Boton boton;
    private Checkbox checkbox;

    // Recibe una fábrica sin saber si es oscura o clara
    public Aplicacion(FabricaUI fabrica) {
        this.boton    = fabrica.crearBoton();
        this.checkbox = fabrica.crearCheckbox();
    }

    public void renderizarUI() {
        System.out.println("  Construyendo la interfaz de usuario...");
        boton.renderizar();
        checkbox.renderizar();
    }

    public void interactuar() {
        System.out.println("  Simulando interacciones del usuario...");
        boton.alHacerClick();
        checkbox.marcar();
    }
}


// ── 7. MAIN ──────────────────────────────────────────────────────────

public class MainAbstractFactory {
    public static void main(String[] args) {

        System.out.println("=== PATRÓN ABSTRACT FACTORY ===\n");

        // La elección de la fábrica podría venir de una config, del SO, etc.
        // Aquí la simulamos manualmente para ver ambas familias.

        // --- Usando la familia OSCURO ---
        System.out.println("--- Iniciando app con Tema OSCURO ---");
        FabricaUI fabricaOscura = new FabricaTemaOscuro();
        Aplicacion appOscura = new Aplicacion(fabricaOscura);
        appOscura.renderizarUI();
        System.out.println();
        appOscura.interactuar();

        System.out.println();

        // --- Usando la familia CLARO ---
        System.out.println("--- Iniciando app con Tema CLARO ---");
        FabricaUI fabricaClara = new FabricaTemaClaro();
        Aplicacion appClara = new Aplicacion(fabricaClara);
        appClara.renderizarUI();
        System.out.println();
        appClara.interactuar();

        System.out.println("\n================================");
        System.out.println("La clase Aplicacion nunca mencionó 'Oscuro' ni 'Claro'.");
        System.out.println("Solo trabajó con FabricaUI, Boton y Checkbox (abstractos).");
        System.out.println("Cambiar de tema = cambiar la fábrica. Nada más.");
    }
}
