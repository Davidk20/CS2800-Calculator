package calculator;

import java.util.Scanner;

/**
 * Class is responsible for giving the user the ASCII view of the program, using ViewInterface to be
 * observed by the controllers and implement the methods needed to calculate.
 *
 * @author David Kidd
 */
public class AsciiView implements ViewInterface {
  CalculatorController calcController = CalculatorController.getInstance();
  private String expression;
  private boolean isInfix;


  // Singleton implementation - inspiration taken from MVCJavaFX example on moodle.

  private static AsciiView instance = null;

  /**
   * Returns the singular instance of GuiView or creates one if it has not been created yet.
   *
   * @return The instance of GuiView.
   */
  public static AsciiView getInstance() {
    if (instance == null) {
      instance = new AsciiView();
    }
    return instance;
  }

  @Override
  public String getExpression() {
    return this.expression;
  }

  @Override
  public boolean getExpressionType() {
    return this.isInfix;
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println("#########################################");
    System.out.println("The answer is: " + answer);
    System.out.println("#########################################");
  }

  /**
   * Notified when the user wants to calculate an expression, notifies the controller to calculate
   * and return the expression.
   */
  public void handleCalculate() {
    this.calcController.handleCalculate();
  }

  /**
   * Runs the ASCII view for the user to interact with.
   */
  public void runView() {
    this.calcController.setView(this);
    // Generates the menu showing the user what instructions to use.
    System.out.println("#########################################");
    System.out.println(
        "Enter one of the following characters, followed by a space then any required input.");
    System.out.println("To calculate - C");
    System.out.println("To enter an expression - E {expression}");
    System.out.println("To set expression as infix - I");
    System.out.println("To set expression as postfix - P");
    System.out.println("To reset expression - R");
    System.out.println("To quit - Q");
    System.out.println("#########################################");
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    while (running && scanner.hasNext()) {
      String input = scanner.nextLine();
      // Using the first char in the string as a key
      switch (input.toUpperCase().charAt(0)) {
        case 'C':
          handleCalculate();
          break;
        case 'E':
          System.out.println(input);
          this.expression = input.substring(2);
          System.out.println("expression set to: " + this.expression);
          break;
        case 'I':
          this.isInfix = true;
          System.out.println("Expression is now infix");
          break;
        case 'P':
          this.isInfix = false;
          System.out.println("Expression is now postfix");
          break;
        case 'R':
          this.expression = null;
          System.out.println("Expression reset");
          break;
        case 'Q':
          System.out.println("Exiting program...");
          scanner.close();
          running = false;
          break;
        default:
          System.out.println("Invalid entry please try again.");
          break;
      }
    }
  }


}
