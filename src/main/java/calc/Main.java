package calc;

import calc.calculator.Calculator;
import calc.calculator.CalculatorImpl;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        calculator.start();

    }
}
