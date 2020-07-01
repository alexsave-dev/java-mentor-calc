package expression;

/**
 * The {@code ArithmeticOperation} enum to store possible arithmetic operands
 */
public enum ArithmeticOperation {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    ArithmeticOperation(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
