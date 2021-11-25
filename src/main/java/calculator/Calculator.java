package calculator;


/**
 * Model for a calculator. {@code Calculator} is a singleton as only one instance of the calculator
 * is needed during runtime. Methods to create Singleton are used with thanks to Dave Cohen and are
 * taken from the "MVC-separated" example of code on Moodle.
 *
 * @see <a href="https://moodle.royalholloway.ac.uk/course/view.php?id=1470&sectionid=141860">
 *      Moodle - MVC-Separated</a>
 *
 * @author David Kidd, Dave Cohen
 */
public final class Calculator {

  /**
   * Private constructor for {@code Calculator} so that this class can only be instantiated from
   * inside the class itself to limit creation to a single instance.
   */
  private Calculator() {}

  /**
   * The (exactly) one instance of this class. Created in a lazy manner when it is required.
   */
  private static Calculator instance = null;

  /**
   * The hook to access this Singleton Calculator. Instantiated in a lazy way - Only created when
   * needed to save resources. If the Calculator hasn't been created then a new {@code Calculator}
   * is created, otherwise the existing {@code Calculator} is returned.
   *
   * @return The instance of {@code Calculator}.
   */
  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    return instance;
  }


  /**
   * Method evaluates and calculates a {@code String} expression.
   *
   * @param expression The expression to be evaluated.
   * @return The output of the expression.
   * @throws InvalidExpression Thrown if the expression passed in is invalid.
   */
  public float evaluate(String expression) throws InvalidExpression {
    throw new InvalidExpression(null);
  }

}
