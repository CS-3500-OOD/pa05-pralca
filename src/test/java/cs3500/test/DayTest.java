package cs3500.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayTest {
  private Day day;

  @BeforeEach
  public void setup() {
    day = new Day("Monday");
  }

  @Test
  public void testGetName() {
    assertEquals("Monday", day.getName());
  }

  @Test
  public void testGetTasks() {
    ArrayList<Task> tasks = day.getTasks();
    assertNotNull(tasks);
    assertTrue(tasks.isEmpty());
  }

  @Test
  public void testGetEvents() {
    ArrayList<Event> events = day.getEvents();
    assertNotNull(events);
    assertTrue(events.isEmpty());
  }

  @Test
  public void testGetDayIndex() {
    assertEquals(0, Day.getDayIndex("monday"));
    assertEquals(1, Day.getDayIndex("tuesday"));
    assertEquals(2, Day.getDayIndex("wednesday"));
    assertEquals(3, Day.getDayIndex("thursday"));
    assertEquals(4, Day.getDayIndex("friday"));
    assertEquals(5, Day.getDayIndex("saturday"));
    assertEquals(6, Day.getDayIndex("sunday"));
  }

  @Test
  public void testGetDayIndexInvalidName() {
    assertThrows(IllegalArgumentException.class, () -> {
      Day.getDayIndex("invalid");
    });
  }
}
