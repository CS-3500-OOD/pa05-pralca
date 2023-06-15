package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Theme {
  DEFAULT,
  DARK,
  COLORFUL;

  public String toString() {
    switch (this) {
      case DEFAULT:
        return "Default";
      case DARK:
        return "Dark";
      case COLORFUL:
        return "Colorful";
      default:
        throw new IllegalArgumentException("Invalid theme");
    }
  }

  public static Theme fromString(String s) {
    switch (s) {
      case "Default":
        return DEFAULT;
      case "Dark":
        return DARK;
      case "Colorful":
        return COLORFUL;
      default:
        throw new IllegalArgumentException("Invalid theme");
    }
  }
}
