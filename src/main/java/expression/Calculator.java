package expression;

import exception.CalculationException;
import exception.ParsingException;

/**
 * The {@code Calculator} class to calculate the result for operands
 * and the operator taken from the parser.
 */
public class Calculator {

    public static String calculate(String expression) throws CalculationException, ParsingException {

        Parser parser = new Parser();
        parser.parse(expression);

        int result;
        int firstOperand = Integer.parseInt(parser.getFirstOperand());
        int secondOperand = Integer.parseInt(parser.getSecondOperand());
        switch (parser.getArithmeticOperation()) {
            case PLUS:
                result = firstOperand + secondOperand;
                break;
            case MINUS:
                result = firstOperand - secondOperand;
                break;
            case MULTIPLY:
                result = firstOperand * secondOperand;
                break;
            case DIVIDE:
                result = firstOperand / secondOperand;
                break;
            default:
                throw new CalculationException("Incorrect operator");
        }

        if (parser.isArabicOperands()) {
            return String.valueOf(result);
        } else {
            if (result < 1) {
                throw new CalculationException("The result for Roman numbers must be greater than 0");
            }
            return RomanArabicConverter.arabicToRoman(result);
        }
    }
}
