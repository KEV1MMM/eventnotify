interface Mediator {
    void notify(Colleague sender, String event, String data);
}

abstract class Colleague {
    protected final Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String event, String data) {
        mediator.notify(this, event, data);
    }

    public void receive(String message) {
        System.out.println(getClass().getSimpleName() + " received -> " + message);
    }
}

class EmailService extends Colleague {
    public EmailService(Mediator mediator) { super(mediator); }

    public void requestSendEmail(String userId, String message) {
        send("EMAIL", "user=" + userId + " msg=\"" + message + "\"");
    }
}

class SmsService extends Colleague {
    public SmsService(Mediator mediator) { super(mediator); }

    public void requestSendSms(String userId, String message) {
        send("SMS", "user=" + userId + " msg=\"" + message + "\"");
    }
}

class PushService extends Colleague {
    public PushService(Mediator mediator) { super(mediator); }

    public void requestSendPush(String userId, String message) {
        send("PUSH", "user=" + userId + " msg=\"" + message + "\"");
    }
}

class NotificationHub implements Mediator {
    private EmailService email;
    private SmsService sms;
    private PushService push;

    public void setEmail(EmailService email) { this.email = email; }
    public void setSms(SmsService sms) { this.sms = sms; }
    public void setPush(PushService push) { this.push = push; }

    @Override
    public void notify(Colleague sender, String event, String data) {
        System.out.println("\n[Hub] Event=" + event + " from " + sender.getClass().getSimpleName());
        // The mediator centralizes routing/coordination:
        switch (event) {
            case "EMAIL" -> System.out.println("[Hub] Routing to Email gateway -> " + data);
            case "SMS" -> System.out.println("[Hub] Routing to SMS gateway -> " + data);
            case "PUSH" -> System.out.println("[Hub] Routing to Push gateway -> " + data);
            default -> System.out.println("[Hub] Unknown event -> " + data);
        }

        // Optional: notify other colleagues (shows coordination)
        if (sender != email && email != null) email.receive("Hub observed " + event);
        if (sender != sms && sms != null) sms.receive("Hub observed " + event);
        if (sender != push && push != null) push.receive("Hub observed " + event);
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Mediator Demo ===");

        NotificationHub hub = new NotificationHub();
        EmailService email = new EmailService(hub);
        SmsService sms = new SmsService(hub);
        PushService push = new PushService(hub);

        hub.setEmail(email);
        hub.setSms(sms);
        hub.setPush(push);

        email.requestSendEmail("u123", "Event created: Concert @ 8pm");
        sms.requestSendSms("u456", "Reminder: Meeting in 10 minutes");
        push.requestSendPush("u789", "Alert: Server downtime scheduled");
    }
}
