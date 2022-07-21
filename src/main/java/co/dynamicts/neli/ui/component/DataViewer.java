package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class DataViewer extends VBox {
  @FXML
  private Label titleLabel;
  
  @FXML
  private Text valueLabel;
  
  public DataViewer() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/data_viewer.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {}
  
  public void setStausValue(String styleClass) {
    this.valueLabel.getStyleClass().clear();
    this.valueLabel.getStyleClass().add(styleClass);
  }
  
  public Text getValueLabel() {
    return this.valueLabel;
  }
  
  public StringProperty titleProperty() {
    return this.titleLabel.textProperty();
  }
  
  public StringProperty valueProperty() {
    return this.valueLabel.textProperty();
  }
  
  public String getTitle() {
    return titleProperty().get();
  }
  
  public void setTitle(String title) {
    titleProperty().set(title);
  }
  
  public String getValue() {
    return valueProperty().get();
  }
  
  public void setValue(String value) {
    valueProperty().set(value);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\DataViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */