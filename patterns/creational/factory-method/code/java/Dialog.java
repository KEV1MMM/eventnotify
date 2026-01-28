public abstract class Dialog {
    public abstract Button createButton();
    public void render() {
        createButton().render();
    }
}
