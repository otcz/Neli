package co.dynamicts.neli.ui.interfaces.geo;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.LatLngTextField;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Magnetic extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private ToggleButton latitudeToggleNorth;
  
  @FXML
  private LatLngTextField latitudeDegreesNorth;
  
  @FXML
  private LatLngTextField latitudeMinutesNorth;
  
  @FXML
  private LatLngTextField latitudeSecondsNorth;
  
  @FXML
  private ToggleButton longitudeToggleNorth;
  
  @FXML
  private LatLngTextField longitudeDegreesNorth;
  
  @FXML
  private LatLngTextField longitudeMinutesNorth;
  
  @FXML
  private LatLngTextField longitudeSecondsNorth;
  
  @FXML
  private TextField declinationNorth;
  
  @FXML
  private ToggleButton latitudeToggleSouth;
  
  @FXML
  private LatLngTextField latitudeDegreesSouth;
  
  @FXML
  private LatLngTextField latitudeMinutesSouth;
  
  @FXML
  private LatLngTextField latitudeSecondsSouth;
  
  @FXML
  private ToggleButton longitudeToggleSouth;
  
  @FXML
  private LatLngTextField longitudeDegreesSouth;
  
  @FXML
  private LatLngTextField longitudeMinutesSouth;
  
  @FXML
  private LatLngTextField longitudeSecondsSouth;
  
  @FXML
  private TextField declinationSouth;
  
  @FXML
  private Button cancel;
  
  @FXML
  private Button accept;
  
  public Magnetic() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/geo/config_magnetic.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {
    this.declinationNorth.getProperties().put("vkType", "numeric");
    this.declinationSouth.getProperties().put("vkType", "numeric");
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    updateComponents();
    Main.getAppController().topMenu().setVisible(false);
    this.cancel.setOnMouseClicked(event -> clearForm());
    this.accept.setOnMouseClicked(event -> {
          if (validateForm())
            formSubmit(); 
        });
  }
  
  private void clearForm() {}
  
  private boolean validateForm() {
    return true;
  }
  
  private void formSubmit() {}
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\geo\Magnetic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */