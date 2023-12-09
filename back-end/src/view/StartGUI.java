package view;

import javafx.application.Application;
import javafx.stage.Stage;
import main.LoadInitialData;
import model.ProjectModelManager;
import parser.ParserException;

/**
 * This class initializes the GUI by loading initial data, setting up the project model manager,
 * creating a view handler, and starting the application.
 *
 * @author Group 1
 */
public class StartGUI extends Application
{

  /**
   * Starts the JavaFX application by initializing the GUI components.
   *
   * @param window The primary stage of the JavaFX application.
   * @throws ParserException If an error occurs while parsing initial data.
   */
  public void start(Stage window) throws ParserException
  {
    LoadInitialData.main(new String[]{});
    ProjectModelManager modelManager = new ProjectModelManager("projects.bin");
    ViewHandler viewHandler = new ViewHandler(window, modelManager);
    viewHandler.start();
  }
}