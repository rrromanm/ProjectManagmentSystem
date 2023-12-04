package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;
import utils.MyFileHandler;

import javax.swing.*;
import java.io.FileNotFoundException;

public class AddCommercialViewController {

  @FXML private TextField projectTypeTextField;
  @FXML private TextField budgetTextField;
  @FXML private TextField dayTextField;
  @FXML private TextField monthTextField;
  @FXML private TextField yearTextField;
  @FXML private ComboBox<String> statusComboBox;
  @FXML private TextField projectIDTextField;
  @FXML private TextField timelineTextField;
  @FXML private TextField firstNameTextField;
  @FXML private TextField surnameTextField;
  @FXML private TextField customerIDTextField;
  @FXML private TextField phoneNumberTextField;
  @FXML private TextField emailTextField;
  @FXML private TextField addressTextField;
  @FXML private TextField expectedManHoursTextField;
  @FXML private TextField materialExpensesTextField;
  @FXML private TextField sizeTextField;
  @FXML private TextField floorsTextField;
  @FXML private TextField usageTextField;
  @FXML private Button clearButton;
  @FXML private Button addProject;
  @FXML private Button backButton;
  private ViewHandler viewHandler;
  private CommercialProject commercialProject;

  private Scene scene;
  private ProjectModelManager projectManager;

  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
    String[] statusString = {"Under Construction","Finished","Planned"};
    statusComboBox.getItems().addAll(statusString);
    statusComboBox.getSelectionModel().selectFirst();
  }

  public void reset()
  {
    budgetTextField.clear();
    dayTextField.clear();
    monthTextField.clear();
    yearTextField.clear();
    statusComboBox.getSelectionModel().clearSelection();
    projectIDTextField.clear();
    firstNameTextField.clear();
    surnameTextField.clear();
    customerIDTextField.clear();
    phoneNumberTextField.clear();
    emailTextField.clear();
    addressTextField.clear();
    expectedManHoursTextField.clear();
    materialExpensesTextField.clear();
    sizeTextField.clear();
    usageTextField.clear();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e) throws FileNotFoundException
  {
    if (e.getSource() == backButton)
    {
      viewHandler.openView("AddProjectView");
    }
    else if(e.getSource() == addProject)
    {
      ProjectList projectList = new ProjectList();
      ProjectModelManager manager = new ProjectModelManager("projects.bin");

//      int budget = 0;
//      int day = 0;
//      int month = 0;
//      int year = 0;
//      String status = null;
//      int projectID = 0;
//      int timeline = 0;
//      String firstName = null;
//      String surname = null;
//      int customerID = 0;
//      int expectedManHours = 0;
//      int materialExpenses = 0;
//      int size = 0;
//      short floors = 0;
//      String usage = null;

//      try
//      {
//          budget = Integer.parseInt(budgetTextField.getText());
//      }
//      catch (NumberFormatException exception)
//      {
//        JOptionPane.showMessageDialog(null, "Incorrect budget inputted", "ERROR",
//            JOptionPane.ERROR_MESSAGE);
//        return;
//      }
      int budget = Integer.parseInt(budgetTextField.getText());
      int day = Integer.parseInt(dayTextField.getText());
      int month = Integer.parseInt(monthTextField.getText());
      int year = Integer.parseInt(yearTextField.getText());
      String status = statusComboBox.getValue();
      int projectID = Integer.parseInt(projectIDTextField.getText());
      int timeline = Integer.parseInt(timelineTextField.getText());
      Customer customer = new Customer(firstNameTextField.getText(), surnameTextField.getText(),
          Integer.parseInt(customerIDTextField.getText()));
      Resources resources = new Resources(Integer.parseInt(expectedManHoursTextField.getText()),
          Integer.parseInt(materialExpensesTextField.getText()));
      int size = Integer.parseInt(sizeTextField.getText());
      short floors = Short.parseShort(floorsTextField.getText());
      commercialProject = new CommercialProject(budget, new MyDate(day, month, year), status, projectID, timeline,
          customer, resources, size, floors, usageTextField.getText());

      projectList.addProject(commercialProject);

      MyFileHandler.appendToTextFile("projects.txt", projectList.toString());
      manager.appendProjects(projectList);
      reset();
    }
    else if(e.getSource() == clearButton)
    {
      reset();
    }
  }
}
