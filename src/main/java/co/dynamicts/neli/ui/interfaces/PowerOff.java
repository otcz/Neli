package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PowerOff extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public PowerOff() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/power_off.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.cancel.setOnMouseClicked((event) -> {
      Main.getAppController().changeUI(MenuNavEnum.HOME);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro que desea apagar NELI?")) {
        Runtime r = Runtime.getRuntime();

        try {
          r.exec("shutdown -s -t 0 -f");
        } catch (IOException var3) {
          var3.printStackTrace();
        }

        Main.getAppController().setNoneDialog(StringUtil.translateKey("dialog.poweroff.header"), StringUtil.translateKey("dialog.poweroff.content"));
      }

    });
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\PowerOff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */