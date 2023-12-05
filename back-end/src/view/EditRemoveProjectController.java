package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
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
    String[] statusString = {"Under Construction","Finished","Planned"};
    projectStatus.getItems().addAll(statusString);
    projectStatus.getSelectionModel().selectFirst();
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
    if(e.getSource() == backButton)
    {
      viewHandler.openView("ManageView");
    }
    else if(e.getSource() == projectPick)
    {
      fillFields();
    }
    else if(e.getSource() == saveButton)
    {

    }
    else if(e.getSource() == removeButton)
    {

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
      if(list.get(i).getName().equals(projectPick.getValue())){
        index = i;
        break;
      }
    }
    projectType.setText(list.get(index).getType());
    projectBudget.setText(String.valueOf(list.get(index).getBudget()));
    projectName.setText(String.valueOf(list.get(index).getName()));

    day.setText(String.valueOf(list.get(index).getStartTime().getDay()));
  month.setText(String.valueOf(list.get(index).getStartTime().getMonth()));
  year.setText(String.valueOf(list.get(index).getStartTime().getYear()));

    if (list.get(index).getStatus().equals("Under Construction"))
    {
      projectStatus.getSelectionModel().select(0);
    }
    else if (list.get(index).getStatus().equals("Finished"))
    {
      projectStatus.getSelectionModel().select(1);
    }
    else if (list.get(index).getStatus().equals("Planned"))
    {
      projectStatus.getSelectionModel().select(2);
    }

    projectID.setText(String.valueOf(list.get(index).getProjectID()));
    projectTimeline.setText(String.valueOf(list.get(index).getTimeline()));

    firstName.setText(list.get(index).getCustomer().getFirstName());
    surname.setText(list.get(index).getCustomer().getSurname());
    customerID.setText(String.valueOf(list.get(index).getCustomer().getId()));

    expectedManHours.setText(
        String.valueOf(list.get(index).getResources().getExpectedManHours()));
    materialExpenses.setText(
        String.valueOf(list.get(index).getResources().getExpenses()));
    manHoursUsed.setText(
        String.valueOf(list.get(index).getResources().getManHoursUsed()));

    String projectType = list.get(index).getType();
    if ("Commercial".equals(projectType))
    {
      hideEverything();
      CommercialProject commercialProject = (CommercialProject) list.get(index);
      custom1.setVisible(true);
      label1.setVisible(true);
      custom2.setVisible(true);
      label2.setVisible(true);
      custom3.setVisible(true);
      label3.setVisible(true);
      custom1.setText(String.valueOf(commercialProject.getSize()));
      label1.setText("Size :");
      custom2.setText(String.valueOf(commercialProject.getFloors()));
      label2.setText("Floors :");
      custom3.setText(String.valueOf(commercialProject.getUsage()));
      label3.setText("Usage :");
    }
    else if("Industrial".equals(projectType))
    {
      IndustrialProjects industrialProjects = (IndustrialProjects) list.get(index);
      hideEverything();
      custom1.setVisible(true);
      label1.setVisible(true);
      custom2.setVisible(true);
      label2.setVisible(true);
      custom1.setText(String.valueOf(industrialProjects.getSize()));
      label1.setText("Size :");
      custom2.setText(String.valueOf(industrialProjects.getFacilityType()));
      label2.setText("Facility Type :");
    }
    else if("Residential".equals(projectType))
    {
      ResidentialProjects residentialProjects = (ResidentialProjects) list.get(index);
      hideEverything();
      custom1.setVisible(true);
      label1.setVisible(true);
      custom2.setVisible(true);
      label2.setVisible(true);
      custom3.setVisible(true);
      label3.setVisible(true);
      custom4.setVisible(true);
      label4.setVisible(true);
      custom5.setVisible(true);
      label5.setVisible(true);
      custom1.setText(String.valueOf(residentialProjects.getSize()));
      label1.setText("Size :");
      custom2.setText(String.valueOf(residentialProjects.getNumberOfKitchens()));
      label2.setText("Number of Kitchens :");
      custom3.setText(String.valueOf(residentialProjects.getNumberOfBathrooms()));
      label3.setText("Number of Bathrooms :");
      custom4.setText(String.valueOf(residentialProjects.getRoomsWithPlumbing()));
      label4.setText("Rooms with plumbing :");
      custom5.setText(String.valueOf(residentialProjects.getState()));
      label5.setText("State :");
    }
    else if("Road Construction".equals(projectType))
    {
      RoadConstruction roadConstruction = (RoadConstruction) list.get(index);
      hideEverything();
      custom1.setVisible(true);
      custom2.setVisible(true);
      custom3.setVisible(true);
      custom4.setVisible(true);
      custom5.setVisible(true);
      custom6.setVisible(true);
      label1.setVisible(true);
      label2.setVisible(true);
      label3.setVisible(true);
      label4.setVisible(true);
      label5.setVisible(true);
      label6.setVisible(true);
      label1.setText("Width :");
      custom2.setText(String.valueOf(roadConstruction.getWidth()));
      label2.setText("Length :");
      custom3.setText(String.valueOf(roadConstruction.getLength()));
      label3.setText("Bridges :");
      custom4.setText(String.valueOf(roadConstruction.getBridges()));
      label4.setText("Tunnels :");
      custom5.setText(String.valueOf(roadConstruction.getEnvironmentalChallenges()));
      label5.setText("Environmental Challenges :");
      custom6.setText(String.valueOf(roadConstruction.getGeographicalChallenges()));
      label6.setText("Geographical Challenges :");

    }

  }
  public void hideEverything ()
  {
    custom1.setVisible(false);
    custom2.setVisible(false);
    custom3.setVisible(false);
    custom4.setVisible(false);
    custom5.setVisible(false);
    custom6.setVisible(false);
    label1.setVisible(false);
    label2.setVisible(false);
    label3.setVisible(false);
    label4.setVisible(false);
    label5.setVisible(false);
    label6.setVisible(false);
  }
}
