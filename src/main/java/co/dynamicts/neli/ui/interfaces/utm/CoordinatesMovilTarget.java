package co.dynamicts.neli.ui.interfaces.utm;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
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

public class CoordinatesMovilTarget extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField east;
  
  @FXML
  private TextField north;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> use;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> band;
  
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
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/utm/aim_moving_target.fxml"), AppConfig.getInstance().getResouce());
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
    this.east.getProperties().put("vkType", "numeric");
    this.north.getProperties().put("vkType", "numeric");
    this.height.getProperties().put("vkType", "numeric");
    this.azimuth.getProperties().put("vkType", "numeric");
    this.speed.getProperties().put("vkType", "numeric");
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
        public String toString(SimpleComboBoxItem object) {
          return object.getText();
        }
        
        public SimpleComboBoxItem fromString(String string) {
          return new SimpleComboBoxItem(string, null);
        }
      };
    this.east.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.east, newValue.booleanValue()));
    this.north.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.north, newValue.booleanValue()));
    this.height.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.height, newValue.booleanValue()));
    this.azimuth.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.azimuth, newValue.booleanValue()));
    this.speed.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.speed, newValue.booleanValue()));
    this.band.setConverter(stringConverter);
    String bands = "CDEFGHJKLMNPQRSTUVWX";
    for (int bandIterator = 0; bandIterator < bands.length(); bandIterator++) {
      String useLetter = bands.substring(bandIterator, bandIterator + 1);
      this.band.getItems().add(new SimpleComboBoxItem(useLetter, useLetter));
    } 
    this.use.setConverter(stringConverter);
    for (int userIterator = 1; userIterator <= 60; userIterator++)
      this.use.getItems().add(new SimpleComboBoxItem("" + userIterator, "" + userIterator)); 
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
  }
  
  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    if (field instanceof TextField) {
      TextField textField = (TextField)field;
      textField.getStyleClass().remove("error");
      if (textField == this.east) {
        if (!newValue && 
          !textField.getText().matches(MeasureExpression.DELTA_EAST))
          textField.getStyleClass().add("error"); 
        return;
      } 
      if (textField == this.north) {
        if (!newValue && 
          !textField.getText().matches(MeasureExpression.DELTA_NORTH))
          textField.getStyleClass().add("error"); 
        return;
      } 
      if (textField == this.height && 
        !newValue && !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
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
    } else if (field instanceof ComboBox) {
      ComboBox<SimpleComboBoxItem> comboBox = (ComboBox)field;
      if (comboBox == this.use && !newValue) {
        SimpleComboBoxItem simpleComboBoxItem = comboBox.getSelectionModel().getSelectedItem();
        if (simpleComboBoxItem != null && simpleComboBoxItem.getText() != null && 
          !String.valueOf(simpleComboBoxItem.getData()).matches(MeasureExpression.UTM_USE)) {
          System.out.println(simpleComboBoxItem.getData());
          comboBox.getStyleClass().add("error");
        } 
        return;
      } 
      if (comboBox == this.band && !newValue) {
        SimpleComboBoxItem simpleComboBoxItem = comboBox.getSelectionModel().getSelectedItem();
        if (simpleComboBoxItem != null && simpleComboBoxItem.getText() != null && 
          !String.valueOf(simpleComboBoxItem.getData()).matches(MeasureExpression.UTM_ZONE))
          comboBox.getStyleClass().add("error"); 
      } 
    } 
  }
  
  private void clearForm() {
    this.east.setText("0");
    this.north.setText("0");
    this.height.setText("0");
    this.use.getSelectionModel().select(0);
    this.band.getSelectionModel().select(0);
    this.azimuth.setText("0.00");
    this.speed.setText("0.00");
  }
  
  private boolean validateForm() {
    validateField(this.east, false);
    validateField(this.north, false);
    validateField(this.height, false);
    validateField(this.use, false);
    validateField(this.band, false);
    if (this.east.getStyleClass().contains("error") || this.north
      .getStyleClass().contains("error") || this.use
      .getStyleClass().contains("error") || this.band
      .getStyleClass().contains("error") || this.azimuth
      .getStyleClass().contains("error") || this.speed
      .getStyleClass().contains("error") || this.height
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interface\\utm\CoordinatesMovilTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */