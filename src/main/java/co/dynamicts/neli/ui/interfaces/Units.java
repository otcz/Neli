package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadAngulo;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadCoordenadas;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadDistancia;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Units extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private ComboBox<SimpleComboBoxItem> coordinates;
  @FXML
  private ComboBox<SimpleComboBoxItem> distance;
  @FXML
  private ComboBox<SimpleComboBoxItem> angle;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;
  private Configuracion configuracion;

  public Units() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/config_units.fxml"), AppConfig.getInstance().getResouce());
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
    this.configuracion = Configuracion.getSingletonInstance();
    this.updateComponents();
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    };
    this.coordinates.setConverter(stringConverter);
    this.coordinates.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.coordinates.geo"), UnidadCoordenadas.GEOGRAFICAS));
    this.coordinates.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.coordinates.utm"), UnidadCoordenadas.UTM));
    this.distance.setConverter(stringConverter);
    this.distance.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.range.m"), UnidadDistancia.METROS));
    this.distance.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.range.km"), UnidadDistancia.KILOMETROS));
    this.angle.setConverter(stringConverter);
    this.angle.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.angle.g"), UnidadAngulo.GRADOS));
    this.angle.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.units.angle.mil"), UnidadAngulo.MILESIMAS));
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().changeUI(MenuNavEnum.HOME, true);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      }

    });
    this.clearForm();
  }

  private void clearForm() {
    if (UnidadCoordenadas.UTM.equals(this.configuracion.getUnidadCoordenadas())) {
      this.coordinates.getSelectionModel().select(1);
    } else {
      this.coordinates.getSelectionModel().select(0);
    }

    if (UnidadDistancia.KILOMETROS.equals(this.configuracion.getUnidadDistancia())) {
      this.distance.getSelectionModel().select(1);
    } else {
      this.distance.getSelectionModel().select(0);
    }

    if (UnidadAngulo.MILESIMAS.equals(this.configuracion.getUnidadAngulo())) {
      this.angle.getSelectionModel().select(1);
    } else {
      this.angle.getSelectionModel().select(0);
    }

  }

  private boolean validateForm() {
    return true;
  }

  private void formSubmit() {
    this.configuracion.setUnidadCoordenadas((UnidadCoordenadas)((SimpleComboBoxItem)this.coordinates.getSelectionModel().getSelectedItem()).getData());
    this.configuracion.setUnidadDistancia((UnidadDistancia)((SimpleComboBoxItem)this.distance.getSelectionModel().getSelectedItem()).getData());
    this.configuracion.setUnidadAngulo((UnidadAngulo)((SimpleComboBoxItem)this.angle.getSelectionModel().getSelectedItem()).getData());
    this.configuracion.actualizaConfiguracion();
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
    Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Units.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */