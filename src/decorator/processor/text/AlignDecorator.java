package decorator.processor.text;


public class AlignDecorator extends Decorator{

    private char alignOption;

    public AlignDecorator(Text text, char alignOption) {
        super(text);
        this.alignOption = alignOption;
    }

    @Override
    public String getText() {
        int lineSize = 80;
        int spacesCount = 0;
        String tabulation = new String();
        String formatedText = new String();
        final String edge = "||";

        spacesCount = (lineSize - this.text.length()) / 2;
        for(int i=0; i<spacesCount; i++)
            tabulation +=" ";

        switch (Character.toUpperCase(alignOption)){
            case 'C':
                formatedText = edge + tabulation + this.text + tabulation + edge;
                break;
            case 'L':
                formatedText = edge + this.text + tabulation + tabulation + edge;
                break;
            case 'R':
                formatedText = edge + tabulation + tabulation + this.text + edge;
                break;
            default:
                formatedText = this.text;
        }

        return formatedText;

    }

    @Override
    public void setText(String text) {

    }
}
