package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task extends Commitment {

  private boolean complete = false;

  public Task(@JsonProperty("name") String name, @JsonProperty("description") String description,
              @JsonProperty("day") Day day) {
    super(name, description, day);
  }
}
