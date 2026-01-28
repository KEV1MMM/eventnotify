abstract class NotificationSender {

    // Template Method (algorithm skeleton)
    public final void sendNotification(String userId, String message) {
        System.out.println("\n[Template] Starting notification flow...");
        if (!validate(userId, message)) {
            System.out.println("[Template] Validation failed");
            return;
        }
        String payload = format(userId, message);
        send(payload);
        System.out.println("[Template] Done");
    }

    // Steps (some are customizable by subclasses)
    protected boolean validate(String userId, String message) {
        return userId != null && !userId.isBlank() && message != null && !message.isBlank();
    }

    protected abstract String format(String userId, String message);

    protected abstract void send(String payload);
}

class EmailSender extends NotificationSender {
    @Override
    protected String format(String userId, String message) {
        return "[EMAIL to=" + userId + "] " + message;
    }

    @Override
    protected void send(String payload) {
        System.out.println("[EmailSender] Sending -> " + payload);
    }
}

class SmsSender extends NotificationSender {
    @Override
    protected String format(String userId, String message) {
        return "[SMS to=" + userId + "] " + message;
    }

    @Override
    protected void send(String payload) {
        System.out.println("[SmsSender] Sending -> " + payload);
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Template Method Demo ===");

        NotificationSender email = new EmailSender();
        NotificationSender sms = new SmsSender();

        email.sendNotification("u123", "Event reminder: Team meeting at 3pm");
        sms.sendNotification("u456", "Alert: Event starts in 10 minutes");

        // invalid example
        email.sendNotification("", "This should fail");
    }
}
