package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Week;

/**
 * Represents a controller for a Java Bullet Journal
 */
public class BujoController {
  private Week week;

  public BujoController(Week week) {
    this.week = week;
  }

  /**
   * Initializes a game of Java Bullet Journal.
   */
  public void run() {
    for (Day day : this.week.getDays()) {
      initDay(day);
    }
    initSideBar();
    initBackground();
  }

  private void initDay(Day day) {
    // TODO: Implement this method
  }

  private void initSideBar() {
    // TODO: Implement this method
  }

  private void initBackground() {
    // TODO: Implement this method
  }
}
