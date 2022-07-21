package co.dynamicts.neli.ui.component.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PageTitle extends HBox {
  @FXML
  private ImageView titleImage;
  
  @FXML
  private Label titleLabel;
  
  @FXML
  public void initialize() {}
  
  public PageTitle() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/page_title.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public ImageView getTitleImage() {
    return this.titleImage;
  }
  
  public void setTitleImage(ImageView titleImage) {
    this.titleImage = titleImage;
  }
  
  public Label getTitleLabel() {
    return this.titleLabel;
  }
  
  public void setTitleLabel(Label titleLabel) {
    this.titleLabel = titleLabel;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\PageTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */