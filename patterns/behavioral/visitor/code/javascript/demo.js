class Dot {
  constructor(x, y) { this.x = x; this.y = y; }
  accept(v) { v.visitDot(this); }
}
class Circle {
  constructor(x, y, r) { this.x = x; this.y = y; this.r = r; }
  accept(v) { v.visitCircle(this); }
}
class Rectangle {
  constructor(w, h) { this.w = w; this.h = h; }
  accept(v) { v.visitRectangle(this); }
}

class JsonExportVisitor {
  visitDot(d) { console.log(JSON.stringify({ type: "dot", x: d.x, y: d.y })); }
  visitCircle(c) { console.log(JSON.stringify({ type: "circle", x: c.x, y: c.y, r: c.r })); }
  visitRectangle(r) { console.log(JSON.stringify({ type: "rectangle", w: r.w, h: r.h })); }
}

const shapes = [new Dot(2,3), new Circle(10,10,5), new Rectangle(7,4)];
const v = new JsonExportVisitor();

console.log("Visitor exporting shapes to JSON-like output:");
for (const s of shapes) s.accept(v);
