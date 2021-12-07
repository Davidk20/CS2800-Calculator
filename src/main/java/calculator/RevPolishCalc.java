package calculator;

import java.util.EmptyStackException;

/**
 * Class implements {@code Calculator} to evaluate Reverse Polish string expressions.
 * {@code RevPolishCalc} takes a {@code String} formatted for Reverse Polish Notation and evaluates
 * this string to find the result of the expression.
 *
 * @see <a href=
 *      "https://isaaccomputerscience.org/concepts/dsa_toc_rpn?examBoard=all&stage=all">Inspiration
 *      for the evaluation of reverse polish notation.</a>
 *
 * @author David Kidd
 */
public class RevPolishCalc implements Calculator {

  /**
   * Stack containing all of the numbers within the expression.
   */
  private NumStack values = new NumStack();


  /**
   * Evaluates a simple, two number expression returning the result.
   *
   * @param f1 The first number
   * @param operator The operation to conduct on the two numbers
   * @param f2 The second number. Must not be 0 if the operator is {@code Symbol.DIVIDE}
   * @return The result of the expression
   * @throws InvalidExpressionException Thrown if there is an error in the expression.
   */
  public float evaluateSubExpression(float f1, Symbol operator, float f2)
      throws InvalidExpressionException {
    switch (operator) {
      case PLUS:
        return f1 + f2;
      case MINUS:
        return f1 - f2;
      case TIMES:
        return f1 * f2;
      case DIVIDE:
        if (f2 == 0.0f) {
          throw new InvalidExpressionException("Invalid Expression - Attempted division by 0.");
        }
        return f1 / f2;
      default:
        throw new InvalidExpressionException("Invalid Expression - Operator is invalid");
    }
  }


  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    // checks to see if there are any reasons for the expression to be invalid
    if (expression == null || expression.length() == 0) {
      throw new InvalidExpressionException("Invalid Expression - String is empty or null.");
    } else if (expression.contains("/ 0")) {
      throw new InvalidExpressionException("Invalid Expression - Attempted division by 0.");
    } else if (expression.contains("(") || expression.contains(")")) {
      throw new InvalidExpressionException(
          "Invalid Expression - Expression is not in postfix format.");
    }
    String[] expressionSplit = expression.split(" ");
    if (expressionSplit.length < 3) {
      throw new InvalidExpressionException("Invalid Expression - Expression too short.");
    }
    // Iterates over each of the characters in the expression
    for (String split : expressionSplit) {
      // Checks if the split is an operand and pushes it to the stack.
      try {
        Float value = Float.valueOf(split);
        values.push(value);
        // If not a float, the catch block will trigger and it knows split is a symbol.
      } catch (IllegalArgumentException e) {
        Symbol symbol = Symbol.toSymbol(split);
        Float first = values.pop();
        Float second = values.pop();
        values.push(evaluateSubExpression(second, symbol, first));
      }
    }
    return values.pop();
  }



}
