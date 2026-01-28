public interface SMSProvider {
    void sendSMS(String number, String message);
}