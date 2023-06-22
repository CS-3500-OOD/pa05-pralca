package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a timeJson object
 *
 * @param hour represents the hour
 * @param minute represents the minute
 */
public record TimeJson(
    @JsonProperty("hour") int hour,
    @JsonProperty("minute") int minute) {

  public Time toTime() {
    return new Time(hour, minute);
  }
}
