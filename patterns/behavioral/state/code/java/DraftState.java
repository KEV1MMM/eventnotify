public class DraftState implements NotificationState {
    @Override
    public void next(NotificationContext ctx) {
        System.out.println("--> Enviando notificación...");
        ctx.setState(new SentState());
    }

    @Override
    public void printStatus() {
        System.out.println("[Estado: BORRADOR] - La notificación espera ser enviada.");
    }
}