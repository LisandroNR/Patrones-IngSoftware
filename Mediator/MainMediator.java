// 1. Interfaz Mediador: Declara el método de comunicación con los componentes.
public interface Mediator {
    void notify(Component sender, String event);
}

// 2. Componente Base: Almacena la referencia al mediador.
public abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

// 3. Componentes Concretos: No dependen de otros componentes, solo del mediador.
public class Button extends Component {
    public void click() {
        System.out.println("Componente Botón: Clickeado.");
        mediator.notify(this, "click");
    }
}

public class TextBox extends Component {
    private String text = "";

    public void setText(String text) {
        this.text = text;
        System.out.println("Componente TextBox: Texto actualizado a '" + text + "'.");
        mediator.notify(this, "textChanged");
    }

    public void save() {
        System.out.println("Componente TextBox: Guardando datos en la base de datos...");
    }
}

public class Checkbox extends Component {
    private boolean checked = false;

    public void check() {
        this.checked = true;
        System.out.println("Componente Checkbox: Marcado.");
        mediator.notify(this, "check");
    }
}

// 4. Mediador Concreto: Encapsula la lógica de interacción entre componentes.
public class AuthenticationDialog implements Mediator {
    private Button loginButton;
    private TextBox usernameTextBox;
    private Checkbox rememberMeCheckbox;

    public AuthenticationDialog(Button loginButton, TextBox usernameTextBox, Checkbox rememberMeCheckbox) {
        this.loginButton = loginButton;
        this.loginButton.setMediator(this);
        
        this.usernameTextBox = usernameTextBox;
        this.usernameTextBox.setMediator(this);
        
        this.rememberMeCheckbox = rememberMeCheckbox;
        this.rememberMeCheckbox.setMediator(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == loginButton && event.equals("click")) {
            System.out.println("Mediador: Reaccionando al clic del botón. Iniciando proceso de guardado.");
            usernameTextBox.save();
        }
        
        if (sender == rememberMeCheckbox && event.equals("check")) {
            System.out.println("Mediador: Reaccionando al checkbox. Autocompletando usuario por defecto.");
            usernameTextBox.setText("usuario_admin");
        }
    }
}

// 5. Código Cliente: Crea los componentes y el mediador, vinculándolos.
public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        TextBox textBox = new TextBox();
        Checkbox checkbox = new Checkbox();

        // El mediador organiza la relación. Los componentes no se conocen entre sí.
        Mediator dialog = new AuthenticationDialog(button, textBox, checkbox);

        System.out.println("--- El usuario marca la casilla 'Recordarme' ---");
        checkbox.check();

        System.out.println("\n--- El usuario hace clic en el botón de 'Login' ---");
        button.click();
    }
}
