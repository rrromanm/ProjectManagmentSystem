package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.ProjectList;
import model.ProjectModelManager;

public class ProjectViewController
{
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private MenuItem exitMenuItem;
  @FXML private TextArea allProjectArea;
  @FXML private Button searchButton;
  @FXML private CheckMenuItem editAreaMenuItem;
  @FXML private MenuItem aboutMenuItem;
  @FXML private Button backButton;
  @FXML private RadioButton typeButton1;
  @FXML private RadioButton typeButton2;
  @FXML private RadioButton typeButton3;
  @FXML private RadioButton typeButton4;
  @FXML private RadioButton statusButton1;
  @FXML private RadioButton statusButton2;
  @FXML private RadioButton statusButton3;
  @FXML private RadioButton statusButton4;
  @FXML private RadioButton budgetButton1;
  @FXML private RadioButton budgetButton2;
  @FXML private RadioButton timelineButton1;
  @FXML private RadioButton timelineButton2;


  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
  }

  public void reset()
  {
    updateProjectArea();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == searchButton)
    {
      updateProjectArea();
    }
    else if (e.getSource() == exitMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          "Do you really want to exit the program?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);

      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES)
      {
        System.exit(0);
      }
    }
    else if (e.getSource() == editAreaMenuItem)
    {
      if (editAreaMenuItem.isSelected())
      {
        allProjectArea.setEditable(true);
      }
      else
      {
        allProjectArea.setEditable(false);
      }
    }
    else if (e.getSource() == aboutMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setTitle("About");
      alert.setContentText("Made by SEP-1 team, enjoy!");
      alert.showAndWait();
    }
    else if (e.getSource() == backButton)
    {
      viewHandler.openView("MenuView");
    }
    else if (e.getSource() == typeButton1)
    {
      projectManager.getProjectsFromType("Industrial");
    }
    else if (e.getSource() == typeButton2)
    {
      projectManager.getProjectsFromType("Industrial");
    }
    else if (e.getSource() == typeButton3)
    {
      projectManager.getProjectsFromType("Industrial");
    }
    else if (e.getSource() == typeButton4)
    {
      projectManager.getProjectsFromType("Industrial");
    }
  }

  private void updateProjectArea()
  {
    ProjectList projectList = projectManager.getAllProjects();
    allProjectArea.setText(projectList.toString());
  }
}
