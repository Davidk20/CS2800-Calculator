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
public class GuiView extends Application {
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
  /**
   * Controller observes changes in the state of the GUI and handles operations triggered by events.
   */
  
  FXMLLoader loader;
  
  
  // Singleton implementation
  
  private static GuiView instance = null;
  
  @FXML
  private void initialize() {
    instance = this;
  }
  
  /**
   * Returns the singular instance of GuiView or creates one if it has not been created yet.
   *
   * @return The instance of GuiView.
   */
  public static GuiView getInstance() {
    if (instance == null) {
      GuiView.launch();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }
    return instance;
  }
    
  @Override
  public void start(Stage stage) throws Exception {
    loader = new FXMLLoader(getClass().getResource("/mainScreen.fxml"));
    Pane page = (Pane) loader.load();
    CalculatorController.getInstance().setView(loader.getController());
    Scene scene = new Scene(page);
    stage.setScene(scene);
    stage.setTitle("Calculator");
    stage.setResizable(false);
    stage.show();
  }
}
