package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.IngresoDatosTiro;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shoot extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField orientation;
  @FXML
  private TextField elevation;
  @FXML
  private TextField height;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public Shoot() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/aim_shoot.fxml"), AppConfig.getInstance().getResouce());
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
    this.orientation.getProperties().put("vkType", "numeric");
    this.elevation.getProperties().put("vkType", "numeric");
    this.height.getProperties().put("vkType", "numeric");
    StringConverter var10000 = new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    };
    this.orientation.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.orientation, newValue);
    });
    this.elevation.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.elevation, newValue);
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
    if (field instanceof TextField) {
      TextField textField = (TextField)field;
      textField.getStyleClass().remove("error");
      if (textField == this.orientation) {
        if (!newValue && !textField.getText().matches(MeasureExpression.AZIMUTH)) {
          textField.getStyleClass().add("error");
        }

        return;
      }

      if (textField == this.elevation) {
        if (!newValue && !textField.getText().matches(MeasureExpression.ELEVATION)) {
          textField.getStyleClass().add("error");
        }

        return;
      }

      if (textField == this.height) {
        if (!newValue && !textField.getText().matches(MeasureExpression.HEIGHT_METERS)) {
          textField.getStyleClass().add("error");
        }

        return;
      }
    } else if (field instanceof ComboBox) {
      ComboBox comboBox = (ComboBox)field;
      comboBox.getStyleClass().remove("error");
    }

  }

  private void clearForm() {
    this.orientation.setText("0.00");
    this.elevation.setText("0.00");
    this.height.setText("0");
  }

  private boolean validateForm() {
    this.validateField(this.orientation, false);
    this.validateField(this.elevation, false);
    this.validateField(this.height, false);
    return !this.orientation.getStyleClass().contains("error") && !this.elevation.getStyleClass().contains("error") && !this.height.getStyleClass().contains("error");
  }

  private void formSubmit() {
    IngresoDatosTiro ingresoDatosTiro = null;

    try {
      ingresoDatosTiro = IngresoDatosTiro.getSingletonInstance();
    } catch (IOException var3) {
      System.out.println("No ha logro ingresar a Ingresar Datos de tiro");
      var3.printStackTrace();
      Main.getAppController().setInfoMessage("Error al obtener datos de tiro", "ERROR");
      return;
    }

    ingresoDatosTiro.actitud.setElevacion(Double.parseDouble(this.elevation.getText()));
    ingresoDatosTiro.actitud.setAzimut(Double.parseDouble(this.orientation.getText()));
    ingresoDatosTiro.setAlturaBlanco(Double.parseDouble(this.height.getText()));

    try {
      ingresoDatosTiro.setBlancoDeseado();
      if (DatosCalculados.getSingletonInstance().isPosible()) {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Blanco Cargado", "El blanco se cargo con éxito", "INFO");
        });
        Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      }
    } catch (IOException var4) {
      System.out.println("No pudo setear el blanco deseado");
      var4.printStackTrace();
      return;
    }

    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Shoot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */