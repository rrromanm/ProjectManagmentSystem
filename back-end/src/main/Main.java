package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.startpageController;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Load the first scene
    FXMLLoader loader = new FXMLLoader(getClass().getResource("startpage.fxml"));
    Parent root = loader.load();
    Scene scene1 = new Scene(root);

    // Set the stage with the first scene
    primaryStage.setTitle("Scene Switching Example");
    primaryStage.setScene(scene1);
    primaryStage.show();

    // Get the controller for the first scene
    startpageController scene1Controller = loader.getController();

    // Set an action in the controller to switch to the second scene
    scene1Controller.setSwitchToScene2Action((arg) -> switchToScene2(primaryStage));
  }

  private void switchToScene2(Stage primaryStage) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("system.fxml"));
      Scene scene2 = new Scene(root);
      primaryStage.setScene(scene2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
