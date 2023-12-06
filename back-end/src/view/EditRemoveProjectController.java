package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.LoadInitialData;
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
  @FXML private Button updateButton;




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
    else if(e.getSource() == updateButton)
    {
      populateComboBox();
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
  public boolean isValidString(String string) {
    return string.matches("[a-zA-Z ]+");
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

    String newType = null;
    int newBudget = 0;
    String newName = null;
    String newStatus =  null;
    int newProjectID = 0;
    int newTimeline = 0;
    int newDay = 0;
    int newMonth = 0;
    int newYear = 0;

    String newCustomerFirstName = null;
    String newCustomerSurname = null;
    int newCustomerId = 0;

    double newExpenses = 0;
    int newManHoursUsed = 0;
    int newExpectedManHours = 0;

     newType = projectType.getText();
    try
    {
      newBudget = Integer.parseInt(projectBudget.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect budget inputted", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (isValidString(projectName.getText()))
    {
      newName = projectName.getText();
    }
    else
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect project name inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newDay = Integer.parseInt(day.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect day inputted", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newMonth = Integer.parseInt(month.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect month inputted", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newYear = Integer.parseInt(year.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect year inputted", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    newStatus = (String) projectStatus.getValue();
    try
    {
      newProjectID = Integer.parseInt(projectID.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect project ID inputted",
          "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newTimeline = Integer.parseInt(projectTimeline.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect timeline inputted",
          "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (isValidString(firstName.getText()))
    {
      newCustomerFirstName = firstName.getText();
    }
    else
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect customer first name inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (isValidString(surname.getText()))
    {
      newCustomerSurname = surname.getText();
    }
    else
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect customer surname inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newCustomerId = Integer.parseInt(customerID.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null, "Incorrect customer ID inputted",
          "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newExpectedManHours = Integer.parseInt(expectedManHours.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect resources expected man hours inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newExpenses = Double.parseDouble(materialExpenses.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect resources material expenses inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    try
    {
      newManHoursUsed = Integer.parseInt(manHoursUsed.getText());
    }
    catch (NumberFormatException exception)
    {
      JOptionPane.showMessageDialog(null,
          "Incorrect  resources man hours used inputted", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    MyDate newDate = new MyDate(newDay,newMonth,newYear);
    Customer newCustomer = new Customer(newCustomerFirstName,newCustomerSurname,newCustomerId);
    Resources newResources = new Resources(newExpectedManHours, newExpenses, newManHoursUsed);

    try
    {
      if (newType.equals("Industrial"))
      {
        int size = Integer.parseInt(custom1.getText());
        String facilityType = custom2.getText();

        project = new IndustrialProjects(newName,newBudget, newDate, newStatus, newProjectID, newTimeline, newCustomer, newResources, size, facilityType);
        IndustrialProjects projects = (IndustrialProjects) list.get(index);
        projects.setName(newName);
        projects.setBudget(newBudget);
        projects.setStartTime(newDate);
        projects.setStatus(newStatus);
        projects.setProjectID(newProjectID);
        projects.setTimeline(newTimeline);
        projects.setCustomer(newCustomer);
        projects.setResources(newResources);
        projects.setSize(size);
        projects.setFacilityType(facilityType);

        MyFileHandler.writeToTextFile("projects.txt",list.toString());
      }
      else if (newType.equals("Commercial"))
      {
        int size = Integer.parseInt(custom1.getText());
        short floors = Short.parseShort(custom2.getText());
        String usage = custom3.getText();

        project = new CommercialProject(newName,newBudget, newDate, newStatus, newProjectID, newTimeline, newCustomer, newResources, size, floors, usage);
        CommercialProject projects = (CommercialProject) list.get(index);
        projects.setName(newName);
        projects.setBudget(newBudget);
        projects.setStartTime(newDate);
        projects.setStatus(newStatus);
        projects.setProjectID(newProjectID);
        projects.setTimeline(newTimeline);
        projects.setCustomer(newCustomer);
        projects.setResources(newResources);
        projects.setSize(size);
        projects.setFloors(floors);
        projects.setUsage(usage);

        MyFileHandler.writeToTextFile("projects.txt",list.toString());
      }
      else if (newType.equals("Residential"))
      {
        int size = Integer.parseInt(custom1.getText());
        int kitchens = Integer.parseInt(custom2.getText());
        int bathrooms = Integer.parseInt(custom3.getText());
        int plumbing = Integer.parseInt(custom4.getText());
        String state = custom5.getText();

        project = new ResidentialProjects(newName,newBudget, newDate, newStatus, newProjectID, newTimeline, newCustomer, newResources, size, kitchens, bathrooms, plumbing, state);
        ResidentialProjects projects = (ResidentialProjects) list.get(index);
        projects.setName(newName);
        projects.setBudget(newBudget);
        projects.setStartTime(newDate);
        projects.setStatus(newStatus);
        projects.setProjectID(newProjectID);
        projects.setTimeline(newTimeline);
        projects.setCustomer(newCustomer);
        projects.setResources(newResources);
        projects.setSize(size);
        projects.setNumberOfKitchens(kitchens);
        projects.setNumberOfBathrooms(bathrooms);
        projects.setRoomsWithPlumbing(plumbing);
        projects.setState(state);

        MyFileHandler.writeToTextFile("projects.txt",list.toString());
      }
      else if (newType.equals("RoadConstruction"))
      {
        int width = Integer.parseInt(custom1.getText());
        int length = Integer.parseInt(custom2.getText());
        int bridges = Integer.parseInt(custom3.getText());
        int tunnels = Integer.parseInt(custom4.getText());
        String environmental = custom5.getText();
        String geographical = custom6.getText();

        project = new RoadConstruction(newName,newBudget, newDate, newStatus, newProjectID, newTimeline, newCustomer, newResources, width, length, bridges, tunnels, environmental, geographical);
        RoadConstruction projects = (RoadConstruction) list.get(index);
        projects.setName(newName);
        projects.setBudget(newBudget);
        projects.setStartTime(newDate);
        projects.setStatus(newStatus);
        projects.setProjectID(newProjectID);
        projects.setTimeline(newTimeline);
        projects.setCustomer(newCustomer);
        projects.setResources(newResources);
        projects.setWidth(width);
        projects.setLength(length);
        projects.setBridges(bridges);
        projects.setTunnels(tunnels);
        projects.setEnvironmentalChallenges(environmental);
        projects.setGeographicalChallenges(geographical);

        MyFileHandler.writeToTextFile("projects.txt",list.toString());
      }


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
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  private void updateProjectArea() {
    ProjectList projectList = projectManager.getAllProjects();
    projectViewController.populateTable(projectList);
  }
}
