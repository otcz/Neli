package co.dynamicts.neli.ui.component.ammunition;

import co.dynamicts.neli.ui.component.common.TextfieldTitle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class AddGunFuse extends HBox {
  @FXML
  private TextfieldTitle gunFuseName;
  
  @FXML
  private TextfieldTitle gunFuseWeight;
  
  @FXML
  private TextfieldTitle deflectionAcceleration;
  
  @FXML
  public void initialize() {
    setTitles();
  }
  
  public AddGunFuse() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/ammunition/add_gun_fuse.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  private void setTitles() {
    this.gunFuseName.setTitleText("Nombre Espoleta");
    this.gunFuseWeight.setTitleText("Peso Espoleta [Kg]");
    this.deflectionAcceleration.setTitleText("Aceleracion Deflexión [m/s2]");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammunition\AddGunFuse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */