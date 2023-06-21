package cs3500.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that contains tests for all the methods from the week class
 */
public class WeekTest {
  Week newWeek;

  @BeforeEach
  public void setUp() {
    newWeek = new Week();
  }

  @Test
  public void testGetDays() {
    Assertions.assertEquals(7, newWeek.getDays().length);
  }

  @Test
  public void testGetMonth() {
    Assertions.assertEquals("January", newWeek.getMonth());
  }

  @Test
  public void testGetWeekOf() {
    Assertions.assertEquals("Jan 1", newWeek.getWeekOf());
  }

  @Test
  public void testGetTheme() {
    Assertions.assertEquals(Theme.DEFAULT, newWeek.getTheme());
  }

  @Test
  public void testSetMonth() {
    newWeek.setMonth("February");
    Assertions.assertEquals("February", newWeek.getMonth());
  }

  @Test
  public void testSetMaxTasks() {
    newWeek.setMaxTasks(5);
    Assertions.assertEquals(5, newWeek.getMaxTasks());
  }

  @Test
  public void testSetMaxEvents() {
    newWeek.setMaxEvents(5);
    Assertions.assertEquals(5, newWeek.getMaxEvents());
  }

  @Test
  public void testAddDay() {
    Week week = new Week("test");
    // Create a Day object for testing
    Day day = new Day("Monday");

    // Add the day to the week
    week.addDay(day);

    // Verify that the day was added successfully
    Assertions.assertEquals(day, week.getDays()[0]);
  }

  @Test
  public void testAddDay_WeekFull() {
    Week week = new Week();
    // Create a Day object for testing
    Day day = new Day("Monday");

    // Fill up the week with dummy days
    for (int i = 0; i < week.getDays().length; i++) {
      assertThrows(IllegalStateException.class, () -> week.addDay(new Day("Dummy")));
    }
  }

}
