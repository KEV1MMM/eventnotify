class Validator {
    public boolean isValid(String userId, String message) {
        return userId != null && !userId.isBlank() && message != null && !message.isBlank();
    }
}

class Formatter {
    public String format(String userId, String message) {
        return "[To=" + userId + "] " + message;
    }
}

class Sender {
    public void send(String payload) {
        System.out.println("[Sender] Sending -> " + payload);
    }
}

// Facade
class NotificationFacade {
    private final Validator validator = new Validator();
    private final Formatter formatter = new Formatter();
    private final Sender sender = new Sender();

    public void sendNotification(String userId, String message) {
        System.out.println("\n[Facade] New request");
        if (!validator.isValid(userId, message)) {
            System.out.println("[Facade] Invalid notification request");
            return;
        }
        String payload = formatter.format(userId, message);
        sender.send(payload);
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Facade Demo ===");

        NotificationFacade facade = new NotificationFacade();
        facade.sendNotification("u123", "Event reminder: Team meeting at 3pm");
        facade.sendNotification("", "This should fail");
    }
}
