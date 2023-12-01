package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.ProjectModelManager;

public class AddResidentialViewController
{
  private ViewHandler viewHandler;
  private Scene scene;
  private ProjectModelManager projectManager;
  @FXML private TextField budgetField;
  @FXML private TextField dayField;
  @FXML private TextField monthField;
  @FXML private TextField yearField;
  @FXML private ComboBox statusComboBox;
  @FXML private TextField projectIDField;
  @FXML private TextField timelineField;
  @FXML private TextField firstNameField;
  @FXML private TextField surnameField;
  @FXML private TextField customerIDField;
  @FXML private TextField phoneNumberField;
  @FXML private TextField emailField;
  @FXML private TextField addressField;
  @FXML private TextField expectedManHoursField;
  @FXML private TextField materialExpensesField;
  @FXML private TextField sizeField;
  @FXML private TextField NrOfKitchens;
  @FXML private TextField NrOfBathrooms;
  @FXML private TextField RoomsWithPlumbing;
  @FXML private Button clearButton;
  @FXML private Button addProjectButton;
  @FXML private Button backButton;

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
    if (e.getSource() == clearButton)
    {

    }
    else if (e.getSource() == backButton)
    {
      viewHandler.openView("AddProjectView");
    }
  }
}
