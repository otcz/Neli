package co.dynamicts.neli.ui.component.url;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ExternalURLSystemPage extends VBox implements BaseUserInterface {
  @FXML
  private PageTitle titleURL;
  
  @FXML
  public void initialize() {
    this.titleURL.getTitleLabel().setText("Sistema Externo URL");
    this.titleURL.getTitleImage().setImage(new Image("/images/componentes/home/iconos/compass3x.png"));
  }
  
  public ExternalURLSystemPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/sistemaURL/pagina_sistema_externoURL.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\componen\\url\ExternalURLSystemPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */