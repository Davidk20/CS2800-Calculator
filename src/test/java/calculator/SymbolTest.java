package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* Class designed to test the {@code Symbol} class.
*
* @author David Kidd
*/
public class SymbolTest {
  @Test
  public void validPrintTest() {
    Assertions.assertEquals("+", Symbol.PLUS.toString());
  }
}
