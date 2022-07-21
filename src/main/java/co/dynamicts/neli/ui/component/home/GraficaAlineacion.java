package co.dynamicts.neli.ui.component.home;

import co.dynamicts.neli.ui.component.home.state.GraficaAlineacionState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GraficaAlineacion extends VBox {
  @FXML
  private TargetAlineacion target;
  
  @FXML
  private DianaAlineacion diana;
  
  @FXML
  private ImageView verticalInd;
  
  @FXML
  private ImageView horizontalInd;
  
  public GraficaAlineacion() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/aligment_graph.fxml"));
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
    GraficaAlineacionState graficaAlineacionState = GraficaAlineacionState.builder().withOkX(true).withOkY(false).withMedX(false).withMedY(false).withBadX(false).withBadY(false).withCoordinateX(3.5D).withCoordinateY(3.5D).build();
    updateStatus(graficaAlineacionState);
  }
  
  private void moveTarget(double x, double y) {
    double targetHeight = 2.0D;
    double targetWidth = 3.0D;
    double xCoord = 25.0D * 1.0D * x - targetWidth + 104.5D;
    double yCoord = 25.0D * -1.0D * y - targetHeight + 104.5D;
    this.target.setTranslateX(xCoord);
    this.target.setTranslateY(yCoord);
    moveInds();
    targetInside(x, y, 10.0D);
  }
  
  private void targetInside(double x, double y, double porcentaje) {
    double nuevoRadio = 4.0D + 4.0D * porcentaje / 100.0D;
    double distanciaAlOrigen = Math.sqrt(x * x + y * y);
    if (distanciaAlOrigen >= nuevoRadio) {
      this.target.setVisible(false);
      this.horizontalInd.setVisible(false);
      this.verticalInd.setVisible(false);
    } else {
      this.target.setVisible(true);
      this.horizontalInd.setVisible(true);
      this.verticalInd.setVisible(true);
    } 
  }
  
  private void moveInds() {
    this.horizontalInd.setTranslateX(this.target.getTranslateX() - 8.0D);
    this.verticalInd.setTranslateY(this.target.getTranslateY());
  }
  
  private void setTargetStatus(boolean isOkY, boolean isOkX, boolean isMedY, boolean isMedX, boolean isBadY, boolean isBadX) {
    if (isBadX || isBadY) {
      this.target.setBadStyle();
      this.diana.setGrayCircle();
    } else if (isOkX && isOkY) {
      this.target.setOkStyle();
      this.diana.setGreenCircle();
    } else if (isMedX || isMedY) {
      this.target.setMedStyle();
    } else {
      this.target.setDefStyle();
      this.diana.setGrayCircle();
    } 
  }
  
  public void updateStatus(GraficaAlineacionState state) {
    moveTarget(state.getCoordinateX(), state.getCoordinateY());
    setTargetStatus(state.isOkY(), state.isOkX(), state.isMedY(), state.isMedX(), state.isBadY(), state.isBadX());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\GraficaAlineacion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */