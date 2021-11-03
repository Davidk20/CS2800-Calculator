package calculator;

/**
 * Contains all the symbols that could be used for an {@code Entry}.
 *
 * @author David Kidd
 *
 */
public enum Symbol {

  /**
   * Describes a round left bracket "(".
   */
  LEFT_BRACKET("("),
  /**
   * Describes a round right bracket ")".
   */
  RIGHT_BRACKET(")"),
  /**
   * Describes a multiplication symbol "*".
   */
  TIMES("*"),
  /**
   * Describes a division symbol "/".
   */
  DIVIDE("/"),
  /**
   * Describes an addition symbol "+".
   */
  PLUS("+"),
  /**
   * Describes a subtraction symbol "-".
   */
  MINUS("-"),
  /**
   * Describes an invalid symbol, one which does not fit into any other {@code Symbol}.
   */
  INVALID("Invalid");

  public final String symbolRef;

  private Symbol(String ref) {
    this.symbolRef = ref;
  }

  @Override
  public String toString() {
    return symbolRef;
  }
}
