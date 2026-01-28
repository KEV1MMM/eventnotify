public class JsonExportVisitor implements Visitor {
    @Override
    public void visitDot(Dot d) {
        System.out.println("{\"type\":\"dot\",\"x\":" + d.x + ",\"y\":" + d.y + "}");
    }

    @Override
    public void visitCircle(Circle c) {
        System.out.println("{\"type\":\"circle\",\"x\":" + c.x + ",\"y\":" + c.y + ",\"r\":" + c.r + "}");
    }

    @Override
    public void visitRectangle(Rectangle r) {
        System.out.println("{\"type\":\"rectangle\",\"w\":" + r.w + ",\"h\":" + r.h + "}");
    }
}
