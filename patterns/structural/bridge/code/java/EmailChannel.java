public class EmailChannel implements MessageChannel {
    @Override
    public void sendMessage(String message) {
        System.out.println("📧 Enviando por EMAIL: " + message);
    }
}