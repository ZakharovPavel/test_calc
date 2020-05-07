package calc.calculator;

import calc.exception.CalculationException;
import calc.roman_numerals.RomanArabicConverter;

import java.util.Scanner;

public class CalcHandler extends CalculatorImpl {

    private final String ROMAN_REGEX = "(.*)[IVXLCDM](.*)";

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String example = scanner.nextLine();
            String[] tokens = example.split(" ");

            try {
                checkExamplesSize(tokens);
            } catch (CalculationException e) {
                e.printStackTrace();
                break;
            }

            boolean exampleIsRoman = false;
            int a, b;
            int result = 0;

            if (tokens[0].matches(ROMAN_REGEX) && tokens[2].matches(ROMAN_REGEX)) {
                a = RomanArabicConverter.romanToArabic(tokens[0]);
                b = RomanArabicConverter.romanToArabic(tokens[2]);
                exampleIsRoman = true;
            } else {
                try {
                    checkCompatible(tokens[0], tokens[2]);
                } catch (CalculationException e) {
                    e.printStackTrace();
                    break;
                }
                a = Integer.parseInt(tokens[0]);
                b = Integer.parseInt(tokens[2]);
            }

            try {
                checkRange(a, b);
            } catch (CalculationException e) {
                e.printStackTrace();
                break;
            }

            switch (tokens[1]) {
                case ("+"):
                    result = increment(a, b);
                    break;
                case ("-"):
                    result = decrement(a, b);
                    break;
                case ("*"):
                    result = multiplication(a, b);
                    break;
                case ("/"):
                    result = division(a, b);
                    break;
                default:
                    break;
            }

            if (exampleIsRoman) {
                System.out.println(RomanArabicConverter.arabicToRoman(result));
            } else {
                System.out.println(result);
            }
        }
    }

    private void checkCompatible(String a, String b) throws CalculationException {
        if ((a.matches(ROMAN_REGEX) && !b.matches(ROMAN_REGEX)) || (!a.matches(ROMAN_REGEX) && b.matches(ROMAN_REGEX))) {
            throw new CalculationException("Different types of input numerals");
        }
    }

    private void checkRange(int a, int b) throws CalculationException {
        if ((a < 1 || b < 1) || (a > 10 || b > 10)) {
            throw new CalculationException("Input number out of range 1-10");
        }
    }

    private void checkExamplesSize(String[] arr) throws CalculationException {
        if (arr.length > 0 && arr.length < 3) {
            throw new CalculationException("Not enough arguments");
        } else if (arr.length > 3) {
            throw new CalculationException("Too many arguments");
        }
    }

}
