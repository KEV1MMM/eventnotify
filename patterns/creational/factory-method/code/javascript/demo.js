class Dot {
  accept(v) { v.visitDot(this); }
}
class Circle {
  accept(v) { v.visitCircle(this); }
}

class JsonVisitor {
  visitDot() { console.log("{dot}"); }
  visitCircle() { console.log("{circle}"); }
}

const shapes = [new Dot(), new Circle()];
const v = new JsonVisitor();
shapes.forEach(s => s.accept(v));
