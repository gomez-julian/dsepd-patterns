package decorator.text;

public class ConcreteText extends Text {
    public ConcreteText(String text) {
        super(text);
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
