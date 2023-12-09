package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.*;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.util.Optional;

public class AddRoadConstructionViewController {


    private ViewHandler viewHandler;
    private Scene scene;
    private ProjectModelManager projectManager;

    @FXML private Button backButton;
    @FXML private Button clearButton;
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
        projectNameField.setText("");
    }

    public Scene getScene()
    {
        return scene;
    }

    public boolean isValidString(String string)
    {
        return string.matches("[a-zA-Z ]+");
    }

    public void handleActions(ActionEvent e)
    {
        if(e.getSource()==backButton)
        {
            viewHandler.openView("AddProjectView");
        }
        else if (e.getSource() == clearButton) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("");
            alert.setContentText("Are you sure you want to clear? This action cannot be undone.");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            } else {
                return;
            }
        }
        else if(e.getSource() == addProjectButton)
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
                if (budget < 1000000|| budget > 5000000)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("");
                    alert.setContentText("Budget must be between 1,000,000 and 5,000,000.\nDo you want to continue with the entered budget?");

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
                width = Integer.parseInt(roadWidth.getText());
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid road width input");
                alert.showAndWait();
                return;
            }
            try
            {
                length = Integer.parseInt(roadLength.getText());
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid road length input");
                alert.showAndWait();
                return;
            }
            try
            {
                tunnel = Integer.parseInt(tunnels.getText());
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid tunnel number input");
                alert.showAndWait();
                return;
            }
            try
            {
                 bridge = Integer.parseInt(bridges.getText());
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid number of bridges input");
                alert.showAndWait();
                return;
            }
            try
            {
                environmental = environmentalChallenges.getText();
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid number of environmental challenges input");
                alert.showAndWait();
                return;
            }
            try
            {
                geographical = geographicalChallenges.getText();
            }
            catch (NumberFormatException exception)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Invalid number of geographical challenges input");
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
                new RoadConstruction(projectName, budget, date, status, projectID, timeline,
                    customer, resources, width, length, bridge,tunnel, environmental, geographical));

            try
            {
                MyFileHandler.appendToTextFile("projects.txt", projects.toString());
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
            manager.appendProjects(projects);
            viewHandler.openView("ProjectView");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Project successfully added!");
            alert.showAndWait();
            reset();
        }
    }
}
