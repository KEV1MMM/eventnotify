public class NotificationContext {
    private NotificationState state;

    public NotificationContext() {
        // Estado inicial
        this.state = new DraftState();
    }

    public void setState(NotificationState state) {
        this.state = state;
    }

    public NotificationState getState() {
        return state;
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}