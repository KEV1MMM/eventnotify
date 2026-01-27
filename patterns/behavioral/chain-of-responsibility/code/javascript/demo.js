class NotificationRequest {
  constructor(userId, message, isSpam, priority) {
    this.userId = userId;
    this.message = message;
    this.isSpam = isSpam;
    this.priority = priority;
  }
}

class AbstractHandler {
  setNext(next) {
    this.next = next;
    return next;
  }

  handle(req) {
    return this.handleNext(req);
  }

  handleNext(req) {
    if (!this.next) return true;
    return this.next.handle(req);
  }
}

class SpamCheckHandler extends AbstractHandler {
  handle(req) {
    if (req.isSpam) {
      console.log(`[SpamCheck] BLOCKED -> user=${req.userId}, msg="${req.message}"`);
      return false;
    }
    console.log("[SpamCheck] OK");
    return this.handleNext(req);
  }
}

class RateLimitHandler extends AbstractHandler {
  handle(req) {
    // Demo simple: prioridad <= 0 simula rate-limit
    if (req.priority <= 0) {
      console.log(`[RateLimit] BLOCKED -> too many requests for user=${req.userId}`);
      return false;
    }
    console.log("[RateLimit] OK");
    return this.handleNext(req);
  }
}

class SendNotificationHandler extends AbstractHandler {
  handle(req) {
    console.log(`[Send] SENT -> user=${req.userId} | priority=${req.priority} | msg="${req.message}"`);
    return true;
  }
}

// Demo: Chain = SpamCheck -> RateLimit -> Send
const spam = new SpamCheckHandler();
const rate = new RateLimitHandler();
const send = new SendNotificationHandler();
spam.setNext(rate).setNext(send);

console.log("=== Case 1: valid notification ===");
console.log("Result:", spam.handle(new NotificationRequest("u123", "Event created: Concert @ 8pm", false, 1)));

console.log("\n=== Case 2: spam blocked ===");
console.log("Result:", spam.handle(new NotificationRequest("u999", "FREE MONEY!!! click now", true, 5)));

console.log("\n=== Case 3: rate limited blocked ===");
console.log("Result:", spam.handle(new NotificationRequest("u123", "Event reminder: Meeting in 10 min", false, 0)));
