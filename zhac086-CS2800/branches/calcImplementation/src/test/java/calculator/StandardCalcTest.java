package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code StandardCalc} class.
 *
 * @author David Kidd
 */
public class StandardCalcTest {
  public static StandardCalc calculator;

  @BeforeEach
  public void initialise() {
    calculator = new StandardCalc();
  }


  /**
   * Test 1 - Test written to check that {@code StandardCalc} correctly implements
   * {@code Calculator}.
   */
  @Test
  public void checkIsImplementedTest() {
    Assertions.assertTrue(calculator instanceof Calculator);
  }


  /**
   * Test 2 - Test written to check that {@code evaluate()} correctly throws a
   * {@code InvalidExpressionException}. In this case it checks that it is thrown when the
   * expression passed in is null.
   */
  @Test
  public void evaluateThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(null));
  }


  /**
   * Test 3 - Test written to check that the {@code StandardCalc} correctly evaluates the string
   * expression given, converts to postfix and returns the expected {@code float} result.
   */
  @Test
  public void evaluateFinalResultTest() {
    float result;
    try {
      result = calculator.evaluate("(5 * (6 + 7)) - 2");
      Assertions.assertEquals(63.0f, result);
    } catch (InvalidExpressionException e) {
      Assertions.fail(e);
    }
  }

  /**
   * Test 4 - Test written to check that {@code infixToPostfix()} correctly throws a
   * {@code InvalidExpressionException}. In this case it checks that it is thrown when the
   * expression passed in is null.
   */
  @Test
  public void infixToPostfixThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.infixToPostfix(null));
  }

  /**
   * Test 5 - Test written to check that the {@code infixToPostfix()} method correctly converts the
   * infix expression to a postfix expression.
   */
  @Test
  public void infixToPostfixTest() {
    String result;
    try {
      result = calculator.infixToPostfix("( 5 * ( 6 + 7 ) ) - 2");
      Assertions.assertEquals("5 6 7 + * 2 -", result);
    } catch (InvalidExpressionException e) {
      Assertions.fail(e);
    }
  }

}
