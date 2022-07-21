package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;

import java.io.IOException;

public class LatLngTextField extends HBox {
  @FXML
  private TextField textField;
  
  @FXML
  private SVGPath svgPath;
  
  public LatLngTextField() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/latlang_textfield.fxml"));
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
    this.textField.getProperties().put("vkType", "numeric");
  }
  
  public void setText(String text) {
    this.textField.setText(text);
  }
  
  public String getText() {
    return this.textField.getText();
  }
  
  public String getIconContent() {
    return this.svgPath.getContent();
  }
  
  public void setIconContent(String iconContent) {
    this.svgPath.setContent(iconContent);
    this.svgPath.setScaleX(0.25D);
    this.svgPath.setScaleY(0.25D);
  }
  
  public TextField getTextField() {
    return this.textField;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\LatLngTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */