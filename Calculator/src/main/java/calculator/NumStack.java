package calculator;

import java.util.EmptyStackException;

/**
 * Class representation of a Stack of numbers. Used as a facade to hide unnecessary constructors and
 * methods that are not used by a stack involving .
 *
 * @author David Kidd
 */
public class NumStack {

  /**
   * The stack being protected by the facade {@code NumStack}.
   */
  Stack numStack = new Stack();

  public Integer getSize() {
    return numStack.getSize();
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
   * @param f The float to be added onto the stack.
   */
  public void push(float f) {
    numStack.push(new Entry(f));
  }


  /**
   * Returns and removes the top {@code Float} in the stack. Uses the method contained in
   * {@code Stack}.
   *
   * @return The number on top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public Float pop() throws EmptyStackException {
    try {
      return numStack.pop().getNumber();
    } catch (InvalidEntryTypeException e) {
      return Float.POSITIVE_INFINITY; // This case never occurs as NumStack controls all inputs of
                                      // the stack.
    }
  }



}
