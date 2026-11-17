// 1. Interfaz Mediador: Define cómo los componentes se comunicarán con él.
public interface Mediator {
    void notify(Component sender, String event);
}

// 2. Clase Base Componente: Todos los componentes conocen a su mediador, pero no a otros componentes.
public abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

// 3. Componentes Concretos: Hacen su trabajo y notifican al mediador.

class Checkbox extends Component {
    private boolean isCorporate = false;

    public void toggle() {
        isCorporate = !isCorporate;
        System.out.println("Checkbox: Estado cambiado a " + (isCorporate ? "Empresa" : "Individuo"));
        // Notifica al mediador que hubo un cambio
        mediator.notify(this, "check"); 
    }

    public boolean isCorporate() {
        return isCorporate;
    }
}

class TextField extends Component {
    private String name;
    private boolean visible = true;

    public TextField(String name) {
        this.name = name;
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
        System.out.println("TextField (" + name + "): Visibilidad cambiada a " + visible);
    }
}

class Button extends Component {
    public void click() {
        System.out.println("Button: Usuario hizo clic en 'Registrar'");
        mediator.notify(this, "click");
    }
}

// 4. Mediador Concreto: Encapsula la lógica de negocio y coordina a los componentes.
public class RegistrationForm implements Mediator {
    private Checkbox corporateCheckbox;
    private TextField dniField;
    private TextField cuitField;
    private Button submitButton;

    // El mediador registra los componentes y se asigna a sí mismo como su mediador.
    public RegistrationForm(Checkbox corporateCheckbox, TextField dniField, TextField cuitField, Button submitButton) {
        this.corporateCheckbox = corporateCheckbox;
        this.corporateCheckbox.setMediator(this);
        
        this.dniField = dniField;
        this.dniField.setMediator(this);
        
        this.cuitField = cuitField;
        this.cuitField.setMediator(this);
        
        this.submitButton = submitButton;
        this.submitButton.setMediator(this);
    }

    @Override
    public void notify(Component sender, String event) {
        // Lógica de coordinación: Si el checkbox cambia...
        if (sender == corporateCheckbox && event.equals("check")) {
            if (corporateCheckbox.isCorporate()) {
                dniField.setVisibility(false);
                cuitField.setVisibility(true);
            } else {
                dniField.setVisibility(true);
                cuitField.setVisibility(false);
            }
        }

        // Lógica de coordinación: Si se hace clic en el botón...
        if (sender == submitButton && event.equals("click")) {
            System.out.println("Mediador: Validando campos y enviando formulario a la base de datos...\n");
        }
    }
}

// 5. Cliente: Configura la aplicación.
public class Main {
    public static void main(String[] args) {
        // Instanciamos los componentes de forma independiente.
        Checkbox checkbox = new Checkbox();
        TextField dniField = new TextField("DNI");
        TextField cuitField = new TextField("CUIT");
        Button button = new Button();

        // Creamos el mediador y le pasamos los componentes.
        Mediator formMediator = new RegistrationForm(checkbox, dniField, cuitField, button);

        System.out.println("--- Escenario 1: El usuario cambia a cuenta de 'Empresa' ---");
        checkbox.toggle();

        System.out.println("\n--- Escenario 2: El usuario vuelve a cuenta de 'Individuo' ---");
        checkbox.toggle();

        System.out.println("\n--- Escenario 3: El usuario envía el formulario ---");
        button.click();
    }
}
