package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.Sistema;
import co.dynamicts.neli.core.interfaces.IngresoPolares;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.application.Platform;
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

public class Polars extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField azimuth;
  @FXML
  private TextField distance;
  @FXML
  private TextField height;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;
  Configuracion configuracion = Configuracion.getSingletonInstance();

  public Polars() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/aim_polars.fxml"), AppConfig.getInstance().getResouce());
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
    this.azimuth.getProperties().put("vkType", "numeric");
    this.distance.getProperties().put("vkType", "numeric");
    this.height.getProperties().put("vkType", "numeric");
    this.azimuth.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.azimuth, newValue);
    });
    this.distance.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.distance, newValue);
    });
    this.height.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.height, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
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
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.azimuth) {
      if (!newValue && !textField.getText().matches(MeasureExpression.AZIMUTH)) {
        textField.getStyleClass().add("error");
      }

    } else {
      textField.getStyleClass().remove("error");
      if (textField != this.distance) {
        textField.getStyleClass().remove("error");
        if (textField == this.height && !newValue && !textField.getText().matches(MeasureExpression.HEIGHT_METERS)) {
          textField.getStyleClass().add("error");
        }

      } else {
        if (!newValue) {
          if (Sistema.OBUS_155.equals(this.configuracion.getSistema())) {
            if (!textField.getText().matches(MeasureExpression.DISTANCE_METERS_155)) {
              textField.getStyleClass().add("error");
            }
          } else if ((Sistema.OBUS_105_L119.equals(this.configuracion.getSistema()) || Sistema.OBUS_105_LG.equals(this.configuracion.getSistema())) && !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105)) {
            textField.getStyleClass().add("error");
          }
        }

      }
    }
  }

  private void clearForm() {
    this.azimuth.setText("0.00");
    this.distance.setText("0");
    this.height.setText("0");
  }

  private boolean validateForm() {
    this.validateField(this.azimuth, false);
    this.validateField(this.distance, false);
    this.validateField(this.height, false);
    return !this.azimuth.getStyleClass().contains("error") && !this.distance.getStyleClass().contains("error") && !this.height.getStyleClass().contains("error");
  }

  private void formSubmit() {
    IngresoPolares ingresoPolares = null;

    try {
      ingresoPolares = IngresoPolares.getSingletonInstance();
    } catch (IOException var4) {
      System.out.println("No pudo ingresar al singleton polares");
      var4.printStackTrace();
    }

    ingresoPolares.posicion.setDistancia(Double.parseDouble(this.distance.getText()));
    ingresoPolares.posicion.setAzimut(Double.parseDouble(this.azimuth.getText()));
    ingresoPolares.setAlturaBlanco(Double.parseDouble(this.height.getText()));

    try {
      ingresoPolares.setBlancoDeseado();
      if (DatosCalculados.getSingletonInstance().isPosible()) {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Blanco Cargado", "El blanco se cargo con éxito", "INFO");
        });
        Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Blanco Cargado", "Blanco Fuera de Alcance", "ERROR");
        });
        Main.getAppController().setInfoMessage("Blanco fuera de Alcance", "ERROR");
      }
    } catch (IOException var3) {
      var3.printStackTrace();
      return;
    }

    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Polars.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */