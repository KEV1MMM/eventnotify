public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern Demo: EventNotify ---");

        // 1. Crear una notificación simple (sin especificar todo)
        Notification simple = new NotificationBuilder()
            .setRecipient("usuario@email.com")
            .setMessage("Bienvenido al sistema")
            .build();
        
        System.out.println("Simple: " + simple);

        // 2. Crear una notificación compleja (especificando todo)
        Notification critical = new NotificationBuilder()
            .setRecipient("admin@empresa.com")
            .setMessage("FALLO DEL SERVIDOR")
            .setChannel("SMS")
            .setPriority(true)
            .build();

        System.out.println("Critica: " + critical);
    }
}

