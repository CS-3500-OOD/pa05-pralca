package cs3500.pa05.model;

/**
 * Represents a week in a Java Bullet Journal
 */
public class Week {
  private Day[] days;

  // If maxEvents or maxTasks is -1, then there is no limit
  private int maxEvents;

  // If maxEvents or maxTasks is -1, then there is no limit
  private int maxTasks;

  private Theme theme = Theme.DEFAULT;

  /**
   * Creates a week with the default setings.
   */
  public Week() {
    this.days = new Day[7];
    this.maxEvents = -1;
    this.maxTasks = -1;

    initDays();
  }

  /**
   * Populates this week's days with emote days
   */
  private void initDays() {
    this.days[0] = new Day("Monday");
    this.days[1] = new Day("Tuesday");
    this.days[2] = new Day("Wednesday");
    this.days[3] = new Day("Thursday");
    this.days[4] = new Day("Friday");
    this.days[5] = new Day("Saturday");
    this.days[6] = new Day("Sunday");
  }

  public Day[] getDays() {
    return this.days;
  }
}
