package co.dynamicts.neli.ui.component.common;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ToggleButton extends HBox {
  @FXML
  private Label label;
  
  @FXML
  private Label labelOn;
  
  @FXML
  private Label labelOff;
  
  @FXML
  private Button toggle;
  
  @FXML
  private ImageView toggleImage;
  
  @FXML
  private String labelText;
  
  @FXML
  private String textOn;
  
  @FXML
  private String textOff;
  
  private Boolean value = Boolean.valueOf(true);
  
  private EventHandler<ActionEvent> onOnHandler;
  
  private EventHandler<ActionEvent> onOffHandler;
  
  @FXML
  public void initialize() {
    this.toggle.setOnAction(event -> setValue(Boolean.valueOf(!this.value.booleanValue()), event));
  }
  
  public Label getLabel() {
    return this.label;
  }
  
  public void setLabel(Label label) {
    this.label = label;
  }
  
  public Label getLabelOn() {
    return this.labelOn;
  }
  
  public void setLabelOn(Label labelOn) {
    this.labelOn = labelOn;
  }
  
  public Button getToggle() {
    return this.toggle;
  }
  
  public void setToggle(Button toggle) {
    this.toggle = toggle;
  }
  
  public ImageView getToggleImage() {
    return this.toggleImage;
  }
  
  public void setToggleImage(ImageView toggleImage) {
    this.toggleImage = toggleImage;
  }
  
  public String getLabelText() {
    return this.labelText;
  }
  
  public void setLabelText(String labelText) {
    this.labelText = labelText;
    this.label.setText(labelText);
  }
  
  public String getTextOn() {
    return this.textOn;
  }
  
  public void setTextOn(String textOn) {
    this.textOn = textOn;
    this.labelOn.setText(textOn);
  }
  
  public String getTextOff() {
    return this.textOff;
  }
  
  public void setTextOff(String textOff) {
    this.textOff = textOff;
    this.labelOff.setText(textOff);
  }
  
  public void setValue(Boolean value) {
    setValue(value, null);
  }
  
  public void setValue(Boolean newValue, ActionEvent event) {
    if (newValue != null)
      if (newValue.booleanValue()) {
        this.labelOn.getStyleClass().clear();
        this.labelOn.getStyleClass().add("enabled");
        this.toggleImage.setLayoutX(-7.0D);
        this.labelOff.getStyleClass().clear();
        this.labelOff.getStyleClass().add("disabled");
        if (event != null)
          this.onOnHandler.handle(event); 
      } else {
        this.labelOn.getStyleClass().clear();
        this.labelOn.getStyleClass().add("disabled");
        this.toggleImage.setLayoutX(7.0D);
        this.labelOff.getStyleClass().clear();
        this.labelOff.getStyleClass().add("enabled");
        if (event != null)
          this.onOffHandler.handle(event); 
      }  
    this.value = newValue;
  }
  
  public ToggleButton() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/toggle_button.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Label getLabelOff() {
    return this.labelOff;
  }
  
  public void setLabelOff(Label labelOff) {
    this.labelOff = labelOff;
  }
  
  public final void setOnOn(EventHandler<ActionEvent> eventHandler) {
    this.onOnHandler = eventHandler;
  }
  
  public final void setOnOff(EventHandler<ActionEvent> eventHandler) {
    this.onOffHandler = eventHandler;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\ToggleButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */