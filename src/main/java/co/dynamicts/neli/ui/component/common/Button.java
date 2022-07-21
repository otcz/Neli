package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Button extends AnchorPane {
  @FXML
  ImageView buttonImage;
  
  @FXML
  Label buttonLabel;
  
  public Button() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/button.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void initialize() {}
  
  public void setImage(String URL) {
    this.buttonImage.setImage(new Image(URL));
  }
  
  public void setText(String text) {
    this.buttonLabel.setText(text);
  }
  
  public ImageView getButtonImage() {
    return this.buttonImage;
  }
  
  public void setButtonImage(ImageView buttonImage) {
    this.buttonImage = buttonImage;
  }
  
  public Label getButtonLabel() {
    return this.buttonLabel;
  }
  
  public void setButtonLabel(Label buttonLabel) {
    this.buttonLabel = buttonLabel;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */