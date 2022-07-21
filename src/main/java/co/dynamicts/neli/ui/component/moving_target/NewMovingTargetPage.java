package co.dynamicts.neli.ui.component.moving_target;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NewMovingTargetPage extends VBox implements BaseUserInterface {
  @FXML
  private PageTitle NOMtitle;
  
  @FXML
  public void initialize() {
    this.NOMtitle.getTitleLabel().setText("Nuevo Objetivo Movil");
    this.NOMtitle.getTitleImage().setImage(new Image("/images/componentes/home/iconos/punteria-movil3x.png"));
  }
  
  public NewMovingTargetPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/objetivoMovil/PaginaNuevoObjetivoMovil.fxml"));
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


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\moving_target\NewMovingTargetPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */