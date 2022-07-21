package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ButtonImage extends Button {
  @FXML
  private ImageView imageViewButton;
  
  @FXML
  private Label imageButtonLabel;
  
  public ButtonImage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/button_image.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  public void initialize() {}
  
  public ImageView getImageViewButton() {
    return this.imageViewButton;
  }
  
  public void setImageViewButton(ImageView imageViewButton) {
    this.imageViewButton = imageViewButton;
  }
  
  public Label getImageButtonLabel() {
    return this.imageButtonLabel;
  }
  
  public void setImageButtonLabel(Label imageButtonLabel) {
    this.imageButtonLabel = imageButtonLabel;
  }
  
  public void setLabel(String text) {
    getImageButtonLabel().setText(text);
  }
  
  public void setImageButton(String url) {
    getImageViewButton().setImage(new Image(url));
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\ButtonImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */