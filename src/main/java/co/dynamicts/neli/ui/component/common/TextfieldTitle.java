package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TextfieldTitle extends VBox {
  @FXML
  private Label titleLabelCMS;
  
  @FXML
  private TextField measureLabelCMS;
  
  @FXML
  public void initialize() {}
  
  public TextfieldTitle() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/textfield_title.fxml"));
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
    this.titleLabelCMS.setText(title);
  }
  
  public TextField getMeasureLabelCMS() {
    return this.measureLabelCMS;
  }
  
  public void setMeasureLabelCMS(TextField measureLabelCMS) {
    this.measureLabelCMS = measureLabelCMS;
  }
  
  public void setMeasureLabelCMS(String measure) {
    this.measureLabelCMS.setText(measure);
  }
  
  public void setTitleText(String titleText) {
    getTitleLabelCMS().setText(titleText);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\TextfieldTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */