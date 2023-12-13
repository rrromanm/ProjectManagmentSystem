package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.ProjectModelManager;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

/**
 * The {@code MenuViewController} class controls the behavior of the main menu view,
 * allowing users to navigate to different sections of the application and perform various actions.
 *
 * This class serves as part of the MVC (Model-View-Controller) architecture and handles user interactions
 * related to the main menu, such as viewing projects, managing projects, and updating the website.
 *
 * @author Samuel Kacenga / Jakub Mateusz Abramek / Romans Mihalonoks
 */
public class MenuViewController
{
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private Button projects;
  @FXML private Button manage;
  @FXML private Button website;

  /**
   * Initializes the controller with the necessary components and dependencies.
   *
   * @param viewHandler    The handler for managing views and navigation.
   * @param scene          The JavaFX scene associated with the main menu view.
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
   * Gets the JavaFX {@code Scene} associated with the main menu view.
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
   * @throws ParserException If an exception occurs during parsing (specifically in the "website" action).
   */
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
      XmlJsonParser parser = new XmlJsonParser();
      File file1 = parser.toJson(projectManager.getAllProjects(), "projectlist.json");

      File file2 = parser.toXml(projectManager.getAllProjects(), "projectlist.xml");
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Success");
      alert.setHeaderText("");
      alert.setContentText("Website successfully updated!");
      alert.showAndWait();
    }
  }


}
