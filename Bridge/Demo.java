package Bridge;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());

        // --- Prueba de setDevice con el mismo control remoto ---
        System.out.println("====================================");
        System.out.println("Prueba cambiando dispositivo con setDevice()");
        
        Device tv = new Tv();
        Device radio = new Radio();
        
        // Creamos el control sin dispositivo asignado inicialmente
        BasicRemote remote = new BasicRemote();

        // Conectamos el control al televisor
        remote.setDevice(tv);
        remote.power();
        tv.printStatus();

        // Reutilizamos el mismo control ahora conectado a la radio
        remote.setDevice(radio);
        remote.power();
        radio.printStatus();
    }

    public static void testDevice(Device device) {
        System.out.println("Prueba con control basico");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Pruebas con control Avanzado");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}