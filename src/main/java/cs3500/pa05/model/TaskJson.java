package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * record for representing a task
 *
 * @param name name of task
 * @param description description of task
 * @param day day of task
 * @param complete whether task is complete
 */
public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("complete") boolean complete) {

  public Task toTask() {
    return new Task(name, description, day);
  }
}
