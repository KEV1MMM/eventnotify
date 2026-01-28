public class Rectangle implements Shape {
    public final int w, h;

    public Rectangle(int w, int h) {
        this.w = w; this.h = h;
    }

    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
}
