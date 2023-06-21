package cs3500.test;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
  private Task newTask;
  @BeforeEach
  public void setup() {
      this.newTask = new Task(
          "Test on Monday",
          "Study for the test on Monday",
          new Day("Monday"));
  }

  @Test
  public void testToString() {
    Assertions.assertEquals
        ("Test on Monday\nStudy for the test on Monday", this.newTask.toString());
  }

  @Test
  public void testToStringWrong() {
    Assertions.assertNotEquals("Test on Tuesday\nStudy for the test on Monday",
        this.newTask.toString());
  }

  @Test
  public void testIsCompleteFalse() {
    Assertions.assertFalse(this.newTask.isComplete());
  }

  @Test
  public void testIsCompleteTrue() {
    this.newTask.setComplete(true);
    Assertions.assertTrue(this.newTask.isComplete());
  }
}