package calculator;


/**
 * {@code Exception} thrown when an invalid expression is passed into the {@code Calculator}.
 *
 * @author David Kidd
 *
 */
public class InvalidExpressionException extends Exception {
  /**
   * This constructor is designed to be used when there is a single exception with no previous
   * errors in the Stack trace.
   *
   * @param message The error message passed when the exception is thrown.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

}
