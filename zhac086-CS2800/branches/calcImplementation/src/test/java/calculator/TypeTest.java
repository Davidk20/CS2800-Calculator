package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code Type} class.
 *
 * @author David Kidd
 */
public class TypeTest {
  
  @Test
  public void validPrintTest() {
    Type symbolType = Type.SYMBOL;
    Assertions.assertEquals("SYMBOL", symbolType.toString());
  }

}