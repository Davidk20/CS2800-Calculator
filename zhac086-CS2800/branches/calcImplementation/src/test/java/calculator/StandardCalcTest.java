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
  
  @Test
  public void checkIsImplementedTest() {
    Assertions.assertTrue(calculator instanceof Calculator);
  }
  
  @Test
  public void evaluateThrowsTest() {
    Assertions.assertThrows(InvalidExpression.class, () -> calculator.evaluate(null));
  }
}
