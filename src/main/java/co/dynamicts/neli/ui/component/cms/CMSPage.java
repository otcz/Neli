package co.dynamicts.neli.ui.component.cms;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CMSPage extends VBox implements BaseUserInterface {
  @FXML
  private PageTitle titleCMS;
  
  public CMSPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/cms/cms_page.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  public void initialize() {
    this.titleCMS.getTitleLabel().setText("Canon Management System");
    this.titleCMS.getTitleImage().setImage(new Image("/images/titles/canon3x.png"));
  }
  
  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\cms\CMSPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */