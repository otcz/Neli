package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class Obus extends StackPane {
  @FXML
  private ImageView compassImageView;
  
  private double minValue = 0.0D;
  
  private double maxValue = 6400.0D;
  
  private RotateTransition rotateTransition;
  
  public static final String OBUS_TYPE_MILS = "mils";
  
  public static final String OBUS_TYPE_DEGREES = "degrees";
  
  private String currentType = "mils";
  
  public Obus() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/obus.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {
    this.compassImageView.setRotationAxis(new Point3D(0.0D, 0.0D, 1.0D));
    setObusType("degrees");
    setValue(0.0D);
  }
  
  public void setObusType(String obusType) {
    if ("mils".equals(obusType)) {
      this.compassImageView.setImage(new Image(
            getClass()
            .getResource("/images/compass.png")
            .toExternalForm()));
      this.maxValue = 6400.0D;
      this.currentType = "mils";
    } else if ("degrees".equals(obusType)) {
      this.compassImageView.setImage(new Image(
            getClass()
            .getResource("/images/compass-degrees.png")
            .toExternalForm()));
      this.maxValue = 360.0D;
      this.currentType = "degrees";
    } 
  }
  
  public void setValue(double value) {
    if (value >= this.maxValue || value < 0.0D)
      return; 
    if ("mils".equals(this.currentType)) {
      value = 360.0D * value / -6400.0D + 30.0D;
    } else {
      value += 30.0D;
    } 
    if (this.rotateTransition == null)
      this.rotateTransition = new RotateTransition(Duration.millis(500.0D), this.compassImageView); 
    if (this.rotateTransition.getStatus() == Animation.Status.RUNNING)
      this.rotateTransition.stop(); 
    this.rotateTransition.setFromAngle(this.compassImageView.getRotate());
    this.rotateTransition.setToAngle(value);
    this.rotateTransition.play();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\Obus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */