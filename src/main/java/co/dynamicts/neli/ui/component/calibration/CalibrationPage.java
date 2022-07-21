package co.dynamicts.neli.ui.component.calibration;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.component.common.PageTitle;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CalibrationPage extends VBox implements BaseUserInterface {
  @FXML
  private CalibrationComponent contenidoCalibracion;
  
  @FXML
  private PageTitle titleCalibracion;
  
  @FXML
  public void initialize() {
    this.titleCalibracion.getTitleLabel().setText("Calibración de Puntería");
    this.titleCalibracion.getTitleImage().setImage(new Image("/images/titles/calibracion3x.png"));
  }
  
  public CalibrationPage() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/calibration/calibration_page.fxml"));
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
    this.contenidoCalibracion.updateStatus();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\calibration\CalibrationPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */