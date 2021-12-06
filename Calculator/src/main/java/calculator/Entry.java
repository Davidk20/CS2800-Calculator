package calculator;

import java.util.Objects;

/**
 * This class is a container for the value within the {@code Stack}.
 *
 * @author David Kidd
 *
 */
public class Entry {

  float number;
  Symbol symbol;
  String str;
  Type type;


  /**
   * Initialises the {@code Entry} with a {@code Symbol}.
   *
   * @param symbol The {@code Symbol} representing this entry
   *
   */
  public Entry(Symbol symbol) {
    this.symbol = symbol;
    this.type = Type.SYMBOL;
  }

  /**
   * Initialises the {@code Entry} with a number.
   *
   * @param value The {@code float} value for this entry.
   */
  public Entry(Float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Initialises the {@code Entry} with a String.
   *
   * @param string The {@code String} value for this entry.
   */
  public Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
  }


  /**
   * Gets the {@code Type} of entry.
   *
   * @return the {@code Type} of entry
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Returns the {@code Number} of the entry. If the {@code Type} of the entry is not {@code NUMBER}
   * then an exception is thrown.
   *
   * @return the Number of the entry
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the entry is not {@code NUMBER}
   */
  public float getNumber() throws InvalidEntryTypeException {
    if (this.getType() == Type.NUMBER) {
      return number;
    } else {
      throw new InvalidEntryTypeException("This entry is not of type NUMBER.");
    }
  }

  /**
   * Returns the {@code Symbol} of the entry. If the {@code Type} of the entry is not {@code SYMBOL}
   * then an exception is thrown.
   *
   * @return The symbol of the entry.
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the entry is not {@code SYMBOL}
   */
  public Symbol getSymbol() throws InvalidEntryTypeException {
    if (this.getType() == Type.SYMBOL) {
      return symbol;
    } else {
      throw new InvalidEntryTypeException("This entry is not of type SYMBOL.");
    }
  }

  /**
   * Returns the {@code Str} of the entry. If the {@code Type} of the entry is not {@code STRING}
   * then an exception is thrown.
   *
   * @return The symbol of the entry.
   * @throws InvalidEntryTypeException thrown if the {@code Type} of the entry is not {@code STRING}
   */
  public String getStr() throws InvalidEntryTypeException {
    if (this.getType() == Type.STRING) {
      return str;
    } else {
      throw new InvalidEntryTypeException("This entry is not of type STRING.");
    }
  }

  @Override
  public String toString() {
    switch (this.type) {
      case SYMBOL:
        return "Symbol = " + this.symbol.toString();
      case NUMBER:
        return "Number = " + this.number;
      case STRING:
        return "String = " + this.str;
      default:
        // The default case is to return invalid as if it is not one of the types above then by
        // elimination it must be invalid.
        return "INVALID ENTRY";
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, str, symbol, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && Objects.equals(str, other.str) && symbol == other.symbol && type == other.type;
  }

}
