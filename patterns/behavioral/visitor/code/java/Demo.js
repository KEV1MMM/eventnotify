public class Demo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
            new Dot(2, 3),
            new Circle(10, 10, 5),
            new Rectangle(7, 4)
        };

        Visitor visitor = new JsonExportVisitor();

        System.out.println("Visitor exporting shapes to JSON-like output:");
        for (Shape s : shapes) s.accept(visitor);
    }
}
