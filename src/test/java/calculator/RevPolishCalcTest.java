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
  
  @Test
  public void checkIsImplementedTest() {
    Assertions.assertTrue(calculator instanceof Calculator);
  }
  
  @Test
  public void evaluateThrowsTest() {
    Assertions.assertThrows(InvalidExpression.class, () -> calculator.evaluate(null));
  }
}
