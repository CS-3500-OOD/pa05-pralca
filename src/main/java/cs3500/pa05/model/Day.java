package cs3500.pa05.model;

import java.util.ArrayList;

/**
 * Represents a day in a week.
 */
public class Day {
  private String name;

  private ArrayList<Task> tasks;

  private ArrayList<Event> events;

  /**
   * Constructs a day with the given name.
   *
   * @param name the day's name
   */
  public Day(String name) {
    this.name = name;
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
  }

  /**
   * Returns the name of this day
   *
   * @return the name of this day
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns this day's tasks.
   *
   * @return this day's tasks
   */
  public ArrayList<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Returns this day's events.
   *
   * @return this day's events
   */
  public ArrayList<Event> getEvents() {
    return this.events;
  }
}
