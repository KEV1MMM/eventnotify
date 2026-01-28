public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Iterator Pattern Demo ---");
        
        NotificationHistory history = new NotificationHistory();

        // Usamos el iterador para recorrer sin saber que por dentro es un Array
        for(Iterator iter = history.getIterator(); iter.hasNext();){
            String notif = (String)iter.next();
            System.out.println("Notificación: " + notif);
        }
    }
}