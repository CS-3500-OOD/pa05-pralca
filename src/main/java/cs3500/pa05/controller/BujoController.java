package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
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

  private Scene taskScene;

  private Scene eventScene;

  private Scene openFileScene;

  private Scene saveFileScene;

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
  private TextField eventNameTextField;

  @FXML
  private TextField eventDescriptionTextField;

  @FXML
  private TextField eventStartTimeField;

  @FXML
  private TextField eventDurationField;

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
  private TextField savePath;

  @FXML
  private TextField loadPath;

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
    this.taskScene = new BujoView(this).loadTask();
    initPopupButton(this.taskButton, this.taskPopup, taskScene);

    this.eventPopup = new Popup();
    this.eventScene = new BujoView(this).loadEvent();
    initPopupButton(this.eventButton, this.eventPopup, eventScene);

    this.loadFilePopup = new Popup();
    this.openFileScene = new BujoView(this).loadOpenFile();
    initPopupButton(this.openButton, this.loadFilePopup, openFileScene);

    this.saveFilePopup = new Popup();
    this.saveFileScene = new BujoView(this).loadSaveFile();
    initPopupButton(this.saveButton, this.saveFilePopup, saveFileScene);

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

    new ObjectMapper().
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

    // Task task = new Task(this.taskName, this.taskDescription, day);
    Task task = new Task("taskName", "taskDescription", day);
    day.addTask(task);

    Label taskLabel = new Label(task.toString());
    taskLabel.setOnMouseClicked(event -> handleLabelClick(taskLabel, task));
    getVBox(selectedDay).getChildren().add(taskLabel);
  }

  /**
   * Adds an event to a Java Bullet Journal.
   */
  private void addEventFromPopup() {
    //String selectedDay = this.eventDayTextField.getText();
    String selectedDay = "Monday";

    Day day = this.week.getDays()[Day.getDayIndex(selectedDay)];

    // int hour = Integer.parseInt(this.eventStartTimeField.getText().split(":")[0]);
    // int minute = Integer.parseInt(this.eventStartTimeField.getText().split(":")[1]);

    // Event event = new Event(this.eventNameTextField.getText(),
    // this.eventDescriptionTextField.getText()
    //        day, new Time(hour, minute), Integer.parseInt(this.eventDurationField.getText()));
    Event event = new Event("eventName", "eventDescription",
        day, new Time(0, 0), 15);
    day.addEvent(event);

    Label taskLabel = new Label(event.toString());
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
  private void initPopupButton(Button button, Popup popup, Scene scene) {
    button.setOnAction(event -> showPopup(popup));


    popup.getContent().add(scene.getRoot());

    Button b = new Button("Done!");
    b.setTranslateX(scene.getWidth());
    b.setOnAction(e -> handlePopupHide(popup));

    popup.getContent().add(b);
    popup.setOnHidden(e -> handleHiddenPopup(button));

    this.nameTextField.setOnKeyTyped(
        event -> this.taskName = this.nameTextField.getText());
    this.descriptionTextField.setOnKeyTyped(
        event -> this.taskDescription = this.descriptionTextField.getText());
  }

  /**
   * Handles hiding a popup in a Java Bullet Journal.
   */
  private void handlePopupHide(Popup popup) {
    System.out.println(this.nameTextField.getText());
    popup.hide();
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
    if (button == this.openButton) {
      loadFile(this.loadPath.getText());
    }
    if (button == this.saveButton) {
      saveFile(this.savePath.getText());
    }
  }

  /**
   * Shows a dialog for a task in a Java Bullet Journal.
   */
  private void showPopup(Popup popup) {
    popup.show(this.stage);
  }
}
