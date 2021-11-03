package calculator;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code Stack} class.
 *
 * @author David Kidd
 */
class StackTest {
  private static Stack testStack;
  private static Entry numberEntry;
  private static Entry symbolEntry;

  /**
   * This method initialises the variables needed to test the {@code Stack} class. This includes
   * Entries for one of each type and a {@code Stack} for them to be tested in
   */
  @BeforeAll
  public static void initialiseEntries() {
    numberEntry = new Entry(1.234f);
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
  }

  @BeforeEach
  public void initialiseStack() {
    testStack = new Stack();
  }


  /**
   * Test 1 - Test designed to ensure that the size of the stack can be correctly obtained. This is
   * the first test so that we can ensure that testing any pushing or popping functions can be
   * validated with a size method that has been proven correct.
   */
  @Test
  public void sizeTest() {
    Assertions.assertEquals(0, testStack.getSize());
  }


  /**
   * Test 2 - Test written to check that when an {@code Entry} is pushed onto the stack, the size of
   * the stack increases by 1.
   */
  @Test
  public void pushTest() {
    testStack.push(numberEntry);
    Assertions.assertEquals(1, testStack.getSize());
  }

  /**
   * Test 3 - Test written to check that when the method {@code top()} is called on an empty stack,
   * the {@code EmptyStackException} is thrown as there is no {@code Entry} to return.
   *
   * @throws EmptyStackException Thrown by the stack to indicate that it is empty.
   */
  @Test
  public void emptyStackTopTest() throws EmptyStackException {
    Assertions.assertThrows(EmptyStackException.class, () -> testStack.top());
  }


  /**
   * Test 4 - Test written to check that the {@code Entry} returned by {@code top()} matches the
   * {@code Entry} put in.
   *
   * @throws EmptyStackException thrown if the stack is empty when called by the method
   *         {@code top()}.
   */
  @Test
  public void topTest() throws EmptyStackException {
    testStack.push(numberEntry);
    Assertions.assertEquals(numberEntry, testStack.top());
  }

  /**
   * Test 5 - Test written to check that when that the method {@code top()} is called, the size of
   * the stack does not change and the entry is left in the stack.
   *
   * @throws EmptyStackException Thrown by the stack to indicate that it is empty.
   */
  @Test
  public void topSizeTest() throws EmptyStackException {
    testStack.push(numberEntry);
    testStack.top();
    Assertions.assertEquals(1, testStack.getSize());
  }

  /**
   * Test 5 - Test written to check that when {@code pop()} is called on an empty stack, the
   * {@code EmptyStackException} is thrown as there is no {@code Entry} to return.
   *
   * @throws EmptyStackException Thrown by the stack to indicate that it is empty.
   */
  @Test
  public void emptyStackPopTest() throws EmptyStackException {
    Assertions.assertThrows(EmptyStackException.class, () -> testStack.pop());
  }


  /**
   * Test 6 - Test written to check that when {@code pop()} is called, the size of the stack
   * decreases by 1 as the {@code Entry} has been removed.
   *
   * @throws EmptyStackException Thrown by the stack to indicate that it is empty.
   */
  @Test
  public void popSizeTest() throws EmptyStackException {
    testStack.push(symbolEntry);
    testStack.pop();
    Assertions.assertEquals(0, testStack.getSize());
  }


  /**
   * Test 7 - Test written to check that when {@code pop()} is called, the {@code Entry} returned by
   * the method matches and is equal to the entry that was pushed in last.
   *
   * @throws EmptyStackException Thrown by the stack to indicate that it is empty.
   */
  @Test
  public void popValueTest() throws EmptyStackException {
    testStack.push(numberEntry);
    testStack.push(symbolEntry);
    Assertions.assertEquals(testStack.pop(), symbolEntry);
  }



}
