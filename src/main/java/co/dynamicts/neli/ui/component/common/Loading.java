package co.dynamicts.neli.ui.component.common;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

import java.io.IOException;

public class Loading extends StackPane {
  @FXML
  private Arc yellowArc;
  
  @FXML
  private Arc yellowArc2;
  
  private RotateTransition rt;
  
  @FXML
  public void initialize() {
    rotate(this.yellowArc);
    this.yellowArc.setType(ArcType.OPEN);
    this.yellowArc2.setType(ArcType.OPEN);
  }
  
  public Loading() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/Loading.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void stop() {
    this.rt.stop();
  }
  
  public void startLoading() {
    this.rt.play();
  }
  
  public void rotate(Arc arc) {
    this.rt = new RotateTransition(Duration.millis(3000.0D), arc);
    this.rt.setFromAngle(0.0D);
    this.rt.setToAngle(360.0D);
    this.rt.setInterpolator(Interpolator.LINEAR);
    this.rt.setCycleCount(-1);
    this.rt.play();
  }
  
  public RotateTransition getRt() {
    return this.rt;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\Loading.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */