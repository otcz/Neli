package co.dynamicts.neli.ui.interfaces.utm;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Magnetic extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField eastNorth;
  
  @FXML
  private TextField northNorth;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> useNorth;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> bandNorth;
  
  @FXML
  private TextField declinationNorth;
  
  @FXML
  private TextField eastSouth;
  
  @FXML
  private TextField northSouth;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> useSouth;
  
  @FXML
  private ComboBox<SimpleComboBoxItem> bandSouth;
  
  @FXML
  private TextField declinationSouth;
  
  @FXML
  private TextField declination;
  
  @FXML
  private Button accept;
  
  @FXML
  private Button cancel;
  
  public Magnetic() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/utm/config_magnetic.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(false);
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    updateComponents();
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
        public String toString(SimpleComboBoxItem object) {
          return object.getText();
        }
        
        public SimpleComboBoxItem fromString(String string) {
          return new SimpleComboBoxItem(string, null);
        }
      };
    this.bandNorth.setConverter(stringConverter);
    this.bandSouth.setConverter(stringConverter);
    for (int bandIterator = 1; bandIterator <= 60; bandIterator++)
      this.bandNorth.getItems().add(new SimpleComboBoxItem("" + bandIterator, null)); 
    this.bandSouth.getItems().setAll(this.bandNorth.getItems());
    this.useNorth.setConverter(stringConverter);
    this.useSouth.setConverter(stringConverter);
    String uses = "CDEFGHJKLMNPQRSTUVWX";
    for (int userIterator = 0; userIterator < uses.length(); userIterator++)
      this.useNorth.getItems().add(new SimpleComboBoxItem(uses.substring(userIterator, userIterator + 1), null)); 
    this.useSouth.getItems().setAll(this.useNorth.getItems());
    this.cancel.setOnMouseClicked(event -> clearForm());
    this.accept.setOnMouseClicked(event -> {
          if (validateForm())
            formSubmit(); 
        });
    Main.getAppController().topMenu().setVisible(false);
  }
  
  private void clearForm() {}
  
  private boolean validateForm() {
    return true;
  }
  
  private void formSubmit() {}
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interface\\utm\Magnetic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */