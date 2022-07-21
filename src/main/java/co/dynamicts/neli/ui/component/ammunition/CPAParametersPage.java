package co.dynamicts.neli.ui.component.ammunition;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.component.cpa.CPAParametersComponent;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CPAParametersPage extends VBox implements BaseUserInterface {
  @FXML
  private CPAParametersComponent parametersComponent;
  
  @FXML
  private PageTitle titleCPA;
  
  @FXML
  public void initialize() {
    this.titleCPA.getTitleLabel().setText("Parametros CPA");
    this.titleCPA.getTitleImage().setImage(new Image("/images/componentes/home/iconos/punteria-3-3x.png"));
  }
  
  public CPAParametersPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/cpa/pagina_parametrosCPA.fxml"));
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
    this.parametersComponent.updateStatus();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammunition\CPAParametersPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */