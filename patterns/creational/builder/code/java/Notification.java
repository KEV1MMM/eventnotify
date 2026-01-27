public class Notification {
    private String recipient;
    private String message;
    private String channel;
    private boolean isPriority;

    // El constructor se deja público o default para que el Builder lo use
    public Notification(String recipient, String message, String channel, boolean isPriority) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
        this.isPriority = isPriority;
    }

    @Override
    public String toString() {
        return "Notification [To: " + recipient + ", Channel: " + channel + 
               ", Message: " + message + ", Priority: " + isPriority + "]";
    }
}
//fin