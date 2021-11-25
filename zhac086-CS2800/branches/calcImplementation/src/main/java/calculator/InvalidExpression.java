package calculator;


/**
 * {@code Exception} thrown when an invalid expression is passed into the {@code Calculator}.
 *
 * @author David Kidd
 *
 */
public class InvalidExpression extends Exception {
  /**
   * This constructor is designed to be used when there is a single exception with no previous
   * errors in the Stack trace.
   *
   * @param message The error message passed when the exception is thrown.
   */
  public InvalidExpression(String message) {
    super(message);
  }

  /**
   * This constructor is designed to be used when there is an exception with a message and also a
   * cause in the form of another {@code Throwable}. Used to trace when further errors which have
   * led to this exception being thrown
   *
   * @param message The error message passed when the exception is thrown.
   * @param cause The previous {@code Exception} which came before this exception in the stack.
   */
  public InvalidExpression(String message, Throwable cause) {
    super(message, cause);
  }

}
