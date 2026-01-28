class Iterator {
    constructor(items) {
        this.items = items;
        this.index = 0;
    }

    hasNext() {
        return this.index < this.items.length;
    }

    next() {
        return this.items[this.index++];
    }
}

class NotificationHistory {
    constructor() {
        this.notifications = [];
    }

    add(notif) {
        this.notifications.push(notif);
    }

    createIterator() {
        return new Iterator(this.notifications);
    }
}

// Demo
console.log("--- Iterator JS ---");
const history = new NotificationHistory();
history.add("Bienvenido");
history.add("Tu pedido salió");
history.add("Alerta de seguridad");

const iterator = history.createIterator();

while (iterator.hasNext()) {
    console.log(iterator.next());
}