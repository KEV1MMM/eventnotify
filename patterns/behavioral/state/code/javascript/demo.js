class Notification {
    constructor() {
        this.state = "DRAFT";
    }

    next() {
        if (this.state === "DRAFT") {
            console.log("--> Enviando...");
            this.state = "SENT";
        } else if (this.state === "SENT") {
            console.log("--> Confirmando recepción...");
            this.state = "DELIVERED";
        } else {
            console.log("--> Error: Ya está finalizada.");
        }
    }

    status() {
        console.log(`[Estado Actual: ${this.state}]`);
    }
}

// Ejecución
console.log("--- State Pattern JS ---");
const notif = new Notification();

notif.status();
notif.next();
notif.status();
notif.next();
notif.status();