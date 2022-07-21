package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Limites;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Limits extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField maxDistance;
  @FXML
  private TextField minDistance;
  @FXML
  private TextField rightLimit;
  @FXML
  private TextField leftLimit;
  @FXML
  private Label minFlush;
  @FXML
  private Label maxFlush;
  @FXML
  private Label minBigAngle;
  @FXML
  private Label maxBigAngle;
  @FXML
  private Label minOrientation;
  @FXML
  private Label maxOrientation;
  @FXML
  private Label maxDistanceUnits;
  @FXML
  private Label minDistanceUnits;
  @FXML
  private Label rightLimitUnits;
  @FXML
  private Label leftLimitUnits;
  @FXML
  private CheckBox automation;
  @FXML
  private Button accept;
  @FXML
  private Button cancel;
  private Limites limites = null;
  private Configuracion configuracion = null;

  public Limits() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/limits.fxml"), AppConfig.getInstance().getResouce());
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
    this.maxDistance.setDisable(this.automation.isSelected());
    this.minDistance.setDisable(this.automation.isSelected());
    this.rightLimit.setDisable(this.automation.isSelected());
    this.leftLimit.setDisable(this.automation.isSelected());
    if (this.automation.isSelected()) {
      this.maxDistance.setText(String.valueOf((int)this.limites.posicionMaxima.getDistancia()));
      this.minDistance.setText(String.valueOf((int)this.limites.posicionMinima.getDistancia()));
      this.rightLimit.setText(String.valueOf(DataTools.limitaDecimales(this.limites.posicionMaxima.getAzimut())));
      this.leftLimit.setText(String.valueOf(DataTools.limitaDecimales(this.limites.posicionMinima.getAzimut())));
    }

    this.minFlush.setText(DataTools.limitaDecimales(this.limites.actitudRas_Min.getElevacion()) + " ₥");
    this.maxFlush.setText(DataTools.limitaDecimales(this.limites.actitudRas_Max.getElevacion()) + " ₥");
    this.minBigAngle.setText(DataTools.limitaDecimales(this.limites.actitudGA_Min.getElevacion()) + " ₥");
    this.maxBigAngle.setText(DataTools.limitaDecimales(this.limites.actitudGA_Max.getElevacion()) + " ₥");
    this.minOrientation.setText(DataTools.limitaDecimales(this.limites.actitudRas_Min.getAzimut()) + " ₥");
    this.maxOrientation.setText(DataTools.limitaDecimales(this.limites.actitudRas_Max.getAzimut()) + " ₥");
  }

  public void initialize(URL location, ResourceBundle resources) {
    try {
      this.limites = Limites.getSingletonInstance();
    } catch (IOException var4) {
      var4.printStackTrace();
    }

    this.configuracion = Configuracion.getSingletonInstance();
    if (!Principal.getSingletonInstance().isLimitesAuto()) {
      this.automation.setSelected(false);
    }

    this.updateComponents();
    this.maxDistance.getProperties().put("vkType", "numeric");
    this.minDistance.getProperties().put("vkType", "numeric");
    this.rightLimit.getProperties().put("vkType", "numeric");
    this.leftLimit.getProperties().put("vkType", "numeric");
    this.maxDistance.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.maxDistance, newValue);
    });
    this.minDistance.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.minDistance, newValue);
    });
    this.rightLimit.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.rightLimit, newValue);
    });
    this.leftLimit.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.leftLimit, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      Main.getAppController().changeUI(MenuNavEnum.HOME, true);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.automation.setOnAction((event) -> {
      if (this.automation.isSelected()) {
        try {
          Limites.getSingletonInstance().checkAutomatico();
        } catch (IOException var3) {
          var3.printStackTrace();
        }

        this.maxDistance.setDisable(true);
        this.minDistance.setDisable(true);
        this.rightLimit.setDisable(true);
        this.leftLimit.setDisable(true);
        this.maxDistance.setText(String.valueOf((int)this.limites.posicionMaxima.getDistancia()));
        this.minDistance.setText(String.valueOf((int)this.limites.posicionMinima.getDistancia()));
        this.rightLimit.setText(String.valueOf(DataTools.limitaDecimales(this.limites.posicionMaxima.getAzimut())));
        this.leftLimit.setText(String.valueOf(DataTools.limitaDecimales(this.limites.posicionMinima.getAzimut())));
        this.validateField(this.maxDistance, true);
        this.validateField(this.minDistance, true);
        this.validateField(this.rightLimit, true);
        this.validateField(this.leftLimit, true);
        this.minFlush.setText(DataTools.limitaDecimales(this.limites.actitudRas_Min.getElevacion()) + " ₥");
        this.maxFlush.setText(DataTools.limitaDecimales(this.limites.actitudRas_Max.getElevacion()) + " ₥");
        this.minBigAngle.setText(DataTools.limitaDecimales(this.limites.actitudGA_Min.getElevacion()) + " ₥");
        this.maxBigAngle.setText(DataTools.limitaDecimales(this.limites.actitudGA_Max.getElevacion()) + " ₥");
        this.minOrientation.setText(DataTools.limitaDecimales(this.limites.actitudRas_Min.getAzimut()) + " ₥");
        this.maxOrientation.setText(DataTools.limitaDecimales(this.limites.actitudRas_Max.getAzimut()) + " ₥");
      } else {
        this.maxDistance.setDisable(false);
        this.minDistance.setDisable(false);
        this.rightLimit.setDisable(false);
        this.leftLimit.setDisable(false);
      }

    });
    this.rightLimitUnits.setText("₥");
    this.leftLimitUnits.setText("₥");
    this.maxDistanceUnits.setText("m");
    this.minDistanceUnits.setText("m");
    this.clearForm();
    if (AppConfig.getInstance().getLimits() != null) {
      this.maxDistance.setText(AppConfig.getInstance().getLimits().maxDistance.getText());
      this.minDistance.setText(AppConfig.getInstance().getLimits().minDistance.getText());
      this.rightLimit.setText(AppConfig.getInstance().getLimits().rightLimit.getText());
      this.leftLimit.setText(AppConfig.getInstance().getLimits().leftLimit.getText());
      this.automation.setSelected(AppConfig.getInstance().getLimits().automation.isSelected());
    }

  }

  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField != this.maxDistance && textField != this.minDistance) {
      if (textField == this.rightLimit || textField == this.leftLimit) {
        if (!newValue && !textField.getText().matches(MeasureExpression.AZIMUTH)) {
          textField.getStyleClass().add("error");
        }

      }
    } else {
      if (!newValue && !textField.getText().matches(MeasureExpression.DISTANCE_METERS_155)) {
        textField.getStyleClass().add("error");
      }

    }
  }

  private void clearForm() {
    this.maxDistance.setText("0");
    this.minDistance.setText("0");
    this.rightLimit.setText("0.00");
    this.leftLimit.setText("0.00");
    this.minFlush.setText("0.00");
    this.maxFlush.setText("0.00");
    this.minBigAngle.setText("0.00");
    this.maxBigAngle.setText("0.00");
    this.minOrientation.setText("0.00");
    this.maxOrientation.setText("0.00");
  }

  private boolean validateForm() {
    if (this.automation.isSelected()) {
      return true;
    } else {
      this.validateField(this.maxDistance, false);
      this.validateField(this.minDistance, false);
      this.validateField(this.rightLimit, false);
      this.validateField(this.leftLimit, false);
      return !this.maxDistance.getStyleClass().contains("error") && !this.minDistance.getStyleClass().contains("error") && !this.rightLimit.getStyleClass().contains("error") && !this.leftLimit.getStyleClass().contains("error");
    }
  }

  private void formSubmit() {
    if (this.limites != null) {
      if (!this.automation.isSelected()) {
        try {
          Limites.getSingletonInstance().limitesManual(Double.parseDouble(this.maxDistance.getText()), Double.parseDouble(this.minDistance.getText()), Double.parseDouble(this.rightLimit.getText()), Double.parseDouble(this.leftLimit.getText()));
          this.minFlush.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudRas_Min.getElevacion())));
          System.out.println("Limits.formSubmit");
          System.out.println("limites.actitudRas_Min.getElevacion() = " + this.limites.actitudRas_Min.getElevacion());
          this.maxFlush.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudRas_Max.getElevacion())));
          this.minBigAngle.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudGA_Min.getElevacion())));
          this.maxBigAngle.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudGA_Max.getElevacion())));
          this.minOrientation.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudRas_Min.getAzimut())));
          this.maxOrientation.setText(String.valueOf(DataTools.limitaDecimales(this.limites.actitudRas_Max.getAzimut())));
        } catch (IOException var2) {
          var2.printStackTrace();
        }
      }

      Limits limits = new Limits();
      limits.maxDistance.setText(this.maxDistance.getText());
      limits.minDistance.setText(this.minDistance.getText());
      limits.rightLimit.setText(this.rightLimit.getText());
      limits.leftLimit.setText(this.leftLimit.getText());
      limits.automation.setSelected(this.automation.isSelected());
      AppConfig.getInstance().setLimits(limits);
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, false);
      Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Limits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */