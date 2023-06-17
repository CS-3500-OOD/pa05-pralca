package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task in a day.
 */
public class Task extends Commitment {

  private boolean complete = false;

  /**
   * Constructs a task with the given name, description, and day.
   *
   * @param name        the task's name
   * @param description the task's description
   * @param day         the day of the task
   */
  public Task(@JsonProperty("name") String name, @JsonProperty("description") String description,
              @JsonProperty("day") Day day) {
    super(name, description, day);
  }
}
