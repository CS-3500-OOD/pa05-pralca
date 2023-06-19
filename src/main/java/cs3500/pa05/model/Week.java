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

  private String month = "January";

  private String weekOf = "Jan 1";

  /**
   * Creates a week with the default settings.
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

  /**
   * Returns the days in this week
   *
   * @return the days in this week
   */
  public Day[] getDays() {
    return this.days;
  }

  /**
   * Sets the value of this week's month to the given value
   */
  public void setMonth(String month) {
    this.month = month;
  }

  /**
   * Returns the max number of events for this week
   *
   * @return the max number of events for this week
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * Returns the max number of tasks for this week
   *
   * @return the max number of tasks for this week
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  /**
   * Returns the theme of this week
   *
   * @return the theme of this week
   */
  public Theme getTheme() {
    return this.theme;
  }

  /**
   * Returns the month of this week
   *
   * @return the month of this week
   */
  public String getMonth() {
    return this.month;
  }

  /**
   * Returns the week of this week
   *
   * @return the week of this week
   */
  public String getWeekOf() {
    return this.weekOf;
  }
}
