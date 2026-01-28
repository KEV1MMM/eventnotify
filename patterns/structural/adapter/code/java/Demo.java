public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Demo ---");

        // 1. Tenemos el servicio viejo (incompatible)
        LegacyNotificationService oldService = new LegacyNotificationService();

        // 2. Lo envolvemos con el adaptador
        SMSProvider provider = new SMSAdapter(oldService);

        // 3. El cliente usa la interfaz nueva sin saber que hay algo viejo detrás
        provider.sendSMS("+5299999999", "Su código es 1234");
    }
}