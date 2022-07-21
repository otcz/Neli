package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Success extends StackPane {
  @FXML
  private ButtonImage aceptar;
  
  @FXML
  private Button closeButton;
  
  @FXML
  private ImageView bullet;
  
  @FXML
  private Label ingresar;
  
  @FXML
  public void initialize() {
    this.aceptar.setLabel("Aceptar");
    this.closeButton.setOnAction(event -> setVisible(false));
    this.aceptar.setOnAction(event -> setVisible(false));
  }
  
  public ButtonImage getAceptar() {
    return this.aceptar;
  }
  
  public Button getCloseButton() {
    return this.closeButton;
  }
  
  public ImageView getBullet() {
    return this.bullet;
  }
  
  public Label getIngresar() {
    return this.ingresar;
  }
  
  private void setMessage(String text) {
    this.ingresar.setText(text);
  }
  
  private void setImage(String url) {
    this.bullet.setImage(new Image(url));
  }
  
  public void setComponents(String text, String imageURL) {
    setMessage(text);
    setImage(imageURL);
  }
  
  public Success() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/confirmar.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\Success.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */