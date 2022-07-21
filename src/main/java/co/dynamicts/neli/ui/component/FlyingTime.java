package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FlyingTime extends VBox {
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label valueLabel;
  
  public FlyingTime() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/flying_time.fxml"));
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
    this.valueLabel.setText("00:00.000");
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
  
  public void setValue(double value) {
    int flyingTime = (int)(value * 1000.0D);
    Date d = new Date(flyingTime);
    SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    this.valueLabel.setText(value + " s");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\FlyingTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */