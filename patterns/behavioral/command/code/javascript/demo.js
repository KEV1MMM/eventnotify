class Light {
  constructor(location) { this.location = location; }
  on() { console.log(`[Light] ${this.location} -> ON`); }
  off() { console.log(`[Light] ${this.location} -> OFF`); }
}

class LightOnCommand {
  constructor(light) { this.light = light; }
  execute() { this.light.on(); }
}

class LightOffCommand {
  constructor(light) { this.light = light; }
  execute() { this.light.off(); }
}

class RemoteControl {
  setCommand(cmd) { this.cmd = cmd; }
  pressButton() {
    if (!this.cmd) return console.log("[RemoteControl] No command set.");
    console.log("[RemoteControl] Executing command...");
    this.cmd.execute();
  }
}

(function main() {
  const light = new Light("Living Room");
  const remote = new RemoteControl();

  remote.setCommand(new LightOnCommand(light));
  remote.pressButton();

  remote.setCommand(new LightOffCommand(light));
  remote.pressButton();

  console.log("[Demo] Command pattern executed successfully.");
})();

