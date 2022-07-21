package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.component.home.HorizontalNoCylinderClock;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AzimuthClock extends VBox {
  @FXML
  private HorizontalNoCylinderClock azimutNoCylinder;
  
  @FXML
  private CustomClock customClock;
  
  @FXML
  private Pane clockPane;
  
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label valueLabel;
  
  @FXML
  private ImageView leftArrow;
  
  @FXML
  private ImageView rightArrow;
  
  public static final String CLOCK_TYPE_MILS = "mils";
  
  public static final String CLOCK_TYPE_DEGREES = "degrees";
  
  public static final String LEFT_ARROW = "LEFT_ARROW";
  
  public static final String RIGHT_ARROW = "RIGHT_ARROW";
  
  public AzimuthClock() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/azimuth_clock.fxml"));
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
    this.customClock = new CustomClock(320.0D, 60.0D, 300.0D, 32.0D, 1.8D);
    this.customClock.rotate(0.0D);
    this.clockPane.getChildren().add(this.customClock);
    this.titleLabel.setText("Orientación");
    setArrow(null);
  }
  
  public void setClockType(String clockType) {
    if ("mils".equals(clockType)) {
      this.customClock.setMinValue(0.0D);
      this.customClock.setMaxValue(6400.0D);
      this.customClock.setCorrectionAngle(-180.0D);
      this.customClock.setDiffuseMap(new Image(getClass()
            .getResource("/images/azimuth-thousandths.png")
            .toExternalForm()));
      this.titleLabel.setText(StringUtil.translateKey("label.azimuth.mils"));
    } else if ("degrees".equals(clockType)) {
      this.customClock.setMinValue(0.0D);
      this.customClock.setMaxValue(360.0D);
      this.customClock.setCorrectionAngle(-180.0D);
      this.customClock.setDiffuseMap(new Image(getClass()
            .getResource("/images/azimuth-degrees.png")
            .toExternalForm()));
      this.titleLabel.setText(StringUtil.translateKey("label.azimuth.degrees"));
    } 
  }
  
  public void setValue(double value) {
    this.azimutNoCylinder.setPunto(value);
    if (value <= this.customClock.getMaxValue() && value >= this.customClock.getMinValue()) {
      this.customClock.clockRotate(value);
      this.valueLabel.setText("" + value);
    } 
  }
  
  public void setArrow(String direccion) {
    if (direccion == null || direccion.isEmpty()) {
      this.leftArrow.setVisible(true);
      this.rightArrow.setVisible(true);
    } else if ("LEFT_ARROW".equals(direccion)) {
      this.leftArrow.setVisible(true);
      this.rightArrow.setVisible(false);
    } else if ("RIGHT_ARROW".equals(direccion)) {
      this.leftArrow.setVisible(false);
      this.rightArrow.setVisible(true);
    } else {
      this.leftArrow.setVisible(false);
      this.rightArrow.setVisible(false);
    } 
  }
  
  public Label getValueLabel() {
    return this.valueLabel;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\AzimuthClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */