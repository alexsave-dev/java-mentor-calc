import exception.CalculationException;
import exception.ParsingException;
import expression.Calculator;
import expression.ConsoleHelper;
import expression.Parser;

public class Main {

    public static void main(String[] args) throws ParsingException, CalculationException {
        while (true) {
            ConsoleHelper.writeMessageWithoutNewLine("Please enter the expression: ");
            String expression = ConsoleHelper.readMessage();
            if (expression.equals("exit")) {
                return;
            }

            ConsoleHelper.writeMessage("The result is " + Calculator.calculate(expression));
        }
    }
}
