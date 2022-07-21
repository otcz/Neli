package co.dynamicts.neli.ui.interfaces.utm;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Correcciones;
import co.dynamicts.neli.core.utilities.ConversorCoordenadas;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.LatLngTextField;
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

public class Corrections extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField east;
  
  @FXML
  private TextField north;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> use;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> band;
  
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
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/utm/corrections.fxml"), AppConfig.getInstance().getResouce());
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
    this.east.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.east, newValue.booleanValue()));
    this.north.focusedProperty().addListener((observable, oldValue, newValue) -> validateField(this.north, newValue.booleanValue()));
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
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
        public String toString(SimpleComboBoxItem object) {
          return object.getText();
        }
        
        public SimpleComboBoxItem fromString(String string) {
          return new SimpleComboBoxItem(string, null);
        }
      };
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
      PuntoUTM puntoUTM = new PuntoUTM();
      ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
      puntoUTM = ConversorCoordenadas.convertirGeo_a_UTM(AppConfig.getInstance().getObserver(), "WGS84");
      int bandAux = 0;
      String bandLetter = bands.substring(bandAux, bandAux + 1);
      while (!puntoUTM.getBanda().equals(bandLetter)) {
        bandLetter = bands.substring(bandAux, bandAux + 1);
        bandAux++;
      } 
      this.east.setText(String.valueOf((int)puntoUTM.getDeltaEste()));
      this.north.setText(String.valueOf((int)puntoUTM.getDeltaNorte()));
      this.use.getSelectionModel().select((int)puntoUTM.getHuso() - 1);
      this.band.getSelectionModel().select(bandAux - 1);
    } 
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
      if ((textField == this.up.getTextField() || textField == this.down.getTextField() || textField == this.left.getTextField() || textField == this.right.getTextField()) && 
        !newValue && 
        !textField.getText().matches(MeasureExpression.CORRECTION))
        textField.getStyleClass().add("error"); 
      if (textField == this.heightIncrease || textField == this.heightDecrease) {
        if (!newValue && 
          !textField.getText().matches(MeasureExpression.CORRECTION))
          textField.getStyleClass().add("error"); 
        return;
      } 
    } else if (field instanceof ComboBox) {
      ComboBox<SimpleComboBoxItem> comboBox = (ComboBox)field;
      comboBox.getStyleClass().remove("error");
      if (comboBox == this.use && !newValue) {
        SimpleComboBoxItem simpleComboBoxItem = comboBox.getSelectionModel().getSelectedItem();
        if (simpleComboBoxItem != null && simpleComboBoxItem.getText() != null && 
          !String.valueOf(simpleComboBoxItem.getData()).matches(MeasureExpression.UTM_USE))
          comboBox.getStyleClass().add("error"); 
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
    this.use.getSelectionModel().select(0);
    this.band.getSelectionModel().select(0);
    this.up.setText("0");
    this.down.setText("0");
    this.left.setText("0");
    this.right.setText("0");
    this.heightIncrease.setText("0");
    this.heightDecrease.setText("0");
  }
  
  private boolean validateForm() {
    validateField(this.east, false);
    validateField(this.north, false);
    validateField(this.use, false);
    validateField(this.band, false);
    validateField(this.up.getTextField(), false);
    validateField(this.down.getTextField(), false);
    validateField(this.left.getTextField(), false);
    validateField(this.right.getTextField(), false);
    validateField(this.heightIncrease, false);
    validateField(this.heightDecrease, false);
    if (this.east.getStyleClass().contains("error") || this.north
      .getStyleClass().contains("error") || this.use
      .getStyleClass().contains("error") || this.band
      .getStyleClass().contains("error") || this.up
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
    Correcciones correcciones;
    try {
      correcciones = Correcciones.getSingletonInstance();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    } 
    correcciones.observadorUTM.setBanda((String)((SimpleComboBoxItem)this.band.getSelectionModel().getSelectedItem()).getData());
    correcciones.observadorUTM.setHuso(Double.parseDouble((String)((SimpleComboBoxItem)this.use.getSelectionModel().getSelectedItem()).getData()));
    correcciones.observadorUTM.setDeltaNorte(Double.parseDouble(this.north.getText()));
    correcciones.observadorUTM.setDeltaEste(Double.parseDouble(this.east.getText()));
    try {
      correcciones.correccion(
          Double.parseDouble(this.up.getText()), 
          Double.parseDouble(this.down.getText()), 
          Double.parseDouble(this.left.getText()), 
          Double.parseDouble(this.right.getText()), 
          Double.parseDouble(this.heightIncrease.getText()), 
          Double.parseDouble(this.heightDecrease.getText()));
      AppConfig.getInstance().setObserver(correcciones.observador);
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
      Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      System.out.println("Se actualizo las coordenadas polares");
    } catch (IOException e1) {
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
      Main.getAppController().setInfoMessage("Error al guardar el blanco", "ERROR");
      System.out.println("PrincipalSimulada.actionPerformed");
      System.out.println("No se actualizo en coordenadas la coordenada");
      e1.printStackTrace();
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interface\\utm\Corrections.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */