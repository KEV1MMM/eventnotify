public class UrgentNotification extends Notification {
    public UrgentNotification(MessageChannel channel) {
        super(channel);
    }

    @Override
    public void notify(String message) {
        System.out.println("!!! ALERTA URGENTE !!!");
        channel.sendMessage(message.toUpperCase()); // Manda todo en mayúsculas
    }
}