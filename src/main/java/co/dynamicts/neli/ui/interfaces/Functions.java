package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Functions extends VBox implements BaseUserInterface, Initializable {
  private boolean openedMessage = false;
  @FXML
  private Button accept;
  @FXML
  private Button cancel;

  public Functions() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/functions.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
  }
}
