package co.dynamicts.neli.ui.component.cpa;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.stauts.StatusCPAParameters;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import co.dynamicts.neli.ui.component.common.TextfieldTitle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CPAParametersComponent extends VBox {
  @FXML
  private Label fases;
  
  @FXML
  private TextfieldTitle fase0;
  
  @FXML
  private TextfieldTitle fase1;
  
  @FXML
  private TextfieldTitle fase2;
  
  @FXML
  private TextfieldTitle fase3;
  
  @FXML
  private Label parametrosControlador;
  
  @FXML
  private TextfieldTitle lIzquierdo;
  
  @FXML
  private TextfieldTitle lDerecho;
  
  @FXML
  private TextfieldTitle minErrorIzquierda;
  
  @FXML
  private TextfieldTitle minErrorDerecha;
  
  @FXML
  private TextfieldTitle maxErrorIzquierda;
  
  @FXML
  private TextfieldTitle maxErrorDerecha;
  
  @FXML
  private TextfieldTitle cpAbajo;
  
  @FXML
  private TextfieldTitle cpArriba;
  
  @FXML
  private ButtonImage desbloquear;
  
  @FXML
  private ButtonImage actualizarParametros;
  
  @FXML
  private ButtonImage guardarParametros;
  
  @FXML
  private ButtonImage cpaMod;
  
  private StatusCPAParameters statusCPAParameters;
  
  FXMLLoader fxmlLoader;
  
  CPA cpa = CPA.getSingletonInstance();
  
  public CPAParametersComponent() {
    this.fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/cpa/parametros_CPA.fxml"));
    this.fxmlLoader.setRoot(this);
    this.fxmlLoader.setController(this);
    try {
      this.fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    setGuardarParametros();
    setDesbloquear();
    setActualizarParametros();
  }
  
  @FXML
  public void initialize() {
    this.statusCPAParameters = new StatusCPAParameters("", "", "", "", "", "", "", "", "", "", "", "");
    setTitles();
    updateStatus();
  }
  
  public void updateStatus() {
    this.fase0.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Fase0));
    this.fase1.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Fase1));
    this.fase2.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Fase2));
    this.fase3.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Fase3));
    this.lIzquierdo.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Alfa_Izq));
    this.lDerecho.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Alfa_Der));
    this.minErrorIzquierda.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_M_Din_Izq));
    this.minErrorDerecha.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_M_Din_Der));
    this.maxErrorIzquierda.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_M_Err_Izq));
    this.maxErrorDerecha.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_M_Err_Der));
    this.cpAbajo.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Kp_Arriba));
    this.cpArriba.setMeasureLabelCMS(String.valueOf(FuncionesCPA.Parametro_Kp_Abajo));
  }
  
  private void setTitles() {
    this.fase0.setTitleLabelCMS("Fase 0");
    this.fase1.setTitleLabelCMS("Fase 1");
    this.fase2.setTitleLabelCMS("Fase 2");
    this.fase3.setTitleLabelCMS("Fase 3");
    this.lIzquierdo.setTitleLabelCMS("L. Izquierdo");
    this.lDerecho.setTitleLabelCMS("L. Derecho");
    this.minErrorIzquierda.setTitleLabelCMS("Min. error Izquierda");
    this.minErrorDerecha.setTitleLabelCMS("Min. error Derecha");
    this.maxErrorDerecha.setTitleLabelCMS("Max. error Derecha");
    this.maxErrorIzquierda.setTitleLabelCMS("Max. error Izquierda");
    this.cpAbajo.setTitleLabelCMS("Cp Abajo");
    this.cpArriba.setTitleLabelCMS("Cp Arriba");
    this.desbloquear.setLabel("Desbloquear");
    this.actualizarParametros.setLabel("Actualizar Parametros");
    this.guardarParametros.setLabel("Guardar Parametros");
    this.cpaMod.setLabel("CPA mod. Sintonizador");
  }
  
  private void setGuardarParametros() {
    this.guardarParametros.setOnAction(event -> {
          if (Main.getAppController().setPasswordDialog())
            System.out.println("Save Button clicked!"); 
        });
  }
  
  private void setDesbloquear() {
    this.desbloquear.setOnAction(event -> {
          this.cpa.funcionesCPA.Comando = FuncionesCPA.desbloquear;
          System.out.println("calibrate Button clicked!");
        });
  }
  
  private void setActualizarParametros() {
    this.actualizarParametros.setOnAction(event -> {
          this.cpa.funcionesCPA.Comando = FuncionesCPA.GetParaRecorrTrincYDestric;
          updateStatus();
          System.out.println("actualice Button clicked!");
        });
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\cpa\CPAParametersComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */