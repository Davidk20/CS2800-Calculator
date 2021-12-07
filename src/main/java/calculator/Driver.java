package calculator;

/**
 * Handles running the program, the main point of entry for the application and controls whether GUI
 * or ASCII view is used.
 *
 * @author David Kidd
 */
public class Driver {

  /**
   * Runs the Calculator.
   *
   * @param args Arguments passed in when calling the program.
   */
  public static void main(String[] args) {
    if (System.console() == null) {
      // Run GUI view in here
    } else {
      // Run ASCII view here
    }

  }

}
