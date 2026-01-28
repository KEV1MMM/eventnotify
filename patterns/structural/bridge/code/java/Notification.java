public abstract class Notification {
    protected MessageChannel channel; // Este es el "Bridge"

    public Notification(MessageChannel channel) {
        this.channel = channel;
    }

    public abstract void notify(String message);
}