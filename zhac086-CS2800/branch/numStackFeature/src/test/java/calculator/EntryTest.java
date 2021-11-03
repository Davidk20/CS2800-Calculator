package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code Entry} class.
 *
 * @author David Kidd
 */
public class EntryTest {
  static Entry numberEntry;
  static Entry symbolEntry;
  static Entry stringEntry;

  /**
   * This method initialises the variables needed to test the {@code Entry} class. This includes
   * Entries for one of each type.
   */
  @BeforeAll
  public static void initialise() {
    numberEntry = new Entry(1.234f);
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    stringEntry = new Entry("test string");

  }

  /**
   * Test 1 - Test written to ensure that when a value is entered, the correct type is configured
   * within the constructor and that the constructor itself is functioning correctly.
   */
  @Test
  public void getCorrectTypeFromValueTest() {
    Assertions.assertEquals(Type.NUMBER, numberEntry.getType());
  }

  /**
   * Test 2 - Test written to ensure that when a symbol is entered, the correct type is configured
   * within the constructor and that the constructor itself is functioning correctly.
   */
  @Test
  public void getCorrectTypeFromSymbolTest() {
    Assertions.assertEquals(Type.SYMBOL, symbolEntry.getType());
  }

  /**
   * Test 3 - Test written to ensure that when a string is entered, the correct type is configured
   * within the constructor and that the constructor itself is functioning correctly.
   */
  @Test
  public void getCorrectTypeFromStringTest() {
    Assertions.assertEquals(Type.STRING, stringEntry.getType());
  }

  /**
   * Test 4 - Test written to check that when an {@code Entry} of type {@code SYMBOL} is
   * instantiated, calling {@code getNumber()} will thrown an exception as it will not match the
   * most recent setter.
   *
   * @throws InvalidEntryTypeException - thrown as the {@code Type} of the latest setter (SYMBOL)
   *         should not match the {@code Type} of the getter (NUMBER) that is being called.
   */
  @Test
  public void getNumberExceptionTest() throws InvalidEntryTypeException {
    Assertions.assertThrows(InvalidEntryTypeException.class, () -> symbolEntry.getNumber());
  }


  /**
   * Test 5 - Test written to check that when an {@code Entry} of type {@code NUMBER} is
   * instantiated, calling {@code getNumber()} will return the expected number.
   *
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the latest setter does not
   *         match the {@code Type} of the getter that is being called.
   */
  @Test
  public void getNumberValidTest() throws InvalidEntryTypeException {
    Assertions.assertEquals(1.234f, numberEntry.getNumber());
  }

  /**
   * Test 6 - Test written to check that when an {@code Entry} of type {@code NUMBER} is
   * instantiated, calling {@code getSymbol()} will throw an exception as it will not match the most
   * recent setter.
   *
   * @throws InvalidEntryTypeException - thrown as the {@code Type} of the latest setter (NUMBER)
   *         should not match the {@code Type} of the getter (SYMBOL) that is being called.
   */
  @Test
  public void getSymbolExceptionTest() throws InvalidEntryTypeException {
    Assertions.assertThrows(InvalidEntryTypeException.class, () -> numberEntry.getSymbol());
  }

  /**
   * Test 7 - Test written to check that when an {@code Entry} of type {@code SYMBOL} is
   * instantiated, calling {@code getNumber()} will return the expected number.
   *
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the latest setter does not
   *         match the {@code Type} of the getter that is being called.
   */
  @Test
  public void getSymbolValidTest() throws InvalidEntryTypeException {
    Assertions.assertEquals(Symbol.LEFT_BRACKET, symbolEntry.getSymbol());
  }


  /**
   * Test 8 - Test written to check that when an {@code Entry} of type {@code NUMBER} is
   * instantiated, calling {@code getString()} will throw an exception as it will not match the most
   * recent setter.
   *
   * @throws InvalidEntryTypeException - thrown as the {@code Type} of the latest setter (NUMBER)
   *         should not match the {@code Type} of the getter (STRING) that is being called.
   */
  @Test
  public void getStringExceptionTest() throws InvalidEntryTypeException {
    Assertions.assertThrows(InvalidEntryTypeException.class, () -> numberEntry.getStr());
  }

  /**
   * Test 9 - Test written to check that when an {@code Entry} of type {@code STRING} is
   * instantiated, calling {@code getStr()} will return the expected number.
   *
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the latest setter does not
   *         match the {@code Type} of the getter that is being called.
   */
  @Test
  public void getStringValidTest() throws InvalidEntryTypeException {
    Assertions.assertEquals("test string", stringEntry.getStr());
  }


  /**
   * Test 10 - Test written to ensure that the {@code Entry.equals} method is working correctly for
   * equal pairs. Two instances of {@code Entry} with the same construction arguments should be
   * considered equal.
   */
  @Test
  public void entryEqualValueTest() {
    Entry entry = new Entry(Symbol.LEFT_BRACKET);
    Assertions.assertTrue(symbolEntry.equals(entry));
  }

  /**
   * Test 11 - Test written to ensure that the {@code Entry.equals} method is working correctly for
   * unequal pairs. Two instances of {@code Entry} with the same construction argument {@code Type}
   * but different values should be considered unequal.
   */
  @Test
  public void entryUnequalValueTest() {
    Entry entry = new Entry(2.345f);
    Assertions.assertFalse(numberEntry.equals(entry));
  }

  /**
   * Test 12 - Test written to ensure that the {@code Entry.equals} method is working correctly for
   * unequal pairs. Two instances of {@code Entry} with the different construction arguments
   * {@code Type} and different values should be considered unequal.
   */
  @Test
  public void entryUnequalTypeTest() {
    Assertions.assertFalse(symbolEntry.equals(stringEntry));
  }

}
