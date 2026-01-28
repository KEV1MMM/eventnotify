// Flyweight: shared (intrinsic) state = channel
class NotificationType {
  constructor(channel) {
    this.channel = channel;
  }

  render(extrinsicState) {
    console.log(`[Flyweight] channel=${this.channel} | ${extrinsicState}`);
  }
}

// Flyweight Factory: reuses flyweights by key (channel)
class FlyweightFactory {
  constructor() {
    this.flyweights = new Map();
  }

  getFlyweight(channel) {
    if (!this.flyweights.has(channel)) {
      this.flyweights.set(channel, new NotificationType(channel));
    }
    return this.flyweights.get(channel);
  }

  cacheSize() {
    return this.flyweights.size;
  }
}

// Demo
console.log("=== Flyweight Demo ===");
const factory = new FlyweightFactory();

// Extrinsic state changes per notification
const email = factory.getFlyweight("EMAIL");
const sms = factory.getFlyweight("SMS");

email.render("user=u1 | eventId=E100 | msg='Event created'");
email.render("user=u2 | eventId=E200 | msg='Reminder: meeting at 3pm'");
sms.render("user=u3 | eventId=E300 | msg='Alert: server down'");
sms.render("user=u4 | eventId=E400 | msg='Promo: 20% off'");

// Reuse check
const email2 = factory.getFlyweight("EMAIL");
console.log("Same EMAIL instance reused?", email === email2);

console.log("Flyweight cache size =", factory.cacheSize(), "(expected 2)");
