package calculator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class handles the interaction between the FXML and JavaFX within the application.
 *
 * @author David Kidd
 */
public class GuiView extends Application {
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
