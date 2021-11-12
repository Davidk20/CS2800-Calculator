package calculator;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code StrStack} class.
 *
 * @author David Kidd
 *
 */
public class StrStackTest {
  /**
   * Instance of {@code StrStack} used for testing.
   */
  private static StrStack testStrStack;

  /**
   * Initialises the {@code StrStack} as a new Stack before each test so that tests are running on a
   * clean stack.
   */
  @BeforeEach
  public void initialiseStrStack() {
    testStrStack = new StrStack();
  }

  /**
   * Test 1 - Test written to check that when a new {@code StrStack} is initialised, that so to is
   * the {@code Stack} that it is using behind the facade. This tests the {@code isEmpty} method as
   * it will return true if the stack size is found to be equal to zero.
   */
  @Test
  public void initialiseEmptyStackTest() {
    Assertions.assertEquals(true, testStrStack.isEmpty());
  }

  /**
   * Test 2 - Test written to check that when a {@code String} is pushed onto the stack, this is
   * accepted and corresponds to an increase of the size of the stack. This means that the isEmpty()
   * method should now return false.
   */
  @Test
  public void checkNonEmptyStackTest() {
    testStrStack.push("string");
    Assertions.assertEquals(false, testStrStack.isEmpty());
  }

  /**
   * Test 3 - Test written to check that when {@code pop()} is attempted on an empty stack, the
   * {@code StackEmptyException} is thrown.
   */
  @Test
  public void emptyStackPopTest() throws EmptyStackException {
    Assertions.assertThrows(EmptyStackException.class, () -> testStrStack.pop());
  }

  /**
   * Test 4 - Test written to check that an entry in the {@code Stack} is correctly returned and
   * that the type of the returned variable is a {@code String}. It is not necessary to check
   * whether the size of the stack has decreased correctly as this will already be handled by
   * {@code StackTest}.
   */
  @Test
  public void validPopTest() {
    testStrStack.push("String");
    try {
      Assertions.assertEquals("String", testStrStack.pop());
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
  }

  /**
   * Test 5 - Test written to check that, when a series of Strings are pushed onto the stack, that
   * the correct entry is popped off when called in the method.
   */
  @Test
  public void correctPopOrderTest() {
    testStrStack.push("String 1");
    testStrStack.push("String 3");
    testStrStack.push("String 2");
    testStrStack.push("String 4");
    try {
      Assertions.assertEquals("String 4", testStrStack.pop());
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
  }

  /**
   * Test 6 - Test written to check that the correct order of the stack is still followed after
   * pushing and popping to and from the stack. This checks that a user can remove any number of
   * entries from a stack and also add any number and the stack will still return the correct
   * ordered element.
   */
  @Test
  public void popAfterPopTest() {
    testStrStack.push("String 1");
    testStrStack.push("String 3");
    testStrStack.push("String 2");
    try {
      testStrStack.pop();
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
    testStrStack.push("String 4");
    try {
      Assertions.assertEquals("String 4", testStrStack.pop());
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
  }

  /**
   * Test 7 - Test written to check that {@code StrStack} correctly reverses the order of its stack.
   * When a stack (a, b, c, d) is passed in, it should return the stack (a, b, c, d) when popped. as
   * it would usually return (d, c, b, a) when popped but this is reversed in this instance.
   */
  @Test
  public void reversalTest() {
    testStrStack.push("a");
    testStrStack.push("b");
    testStrStack.push("c");
    testStrStack.push("d");
    testStrStack.reverse();
    Assertions.assertEquals("a", testStrStack.pop());
  }
}
