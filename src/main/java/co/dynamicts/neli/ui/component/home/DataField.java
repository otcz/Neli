package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class DataField extends Pane {
  @FXML
  private Text measure;
  
  @FXML
  private Text title;
  
  @FXML
  private Text subtitle;
  
  @FXML
  private String measureText;
  
  @FXML
  private String titleText;
  
  @FXML
  private String subtitleText;
  
  public DataField() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/data_field.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Text getMeasure() {
    return this.measure;
  }
  
  public void setMeasure(Text measure) {
    this.measure = measure;
  }
  
  public void setText(String text) {
    this.measure.setText(text);
  }
  
  public Text getTitle() {
    return this.title;
  }
  
  public void setTitle(Text title) {
    this.title = title;
  }
  
  public Text getSubtitle() {
    return this.subtitle;
  }
  
  public void setSubtitle(Text subtitle) {
    this.subtitle = subtitle;
  }
  
  public String getMeasureText() {
    return this.measureText;
  }
  
  public void setMeasureText(String measureText) {
    this.measureText = measureText;
    this.measure.setText(this.measureText);
  }
  
  public String getTitleText() {
    return this.titleText;
  }
  
  public void setTitleText(String titleText) {
    this.titleText = titleText;
    this.title.setText(this.titleText);
  }
  
  public String getSubtitleText() {
    return this.subtitleText;
  }
  
  public void setSubtitleText(String subtitleText) {
    this.subtitleText = subtitleText;
    this.subtitle.setText(this.subtitleText);
  }
  
  @FXML
  public void initialize() {}
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\DataField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */