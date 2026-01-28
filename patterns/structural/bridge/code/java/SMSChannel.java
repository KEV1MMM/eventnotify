public class SMSChannel implements MessageChannel {
    @Override
    public void sendMessage(String message) {
        System.out.println("📱 Enviando por SMS: " + message);
    }
}