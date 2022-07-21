package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.local.model.RadarHistory;
import co.dynamicts.neli.core.utilities.Tools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RadarHystoryView extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private Button accept;
  @FXML
  private ImageView imageView;

  public RadarHystoryView() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/radarHistoryView.fxml"), AppConfig.getInstance().getResouce());
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
    this.accept.setOnMouseClicked((event) -> {
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.MUR);
    });
    if (AppConfig.getInstance().getRadarHistory() != null) {
      RadarHistory radarHistory = AppConfig.getInstance().getRadarHistory();
      File file = new File(Tools.getFolderRadar() + radarHistory.getDate() + ".png");
      Image images = new Image(file.toURI().toString());
      this.imageView.setImage(images);
      AppConfig.getInstance().setRadarHistory((RadarHistory)null);
    } else {
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.MUR);
    }

  }
}

/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\RadarHystoryView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */