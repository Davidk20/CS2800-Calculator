package calculator;

import java.util.function.Consumer;

/**
 * Interface to create a relationship between the two different View classes (GuiView and
 * AsciiView).
 *
 * @author David Kidd
 */
public interface ViewInterface {
  
  
  /**
   * Collects the user input and returns as a {@code String}.
   *
   * @return The expression passed in by the user.
   */
  public String getExpression();
  
  /**
   * Returns the answer to the user as a {@code String}.
   *
   * @param answer The result of the expression being evaluated.
   */
  public void setAnswer(String answer);
  
  public void addCalcObserver(boolean isInfix);
  
}
