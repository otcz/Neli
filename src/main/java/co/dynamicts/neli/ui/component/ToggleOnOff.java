package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ToggleOnOff extends VBox {
  @FXML
  private Label title;
  
  @FXML
  private Toggle toggle;
  
  private final ToggleGroup group = new ToggleGroup();
  
  public ToggleOnOff() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/toggle_on_off.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {
    this.toggle.setToggleGroup(this.group);
  }
  
  public void setText(String text) {
    this.title.setText(text);
  }
  
  public String getText() {
    return this.title.getText();
  }
  
  public ToggleGroup getToggleGroup() {
    return this.group;
  }
  
  public ReadOnlyObjectProperty<Toggle> getToggleProperty() {
    return this.group.selectedToggleProperty();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ToggleOnOff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */