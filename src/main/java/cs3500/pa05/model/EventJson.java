package cs3500.pa05.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents the record for an event
 *
 * @param name name of event
 * @param description description of event
 * @param day day of event
 * @param time start time of event
 * @param duration duration of event
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("start-time") TimeJson time,
    @JsonProperty("duration") int duration) {

  public Event toEvent() {
    return new Event(name, description, day, time.toTime(), duration);
  }
}
