public class Demo {
    public static void main(String[] args) {
        System.out.println("--- State Pattern Demo ---");

        NotificationContext notification = new NotificationContext();

        // Ciclo de vida: Borrador -> Enviado -> Entregado
        notification.printStatus();
        
        notification.nextState(); // Pasa a Enviado
        notification.printStatus();

        notification.nextState(); // Pasa a Entregado
        notification.printStatus();

        notification.nextState(); // Ya no avanza más
    }
}