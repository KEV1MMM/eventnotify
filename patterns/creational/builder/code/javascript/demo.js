class Notification {
    constructor(builder) {
        this.recipient = builder.recipient;
        this.message = builder.message;
        this.channel = builder.channel;
    }

    toString() {
        return `Notification -> To: ${this.recipient} | Msg: ${this.message} | Via: ${this.channel}`;
    }
}

class NotificationBuilder {
    constructor() {
        this.recipient = "";
        this.message = "";
        this.channel = "Email"; // Default
    }

    setRecipient(recipient) {
        this.recipient = recipient;
        return this; // Retornamos 'this' para encadenar métodos
    }

    setMessage(message) {
        this.message = message;
        return this;
    }

    setChannel(channel) {
        this.channel = channel;
        return this;
    }

    build() {
        return new Notification(this);
    }
}

// Ejecución
console.log("--- Builder Pattern JS Demo ---");

const myNotif = new NotificationBuilder()
    .setRecipient("juan@gmail.com")
    .setMessage("Tu pedido ha llegado")
    .setChannel("Push Notification")
    .build();

console.log(myNotif.toString());