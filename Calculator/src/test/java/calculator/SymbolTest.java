package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code Symbol} class.
 *
 * @author David Kidd
 */
public class SymbolTest {

  /**
   * Test 1 - Test written to check that the enum {@code Symbol} is correctly initialised and can
   * return as the correct string representation.
   */
  @Test
  public void validPrintTest() {
    Assertions.assertEquals("+", Symbol.PLUS.toString());
  }
}
