package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Correcciones;
import co.dynamicts.neli.core.utilities.DataTools;
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

public class Corrections extends VBox implements BaseUserInterface, Initializable {
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
  private LatLngTextField up;
  
  @FXML
  private LatLngTextField down;
  
  @FXML
  private LatLngTextField left;
  
  @FXML
  private LatLngTextField right;
  
  @FXML
  private TextField heightIncrease;
  
  @FXML
  private TextField heightDecrease;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  public Corrections() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/corrections.fxml"), AppConfig.getInstance().getResouce());
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
    this.heightIncrease.getProperties().put("vkType", "numeric");
    this.heightDecrease.getProperties().put("vkType", "numeric");
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
    this.up.getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.up.getTextField(), newValue.booleanValue()));
    this.down.getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.down.getTextField(), newValue.booleanValue()));
    this.left.getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.left.getTextField(), newValue.booleanValue()));
    this.right.getTextField()
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.right.getTextField(), newValue.booleanValue()));
    this.heightIncrease
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.heightIncrease, newValue.booleanValue()));
    this.heightDecrease
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.heightDecrease, newValue.booleanValue()));
    this.cancel.setOnMouseClicked(event -> {
          clearForm();
          Main.getAppController().changeUI(MenuNavEnum.HOME, true);
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
    AppConfig config = AppConfig.getInstance();
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
    if (textField == this.up.getTextField() || textField == this.down.getTextField() || textField == this.left.getTextField() || textField == this.right.getTextField()) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.CORRECTION))
        textField.getStyleClass().add("error"); 
      return;
    } 
    if (textField == this.heightIncrease || textField == this.heightDecrease) {
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.CORRECTION))
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
    this.up.setText("0");
    this.down.setText("0");
    this.left.setText("0");
    this.right.setText("0");
    this.heightIncrease.setText("0");
    this.heightDecrease.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.latitudeDegrees.getTextField(), false);
    validateField(this.latitudeMinutes.getTextField(), false);
    validateField(this.latitudeSeconds.getTextField(), false);
    validateField(this.longitudeDegrees.getTextField(), false);
    validateField(this.longitudeMinutes.getTextField(), false);
    validateField(this.longitudeSeconds.getTextField(), false);
    validateField(this.up.getTextField(), false);
    validateField(this.down.getTextField(), false);
    validateField(this.left.getTextField(), false);
    validateField(this.right.getTextField(), false);
    validateField(this.heightIncrease, false);
    validateField(this.heightDecrease, false);
    if (this.latitudeDegrees.getTextField().getStyleClass().contains("error") || this.latitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.latitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.longitudeDegrees
      .getTextField().getStyleClass().contains("error") || this.longitudeMinutes
      .getTextField().getStyleClass().contains("error") || this.longitudeSeconds
      .getTextField().getStyleClass().contains("error") || this.up
      .getTextField().getStyleClass().contains("error") || this.down
      .getTextField().getStyleClass().contains("error") || this.left
      .getTextField().getStyleClass().contains("error") || this.right
      .getTextField().getStyleClass().contains("error") || this.heightIncrease
      .getStyleClass().contains("error") || this.heightDecrease
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    Correcciones correcciones = null;
    try {
      correcciones = Correcciones.getSingletonInstance();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    if (correcciones == null) {
      Main.getAppController().setInfoMessage("Correcciones no alcanzable", "ERROR");
      return;
    } 
    correcciones.observador.setLonGrados(Double.parseDouble(this.longitudeDegrees.getText()));
    correcciones.observador.setLonMinutos(Double.parseDouble(this.longitudeMinutes.getText()));
    correcciones.observador.setLonSegundos(Double.parseDouble(this.longitudeSeconds.getText()));
    if (this.longitudeToggle.isSelected()) {
      correcciones.observador.setSignoLongitud("E");
    } else {
      correcciones.observador.setSignoLongitud("W");
    } 
    correcciones.observador.setLatGrados(Double.parseDouble(this.latitudeDegrees.getText()));
    correcciones.observador.setLatMinutos(Double.parseDouble(this.latitudeMinutes.getText()));
    correcciones.observador.setLatSegundos(Double.parseDouble(this.latitudeSeconds.getText()));
    if (this.latitudeToggle.isSelected()) {
      correcciones.observador.setSignoLatitud("S");
    } else {
      correcciones.observador.setSignoLatitud("N");
    } 
    try {
      correcciones.correccion(
          Double.parseDouble(this.up.getText()), 
          Double.parseDouble(this.down.getText()), 
          Double.parseDouble(this.right.getText()), 
          Double.parseDouble(this.left.getText()), 
          Double.parseDouble(this.heightIncrease.getText()), 
          Double.parseDouble(this.heightDecrease.getText()));
    } catch (IOException e) {
      e.printStackTrace();
    } 
    AppConfig.getInstance().setObserver(correcciones.observador);
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
    Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\Corrections.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */