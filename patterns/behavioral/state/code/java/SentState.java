public class SentState implements NotificationState {
    @Override
    public void next(NotificationContext ctx) {
        System.out.println("--> Confirmando entrega...");
        ctx.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("[Estado: ENVIADO] - Notificación en camino.");
    }
}