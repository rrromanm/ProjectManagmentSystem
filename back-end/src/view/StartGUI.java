package view;

import javafx.application.Application;
import javafx.stage.Stage;
import main.LoadInitialData;
import model.ProjectModelManager;
import parser.ParserException;

public class StartGUI extends Application
{
  public void start(Stage window) throws ParserException
  {
    LoadInitialData.main(new String[]{});
    ProjectModelManager modelManager = new ProjectModelManager("projects.bin");
    ViewHandler viewHandler = new ViewHandler(window, modelManager);
    viewHandler.start();
  }
}