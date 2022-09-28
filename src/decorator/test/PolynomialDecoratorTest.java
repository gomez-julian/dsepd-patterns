package decorator.test;

import decorator.polynomial.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PolynomialDecoratorTest {

    private ConcretePolynomialEquation generateRandomFullPolynomial(int maxExponent){
        ConcretePolynomialEquation polynomial = new ConcretePolynomialEquation();

        for(int i=0; i<maxExponent + 1; i++)
            polynomial.addTerm(new Term((int) (Math.random()*(21)-10), i));
        return  polynomial;
    }

    @Test
    public void testPolynomialRepresentation(){
        AbstractPolynomial polynomial = generateRandomFullPolynomial(9);
        System.out.println("Polynomial: " + polynomial);
    }

    @Test
    public void testPolynomialDerivative(){
        AbstractPolynomial polynomial = generateRandomFullPolynomial(5);

        System.out.println("Without deriving:  " + polynomial);
        polynomial = new ConcreteDecoratorDerivative(polynomial);
        System.out.println("First derivative:  " + polynomial);
        polynomial = new ConcreteDecoratorDerivative(polynomial);
        System.out.println("Second derivative: " + polynomial);
    }

    @Test
    public void testPolynomialSimplification(){
        AbstractPolynomial polynomial = generateRandomFullPolynomial(5);

        for(int i=0; i<5 + 1; i++)
            polynomial.addTerm(new Term((int)(Math.random()*9) + 1, i));

        System.out.println("Polynomial before: " + polynomial);
        polynomial = new ConcreteDecoratorSimplifier(polynomial);
        System.out.println("Polynomial after:  " + polynomial);
    }

    @Test
    public void testResolutionDecorator(){
        AbstractPolynomial polynomial = new ConcretePolynomialEquation();
        polynomial.addTerm(new Term(1,2));
        polynomial.addTerm(new Term(2,1));
        polynomial.addTerm(new Term(-8,0));
        polynomial = new ConcreteDecoratorResolution(polynomial);
    }
}
