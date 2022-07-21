package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.component.home.NoCylinderClock;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ReachClock extends VBox {
  @FXML
  private CustomClock customClock;
  
  @FXML
  private Pane clockPane;
  
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label valueLabel;
  
  @FXML
  private NoCylinderClock reachClockNoCylinder;
  
  public static final String CLOCK_TYPE_M = "meter";
  
  public static final String CLOCK_TYPE_KM = "kilometer";
  
  public ReachClock() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/reach_clock.fxml"));
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
    this.customClock = new CustomClock(60.0D, 128.0D, 200.0D, 32.0D, 2.0D);
    this.customClock.rotate(-90.0D);
    this.reachClockNoCylinder.getRegla().setImage(new Image("images/componentes/home/Reglas/alcance_metros1xlong.png"));
    this.clockPane.getChildren().add(this.customClock);
  }
  
  public void setClockType(String clockType) {
    if ("meter".equals(clockType)) {
      this.customClock.setMinValue(0.0D);
      this.customClock.setMaxValue(20000.0D);
      this.customClock.setEmptyAngle(0.2D);
      this.customClock.setCorrectionAngle(-180.0D);
      this.customClock.setDiffuseMap(new Image(getClass()
            .getResource("/images/range-m.png")
            .toExternalForm()));
      this.titleLabel.setText(StringUtil.translateKey("label.reach.meters"));
    } else if ("kilometer".equals(clockType)) {
      this.customClock.setMinValue(0.0D);
      this.customClock.setMaxValue(20.0D);
      this.customClock.setEmptyAngle(0.2D);
      this.customClock.setCorrectionAngle(-180.0D);
      this.customClock.setDiffuseMap(new Image(getClass()
            .getResource("/images/range-km.png")
            .toExternalForm()));
      this.titleLabel.setText(StringUtil.translateKey("label.reach.kilometers"));
    } 
  }
  
  public void setValue(String clockType, double value) {
    setValue(value);
    if ("meter".equals(clockType)) {
      int valueaux = 0;
      valueaux = (int)value;
      if (value <= this.customClock.getMaxValue() && value >= this.customClock.getMinValue()) {
        this.customClock.clockRotate(valueaux);
        this.valueLabel.setText("" + valueaux);
      } 
    } else if ("kilometer".equals(clockType) && 
      value <= this.customClock.getMaxValue() && value >= this.customClock.getMinValue()) {
      this.customClock.clockRotate(value);
      this.valueLabel.setText("" + value);
    } 
  }
  
  public void setValue(double value) {
    this.reachClockNoCylinder.setReach50(value);
    this.valueLabel.setText(Double.toString(value));
  }
  
  public Label getValueLabel() {
    return this.valueLabel;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ReachClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */