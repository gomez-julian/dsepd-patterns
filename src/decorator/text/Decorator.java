package decorator.text;

public abstract class Decorator extends Text{
    protected Text iText;

    public Decorator(Text text) {
        super(text.getText());
        iText = text;
    }

    @Override
    public String getText(){
        return this.iText.getText();
    }
}
