package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class AddProjectViewController {

  @FXML
  private Text projectTypeText;

  @FXML
  private Button residentialButton;

  @FXML
  private Button industrialButton;

  @FXML
  private Button commercialButton;

  @FXML
  private Button roadConstructionButton;

  @FXML
  private MenuBar menuBar;

  @FXML
  private Menu fileMenu;

  @FXML
  private MenuItem closeMenuItem;

  @FXML
  private Menu editMenu;

  @FXML
  private MenuItem deleteMenuItem;

  @FXML
  private Menu helpMenu;

  @FXML
  private MenuItem aboutMenuItem;

  @FXML
  private void initialize() {
    // You can perform initialization tasks here.
  }

  @FXML
  private void handleResidentialButtonAction(ActionEvent event) {
    projectTypeText.setText("Residential project selected");
    // Add your logic for Residential project here
  }

  @FXML
  private void handleIndustrialButtonAction(ActionEvent event) {
    projectTypeText.setText("Industrial project selected");
    // Add your logic for Industrial project here
  }

  @FXML
  private void handleCommercialButtonAction(ActionEvent event) {
    projectTypeText.setText("Commercial project selected");
    // Add your logic for Commercial project here
  }

  @FXML
  private void handleRoadConstructionButtonAction(ActionEvent event) {
    projectTypeText.setText("Road Construction project selected");
    // Add your logic for Road Construction project here
  }

//  @FXML
//  private void handleCloseMenuItemAction(ActionEvent event) {
//    // Add your logic for closing the application or the current project
//  }
//
//  @FXML
//  private void handleDeleteMenuItemAction(ActionEvent event) {
//    // Add your logic for deleting a project or data
//  }
//
//  @FXML
//  private void handleAboutMenuItemAction(ActionEvent event) {
//    // Add your logic for displaying information about the application
//  }
}
