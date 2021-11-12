package calculator;

import org.junit.jupiter.api.BeforeEach;

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
  public void initialiseOpStack() {
    testStrStack = new StrStack();
  }
  
}
