package co.dynamicts.neli.core.ObusHW;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Direccion;
import co.dynamicts.neli.core.Fires.Pointing;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.MovilTarget;
import co.dynamicts.neli.core.utilities.Tools;

import java.io.IOException;

public class CPA extends Thread {
  private static CPA cpa;
  
  public Tools tools = new Tools();
  
  public FuncionesCPA funcionesCPA = new FuncionesCPA();
  
  public Thread hiloPunteria;
  
  final Ins ins = Ins.getSingletonInstance();
  
  private MuzzleRadar radar = MuzzleRadar.getSingletonInstance();
  
  private Trinca trinca = Trinca.getSingletonInstance();
  
  public DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  public Pointing pointing = Pointing.getSingletonInstance();
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  public boolean estadoPrueba = false;
  
  private double orientacion = this.ins.actitud.getAzimut();
  
  private double elevacion = this.ins.actitud.getElevacion();
  
  private double refOrientacion = 0.0D;
  
  private double refElevacion = 0.0D;
  
  private boolean isHMS = false;
  
  private int HMS = 0;
  
  private boolean isCPA = false;
  
  private int isCalibrated = 0;
  
  private boolean isSensorIzquierdo;
  
  private boolean isSensorDerecho;
  
  private boolean isCalibratedElevation;
  
  private boolean isCalibratedOrientation;
  
  private boolean isBtnApuntar;
  
  private boolean isBtnDisparar;
  
  private boolean isBtnStop = false;
  
  private boolean isBtnSeguir = false;
  
  private boolean appointindSignal = false;
  
  private boolean stopSignal = false;
  
  private boolean followSignal = false;
  
  private boolean isPointingOk = false;
  
  private boolean ejecutar = true;
  
  public static String IDCOMCPA;
  
  Thread hiloBlancoMovil;
  
  public void CPA() {}
  
  public void run() {
    this.funcionesCPA.TomarPuerto();
    while (true) {
      if (!this.ejecutar)
        this.funcionesCPA.TomarPuerto(); 
      this.funcionesCPA.run();
      FuncionesCPA.AzimuthActual = (float)this.ins.actitud.getAzimut();
      FuncionesCPA.PitchActual = (float)this.ins.actitud.getElevacion();
      FuncionesCPA.Latitud = (float)this.ins.obus.getLatitud();
      FuncionesCPA.Longitud = (float)this.ins.obus.getLongitud();
      setEstadoHMS();
      if (this.funcionesCPA.Est_Conex == 0) {
        setCPA(false);
      } else if (this.funcionesCPA.Est_Conex == 2) {
        setCPA(true);
      } 
      CMS.getSingletonInstance().updateTemCanonState();
    } 
  }
  
  public void detener() {
    this.ejecutar = false;
  }
  
