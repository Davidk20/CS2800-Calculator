package calculator;


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
  public int getSize() {
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

}