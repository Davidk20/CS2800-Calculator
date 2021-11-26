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
   * {@code InvalidExpressionException}. In this case it checks that it is thrown when the
   * expression passed in is null. 
   */
  @Test
  public void evaluateThrowsTest() {
    Assertions.assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(null));
  }
  
  /**
   * Test 3 - Test written to check that the {@code RevPolishCalc} correctly evaluates the string
   * expression given and returns the expected {@code float}.
   */
  @Test
  public void evaluateTest() {
    float result;
    try {
      result = calculator.evaluate("5 6 7 + * 2");
      Assertions.assertEquals(63.0f, result);
    } catch (InvalidExpressionException e) {
      Assertions.fail(e);
    }
  }
}
