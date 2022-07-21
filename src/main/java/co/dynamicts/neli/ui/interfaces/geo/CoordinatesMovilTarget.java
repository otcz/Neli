package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.IngresoCoordenadas;
import co.dynamicts.neli.core.interfaces.MovilTarget;
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

public class CoordinatesMovilTarget extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private Toggle latitudeToggle;
  
  @FXML
  private LatLngTextField latitudeDegrees;
  
  @FXML
  private LatLngTextField latitudeMinutes;
  
  @FXML
  private LatLngTextField latitudeSeconds;
  
  @FXML
  private Toggle longitudeToggle;
  
  @FXML
  private LatLngTextField longitudeDegrees;
  
  @FXML
  private LatLngTextField longitudeMinutes;
  
  @FXML
  private LatLngTextField longitudeSeconds;
  
  @FXML
  private TextField height;
  
  @FXML
  private TextField azimuth;
  
  @FXML
  private TextField speed;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  public CoordinatesMovilTarget() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/aim_moving_target.fxml"), AppConfig.getInstance().getResouce());
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
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    updateComponents();
    this.height.getProperties().put("vkType", "numeric");
    this.azimuth.getProperties().put("vkType", "numeric");
    this.speed.getProperties().put("vkType", "numeric");
    this.latitudeDegrees
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeDegrees.getTextField(), newValue.booleanValue()));
    this.latitudeMinutes
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeMinutes.getTextField(), newValue.booleanValue()));
    this.latitudeSeconds
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.latitudeSeconds.getTextField(), newValue.booleanValue()));
    this.longitudeDegrees
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeDegrees.getTextField(), newValue.booleanValue()));
    this.longitudeMinutes
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeMinutes.getTextField(), newValue.booleanValue()));
    this.longitudeSeconds
      .getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.longitudeSeconds.getTextField(), newValue.booleanValue()));
    this.height
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.height, newValue.booleanValue()));
    this.azimuth
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.azimuth, newValue.booleanValue()));
    this.speed
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.speed, newValue.booleanValue()));
    this.cancel.setOnMouseClicked(event -> {
          clearForm();
          Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
        });
    this.accept.setOnMouseClicked(event -> {
          if (validateForm()) {
            formSubmit();
            try {
              MovilTarget movilTarget = MovilTarget.getSingletonInstance();
              movilTarget.puntoPartidaGeo.setLatGrados(Double.parseDouble(this.latitudeDegrees.getText()));
              movilTarget.puntoPartidaGeo.setLatMinutos(Double.parseDouble(this.latitudeMinutes.getText()));
              movilTarget.puntoPartidaGeo.setLatSegundos(Double.parseDouble(this.latitudeSeconds.getText()));
              if (this.latitudeToggle.isSelected()) {
                movilTarget.puntoPartidaGeo.setSignoLatitud("S");
              } else {
                movilTarget.puntoPartidaGeo.setSignoLatitud("N");
              } 
              movilTarget.puntoPartidaGeo.setLonGrados(Double.parseDouble(this.longitudeDegrees.getText()));
              movilTarget.puntoPartidaGeo.setLonMinutos(Double.parseDouble(this.longitudeMinutes.getText()));
              movilTarget.puntoPartidaGeo.setLonSegundos(Double.parseDouble(this.longitudeSeconds.getText()));
              if (this.longitudeToggle.isSelected()) {
                movilTarget.puntoPartidaGeo.setSignoLongitud("E");
              } else {
                movilTarget.puntoPartidaGeo.setSignoLongitud("W");
              } 
              movilTarget.puntoPartidaGeo.setAltura(Double.parseDouble(this.height.getText()));
              movilTarget.setAzimuth(Double.parseDouble(this.azimuth.getText()));
              movilTarget.setVelocidad(Double.parseDouble(this.speed.getText()));
              (IngresoCoordenadas.getSingletonInstance()).blancoDeseadoGeograficas.punto(movilTarget.puntoPartidaGeo);
              IngresoCoordenadas.getSingletonInstance().setBlancoDeseado();
              Configuracion.getSingletonInstance().setTipoCalculo(Configuracion.TipoCalculo.MOVIL);
              Configuracion.getSingletonInstance().setCriterio(Configuracion.Criterio.SUPERVIVENCIA);
            } catch (IOException e) {
              e.printStackTrace();
            } 
          } else {
            Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
          } 
        });
    clearForm();
  }
  
  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.latitudeDegrees.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_DEGREES_LATITUDE))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.longitudeDegrees.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_DEGREES_LONGITUDE))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.latitudeMinutes.getTextField() || textField == this.longitudeMinutes.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_MINUTES))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.latitudeSeconds.getTextField() || textField == this.longitudeSeconds.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.ANGLE_SECONDS))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (field == this.height && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
      textField.getStyleClass().add("error"); 
    if (textField == this.azimuth) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AZIMUTH))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.speed) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.SPEED))
        textField.getStyleClass().add("error"); 
      return;
    } 
  }
  
  private void clearForm() {
    this.latitudeDegrees.setText("0");
    this.latitudeMinutes.setText("0");
    this.latitudeSeconds.setText("0.00");
    this.longitudeDegrees.setText("0");
    this.longitudeMinutes.setText("0");
    this.longitudeSeconds.setText("0.00");
    this.height.setText("0");
    this.azimuth.setText("0.00");
    this.speed.setText("0.00");
  }
  
  private boolean validateForm() {
    validateField(this.latitudeDegrees.getTextField(), false);
    validateField(this.latitudeMinutes.getTextField(), false);
    validateField(this.latitudeSeconds.getTextField(), false);
    validateField(this.longitudeDegrees.getTextField(), false);
    validateField(this.longitudeMinutes.getTextField(), false);
    validateField(this.longitudeSeconds.getTextField(), false);
    validateField(this.height, false);
    validateField(this.azimuth, false);
    validateField(this.speed, false);
    if (this.latitudeDegrees.getTextField().getStyleClass().contains("error") || this.latitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.latitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.longitudeDegrees
      .getTextField().getStyleClass().contains("error") || this.longitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.longitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.height
      .getStyleClass().contains("error") || this.azimuth
      .getStyleClass().contains("error") || this.speed
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\CoordinatesMovilTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */