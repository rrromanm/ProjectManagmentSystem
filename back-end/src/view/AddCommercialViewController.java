package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.*;
import utils.MyFileHandler;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Optional;

public class AddCommercialViewController {

  @FXML private TextField projectTypeTextField;
  @FXML private TextField budgetTextField;
  @FXML private TextField projectNameField;
  @FXML private TextField dayTextField;
  @FXML private TextField monthTextField;
  @FXML private TextField yearTextField;
  @FXML private ComboBox<String> statusComboBox;
  @FXML private TextField timelineTextField;
  @FXML private TextField firstNameTextField;
  @FXML private TextField surnameTextField;
  @FXML private TextField customerIDTextField;
  @FXML private TextField expectedManHoursTextField;
  @FXML private TextField materialExpensesTextField;
  @FXML private TextField manHoursUsedField;
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
  private MyDate dates;


  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
    String[] statusString = {"Under Construction","Finished","Planned"};
    statusComboBox.getItems().addAll(statusString);
    statusComboBox.getSelectionModel().selectFirst();
  }
  public boolean isValidString(String string)
  {
    return string.matches("[a-zA-Z ]+");
  }

  public void reset()
  {
    budgetTextField.clear();
    dayTextField.clear();
    monthTextField.clear();
    yearTextField.clear();
    statusComboBox.getSelectionModel().clearSelection();
    firstNameTextField.clear();
    surnameTextField.clear();
    customerIDTextField.clear();
    expectedManHoursTextField.clear();
    manHoursUsedField.clear();
    materialExpensesTextField.clear();
    sizeTextField.clear();
    usageTextField.clear();
    projectNameField.clear();
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
      ProjectList projects = new ProjectList();
      ProjectModelManager manager = new ProjectModelManager("projects.bin");

      int budget = 0;
      String projectName = null;
      int day = 0;
      int month = 0;
      int year = 0;
      String status = null;
      int projectID = projectManager.generateProjectID();
      int timeline = 0;
      String firstName = null;
      String surname = null;
      int customerID = 0;
      int expectedManHours = 0;
      int materialExpenses = 0;
      int manHoursUsed = 0;
      int size = 0;
      short floors =0;
      String usage = null;


      String type = projectTypeTextField.getText();
      try
      {
        budget = Integer.parseInt(budgetTextField.getText());
        if (budget < 100000 || budget > 2000000)
        {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Budget must be between 2,000,000 and 10,000,000.\nDo you want to continue with the entered budget?");

          Optional<ButtonType> result = alert.showAndWait();
          if (result.get() == ButtonType.CANCEL)
          {
            return;
          }
        }
      }
      catch(NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid budget input");
        alert.showAndWait();
        return;
      }
      if (isValidString(projectNameField.getText()))
      {
        projectName = projectNameField.getText();
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid name input");
        alert.showAndWait();
        return;
      }
      try
      {
        day = Integer.parseInt(dayTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid day input");
        alert.showAndWait();
        return;
      }
      try
      {
        month = Integer.parseInt(monthTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid month input");
        alert.showAndWait();
        return;
      }
      try
      {
        year = Integer.parseInt(yearTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid year input");
        alert.showAndWait();
        return;
      }
      status = (String) statusComboBox.getValue();
      try
      {
        timeline = Integer.parseInt(timelineTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid timeline input");
        alert.showAndWait();
        return;
      }
      if (isValidString(firstNameTextField.getText()))
      {
        firstName = firstNameTextField.getText();
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid customer first name input");
        alert.showAndWait();
        return;
      }
      if (isValidString(surnameTextField.getText()))
      {
        surname = surnameTextField.getText();
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid customer surname input");
        alert.showAndWait();
        return;
      }
      try
      {
        customerID = Integer.parseInt(customerIDTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid customer ID input");
        alert.showAndWait();
        return;
      }
      try
      {
        expectedManHours = Integer.parseInt(expectedManHoursTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid expected man hours input");
        alert.showAndWait();
        return;
      }
      try
      {
        materialExpenses = Integer.parseInt(materialExpensesTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid material expenses input");
        alert.showAndWait();
        return;
      }
      try
      {
        manHoursUsed = Integer.parseInt(manHoursUsedField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid man hours used input");
        alert.showAndWait();
        return;
      }
      try
      {
        size = Integer.parseInt(sizeTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid size input");
        alert.showAndWait();
        return;
      }
      try
      {
        floors = Short.parseShort(floorsTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid number of floors input");
        alert.showAndWait();
        return;
      }
      if (isValidString(usageTextField.getText()))
      {
        usage = usageTextField.getText();
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid usage input");
        alert.showAndWait();
        return;
      }

      MyDate date = new MyDate(day, month, year);
      if (!date.isValidDate())
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid date input");
        alert.show();
        return;
      }

      Customer customer = new Customer(firstName, surname, customerID);
      Resources resources = new Resources(expectedManHours, materialExpenses,manHoursUsed);
      projects.addProject(
          new CommercialProject(projectName, budget, date, status, projectID, timeline,
              customer, resources, size, floors,usage));

      MyFileHandler.appendToTextFile("projects.txt", projects.toString());
      manager.appendProjects(projects);
      viewHandler.openView("ProjectView");
      JOptionPane.showMessageDialog(null,"Project added!", "Success", JOptionPane.INFORMATION_MESSAGE);
      reset();


    }
    else if(e.getSource() == clearButton)
    {
      reset();
    }
  }
}
