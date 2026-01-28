class RealImage {
  constructor(filename) {
    this.filename = filename;
    this.loadFromDisk();
  }
  loadFromDisk() {
    console.log(`[RealImage] Loading '${this.filename}' from disk...`);
  }
  display() {
    console.log(`[RealImage] Displaying '${this.filename}'`);
  }
}

class ProxyImage {
  constructor(filename) {
    this.filename = filename;
    this.realImage = null;
  }
  display() {
    if (!this.realImage) {
      console.log("[ProxyImage] Creating RealImage (lazy loading)...");
      this.realImage = new RealImage(this.filename);
    } else {
      console.log("[ProxyImage] Reusing cached RealImage...");
    }
    this.realImage.display();
  }
}

console.log("=== Proxy Pattern (JavaScript) ===");
const image = new ProxyImage("photo.png");

console.log("\nFirst call:");
image.display();

