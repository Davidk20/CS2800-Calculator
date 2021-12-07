package calculator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class handles the interaction between the FXML and JavaFX within the application.
 *
 * @author David Kidd
 */
public class GuiView extends Application implements ViewInterface {
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
  private Button evaluateButton;
  /**
   * One of the two buttons used to select expression type (infix).
   */
  @FXML
  private RadioButton isInfix;
  /**
   * One of the two buttons used to select expression type (postfix).
   */
  @FXML
  private RadioButton isPostfix;
  /**
   * The group containing the two radio buttons used to facilitate toggling between states.
   */
  @FXML
  private ToggleGroup expressionType;

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Pane page = (Pane) FXMLLoader.load(getClass().getResource("/mainScreen.fxml"));
    Scene scene = new Scene(page);
    stage.setScene(scene);
    stage.setTitle("Calculator");
    stage.setResizable(false);
    stage.show();
  }

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    outputField.setText(answer);
  }

  @Override
  public void addCalcObserver(boolean isInfix) {
    // TODO Auto-generated method stub
    
  }



}
