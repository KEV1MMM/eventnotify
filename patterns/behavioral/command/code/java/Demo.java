public class Demo {

    interface Command {
        void execute();
    }

    static class Light {
        private final String location;
        Light(String location) { this.location = location; }
        void on() { System.out.println("[Light] " + location + " -> ON"); }
        void off() { System.out.println("[Light] " + location + " -> OFF"); }
    }

    static class LightOnCommand implements Command {
        private final Light light;
        LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.on(); }
    }

    static class LightOffCommand implements Command {
        private final Light light;
        LightOffCommand(Light light) { this.light = light; }
        public void execute() { light.off(); }
    }

    static class RemoteControl {
        private Command slot;
        void setCommand(Command cmd) { this.slot = cmd; }
        void pressButton() {
            if (slot == null) {
                System.out.println("[RemoteControl] No command set.");
                return;
            }
            System.out.println("[RemoteControl] Executing command...");
            slot.execute();
        }
    }

    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Command on = new LightOnCommand(livingRoomLight);
        Command off = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(on);
        remote.pressButton();
        remote.setCommand(off);
        remote.pressButton();

        System.out.println("[Demo] Command pattern executed successfully.");
    }
}

