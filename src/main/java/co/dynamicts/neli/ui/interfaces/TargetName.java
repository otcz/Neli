package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.local.model.Point;
import co.dynamicts.neli.core.local.service.PointService;
import co.dynamicts.neli.core.models.Boletin;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class TargetName extends VBox implements BaseUserInterface, Initializable {
  private static TargetName targetName;
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  Ins ins = Ins.getSingletonInstance();
  @FXML
  private TextField name;
  @FXML
  private Button cancel;
  @FXML
  private Button save;

  public TargetName() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/target_name.fxml"), AppConfig.getInstance().getResouce());
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
    this.name.getProperties().put("vkType", "numeric");
    this.name.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.name, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.TARGET_LIST);
    });
    this.save.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.clearForm();
    if (AppConfig.getInstance().getPoint() != null) {
    }

  }

  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (field == this.name && !newValue && !textField.getText().matches(MeasureExpression.NAME_RECORD)) {
      textField.getStyleClass().add("error");
    }

  }

  private void clearForm() {
    this.name.setText("");
  }

  private boolean validateForm() {
    this.validateField(this.name, false);
    return !this.name.getStyleClass().contains("error");
  }

  public void addOrUpdateTarget(String nameTarget) {
    Point blancoDeseado = new Point();
    blancoDeseado.setName(nameTarget);
    blancoDeseado.setObusLatitude(this.ins.obus.getLatitud());
    blancoDeseado.setObusLongitude(this.ins.obus.getLongitud());
    blancoDeseado.setObusHeight(this.ins.obus.getAltura());
    blancoDeseado.setTargetLatitude(this.datosCalculados.blancoDeseadoGeo.getLatitud());
    blancoDeseado.setTargetLongitude(this.datosCalculados.blancoDeseadoGeo.getLongitud());
    blancoDeseado.setTargetHeight(this.datosCalculados.blancoDeseadoGeo.getAltura());
    blancoDeseado.setDistance(this.datosCalculados.posicionDeseadaMetros.getDistancia());
    blancoDeseado.setAzimuth(this.datosCalculados.posicionDeseadaMetros.getAzimut());
    blancoDeseado.setInterval(this.datosCalculados.posicionDeseadaMetros.getIntervalo());
    if (Boletin.getSingletonInstance().getArea() == 1) {
      blancoDeseado.setActive(true);
    } else {
      blancoDeseado.setActive(false);
    }

    blancoDeseado.setDate(new Date());

    try {
      PointService pointService = new PointService();
      pointService.createTableIfNotExists(Point.class);
      pointService.createOrUpdate(blancoDeseado);
    } catch (ClassNotFoundException | SQLException var5) {
      var5.printStackTrace();
    }

  }

  private void formSubmit() {
    if (!this.name.getText().equals("")) {
      try {
        new Point();
        PointService pointService = new PointService();
        pointService.createTableIfNotExists(Point.class);
        Point blancoDeseadoExiste = (Point)pointService.getById(Point.class, this.name.getText());
        if (blancoDeseadoExiste == null) {
          if (this.datosCalculados.blancoDeseadoGeo.getLongitud() == 0.0 && this.datosCalculados.blancoDeseadoGeo.getLatitud() == 0.0) {
            Platform.runLater(() -> {
              Main.getAppController().setInfoDialog("Error", "No se puede crear el blanco " + this.name.getText() + "\nYa que no se han cargado datos al sistema", "ERROR");
              Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.TARGET_LIST);
            });
          } else {
            this.addOrUpdateTarget(this.name.getText());
            Platform.runLater(() -> {
              Main.getAppController().setInfoDialog("Blanco Creado", "El blanco " + this.name.getText() + " se creo con éxito", "INFO");
              Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.TARGET_LIST);
            });
          }
        } else {
          Platform.runLater(() -> {
            Main.getAppController().setInfoDialog("Error Blanco", "El blanco " + this.name.getText() + " ya existe", "ERROR");
            Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.TARGET_LIST);
          });
        }
      } catch (SQLException var3) {
        var3.printStackTrace();
      } catch (ClassNotFoundException var4) {
        var4.printStackTrace();
      }
    }

  }

  public static TargetName getSingletonInstance() throws IOException {
    if (targetName == null) {
      targetName = new TargetName();
    }

    return targetName;
  }
}