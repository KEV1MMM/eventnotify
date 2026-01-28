public class demo {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();
        notifier = new EmailDecorator(notifier);
        notifier = new SmsDecorator(notifier);

        notifier.send("Order #1234 shipped!");
    }
}
