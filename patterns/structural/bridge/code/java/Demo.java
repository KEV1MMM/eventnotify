public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Bridge Pattern Demo ---");

        // 1. Crear los canales (las implementaciones)
        MessageChannel email = new EmailChannel();
        MessageChannel sms = new SMSChannel();

        // 2. Usar el puente: Una Notificación Urgente por EMAIL
        Notification alertEmail = new UrgentNotification(email);
        alertEmail.notify("Servidor caído");

        System.out.println();

        // 3. Usar el puente: La MISMA notificación pero por SMS
        Notification alertSMS = new UrgentNotification(sms);
        alertSMS.notify("Intento de intrusión");
    }
}