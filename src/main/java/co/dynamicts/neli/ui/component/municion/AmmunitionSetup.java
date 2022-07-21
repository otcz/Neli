package co.dynamicts.neli.ui.component.municion;

import co.dynamicts.Main;
import co.dynamicts.neli.core.stauts.StatusAmmunition;
import co.dynamicts.neli.core.stauts.StatusAmmunitionOptions;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import co.dynamicts.neli.ui.component.common.MenuTitle;
import co.dynamicts.neli.ui.component.common.TextfieldTitle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AmmunitionSetup extends AnchorPane {
  @FXML
  private MenuTitle ammunitionType;
  
  @FXML
  private MenuTitle fuseGunType;
  
  @FXML
  private MenuTitle propellantType;
  
  @FXML
  private MenuTitle zone;
  
  @FXML
  private TextfieldTitle temperature;
  
  @FXML
  private MenuTitle explosionHeight;
  
  @FXML
  private ButtonImage cancel;
  
  @FXML
  private ButtonImage save;
  
  @FXML
  private Label ammunitionHandlingLabel;
  
  @FXML
  private ButtonImage add;
  
  @FXML
  private ButtonImage delete;
  
  @FXML
  private ButtonImage edit;
  
  private StatusAmmunition status;
  
  private StatusAmmunitionOptions optionStatus;
  
  @FXML
  public void initialize() {
    setTitles();
    setChoices();
    this.add.setOnAction(event -> Main.getAppController().showPassword());
    this.edit.setOnAction(event -> {
          Main.getAppController().showSuccess("Se agregó ammunition", "/images/municiones3x.png");
          Main.getAppController().showPassword();
          Main.getAppController().hidePassword();
        });
  }
  
  public AmmunitionSetup() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/ammunition/ammunition_setup.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    this.save.setOnAction(event -> saveEstadoMunicion());
    this.cancel.setOnAction(event -> cancelEstadoMunicion());
  }
  
  private void setChoices() {
    choice(this.ammunitionType);
    choice(this.fuseGunType);
    choice(this.propellantType);
    choice(this.zone);
    choice(this.explosionHeight);
  }
  
  private void cancelEstadoMunicion() {}
  
  private void setStatus() {
    if (this.ammunitionType.getMenu() == null);
  }
  
  private void setTitles() {
    this.ammunitionType.setMenuTitleText("Tipo de Municion");
    this.fuseGunType.setMenuTitleText("Tipo de Espoleta");
    this.propellantType.setMenuTitleText("Tipo de Propelente");
    this.zone.setMenuTitleText("zone");
    this.explosionHeight.setMenuTitleText("Altura explosion m");
    this.add.getImageButtonLabel().setText("Agregar Municion");
    this.edit.getImageButtonLabel().setText("Editar Municion");
    this.delete.getImageButtonLabel().setText("Borrar Municion");
    this.ammunitionHandlingLabel.setText("Manejo de Municion");
    this.temperature.setTitleText("Temperatura [C°]");
    this.cancel.getImageButtonLabel().setText("Cancelar");
    this.save.getImageButtonLabel().setText("Guardar");
  }
  
  private void saveEstadoMunicion() {}
  
  private void choice(MenuTitle tipoDeMunicion) {}
  
  public MenuTitle getAmmunitionType() {
    return this.ammunitionType;
  }
  
  public void setAmmunitionType(MenuTitle ammunitionType) {
    this.ammunitionType = ammunitionType;
  }
  
  public MenuTitle getFuseGunType() {
    return this.fuseGunType;
  }
  
  public void setFuseGunType(MenuTitle fuseGunType) {
    this.fuseGunType = fuseGunType;
  }
  
  public MenuTitle getPropellantType() {
    return this.propellantType;
  }
  
  public void setPropellantType(MenuTitle propellantType) {
    this.propellantType = propellantType;
  }
  
  public MenuTitle getzone() {
    return this.zone;
  }
  
  public void setzone(MenuTitle zone) {
    this.zone = zone;
  }
  
  public MenuTitle getExplosionHeight() {
    return this.explosionHeight;
  }
  
  public void setExplosionHeight(MenuTitle explosionHeight) {
    this.explosionHeight = explosionHeight;
  }
  
  public ButtonImage getCancel() {
    return this.cancel;
  }
  
  public void setCancel(ButtonImage cancel) {
    this.cancel = cancel;
  }
  
  public ButtonImage getSave() {
    return this.save;
  }
  
  public void setSave(ButtonImage save) {
    this.save = save;
  }
  
  public Label getAmmunitionHandlingLabel() {
    return this.ammunitionHandlingLabel;
  }
  
  public void setAmmunitionHandlingLabel(Label ammunitionHandlingLabel) {
    this.ammunitionHandlingLabel = ammunitionHandlingLabel;
  }
  
  public ButtonImage getAdd() {
    return this.add;
  }
  
  public void setAdd(ButtonImage add) {
    this.add = add;
  }
  
  public ButtonImage getDelete() {
    return this.delete;
  }
  
  public void setDelete(ButtonImage delete) {
    this.delete = delete;
  }
  
  public ButtonImage getEdit() {
    return this.edit;
  }
  
  public void setEdit(ButtonImage edit) {
    this.edit = edit;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\municion\AmmunitionSetup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */