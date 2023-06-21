package cs3500.pa05.model;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;

/**
 * Represents a Json view of a day.
 */
public record DayJson(String name, Task[] tasks, Event[] events) {

  /**
   * Returns the day represented by this Json
   *
   * @return the day represented by this Json
   */
  public Day toDay() {
    Day day = new Day(this.name);
    for (Task task : this.tasks) {
      day.addTask(task);
    }
    for (Event event : this.events) {
      day.addEvent(event);
    }
    return day;
  }
}
