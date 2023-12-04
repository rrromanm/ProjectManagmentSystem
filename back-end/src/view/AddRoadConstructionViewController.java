package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;
import javax.swing.*;

public class AddRoadConstructionViewController {


    private ViewHandler viewHandler;
    private Scene scene;
    private ProjectModelManager projectManager;

    @FXML private Button backButton;
    @FXML private Button clearButton;
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
    @FXML private TextField expectedManHoursField;
    @FXML private TextField materialExpensesField;
    @FXML private TextField manHoursUsedField;
    @FXML private TextField roadLength;
    @FXML private TextField roadWidth;
    @FXML private TextField environmentalChallenges;
    @FXML private TextField geographicalChallenges;
    @FXML private Button addProjectButton;
    @FXML private TextField tunnels;
    @FXML private TextField bridges;

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
        budgetField.setText("");
        dayField.setText("");
        monthField.setText("");
        yearField.setText("");
        statusComboBox.getSelectionModel().selectFirst();
        projectIDField.setText("");
        timelineField.setText("9");
        firstNameField.setText("");
        surnameField.setText("");
        customerIDField.setText("");
        manHoursUsedField.setText("");
        expectedManHoursField.setText("");
        materialExpensesField.setText("");
        roadLength.setText("");
        roadWidth.setText("");
        environmentalChallenges.setText("");
        geographicalChallenges.setText("");
        tunnels.setText("");
        bridges.setText("");
    }

    public Scene getScene()
    {
        return scene;
    }

    public boolean isValidString(String string)
    {
        return string.matches("[a-zA-Z]+");
    }

    public void handleActions(ActionEvent e)
    {
        if(e.getSource()==backButton)
        {
            viewHandler.openView("AddProjectView");
        }
        else if (e.getSource()==clearButton)
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
            int expectedManHours = 0;
            int materialExpenses = 0;
            int manHoursUsed = 0;
            int width = 0;
            int length = 0;
            String environmental = null;
            String geographical = null;
            int bridge = 0;
            int tunnel = 0;

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
                manHoursUsed = Integer.parseInt(manHoursUsedField.getText());
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null,
                    "Incorrect used man hours inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                width = Integer.parseInt(roadWidth.getText());
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null,
                    "Incorrect value inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                length = Integer.parseInt(roadLength.getText());
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Incorrect value inputted",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                tunnel = Integer.parseInt(tunnels.getText());
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Incorrect number inputted",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                 bridge = Integer.parseInt(bridges.getText());
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Incorrect number inputted",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                environmental = environmentalChallenges.getText();
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Incorrect value",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                geographical = geographicalChallenges.getText();
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Incorrect value",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }


            MyDate date = new MyDate(day, month, year);
            Customer customer = new Customer(firstName, surname, customerID);
            Resources resources = new Resources(expectedManHours, materialExpenses,manHoursUsed);
            projects.addProject(
                new RoadConstruction(budget, date, status, projectID, timeline,
                    customer, resources, width, length, bridge,tunnel, environmental, geographical));
            manager.appendProjects(projects);
            viewHandler.openView("ProjectView");
            JOptionPane.showMessageDialog(null,"Project added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
    }
}
