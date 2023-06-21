package cs3500.test;

import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that contains all the methods from the week class
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

}
