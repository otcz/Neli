package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Host extends VBox implements BaseUserInterface, Initializable {
  private static Host targetName;
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  Ins ins = Ins.getSingletonInstance();
  @FXML
  private TextField host;
  @FXML
  private Button edit;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public Host() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/host.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.host.getProperties().put("vkType", "numeric");
    this.host.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.host, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
    });
    this.clearForm();
    if (AppConfig.getInstance().getPoint() != null) {
    }

  }

  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (field == this.host && !newValue && !textField.getText().matches(MeasureExpression.HOST)) {
      textField.getStyleClass().add("error");
    }

  }

  private void clearForm() {
    this.host.setText("");
  }

  private boolean validateForm() {
    this.validateField(this.host, false);
    return !this.host.getStyleClass().contains("error");
  }

  private void formSubmit() {
    if (!this.host.getText().equals("")) {
      Main.getAppController().setInfoMessage("OK", "ERROR");
    }

  }

  public static Host getSingletonInstance() throws IOException {
    if (targetName == null) {
      targetName = new Host();
    }

    return targetName;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Host.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */