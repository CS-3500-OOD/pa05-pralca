package cs3500.pa05.view;

import javafx.scene.Scene;


  public interface BujoGuiView {
    /**
     * Loads a scene from a Whack-a-Mole GUI layout.
     *
     * @return the layout
     */
    Scene load() throws IllegalStateException;
}
