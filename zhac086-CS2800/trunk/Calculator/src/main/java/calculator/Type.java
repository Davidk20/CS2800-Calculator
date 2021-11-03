package calculator;

/**
 * Contains the types that an {@code Entry} class can be.
 *
 * @author David Kidd
 * 
 */
public enum Type {
  /**
   * Describes a number which is of type {@code float}.
   */
  NUMBER,

  /**
   * Describes a {@link Symbol}.
   */
  SYMBOL,
  /**
   * Describes a {@code String}.
   */
  STRING,
  /**
   * Describes an invalid entry, anything which cannot be categorised by one of the other types
   * within {@code Type}.
   */
  INVALID
}
