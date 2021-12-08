package calculator;

/**
 * Creates the view and model. Observes the view so that changes can be observed.
 *
 * @author David Kidd
 */
public class Controller {
  /**
   * The model for the calculator allowing the controller to access both types of calculation.
   */
  CalculatorModel model;
  /**
   * The view for the controller to observe.
   */
  ViewInterface view;

  /**
   * Constructor for {@code Controller}.
   *
   * @param view The view for the controller to observe. Either {@code GuiView} or
   *        {@code AsciiView}.
   */
  public Controller(ViewInterface view) {
    this.model = new CalculatorModel();
    this.view = view;
    this.view.addCalcObserver(this);
  }

  /**
   * Handles the calculation of the expression returning the result to the GUI. If an error occurs
   * during evaluation, the error message is instead returned to the GUI.
   */
  public void handleCalculate() {
    try {
      Float result = this.model.evaluate(this.view.getExpression(), this.view.getExpressionType());
      this.view.setAnswer(result.toString());
    } catch (InvalidExpressionException e) {
      this.view.setAnswer(e.getMessage());
    }
  }
}
