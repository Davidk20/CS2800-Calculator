package calculator;

/**
 * Creates the view and model. Observes the view so that changes can be observed.
 *
 * @author David Kidd
 */
public class Controller {
  CalculatorModel model;
  ViewInterface view;
  
  public Controller(CalculatorModel model, ViewInterface view) {
    this.model = model;
    this.view = view;
  }
  
  public Float calculate(String expression, boolean isInfix) throws InvalidExpressionException {
    return this.model.evaluate(expression, isInfix);
  }
  
}
