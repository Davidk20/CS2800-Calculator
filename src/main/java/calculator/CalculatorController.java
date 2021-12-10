package calculator;

/**
 * Creates the view and model. Observes the view so that changes can be acted upon.
 *
 * @author David Kidd
 */
public class CalculatorController {
  /**
   * The model for the calculator allowing the controller to access both types of calculation.
   */
  CalculatorModel model = new CalculatorModel();
  /**
   * The view for the controller to observe.
   */
  ViewInterface view;


  // Singleton implementation - inspiration taken from MVCJavaFX example on moodle.
  
  private static CalculatorController instance = null;
  
  /**
   * Returns the singular instance of GuiView or creates one if it has not been created yet.
   *
   * @return The instance of GuiView.
   */
  public static CalculatorController getInstance() {
    if (instance == null) {
      instance = new CalculatorController();
    }
    return instance;
  }

  /**
   * Sets the view for the controller.
   *
   * @param view The view to be set.
   */
  public void setView(ViewInterface view) {
    this.view = view;
  }
  
  /**
   * Handles the calculation of the expression returning the result to the view. If an error occurs
   * during evaluation, the error message is instead returned to the view.
   */
  public void handleCalculate() {
    try {
      Float result = this.model.evaluate(this.view.getExpression(), this.view.getExpressionType());
      this.view.setAnswer(result.toString());
    } catch (InvalidExpressionException e) {
      this.view.setAnswer(e.getMessage().substring(21));
    }
  }
}
