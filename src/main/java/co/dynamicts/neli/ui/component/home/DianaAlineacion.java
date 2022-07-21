package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class DianaAlineacion extends StackPane {
  @FXML
  private Circle dianaCircle1;
  
  @FXML
  private Circle dianaCircle2;
  
  @FXML
  private Circle dianaCircle3;
  
  @FXML
  private Circle dianaCircle4;
  
  @FXML
  private Circle inCircle1;
  
  @FXML
  private Circle inCircle2;
  
  @FXML
  private Circle inCircle3;
  
  @FXML
  public void initialize() {
    this.dianaCircle1.getStrokeDashArray().addAll(new Double[] { Double.valueOf(2.5D), Double.valueOf(2.5D) });
    this.dianaCircle1.setStrokeWidth(0.5D);
    this.dianaCircle2.setStrokeWidth(0.7D);
    this.dianaCircle3.setStrokeWidth(0.7D);
    this.dianaCircle4.setStrokeWidth(0.7D);
    this.inCircle1.setStrokeWidth(0.7D);
    this.inCircle2.setStrokeWidth(0.7D);
    this.inCircle3.setStrokeWidth(0.7D);
  }
  
  public DianaAlineacion() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/aligment_target.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void setGrayCircle() {
    this.inCircle3.getStyleClass().clear();
    this.inCircle3.getStyleClass().add("grayCircle");
  }
  
  public void setGreenCircle() {
    this.inCircle3.getStyleClass().clear();
    this.inCircle3.getStyleClass().add("greenCircle");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\DianaAlineacion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */