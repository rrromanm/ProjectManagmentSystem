package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ProjectModelManager;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ProjectModelManager projectManager;
  private StartViewController startViewController;
  private ProjectViewController projectViewController;

  public ViewHandler(Stage stage, ProjectModelManager projectManager)
  {
    this.stage = stage;
    this.projectManager = projectManager;
  }

  public void start()
  {
    loadProjectView();
    loadStartView();
  }

  public void openView(String id)
  {
    switch (id)
    {
      case "ProjectView":
        stage.setScene(projectViewController.getScene());
        projectViewController.reset();
        break;
    }

    String title = "";

    if(stage.getScene().getRoot().getUserData() !=null)
    {
      title = stage.getScene().getRoot().getUserData().toString();
    }

    stage.setTitle(title);
    stage.show();
  }

  private void loadStartView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("StartView.fxml"));
      Region root = loader.load();
      projectViewController = loader.getController();
      projectViewController.init(this, new Scene(root), projectManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadProjectView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ProjectView.fxml"));
      Region root = loader.load();
      projectViewController = loader.getController();
      projectViewController.init(this, new Scene(root), projectManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
