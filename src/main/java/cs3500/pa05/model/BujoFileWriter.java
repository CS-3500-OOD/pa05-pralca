package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that contains methods to write a Bullet Journal to a file.
 */
public class BujoFileWriter {
  public static void writeBujo(Week week, String path) {
    try {
      FileWriter myWriter = new FileWriter(path);
      myWriter.write(weekToJson(week).toString());
      myWriter.close();
    } catch (IOException e) {
      // write failed
    }
  }

  public static JsonNode weekToJson(Week week) {
    DayJson[] dayJsons = new DayJson[7];
    Day[] days = week.getDays();
    for (int i = 0; i < 7; i++) {
      dayJsons[i] = dayToJson(days[i]);
    }
    WeekJson weekJson = new WeekJson(dayJsons, week.getMaxTasks(), week.getMaxEvents(),
        week.getTheme().toString(), week.getMonth(), week.getWeekOf());
    return JsonUtils.serializeRecord(weekJson);
  }

  private static DayJson dayToJson(Day day) {
    Task[] tasks = day.getTasks().toArray(new Task[0]);
    Event[] events = day.getEvents().toArray(new Event[0]);

    return new DayJson(day.getName(), tasks, events);
  }
}
