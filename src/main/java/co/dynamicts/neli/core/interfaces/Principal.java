package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.Direccion;
import co.dynamicts.neli.core.Fires.Pointing;
import co.dynamicts.neli.core.ObusHW.*;
import co.dynamicts.neli.core.models.Boletin;
import co.dynamicts.neli.core.sensors.DisplayKeys;
import co.dynamicts.neli.core.sensors.UpdateIns;
import co.dynamicts.neli.core.trayectoria.Trayectoria;
import co.dynamicts.neli.core.utilities.Actitud;
import co.dynamicts.neli.core.utilities.Posicion;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.core.utilities.Tools;

public class Principal extends Tools {
  private static Principal principal;
  
  public PuntoUTM blancoDeseadoUTM = new PuntoUTM();
  
  public Posicion posicionApuntadaKm = new Posicion();
  
  public Posicion posicionDeseadaKm = new Posicion();
  
  public Actitud actitudApuntadaGrados = new Actitud();
  
  public Actitud actitudDeseadaGrados = new Actitud();
  
  private Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private Boletin boletin = Boletin.getSingletonInstance();
  
  Ins ins = Ins.getSingletonInstance();
  
  public Trayectoria trayectoriaApuntada = new Trayectoria();
  
  public Trayectoria trayectoriaDeseada = new Trayectoria();
  
  private boolean isPosible = true;
  
  public boolean isLimitesAuto = false;
  
  private double errorProbElevacion = 0.0D;
  
  private double errorProbableAzimut = 0.0D;
  
  Tools tools = new Tools();
  
  private boolean ejecutaHilo = true;
  
  MuzzleRadar muzzleRadar;
  
  Pointing pointing = Pointing.getSingletonInstance();
  
  UpdateIns updateIns = UpdateIns.getSingletonInstance();
  
  CMS cms = CMS.getSingletonInstance();
  
  CPA cpa = CPA.getSingletonInstance();
  
  Trinca trinca = new Trinca();
  
  Direccion direccion = Direccion.getSingletonInstance();
  
  DisplayKeys displayKeys;
  
  private Principal() {
    if (!this.configuracion.isSimulado && this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
      this.muzzleRadar = MuzzleRadar.getSingletonInstance();
      this.cpa.start();
      this.muzzleRadar.start();
    } 
    if (!this.configuracion.isForPCSimulado) {
      this.displayKeys = DisplayKeys.getSingletonInstance();
      this.displayKeys.start();
    } 
    if (this.configuracion.isSimulado) {
      HWObus interfaz = new HWObus();
      interfaz.setVisible(true);
    } 
    Thread hiloIns = new Thread((Runnable)this.ins);
    hiloIns.start();
    this.pointing.start();
    this.direccion.start();
    this.updateIns.start();
  }
  
  public boolean isLimitesAuto() {
    return this.isLimitesAuto;
  }
  
  public void setLimitesAuto(boolean limitesAuto) {
    this.isLimitesAuto = limitesAuto;
  }
  
  public boolean isPosible() {
    return this.isPosible;
  }
  
  public void setPosible(boolean posible) {
    this.isPosible = posible;
  }
  
  public double getErrorProbElevacion() {
    return this.errorProbElevacion;
  }
  
  public void setErrorProbElevacion(double errorProbElevacion) {
    this.errorProbElevacion = errorProbElevacion;
  }
  
  public double getErrorProbableAzimut() {
    return this.errorProbableAzimut;
  }
  
  public void setErrorProbableAzimut(double errorProbableAzimut) {
    this.errorProbableAzimut = errorProbableAzimut;
  }
  
  public boolean isEjecutaHilo() {
    return this.ejecutaHilo;
  }
  
  public void setEjecutaHilo(boolean ejecutaHilo) {
    this.ejecutaHilo = ejecutaHilo;
  }
  
  public MuzzleRadar getMuzzleRadar() {
    return this.muzzleRadar;
  }
  
  public static Principal getSingletonInstance() {
    if (principal == null)
      principal = new Principal(); 
    return principal;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\Principal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */