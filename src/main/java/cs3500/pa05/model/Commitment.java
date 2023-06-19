package cs3500.pa05.model;

/**
 * Represents a commitment in a day.
 */
public abstract class Commitment {
  private String name;

  private String description;

  private Day day;

  /**
   * Constructs a commitment with the given name, description, and day.
   *
   * @param name        the commitment's name
   * @param description the commitment's description
   * @param day         the day of the commitment
   */
  public Commitment(String name, String description, Day day) {
    this.name = name;
    this.description = description;
    this.day = day;
  }

  /**
   * Returns the name of this commitment.
   *
   * @return the name of this commitment
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the description of this commitment.
   *
   * @return the description of this commitment
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns the day of this commitment.
   *
   * @return the day of this commitment
   */
  public Day getDay() {
    return this.day;
  }
}
