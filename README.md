# Patrones de Diseño 

**Universidad Nacional de Villa Mercedes (UNViMe)**  
**Materia:** Ingeniería de Software  
**Grupo:** Cahe Emilio, Carballo Emilio, García Nicolás, Mercado Luka, Moneo Martina, Oliva Jonathan, Rimada Lisandro, Sibona Franco, Silvera Álvaro.

## 📌 Objetivo del Proyecto
El objetivo de este proyecto es analizar, comprender e implementar mediante código fuente los principales Patrones de Diseño orientados a objetos. Se busca demostrar cómo estos patrones resuelven problemas recurrentes de arquitectura de software, mejorando la modularidad, escalabilidad y el mantenimiento del código sin violar principios de diseño sólidos.

## 🧩 Patrones Implementados

El repositorio contiene ejemplos prácticos divididos en tres categorías fundamentales:

### Patrones Creacionales
Se enfocan en los mecanismos de creación de objetos.
*   **Builder:** Patrón que nos permite construir objetos complejos paso a paso. Separa el código de construcción de la lógica de negocio.
*   **Prototype:** Patrón que nos permite copiar objetos existentes sin que el código dependa de sus clases.

### Patrones Estructurales
*   **Adapter:** Permite la colaboración entre objetos con interfaces incompatibles. Separa la lógica de traducción de la lógica de negocio.
*   **Decorator:** Permite comprimir y encriptar información sensible, independientemente del código que utilice esos datos. Suma comportamientos a un objeto sin tener que crear subclases nuevas.
*   **Facade:** Proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases. 

### Patrones de Comportamiento
*   **Chain of Responsibility:** Permite pasar solicitudes a lo largo de una cadena de manejadores. Cada clase se encarga de realizar una única tarea sobre la solicitud.
*   **Memento:** Permite guardar y restaurar el estado previo de un objeto sin revelar los detalles de su implementación.
*   **Observer:** Permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que les suceda al objeto que están observando.
*   **State:** Permite a un objeto alterar su comportamiento cuando su estado interno cambia. Sustituye extensas cadenas de switch o if-else dependientes del estado por polimorfismo limpio.
*   **Strategy:** Permite definir una familia de algoritmos, colocar cada uno en una clase separada y hacer que sus objetos sean intercambiables. 

### 4. Patrón Decorator (Estructural)
* **Propósito:** Permitir añadir funcionalidades de manera dinámica a un objeto envolviéndolo en clases contenedoras (decoradores) que comparten la misma interfaz, ofreciendo una alternativa flexible a la herencia para extender comportamientos.
* **Ubicación:** Carpeta `Decorator/`.
* **Estructura implementada:**
`DataSource` (Interfaz): Define el contrato estándar para leer y escribir datos.

`FileDataSource` (Componente Concreto): Implementación básica encargada de operar directamente sobre el archivo.

`DataSourceDecorator` (Decorador Base): Clase que implementa la interfaz y mantiene una referencia interna (`wrappee`) al objeto envuelto.

`EncryptionDecorator` y `CompressionDecorator` (Decoradores Concretos): Extienden el decorador base para aplicar capas adicionales de seguridad (encriptación) o optimización (compresión) en tiempo de ejecución.
* **Punto de Entrada:** `MainDecorator.java`.

### 5. Patrón Facade (Estructural)
* **Propósito:** Proporcionar una interfaz unificada y simplificada a un conjunto de interfaces de un subsistema complejo, facilitando su uso por parte del cliente y reduciendo el acoplamiento general del sistema.
* **Ubicación:** Carpeta `Facade/`.
* **Estructura implementada:**
`Facade` (Clase Fachada Principal): Coordina y agrupa las llamadas a las distintas clases del subsistema a través de un método unificado (subsystemOperation()).

`AdditionalFacade` (Fachada Adicional): Ofrece operaciones complementarias para evitar sobrecargar la fachada principal con funciones no relacionadas.

`SubsystemOne`, `SubsystemTwo`, `SubsystemThree` (Clases del Subsistema): Conjunto de clases internas que realizan el trabajo real de forma independiente.

`MainFacade` (Cliente): Interactúa únicamente con la fachada, desconociendo la complejidad de las clases internas del subsistema.
* **Punto de Entrada:** `MainFacade.java`.

### 6. Patrón Chain of Responsibility (Comportamiento)
* **Propósito:** Permitir que una solicitud pase a través de una cadena de objetos receptores hasta que uno de ellos la procese, desacoplando al emisor del receptor y permitiendo flexibilidad para que la petición escale automáticamente.
* **Ubicación:** Carpeta `ChainOfResponsibility/`.
* **Estructura implementada:**
`ComponentWithContextualHelp` (Interfaz Manejador): Declara el contrato común (`showHelp()`) para procesar las solicitudes de ayuda.

`Component` (Manejador Base): Implementa la interfaz y mantiene una referencia al siguiente eslabón (`container`), encargándose de delegar la solicitud si el componente actual no puede resolverla.

`Container` (Clase Contenedor): Extiende del componente base y agrupa una colección de elementos hijos.

