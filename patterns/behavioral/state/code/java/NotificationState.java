public interface NotificationState {
    void next(NotificationContext ctx);
    void printStatus();
}