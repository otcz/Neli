package co.dynamicts.neli.ui.component.calibration;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.stauts.StatusAimCalibration;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CalibrationComponent extends AnchorPane {
  @FXML
  private Label azimutTubo;
  
  @FXML
  private Label elevationTubo;
  
  @FXML
  private Label statusCPA;
  
  @FXML
  private CheckCalibration localisedTarget;
  
  @FXML
  private CheckCalibration calibrationOrientation;
  
  @FXML
  private CheckCalibration raceEnd;
  
  @FXML
  private CheckCalibration communicationError;
  
  @FXML
  private CheckCalibration firstPieceAssembly;
  
  @FXML
  private CheckCalibration tubeOut;
  
  @FXML
  private CheckCalibration movingAlarm;
  
  @FXML
  private CheckCalibration notLocatedTarget;
  
  @FXML
  private CheckCalibration elevationCalibration;
  
  @FXML
  private CheckCalibration finalDistance;
  
  @FXML
  private CheckCalibration syncMode;
  
  @FXML
  private CheckCalibration commandSequence;
  
  @FXML
  private CheckCalibration computedMatrix;
  
  @FXML
  private CheckCalibration offsetError;
  
  @FXML
  private ButtonImage calibrate;
  
  @FXML
  private ButtonImage HMS;
  
  @FXML
  private ButtonImage waitingPosition;
  
  @FXML
  private ButtonImage calibrateOffset;
  
  @FXML
  private ButtonImage shutDown;
  
  @FXML
  private ButtonImage trincar;
  
  @FXML
  private ButtonImage unlock;
  
  @FXML
  private ButtonImage desTrincar;
  
  CPA cpa = CPA.getSingletonInstance();
  
  @FXML
  public void initialize() {
    setTitles();
    updateStatus();
  }
  
  public void updateStatus() {
    updateSingleStatus(this.localisedTarget, this.cpa.estadoPrueba);
    updateSingleStatus(this.calibrationOrientation, FuncionesCPA.CalibradoAzimuth);
    updateSingleStatus(this.raceEnd, FuncionesCPA.PositionAlamrHW);
    updateSingleStatus(this.communicationError, FuncionesCPA.ErrorComunicacion);
    updateSingleStatus(this.firstPieceAssembly, FuncionesCPA.PrimerMontajeCPA);
    updateSingleStatus(this.tubeOut, FuncionesCPA.FueraDeConoApuntamiento);
    updateSingleStatus(this.movingAlarm, FuncionesCPA.PositioningAlamrSW);
    updateSingleStatus(this.notLocatedTarget, FuncionesCPA.TargetNotLocked);
    updateSingleStatus(this.elevationCalibration, FuncionesCPA.CalibradoPitch);
    updateSingleStatus(this.finalDistance, FuncionesCPA.PositioningAlamrSW);
    updateSingleStatus(this.syncMode, FuncionesCPA.SintonizingDevice);
    updateSingleStatus(this.commandSequence, FuncionesCPA.ChecksumAlarma);
    updateSingleStatus(this.computedMatrix, FuncionesCPA.MatrizCalculada);
    updateSingleStatus(this.offsetError, FuncionesCPA.OffsetsError);
  }
  
  public void updateStatus(StatusAimCalibration status) {
    updateSingleStatus(this.localisedTarget, status.isObjetivoLocalizado());
    updateSingleStatus(this.calibrationOrientation, status.isCalibracionOrientacion());
    updateSingleStatus(this.raceEnd, status.isFinalCarrera());
    updateSingleStatus(this.communicationError, status.isErrorComunicacion());
    updateSingleStatus(this.firstPieceAssembly, status.isPrimerMontajePieza());
    updateSingleStatus(this.tubeOut, status.isTuboFuera());
    updateSingleStatus(this.movingAlarm, status.isAlarmaMovimiento());
    updateSingleStatus(this.notLocatedTarget, status.isObjetivoNoLocalizado());
    updateSingleStatus(this.elevationCalibration, status.isCalibracionElevacion());
    updateSingleStatus(this.finalDistance, status.isFinalRecorrido());
    updateSingleStatus(this.syncMode, status.isModoSincronizado());
    updateSingleStatus(this.commandSequence, status.isSecuenciaComandar());
    updateSingleStatus(this.computedMatrix, status.isMatrizCalculada());
    updateSingleStatus(this.offsetError, status.isErrorDeOffset());
    this.azimutTubo.setText(String.valueOf(DataTools.limitaDecimales(this.cpa.getOrientacion())));
    this.elevationTubo.setText(String.valueOf(DataTools.limitaDecimales(this.cpa.getElevacion())));
  }
  
  private void updateSingleStatus(CheckCalibration checkCalibration, boolean status) {
    checkCalibration.setSelected(status);
    checkCalibration.check(status);
  }
  
  private void setTitles() {
    this.localisedTarget.setCheckLabel("Objetivo Localizado");
    this.calibrationOrientation.setCheckLabel("Calibración Orientación");
    this.raceEnd.setCheckLabel("Final de Carrera");
    this.communicationError.setCheckLabel("Error Comunicación");
    this.firstPieceAssembly.setCheckLabel("Primer Montaje Pieza");
    this.tubeOut.setCheckLabel("Tubo Fuera Cono Puntería");
    this.movingAlarm.setCheckLabel("Alarma movimiento");
    this.notLocatedTarget.setCheckLabel("Objetivo No Localizado");
    this.elevationCalibration.setCheckLabel("Calibración Elevación");
    this.finalDistance.setCheckLabel("Final del Recorrido");
    this.syncMode.setCheckLabel("Modo Sincronizado Control");
    this.commandSequence.setCheckLabel("Secuencia Comandar Errónea");
    this.computedMatrix.setCheckLabel("Matriz Calculada");
    this.offsetError.setCheckLabel("Error De Offset");
    this.calibrate.setLabel("Calibrar");
    this.HMS.setLabel("HMS");
    this.waitingPosition.setLabel("Posición Espera");
    this.calibrateOffset.setLabel("Offset");
    this.azimutTubo.setText("0.00");
    this.elevationTubo.setText("0.00");
    this.statusCPA.setText("NA");
    this.shutDown.setLabel("Apagar");
    this.unlock.setLabel("Desbloquear");
    this.trincar.setLabel("Trincar");
    this.desTrincar.setLabel("Destrincar");
  }
  
  public CalibrationComponent() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/calibration/calibration_component.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    setCalibrateAction();
    setRestartCommunicationAction();
    setWaitingPositionAction();
    setCalibrateOffsetction();
    setShutDownAction();
    setTrincarAction();
    setUnlockAction();
    setDesTrincarAction();
  }
  
  private void setCalibrateAction() {
    this.calibrate.setOnAction(event -> {
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de calibrar?")) {
            this.cpa.funcionesCPA.Comando = FuncionesCPA.calibrar;
            System.out.println("calibrate Button clicked!");
          } 
        });
  }
  
  private void setRestartCommunicationAction() {
    this.HMS.setOnAction(event -> {
          Main.getAppController().changeUIWithOutMenu(MenuNavEnum.CALIBRACION, "PAGINA_HMS", false);
          System.out.println("restartCommunication Button clicked!");
        });
  }
  
  private void setWaitingPositionAction() {
    this.waitingPosition.setOnAction(event -> {
          this.cpa.funcionesCPA.Comando = FuncionesCPA.ir_a_posi;
          System.out.println("waitingPosition Button clicked!");
        });
  }
  
  private void setCalibrateOffsetction() {
    this.calibrateOffset.setOnAction(event -> {
          Main.getAppController().changeUIWithOutMenu(MenuNavEnum.CALIBRACION, "PAGINA_CPA_OFFSET", false);
          System.out.println("calibrate offset Button clicked!");
        });
  }
  
  private void setShutDownAction() {
    this.shutDown.setOnAction(event -> {
          FuncionesCPA.NumeroDeMensajes = 3;
          this.cpa.funcionesCPA.Comando = FuncionesCPA.apagar;
          System.out.println("Shutdown Button clicked!");
        });
  }
  
  private void setTrincarAction() {
    this.trincar.setOnAction(event -> {
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de trincar?")) {
            this.cpa.funcionesCPA.Comando = FuncionesCPA.in_travel_LK;
            System.out.println("Trincar Button clicked!");
          } 
        });
  }
  
  private void setUnlockAction() {
    this.unlock.setOnAction(event -> {
          this.cpa.funcionesCPA.Comando = FuncionesCPA.desbloquear;
          System.out.println("Unlock Button clicked!");
        });
  }
  
  private void setDesTrincarAction() {
    this.desTrincar.setOnAction(event -> {
          if (Main.getAppController().setConfirmationDialog("Confirmacion", "¿Esta seguro de destrincar?")) {
            this.cpa.funcionesCPA.Comando = FuncionesCPA.out_travel_LK;
            System.out.println("Destrincar Button clicked!");
          } 
        });
  }
  
  public CheckCalibration getLocalisedTarget() {
    return this.localisedTarget;
  }
  
  public void setLocalisedTarget(CheckCalibration localisedTarget) {
    this.localisedTarget = localisedTarget;
  }
  
  public CheckCalibration getCalibrationOrientation() {
    return this.calibrationOrientation;
  }
  
  public void setCalibrationOrientation(CheckCalibration calibrationOrientation) {
    this.calibrationOrientation = calibrationOrientation;
  }
  
  public CheckCalibration getRaceEnd() {
    return this.raceEnd;
  }
  
  public void setRaceEnd(CheckCalibration raceEnd) {
    this.raceEnd = raceEnd;
  }
  
  public CheckCalibration getCommunicationError() {
    return this.communicationError;
  }
  
  public void setCommunicationError(CheckCalibration communicationError) {
    this.communicationError = communicationError;
  }
  
  public CheckCalibration getFirstPieceAssembly() {
    return this.firstPieceAssembly;
  }
  
  public void setFirstPieceAssembly(CheckCalibration firstPieceAssembly) {
    this.firstPieceAssembly = firstPieceAssembly;
  }
  
  public CheckCalibration getTubeOut() {
    return this.tubeOut;
  }
  
  public void setTubeOut(CheckCalibration tubeOut) {
    this.tubeOut = tubeOut;
  }
  
  public CheckCalibration getMovingAlarm() {
    return this.movingAlarm;
  }
  
  public void setMovingAlarm(CheckCalibration movingAlarm) {
    this.movingAlarm = movingAlarm;
  }
  
  public CheckCalibration getNotLocatedTarget() {
    return this.notLocatedTarget;
  }
  
  public void setNotLocatedTarget(CheckCalibration notLocatedTarget) {
    this.notLocatedTarget = notLocatedTarget;
  }
  
  public CheckCalibration getElevationCalibration() {
    return this.elevationCalibration;
  }
  
  public void setElevationCalibration(CheckCalibration elevationCalibration) {
    this.elevationCalibration = elevationCalibration;
  }
  
  public CheckCalibration getFinalDistance() {
    return this.finalDistance;
  }
  
  public void setFinalDistance(CheckCalibration finalDistance) {
    this.finalDistance = finalDistance;
  }
  
  public CheckCalibration getSyncMode() {
    return this.syncMode;
  }
  
  public void setSyncMode(CheckCalibration syncMode) {
    this.syncMode = syncMode;
  }
  
  public CheckCalibration getCommandSequence() {
    return this.commandSequence;
  }
  
  public void setCommandSequence(CheckCalibration commandSequence) {
    this.commandSequence = commandSequence;
  }
  
  public CheckCalibration getComputedMatrix() {
    return this.computedMatrix;
  }
  
  public void setComputedMatrix(CheckCalibration computedMatrix) {
    this.computedMatrix = computedMatrix;
  }
  
  public CheckCalibration getOffsetError() {
    return this.offsetError;
  }
  
  public void setOffsetError(CheckCalibration offsetError) {
    this.offsetError = offsetError;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\calibration\CalibrationComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */