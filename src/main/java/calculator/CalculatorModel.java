package calculator;


/**
 * Class encapsulates both the Reverse Polish and Standard calculators in a model to allow
 * Integration with the user interfaces.
 *
 * @author David Kidd
 */
public class CalculatorModel {
  private RevPolishCalc revPolish = new RevPolishCalc();
  private StandardCalc standard = new StandardCalc();



  /**
   * Evaluates the expression using {@code isInfix} to decide whether to evaluate the expression
   * using the standard or reverse polish calculators.
   *
   * @param expression The expression to be evaluated.
   * @param isInfix {@code true} if the expression is infix.
   * @return The evaluated expression as a {@code Float}
   * @throws InvalidExpressionException Thrown if there is an error in the formatting of the
   *         exception.
   */
  public Float evaluate(String expression, boolean isInfix) throws InvalidExpressionException {
    if (isInfix) {
      return standard.evaluate(expression);
    } else {
      return revPolish.evaluate(expression);
    }
  }


}
