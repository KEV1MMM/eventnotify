import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Flyweight {
    void render(String extrinsicState);
}

// Concrete Flyweight: shared (intrinsic) state = channel
class NotificationType implements Flyweight {
    private final String channel;

    public NotificationType(String channel) {
        this.channel = channel;
    }

    @Override
    public void render(String extrinsicState) {
        System.out.println("[Flyweight] channel=" + channel + " | " + extrinsicState);
    }
}

// Flyweight Factory: reuses flyweights by key (channel)
class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String channel) {
        return flyweights.computeIfAbsent(channel, NotificationType::new);
    }

    public int cacheSize() {
        return flyweights.size();
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Demo ===");
        FlyweightFactory factory = new FlyweightFactory();

        // Extrinsic state: user + message + eventId (changes per notification)
        Flyweight email = factory.getFlyweight("EMAIL");
        Flyweight sms = factory.getFlyweight("SMS");

        email.render("user=u1 | eventId=E100 | msg='Event created'");
        email.render("user=u2 | eventId=E200 | msg='Reminder: meeting at 3pm'");
        sms.render("user=u3 | eventId=E300 | msg='Alert: server down'");
        sms.render("user=u4 | eventId=E400 | msg='Promo: 20% off'");

        // Reuse: requesting again should not create new objects
        Flyweight email2 = factory.getFlyweight("EMAIL");
        System.out.println("Same EMAIL instance reused? " + (email == email2));

        System.out.println("Flyweight cache size = " + factory.cacheSize() + " (expected 2)");
    }
}
