package calculator;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class designed to test the {@code OpStack} class.
 *
 * @author David Kidd
 *
 */
public class OpStackTest {
  /**
   * Instance of {@code OpStack} used for testing.
   */
  private static OpStack testOpStack;


  /**
   * Initialises the {@code OpStack} as a new Stack before each test so that tests are running on a
   * clean stack.
   */
  @BeforeEach
  public void initialiseOpStack() {
    testOpStack = new OpStack();
  }


  /**
   * Test 1 - Test written to check that when a new {@code NumStack} is initialised, that so to is
   * the {@code Stack} that it is using behind the facade. This tests the {@code isEmpty} method as
   * it will return true if the stack size is found to be equal to zero.
   */
  @Test
  public void initialiseEmptyStackTest() {
    Assertions.assertEquals(true, testOpStack.isEmpty());
  }

  /**
   * Test 2 - Test written to check that when a {@code Symbol} is pushed onto the stack, this is
   * accepted and corresponds to an increase of the size of the stack. This means that the isEmpty()
   * method should now return false.
   */
  @Test
  public void checkNonEmptyStackTest() {
    testOpStack.push(Symbol.LEFT_BRACKET);
    Assertions.assertEquals(false, testOpStack.isEmpty());
  }

  /**
   * Test 3 - Test written to check that when {@code pop()} is attempted on an empty stack, the
   * {@code StackEmptyException} is thrown.
   */
  @Test
  public void emptyStackPopTest() throws EmptyStackException {
    Assertions.assertThrows(EmptyStackException.class, () -> testOpStack.pop());
  }

  /**
   * Test 4 - Test written to check that an entry in the {@code Stack} is correctly returned and
   * that the type of the returned variable is a {@code Symbol}. It is not necessary to check
   * whether the size of the stack has decreased correctly as this will already be handled by
   * {@code StackTest}.
   */
  @Test
  public void validPopTest() {
    testOpStack.push(Symbol.TIMES);
    try {
      Assertions.assertEquals(Symbol.TIMES, testOpStack.pop());
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
  }

  /**
   * Test 5 - Test written to check that, when a series of Symbols are pushed onto the stack, that
   * the correct entry is popped off when called in the method.
   */
  @Test
  public void correctPopOrderTest() {
    testOpStack.push(Symbol.TIMES);
    testOpStack.push(Symbol.DIVIDE);
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.RIGHT_BRACKET);
    try {
      Assertions.assertEquals(Symbol.RIGHT_BRACKET, testOpStack.pop());
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
    testOpStack.push(Symbol.DIVIDE);
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.MINUS);
    try {
      testOpStack.pop();
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
    testOpStack.push(Symbol.PLUS);
    testOpStack.push(Symbol.RIGHT_BRACKET);
    try {
      Assertions.assertEquals(Symbol.RIGHT_BRACKET, testOpStack.pop());
    } catch (EmptyStackException e) {
      // Catch statement here to safely deal with the exception however it is not expected to fail
      // as the stack has a float pushed onto it in the test therefore it is known that there is
      // something in the stack which can be popped off.
      Assertions.fail(e);
    }
  }
  
}