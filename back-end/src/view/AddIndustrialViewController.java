package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.ProjectModelManager;
import model.*;

import javax.swing.*;

public class AddIndustrialViewController
{
  public AnchorPane AddIndustrialProjectView;
  private Scene scene;
  private ProjectModelManager projectManager;
  private ViewHandler viewHandler;

  @FXML private TextField projectTypeField;
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
    return string.matches("[a-zA-Z]+");
  }


  public void reset()
  {
    budgetField.setText("");
    dayField.setText("");
    monthField.setText("");
    yearField.setText("");
    statusComboBox.getSelectionModel().selectFirst();
    projectIDField.setText("");
    timelineField.setText("");
    firstNameField.setText("");
    surnameField.setText("");
    customerIDField.setText("");
    phoneNumberField.setText("");
    emailField.setText("");
    addressField.setText("");
    expectedManHoursField.setText("");
    materialExpensesField.setText("");
    sizeField.setText("");
    typeOfTheFacilityField.setText("");
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
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
      int day = 0;
      int month = 0;
      int year = 0;
      String status = null;
      int projectID = 0;
      int timeline = 0;
      String firstName = null;
      String surname = null;
      int customerID = 0;
      int phoneNumber = 0;
      String email = null;
      String address = null;
      int expectedManHours = 0;
      int materialExpenses = 0;
      int size = 0;
      String typeOfFacility = null;

      String type = projectTypeField.getText();
      try
      {
        budget = Integer.parseInt(budgetField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect budget inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        day = Integer.parseInt(dayField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect day inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        month = Integer.parseInt(monthField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect month inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        year = Integer.parseInt(yearField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect year inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      status = (String) statusComboBox.getValue();
      try
      {
        projectID = Integer.parseInt(projectIDField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect project ID inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        timeline = Integer.parseInt(timelineField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect timeline inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(firstNameField.getText()))
      {
        firstName = firstNameField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect customer first name inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(surnameField.getText()))
      {
        surname = surnameField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect customer surname inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        customerID = Integer.parseInt(customerIDField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect customer ID inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        phoneNumber = Integer.parseInt(phoneNumberField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect phone number inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(emailField.getText()))
      {
        email = emailField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Incorrect customer email inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(addressField.getText()))
      {
        address = addressField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect customer address inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        expectedManHours = Integer.parseInt(expectedManHoursField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect expected man hours inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        materialExpenses = Integer.parseInt(materialExpensesField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect material expenses inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        size = Integer.parseInt(sizeField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect size of the facility inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(typeOfTheFacilityField.getText()))
      {
        typeOfFacility = typeOfTheFacilityField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect type of the facility inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      MyDate date = new MyDate(day, month, year);
      Customer customer = new Customer(firstName, surname, customerID,
          phoneNumber, email, address);
      Resources resources = new Resources(expectedManHours, materialExpenses);
      projects.addProject(
          new IndustrialProjects(budget, date, status, projectID, timeline,
              customer, resources, size, typeOfFacility));

      manager.appendProjects(projects);
      reset();
    }
  }
}
