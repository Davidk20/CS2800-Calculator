package calculator;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a stack of {@code Entry}'s and it's associated methods.
 *
 * @author David Kidd
 */
public class Stack {
  int size = 0;
  List<Entry> entries = new LinkedList<Entry>();


  /**
   * Returns the size of the stack.
   *
   * @return the size of the stack
   */
  public Integer getSize() {
    return size;
  }


  /**
   * Pushes the {@code Entry} onto the stack and increments the size of the stack by 1.
   *
   * @param entry The entry to be added to the stack
   */
  public void push(Entry entry) {
    entries.add(entry);
    size += 1;
  }


  /**
   * Returns the {@code Entry} on the top of the stack without removing it from the stack.
   *
   * @return The {@code Entry} on the top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public Entry top() throws EmptyStackException {
    try {
      return entries.get(this.size - 1);
    } catch (IndexOutOfBoundsException exception) {
      throw new EmptyStackException();
    }
  }


  /**
   * Returns and removes the {@code Entry} on the top of the stack.
   *
   * @return The {@code Entry} on the top of the stack.
   * @throws EmptyStackException Thrown if the stack is empty.
   */
  public Entry pop() throws EmptyStackException {
    try {
      Entry top = top();
      entries.remove(this.size - 1);
      this.size -= 1;
      return top;
    } catch (EmptyStackException exception) {
      throw new EmptyStackException();
    }
  }



}
