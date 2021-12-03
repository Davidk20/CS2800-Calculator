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
   * Test 4 - Test written to check that the {@code StandardCalc} correctly evaluates the string
   * expression given, converts to postfix and returns the expected {@code float} result.
   */
  @Test
  public void evaluateFinalResultTest() throws InvalidExpressionException {
    float result = calculator.evaluate("( 5 * ( 6 + 7 ) ) - 2");
    Assertions.assertEquals(63.0f, result);
  }

  /**
   * Test 5 - Test written to check that {@code infixToPostfix()} correctly throws a
   * {@code InvalidExpressionException} with the cause being when the expression passed in is null.
   */
  @Test
  public void infixToPostfixNullThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.infixToPostfix(null));
  }
  
  /**
   * Test 5b - Test written to check that {@code infixToPostfix()} correctly throws a
   * {@code InvalidExpressionException} when the expression is a null string.
   */
  @Test
  public void infixToPostfixNullStringThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.infixToPostfix(""));
  }

  /**
   * Test 6 - Test written to check that {@code infixToPostfix()} correctly throws a
   * {@code InvalidExpressionException} with the cause being a division by zero error.
   */
  @Test
  public void infixToPostfixDivisionByZeroThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.infixToPostfix("( 1 / 0 ) + 3"));
  }


  /**
   * Test 7 - Test written to check that {@code infixToPostfix()} does not return an error when
   * expressions are used which include division by zero but in ways which would be mathematically
   * appropriate and valid.
   */
  @Test
  public void infixToPostfixDivisionByZeroEdgeTest() {
    Assertions.assertDoesNotThrow(() -> calculator.infixToPostfix("1 / (0 + 3)"));
  }

  /**
   * Test 8 - Test written to check that {@code infixToPostfix()} correctly throws a
   * {@code InvalidExpressionException} with the cause being that the expression is too short to be
   * complete.
   */
  @Test
  public void infixToPostfixTooShortTest() {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.infixToPostfix("3 +"));
  }

  /**
   * Test 9 - Test written to check that the {@code infixToPostfix()} method correctly converts a
   * series of simple infix expressions to a postfix.
   */
  @Test
  public void basicInfixToPostfixTest() throws InvalidExpressionException {
    // Basic expression with no brackets
    Assertions.assertEquals("5.0 6.0 +", calculator.infixToPostfix("5 + 6"));
    // Basic expression including brackets
    Assertions.assertEquals("5.0 6.0 7.0 + *", calculator.infixToPostfix("5 * ( 6 + 7 )"));
    // Basic expression with operations either side of the brackets
    Assertions.assertEquals("5.0 6.0 7.0 + * 2.0 -",
        calculator.infixToPostfix("5 * ( 6 + 7 ) - 2"));
    // Expression with nested brackets
    Assertions.assertEquals("5.0 6.0 7.0 + 8.0 + *",
        calculator.infixToPostfix("5 * ( ( 6 + 7 ) + 8 )"));
  }

  /**
   * Test 10 - Test written to check that expressions are returned correctly when a negative number
   * is included in the expression.
   */
  @Test
  public void negativeNumberInfixToPostfixTest() throws InvalidExpressionException {
    Assertions.assertEquals("-3.0 4.0 8.0 + *", calculator.infixToPostfix("-3 * ( 4 + 8 )"));
    Assertions.assertEquals("3.0 -4.0 8.0 + *", calculator.infixToPostfix("3 * ( -4 + 8 )"));
    Assertions.assertEquals("3.0 4.0 -8.0 + *", calculator.infixToPostfix("3 * ( 4 + -8 )"));
  }

  /**
   * Test 10 - Test written to check that expressions of an extreme length (> 100 numbers) are
   * handled correctly.
   */
  @Test
  public void extremeLengthInfixToPostfixTest() throws InvalidExpressionException {
    Assertions.assertEquals(
        "83.5 -13.3 -11.1 * + 103.9 121.6 - 136.7 / - 65.1 58.0 + 2.0 * 10.1 49.0 + 64.3 / / +",
        calculator.infixToPostfix(
            "( ( 83.5 + ( -13.3 * -11.1 ) ) - ( ( 103.9 - 121.6 ) / 136.7 ) ) + "
            + "( ( ( 65.1 + 58.0 ) * 2.0 ) / ( ( 10.1 + 49.0 ) / 64.3 ) )"));
  }

  /**
   * Test 11 - Test written to check that if an expression which is already converted to postfix
   * before being passed into the {@code infixToPostfix()} method, then it will throw an exception
   * as it is an invalid infix expression, even though it is a valid postfix expression. This is
   * because the user has chosen to enter an infix expression therefore this is an invalid choice.
   *
   * @throws InvalidExpressionException Thrown if the user enters a postfix expression into the
   *         infix calculator.
   */
  @Test
  public void alreadyConvertedInfixToPostfixTest() throws InvalidExpressionException {
    Assertions.assertThrows(InvalidExpressionException.class,
        () -> calculator.infixToPostfix("3.0 4.0 -8.0 + *"));
  }

}
