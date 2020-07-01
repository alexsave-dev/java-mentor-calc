package expression;

import exception.ParsingException;

/**
 * The {@code Parser} class to validate the arithmetic expression
 * and populate internal class fields to be used for the calculation itself.
 */
public class Parser {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 10;
    private String firstOperand;
    private String secondOperand;
    private boolean isArabicOperands;
    private ArithmeticOperation arithmeticOperation;

    public String getFirstOperand() {
        return firstOperand;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public boolean isArabicOperands() {
        return isArabicOperands;
    }

    public ArithmeticOperation getArithmeticOperation() {
        return arithmeticOperation;
    }

    public void parse(String expression) throws ParsingException {
        if (expression == null) {
            throw new ParsingException("Expression cannot be null");
        }

        expression = expression.replaceAll("\\s", "");
        if (expression.length() == 0) {
            throw new ParsingException("Empty Expression");
        }

        try {
            for (int i = 0; i < expression.length() - 1; i++) {
                for (ArithmeticOperation arithmeticOperationItem : ArithmeticOperation.values()) {
                    if (arithmeticOperationItem.getSign().equals(expression.substring(i, i + 1))) {
                        arithmeticOperation = arithmeticOperationItem;
                        firstOperand = expression.substring(0, i);
                        secondOperand = expression.substring(i + 1);
                        break;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new ParsingException("Incorrect Expression");
        }

        if (arithmeticOperation == null) {
            throw new ParsingException("Incorrect Expression");
        }

        if (firstOperand.matches("\\d{1,2}")) {
            if (secondOperand.matches("\\d{1,2}")) {
                isArabicOperands = true;
            } else {
                throw new ParsingException("Incorrect Expression");
            }
        } else {
            try {
                firstOperand = RomanArabicConverter.romanToArabic(firstOperand);
                secondOperand = RomanArabicConverter.romanToArabic(secondOperand);
                isArabicOperands = false;
            } catch (IllegalArgumentException e) {
                throw new ParsingException("Incorrect Expression");
            }
        }

        if (Integer.parseInt(firstOperand) < MIN_NUMBER || Integer.parseInt(firstOperand) > MAX_NUMBER
            || Integer.parseInt(secondOperand) < MIN_NUMBER || Integer.parseInt(secondOperand) > MAX_NUMBER) {
            throw new ParsingException("Operands must be in the range " + MIN_NUMBER + " - " + MAX_NUMBER);
        }
    }
}
