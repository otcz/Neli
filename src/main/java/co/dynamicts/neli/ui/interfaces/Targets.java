package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.Sistema;
import co.dynamicts.neli.core.interfaces.IngresoCoordenadas;
import co.dynamicts.neli.core.local.model.Point;
import co.dynamicts.neli.core.local.service.PointService;
import co.dynamicts.neli.core.utilities.ConversorCoordenadas;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Targets extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TableView<Point> targetTable;
  @FXML
  private Button upload;
  @FXML
  private Button add;
  @FXML
  private Button edit;
  @FXML
  private Button delete;
  ArrayList<Point> points = new ArrayList();

  public Targets() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/targets.fxml"), AppConfig.getInstance().getResouce());
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
    this.upload.setOnMouseClicked((event) -> {
      TableView.TableViewSelectionModel model = this.targetTable.getSelectionModel();
      Object selectedItem = model.getSelectedItem();
      if (selectedItem != null) {
        if (selectedItem instanceof Point) {
          Point point = (Point)selectedItem;
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de cargar el blanco " + point.getName() + " ?")) {
            IngresoCoordenadas ingresoCoordenadas;
            try {
              ingresoCoordenadas = IngresoCoordenadas.getSingletonInstance();
            } catch (IOException var9) {
              System.out.println("No pudo iniciar la clase IngresoCoordenadas");
              var9.printStackTrace();
              return;
            }

            ingresoCoordenadas.blancoDeseadoGeograficas.setLongitud(point.getTargetLongitude(), true);
            ingresoCoordenadas.blancoDeseadoGeograficas.setLatitud(point.getTargetLatitude(), true);
            ingresoCoordenadas.blancoDeseadoGeograficas.setAltura(point.getTargetHeight());
            PuntoUTM puntoUTM = ConversorCoordenadas.convertirGeo_a_UTM(ingresoCoordenadas.blancoDeseadoGeograficas, "WGS84");
            ingresoCoordenadas.blancoDeseadoUTM = puntoUTM;

            try {
              ingresoCoordenadas.setBlancoDeseado();
              if (DatosCalculados.getSingletonInstance().isPosible()) {
                Platform.runLater(() -> {
                  Main.getAppController().setInfoDialog("Blanco Cargado", "El blanco se cargó con éxito", "INFO");
                });
                Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
              } else {
                Platform.runLater(() -> {
                  Main.getAppController().setInfoDialog("Blanco Cargado", "Blanco Fuera de Alcance", "ERROR");
                });
                Main.getAppController().setInfoMessage("Blanco fuera de Alcance", "ERROR");
              }
            } catch (IOException var8) {
              var8.printStackTrace();
            }

            Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
          }
        }
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "No se ha selecionado ningun blanco de la tabla", "ERROR");
        });
      }

    });
    this.add.setOnMouseClicked((event) -> {
      Main.getAppController().changeUIWithOutMenu(MenuNavEnum.TARGET_LIST, "TARGET_NAME", false);
    });
    this.edit.setOnMouseClicked((event) -> {
      TableView.TableViewSelectionModel model = this.targetTable.getSelectionModel();
      Object selectedItem = model.getSelectedItem();
      if (selectedItem != null) {
        if (selectedItem instanceof Point) {
          Point point = (Point)selectedItem;
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de modificar el blanco " + point.getName() + " ?")) {
            AppConfig.getInstance().setPoint(point);
            Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.COORDINATES);
          }
        }
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "No se ha selecionado ningun blanco de la tabla", "ERROR");
        });
      }

    });
    this.delete.setOnMouseClicked((event) -> {
      TableView.TableViewSelectionModel model = this.targetTable.getSelectionModel();
      Object selectedItem = model.getSelectedItem();
      if (selectedItem != null) {
        if (selectedItem instanceof Point) {
          Point point = (Point)selectedItem;
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de borrar el blanco " + point.getName() + " ?")) {
            PointService pointService = null;

            try {
              pointService = new PointService();
              pointService.createTableIfNotExists(Point.class);
              pointService.deleteById(Point.class, point.getName());
              Platform.runLater(() -> {
                Main.getAppController().setInfoDialog("Blanco Borrado", "El blanco se borró con éxito", "INFO");
              });
              Main.getAppController().setInfoMessage("Blanco eliminado con exito", "INFO");
              this.loadTargets();
            } catch (ClassNotFoundException | SQLException var7) {
              var7.printStackTrace();
              Main.getAppController().setInfoMessage("Error al eliminar Blanco", "ERROR");
            }

            Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
          }
        }
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "No se ha selecionado ningun blanco de la tabla", "ERROR");
        });
      }

    });
    this.targetTable.setOnMouseClicked((event) -> {
      Point point = (Point)this.targetTable.getSelectionModel().getSelectedItem();
      if (point != null) {
      }

    });
    this.loadTargets();
    PseudoClass higlighted = PseudoClass.getPseudoClass("highlighted");
    this.targetTable.setRowFactory((tableView) -> {
      TableRow<Point> row = new TableRow();
      row.itemProperty().addListener((obs, oldPoint, newPoint) -> {
        row.pseudoClassStateChanged(higlighted, this.validateRow(newPoint));
      });
      return row;
    });
  }

  private void loadTargets() {
    try {
      PointService pointService = new PointService();
      pointService.createTableIfNotExists(Point.class);
      this.points = (ArrayList)pointService.getList(Point.class);
      this.targetTable.getItems().remove(0, this.targetTable.getItems().size());
      this.targetTable.getItems().addAll(this.points);
      this.targetTable.refresh();
    } catch (ClassNotFoundException | SQLException var2) {
      var2.printStackTrace();
    }

  }

  private boolean validateRow(Point point) {
    if (point != null) {
      if (Configuracion.getSingletonInstance().getSistema().equals(Sistema.OBUS_155)) {
        return point.getDistance() > 40000.0;
      } else {
        return point.getDistance() > 16000.0;
      }
    } else {
      return false;
    }
  }
}