package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HorizontalNoCylinderClock extends AnchorPane {
  private double reglaWidth;
  
  @FXML
  private ImageView regla;
  
  private double punto;
  
  public HorizontalNoCylinderClock() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/horizontal_no_cylinder_clock.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  private void initialize() {
    this.punto = 2000.0D;
    this.reglaWidth = 6160.0D;
    setViewPort(this.punto);
    this.punto = 3000.0D;
    setViewPort(this.punto);
  }
  
  public void setViewPort(double punto) {
    double metrosPixel = this.reglaWidth / 6971.5D;
    double calcularX = metrosPixel * (punto + 571.5D);
    this.regla.setViewport(new Rectangle2D(calcularX - 405.0D, 0.0D, 800.0D, 100.0D));
  }
  
  public ImageView getRegla() {
    return this.regla;
  }
  
  public void setRegla(ImageView regla) {
    this.regla = regla;
  }
  
  public double getPunto() {
    return this.punto;
  }
  
  public void setPunto(double punto) {
    setViewPort(punto);
    this.punto = punto;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\HorizontalNoCylinderClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */