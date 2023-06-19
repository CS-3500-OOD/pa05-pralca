package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Represents a controller for a Java Bullet Journal
 */
public class BujoController {
  private Week week;

  private Stage stage;

  private Popup taskPopup;

  private Popup eventPopup;

  private Popup loadFilePopup;

  private Popup saveFilePopup;

  @FXML
  private Button taskButton;

  @FXML
  private Button eventButton;

  @FXML
  private Button openButton;

  @FXML
  private Button saveButton;

  @FXML
  private TextField monthField;

  @FXML
  private TextField weekOfField;

  @FXML
  private MenuButton dayTaskBar;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField descriptionTextField;

  @FXML
  private VBox Monday;

  @FXML
  private VBox Tuesday;

  @FXML
  private VBox Wednesday;

  @FXML
  private VBox Thursday;

  @FXML
  private VBox Friday;

  @FXML
  private VBox Saturday;

  @FXML
  private VBox Sunday;

  private String taskName;

  private String taskDescription;

  public BujoController(Week week, Stage stage) {
    this.week = week;
    this.stage = stage;
  }

  /**
   * Initializes a game of Java Bullet Journal.
   */
  public void run() {

    this.taskPopup = new Popup();
    initPopupButton(this.taskButton, this.taskPopup, "taskScene.fxml");

    this.eventPopup = new Popup();
    initPopupButton(this.eventButton, this.eventPopup, "eventScene.fxml");

    this.loadFilePopup = new Popup();
    initPopupButton(this.openButton, this.loadFilePopup, "openFileScene.fxml");

    this.saveFilePopup = new Popup();
    initPopupButton(this.saveButton, this.saveFilePopup, "saveFileScene.fxml");

    this.monthField.setText(this.week.getMonth());
    this.monthField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));

    this.weekOfField.setText(this.week.getWeekOf());
    this.weekOfField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));


  }

  /**
   * Loads a selected .bujo file into a Java Bullet Journal.
   */
  private void loadFile(String filename) {
    // TODO: Implement
  }

  /**
   * Saves a Java Bullet Journal to a .bujo file.
   */
  private void saveFile(String filename) {
    // TODO: Implement
  }

  /**
   * Adds a task to a Java Bullet Journal.
   */
  private void addTaskFromPopup() {

    //String selectedDay = this.dayTaskBar.getText();
    String selectedDay = "Monday";

    Day day = this.week.getDays()[Day.getDayIndex(selectedDay)];

    Task task = new Task(this.taskName, this.taskDescription, day);
    day.addTask(task);

    Label taskLabel = new Label(task.toString());
    taskLabel.setOnMouseClicked(event -> handleLabelClick(taskLabel, task));
    getVBox(selectedDay).getChildren().add(taskLabel);
  }

  /**
   * Handles clicking a task label in a Java Bullet Journal.
   */
  private void handleLabelClick(Label taskLabel, Task task) {
    task.setComplete(!task.isComplete());
    taskLabel.setText(task + "\n [COMPLETE]");
  }

  /**
   * Returns the correct VBox for a given string
   *
   * @param day the string representing the day
   * @return the correct VBox
   */
  private VBox getVBox(String day) {
    switch (day.toLowerCase()) {
      case "monday":
        return this.Monday;
      case "tuesday":
        return this.Tuesday;
      case "wednesday":
        return this.Wednesday;
      case "thursday":
        return this.Thursday;
      case "friday":
        return this.Friday;
      case "saturday":
        return this.Saturday;
      case "sunday":
        return this.Sunday;
      default:
        throw new IllegalArgumentException("No such day");
    }
  }

  /**
   * Initializes the task button in a Java Bullet Journal.
   */
  private void initPopupButton(Button button, Popup popup, String popupFilename) {
    button.setOnAction(event -> showPopup(popup));

    try {
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource(popupFilename));
      loader.setController(this);

      Scene s = loader.load();

      popup.getContent().add(s.getRoot());

      Button b = new Button("Done!");
      b.setTranslateX(100);
      b.setOnAction(e -> popup.hide());

      popup.getContent().add(b);
      popup.setOnHidden(e -> handleHiddenPopup(button));

      this.nameTextField.setOnKeyTyped(
          event -> this.taskName = this.nameTextField.getText());
      this.descriptionTextField.setOnKeyTyped(
          event -> this.taskDescription = this.descriptionTextField.getText());

    } catch (IOException e) {
      System.err.println("Unable to load popup.");
    }
  }

  /**
   * Handles a hidden popup in a Java Bullet Journal.
   */
  private void handleHiddenPopup(Button button) {
    if (button == this.taskButton) {
      addTaskFromPopup();
    }
  }

  /**
   * Shows a dialog for a task in a Java Bullet Journal.
   */
  private void showPopup(Popup popup) {
    popup.show(this.stage);
  }
}
