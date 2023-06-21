package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents in an event in a day.
 */
public class Event extends Commitment {

  private Time startTime;

  // Duration in minutes
  private int duration;

  /**
   * Constructs an event with the given name, description, day, start time, and duration.
   *
   * @param name        the event's name
   * @param description the event's description
   * @param day         the day of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   */
  public Event(@JsonProperty("name") String name, @JsonProperty("description") String description,
               @JsonProperty("day") Day day, @JsonProperty("start-time") Time startTime,
               @JsonProperty("duration") int duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Getter method for returning the startTime of the event.
   * @return the start time of the event
   */
  public Time getStartTime() {
      return this.startTime;
  }
}
