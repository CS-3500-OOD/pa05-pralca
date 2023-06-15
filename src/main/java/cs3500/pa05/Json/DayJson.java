package cs3500.pa05.Json;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;

public record DayJson(String name, Task[] tasks, Event[] events) {
}
