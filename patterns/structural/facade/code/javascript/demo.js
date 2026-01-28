class Validator {
  isValid(userId, message) {
    return typeof userId === "string" && userId.trim() !== "" &&
           typeof message === "string" && message.trim() !== "";
  }
}

class Formatter {
  format(userId, message) {
    return `[To=${userId}] ${message}`;
  }
}

class Sender {
  send(payload) {
    console.log("[Sender] Sending ->", payload);
  }
}

// Facade
class NotificationFacade {
  constructor() {
    this.validator = new Validator();
    this.formatter = new Formatter();
    this.sender = new Sender();
  }

  sendNotification(userId, message) {
    console.log("\n[Facade] New request");
    if (!this.validator.isValid(userId, message)) {
      console.log("[Facade] Invalid notification request");
      return;
    }
    const payload = this.formatter.format(userId, message);
    this.sender.send(payload);
  }
}

// Demo
console.log("=== Facade Demo ===");

const facade = new NotificationFacade();
facade.sendNotification("u123", "Event reminder: Team meeting at 3pm");
facade.sendNotification("", "This should fail");
