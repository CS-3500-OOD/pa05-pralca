package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Json view of a BuJo week
 *
 * @param days      the days in a week
 * @param maxTasks  the max number of tasks per day
 * @param maxEvents the max number of events per day
 * @param theme     the current theme of the BuJo
 */
public record WeekJson(@JsonProperty("days") DayJson[] days,
                       @JsonProperty("max-tasks") int maxTasks,
                       @JsonProperty("max-events") int maxEvents,
                       @JsonProperty("theme") String theme,
                       @JsonProperty("month") String month,
                       @JsonProperty("week-of") String weekOf) {
}
