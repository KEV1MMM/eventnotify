public class Circle implements Shape {
    public final int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x; this.y = y; this.r = r;
    }

    @Override
    public void accept(Visitor v) {
        v.visitCircle(this);
    }
}
