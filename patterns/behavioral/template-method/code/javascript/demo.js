class NotificationSender {
  // Template Method (algorithm skeleton)
  sendNotification(userId, message) {
    console.log("\n[Template] Starting notification flow...");
    if (!this.validate(userId, message)) {
      console.log("[Template] Validation failed");
      return;
    }
    const payload = this.format(userId, message);
    this.send(payload);
    console.log("[Template] Done");
  }

  validate(userId, message) {
    return typeof userId === "string" && userId.trim() !== "" &&
           typeof message === "string" && message.trim() !== "";
  }

  // Steps to override
  format(userId, message) {
    throw new Error("format() must be implemented by subclass");
  }

  send(payload) {
    throw new Error("send() must be implemented by subclass");
  }
}

class EmailSender extends NotificationSender {
  format(userId, message) {
    return `[EMAIL to=${userId}] ${message}`;
  }

  send(payload) {
    console.log("[EmailSender] Sending ->", payload);
  }
}

class SmsSender extends NotificationSender {
  format(userId, message) {
    return `[SMS to=${userId}] ${message}`;
  }

  send(payload) {
    console.log("[SmsSender] Sending ->", payload);
  }
}

// Demo
console.log("=== Template Method Demo ===");

const email = new EmailSender();
const sms = new SmsSender();

email.sendNotification("u123", "Event reminder: Team meeting at 3pm");
sms.sendNotification("u456", "Alert: Event starts in 10 minutes");

// invalid example
email.sendNotification("", "This should fail");
