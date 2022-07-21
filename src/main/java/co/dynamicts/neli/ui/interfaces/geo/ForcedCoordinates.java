package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.LatLngTextField;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForcedCoordinates extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private Toggle latitudeToggleForcing;
  
  @FXML
  private LatLngTextField latitudeDegreesForcing;
  
  @FXML
  private LatLngTextField latitudeMinutesForcing;
  
  @FXML
  private LatLngTextField latitudeSecondsForcing;
  
  @FXML
  private Toggle longitudeToggleForcing;
  
  @FXML
  private LatLngTextField longitudeDegreesForcing;
  
  @FXML
  private LatLngTextField longitudeMinutesForcing;
  
  @FXML
  private LatLngTextField longitudeSecondsForcing;
  
  @FXML
  private TextField heightForcing;
  
  @FXML
  private Toggle forcing;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  @FXML
  private Toggle latitudeToggleGPS;
  
  @FXML
  private LatLngTextField latitudeDegreesGPS;
  
  @FXML
  private LatLngTextField latitudeMinutesGPS;
  
  @FXML
  private LatLngTextField latitudeSecondsGPS;
  
  @FXML
  private Toggle longitudeToggleGPS;
  
  @FXML
  private LatLngTextField longitudeDegreesGPS;
  
  @FXML
  private LatLngTextField longitudeMinutesGPS;
  
  @FXML
  private LatLngTextField longitudeSecondsGPS;
  
  @FXML
  private TextField heightGPS;
  
  Ins ins;
  
  public ForcedCoordinates() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/forced_coordinates.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
    setCoordinatesGPS();
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    this.ins = Ins.getSingletonInstance();
    updateComponents();
    this.heightForcing.getProperties().put("vkType", "numeric");
    this.latitudeDegreesForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeDegreesForcing.getTextField(), newValue.booleanValue()));
    this.latitudeMinutesForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeMinutesForcing.getTextField(), newValue.booleanValue()));
    this.latitudeSecondsForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeSecondsForcing.getTextField(), newValue.booleanValue()));
    this.longitudeDegreesForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeDegreesForcing.getTextField(), newValue.booleanValue()));
    this.longitudeMinutesForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeMinutesForcing.getTextField(), newValue.booleanValue()));
    this.longitudeSecondsForcing
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeSecondsForcing.getTextField(), newValue.booleanValue()));
    this.heightForcing
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.heightForcing, newValue.booleanValue()));
    this.forcing.selectedProperty().addListener((observable, oldValue, newValue) -> {
          if (newValue.booleanValue()) {
            this.latitudeDegreesForcing.setDisable(false);
            this.latitudeMinutesForcing.setDisable(false);
            this.latitudeSecondsForcing.setDisable(false);
            this.longitudeDegreesForcing.setDisable(false);
            this.longitudeMinutesForcing.setDisable(false);
            this.longitudeSecondsForcing.setDisable(false);
            this.heightForcing.setDisable(false);
          } else {
            clearForm();
          } 
        });
    this.cancel.setOnMouseClicked(event -> {
          clearForm();
          Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
        });
    this.accept.setOnMouseClicked(event -> {
          if (validateForm()) {
            if (this.forcing.isSelected()) {
              formSubmit();
            } else {
              setCoordinatesGPS();
              this.ins.setForcedCoordinates(false);
              AppConfig.getInstance().setForcing(null);
              Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
            } 
          } else {
            Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
          } 
        });
    clearForm();
    if (AppConfig.getInstance().getForcing() != null) {
      this.forcing.setSelected(true);
      if (AppConfig.getInstance().getForcing().getSignoLatitud().equals("S")) {
        this.latitudeToggleForcing.setSelected(true);
      } else {
        this.latitudeToggleForcing.setSelected(false);
      } 
      if (AppConfig.getInstance().getForcing().getSignoLongitud().equals("E")) {
        this.longitudeToggleForcing.setSelected(true);
      } else {
        this.longitudeToggleForcing.setSelected(false);
      } 
      this.latitudeDegreesForcing.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getForcing().getLatGrados())));
      this.latitudeMinutesForcing.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getForcing().getLatMinutos())));
      this.latitudeSecondsForcing.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getForcing().getLatSegundos()))));
      this.longitudeDegreesForcing.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getForcing().getLonGrados())));
      this.longitudeMinutesForcing.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getForcing().getLonMinutos())));
      this.longitudeSecondsForcing.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getForcing().getLonSegundos()))));
    } 
  }
  
  private void setCoordinatesGPS() {
    Ins ins = Ins.getSingletonInstance();
    if (ins.obusGPS.getLatitud() > 0.0D) {
      this.latitudeToggleGPS.setSelected(false);
    } else {
      this.latitudeToggleGPS.setSelected(true);
    } 
    this.latitudeDegreesGPS.setText(String.valueOf(ins.obusGPS.getLatGrados()));
    this.latitudeMinutesGPS.setText(String.valueOf(ins.obusGPS.getLatMinutos()));
    this.latitudeSecondsGPS.setText(String.valueOf(ins.obusGPS.getLatSegundos()));
    if (ins.obusGPS.getLongitud() < 0.0D) {
      this.longitudeToggleGPS.setSelected(false);
    } else {
      this.longitudeToggleGPS.setSelected(true);
    } 
    this.longitudeDegreesGPS.setText(String.valueOf(ins.obusGPS.getLonGrados()));
    this.longitudeMinutesGPS.setText(String.valueOf(ins.obusGPS.getLonMinutos()));
    this.longitudeSecondsGPS.setText(String.valueOf(ins.obusGPS.getLonSegundos()));
    this.heightGPS.setText(String.valueOf(ins.obusGPS.getAltura()));
  }
  
  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.latitudeDegreesForcing.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_DEGREES_LATITUDE))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.longitudeDegreesForcing.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_DEGREES_LONGITUDE))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.latitudeMinutesForcing.getTextField() || textField == this.longitudeMinutesForcing.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_MINUTES))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.latitudeSecondsForcing.getTextField() || textField == this.longitudeSecondsForcing.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_SECONDS))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (field == this.heightForcing && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
      textField.getStyleClass().add("error"); 
  }
  
  private void clearForm() {
    this.latitudeDegreesForcing.setDisable(true);
    this.latitudeMinutesForcing.setDisable(true);
    this.latitudeSecondsForcing.setDisable(true);
    this.longitudeDegreesForcing.setDisable(true);
    this.longitudeMinutesForcing.setDisable(true);
    this.longitudeSecondsForcing.setDisable(true);
    this.heightForcing.setDisable(true);
    this.latitudeDegreesForcing.setText("0");
    this.latitudeMinutesForcing.setText("0");
    this.latitudeSecondsForcing.setText("0.00");
    this.longitudeDegreesForcing.setText("0");
    this.longitudeMinutesForcing.setText("0");
    this.longitudeSecondsForcing.setText("0.00");
    this.heightForcing.setText("0");
    this.latitudeDegreesGPS.setText("0");
    this.latitudeMinutesGPS.setText("0");
    this.latitudeSecondsGPS.setText("0.00");
    this.longitudeDegreesGPS.setText("0");
    this.longitudeMinutesGPS.setText("0");
    this.longitudeSecondsGPS.setText("0.00");
    this.heightGPS.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.latitudeDegreesForcing.getTextField(), false);
    validateField(this.latitudeMinutesForcing.getTextField(), false);
    validateField(this.latitudeSecondsForcing.getTextField(), false);
    validateField(this.longitudeDegreesForcing.getTextField(), false);
    validateField(this.longitudeMinutesForcing.getTextField(), false);
    validateField(this.longitudeSecondsForcing.getTextField(), false);
    validateField(this.heightForcing, false);
    if (this.latitudeDegreesForcing.getTextField().getStyleClass().contains("error") || this.latitudeMinutesForcing
      .getTextField().getStyleClass().contains("error") || this.latitudeSecondsForcing
      .getTextField().getStyleClass().contains("error") || this.longitudeDegreesForcing
      .getTextField().getStyleClass().contains("error") || this.longitudeMinutesForcing
      .getTextField().getStyleClass().contains("error") || this.longitudeSecondsForcing
      .getTextField().getStyleClass().contains("error") || this.heightForcing
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    PuntoGeograficas puntoForzado = new PuntoGeograficas();
    puntoForzado.setLonGrados(Double.parseDouble(this.longitudeDegreesForcing.getText()));
    puntoForzado.setLonMinutos(Double.parseDouble(this.longitudeMinutesForcing.getText()));
    puntoForzado.setLonSegundos(Double.parseDouble(this.longitudeSecondsForcing.getText()));
    if (this.longitudeToggleForcing.isSelected()) {
      puntoForzado.setSignoLongitud("E");
    } else {
      puntoForzado.setSignoLongitud("W");
    } 
    puntoForzado.setLatGrados(Double.parseDouble(this.latitudeDegreesForcing.getText()));
    puntoForzado.setLatMinutos(Double.parseDouble(this.latitudeMinutesForcing.getText()));
    puntoForzado.setLatSegundos(Double.parseDouble(this.latitudeSecondsForcing.getText()));
    if (this.latitudeToggleForcing.isSelected()) {
      puntoForzado.setSignoLatitud("S");
    } else {
      puntoForzado.setSignoLatitud("N");
    } 
    puntoForzado.setAltura(Double.parseDouble(this.heightForcing.getText()));
    this.ins.obusForzado.punto(puntoForzado);
    this.ins.setForcedCoordinates(true);
    AppConfig.getInstance().setForcing(puntoForzado);
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\ForcedCoordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */