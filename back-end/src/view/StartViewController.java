package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.ProjectModelManager;

/**
 * This class manages the start view's functionality, such as initializing the application,
 * handling user actions, and navigating to the main menu view.
 *
 * @author Group 1
 */
public class StartViewController
{
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button startButton;


  /**
   * Initializes the StartViewController with the required dependencies.
   *
   * @param viewHandler    The view handler managing views.
   * @param scene          The scene to be initialized.
   * @param projectManager The project manager for handling projects.
   */
  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
  }

  /**
   * Resets the view to its initial state.
   */
  public void reset()
  {

  }

  /**
   * Retrieves the scene managed by this controller.
   *
   * @return The scene managed by this controller.
   */
  public Scene getScene()
  {
    return this.scene;
  }


  /**
   * Handles the actions triggered by user interactions with the start view.
   *
   * @param e The ActionEvent representing the action triggered.
   */
  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == startButton)
    {
      viewHandler.openView("MenuView");
    }
  }
}