  public void apuntar() {
    if (!this.configuracion.isSimulado && this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
      cpa.funcionesCPA.Comando = FuncionesCPA.desbloquear;
      try {
        sleep(200L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
      FuncionesCPA.AzimuthObjetivo = (float)this.datosCalculados.actitudDeseadaMils.getAzimut();
      FuncionesCPA.PitchObjetivo = (float)this.datosCalculados.actitudDeseadaMils.getElevacion();
      this.funcionesCPA.Comando = FuncionesCPA.ir_a_posi;
      try {
        sleep(200L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
    this.appointindSignal = true;
  }
  
  public void seguir() {
    if (!this.configuracion.isSimulado && this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
      try {
        MovilTarget movilTarget = MovilTarget.getSingletonInstance();
        movilTarget.setSeguir(true);
        movilTarget.setTakeTimeStart(true);
        this.hiloBlancoMovil = new Thread((Runnable)movilTarget);
        cpa.funcionesCPA.Comando = FuncionesCPA.desbloquear;
        try {
          sleep(200L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
        this.hiloBlancoMovil.start();
        this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.MOVIL);
        this.configuracion.setCriterio(Configuracion.Criterio.SUPERVIVENCIA);
      } catch (IOException e) {
        e.printStackTrace();
      } 
      this.followSignal = true;
      System.out.println("Blanco en seguimiento");
    } 
  }
  
  public void parar() {
    if (!this.configuracion.isSimulado)
      try {
        sleep(200L);
        cpa.funcionesCPA.Comando = FuncionesCPA.desbloquear;
        this.funcionesCPA.Comando = FuncionesCPA.parar;
        this.appointindSignal = false;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }  
    if (this.configuracion.getTipoCalculo() == Configuracion.TipoCalculo.MOVIL)
      try {
        MovilTarget.getSingletonInstance().setSeguir(false);
        this.hiloBlancoMovil.stop();
        this.funcionesCPA.Comando = FuncionesCPA.parar;
        this.followSignal = false;
      } catch (IOException e) {
        e.printStackTrace();
      }  
    this.appointindSignal = false;
  }
  
  public void disparar() {
    this.radar.coutnAux++;
    this.radar.lastVelocity = Double.parseDouble(String.valueOf(this.configuracion.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso())));
    this.radar.listenerFire();
  }
  
  private void testIsPointingOK() {
    if (!this.pointing.isYOk() || !this.pointing.isXOk()) {
      setPointingOk(false);
    } else {
      setPointingOk(true);
    } 
  }
  
  public boolean isBtnApuntar() {
    Direccion direccion = Direccion.getSingletonInstance();
    testIsPointingOK();
    if (!this.trinca.isTrincaPut() && 
      !isPointingOk() && this.datosCalculados
      .isBlancoSetting() && this.datosCalculados
      .isPosible() && 
      
      !direccion.isLimMecanicoDerIsBad() && 
      !direccion.isLimMecanicoIzqIsBad() && !this.appointindSignal && this.tools
      
      .difCirculoAZ1_AZ2(this.datosCalculados.actitudDeseadaMils.getAzimut(), direccion.getLimiteIzquierdoFisico()) >= 0.0D && this.tools
      .difCirculoAZ1_AZ2(this.datosCalculados.actitudDeseadaMils.getAzimut(), direccion.getLimiteDerechoFisico()) <= 0.0D) {
      this.isBtnApuntar = true;
    } else {
      this.isBtnApuntar = false;
    } 
    return this.isBtnApuntar;
  }
  
  public boolean isBtnStop() {
    boolean isTipoCalculoMovil;
    if (this.configuracion.getTipoCalculo() == Configuracion.TipoCalculo.MOVIL) {
      isTipoCalculoMovil = true;
    } else {
      isTipoCalculoMovil = false;
    } 
    if (!isTipoCalculoMovil && this.appointindSignal && !isPointingOk()) {
      this.isBtnStop = true;
    } else if (isTipoCalculoMovil && this.followSignal && isPointingOk()) {
      this.isBtnStop = true;
    } else {
      return false;
    } 
    return this.isBtnStop;
  }
  
  public boolean isBtnSeguir() {
    testIsPointingOK();
    boolean isTipoCalculoMovil = (Configuracion.getSingletonInstance().getTipoCalculo() == Configuracion.TipoCalculo.MOVIL);
    if (isTipoCalculoMovil && 
      isPointingOk() && !this.followSignal && 
      
      !this.trinca.isTrincaPut() && this.datosCalculados
      .isBlancoSetting() && this.datosCalculados
      .isPosible() && 
      isCPA() && this.ins
      .isZuptTiro() && 
      !Direccion.getSingletonInstance().isLimMecanicoDerIsBad() && 
      !Direccion.getSingletonInstance().isLimMecanicoIzqIsBad()) {
      this.isBtnSeguir = true;
    } else {
      this.isBtnSeguir = false;
    } 
    return this.isBtnSeguir;
  }
  
  public boolean isBtnDisparar() {
    testIsPointingOK();
    if (!this.trinca.isTrincaPut() && 
      isPointingOk() && this.datosCalculados
      .isBlancoSetting() && this.datosCalculados
      .isPosible())
      if (!Direccion.getSingletonInstance().isLimMecanicoDerIsBad() && 
        !Direccion.getSingletonInstance().isLimMecanicoIzqIsBad()) {
        this.isBtnDisparar = true;
        return this.isBtnDisparar;
      }  
    this.isBtnDisparar = false;
    return this.isBtnDisparar;
  }
  
  private void setEstadoHMS() {
    setHMS(FuncionesCPA.HMS_Enecendido);
    this.HMS = 0;
    if (FuncionesCPA.HMS_TejaAbajo)
      if (!FuncionesCPA.HMS_ProyectilEnTeja) {
        setHMS(0);
        return;
      }  
    if (FuncionesCPA.HMS_ProyectilEnTeja) {
      setHMS(1);
    } else if (FuncionesCPA.HMS_TejaAlineada) {
      setHMS(2);
    } else if (FuncionesCPA.HMS_AtacaComp) {
      setHMS(3);
    } else {
      setHMS(0);
    } 
  }
  
  public double getOrientacion() {
    return this.orientacion;
  }
  
  public void setOrientacion(double orientacion) {
    this.orientacion = orientacion;
  }
  
  public double getElevacion() {
    return this.elevacion;
  }
  
  public void setElevacion(double elevacion) {
    this.elevacion = elevacion;
  }
  
  public boolean isSensorIzquierdo() {
    return this.isSensorIzquierdo;
  }
  
  public void setSensorIzquierdo(boolean sensorIzquierdo) {
    this.isSensorIzquierdo = sensorIzquierdo;
  }
  
  public boolean isSensorDerecho() {
    return this.isSensorDerecho;
  }
  
  public void setSensorDerecho(boolean sensorDerecho) {
    this.isSensorDerecho = sensorDerecho;
  }
  
  public boolean isCalibratedElevation() {
    return this.isCalibratedElevation;
  }
  
  public void setCalibratedElevation(boolean calibratedElevation) {
    this.isCalibratedElevation = calibratedElevation;
  }
  
  public boolean isCalibratedOrientation() {
    return this.isCalibratedOrientation;
  }
  
  public void setCalibratedOrientation(boolean calibratedOrientation) {
    this.isCalibratedOrientation = calibratedOrientation;
  }
  
  public int getHMS() {
    return this.HMS;
  }
  
  public void setHMS(int HMS) {
    this.HMS = HMS;
  }
  
  public int getIsCalibrated() {
    return this.isCalibrated;
  }
  
  public void setIsCalibrated(int isCalibrated) {
    this.isCalibrated = isCalibrated;
  }
  
  public boolean isHMS() {
    return this.isHMS;
  }
  
  public void setHMS(boolean HMS) {
    this.isHMS = HMS;
  }
  
  public boolean isCPA() {
    return this.isCPA;
  }
  
  public void setCPA(boolean bool) {
    this.isCPA = bool;
  }
  
  public void setBtnApuntar(boolean btnApuntar) {
    this.isBtnApuntar = btnApuntar;
  }
  
  public boolean isPointingOk() {
    return this.isPointingOk;
  }
  
  public void setPointingOk(boolean pointingOk) {
    this.isPointingOk = pointingOk;
  }
  
  public double getRefOrientacion() {
    return this.refOrientacion;
  }
  
  public void setRefOrientacion(double refOrientacion) {
    this.refOrientacion = refOrientacion;
  }
  
  public double getRefElevacion() {
    return this.refElevacion;
  }
  
  public void setRefElevacion(double refElevacion) {
    this.refElevacion = refElevacion;
  }
  
  public boolean isAppointindSignal() {
    return this.appointindSignal;
  }
  
  public void setAppointindSignal(boolean appointindSignal) {
    this.appointindSignal = appointindSignal;
  }
  
  public boolean isStopSignal() {
    return this.stopSignal;
  }
  
  public void setStopSignal(boolean stopSignal) {
    this.stopSignal = stopSignal;
  }
  
  public void setBtnStop(boolean btnStop) {
    this.isBtnStop = btnStop;
  }
  
  public void setBtnSeguir(boolean btnSeguir) {
    this.isBtnSeguir = btnSeguir;
  }
  
  public static CPA getSingletonInstance() {
    if (cpa == null)
      cpa = new CPA(); 
    return cpa;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\ObusHW\CPA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */