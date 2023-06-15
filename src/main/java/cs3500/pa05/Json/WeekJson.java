package cs3500.pa05.Json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeekJson(@JsonProperty("days") DayJson[] days,
                       @JsonProperty("max-tasks") int maxTasks,
                       @JsonProperty("max-events") int maxEvents,
                       @JsonProperty("theme") String theme) {
}
