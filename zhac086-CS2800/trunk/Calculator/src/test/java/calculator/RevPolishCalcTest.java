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
  public void expressionTooShortTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 +"));
  }

  /**
   * Test 5 - Test written to check that the {@code RevPolishCalc} correctly evaluates the string
   * expression given and returns the expected {@code float}.
   */
  @Test
  public void evaluateFinalResultTest() throws InvalidExpressionException {
    Assertions.assertEquals(63.0f, calculator.evaluate("5 6 7 + * 2 -"));
    Assertions.assertEquals(105.0f, calculator.evaluate("5.0 6.0 7.0 + 8.0 + *"));
    Assertions.assertEquals(-12.0f, calculator.evaluate("3.0 4.0 -8.0 + *"));
  }

  /**
   * Test 6 - Test written to check that an {@code InvalidExpressionException} is thrown when an
   * infix expression is passed into the postfix calculator.
   */
  @Test
  public void invalidInfixExpressionTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.evaluate("( 3 + 4 )"));
  }

  /**
   * Test 7 - Test written to check that {@code InvalidExpressionException} is thrown when an
   * invalid operator is used in the evaluation.
   */
  @Test
  public void evaluateSubExpressionThrowsInvalidTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.evaluateSubExpression(1.0f, Symbol.RIGHT_BRACKET, 1.0f));
  }

  /**
   * Test 8 - Test written to check that {@code InvalidExpressionException} is thrown when division
   * by zero is attempted in the evaluation.
   */
  @Test
  public void evaluateSubExpressionThrowsDivByZeroTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.evaluateSubExpression(1.0f, Symbol.DIVIDE, 0.0f));
  }

  /**
   * Test 9 - Test written to check that the method correctly evaluates the small expressions and
   * returns the correct result.
   */
  @Test
  public void evaluateSubExpressionTest() throws InvalidExpressionException {
    Assertions.assertEquals(4.0f, calculator.evaluateSubExpression(2.0f, Symbol.PLUS, 2.0f));
    Assertions.assertEquals(25.0f, calculator.evaluateSubExpression(5.0f, Symbol.TIMES, 5.0f));
    Assertions.assertEquals(7.0f, calculator.evaluateSubExpression(10.0f, Symbol.MINUS, 3.0f));
    Assertions.assertEquals(10.0f, calculator.evaluateSubExpression(100.0f, Symbol.DIVIDE, 10.0f));
  }


}
