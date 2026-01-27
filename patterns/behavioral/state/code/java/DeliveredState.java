public class DeliveredState implements NotificationState {
    @Override
    public void next(NotificationContext ctx) {
        System.out.println("--> ¡La notificación ya finalizó! No hay más estados.");
    }

    @Override
    public void printStatus() {
        System.out.println("[Estado: ENTREGADO] - Proceso terminado exitosamente.");
    }
}