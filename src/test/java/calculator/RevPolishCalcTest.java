package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code RevPolishCalc} class.
 *
 * @author David Kidd
 */
public class RevPolishCalcTest {
  public static RevPolishCalc calculator;

  @BeforeEach
  public void initialise() {
    calculator = new RevPolishCalc();
  }

  /**
   * Test 1 - Test written to check that {@code RevPolishCalc} correctly implements
   * {@code Calculator}.
   */
  @Test
  public void checkIsImplementedTest() {
    Assertions.assertTrue(calculator instanceof Calculator);
  }

  /**
   * Test 2 - Test written to check that {@code evaluate()} correctly throws a
   * {@code InvalidExpressionException} with the cause being when the expression passed in is null.
   */
  @Test
  public void evaluateThrowsWhenNullTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(null));
  }

  /**
   * Test 2b - Test written to check that {@code evaluate()} correctly throws a
   * {@code InvalidExpressionException} when the expression is a null string.
   */
  @Test
  public void evaluateThrowsWhenNullStringTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(""));
  }

  /**
   * Test 3 - Test written to check that {@code evaluate()} correctly throws a
   * {@code InvalidExpressionException} with the cause being a division by zero error.
   */
  @Test
  public void evaluateThrowsDivisionByZeroTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(" / 0 "));
  }

  /**
   * Test 4 - Test written to check that {@code InvalidExpressionException} is thrown with the cause
   * being that the expression is too short to be complete.
   */
  @Test
  public void infixToPostfixTooShortTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.evaluate("3 +"));
  }

  /**
   * Test 5 - Test written to check that the {@code RevPolishCalc} correctly evaluates the string
   * expression given and returns the expected {@code float}.
   */
  @Test
  public void evaluateFinalResultTest() throws InvalidExpressionException {
    float result = calculator.evaluate("5 6 7 + * 2");
    Assertions.assertEquals(63.0f, result);
  }

}
