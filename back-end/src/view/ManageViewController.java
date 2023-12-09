package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.ProjectModelManager;

/**
 * The {@code ManageViewController} class controls the behavior of the "Manage Projects" view,
 * allowing users to navigate to different project-related actions, such as adding, editing, or removing projects.
 *
 * @author Jakub Mateusz Abramek / Samuel Kacenga
 */

public class ManageViewController
{
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button addProject;
  @FXML private Button editRemoveProject;
  @FXML private Button back;

  /**
   * Initializes the controller with the necessary components and dependencies.
   *
   * @param viewHandler    The handler for managing views and navigation.
   * @param scene          The JavaFX scene associated with the "Manage Projects" view.
   * @param projectManager The manager for handling project-related operations and data.
   */
  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
  }

  /**
   * Resets the state of the controller if needed.
   */
  public void reset()
  {

  }

  /**
   * Gets the JavaFX {@code Scene} associated with the "Manage Projects" view.
   *
   * @return The JavaFX scene.
   */
  public Scene getScene()
  {
    return scene;
  }

  /**
   * Handles button actions triggered by user interactions.
   *
   * @param e The {@code ActionEvent} triggered by the user.
   */
  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addProject)
    {
      viewHandler.openView("AddProjectView");
    }
    else if(e.getSource() == editRemoveProject)
    {
      viewHandler.openView("EditRemoveProjectView");
    }
    else if(e.getSource() == back)
    {
      viewHandler.openView("MenuView");
    }
  }
}
