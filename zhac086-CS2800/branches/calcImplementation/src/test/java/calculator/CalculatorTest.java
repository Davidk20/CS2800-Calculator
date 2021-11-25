package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code Calculator} class.
 *
 * @author David Kidd
 */
public class CalculatorTest {
  /**
   * {@code Calculator} is initialised here rather than in a {@code BeforeEach} method because,
   * being a singleton, there is no need to prepare or initialise this class before each test as the
   * one instance can be used for all.
   */
  Calculator calculator = Calculator.getInstance();


  /**
   * Test 1 - Test written to check that {@code Calculator.evaluate()} throws
   * {@code InvalidExpression}.
   */
  @Test
  public void evaluateThrowsTest() {
    Assertions.assertThrows(InvalidExpression.class, () -> calculator.evaluate("TEST_STRING"));
  }

}
