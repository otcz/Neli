package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.local.model.RadarHistory;
import co.dynamicts.neli.core.local.service.RadarHistoryService;
import co.dynamicts.neli.core.utilities.Tools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Radar extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TableView<RadarHistory> radarTable;
  @FXML
  private Button image;
  @FXML
  private Button reset;
  @FXML
  private Button cancel;
  ArrayList<RadarHistory> radarHistory = new ArrayList();

  public Radar() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/radar.fxml"), AppConfig.getInstance().getResouce());
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
    this.reset.setOnMouseClicked((event) -> {
      if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de borrar el registro del radar de velocidad ?") && Main.getAppController().setPasswordDialog()) {
        RadarHistoryService radarHistoryService = null;

        try {
          radarHistoryService = new RadarHistoryService();
          radarHistoryService.createTableIfNotExists(RadarHistory.class);
          this.radarHistory = (ArrayList)radarHistoryService.getList(RadarHistory.class);

          for(int i = 0; i < this.radarHistory.size(); ++i) {
            radarHistoryService.deleteById(RadarHistory.class, ((RadarHistory)this.radarHistory.get(i)).getDate());
          }

          Tools.deleteDir(new File(Tools.getFolderRadar()));
          Platform.runLater(() -> {
            Main.getAppController().setInfoDialog("Registro Borrado", "El registro se borró con éxito", "INFO");
          });
          Main.getAppController().setInfoMessage("Registro eliminado con exito", "INFO");
          this.loadRadar();
        } catch (ClassNotFoundException | SQLException var4) {
          var4.printStackTrace();
          Main.getAppController().setInfoMessage("Error al eliminar Blanco", "ERROR");
        }

        Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
      }

    });
    this.cancel.setOnMouseClicked((event) -> {
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
    });
    this.radarTable.setOnMouseClicked((event) -> {
      RadarHistory radarHistory = (RadarHistory)this.radarTable.getSelectionModel().getSelectedItem();
      if (radarHistory != null) {
      }

    });
    this.image.setOnMouseClicked((event) -> {
      TableView.TableViewSelectionModel model = this.radarTable.getSelectionModel();
      Object selectedItem = model.getSelectedItem();
      if (selectedItem != null) {
        if (selectedItem instanceof RadarHistory) {
          RadarHistory radarHistory = (RadarHistory)selectedItem;
          AppConfig.getInstance().setRadarHistory(radarHistory);
          Main.getAppController().changeUIWithOutMenu(MenuNavEnum.MUR, "IMAGE", false);
        }
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "No se ha selecionado ningun registro de la tabla", "ERROR");
        });
      }

    });
    this.loadRadar();
  }

  private void loadRadar() {
    try {
      RadarHistoryService radarHistoryService = new RadarHistoryService();
      radarHistoryService.createTableIfNotExists(RadarHistory.class);
      this.radarHistory = (ArrayList)radarHistoryService.getList(RadarHistory.class);
      this.radarTable.getItems().remove(0, this.radarTable.getItems().size());
      this.radarTable.getItems().addAll(this.radarHistory);
      this.radarTable.refresh();
    } catch (ClassNotFoundException | SQLException var2) {
      var2.printStackTrace();
    }

  }
}