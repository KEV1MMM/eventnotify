import java.util.ArrayList;
import java.util.List;

class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("State set to: " + state);
    }

    public Memento save() {
        System.out.println("Saving state...");
        return new Memento(state);
    }

    public void restore(Memento memento) {
        this.state = memento.getState();
        System.out.println("State restored to: " + state);
    }
}

class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    public void add(Memento memento) {
        history.add(memento);
    }

    public Memento get(int index) {
        return history.get(index);
    }
}

public class Demo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("Draft");
        caretaker.add(originator.save());

        originator.setState("Reviewed");
        caretaker.add(originator.save());

        originator.setState("Published");

        originator.restore(caretaker.get(0));
        originator.restore(caretaker.get(1));
    }
}
