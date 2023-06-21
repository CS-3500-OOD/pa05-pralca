package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TimeJson(
    @JsonProperty("hour") int hour,
    @JsonProperty("minute") int minute) {

  public Time toTime() {
    return new Time(hour, minute);
  }
}
