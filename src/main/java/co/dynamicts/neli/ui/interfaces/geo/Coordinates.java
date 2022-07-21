package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.IngresoCoordenadas;
import co.dynamicts.neli.core.local.model.Point;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.LatLngTextField;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.interfaces.TargetName;
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

public class Coordinates extends VBox implements BaseUserInterface, Initializable {
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
  private Button cancel;
  
  @FXML
  private Button accept;
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Coordinates() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/aim_coordinates.fxml"), AppConfig.getInstance().getResouce());
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
    if (AppConfig.getInstance().getPoint() != null) {
      Point point = AppConfig.getInstance().getPoint();
      String coordinatesFromDB = point.getTargetCoordinatesFromDB();
      String[] aux = coordinatesFromDB.split(" ");
      if (aux[0].equals("S")) {
        this.latitudeToggle.setSelected(true);
      } else {
        this.latitudeToggle.setSelected(false);
      } 
      if (aux[4].equals("E")) {
        this.longitudeToggle.setSelected(true);
      } else {
        this.longitudeToggle.setSelected(false);
      } 
      this.latitudeDegrees.setText(aux[5]);
      this.latitudeMinutes.setText(aux[6]);
      this.latitudeSeconds.setText(aux[7]);
      this.longitudeDegrees.setText(aux[1]);
      this.longitudeMinutes.setText(aux[2]);
      this.longitudeSeconds.setText(aux[3]);
      this.height.setText(aux[8]);
      setName(point.getName());
      AppConfig.getInstance().setPoint(null);
    } 
    if (AppConfig.getInstance().getTarget() != null) {
      if (AppConfig.getInstance().getTarget().getSignoLatitud().equals("S")) {
        this.latitudeToggle.setSelected(true);
      } else {
        this.latitudeToggle.setSelected(false);
      } 
      if (AppConfig.getInstance().getTarget().getSignoLongitud().equals("E")) {
        this.longitudeToggle.setSelected(true);
      } else {
        this.longitudeToggle.setSelected(false);
      } 
      this.latitudeDegrees.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getTarget().getLatGrados())));
      this.latitudeMinutes.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getTarget().getLatMinutos())));
      this.latitudeSeconds.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getTarget().getLatSegundos()))));
      this.longitudeDegrees.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getTarget().getLonGrados())));
      this.longitudeMinutes.setText(String.valueOf((int)Math.abs(AppConfig.getInstance().getTarget().getLonMinutos())));
      this.longitudeSeconds.setText(String.valueOf(DataTools.limitaDecimales(Math.abs(AppConfig.getInstance().getTarget().getLonSegundos()))));
      this.height.setText(String.valueOf((int)AppConfig.getInstance().getTarget().getAltura()));
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
    if (field == this.height && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
      textField.getStyleClass().add("error"); 
  }
  
  private void clearForm() {
    this.latitudeDegrees.setText("0");
    this.latitudeMinutes.setText("0");
    this.latitudeSeconds.setText("0.00");
    this.longitudeDegrees.setText("0");
    this.longitudeMinutes.setText("0");
    this.longitudeSeconds.setText("0.00");
    this.height.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.latitudeDegrees.getTextField(), false);
    validateField(this.latitudeMinutes.getTextField(), false);
    validateField(this.latitudeSeconds.getTextField(), false);
    validateField(this.longitudeDegrees.getTextField(), false);
    validateField(this.longitudeMinutes.getTextField(), false);
    validateField(this.longitudeSeconds.getTextField(), false);
    validateField(this.height, false);
    if (this.latitudeDegrees.getTextField().getStyleClass().contains("error") || this.latitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.latitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.longitudeDegrees
      .getTextField().getStyleClass().contains("error") || this.longitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.longitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.height
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    IngresoCoordenadas ingresoCoordenadas;
    try {
      ingresoCoordenadas = IngresoCoordenadas.getSingletonInstance();
    } catch (IOException e1) {
      System.out.println("No pudo iniciar la clase IngresoCoordenadas");
      e1.printStackTrace();
      return;
    } 
    ingresoCoordenadas.blancoDeseadoGeograficas.setLonGrados(Double.parseDouble(this.longitudeDegrees.getText()));
    ingresoCoordenadas.blancoDeseadoGeograficas.setLonMinutos(Double.parseDouble(this.longitudeMinutes.getText()));
    ingresoCoordenadas.blancoDeseadoGeograficas.setLonSegundos(Double.parseDouble(this.longitudeSeconds.getText()));
    if (this.longitudeToggle.isSelected()) {
      ingresoCoordenadas.blancoDeseadoGeograficas.setSignoLongitud("E");
    } else {
      ingresoCoordenadas.blancoDeseadoGeograficas.setSignoLongitud("W");
    } 
    ingresoCoordenadas.blancoDeseadoGeograficas.setLatGrados(Double.parseDouble(this.latitudeDegrees.getText()));
    ingresoCoordenadas.blancoDeseadoGeograficas.setLatMinutos(Double.parseDouble(this.latitudeMinutes.getText()));
    ingresoCoordenadas.blancoDeseadoGeograficas.setLatSegundos(Double.parseDouble(this.latitudeSeconds.getText()));
    if (this.latitudeToggle.isSelected()) {
      ingresoCoordenadas.blancoDeseadoGeograficas.setSignoLatitud("S");
    } else {
      ingresoCoordenadas.blancoDeseadoGeograficas.setSignoLatitud("N");
    } 
    ingresoCoordenadas.blancoDeseadoGeograficas.setAltura(Double.parseDouble(this.height.getText()));
    AppConfig.getInstance().setTarget(ingresoCoordenadas.blancoDeseadoGeograficas);
    try {
      ingresoCoordenadas.setBlancoDeseado();
      if (getName() != null) {
        TargetName.getSingletonInstance().addOrUpdateTarget(getName());
        Platform.runLater(() -> setName(null));
      } 
      if (DatosCalculados.getSingletonInstance().isPosible()) {
        Platform.runLater(() -> Main.getAppController().setInfoDialog("Blanco Cargado", "El blanco se cargo con éxito", "INFO"));
        Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      } else {
        Platform.runLater(() -> Main.getAppController().setInfoDialog("Blanco Cargado", "Blanco Fuera de Alcance", "ERROR"));
        Main.getAppController().setInfoMessage("Blanco fuera de Alcance", "ERROR");
      } 
    } catch (IOException e1) {
      e1.printStackTrace();
    } 
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\Coordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */