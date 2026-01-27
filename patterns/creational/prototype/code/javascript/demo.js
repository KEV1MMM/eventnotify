class NotificationTemplate {
  constructor(channel, title, body) {
    this.channel = channel;
    this.title = title;
    this.body = body;
  }

  clone() {
    // Copy is enough because fields are primitive/strings
    return new NotificationTemplate(this.channel, this.title, this.body);
  }

  withBody(newBody) {
    const c = this.clone();
    c.body = newBody;
    return c;
  }

  toString() {
    return `Template{channel=${this.channel}, title=${this.title}, body=${this.body}}`;
  }
}

class TemplateRegistry {
  constructor() {
    this.templates = new Map();
  }

  register(key, template) {
    this.templates.set(key, template);
  }

  createFrom(key) {
    const t = this.templates.get(key);
    if (!t) throw new Error(`No template for key=${key}`);
    return t.clone();
  }
}

// Demo
console.log("=== Prototype Demo ===");

const registry = new TemplateRegistry();
registry.register("reminder", new NotificationTemplate("EMAIL", "Reminder", "Default reminder body"));
registry.register("alert", new NotificationTemplate("SMS", "Alert", "Default alert body"));

const t1 = registry.createFrom("reminder").withBody("Event starts in 10 minutes!");
const t2 = registry.createFrom("alert").withBody("System downtime scheduled at 2am.");

console.log(t1.toString());
console.log(t2.toString());
