package calculator;

import java.util.EmptyStackException;

/**
 * Class representation of a Stack of Symbols (Operators). Since the shunting algorithm only uses a
 * Stack of symbols, we provide a facade to hide details.
 *
 * @author David Kidd
 */
public class OpStack {
  /**
   * The stack being protected by the facade {@code OpStack}.
   */
  Stack opStack = new Stack();


  /**
   * Returns the size of the stack.
   *
   * @return The size of the stack.
   */
  private int getSize() {
    return this.opStack.getSize();
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
   * @param symbol The symbol to be added onto the stack.
   */
  public void push(Symbol symbol) {
    opStack.push(new Entry(symbol));
  }


  /**
   * Returns and removes the top {@code Symbol} in the stack. Uses the method contained in
   * {@code Stack}.
   *
   * @return The symbol on top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public Symbol pop() throws EmptyStackException {
    try {
      return opStack.pop().getSymbol();
    } catch (InvalidEntryTypeException e) {
      return Symbol.INVALID;
      // This case never occurs as OpStack controls all inputs of the stack.
      // This means that it will never be covered in test and therefore will not pass coverage.
    }
  }

  /**
   * Returns the {@code Symbol} on the top of the stack without removing it.
   *
   * @return The {@code Symbol} on the top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public Symbol top() throws EmptyStackException {
    try {
      return opStack.top().getSymbol();
    } catch (InvalidEntryTypeException e) {
      return null;
      // Empty catch block as this case never occurs as OpStack controls all inputs of the stack.
      // This means that it will never be covered in test and therefore will not pass coverage.
    }
  }

}
