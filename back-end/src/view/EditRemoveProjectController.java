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
import view.ProjectViewController;
import javax.swing.*;
import utils.MyFileHandler;
import javax.swing.*;
import java.io.FileNotFoundException;

public class EditRemoveProjectController
{
  private ViewHandler viewHandler;
  private Scene scene;
  private ProjectModelManager projectManager;
  private ProjectViewController projectViewController;

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




  public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager, ProjectViewController projectViewController)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.projectManager = projectManager;
    this.projectViewController = projectViewController;
    populateComboBox();
    String[] statusString = {"Under Construction","Finished","Planned"};
    projectStatus.getItems().addAll(statusString);
    projectStatus.getSelectionModel().selectFirst();
  }

  public void reset()
  {
    projectBudget.setText("");
    day.setText("");
    month.setText("");
    year.setText("");
    projectStatus.getSelectionModel().selectFirst();
    projectID.setText("");
    projectTimeline.setText("");
    firstName.setText("");
    surname.setText("");
    customerID.setText("");
    expectedManHours.setText("");
    materialExpenses.setText("");
    manHoursUsed.setText("");
    projectName.setText("");
    projectType.setText("");
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
      saveChanges();
    }
    else if(e.getSource() == removeButton)
    {
      removeProject();
      populateComboBox();
      viewHandler.openView("MenuView");
      JOptionPane.showMessageDialog(null, "Project removed!", "Remove",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void populateComboBox() {
    projectPick.getItems().clear();
    reset();
    hideEverything();

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
    else if("RoadConstruction".equals(projectType))
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
      custom1.setText(String.valueOf(roadConstruction.getWidth()));
      label2.setText("Length :");
      custom2.setText(String.valueOf(roadConstruction.getLength()));
      label3.setText("Bridges :");
      custom3.setText(String.valueOf(roadConstruction.getBridges()));
      label4.setText("Tunnels :");
      custom4.setText(String.valueOf(roadConstruction.getTunnels()));
      label5.setText("Environmental Challenges :");
      custom5.setText(String.valueOf(roadConstruction.getEnvironmentalChallenges()));
      label6.setText("Geographical Challenges :");
      custom6.setText(String.valueOf(roadConstruction.getGeographicalChallenges()));

    }

  }

  public void removeProject(){
    ProjectModelManager manager = new ProjectModelManager("projects.bin");
    ProjectList list = projectManager.getAllProjects();

    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getName().equals(projectPick.getValue())){
        list.removeProject(list.get(i));
      }
    }
    try{
      manager.removeProject(list);

      MyFileHandler.writeToTextFile("projects.txt", list.toString());

    }
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
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

  private void saveChanges()
  {
    if (projectPick.getValue() == null)
    {
      return;
    }

    ProjectList list = projectManager.getAllProjects();
    int index = 0;

    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getName().equals(projectPick.getValue()))
      {
        index = i;
        break;
      }
    }

    Project project = list.get(index);

    String newType = projectType.getText();
    int newBudget = Integer.parseInt(projectBudget.getText());
    String newName = projectName.getText();
    int newDay = Integer.parseInt(day.getText());
    int newMonth = Integer.parseInt(month.getText());
    int newYear = Integer.parseInt(year.getText());
    String newCustomerFirstName = firstName.getText();
    String newCustomerSurname = surname.getText();
    int newCustomerId = Integer.parseInt(customerID.getText());
    double newExpenses = Double.parseDouble(materialExpenses.getText());
    int newManHoursUsed = Integer.parseInt(manHoursUsed.getText());
    int newExpectedManHours = Integer.parseInt(expectedManHours.getText());

    try
    {
      project.setType(newType);
      project.setBudget(newBudget);
      project.setName(newName);
      project.getStartTime().setDay(newDay);
      project.getStartTime().setMonth(newMonth);
      project.getStartTime().setYear(newYear);
      project.setStatus(projectStatus.getValue());

      project.getCustomer().setFirstName(newCustomerFirstName);
      project.getCustomer().setSurname(newCustomerSurname);
      project.getCustomer().setId(newCustomerId);

      project.getResources().setExpenses(newExpenses);
      project.getResources().setManHoursUsed(newManHoursUsed);
      project.getResources().setExpectedManHours(newExpectedManHours);

      projectManager.updateProject(project);
      updateProjectArea();
      populateComboBox();
      viewHandler.openView("ProjectView");
      JOptionPane.showMessageDialog(null, "Project changes have been saved.",
          "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    catch (NumberFormatException e)
    {
      e.printStackTrace();
    }
  }

  private void updateProjectArea() {
    ProjectList projectList = projectManager.getAllProjects();
    projectViewController.populateTable(projectList);
  }
}
