package decorator.processor.text;

public class ColorDecorator extends Decorator{

    private ConsoleColors selectedColor;

    public ColorDecorator(Text text, ConsoleColors colorOption) {
        super(text);
        this.selectedColor = colorOption;
    }

    @Override
    public String getText(){
            return  selectedColor + this.text + ConsoleColors.RESET;
    }

    @Override
    public void setText(String text) {

    }

    public void setSelectedColor(ConsoleColors selectedColor) {
        this.selectedColor = selectedColor;
    }

}
