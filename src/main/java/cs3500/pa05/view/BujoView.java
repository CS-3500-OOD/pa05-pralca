package cs3500.pa05.view;

import cs3500.pa05.controller.BujoController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a view for a Java Bullet Journal
 */
public class BujoView {

  private final FXMLLoader loader;

  /**
   * Constructs a simple BuJo GUI view.
   */
  public BujoView(BujoController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("mainScene2.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene load() throws IllegalStateException {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
