package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
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

public class Sensor extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField azimuthCorrection;
  @FXML
  private TextField elevationCorrection;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public Sensor() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/config_sensor.fxml"), AppConfig.getInstance().getResouce());
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
    this.azimuthCorrection.getProperties().put("vkType", "numeric");
    this.elevationCorrection.getProperties().put("vkType", "numeric");
    this.azimuthCorrection.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.azimuthCorrection, newValue);
    });
    this.elevationCorrection.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.elevationCorrection, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().changeUI(MenuNavEnum.HOME, true);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.clearForm();
  }

  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    if (field instanceof TextField) {
      TextField textField = (TextField)field;
      textField.getStyleClass().remove("error");
      if (textField == this.azimuthCorrection || textField == this.elevationCorrection) {
        if (!newValue && !textField.getText().matches(MeasureExpression.AZIMUTH)) {
          textField.getStyleClass().add("error");
        }

        return;
      }
    }

  }

  private void clearForm() {
    this.azimuthCorrection.setText("0.00");
    this.elevationCorrection.setText("0.00");
  }

  private boolean validateForm() {
    this.validateField(this.azimuthCorrection, false);
    this.validateField(this.elevationCorrection, false);
    return !this.azimuthCorrection.getStyleClass().contains("error") && !this.elevationCorrection.getStyleClass().contains("error");
  }

  private void formSubmit() {
    Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Sensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */