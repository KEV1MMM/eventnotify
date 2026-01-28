public class demo {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println("Same instance? " + (db1 == db2));
        db1.query("SELECT * FROM users;");
    }
}
