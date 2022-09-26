package decorator.processor.text;

public abstract class Text {
    protected String text;

    public abstract  String getText();
    public abstract void setText(String text);
    public Text(String text){
        this.text = text;
    }
}
