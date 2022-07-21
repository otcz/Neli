package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;

import java.io.IOException;

public class IconDataViewer extends HBox {
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label subtitleLabel;
  
  @FXML
  private Label valueLabel;
  
  @FXML
  private SVGPath svgPath;
  
  public IconDataViewer() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/icon_data_viewer.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {}
  
  public StringProperty titleProperty() {
    return this.titleLabel.textProperty();
  }
  
  public StringProperty subtitleProperty() {
    return this.subtitleLabel.textProperty();
  }
  
  public StringProperty valueProperty() {
    return this.valueLabel.textProperty();
  }
  
  public StringProperty svgIconProperty() {
    return this.svgPath.contentProperty();
  }
  
  public String getTitle() {
    return titleProperty().get();
  }
  
  public void setTitle(String title) {
    titleProperty().set(title);
  }
  
  public String getSubtitle() {
    return subtitleProperty().get();
  }
  
  public void setSubtitle(String subtitle) {
    subtitleProperty().set(subtitle);
  }
  
  public String getValue() {
    return valueProperty().get();
  }
  
  public void setValue(String value) {
    valueProperty().set(value);
  }
  
  public String getSvgIcon() {
    return svgIconProperty().get();
  }
  
  public void setSvgIcon(String icon) {
    svgIconProperty().set(icon);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\IconDataViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */