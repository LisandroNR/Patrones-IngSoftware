package TemplateMethod;

// 1. Clase Abstracta: Define el esqueleto del algoritmo y pasos base
abstract class GameAI {

    // MÉTODO PLANTILLA (Template Method):
    // Se declara 'final' para evitar que las subclases alteren el orden del algoritmo.
    public final void takeTurn() {
        collectResources();
        buildStructures();
        buildUnits();
        attack();
    }

    // Paso con implementación por defecto (puede ser sobrescrito)
    public void collectResources() {
        System.out.println("[GameAI] Recolectando recursos estándar de las minas y granjas...");
    }

    // Paso con implementación por defecto que invoca pasos abstractos
    public void attack() {
        String enemyPosition = "Coordenadas (X: 45, Y: 80)";
        sendScouts(enemyPosition);
        sendWarriors(enemyPosition);
    }

    // Pasos abstractos: obligan a las subclases a definir su propia lógica
    public abstract void buildStructures();
    public abstract void buildUnits();
    public abstract void sendScouts(String position);
    public abstract void sendWarriors(String position);
}

// 2. Subclase Concreta 1: Implementa los pasos obligatorios y usa la recolección por defecto
class OrcsAI extends GameAI {

    @Override
    public void buildStructures() {
        System.out.println("[Orcos] Construyendo granjas, cuarteles y torres de vigilancia.");
    }

    @Override
    public void buildUnits() {
        System.out.println("[Orcos] Entrenando peones y guerreros grunts.");
    }

    @Override
    public void sendScouts(String position) {
        System.out.println("[Orcos] Enviando exploradores en lobo hacia " + position);
    }

    @Override
    public void sendWarriors(String position) {
        System.out.println("[Orcos] Enviando horda de guerreros a atacar " + position);
    }
}

// 3. Subclase Concreta 2: Sobrescribe además el paso por defecto 'collectResources'
class MonstersAI extends GameAI {

    @Override
    public void collectResources() {
        System.out.println("[Monstruos] Los monstruos no recolectan oro; absorben energía oscura pasivamente.");
    }

    @Override
    public void buildStructures() {
        System.out.println("[Monstruos] Excavando guaridas subterráneas.");
    }

    @Override
    public void buildUnits() {
        System.out.println("[Monstruos] Invocando criaturas salvajes.");
    }

    @Override
    public void sendScouts(String position) {
        System.out.println("[Monstruos] Enviando murciélagos rastreadores hacia " + position);
    }

    @Override
    public void sendWarriors(String position) {
        System.out.println("[Monstruos] Desatando bestias gigantes en " + position);
    }
}

// 4. Cliente: Ejecuta los turnos sin preocuparse por las diferencias internas de cada raza
public class MainTemplateMethod {
    public static void main(String[] args) {
        System.out.println("=== TURNO DE LOS ORCOS ===");
        GameAI orcs = new OrcsAI();
        orcs.takeTurn();

        System.out.println("\n=== TURNO DE LOS MONSTRUOS ===");
        GameAI monsters = new MonstersAI();
        monsters.takeTurn();
    }
}
