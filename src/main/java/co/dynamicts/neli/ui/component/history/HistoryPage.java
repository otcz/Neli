package co.dynamicts.neli.ui.component.history;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HistoryPage extends VBox implements BaseUserInterface {
  @FXML
  private PageTitle titleHistorial;
  
  @FXML
  public void initialize() {
    this.titleHistorial.getTitleLabel().setText("Radar de Velocidad en Boca");
    this.titleHistorial.getTitleImage().setImage(new Image("/images/componentes/home/iconos/ca-on-vel-activo3x.png"));
  }
  
  public HistoryPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/historial/pagina_historial.fxml"));
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


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\history\HistoryPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */