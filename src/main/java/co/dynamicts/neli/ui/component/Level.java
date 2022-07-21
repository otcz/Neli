package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Level extends VBox {
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label valueLabel;
  
  @FXML
  private Canvas canvas;
  
  private GraphicsContext graphicsContext;
  
  private Image level;
  
  private Image whitePill;
  
  private Image greenPill;
  
  private Image redPill;
  
  public static final String WHITE_PILL = "WHITE";
  
  public static final String GREEN_PILL = "GREEN";
  
  public static final String RED_PILL = "RED";
  
  private static final double MIN_RANGE = 10.0D;
  
  private static final double MAX_RANGE = 30.0D;
  
  public Level() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/level.fxml"));
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
    this.graphicsContext = this.canvas.getGraphicsContext2D();
    this.level = new Image(getClass().getResource("/images/level.png").toExternalForm());
    this.whitePill = new Image(getClass().getResource("/images/pill-white.png").toExternalForm());
    this.greenPill = new Image(getClass().getResource("/images/pill-green.png").toExternalForm());
    this.redPill = new Image(getClass().getResource("/images/pill-red.png").toExternalForm());
    setValue(0.0D);
  }
  
  public void setValue(double value) {
    if (value > -1000.0D && value < 1000.0D) {
      double position = 59.0D * value / 1000.0D + 59.0D;
      draw(position);
    } else {
      draw(0.0D);
    } 
    this.valueLabel.setText(String.valueOf(value));
  }
  
  private void draw(double position) {
    Image pill = this.redPill;
    if (position > 49.0D && position < 69.0D) {
      pill = this.greenPill;
    } else if (position > 29.0D && position < 89.0D) {
      pill = this.whitePill;
    } 
    this.graphicsContext.clearRect(0.0D, 0.0D, this.canvas.getWidth(), this.canvas.getHeight());
    this.graphicsContext.drawImage(pill, position, 3.0D, 22.0D, 16.0D);
    this.graphicsContext.drawImage(this.level, 0.0D, 0.0D, 140.0D, 22.0D);
  }
  
  public StringProperty titleProperty() {
    return this.titleLabel.textProperty();
  }
  
  public String getTitle() {
    return titleProperty().get();
  }
  
  public void setTitle(String title) {
    titleProperty().set(title);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\Level.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */