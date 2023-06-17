package cs3500.pa05.model;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;

/**
 * Represents a Json view of a day.
 */
public record DayJson(String name, Task[] tasks, Event[] events) {
}
