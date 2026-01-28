class Colleague {
  constructor(mediator) {
    this.mediator = mediator;
  }

  send(event, data) {
    this.mediator.notify(this, event, data);
  }

  receive(message) {
    console.log(`${this.constructor.name} received -> ${message}`);
  }
}

class EmailService extends Colleague {
  requestSendEmail(userId, message) {
    this.send("EMAIL", `user=${userId} msg="${message}"`);
  }
}

class SmsService extends Colleague {
  requestSendSms(userId, message) {
    this.send("SMS", `user=${userId} msg="${message}"`);
  }
}

class PushService extends Colleague {
  requestSendPush(userId, message) {
    this.send("PUSH", `user=${userId} msg="${message}"`);
  }
}

class NotificationHub {
  setEmail(email) { this.email = email; }
  setSms(sms) { this.sms = sms; }
  setPush(push) { this.push = push; }

  notify(sender, event, data) {
    console.log(`\n[Hub] Event=${event} from ${sender.constructor.name}`);

    switch (event) {
      case "EMAIL":
        console.log("[Hub] Routing to Email gateway ->", data);
        break;
      case "SMS":
        console.log("[Hub] Routing to SMS gateway ->", data);
        break;
      case "PUSH":
        console.log("[Hub] Routing to Push gateway ->", data);
        break;
      default:
        console.log("[Hub] Unknown event ->", data);
    }

    // Notify other colleagues (coordination)
    if (sender !== this.email && this.email) this.email.receive(`Hub observed ${event}`);
    if (sender !== this.sms && this.sms) this.sms.receive(`Hub observed ${event}`);
    if (sender !== this.push && this.push) this.push.receive(`Hub observed ${event}`);
  }
}

// Demo
console.log("=== Mediator Demo ===");

const hub = new NotificationHub();
const email = new EmailService(hub);
const sms = new SmsService(hub);
const push = new PushService(hub);

hub.setEmail(email);
hub.setSms(sms);
hub.setPush(push);

email.requestSendEmail("u123", "Event created: Concert @ 8pm");
sms.requestSendSms("u456", "Reminder: Meeting in 10 minutes");
push.requestSendPush("u789", "Alert: Server downtime scheduled");
