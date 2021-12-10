package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * The controller for the GUI, handles the action of the calculate button and notifies the
 * {@code CalculatorController} on when to act.
 *
 * @author David Kidd
 */
public class GuiController implements ViewInterface {
  /**
   * The text field for the user to enter their expression.
   */
  @FXML
  private TextField inputField;
  /**
   * The text field for the user to see the result of their expression.
   */
  @FXML
  private TextField outputField;
  /**
   * The button to trigger evaluation.
   */
  @FXML
  private Button evaluateButton = null;
  /**
   * One of the two buttons used to select expression type (infix).
   */
  @FXML
  private RadioButton isInfix;

  CalculatorController observer = CalculatorController.getInstance();

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public boolean getExpressionType() {
    return isInfix.isSelected();
  }

  @Override
  public void setAnswer(String answer) {
    outputField.setText(answer);
  }


  /**
   * The {@code OnAction} method from the GUI, the method is notified when the user wants to
   * calculate and handles sending the calculation to the controller.
   *
   * @param event The{@code OnAction} event from JavaFX.
   */
  public void handleCalculate(ActionEvent event) {
    this.observer.handleCalculate();
  }

}
