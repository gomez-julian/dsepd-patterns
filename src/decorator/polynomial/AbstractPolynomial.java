package decorator.polynomial;

import java.util.Vector;

public abstract class AbstractPolynomial {
    private Vector<Term> terms;

    protected AbstractPolynomial(){
        this.terms = new Vector<>();
    }

    protected AbstractPolynomial(Vector<Term> terms){
        this.terms = terms;
    }

    public void addTerm(Term term){
        this.terms.add(term);
    }

    public abstract Vector<Term> evaluate();

    public Vector<Term> getTerms() {
        return terms;
    }

    public void setTerms(Vector<Term> terms) {
        this.terms = terms;
    }

    @Override
    public String toString(){
        String string = "";
        for(Term term: terms) {
            String sign = (term.getCoefficient() >= 0) ? " +" : " -";
            if(term.getExponent() == 0)
                string = string
                        + sign
                        + Math.abs(term.getCoefficient());
            else
                string = string
                        + sign
                        + Math.abs(term.getCoefficient())
                        + "x"
                        + getExponentString(term.getExponent());
        }
        return string;
    }

    private String getExponentString(int exponent){
        return
                switch (exponent){
                    case 2 -> "\u00B2";
                    case 3 -> "\u00B3";
                    case 4 -> "\u2074";
                    case 5 -> "\u2075";
                    case 6 -> "\u2076";
                    case 7 -> "\u2077";
                    case 8 -> "\u2078";
                    case 9 -> "\u2079";
                    case 0 -> "\u2070";
                    default -> "";
                };

    }
}
