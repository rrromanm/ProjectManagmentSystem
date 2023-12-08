package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import main.LoadInitialData;
import model.ProjectModelManager;
import parser.ParserException;

import javax.swing.*;

public class MenuViewController
{
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button projects;
  @FXML private Button manage;
  @FXML private Button website;

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

  public void handleActions(ActionEvent e) throws ParserException
  {
    if (e.getSource() == projects)
    {
      viewHandler.openView("ProjectView");
    }
    else if (e.getSource() == manage)
    {
     viewHandler.openView("ManageView");
    }
    else if (e.getSource() == website){
      LoadInitialData.main(new String[]{});
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Success");
      alert.setHeaderText("");
      alert.setContentText("Website successfully updated!");
      alert.showAndWait();
    }
  }


}
