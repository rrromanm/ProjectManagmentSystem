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

  @FXML private Button industrialButton;
  @FXML private Button residentialButton;
  @FXML private Button roadConstructionButton;
  @FXML private Button commercialButton;
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
