package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Confirm extends StackPane {
  @FXML
  private ImageView alertaImage;
  
  @FXML
  private ImageView close;
  
  @FXML
  private Label seguro;
  
  @FXML
  private ButtonImage disparar;
  
  @FXML
  private ButtonImage cancelar;
  
  @FXML
  private Button closeButton;
  
  @FXML
  private AnchorPane efectPane;
  
  public Confirm() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/confirm_shot.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  public void initialize() {
    setTitles();
    this.cancelar.setOnAction(event -> setVisible(false));
    this.disparar.setOnAction(event -> setVisible(false));
    this.closeButton.setOnAction(event -> setVisible(false));
  }
  
  public void setConfirm(String imageURL, String confirmText, String aceptar) {
    this.alertaImage.setImage(new Image(imageURL));
    this.seguro.setText(confirmText);
    this.disparar.setLabel(aceptar);
  }
  
  private void setTitles() {
    this.seguro.setText("Seguro de realizar esta acción?");
    this.cancelar.setLabel("Cancelar");
    this.disparar.setLabel("aceptar");
  }
  
  public ButtonImage getDisparar() {
    return this.disparar;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\Confirm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */