package decorator.polynomial;

import java.util.Vector;

public class ConcreteDecoratorResolution extends AbstractDecoratorPolynomial {

    public ConcreteDecoratorResolution(AbstractPolynomial polynomial) {
        super(polynomial);
        this.evaluate();
    }

    @Override
    public Vector<Term> evaluate() {
        throw new UnsupportedOperationException("Polynomial resolution is too hard for me (for the moment).");
    }
}
