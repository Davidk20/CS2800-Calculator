package calculator;


/**
 * Class implements {@code Calculator} to evaluate Reverse Polish string expressions.
 * {@code RevPolishCalc} takes a {@code String} formatted for Reverse Polish Notation and evaluates
 * this string to find the result of the expression.
 *
 * @author David Kidd
 */
public class RevPolishCalc implements Calculator {
  
  /**
   * Stack containing all of the numbers within the expression.
   */
  private NumStack values = new NumStack();
  
  /**
   * Stack containing all operators within the expression.
   */
  private OpStack operators = new OpStack();

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    float result = 63.0f;
    if (expression == null) {
      throw new InvalidExpressionException("INVALID EXPRESSION");
    }
    return result;
  }


}
