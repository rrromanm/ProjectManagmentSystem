package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.*;
import model.ProjectModelManager;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * The {@code EditRemoveProjectController} class controls the behavior of the "Edit/Remove Project" view,
 * allowing users to edit or remove existing projects, and update the display accordingly.
 *
 * @author Maciej Matuszewski / Samuel Kacenga / Jakub Mateusz Abramek / Romans Mihalonoks
 */
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

  /**
   * Initializes the controller with the necessary components and dependencies.
   *
   * @param viewHandler            The handler for managing views and navigation.
   * @param scene                  The JavaFX scene associated with the "Edit/Remove Project" view.
   * @param projectManager         The manager for handling project-related operations and data.
   * @param projectViewController  The controller for the main project view.
   */
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

  /**
   * Resets the state of the controller by clearing input fields and hiding custom project details.
   */
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

  /**
   * Gets the JavaFX {@code Scene} associated with the "Edit/Remove Project" view.
   *
   * @return The JavaFX scene.
   */
  public Scene getScene()
  {
    return scene;
  }

  /**
   * Handles button actions triggered by user interactions.
   *
   * @param e The {@code ActionEvent} triggered by the user.
   */
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
    else if (e.getSource() == removeButton) {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation");
      alert.setHeaderText("");
      alert.setContentText("Are you sure you want to remove this project?");

      Optional<ButtonType> result = alert.showAndWait();

      if (result.isPresent() && result.get() == ButtonType.OK) {
        removeProject();
        populateComboBox();
        viewHandler.openView("ProjectView");
      } else {
        return;
      }
    }
  }

  /**
   * Populates the project selection {@code ComboBox} with project names.
   */
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

  /**
   * Fills input fields with details of the selected project for editing.
   */
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

  /**
   * Removes the selected project and updates the project list and view.
   */
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

  /**
   * Hides custom project details labels and text fields.
   */
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
  /**
   * Checks if a given string is a valid alphabetical string.
   *
   * @param string The string to validate.
   * @return {@code true} if the string is valid, {@code false} otherwise.
   */
  public boolean isValidString(String string) {
    return string.matches("[a-zA-Z ]+");
  }

  /**
   * Saves changes made to the selected project.
   */
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
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("");
      alert.setContentText("Invalid budget input");
      alert.showAndWait();
      return;
    }
    if (isValidString(projectName.getText()))
    {
      newName = projectName.getText();
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
      newDay = Integer.parseInt(day.getText());
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
      newMonth = Integer.parseInt(month.getText());
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
      newYear = Integer.parseInt(year.getText());
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
    newStatus = (String) projectStatus.getValue();
    try
    {
      newProjectID = Integer.parseInt(projectID.getText());
    }
    catch (NumberFormatException exception)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("");
      alert.setContentText("Invalid projectID input");
      alert.showAndWait();
      return;
    }
    try
    {
      newTimeline = Integer.parseInt(projectTimeline.getText());
    }
    catch (NumberFormatException exception)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("");
      alert.setContentText("Invalid project timeline input");
      alert.showAndWait();
      return;
    }
    if (isValidString(firstName.getText()))
    {
      newCustomerFirstName = firstName.getText();
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
    if (isValidString(surname.getText()))
    {
      newCustomerSurname = surname.getText();
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
      newCustomerId = Integer.parseInt(customerID.getText());
    }
    catch (NumberFormatException exception)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("");
      alert.setContentText("Invalid customer id input");
      alert.showAndWait();
      return;
    }
    try
    {
      newExpectedManHours = Integer.parseInt(expectedManHours.getText());
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
      newExpenses = Double.parseDouble(materialExpenses.getText());
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
      newManHoursUsed = Integer.parseInt(manHoursUsed.getText());
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

    MyDate newDate = new MyDate(newDay,newMonth,newYear);

    if (!newDate.isValidDate())
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Invalid date input");
      alert.show();
      return;
    }

    Customer newCustomer = new Customer(newCustomerFirstName,newCustomerSurname,newCustomerId);
    Resources newResources = new Resources(newExpectedManHours, newExpenses, newManHoursUsed);

    try
    {
      if (newType.equals("Industrial"))
      {
        int size = 0;
        String facilityType = null;

        try
        {
          size = Integer.parseInt(custom1.getText());
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

        if (isValidString(custom2.getText()))
        {
          facilityType = projectName.getText();
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
        int size = 0;
        short floors = 0;
        String usage = null;

        try
        {
          size = Integer.parseInt(custom1.getText());
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
          floors = Short.parseShort(custom2.getText());
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

        if (isValidString(custom3.getText()))
        {
          usage = custom3.getText();
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
        int size = 0;
        int kitchens = 0;
        int bathrooms = 0;
        int plumbing = 0;
        String state = null;

        try
        {
          size = Integer.parseInt(custom1.getText());
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
          kitchens = Integer.parseInt(custom2.getText());
        }
        catch (NumberFormatException exception)
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid number of kitchens input");
          alert.showAndWait();
          return;
        }

        try
        {
          bathrooms = Integer.parseInt(custom3.getText());
        }
        catch (NumberFormatException exception)
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid number of bathrooms input");
          alert.showAndWait();
          return;
        }

        try
        {
          plumbing = Integer.parseInt(custom4.getText());
        }
        catch (NumberFormatException exception)
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid number of rooms with plumbing input");
          alert.showAndWait();
          return;
        }

        if (isValidString(custom5.getText()))
        {
          state = custom5.getText();
        }
        else
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid state input");
          alert.showAndWait();
          return;
        }

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
        int width = 0;
        int length = 0;
        int bridges = 0;
        int tunnels = 0;
        String environmental = null;
        String geographical = null;

        try
        {
          width = Integer.parseInt(custom1.getText());
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
          length = Integer.parseInt(custom2.getText());
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
          bridges = Integer.parseInt(custom3.getText());
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
          tunnels = Integer.parseInt(custom4.getText());
        }
        catch (NumberFormatException exception)
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid number of tunnels input");
          alert.showAndWait();
          return;
        }

        if (isValidString(custom5.getText()))
        {
          environmental = custom5.getText();
        }
        else
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid environmental challenges input");
          alert.showAndWait();
          return;
        }

        if (isValidString(custom6.getText()))
        {
          geographical = custom6.getText();
        }
        else
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText("");
          alert.setContentText("Invalid geographical challenges input");
          alert.showAndWait();
          return;
        }

        project = new RoadConstruction(newName, newBudget, newDate, newStatus,
            newProjectID, newTimeline, newCustomer, newResources, width, length,
            bridges, tunnels, environmental, geographical);
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

        MyFileHandler.writeToTextFile("projects.txt", list.toString());
      }


      projectManager.updateProject(project);
      updateProjectArea();
      populateComboBox();
      viewHandler.openView("ProjectView");
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Success");
      alert.setHeaderText("");
      alert.setContentText("Changes successfully saved!");
      alert.showAndWait();
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

  /**
   * Updates the project area in the main project view.
   */
  private void updateProjectArea() {
    ProjectList projectList = projectManager.getAllProjects();
    projectViewController.populateTable(projectList);
  }
}
