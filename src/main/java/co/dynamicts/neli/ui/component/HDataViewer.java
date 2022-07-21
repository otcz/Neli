package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class HDataViewer extends HBox {
  @FXML
  private Label leftLabel;
  
  @FXML
  private Label rightLabel;
  
  public Label getLeftLabel() {
    return this.leftLabel;
  }
  
  public Label getRightLabel() {
    return this.rightLabel;
  }
  
  public HDataViewer() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/horizontal_data_viewer.fxml"));
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
  
  public void setStausValue(Label valueLabel, String styleClass) {
    valueLabel.getStyleClass().clear();
    valueLabel.getStyleClass().add(styleClass);
  }
  
  public StringProperty leftProperty() {
    return this.leftLabel.textProperty();
  }
  
  public StringProperty rightProperty() {
    return this.rightLabel.textProperty();
  }
  
  public String getLeft() {
    return leftProperty().get();
  }
  
  public void setLeft(String text) {
    leftProperty().set(text);
  }
  
  public String getRight() {
    return rightProperty().get();
  }
  
  public void setRight(String text) {
    rightProperty().set(text);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\HDataViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */