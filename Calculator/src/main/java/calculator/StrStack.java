package calculator;

import java.util.EmptyStackException;

/**
 * Class representation of a Stack of Strings. Since the shunting algorithm only uses a
 * Stack of Strings, we provide a facade to hide details.
 *
 * @author David Kidd
 */
public class StrStack {
  Stack strStack = new Stack();
  
  /**
   * Returns the size of the stack.
   *
   * @return The size of the stack.
   */
  private int getSize() {
    return this.strStack.getSize();
  }
  
  /**
   * Checks if the stack is empty. Returns empty even if the stack is negative as a protection case.
   *
   * @return true if the stack is empty.
   */
  public boolean isEmpty() {
    return getSize() <= 0;
  }

  /**
   * Pushes onto the stack. Uses the method contained in {@code Stack}.
   *
   * @param string The symbol to be added onto the stack.
   */
  public void push(String string) {
    strStack.push(new Entry(string));
  }
  
  /**
   * Returns and removes the top {@code String} in the stack. Uses the method contained in
   * {@code Stack}.
   *
   * @return The String on top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public String pop() throws EmptyStackException {
    try {
      return strStack.pop().getStr();
    } catch (InvalidEntryTypeException e) {
      return null; 
      // This case never occurs as OpStack controls all inputs of the stack.
    }
  }
  
  
}
