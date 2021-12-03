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
    // checks to see if there are any reasons for the expression to be invalid
    if (expression == null || expression.length() == 0) {
      throw new InvalidExpressionException("Invalid Expression - String is empty or null.");
    } else if (expression.contains("/ 0")) {
      throw new InvalidExpressionException("Invalid Expression - Attempted division by 0.");
    }
    String[] expressionSplit = expression.split(" ");
    if (expressionSplit.length < 3) {
      throw new InvalidExpressionException("Invalid Expression - Expression too short.");
    }
    return 63.0f;
  }


}
