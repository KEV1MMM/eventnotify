public class SMSAdapter implements SMSProvider {
    private LegacyNotificationService legacyService;

    public SMSAdapter(LegacyNotificationService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public void sendSMS(String number, String message) {
        // Aquí traducimos la llamada:
        // El sistema nuevo pide (numero, mensaje)
        // El viejo pide (mensaje, numero)
        this.legacyService.sendOldSchool(message, number);
    }
}