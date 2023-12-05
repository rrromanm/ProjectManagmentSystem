package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ProjectModelManager;
import model.Project;
import model.ProjectList;
import model.ProjectModelManager;
public class EditRemoveProjectController
{
  private ViewHandler viewHandler;
  private Scene scene;
  private ProjectModelManager projectManager;

  @FXML private TextField projectType;
  @FXML private TextField projectBudget;
  @FXML private TextField projectName;
  @FXML private TextField day;
  @FXML private TextField month;
  @FXML private TextField year;
  @FXML private TextField projectID;
  @FXML private TextField projectTimeline;
  @FXML private TextField firstName;
  @FXML private TextField surname;
  @FXML private TextField customerID;
  @FXML private TextField expectedManHours;
  @FXML private TextField materialExpenses;
  @FXML private TextField manHoursUsed;
  @FXML private TextField custom1;
  @FXML private TextField custom2;
  @FXML private TextField custom3;
  @FXML private TextField custom4;
  @FXML private TextField custom5;
  @FXML private TextField custom6;
  @FXML private ComboBox<String> projectStatus;
  @FXML private ComboBox<String> projectPick;
  @FXML private Label label1;
  @FXML private Label label2;
  @FXML private Label label3;
  @FXML private Label label4;
  @FXML private Label label5;
  @FXML private Label label6;
  @FXML private Button backButton;
  @FXML private Button removeButton;
  @FXML private Button saveButton;




  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
    populateComboBox();
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
    fillFields();
    if(e.getSource() == backButton)
    {
      viewHandler.openView("ManageView");
    }
  }

  public void populateComboBox() {
    ProjectList list = projectManager.getAllProjects();

    for (int i = 0; i < list.size(); i++) {
      Project project = list.get(i);

      String projectNameWithType = project.getName();
      projectPick.getItems().add(projectNameWithType);
    }
  }

  public void fillFields(){
    ProjectList list = projectManager.getAllProjects();
    int index = 0;

    for(int i = 0; i < list.size(); i++){
      if(list.get(i).equals(projectPick.getValue())){
        index = i;
        break;
      }
    }
    System.out.println(list.get(index).getType());
    projectType.setText(list.get(index).getType());
    projectBudget.setText(String.valueOf(list.get(index).getBudget()));

//    day.setText(String.valueOf(list.get(index).getStartTime().getDays());
//    month.setText(String.valueOf(list.get(index).getStartTime().getMonth()));
//    year.setText(String.valueOf(list.get(index).getStartTime().getYear()));

    projectID.setText(String.valueOf(list.get(index).getProjectID()));
    projectTimeline.setText(String.valueOf(list.get(index).getTimeline()));

    firstName.setText(list.get(index).getCustomer().getFirstName());
    surname.setText(list.get(index).getCustomer().getSurname());
    customerID.setText(String.valueOf(list.get(index).getCustomer().getId()));

    expectedManHours.setText(String.valueOf(list.get(index).getResources().getExpectedManHours()));
    materialExpenses.setText(String.valueOf(list.get(index).getResources().getExpenses()));
    manHoursUsed.setText(String.valueOf(list.get(index).getResources().getManHoursUsed()));
  }
}