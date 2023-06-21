package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.BujoView;
import java.io.IOException;
import java.util.Scanner;
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

  @FXML
  private TextField eventNameTextField;

  @FXML
  private TextField eventDescriptionTextField;

  @FXML
  private TextField eventStartTimeField;

  @FXML
  private TextField eventDurationField;

  @FXML
  private TextField eventDayField;

  @FXML
  private TextField taskDayField;

  @FXML
  private TextField commitEventField;

  @FXML
  private TextField commitTaskField;

  private String taskName;

  private String taskDescription;

  private String eventName;

  private String eventDescription;

  private String eventStartTime;

  private String eventDuration;

  private String taskDay;

  private String eventDay;

  private Scene taskScene;

  private Scene eventScene;

  private Scene openFileScene;

  private Scene saveFileScene;


  /**
   * Initializes a controller for a Java Bullet Journal.
   *
   * @param week  the week to be displayed
   * @param stage the stage to be displayed on
   */
  public BujoController(Week week, Stage stage) {
    this.week = week;
    this.stage = stage;
  }

  /**
   * Initializes a game of Java Bullet Journal.
   */
  public void run() {

    this.taskPopup = new Popup();
    this.taskScene = new BujoView(this).loadTask();

    this.nameTextField.setOnKeyTyped(
        event -> this.taskName = this.nameTextField.getText());
    this.descriptionTextField.setOnKeyTyped(
        event -> this.taskDescription = this.descriptionTextField.getText());
    this.taskDayField.setOnKeyTyped(event -> this.taskDay = this.taskDayField.getText());

    initPopupButton(this.taskButton, this.taskPopup, this.taskScene);

    this.eventPopup = new Popup();
    this.eventScene = new BujoView(this).loadEvent();

    this.eventNameTextField.setOnKeyTyped(
        event -> this.eventName = this.eventNameTextField.getText());
    this.eventDescriptionTextField.setOnKeyTyped(
        event -> this.eventDescription = this.eventDescriptionTextField.getText());
    this.eventStartTimeField.setOnKeyTyped(
        event -> this.eventStartTime = this.eventStartTimeField.getText());
    this.eventDurationField.setOnKeyTyped(event -> this.eventDuration = this.eventDurationField
        .getText());
    this.eventDayField.setOnKeyTyped(event -> this.eventDay = this.eventDayField.getText());

    initPopupButton(this.eventButton, this.eventPopup, this.eventScene);

    this.loadFilePopup = new Popup();
    this.openFileScene = new BujoView(this).loadOpen();
    initPopupButton(this.openButton, this.loadFilePopup, this.openFileScene);

    this.saveFilePopup = new Popup();
    this.saveFileScene = new BujoView(this).loadSave();
    initPopupButton(this.saveButton, this.saveFilePopup, this.saveFileScene);

    this.monthField.setText(this.week.getMonth());
    this.monthField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));

    this.weekOfField.setText(this.week.getWeekOf());
    this.weekOfField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));


  }

  /**
   * Loads a selected .bujo file into a Java Bullet Journal.
   */
  private void loadFile(String filename) {
    StringBuilder file = new StringBuilder();
    Scanner scanner = new Scanner(filename);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine() + "\n";
      file.append(line);
    }
    scanner.close();

    try {
      JsonNode json = new ObjectMapper().readTree(file.toString());
      // TODO
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
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
    Day day = this.week.getDays()[Day.getDayIndex(this.taskDay)];

    Task task = new Task(this.taskName, this.taskDescription, day);
    day.addTask(task);

    Label taskLabel = new Label(task.toString());
    taskLabel.setOnMouseClicked(event -> handleLabelClick(taskLabel, task));
    getVBox(this.taskDay).getChildren().add(taskLabel);
  }

  /**
   * Adds a task to a Java Bullet Journal.
   */
  private void addEventFromPopup() {

    Day day = this.week.getDays()[Day.getDayIndex(this.eventDay)];

    int hour = Integer.parseInt(this.eventStartTime.split(":")[0]);
    int minute = Integer.parseInt(this.eventStartTime.split(":")[1]);

    Event event = new Event(this.eventName, this.eventDescription, day, new Time(hour, minute),
        Integer.parseInt(this.eventDuration));
    day.addEvent(event);

    Label eventLabel = new Label(event.toString());
    getVBox(this.eventDay).getChildren().add(eventLabel);
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
  private void initPopupButton(Button button, Popup popup, Scene s) {
    button.setOnAction(event -> showPopup(popup));

    popup.getContent().add(s.getRoot());

    Button b = new Button("Done!");
    b.setOnAction(e -> popup.hide());

    popup.getContent().add(b);
    popup.setOnHidden(e -> handleHiddenPopup(button));
  }

  /**
   * Handles a hidden popup in a Java Bullet Journal.
   */
  private void handleHiddenPopup(Button button) {
    if (button == this.taskButton) {
      addTaskFromPopup();
    }
    if (button == this.eventButton) {
      addEventFromPopup();
    }
  }

  /**
   * Shows a dialog for a task in a Java Bullet Journal.
   */
  private void showPopup(Popup popup) {
    popup.show(this.stage);
  }
}
