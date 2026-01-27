class NotificationRequest {
    public final String userId;
    public final String message;
    public final boolean isSpam;
    public final int priority;

    public NotificationRequest(String userId, String message, boolean isSpam, int priority) {
        this.userId = userId;
        this.message = message;
        this.isSpam = isSpam;
        this.priority = priority;
    }
}

interface Handler {
    Handler setNext(Handler next);
    boolean handle(NotificationRequest req);
}

abstract class AbstractHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public boolean handle(NotificationRequest req) {
        return handleNext(req);
    }

    protected boolean handleNext(NotificationRequest req) {
        if (next == null) return true;
        return next.handle(req);
    }
}

class SpamCheckHandler extends AbstractHandler {
    @Override
    public boolean handle(NotificationRequest req) {
        if (req.isSpam) {
            System.out.println("[SpamCheck] BLOCKED -> user=" + req.userId + ", msg=\"" + req.message + "\"");
            return false;
        }
        System.out.println("[SpamCheck] OK");
        return handleNext(req);
    }
}

class RateLimitHandler extends AbstractHandler {
    @Override
    public boolean handle(NotificationRequest req) {
        // Demo simple: prioridad <= 0 simula rate-limit
        if (req.priority <= 0) {
            System.out.println("[RateLimit] BLOCKED -> too many requests for user=" + req.userId);
            return false;
        }
        System.out.println("[RateLimit] OK");
        return handleNext(req);
    }
}

class SendNotificationHandler extends AbstractHandler {
    @Override
    public boolean handle(NotificationRequest req) {
        System.out.println("[Send] SENT -> user=" + req.userId + " | priority=" + req.priority + " | msg=\"" + req.message + "\"");
        return true;
    }
}

public class Demo {
    public static void main(String[] args) {
        // Chain: SpamCheck -> RateLimit -> Send
        Handler spam = new SpamCheckHandler();
        Handler rate = new RateLimitHandler();
        Handler send = new SendNotificationHandler();
        spam.setNext(rate).setNext(send);

        System.out.println("=== Case 1: valid notification ===");
        System.out.println("Result: " + spam.handle(new NotificationRequest("u123", "Event created: Concert @ 8pm", false, 1)));

        System.out.println("\n=== Case 2: spam blocked ===");
        System.out.println("Result: " + spam.handle(new NotificationRequest("u999", "FREE MONEY!!! click now", true, 5)));

        System.out.println("\n=== Case 3: rate limited blocked ===");
        System.out.println("Result: " + spam.handle(new NotificationRequest("u123", "Event reminder: Meeting in 10 min", false, 0)));
    }
}
