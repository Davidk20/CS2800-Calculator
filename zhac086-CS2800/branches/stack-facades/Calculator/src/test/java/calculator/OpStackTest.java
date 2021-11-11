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
   * Test 2 - Test written to check that when a {@code Symbol} is pushed onto the
   * stack, this is accepted and corresponds to an increase of the size of the stack. This means
   * that the isEmpty() method should now return false.
   */
  @Test
  public void checkNonEmptyStackTest() {
    testOpStack.push(Symbol.LEFT_BRACKET);
    Assertions.assertEquals(false, testOpStack.isEmpty());
  }
}
