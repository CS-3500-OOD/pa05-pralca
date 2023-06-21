package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") Day day) {

  public Task toTask() {
    return new Task(name, description, day);
  }
}
