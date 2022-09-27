package decorator.polynomial;

//TODO: REMOVE isPositive VALUE BECAUSE ITS REDUNDANT
public class Term {
    private int coefficient, exponent;
    private boolean positive;

    public Term(int coefficient, int exponent, boolean positive) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.positive = positive;
    }

    public Term(Term term){
        this.coefficient = term.getCoefficient();
        this.exponent = term.getExponent();
        this.positive = term.isPositive();
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public boolean isPositive() {
        return positive;
    }
}
