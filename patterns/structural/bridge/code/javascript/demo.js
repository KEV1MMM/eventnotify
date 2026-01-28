// Implementor
class EmailChannel {
    send(msg) {
        console.log(`Email: ${msg}`);
    }
}

class SMSChannel {
    send(msg) {
        console.log(`SMS: ${msg}`);
    }
}

// Abstraction
class Notification {
    constructor(channel) {
        this.channel = channel;
    }
    
    notify(message) {
        // Delegamos el trabajo al canal (Bridge)
        this.channel.send(message);
    }
}

// Refined Abstraction
class UrgentNotification extends Notification {
    notify(message) {
        console.log(">>> URGENTE <<<");
        super.notify(message.toUpperCase());
    }
}

// Demo
console.log("--- Bridge JS ---");
const email = new EmailChannel();
const sms = new SMSChannel();

const notif1 = new UrgentNotification(email);
notif1.notify("Error crítico");

const notif2 = new UrgentNotification(sms);
notif2.notify("Batería baja");