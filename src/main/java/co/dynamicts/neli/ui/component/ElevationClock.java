package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.component.home.NoCylinderClock;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ElevationClock extends VBox {
  @FXML
  private NoCylinderClock elevationNoCylinder;
  
  @FXML
  private Pane clockPane;
  
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label valueLabel;
  
  @FXML
  private ImageView upArrow;
  
  @FXML
  private ImageView downArrow;
  
  @FXML
  public Label maxLabel;
  
  @FXML
  public Label minLabel;
  
  public static final String CLOCK_TYPE_MILS = "mils";
  
  public static final String CLOCK_TYPE_DEGREES = "degrees";
  
  public static final String UP_ARROW = "UP_ARROW";
  
  public static final String DOWN_ARROW = "DOWN_ARROW";
  
  public ElevationClock() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/elevation_clock.fxml"));
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
    this.elevationNoCylinder.getRegla().setImage(new Image("images/componentes/home/Reglas/elevacion_milesimas1xlog.png"));
  }
  
  public void setClockType(String clockType) {
    if ("mils".equals(clockType)) {
      this.titleLabel.setText(StringUtil.translateKey("label.elevation.mils"));
    } else if ("degrees".equals(clockType)) {
      this.titleLabel.setText(StringUtil.translateKey("label.elevation.degrees"));
    } 
    setArrow(null);
  }
  
  public void setValue(double value) {
    this.elevationNoCylinder.setPuntoElevacion(value);
    this.valueLabel.setText("" + value);
  }
  
  public void setArrow(String direccion) {
    if (direccion == null || direccion.isEmpty()) {
      this.upArrow.setVisible(true);
      this.downArrow.setVisible(true);
    } else if ("UP_ARROW".equals(direccion)) {
      this.upArrow.setVisible(true);
      this.downArrow.setVisible(false);
    } else if ("DOWN_ARROW".equals(direccion)) {
      this.upArrow.setVisible(false);
      this.downArrow.setVisible(true);
    } else {
      this.upArrow.setVisible(false);
      this.downArrow.setVisible(false);
    } 
  }
  
  public StringProperty maxProperty() {
    return this.maxLabel.textProperty();
  }
  
  public StringProperty minProperty() {
    return this.minLabel.textProperty();
  }
  
  public String getMax() {
    return maxProperty().get();
  }
  
  public void setMax(String text) {
    maxProperty().set(text);
  }
  
  public String getMin() {
    return minProperty().get();
  }
  
  public void setMin(String text) {
    minProperty().set(text);
  }
  
  public Label getValueLabel() {
    return this.valueLabel;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ElevationClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */