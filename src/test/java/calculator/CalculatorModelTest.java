package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code CalculatorModel}.
 *
 * @author David Kidd
 */
public class CalculatorModelTest {
  CalculatorModel calcModel = new CalculatorModel();


  /**
   * Test 1 - Test written to check that {@code InvalidExpressionException} is correctly thrown when
   * null is evaluated.
   */
  @Test
  public void evaluateNullThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calcModel.evaluate(null, false));
  }

  /**
   * Test 1b - Test written to check that {@code InvalidExpressionException} is correctly thrown
   * when a null string is evaluated.
   */
  @Test
  public void evaluateNullStringThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calcModel.evaluate("", false));
  }


  /**
   * Test 2 - Test written to check that the model can correctly evaluate infix expressions. Test
   * cases are using the same expressions as tests in {@code StandardCalcTest} as the expressions
   * are already known to be correct and so it has isolated the test issue of ensuring that infix
   * and postfix expressions are correctly passed to the right Calculator implementation.
   */
  @Test
  public void evaluateInfixTest() throws InvalidExpressionException {
    Assertions.assertEquals(63.0f, calcModel.evaluate("( 5 * ( 6 + 7 ) ) - 2", true));
    Assertions.assertEquals(105.0f, calcModel.evaluate("5 * ( ( 6 + 7 ) + 8 )", true));
    Assertions.assertEquals(-12.0f, calcModel.evaluate("3 * ( 4 + -8 )", true));
  }

  /**
   * Test 3 - Test written to check that the model can correctly evaluate postfix expressions. Test
   * cases are using the same expressions as tests in {@code StandardCalcTest} as the expressions
   * are already known to be correct and so it has isolated the test issue of ensuring that infix
   * and postfix expressions are correctly passed to the right Calculator implementation.
   */
  @Test
  public void evaluatePostfixTest() throws InvalidExpressionException {
    Assertions.assertEquals(63.0f, calcModel.evaluate("5 6 7 + * 2 -", false));
    Assertions.assertEquals(105.0f, calcModel.evaluate("5.0 6.0 7.0 + 8.0 + *", false));
    Assertions.assertEquals(-12.0f, calcModel.evaluate("3.0 4.0 -8.0 + *", false));
  }

  /**
   * Test 4 - Test written to check that {@code InvalidExpressionException} is thrown when a postfix
   * expression is used but the {@code isInfix} boolean is also true. An error is expected as this
   * is the expected outcome when the same test is completed in {@code StandardCalcTest}.
   */
  @Test
  public void evaluateAlreadyPostfixTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calcModel.evaluate("3.0 4.0 -8.0 + *", true));
  }

  /**
   * Test 5 - Test written to check that {@code InvalidExpressionException} is thrown when an infix
   * expression and true are used as arguments for the models evaluate method. This matches the
   * expected outcome in the {@code RevPolishCalc} tests.
   */
  @Test
  public void evaluateAlreadyInfixTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calcModel.evaluate("( 3 + 4 )", false));
  }

}
