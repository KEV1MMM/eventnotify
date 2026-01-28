public class NotificationHistory implements Container {
    public String notifications[] = {"Login Exitoso", "Pago Recibido", "Nueva Amistad", "Error 404"};

    @Override
    public Iterator getIterator() {
        return new HistoryIterator();
    }

    // Clase interna que sabe cómo recorrer el array
    private class HistoryIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < notifications.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return notifications[index++];
            }
            return null;
        }
    }
}