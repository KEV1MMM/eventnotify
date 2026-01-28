import java.util.HashMap;
import java.util.Map;

class NotificationTemplate implements Cloneable {
    public String channel;
    public String title;
    public String body;

    public NotificationTemplate(String channel, String title, String body) {
        this.channel = channel;
        this.title = title;
        this.body = body;
    }

    @Override
    public NotificationTemplate clone() {
        try {
            // Shallow clone is enough here because fields are immutable Strings
            return (NotificationTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public NotificationTemplate withBody(String newBody) {
        NotificationTemplate c = this.clone();
        c.body = newBody;
        return c;
    }

    @Override
    public String toString() {
        return "Template{channel=" + channel + ", title=" + title + ", body=" + body + "}";
    }
}

class TemplateRegistry {
    private final Map<String, NotificationTemplate> templates = new HashMap<>();

    public void register(String key, NotificationTemplate template) {
        templates.put(key, template);
    }

    public NotificationTemplate createFrom(String key) {
        NotificationTemplate t = templates.get(key);
        if (t == null) throw new IllegalArgumentException("No template for key=" + key);
        return t.clone();
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Prototype Demo ===");

        TemplateRegistry registry = new TemplateRegistry();
        registry.register("reminder", new NotificationTemplate("EMAIL", "Reminder", "Default reminder body"));
        registry.register("alert", new NotificationTemplate("SMS", "Alert", "Default alert body"));

        NotificationTemplate t1 = registry.createFrom("reminder").withBody("Event starts in 10 minutes!");
        NotificationTemplate t2 = registry.createFrom("alert").withBody("System downtime scheduled at 2am.");

        System.out.println(t1);
        System.out.println(t2);
    }
}
