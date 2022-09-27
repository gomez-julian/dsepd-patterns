package decorator.polynomial;

import java.util.Vector;

public class ConcretePolynomialEquation extends AbstractPolynomial{
    @Override
    public Vector<Term> evaluate() {
        return this.getTerms();
    }
}
