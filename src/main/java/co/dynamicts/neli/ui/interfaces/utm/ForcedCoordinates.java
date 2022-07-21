package co.dynamicts.neli.ui.interfaces.utm;

import co.dynamicts.Main;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.utilities.ConversorCoordenadas;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.PuntoUTM;
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
import javafx.scene.control.Toggle;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForcedCoordinates extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField eastForcing;
  
  @FXML
  private TextField northForcing;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> useForcing;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> bandForcing;
  
  @FXML
  private TextField heightForcing;
  
  @FXML
  private Toggle forcing;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  @FXML
  private TextField eastGPS;
  
  @FXML
  private TextField northGPS;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> useGPS;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> bandGPS;
  
  @FXML
  private TextField heightGPS;
  
  Ins ins;
  
  public ForcedCoordinates() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/utm/forced_coordinates.fxml"), AppConfig.getInstance().getResouce());
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
    this.ins = Ins.getSingletonInstance();
    setCoordinatesGPS();
    updateComponents();
    this.eastForcing.getProperties().put("vkType", "numeric");
    this.northForcing.getProperties().put("vkType", "numeric");
    this.heightForcing.getProperties().put("vkType", "numeric");
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
        public String toString(SimpleComboBoxItem object) {
          return object.getText();
        }
        
        public SimpleComboBoxItem fromString(String string) {
          return new SimpleComboBoxItem(string, null);
        }
      };
    this.eastForcing.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.eastForcing, newValue.booleanValue()));
    this.northForcing.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.northForcing, newValue.booleanValue()));
    this.heightForcing.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.heightForcing, newValue.booleanValue()));
    this.bandForcing.setConverter(stringConverter);
    this.bandGPS.setConverter(stringConverter);
    String bands = "CDEFGHJKLMNPQRSTUVWX";
    for (int bandIterator = 0; bandIterator < bands.length(); bandIterator++) {
      String useLetter = bands.substring(bandIterator, bandIterator + 1);
      this.bandForcing.getItems().add(new SimpleComboBoxItem(useLetter, useLetter));
      this.bandGPS.getItems().add(new SimpleComboBoxItem(useLetter, useLetter));
    } 
    this.useForcing.setConverter(stringConverter);
    this.useGPS.setConverter(stringConverter);
    for (int userIterator = 1; userIterator <= 60; userIterator++) {
      this.useForcing.getItems().add(new SimpleComboBoxItem("" + userIterator, "" + userIterator));
      this.useGPS.getItems().add(new SimpleComboBoxItem("" + userIterator, "" + userIterator));
    } 
    this.forcing.selectedProperty().addListener((observable, oldValue, newValue) -> {
          if (newValue.booleanValue()) {
            this.eastForcing.setDisable(false);
            this.northForcing.setDisable(false);
            this.useForcing.setDisable(false);
            this.bandForcing.setDisable(false);
            this.heightForcing.setDisable(false);
          } else {
            clearForm();
          } 
        });
    this.cancel.setOnMouseClicked(event -> {
          clearForm();
          this.ins.setForcedCoordinates(false);
          Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
        });
    this.accept.setOnMouseClicked(event -> {
          if (validateForm()) {
            if (this.forcing.isSelected()) {
              formSubmit();
            } else {
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
      PuntoUTM puntoUTM = new PuntoUTM();
      ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
      puntoUTM = ConversorCoordenadas.convertirGeo_a_UTM(AppConfig.getInstance().getForcing(), "WGS84");
      int bandAux = 0;
      String bandLetter = bands.substring(bandAux, bandAux + 1);
      while (!puntoUTM.getBanda().equals(bandLetter)) {
        bandLetter = bands.substring(bandAux, bandAux + 1);
        bandAux++;
      } 
      this.eastForcing.setText(String.valueOf((int)puntoUTM.getDeltaEste()));
      this.northForcing.setText(String.valueOf((int)puntoUTM.getDeltaNorte()));
      this.useForcing.getSelectionModel().select((int)puntoUTM.getHuso() - 1);
      this.bandForcing.getSelectionModel().select(bandAux - 1);
    } 
  }
  
  private void setCoordinatesGPS() {
    Ins ins = Ins.getSingletonInstance();
    this.eastGPS.setText(String.valueOf(ins.obusUTM_GPS.getDeltaEste()));
    this.northGPS.setText(String.valueOf(ins.obusUTM_GPS.getDeltaNorte()));
    this.useGPS.setVisibleRowCount((int)ins.obusUTM_GPS.getHuso());
    this.bandGPS.setVisibleRowCount(Integer.parseInt(ins.obusUTM_GPS.getBanda()));
    this.heightGPS.setText(String.valueOf(ins.obusGPS.getAltura()));
  }
  
  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    if (field instanceof TextField) {
      TextField textField = (TextField)field;
      textField.getStyleClass().remove("error");
      if (textField == this.eastForcing) {
        if (!newValue && 
          !textField.getText().matches(MeasureExpression.DELTA_EAST))
          textField.getStyleClass().add("error"); 
        return;
      } 
      if (textField == this.northForcing) {
        if (!newValue && 
          !textField.getText().matches(MeasureExpression.DELTA_NORTH))
          textField.getStyleClass().add("error"); 
        return;
      } 
      if (textField == this.heightForcing && 
        !newValue && !textField.getText().matches(MeasureExpression.DISTANCE_METERS_105))
        textField.getStyleClass().add("error"); 
    } else if (field instanceof ComboBox) {
      ComboBox<SimpleComboBoxItem> comboBox = (ComboBox)field;
      if (comboBox == this.useForcing && !newValue) {
        SimpleComboBoxItem simpleComboBoxItem = comboBox.getSelectionModel().getSelectedItem();
        if (simpleComboBoxItem != null && simpleComboBoxItem.getText() != null && 
          !String.valueOf(simpleComboBoxItem.getData()).matches(MeasureExpression.UTM_USE)) {
          System.out.println(simpleComboBoxItem.getData());
          comboBox.getStyleClass().add("error");
        } 
        return;
      } 
      if (comboBox == this.bandForcing && !newValue) {
        SimpleComboBoxItem simpleComboBoxItem = comboBox.getSelectionModel().getSelectedItem();
        if (simpleComboBoxItem != null && simpleComboBoxItem.getText() != null && 
          !String.valueOf(simpleComboBoxItem.getData()).matches(MeasureExpression.UTM_ZONE))
          comboBox.getStyleClass().add("error"); 
      } 
    } 
  }
  
  private void clearForm() {
    this.eastForcing.setDisable(true);
    this.northForcing.setDisable(true);
    this.useForcing.setDisable(true);
    this.bandForcing.setDisable(true);
    this.heightForcing.setDisable(true);
    this.eastForcing.setText("0");
    this.northForcing.setText("0");
    this.useForcing.getSelectionModel().select(0);
    this.bandForcing.getSelectionModel().select(0);
    this.heightForcing.setText("0");
    this.eastGPS.setText("0");
    this.northGPS.setText("0");
    this.useGPS.getSelectionModel().select(0);
    this.bandGPS.getSelectionModel().select(0);
    this.heightGPS.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.eastForcing, false);
    validateField(this.northForcing, false);
    validateField(this.useForcing, false);
    validateField(this.bandForcing, false);
    validateField(this.heightForcing, false);
    return (!this.eastForcing.getStyleClass().contains("error") && 
      !this.northForcing.getStyleClass().contains("error") && 
      !this.useForcing.getStyleClass().contains("error") && 
      !this.bandForcing.getStyleClass().contains("error") && 
      !this.heightForcing.getStyleClass().contains("error"));
  }
  
  private void formSubmit() {
    PuntoUTM puntoUTMForzado = new PuntoUTM();
    puntoUTMForzado.setBanda((String)((SimpleComboBoxItem)this.bandForcing.getSelectionModel().getSelectedItem()).getData());
    puntoUTMForzado.setHuso(Double.parseDouble((String)((SimpleComboBoxItem)this.useForcing.getSelectionModel().getSelectedItem()).getData()));
    puntoUTMForzado.setDeltaNorte(Double.parseDouble(this.northForcing.getText()));
    puntoUTMForzado.setDeltaEste(Double.parseDouble(this.eastForcing.getText()));
    puntoUTMForzado.setAltura(Double.parseDouble(this.heightForcing.getText()));
    this.ins.obusUTMForzado = puntoUTMForzado;
    this.ins.setForcedCoordinates(true);
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
    puntoGeograficas = ConversorCoordenadas.convertirUTM_a_Geo(puntoUTMForzado, "WGS84");
    AppConfig.getInstance().setForcing(puntoGeograficas);
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interface\\utm\ForcedCoordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */