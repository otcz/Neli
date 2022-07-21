package co.dynamicts.neli.ui.component.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import java.io.IOException;

public class IconDataField extends Pane {
  private static final Double DEFAULT_ICON_SIZE = Double.valueOf(16.0D);
  
  @FXML
  private Text measure;
  
  @FXML
  private Text title;
  
  @FXML
  private Text subtitle;
  
  @FXML
  private SVGPath icon;
  
  @FXML
  private String iconPath;
  
  @FXML
  private Double iconWidth;
  
  @FXML
  private Double iconHeight;
  
  @FXML
  private Region iconRegion;
  
  @FXML
  private String measureText;
  
  @FXML
  private String titleText;
  
  @FXML
  private String subtitleText;
  
  public SVGPath getIcon() {
    return this.icon;
  }
  
  public void setIcon(SVGPath icon) {
    this.icon = icon;
  }
  
  public IconDataField() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/icon_data_field.fxml"));
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
  
  public String getIconPath() {
    return this.iconPath;
  }
  
  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
    this.icon.setContent(iconPath);
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
  
  public Double getIconWidth() {
    return this.iconWidth;
  }
  
  public void setIconWidth(Double iconWidth) {
    this.iconWidth = iconWidth;
    this.iconRegion.setPrefWidth(iconWidth.doubleValue());
    this.iconRegion.setMaxWidth(iconWidth.doubleValue());
    this.iconRegion.setMinWidth(iconWidth.doubleValue());
  }
  
  public Double getIconHeight() {
    return this.iconHeight;
  }
  
  public void setIconHeight(Double iconHeight) {
    this.iconHeight = iconHeight;
    this.iconRegion.setPrefHeight(iconHeight.doubleValue());
    this.iconRegion.setMaxHeight(iconHeight.doubleValue());
    this.iconRegion.setMinHeight(iconHeight.doubleValue());
  }
  
  public Region getIconRegion() {
    return this.iconRegion;
  }
  
  public void setIconRegion(Region iconRegion) {
    this.iconRegion = iconRegion;
  }
  
  @FXML
  public void initialize() {
    this.iconRegion.setPrefSize(DEFAULT_ICON_SIZE.doubleValue(), DEFAULT_ICON_SIZE.doubleValue());
    this.iconRegion.setMaxSize(DEFAULT_ICON_SIZE.doubleValue(), DEFAULT_ICON_SIZE.doubleValue());
    this.iconRegion.setMinSize(DEFAULT_ICON_SIZE.doubleValue(), DEFAULT_ICON_SIZE.doubleValue());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\IconDataField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */