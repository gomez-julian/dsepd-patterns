package decorator.test;

import decorator.processor.text.*;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void simpleIntegrationTest(){
        Text textComponent = new ConcreteText("New concrete text.");
        System.out.println("Text: " + textComponent.getText());
        textComponent = new AlignDecorator(textComponent, 'C');
        System.out.println("Text: " + textComponent.getText());
    }

    @Test
    public void alignOptionsText(){
        Text textComponent = new ConcreteText("Aling options test.");
        Text leftText = new AlignDecorator(textComponent, 'L');
        Text centerText = new AlignDecorator(textComponent, 'C');
        Text rightText = new AlignDecorator(textComponent, 'R');
        Text defaultText = new AlignDecorator(textComponent, 'X');

        System.out.println("Left:    " + leftText.getText());
        System.out.println("Center:  " + centerText.getText());
        System.out.println("Right:   " + rightText.getText());
        System.out.println("Default: " + defaultText.getText());
    }

    @Test
    public void colorDecoratorTest(){
        Text textComponent = new ConcreteText("Your life need more colors.");
        textComponent = new ColorDecorator(textComponent, ConsoleColors.RED);
        System.out.println("Text: " + textComponent.getText());
        ((ColorDecorator) textComponent).setSelectedColor(ConsoleColors.CYAN);
        System.out.println("Text: " + textComponent.getText());
    }
}