`Button`, `Panel`, `Dialog` (Manejadores Concretos): Clases finales que evalúan si poseen recursos propios de ayuda o si deben propagar el evento hacia arriba en la cadena.

* **Punto de Entrada:** `MainCHOR.java`.


### 7.  Patrón Memento (Comportamiento)
* **Propósito:** Permitir capturar y externalizar el estado interno de un objeto sin violar su encapsulamiento, de manera que el objeto pueda ser restaurado posteriormente a dicho estado (soporte para operaciones de Undo/Redo).

* **Ubicación:** Carpeta Memento/.

* **Estructura  implementada:** 

TextEditor (Originator): Posee el estado real (content, cursorPosition). Es el único responsable de empaquetar su estado en un memento (save()) y de restaurarse a partir de él (restore()).

TextEditorMemento (Memento): Objeto inmutable que almacena la instantánea del estado. Funciona como una caja negra hacia el exterior.

History (Caretaker): Administra la pila de instantáneas pasadas. Almacena y provee los mementos según se requiera, sin examinar ni manipular su contenido interno.

* **Punto de Entrada:** MainMemento.java.

### 8. Patrón State (Comportamiento)
* **Propósito:** Permitir que un objeto altere su comportamiento cuando cambia su estado interno, dando la apariencia de haber cambiado de clase al eliminar sentencias condicionales masivas (if/switch) y encapsular los comportamientos específicos en clases de estado independientes.

* **Ubicación:** Carpeta State/.

* **Estructura implementada:**

Player (Contexto): Mantiene la referencia al estado actual y le delega la ejecución de las acciones (clickPlay(), clickLock(), clickNext()). Permite realizar transiciones mediante changeState().

State (Clase Abstracta / Interfaz): Define el contrato para todas las operaciones sensibles al estado (onPlay(), onLock(), onNext()) y mantiene una referencia al contexto Player.

ReadyState, PlayingState, LockedState (Estados Concretos): Implementan las reacciones particulares a cada evento y controlan las transiciones dinámicas entre los distintos modos del reproductor.

* **Punto de Entrada:** MainState.java.

## 🚀 Instrucciones de Ejecución

El código fuente de este proyecto está desarrollado en **Java**. Para ejecutar los ejemplos de implementación de cada patrón, sigue estos pasos:

<<<<<<< HEAD
1. **Clonar el repositorio:**
   git clone https://github.com/LisandroNR/Patrones-IngSoftware.git
   
2. **Abrir el proyecto:**
   Abre la carpeta raíz del repositorio en un entorno de desarrollo compatible con Java.
   
3. **Ejecutar los patrones:**
   Cada patrón de diseño se encuentra encapsulado en su propia subcarpeta. 
   * Navega hasta la carpeta del patrón que deseas probar.
   * Abre el archivo principal que contiene la clase ejecutora.
   * Ejecuta el archivo para visualizar la salida en la terminal.
