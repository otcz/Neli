package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NoCylinderClock extends AnchorPane {
  public static final int totalMetrosRegla = 27000;
  
  private double reglaWidth;
  
  @FXML
  private ImageView regla;
  
  private double punto;
  
  public NoCylinderClock() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/no_cylinder_clock.fxml"));
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
    this.punto = 4000.0D;
    this.reglaWidth = 2828.0D;
    setViewPort(this.punto);
  }
  
  public void setViewPort(double metros) {
    double metrosPixel = this.reglaWidth / 27000.0D;
    double calcularY = this.reglaWidth - metrosPixel * metros - 58.0D;
    this.regla.setViewport(new Rectangle2D(0.0D, calcularY, 64.0D, 116.0D));
  }
  
  public void setViewElevacion(double metros) {
    double metrosPixel = this.reglaWidth / 1625.5D;
    double metrosSuperior = metros + 100.0D;
    if (metros >= 0.0D) {
      double calcularY = this.reglaWidth - metrosPixel * metrosSuperior - 58.0D;
      this.regla.setViewport(new Rectangle2D(0.0D, calcularY, 64.0D, 116.0D));
    } else if (metros >= -100.0D) {
      double calcularY = this.reglaWidth - metrosPixel * (100.0D + metros) - 58.0D;
      this.regla.setViewport(new Rectangle2D(0.0D, calcularY, 64.0D, 116.0D));
    } else {
      double calcularY = this.reglaWidth - metrosPixel * (metrosSuperior - 100.0D) - 58.0D;
      this.regla.setViewport(new Rectangle2D(0.0D, calcularY, 64.0D, 116.0D));
    } 
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
    this.punto = punto;
    setViewPort(punto);
  }
  
  public void setReach50(double measure) {
    double maxValue = 50100.0D;
    double metrosPixel = 5626.0D / maxValue;
    double calcularY = (maxValue - measure) * metrosPixel - 58.0D;
    this.regla.setViewport(new Rectangle2D(0.0D, calcularY, 64.0D, 116.0D));
  }
  
  public void setPuntoElevacion(double punto) {
    this.punto = punto;
    setViewElevacion(punto);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\NoCylinderClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */