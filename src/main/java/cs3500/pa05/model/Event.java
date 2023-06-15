package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event extends Commitment {

  private Time startTime;

  // Duration in minutes
  private int duration;

  public Event(@JsonProperty("name") String name, @JsonProperty("description") String description,
               @JsonProperty("day") Day day, @JsonProperty("start-time") Time startTime,
               @JsonProperty("duration") int duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }
}
