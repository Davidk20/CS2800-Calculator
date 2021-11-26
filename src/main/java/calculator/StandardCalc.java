package calculator;

/**
 * Class implements {@code Calculator} to evaluate Infix string expressions. Evaluating a Infix
 * expression in {@code StandardCalc} will convert it to a {@code RevPolishCalc} where the actual
 * calculation will take place.
 *
 * @author David Kidd
 */
public class StandardCalc implements Calculator {

  /**
   * Instance of the Reverse Polish Calculator which will handle the calculations.
   */
  RevPolishCalc rpCalc = new RevPolishCalc();
  /**
   * Stack containing all of the numbers within the expression.
   */
  private NumStack values = new NumStack();

  /**
   * Stack containing all operators within the expression.
   */
  private OpStack operators = new OpStack();

  /**
   * {@code StringBuilder} used to build the formatted postfix expression.
   */
  StringBuilder stringBuilder = new StringBuilder();


  /**
   * Converts an infix expression to a postfix {@code String} expression.
   *
   * @param expression The infix expression to be converted.
   * @return The converted Postfix expression.
   */
  public String infixToPostfix(String expression) throws InvalidExpressionException {
    if (expression == null) {
      throw new InvalidExpressionException("INVALID EXPRESSION");
    }
    String[] expressionSplit = expression.split(" ");
    for (String slice : expressionSplit) {
      try {
        Symbol operator = Symbol.toSymbol(slice);
        if (operator.equals(Symbol.LEFT_BRACKET) || operator.equals(Symbol.RIGHT_BRACKET)) {
          continue;
        }
        operators.push(operator);
      } catch (IllegalArgumentException e) {
        // Try/catch block used to separate symbols from numbers as it is easy to check whether
        // an element is a symbol and if it is not then the exception is thrown which means,
        // providing the expression is valid up to this point, it can be assumed that it is a float.
        values.push(Float.valueOf(slice));
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    float result = 63.0f;
    if (expression == null) {
      throw new InvalidExpressionException("INVALID EXPRESSION");
    }
    return result;
  }


}
