package cs3500.pa05.model;

import java.util.ArrayList;

public class Day {
  private String name;

  private ArrayList<Task> tasks;

  private ArrayList<Event> events;

  public Day(String name) {
    this.name = name;
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
  }
}
