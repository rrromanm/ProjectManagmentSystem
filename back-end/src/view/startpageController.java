package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.function.Consumer;
public class startpageController
{
  private Consumer<Void> switchToScene2Action;

  public void setSwitchToScene2Action(Consumer<Void> switchToScene2Action) {
    this.switchToScene2Action = switchToScene2Action;
  }

  @FXML
  private void switchToScene2(ActionEvent event) {
    if (switchToScene2Action != null) {
      switchToScene2Action.accept(null);
    }
  }
}
