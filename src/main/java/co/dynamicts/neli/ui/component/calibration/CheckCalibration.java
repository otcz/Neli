package co.dynamicts.neli.ui.component.calibration;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class CheckCalibration extends HBox {
  @FXML
  private Label checkLabel;
  
  @FXML
  private Circle checkMinicircle;
  
  private boolean isSelected;
  
  @FXML
  public void initialize() {
    if (this.isSelected) {
      this.checkMinicircle.setVisible(true);
      getStylesheets().clear();
      getStylesheets().add(getClass().getResource("/css/interfaces/calibracion/style_check_calibracion_verde.css").toExternalForm());
    } else {
      this.checkMinicircle.setVisible(false);
      getStylesheets().clear();
      getStylesheets().add(getClass().getResource("/css/interfaces/calibracion/style_check_calibracion.css").toExternalForm());
    } 
  }
  
  public void check(boolean check) {
    this.isSelected = check;
    if (this.isSelected) {
      this.checkMinicircle.setVisible(true);
      getStylesheets().clear();
      getStylesheets().add(getClass().getResource("/css/interfaces/calibracion/style_check_calibracion_verde.css").toExternalForm());
    } else {
      this.checkMinicircle.setVisible(false);
      getStylesheets().clear();
      getStylesheets().add(getClass().getResource("/css/interfaces/calibracion/style_check_calibracion.css").toExternalForm());
    } 
  }
  
  public void check() {
    check(true);
  }
  
  public void uncheck() {
    check(false);
  }
  
  public CheckCalibration() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/calibration/check_calibration.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Label getCheckLabel() {
    return this.checkLabel;
  }
  
  public void setCheckLabel(Label checkLabel) {
    this.checkLabel = checkLabel;
  }
  
  public void setCheckLabel(String title) {
    getCheckLabel().setText(title);
  }
  
  public Circle getCheckMinicircle() {
    return this.checkMinicircle;
  }
  
  public void setCheckMinicircle(Circle checkMinicircle) {
    this.checkMinicircle = checkMinicircle;
  }
  
  public boolean isSelected() {
    return this.isSelected;
  }
  
  public void setSelected(boolean selected) {
    this.isSelected = selected;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\calibration\CheckCalibration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */