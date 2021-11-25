package calculator;

/**
 * Class implements {@code Calculator} to evaluate Infix string expressions.
 *
 * @author David Kidd
 */
public class StandardCalc implements Calculator {

  @Override
  public float evaluate(String expression) throws InvalidExpression {
    throw new InvalidExpression("INVALID EXPRESSION");
  }

}
