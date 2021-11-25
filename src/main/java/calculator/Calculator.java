package calculator;


/**
 * Model for a calculator. {@code Calculator}. An {@code Interface} is used to group the methods of
 * both the {@code StandardCalc} and {@code RevPolishCalc}. No test class is written for
 * {@code Calculator} as there is no need for tests on an interface method and the interface methods
 * can only be accessed via implementation so they will be tested in the classes which implement
 * {@code Calculator}.
 *
 * @author David Kidd
 */
interface Calculator {



  /**
   * Method evaluates and calculates a {@code String} expression.
   *
   * @param expression The expression to be evaluated.
   * @return The output of the expression.
   * @throws InvalidExpression Thrown if the expression passed in is invalid.
   */
  public float evaluate(String expression) throws InvalidExpression;

}
