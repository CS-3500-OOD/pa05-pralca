package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a theme of a BuJo
 */
public enum Theme {
  DEFAULT,
  DARK,
  COLORFUL;

  /**
   * Returns the string representation of this theme.
   *
   * @return the string representation of this theme
   */
  public String toString() {
    switch (this) {
      case DEFAULT:
        return "DEFAULT";
      case DARK:
        return "DARK";
      case COLORFUL:
        return "COLORFUL";
      default:
        throw new IllegalArgumentException("Invalid theme");
    }
  }

  /**
   * Returns the theme represented by the given string.
   *
   * @param s the string representation of the theme
   * @return the theme represented by the given string
   */
  public static Theme fromString(String s) {
    switch (s) {
      case "DEFAULT":
        return DEFAULT;
      case "DARK":
        return DARK;
      case "COLORFUL":
        return COLORFUL;
      default:
        throw new IllegalArgumentException("Invalid theme");
    }
  }
}
