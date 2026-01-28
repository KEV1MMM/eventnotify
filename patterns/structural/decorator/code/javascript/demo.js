// Decorator in JavaScript (simple functional approach)

class BaseNotifier {
  send(message) {
    console.log(`[Base] Sending notification: ${message}`);
  }
}

class NotifierDecorator {
  constructor(wrappee) {
    this.wrappee = wrappee;
  }
  send(message) {
    this.wrappee.send(message);
  }
}

class EmailDecorator extends NotifierDecorator {
  send(message) {
    super.send(message);
    console.log(`[Email] Also sending EMAIL: ${message}`);
  }
}

class SmsDecorator extends NotifierDecorator {
  send(message) {
    super.send(message);
    console.log(`[SMS] Also sending SMS: ${message}`);
  }
}

const notifier = new SmsDecorator(new EmailDecorator(new BaseNotifier()));
notifier.send("Order #1234 shipped!");

