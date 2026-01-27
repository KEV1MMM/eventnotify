public class NotificationBuilder {
    private String recipient;
    private String message;
    private String channel = "EMAIL"; // Valor por defecto
    private boolean isPriority = false; // Valor por defecto

    public NotificationBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public NotificationBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public NotificationBuilder setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public NotificationBuilder setPriority(boolean isPriority) {
        this.isPriority = isPriority;
        return this;
    }

    public Notification build() {
        return new Notification(recipient, message, channel, isPriority);
    }
}