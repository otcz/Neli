package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.IngresoOAPolares;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.LatLngTextField;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.application.Platform;
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

public class CoordinatesObserver extends VBox implements BaseUserInterface, Initializable {
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
  private TextField azimuth;
  
  @FXML
  private TextField distance;
  
  @FXML
  private TextField height;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  public CoordinatesObserver() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/aim_polar_observer.fxml"), AppConfig.getInstance().getResouce());
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
    this.azimuth.getProperties().put("vkType", "numeric");
    this.distance.getProperties().put("vkType", "numeric");
    this.height.getProperties().put("vkType", "numeric");
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
    this.azimuth
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.azimuth, newValue.booleanValue()));
    this.distance
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.distance, newValue.booleanValue()));
    this.height
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.height, newValue.booleanValue()));
    this.cancel.setOnMouseClicked(event -> {
          clearForm();
          Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
        });
    this.accept.setOnMouseClicked(event -> {
          if (validateForm()) {
            formSubmit();
          } else {
            Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
          } 
        });
    clearForm();
    if (AppConfig.getInstance().getObserver() != null) {
      if (AppConfig.getInstance().getObserver().getSignoLatitud().equals("S")) {
        this.latitudeToggle.setSelected(true);
      } else {
        this.latitudeToggle.setSelected(false);
      } 
      if (AppConfig.getInstance().getObserver().getSignoLongitud().equals("E")) {
        this.longitudeToggle.setSelected(true);
      } else {
        this.longitudeToggle.setSelected(false);
      } 
      this.latitudeDegrees.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getObserver().getLatGrados())));
      this.latitudeMinutes.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getObserver().getLatMinutos())));
      this.latitudeSeconds.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getObserver().getLatSegundos()))));
      this.longitudeDegrees.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getObserver().getLonGrados())));
      this.longitudeMinutes.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getObserver().getLonMinutos())));
      this.longitudeSeconds.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getObserver().getLonSegundos()))));
    } 
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
    if (textField == this.azimuth) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AZIMUTH))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.distance) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.height && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.HEIGHT_METERS))
      textField.getStyleClass().add("error"); 
  }
  
  private void clearForm() {
    this.latitudeDegrees.setText("0");
    this.latitudeMinutes.setText("0");
    this.latitudeSeconds.setText("0.00");
    this.longitudeDegrees.setText("0");
    this.longitudeMinutes.setText("0");
    this.longitudeSeconds.setText("0.00");
    this.azimuth.setText("0.00");
    this.distance.setText("0");
    this.height.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.latitudeDegrees.getTextField(), false);
    validateField(this.latitudeMinutes.getTextField(), false);
    validateField(this.latitudeSeconds.getTextField(), false);
    validateField(this.longitudeDegrees.getTextField(), false);
    validateField(this.longitudeMinutes.getTextField(), false);
    validateField(this.longitudeSeconds.getTextField(), false);
    validateField(this.azimuth, false);
    validateField(this.distance, false);
    validateField(this.height, false);
    if (this.latitudeDegrees.getTextField().getStyleClass().contains("error") || this.latitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.latitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.longitudeDegrees
      .getTextField().getStyleClass().contains("error") || this.longitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.longitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.azimuth
      .getStyleClass().contains("error") || this.distance
      .getStyleClass().contains("error") || this.height
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    IngresoOAPolares ingresoOAPolares;
    try {
      ingresoOAPolares = IngresoOAPolares.getSingletonInstance();
    } catch (IOException e) {
      System.out.println("No pudo iniciar la clase IngresoOAPolares");
      e.printStackTrace();
      return;
    } 
    ingresoOAPolares.observador.setLonGrados(Double.parseDouble(this.longitudeDegrees.getText()));
    ingresoOAPolares.observador.setLonMinutos(Double.parseDouble(this.longitudeMinutes.getText()));
    ingresoOAPolares.observador.setLonSegundos(Double.parseDouble(this.longitudeSeconds.getText()));
    if (this.longitudeToggle.isSelected()) {
      ingresoOAPolares.observador.setSignoLongitud("E");
    } else {
      ingresoOAPolares.observador.setSignoLongitud("W");
    } 
    ingresoOAPolares.observador.setLatGrados(Double.parseDouble(this.latitudeDegrees.getText()));
    ingresoOAPolares.observador.setLatMinutos(Double.parseDouble(this.latitudeMinutes.getText()));
    ingresoOAPolares.observador.setLatSegundos(Double.parseDouble(this.latitudeSeconds.getText()));
    if (this.latitudeToggle.isSelected()) {
      ingresoOAPolares.observador.setSignoLatitud("S");
    } else {
      ingresoOAPolares.observador.setSignoLatitud("N");
    } 
    ingresoOAPolares.posicion.setAzimut(Double.parseDouble(this.azimuth.getText()));
    ingresoOAPolares.posicion.setDistancia(Double.parseDouble(this.distance.getText()));
    ingresoOAPolares.setAlturaBlanco(Double.parseDouble(this.height.getText()));
    try {
      ingresoOAPolares.setBlancoDeseado();
      if (DatosCalculados.getSingletonInstance().isPosible()) {
        Platform.runLater(() -> Main.getAppController().setInfoDialog("Blanco Cargado", "El blanco se cargo con éxito", "INFO"));
        Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      } else {
        Platform.runLater(() -> Main.getAppController().setInfoDialog("Blanco Cargado", "Blanco Fuera de Alcance", "ERROR"));
        Main.getAppController().setInfoMessage("Blanco fuera de Alcance", "ERROR");
      } 
    } catch (IOException e) {
      System.out.println("No se actualizo en coordenadas la coordenada");
      e.printStackTrace();
    } 
    AppConfig.getInstance().setObserver(ingresoOAPolares.observador);
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\CoordinatesObserver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */