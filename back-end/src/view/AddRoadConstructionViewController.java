package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.ProjectModelManager;

public class AddRoadConstructionViewController {


    private ViewHandler viewHandler;
    private Scene scene;
    private ProjectModelManager projectManager;

    @FXML private Button backButton;


    public void init(ViewHandler viewHandler, Scene scene, ProjectModelManager projectManager)
    {
        this.viewHandler = viewHandler;
        this.scene = scene;
        this.projectManager = projectManager;
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
        if(e.getSource()==backButton){
            viewHandler.openView("AddProjectView");
        }
    }
}
