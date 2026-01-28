public class Dot implements Shape {
    public final int x, y;

    public Dot(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public void accept(Visitor v) {
        v.visitDot(this);
    }
}