=======
### Clonar el repositorio
```bash
git clone <https://github.com/LisandroNR/Tp-N-1-Ingenieria-de-software.git>
cd Tp-N-1-Ingenieria-de-software

Ejecución del Patrón Observer/Strategy/Singleton/Decorator/Facade
Para compilar y ejecutar el ejemplo del patrón Observer/Strategy/Singleton/Decorator/Facade/ChainOfResponsibility:

Ingresar al directorio del patrón
cd Observer/Strategy/Singleton/Decorator/Facade/ChainOfResponsibility

Compilar los archivos Java:
javac *.java

Ejecutar la clase principal
java MainObserver/MainStrategy/MainSingleton/MainDecorator/MainFacade/MainCHOR

# Ejemplos Prácticos de los Principios S.O.L.I.D. en Java

Este repositorio contiene una implementación didáctica, completa y ejecutable de los **5 principios de diseño de software S.O.L.I.D.** en Java. Para cada principio se incluye el contraejemplo (violación del principio o anti-patrón) y la solución recomendada aplicando el principio correspondiente.

---

## 🧭 Estructura del Proyecto

```text
PrincipiosSolid/
├── src/com/solid/
│   ├── srp/                   # 1. Single Responsibility Principle
│   │   ├── bad/               # Violación: Invoice con cálculo, impresión y base de datos
│   │   ├── good/              # Solución: Invoice, InvoiceRepository, InvoicePrinter
│   │   └── SrpDemo.java       # Demostración ejecutable
│   │
│   ├── ocp/                   # 2. Open/Closed Principle
│   │   ├── bad/               # Violación: PaymentProcessor con if/else encadenados
│   │   ├── good/              # Solución: Interfaz PaymentMethod y clases polimórficas
│   │   └── OcpDemo.java       # Demostración ejecutable
│   │
│   ├── lsp/                   # 3. Liskov Substitution Principle
│   │   ├── bad/               # Violación: FixedDepositAccount lanzando excepción en withdraw()
│   │   ├── good/              # Solución: Separación entre Account y WithdrawableAccount
│   │   └── LspDemo.java       # Demostración ejecutable
│   │
│   ├── isp/                   # 4. Interface Segregation Principle
│   │   ├── bad/               # Violación: MultiFunctionDevice gigante que fuerza métodos no soportados
│   │   ├── good/              # Solución: Interfaces finas (Printer, Scanner, Fax)
│   │   └── IspDemo.java       # Demostración ejecutable
│   │
│   ├── dip/                   # 5. Dependency Inversion Principle
│   │   ├── bad/               # Violación: OrderService acoplado a SmtpEmailSender
│   │   ├── good/              # Solución: OrderService depende de NotificationChannel (abstracción)
│   │   └── DipDemo.java       # Demostración ejecutable
│   │
│   └── Main.java              # Ejecutor global de todas las demostraciones
└── README.md
```

---

## 1. S — Single Responsibility Principle (SRP)
> *"Una clase debe tener una, y solo una, razón para cambiar."*

- **El Problema (`bad.Invoice`)**: La clase calcula totales e impuestos, formatea e imprime la factura por consola y además guarda el registro en la base de datos. Si cambia el motor de base de datos, el formato del informe o el cálculo fiscal, esta misma clase se ve modificada.
- **La Solución (`good`)**:
  - `Invoice`: Maneja exclusivamente el estado de la factura y su lógica de negocio.
  - `InvoicePrinter`: Se encarga exclusivamente de formatear y presentar la factura.
  - `InvoiceRepository`: Se encarga de la persistencia de datos.

---

## 2. O — Open/Closed Principle (OCP)
> *"Las entidades de software deben estar abiertas para la extensión, pero cerradas para la modificación."*

- **El Problema (`bad.PaymentProcessor`)**: Cada vez que el negocio requiere un nuevo medio de pago (PayPal, Cripto, etc.), hay que abrir y modificar la clase `PaymentProcessor` agregando ramas condicionales `if-else` o `switch`, con riesgo de romper código existente.
- **La Solución (`good`)**:
  - Se define la abstracción `PaymentMethod` con el método `pay(double amount)`.
  - Cada método de pago (`CreditCardPayment`, `PayPalPayment`, `CryptoPayment`) implementa la interfaz.
  - `PaymentProcessor` orquesta el pago a través de la abstracción sin importar qué método se agregue en el futuro.

---

## 3. L — Liskov Substitution Principle (LSP)
> *"Si S es un subtipo de T, los objetos de tipo T pueden ser sustituidos por objetos de tipo S sin alterar el funcionamiento del programa."*

- **El Problema (`bad.FixedDepositAccount`)**: La clase base `BankAccount` define el método `withdraw()`. La subclase `FixedDepositAccount` (plazo fijo) sobreescribe `withdraw()` lanzando una excepción `UnsupportedOperationException`. Cualquier cliente que espere un `BankAccount` fallará en tiempo de ejecución.
- **La Solución (`good`)**:
  - Se define `Account` con las operaciones comunes (`deposit()`, `getBalance()`).
  - Se define `WithdrawableAccount` que extiende `Account` y añade `withdraw()`.
  - `SavingsAccount` implementa `WithdrawableAccount`.
  - `FixedDepositAccount` implementa solo `Account`. Ningún cliente que realice retiros aceptará una cuenta que no garantice contractualmente esa capacidad.

---

## 4. I — Interface Segregation Principle (ISP)
> *"Los clientes no deben verse obligados a depender de interfaces que no utilizan."*

- **El Problema (`bad.MultiFunctionDevice`)**: Una interfaz monolítica agrupa `print()`, `scan()` y `fax()`. Una impresora básica económica se ve forzada a implementar métodos que físicamente no puede cumplir, viéndose obligada a lanzar excepciones o dejar métodos vacíos.
- **La Solución (`good`)**:
  - Se segregan interfaces cohesivas: `Printer`, `Scanner`, `Fax`.
  - `BasicPrinter` solo implementa `Printer`.
  - `AllInOneOfficeMachine` compone e implementa `Printer`, `Scanner` y `Fax`.

---

## 5. D — Dependency Inversion Principle (DIP)
> *"1. Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones."*  
> *"2. Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones."*

- **El Problema (`bad.OrderService`)**: La clase de alto nivel `OrderService` instancia directamente `new SmtpEmailSender()`. Está rígidamente acoplada a una implementación técnica de infraestructura; no se puede reemplazar fácilmente por SMS o Slack, ni se puede aislar para pruebas unitarias (unit tests).
- **La Solución (`good`)**:
  - Se crea la abstracción `NotificationChannel`.
  - Los canales concretos (`EmailNotificationChannel`, `SmsNotificationChannel`, `SlackNotificationChannel`) implementan la abstracción.
  - `OrderService` recibe su dependencia vía inyección de dependencias por constructor.

---

## 🚀 Compilación y Ejecución

Para compilar y ejecutar todo el proyecto desde la terminal:

```bash
# Compilar todo el código fuente en la carpeta bin/
mkdir -p bin
javac -d bin $(find src -name "*.java")

# Ejecutar el orquestador principal
java -cp bin com.solid.Main
```

También es posible ejecutar cada principio por separado si se desea:

```bash
# Ejecutar solo la demo de DIP, por ejemplo:
java -cp bin com.solid.dip.DipDemo
```

