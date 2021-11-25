package calculator;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representation of a Stack of Strings. Since the shunting algorithm only uses a Stack of
 * Strings, we provide a facade to hide details.
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

  /**
   * Reverses the stack by popping all elements off into a temporary list and then pushing them back
   * on in the order they were popped off as the First-In-First-Out nature of stacks means that this
   * will naturally reverse the stack.
   */
  public void reverse() {
    List<String> tempStack = new LinkedList<>();
    while (true) {
      try {
        tempStack.add(strStack.pop().getStr());
      } catch (EmptyStackException e) {
        break;
      } catch (InvalidEntryTypeException e) {
        // Empty catch block as the strStack will always contain entries of type string.
      }
    }
    // Collections.reverse(tempStack);
    for (String s : tempStack) {
      push(s);
    }
  }


}