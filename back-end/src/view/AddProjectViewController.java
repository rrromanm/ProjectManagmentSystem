package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.ProjectModelManager;

public class AddProjectViewController
{
  public AnchorPane AddProjectView;
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button addProject;
  @FXML private Button editProject;
  @FXML private Button removeProject;
  @FXML private Button back;

  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
  }

  public void reset()
  {

  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addProject)
    {
      viewHandler.openView("AddProjectView");
    }
    else if(e.getSource() == editProject)
    {
      viewHandler.openView("EditProjectView");
    }
    else if(e.getSource() == removeProject )
    {
      viewHandler.openView("RemoveProjectView");
    }
    else if(e.getSource() == back)
    {
      viewHandler.openView("MenuView");
    }
  }
}
