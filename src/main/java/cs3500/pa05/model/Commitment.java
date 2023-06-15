package cs3500.pa05.model;

public abstract class Commitment {
  private String name;

  private String description;

  private Day day;

  public Commitment(String name, String description, Day day) {
    this.name = name;
    this.description = description;
    this.day = day;
  }
}
