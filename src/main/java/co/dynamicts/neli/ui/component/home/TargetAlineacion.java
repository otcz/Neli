package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;

import java.io.IOException;

public class TargetAlineacion extends StackPane {
  @FXML
  private SVGPath bigTarget;
  
  @FXML
  private SVGPath statusTarget;
  
  @FXML
  public void initialize() {}
  
  public TargetAlineacion() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/target_alineacion.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void setOkStyle() {
    this.statusTarget.getStyleClass().clear();
    this.statusTarget.getStyleClass().add("targetOk");
  }
  
  public void setMedStyle() {
    this.statusTarget.getStyleClass().clear();
    this.statusTarget.getStyleClass().add("targetMed");
  }
  
  public void setBadStyle() {
    this.statusTarget.getStyleClass().clear();
    this.statusTarget.getStyleClass().add("targetBad");
  }
  
  public void setDefStyle() {
    this.statusTarget.getStyleClass().clear();
    this.statusTarget.getStyleClass().add("targetDefault");
  }
  
  public SVGPath getBigTarget() {
    return this.bigTarget;
  }
  
  public SVGPath getStatusTarget() {
    return this.statusTarget;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\TargetAlineacion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */