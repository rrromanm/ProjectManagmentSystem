package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.ProjectModelManager;

/**
 * The {@code AddProjectViewController} class controls the behavior of the "Add Project" view,
 * allowing users to navigate to specific project type views (Industrial, Commercial, Road Construction, Residential)
 * or return to the main management view.
 *
 * @author Group 1
 */
public class AddProjectViewController
{
  public AnchorPane AddProjectView;
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button industrialButton;
  @FXML private Button residentialButton;
  @FXML private Button roadConstructionButton;
  @FXML private Button commercialButton;
  @FXML private Button back;

  /**
   * Initializes the controller with the necessary components and dependencies.
   *
   * @param viewHandler   The handler for managing views and navigation.
   * @param scene         The JavaFX scene associated with the "Add Project" view.
   * @param projectManager The manager for handling project-related operations and data.
   */
  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
  }

  /**
   * Resets the state of the controller. (Currently empty)
   */
  public void reset()
  {

  }

  /**
   * Gets the JavaFX {@code Scene} associated with the "Add Project" view.
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
    if (e.getSource() == industrialButton)
    {
      viewHandler.openView("AddIndustrialView");
    }
    else if(e.getSource() == commercialButton)
    {
      viewHandler.openView("AddCommercialView");
    }
    else if(e.getSource() == roadConstructionButton )
    {
      viewHandler.openView("AddRoadConstructionView");
    }
    else if(e.getSource() == residentialButton)
    {
      viewHandler.openView("AddResidentialView");
    }
    else if(e.getSource() == back)
    {
      viewHandler.openView("ManageView");
    }
  }
}
