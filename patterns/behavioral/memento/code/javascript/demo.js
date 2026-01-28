class Memento {
  constructor(state) {
    this.state = state;
  }

  getState() {
    return this.state;
  }
}

class Originator {
  setState(state) {
    this.state = state;
    console.log("State set to:", state);
  }

  save() {
    console.log("Saving state...");
    return new Memento(this.state);
  }

  restore(memento) {
    this.state = memento.getState();
    console.log("State restored to:", this.state);
  }
}

class Caretaker {
  constructor() {
    this.history = [];
  }

  add(memento) {
    this.history.push(memento);
  }

  get(index) {
    return this.history[index];
  }
}

// Demo
const originator = new Originator();
const caretaker = new Caretaker();

originator.setState("Draft");
caretaker.add(originator.save());

originator.setState("Reviewed");
caretaker.add(originator.save());

originator.setState("Published");

originator.restore(caretaker.get(0));
originator.restore(caretaker.get(1));
