package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.local.model.Ammunition;
import co.dynamicts.neli.core.local.service.AmmunitionService;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.common.Password;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import co.dynamicts.neli.ui.utils.StringUtil;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Ammo extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private ComboBox<SimpleComboBoxItem> ammoType;
  @FXML
  private ComboBox<SimpleComboBoxItem> ammoFuze;
  @FXML
  private ComboBox<SimpleComboBoxItem> ammoWeightBox;
  @FXML
  private ComboBox<SimpleComboBoxItem> ammoZone;
  @FXML
  private TextField ammoTemperature;
  @FXML
  private TextField ammoProp;
  @FXML
  private TextField ammoExplosion;
  @FXML
  private TextField ammoQty;
  @FXML
  private TextField fuzeEffect;
  @FXML
  private Button accept;
  @FXML
  private Button cancel;
  @FXML
  private Button add;
  @FXML
  private Button delete;
  @FXML
  private Button edit;
  private Configuracion configuracion;
  private Password password;
  Ammunition ammoSelect = new Ammunition();

  public Ammo() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/config_ammo.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }

    this.updateComponents();
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.configuracion = Configuracion.getSingletonInstance();
    this.password = Password.getSingletonInstance();
    this.ammoTemperature.getProperties().put("vkType", "numeric");
    this.ammoExplosion.getProperties().put("vkType", "numeric");
    this.ammoQty.getProperties().put("vkType", "numeric");
    this.ammoTemperature.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ammoTemperature, newValue);
    });
    this.ammoExplosion.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ammoExplosion, newValue);
    });
    this.ammoQty.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ammoQty, newValue);
    });
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    };
    this.ammoType.setConverter(stringConverter);
    this.ammoType.getItems().clear();
    this.ammoFuze.setConverter(stringConverter);
    this.ammoZone.setConverter(stringConverter);
    this.ammoWeightBox.setConverter(stringConverter);
    this.configuracion.setAmmoList();
    this.ammoZone.setDisable(this.configuracion.isActivaZone());
    if (this.configuracion.getAmmoList() != null) {
      for(int i = 0; i < this.configuracion.getAmmoList().size(); ++i) {
        this.ammoType.getItems().add(new SimpleComboBoxItem(((Ammunition)this.configuracion.getAmmoList().get(i)).getNombreMunicion(), i));
      }
    }

    this.ammoType.valueProperty().addListener((observable, oldValue, newValue) -> {
      this.ammoFuze.getItems().clear();
      this.ammoFuze.setValue( null);
      this.ammoZone.getItems().clear();
      this.ammoZone.setValue( null);
      this.ammoWeightBox.getItems().clear();
      this.ammoWeightBox.setValue( null);
      if (this.ammoType.getValue() != null) {
        try {
          AmmunitionService ammunitionService = new AmmunitionService();
          ammunitionService.createTableIfNotExists(Ammunition.class);
          this.ammoSelect = (Ammunition)ammunitionService.getById(Ammunition.class, ((SimpleComboBoxItem)this.ammoType.getSelectionModel().getSelectedItem()).getText());

          int i;
          for(i = 0; i < this.ammoSelect.getZonesSelected().split(",").length; ++i) {
            this.ammoZone.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.load.zone") + " " + this.ammoSelect.getZonesSelected().split(",")[i], i));
          }

          this.ammoZone.getSelectionModel().select(0);

          for(i = 0; i < (this.ammoSelect.getIndexEspoletas() + 1) * 3; i += 3) {
            String[] aux = this.ammoSelect.getEspoletas().split(",");
            this.ammoFuze.getItems().add(new SimpleComboBoxItem(aux[i], i / 3));
          }

          this.ammoFuze.getSelectionModel().select(0);

          for(i = 0; i < 5; ++i) {
            String texto = "";

            for(int j = 0; j < i + 1; ++j) {
              texto = texto + "◻";
            }

            this.ammoWeightBox.getItems().add(new SimpleComboBoxItem(texto, i));
            texto = "";
          }

          this.ammoWeightBox.getSelectionModel().select(this.ammoSelect.getIndexMunicionPesoSTD());
          if (this.ammoSelect.getNombreMunicion().equals(this.configuracion.getTipoMunicion())) {
            this.ammoQty.setText(String.valueOf(this.configuracion.getCantidadMunicion()));
            this.ammoTemperature.setText(String.valueOf(this.configuracion.getTempProp()));
            this.ammoExplosion.setText(String.valueOf(this.configuracion.getAlturaExplosion_m()));
          } else {
            this.ammoQty.setText("1");
            this.ammoTemperature.setText("21.0");
            this.ammoExplosion.setText("0.00");
          }
        } catch (SQLException var8) {
          var8.printStackTrace();
        } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
        }
      }

    });
    this.ammoZone.valueProperty().addListener((observable, oldValue, newValue) -> {
      if (this.ammoZone.getValue() != null) {
        String[] aux = this.ammoSelect.getPropArray().split(",");
        String[] numZone = ((SimpleComboBoxItem)this.ammoZone.getSelectionModel().getSelectedItem()).getText().split(" ");
        this.ammoProp.setText(aux[Integer.parseInt(numZone[1]) - 1]);
      }

    });
    this.ammoFuze.valueProperty().addListener((observable, oldValue, newValue) -> {
      if (this.ammoFuze.getValue() != null) {
        String[] aux = this.ammoSelect.getEspoletas().split(",");
        int index = this.ammoFuze.getSelectionModel().getSelectedIndex() * 3 + 2;
        this.fuzeEffect.setText(aux[index]);
        if (!aux[index].equals("TIME") && !aux[index].equals("DELAY")) {
          this.ammoExplosion.setDisable(true);
        } else {
          this.ammoExplosion.setDisable(false);
        }
      }

    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().changeUI(MenuNavEnum.HOME, true);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      }

    });
    this.add.setOnMouseClicked((event) -> {
      if (Main.getAppController().setPasswordDialog()) {
        Main.getAppController().changeUIWithOutMenu(MenuNavEnum.AMMO, "PAGINA_AJUSTES_155", false);
      }

    });
    this.delete.setOnMouseClicked((event) -> {
      AmmunitionService ammunitionService = null;

      try {
        ammunitionService = new AmmunitionService();
        ammunitionService.createTableIfNotExists(Ammunition.class);
        Ammunition ammunition = (Ammunition)this.configuracion.getAmmoList().get(this.ammoType.getSelectionModel().getSelectedIndex());
        ammunitionService.deleteById(Ammunition.class, ammunition.getNombreMunicion());
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog(StringUtil.translateKey("alert.ammo.title.ammos.deleted"), StringUtil.translateKey("alert.ammo.content.ammos.deleted"), "INFO");
        });
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.ammo.deleted"), "INFO");
        this.configuracion.setAmmoList();
      } catch (SQLException var4) {
        var4.printStackTrace();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }

      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
    });
    this.edit.setOnMouseClicked((event) -> {
      new Ammunition();

      try {
        AmmunitionService ammunitionService = new AmmunitionService();
        ammunitionService.createTableIfNotExists(Ammunition.class);
        Ammunition ammunitionExist = (Ammunition)ammunitionService.getById(Ammunition.class, ((SimpleComboBoxItem)this.ammoType.getSelectionModel().getSelectedItem()).getText());
        if (ammunitionExist != null) {
          AppConfig.getInstance().setAmmunition(ammunitionExist);
          if (Main.getAppController().setPasswordDialog()) {
            Main.getAppController().changeUIWithOutMenu(MenuNavEnum.AMMO, "PAGINA_AJUSTES_155", false);
          }
        }
      } catch (SQLException var5) {
        var5.printStackTrace();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }

    });
    this.clearForm();
    if (AppConfig.getInstance().getConfiguration() != null) {
      this.ammoType.getSelectionModel().select(this.configuracion.getIndexMunicion());
      this.ammoZone.getSelectionModel().select(this.configuracion.getNumeroZona() - 1);
      this.ammoFuze.getSelectionModel().select(this.configuracion.getIndexEspoleta());
      this.ammoWeightBox.getSelectionModel().select(this.configuracion.getCuadros() - 1);
      this.ammoTemperature.setText(String.valueOf(this.configuracion.getTempProp()));
      this.ammoQty.setText(String.valueOf(this.configuracion.getCantidadMunicion()));
      this.ammoExplosion.setText(String.valueOf(this.configuracion.getAlturaExplosion_m()));
    }

  }

  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    if (field instanceof TextField) {
      TextField textField = (TextField)field;
      textField.getStyleClass().remove("error");
      if (textField == this.ammoTemperature && !newValue && !textField.getText().matches(MeasureExpression.TEMPERATURE)) {
        textField.getStyleClass().add("error");
      }

      if (textField == this.ammoQty && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_INT)) {
        textField.getStyleClass().add("error");
      }

      if (textField == this.ammoExplosion && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_POSITIVE_DOUBLE)) {
        textField.getStyleClass().add("error");
      }
    }

  }

  private void clearForm() {
    this.ammoType.getSelectionModel().select(0);
    this.ammoTemperature.setText("0");
    this.ammoExplosion.setText("0");
    this.ammoQty.setText("0");
  }

  private boolean validateForm() {
    this.validateField(this.ammoTemperature, false);
    return !this.ammoTemperature.getStyleClass().contains("error") && !this.ammoQty.getStyleClass().contains("error") && !this.ammoExplosion.getStyleClass().contains("error");
  }

  private void formSubmit() {
    this.configuracion.setTipoMunicion(((SimpleComboBoxItem)this.ammoType.getSelectionModel().getSelectedItem()).getText());
    this.configuracion.setNumeroZona(Integer.parseInt(((SimpleComboBoxItem)this.ammoZone.getSelectionModel().getSelectedItem()).getText().split(" ")[1]));
    this.configuracion.setIndexCuadros(this.ammoWeightBox.getSelectionModel().getSelectedIndex());
    this.configuracion.setTempProp(Double.parseDouble(this.ammoTemperature.getText()));
    this.configuracion.setCantidadMunicion(Integer.parseInt(this.ammoQty.getText()));
    this.configuracion.setAlturaExplosion_m(Double.parseDouble(this.ammoExplosion.getText()));
    this.configuracion.setIndexEspoleta(this.ammoFuze.getSelectionModel().getSelectedIndex());
    this.configuracion.actualizaConfiguracion();
    DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
    this.updateComponents();
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
    Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
  }
}