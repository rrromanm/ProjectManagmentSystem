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
  @FXML private TextField projectNameField;
  @FXML private TextField dayTextField;
  @FXML private TextField monthTextField;
  @FXML private TextField yearTextField;
  @FXML private ComboBox<String> statusComboBox;
  @FXML private TextField projectIDTextField;
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
    return string.matches("[a-zA-Z]+");
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
      int projectID = 0;
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
        if (budget < 500000 || budget > 2000000) {
        JOptionPane.showMessageDialog(null, "Budget must be between 500,000 and 2,000,000", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
        if (isValidString(projectNameField.getText()))
        {
          projectName = projectNameField.getText();
        }
        else
        {
          JOptionPane.showMessageDialog(null,
              "Incorrect project name inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
          return;
        }
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect budget inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        day = Integer.parseInt(dayTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect day inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        month = Integer.parseInt(monthTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect month inputted", "ERROR",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        year = Integer.parseInt(yearTextField.getText());
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
        projectID = Integer.parseInt(projectIDTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect project ID inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        timeline = Integer.parseInt(timelineTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect timeline inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(firstNameTextField.getText()))
      {
        firstName = firstNameTextField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect customer first name inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(surnameTextField.getText()))
      {
        surname = surnameTextField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect customer surname inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        customerID = Integer.parseInt(customerIDTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null, "Incorrect customer ID inputted",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        expectedManHours = Integer.parseInt(expectedManHoursTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect resources expected man hours inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        materialExpenses = Integer.parseInt(materialExpensesTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect resources material expenses inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        manHoursUsed = Integer.parseInt(manHoursUsedField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect  resources man hours used inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        size = Integer.parseInt(sizeTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect size inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      try
      {
        floors = Short.parseShort(floorsTextField.getText());
      }
      catch (NumberFormatException exception)
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect number of floors inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if (isValidString(usageTextField.getText()))
      {
        usage = usageTextField.getText();
      }
      else
      {
        JOptionPane.showMessageDialog(null,
            "Incorrect usage inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
      }
      MyDate date = new MyDate(day, month, year);
      Customer customer = new Customer(firstName, surname, customerID);
      Resources resources = new Resources(expectedManHours, materialExpenses,manHoursUsed);
      projects.addProject(
          new CommercialProject(budget, date, status, projectID, timeline,
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
