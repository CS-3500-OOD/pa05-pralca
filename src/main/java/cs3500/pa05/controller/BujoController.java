package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Week;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

  public BujoController(Week week, Stage stage) {
    this.week = week;
    this.stage = stage;
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

    this.taskPopup = new Popup();
    initPopupButton(this.taskButton, this.taskPopup);

    this.eventPopup = new Popup();
    initPopupButton(this.eventButton, this.eventPopup);

    this.loadFilePopup = new Popup();
    initPopupButton(this.openButton, this.loadFilePopup);

    this.saveFilePopup = new Popup();
    initPopupButton(this.saveButton, this.saveFilePopup);

    this.monthField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));

    this.weekOfField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));

  }

  /**
   * Initializes a day in a Java Bullet Journal.
   *
   * @param day the day to initialize
   */
  private void initDay(Day day) {
    // TODO: Implement this method
  }

  /**
   * Initializes the sidebar in a Java Bullet Journal.
   */
  private void initSideBar() {
    // TODO: Implement this method
  }

  /**
   * Initializes the background in a Java Bullet Journal.
   */
  private void initBackground() {
    // TODO: Implement this method
  }

  /**
   * Initializes the task button in a Java Bullet Journal.
   */
  private void initPopupButton(Button button, Popup popup) {
    button.setOnAction(event -> showPopup(popup));

    try {
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("taskScene.fxml"));
      loader.setController(this);
      Scene s = loader.load();
      popup.getContent().add(s.getRoot());
      Button b = new Button("Done!");
      b.setOnAction(e -> popup.hide());
      popup.getContent().add(b);
    } catch (IOException e) {
      System.err.println("Unable to load popup.");
    }
  }

  /**
   * Shows a dialog for a task in a Java Bullet Journal.
   */
  private void showPopup(Popup popup) {
    popup.show(this.stage);
  }
}
