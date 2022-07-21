package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LabelTitle extends VBox {
  @FXML
  private Label titleLabelCMS;
  
  @FXML
  private Label measureLabelCMS;
  
  @FXML
  public void initialize() {}
  
  public LabelTitle() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/label_title.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Label getTitleLabelCMS() {
    return this.titleLabelCMS;
  }
  
  public void setTitleLabelCMS(Label titleLabelCMS) {
    this.titleLabelCMS = titleLabelCMS;
  }
  
  public void setTitleLabelCMS(String title) {
    getTitleLabelCMS().setText(title);
  }
  
  public Label getMeasureLabelCMS() {
    return this.measureLabelCMS;
  }
  
  public void setMeasureLabelCMS(Label measureLabelCMS) {
    this.measureLabelCMS = measureLabelCMS;
  }
  
  public void setMeasureLabelCMS(double measure) {
    getMeasureLabelCMS().setText(Double.toString(measure));
  }
  
  public void setMeasureLabelCMS(String measure) {
    getMeasureLabelCMS().setText(measure);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\LabelTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */