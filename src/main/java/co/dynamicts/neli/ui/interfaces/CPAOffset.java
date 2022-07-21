package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CPAOffset extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField elevation;
  @FXML
  private TextField descent;
  @FXML
  private TextField right;
  @FXML
  private TextField left;
  @FXML
  private Button edit;
  @FXML
  private Button auto;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;
  Configuracion configuracion = Configuracion.getSingletonInstance();
  CPA cpa = CPA.getSingletonInstance();

  public CPAOffset() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/CPA_Offset.fxml"), AppConfig.getInstance().getResouce());
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
    this.elevation.getProperties().put("vkType", "numeric");
    this.descent.getProperties().put("vkType", "numeric");
    this.left.getProperties().put("vkType", "numeric");
    this.right.getProperties().put("vkType", "numeric");
    this.elevation.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.elevation, newValue);
    });
    this.descent.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.descent, newValue);
    });
    this.left.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.left, newValue);
    });
    this.right.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.right, newValue);
    });
    this.edit.setOnMouseClicked((event) -> {
      if (Main.getAppController().setPasswordDialog()) {
        this.elevation.setDisable(false);
        this.descent.setDisable(false);
        this.left.setDisable(false);
        this.right.setDisable(false);
        this.accept.setDisable(false);
        this.edit.setDisable(true);
        this.auto.setDisable(false);
      }

    });
    this.auto.setOnMouseClicked((event) -> {
      System.out.println("AUTO OffSet Clicked");
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.CALIBRACION);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.clearForm();
    FuncionesCPA var10001 = this.cpa.funcionesCPA;
    this.cpa.funcionesCPA.Comando = FuncionesCPA.TomarOffSets;
    var10001 = this.cpa.funcionesCPA;
    this.elevation.setText(String.valueOf(FuncionesCPA.OffSetUp));
    var10001 = this.cpa.funcionesCPA;
    this.descent.setText(String.valueOf(FuncionesCPA.OffSetDn));
    var10001 = this.cpa.funcionesCPA;
    this.right.setText(String.valueOf(FuncionesCPA.OffSetRg));
    var10001 = this.cpa.funcionesCPA;
    this.left.setText(String.valueOf(FuncionesCPA.OffSetLf));
  }

  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.elevation || textField == this.descent || textField == this.left || textField == this.right) {
      if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_DOUBLE)) {
        textField.getStyleClass().add("error");
      }

    }
  }

  private void clearForm() {
    this.elevation.setText("0.00");
    this.descent.setText("0");
    this.left.setText("0");
    this.right.setText("0");
  }

  private boolean validateForm() {
    this.validateField(this.elevation, false);
    this.validateField(this.descent, false);
    this.validateField(this.right, false);
    return !this.elevation.getStyleClass().contains("error") && !this.descent.getStyleClass().contains("error") && !this.right.getStyleClass().contains("error");
  }

  private void formSubmit() {
    FuncionesCPA var10000 = this.cpa.funcionesCPA;
    FuncionesCPA.OffSetUp = Float.parseFloat(this.elevation.getText());
    var10000 = this.cpa.funcionesCPA;
    FuncionesCPA.OffSetDn = Float.parseFloat(this.descent.getText());
    var10000 = this.cpa.funcionesCPA;
    FuncionesCPA.OffSetLf = Float.parseFloat(this.left.getText());
    var10000 = this.cpa.funcionesCPA;
    FuncionesCPA.OffSetRg = Float.parseFloat(this.right.getText());
    this.cpa.funcionesCPA.Comando = this.cpa.funcionesCPA.CambiarOffSets;
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.CALIBRACION);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\CPAOffset.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */