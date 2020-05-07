package calc.calculator;

public class CalculatorImpl implements Calculator {

    public int increment(int a, int b) {
        return a + b;
    }

    public int decrement(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public void start() {
        new CalcHandler().start();
    }
}
