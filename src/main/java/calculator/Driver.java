package calculator;

/**
 * Handles running the program, the main point of entry for the application and controls whether GUI
 * or ASCII view is used.
 *
 * @author David Kidd
 */
public class Driver {

  /**
   * Runs the Calculator. If run from the .jar file then is run as a GUI however if run from the
   * command line then it is run in ASCII mode.
   *
   * @param args Arguments passed in when calling the program.
   */
  public static void main(String[] args) {
    // Initialises the singleton for the Calculator Controller.
    CalculatorController.getInstance();
    if (System.console() == null) {
      // Run GUI view in here
      System.out.println("running in GUI mode.");
      GuiView.getInstance();
    } else {
      // Run ASCII view here
      System.out.println("running in ASCII mode.");
      AsciiView.getInstance().runView();
    }
  }
}
