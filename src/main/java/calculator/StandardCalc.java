package calculator;

import java.util.EmptyStackException;

/**
 * Class implements {@code Calculator} to evaluate Infix string expressions. Evaluating a Infix
 * expression in {@code StandardCalc} will convert it to a {@code RevPolishCalc} where the actual
 * calculation will take place.
 *
 * @see <a href=
 *      "https://www.free-online-calculator-use.com/infix-to-postfix-converter.html">Inspiration for
 *      the infix to postfix conversion.</a>
 *
 * @author David Kidd
 */
public class StandardCalc implements Calculator {

  /**
   * Instance of the Reverse Polish Calculator which will handle the calculations.
   */
  RevPolishCalc revPolishCalc = new RevPolishCalc();
  /**
   * Stack containing all operators within the expression.
   */
  private OpStack operators;
  /**
   * {@code StringBuilder} used to build final converted expression.
   */
  private StringBuilder stringBuilder;



  /**
   * Returns the precedence of a symbol to be used to compare the importance of operators.
   *
   * @param op The operation to check precedence.
   * @return 1 if the operator is low precedence, 2 if the operator is high precedence and 0 if it
   *         is not an operator.
   */
  public Integer getPrecedence(Symbol op) {
    if (op == Symbol.PLUS || op == Symbol.MINUS) {
      return 1;
    } else if (op == Symbol.TIMES || op == Symbol.DIVIDE) {
      return 2;
    }
    return 0;
  }

  /**
   * Converts an infix expression to a postfix {@code String} expression.
   *
   * @param expression The infix expression to be converted.
   * @return The converted Postfix expression.
   */
  public String infixToPostfix(String expression) throws InvalidExpressionException {
    // checks to see if there are any reasons for the expression to be invalid
    if (expression == null || expression.length() == 0) {
      throw new InvalidExpressionException("Invalid Expression - String is empty or null.");
    } else if (expression.contains("/ 0")) {
      throw new InvalidExpressionException("Invalid Expression - Attempted division by 0.");
    }
    // Initialises the data structures needed to build the postfix expression.
    operators = new OpStack();
    stringBuilder = new StringBuilder();

    Symbol currentSymbol = Symbol.INVALID;
    String[] expressionSplit = expression.split(" ");
    if (expressionSplit.length < 3) {
      throw new InvalidExpressionException("Invalid Expression - Expression too short.");
    }
    try {
      // Test case to see if the expression is already in postfix, checks if the first two splices
      // are both numbers. If so, the expression is already in postfix and does not need to be
      // converted.
      if (Float.valueOf(expressionSplit[0]) instanceof Float
          && Float.valueOf(expressionSplit[1]) instanceof Float) {
        throw new InvalidExpressionException("Invalid Expression - Expression is already postfix.");
      }
    } catch (NumberFormatException e1) {
      // Empty catch block used as if the above if statement throws an error it means one of the
      // splices is not a number and therefore is still in infix.
    }
    // Iterates through the expression and divides the infix expression into its respective stacks,
    // adding values to the stringBuilder when necessary to match postfix convention.
    for (String slice : expressionSplit) {
      try {
        // Checks if slice is operand
        Float value = Float.valueOf(slice);
        // Appends it to formatted expression
        stringBuilder.append(value.toString() + " ");
      } catch (IllegalArgumentException e) {
        Symbol symbol = Symbol.toSymbol(slice);
        // if slice == (
        if (symbol.equals(Symbol.LEFT_BRACKET)) {
          operators.push(symbol);
        } else if (symbol.equals(Symbol.RIGHT_BRACKET)) {
          // if slice == )
          // pops all values and builds subexpression until left bracket is found
          currentSymbol = operators.pop();
          while (!currentSymbol.equals(Symbol.LEFT_BRACKET)) {
            stringBuilder.append(currentSymbol.toString() + " ");
            try {
              currentSymbol = operators.pop();
            } catch (EmptyStackException ex) {
              break;
            }
          }
          // if slice == operator and there is no operator in the stack with greater precedence then
        } else if ((operators.opStack.getSize() == 0 && getPrecedence(symbol) >= 1)
            || (operators.opStack.getSize() > 0
                && getPrecedence(symbol) > getPrecedence(operators.top()))) {
          operators.push(symbol);
        } else {
          while (operators.opStack.getSize() > 0
              && getPrecedence(symbol) < getPrecedence(operators.top())) {
            stringBuilder.append(operators.pop() + " ");
          }
          operators.push(symbol);
        }
      }
    }
    while (operators.opStack.getSize() > 0) {
      stringBuilder.append(operators.pop() + " ");
    }
    return stringBuilder.toString().strip();
  }


  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String formattedExpression = infixToPostfix(expression);
    return revPolishCalc.evaluate(formattedExpression);
  }


}
