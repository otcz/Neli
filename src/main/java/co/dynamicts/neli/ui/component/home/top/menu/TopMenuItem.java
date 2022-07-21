package co.dynamicts.neli.ui.component.home.top.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import java.io.IOException;

public class TopMenuItem extends HBox {
  @FXML
  private SVGPath icon;
  
  @FXML
  private String iconPath;
  
  @FXML
  private Region iconRegion;
  
  @FXML
  private String label;
  
  @FXML
  private Text text;
  
  @FXML
  Text value;
  
  public SVGPath getIcon() {
    return this.icon;
  }
  
  public void setIcon(SVGPath icon) {
    this.icon = icon;
  }
  
  public String getIconPath() {
    return this.iconPath;
  }
  
  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
    this.icon.setContent(iconPath);
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public void setLabel(String label) {
    this.text.setText(label);
    this.label = label;
  }
  
  public Text getText() {
    return this.text;
  }
  
  public void setText(Text text) {
    this.text = text;
  }
  
  public Region getIconRegion() {
    return this.iconRegion;
  }
  
  public void setIconRegion(Region iconRegion) {
    this.iconRegion = iconRegion;
  }
  
  public TopMenuItem() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/top_menu/item.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Text getValue() {
    return this.value;
  }
  
  public void setValue(Text value) {
    this.value = value;
  }
  
  public void setValue(String value) {
    this.value.setText(value);
  }
  
  @FXML
  private void initialize() {}
  
  public void setStatus(ItemStatus itemStatus) {
    this.iconRegion.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.iconRegion.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.iconRegion.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
    this.iconRegion.getStyleClass().add(itemStatus.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
    this.value.getStyleClass().add(itemStatus.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
    this.text.getStyleClass().add(itemStatus.toString().toLowerCase());
  }
  
  public void setTwoOptionStatus(ItemStatus itemStatus) {
    this.iconRegion.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.iconRegion.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.iconRegion.getStyleClass().add(itemStatus.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.value.getStyleClass().add(itemStatus.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.BAD.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.OK.toString().toLowerCase());
    this.text.getStyleClass().add(itemStatus.toString().toLowerCase());
    this.value.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
    this.iconRegion.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
    this.text.getStyleClass().remove(ItemStatus.MEDIUM.toString().toLowerCase());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\top\menu\TopMenuItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */