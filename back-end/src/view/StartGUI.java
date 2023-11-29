package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectModelManager;

public class StartGUI extends Application
{
  public void start(Stage window)
  {
    ProjectModelManager modelManager = new ProjectModelManager("projects.bin");
    ViewHandler viewHandler = new ViewHandler(window, modelManager);
    viewHandler.start();
  }
}