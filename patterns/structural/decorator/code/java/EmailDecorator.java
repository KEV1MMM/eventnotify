public class EmailDecorator extends NotifierDecorator {
    public EmailDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("[Email] Also sending EMAIL: " + message);
    }
}
