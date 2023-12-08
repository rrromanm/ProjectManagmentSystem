package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.ProjectModelManager;
import model.*;
import utils.MyFileHandler;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Optional;

public class AddIndustrialViewController
{
  public AnchorPane AddIndustrialProjectView;
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private TextField projectTypeField;
  @FXML private TextField budgetField;
  @FXML private TextField projectNameField;
  @FXML private TextField dayField;
  @FXML private TextField monthField;
  @FXML private TextField yearField;
  @FXML private ComboBox statusComboBox;
  @FXML private TextField timelineField;
  @FXML private TextField firstNameField;
  @FXML private TextField surnameField;
  @FXML private TextField customerIDField;
  @FXML private TextField manHoursUsedField;
  @FXML private TextField expectedManHoursField;
  @FXML private TextField materialExpensesField;
  @FXML private TextField sizeField;
  @FXML private TextField typeOfTheFacilityField;
  @FXML private Button clearButton;
  @FXML private Button addProjectButton;
  @FXML private Button backButton;

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
    budgetField.setText("");
    dayField.setText("");
    monthField.setText("");
    yearField.setText("");
    statusComboBox.getSelectionModel().selectFirst();
    timelineField.setText("");
    firstNameField.setText("");
    surnameField.setText("");
    customerIDField.setText("");
    expectedManHoursField.setText("");
    materialExpensesField.setText("");
    sizeField.setText("");
    manHoursUsedField.setText("");
    typeOfTheFacilityField.setText("");
    projectNameField.setText("");
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e) throws FileNotFoundException
  {
    if(e.getSource()==backButton)
    {
      viewHandler.openView("AddProjectView");
    }
    else if(e.getSource() == clearButton)
    {
      reset();
    }
    else if(e.getSource() == addProjectButton)
    {
      ProjectList projects = new ProjectList();
      ProjectModelManager manager = new ProjectModelManager("projects.bin");

      int budget = 0;
      String projectName;
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
      String typeOfFacility = null;

      String type = projectTypeField.getText();
      try
      {
        budget = Integer.parseInt(budgetField.getText());
        if (budget < 2000000 || budget > 10000000)
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
        day = Integer.parseInt(dayField.getText());
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
        month = Integer.parseInt(monthField.getText());
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
        year = Integer.parseInt(yearField.getText());
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
        timeline = Integer.parseInt(timelineField.getText());
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
      if (isValidString(firstNameField.getText()))
      {
        firstName = firstNameField.getText();
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
      if (isValidString(surnameField.getText()))
      {
        surname = surnameField.getText();
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
        customerID = Integer.parseInt(customerIDField.getText());
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
        expectedManHours = Integer.parseInt(expectedManHoursField.getText());
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
        materialExpenses = Integer.parseInt(materialExpensesField.getText());
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
        size = Integer.parseInt(sizeField.getText());
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
      if (isValidString(typeOfTheFacilityField.getText()))
      {
        typeOfFacility = typeOfTheFacilityField.getText();
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Invalid facility type input");
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
          new IndustrialProjects(projectName,budget, date, status, projectID, timeline,
              customer, resources, size, typeOfFacility));

      MyFileHandler.appendToTextFile("projects.txt", projects.toString());
      manager.appendProjects(projects);
      viewHandler.openView("ProjectView");
      JOptionPane.showMessageDialog(null,"Project added!", "Success", JOptionPane.INFORMATION_MESSAGE);
      reset();
    }
  }
}
