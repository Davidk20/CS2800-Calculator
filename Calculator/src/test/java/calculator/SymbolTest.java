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

  /**
   * Test 2 - Test written to validate the result of the {@code toSymbol()} method. The method takes
   * a String representation of a {@code Symbol} and should return the matching {@code Symbol}.
   */
  @Test
  public void validToSymbolTest() {
    Assertions.assertEquals(Symbol.PLUS, Symbol.toSymbol("+"));
  }


  /**
   * Test 3 - Test written to check that when a character not in the {@code Symbol} enum is passed
   * in as an argument to {@code toSymbol()}, the {@code Symbol.INVALID} enum is correctly returned.
   */
  @Test
  public void invalidToSymbolTest() {
    Assertions.assertEquals(Symbol.INVALID, Symbol.toSymbol("F"));
  }

}
