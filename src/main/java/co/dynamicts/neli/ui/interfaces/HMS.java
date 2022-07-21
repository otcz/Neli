
package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.calibration.CheckCalibration;
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

public class HMS extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private CheckCalibration power;
  @FXML
  private CheckCalibration presion;
  @FXML
  private CheckCalibration posicionInicial;
  @FXML
  private CheckCalibration modoAutomatico;
  @FXML
  private CheckCalibration secuenciaAtacadoCompleta;
  @FXML
  private CheckCalibration atacadoCompleto;
  @FXML
  private CheckCalibration limteElevacion;
  @FXML
  private CheckCalibration errorPosicion;
  @FXML
  private CheckCalibration presionAtacador;
  @FXML
  private CheckCalibration temperaturaAceite;
  @FXML
  private CheckCalibration errorElectronico;
  @FXML
  private CheckCalibration preparado;
  @FXML
  private CheckCalibration cierreCerrado;
  @FXML
  private CheckCalibration cierreAbierto;
  @FXML
  private CheckCalibration presionSistema;
  @FXML
  private CheckCalibration elevacion25;
  @FXML
  private CheckCalibration elevacion45;
  @FXML
  private CheckCalibration tejaDesalineada;
  @FXML
  private CheckCalibration tejaAlineada;
  @FXML
  private CheckCalibration tejaArriba;
  @FXML
  private CheckCalibration tejaAbajo;
  @FXML
  private CheckCalibration bloqueado;
  @FXML
  private CheckCalibration proyectilEnTeja;
  @FXML
  private Button cancel;
  CPA cpa = CPA.getSingletonInstance();

  public HMS() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/HMS.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    this.updateStatus();
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.setTitles();
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.CALIBRACION);
    });
    this.clearForm();
    this.updateStatus();
  }

  private void clearForm() {
    this.updateSingleStatus(this.power, false);
    this.updateSingleStatus(this.presion, false);
    this.updateSingleStatus(this.posicionInicial, false);
    this.updateSingleStatus(this.modoAutomatico, false);
    this.updateSingleStatus(this.secuenciaAtacadoCompleta, false);
    this.updateSingleStatus(this.atacadoCompleto, false);
    this.updateSingleStatus(this.limteElevacion, false);
    this.updateSingleStatus(this.errorPosicion, false);
    this.updateSingleStatus(this.presionAtacador, false);
    this.updateSingleStatus(this.temperaturaAceite, false);
    this.updateSingleStatus(this.errorElectronico, false);
    this.updateSingleStatus(this.preparado, false);
    this.updateSingleStatus(this.cierreCerrado, false);
    this.updateSingleStatus(this.cierreAbierto, false);
    this.updateSingleStatus(this.presionSistema, false);
    this.updateSingleStatus(this.elevacion25, false);
    this.updateSingleStatus(this.elevacion45, false);
    this.updateSingleStatus(this.tejaDesalineada, false);
    this.updateSingleStatus(this.tejaAlineada, false);
    this.updateSingleStatus(this.tejaArriba, false);
    this.updateSingleStatus(this.tejaAbajo, false);
    this.updateSingleStatus(this.bloqueado, false);
    this.updateSingleStatus(this.proyectilEnTeja, false);
  }

  private void formSubmit() {
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.CALIBRACION);
  }

  private void setTitles() {
    this.power.setCheckLabel(StringUtil.translateKey("label.interface.hms.power"));
    this.presion.setCheckLabel(StringUtil.translateKey("label.interface.hms.pressure"));
    this.posicionInicial.setCheckLabel(StringUtil.translateKey("label.interface.hms.pos.ini"));
    this.modoAutomatico.setCheckLabel(StringUtil.translateKey("label.interface.hms.automatic.mode"));
    this.secuenciaAtacadoCompleta.setCheckLabel(StringUtil.translateKey("label.interface.hms.sec.atac.com"));
    this.atacadoCompleto.setCheckLabel(StringUtil.translateKey("label.interface.hms.atac.com"));
    this.limteElevacion.setCheckLabel(StringUtil.translateKey("label.interface.hms.lim.elev"));
    this.errorPosicion.setCheckLabel(StringUtil.translateKey("label.interface.hms.pos.error"));
    this.presionAtacador.setCheckLabel(StringUtil.translateKey("label.interface.hms.press.ata"));
    this.temperaturaAceite.setCheckLabel(StringUtil.translateKey("label.interface.hms.temp.oil"));
    this.errorElectronico.setCheckLabel(StringUtil.translateKey("label.interface.hms.elec.error"));
    this.preparado.setCheckLabel(StringUtil.translateKey("label.interface.hms.ready"));
    this.cierreCerrado.setCheckLabel(StringUtil.translateKey("label.interface.hms.cierre.abierto"));
    this.cierreAbierto.setCheckLabel(StringUtil.translateKey("label.interface.hms.cierre.cerrado"));
    this.presionSistema.setCheckLabel(StringUtil.translateKey("label.interface.hms.press.sis"));
    this.elevacion25.setCheckLabel(StringUtil.translateKey("label.interface.hms.elev.25"));
    this.elevacion45.setCheckLabel(StringUtil.translateKey("label.interface.hms.elev.45"));
    this.tejaDesalineada.setCheckLabel(StringUtil.translateKey("label.interface.hms.teja.desali"));
    this.tejaAlineada.setCheckLabel(StringUtil.translateKey("label.interface.hms.teja.ali"));
    this.tejaArriba.setCheckLabel(StringUtil.translateKey("label.interface.hms.teja.arriba"));
    this.tejaAbajo.setCheckLabel(StringUtil.translateKey("label.interface.hms.teja.abajo"));
    this.bloqueado.setCheckLabel(StringUtil.translateKey("label.interface.hms.bloq"));
    this.proyectilEnTeja.setCheckLabel(StringUtil.translateKey("label.interface.hms.pro.teja"));
  }

  private void updateSingleStatus(CheckCalibration checkCalibration, boolean status) {
    checkCalibration.setSelected(status);
    checkCalibration.check(status);
  }

  public void updateStatus() {
    FuncionesCPA var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.power, FuncionesCPA.HMS_Enecendido);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.presion, FuncionesCPA.HMS_PresionCorrecta);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.posicionInicial, FuncionesCPA.HMS_PosiInicial);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.modoAutomatico, FuncionesCPA.HMS_ModoAuto);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.secuenciaAtacadoCompleta, FuncionesCPA.HMS_SecAtacComp);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.atacadoCompleto, FuncionesCPA.HMS_AtacaComp);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.limteElevacion, FuncionesCPA.HMS_LimiteEleva);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.errorPosicion, FuncionesCPA.HMS_FalloPosic);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.presionAtacador, FuncionesCPA.HMS_PresAtaca);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.temperaturaAceite, FuncionesCPA.HMS_TempAceit);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.errorElectronico, FuncionesCPA.HMS_FalloElectr);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.preparado, FuncionesCPA.HMS_Preparado);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.cierreCerrado, FuncionesCPA.HMS_CierreAbierto);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.cierreAbierto, FuncionesCPA.HMS_CierrreCerrado);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.presionSistema, FuncionesCPA.HMS_PresionSistema);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.elevacion25, FuncionesCPA.HMS_Elev25);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.elevacion45, FuncionesCPA.HMS_Eleva45);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.tejaDesalineada, FuncionesCPA.HMS_TejaDesal);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.tejaAlineada, FuncionesCPA.HMS_TejaAlineada);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.tejaArriba, FuncionesCPA.HMS_TejaArriba);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.tejaAbajo, FuncionesCPA.HMS_TejaAbajo);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.bloqueado, FuncionesCPA.HMS_Bloqueado);
    var10002 = this.cpa.funcionesCPA;
    this.updateSingleStatus(this.proyectilEnTeja, FuncionesCPA.HMS_ProyectilEnTeja);
  }
}

/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\HMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */