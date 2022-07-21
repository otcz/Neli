package co.dynamicts.neli.core.sensors;

import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.models.Rotation;
import co.dynamicts.neli.core.sensors.events.Event;
import co.dynamicts.neli.core.sensors.events.EventDispatcher;
import co.dynamicts.neli.core.sensors.events.RotationChangeEvent;
import javafx.application.Platform;

public class RotationSensor extends EventDispatcher implements Runnable {
  private Rotation rotation;
  
  final CPA cpa = CPA.getSingletonInstance();
  
  Ins ins;
  
  public RotationSensor() {
    this.ins = Ins.getSingletonInstance();
    this.rotation = new Rotation(1000.0D, 5.0D, 0.0D);
    (new Thread(this)).start();
  }
  
  public void run() {
    synchronized (this) {
      while (true) {
        if ((Configuracion.getSingletonInstance()).municion.zonaSelec.getVelBocaStd() != 0.0D) {
          DatosApuntados.getSingletonInstance().calcularDatosPorActitudApuntada();
          randomize();
          Platform.runLater(() -> dispatch((Event)new RotationChangeEvent(this.rotation)));
        } 
      } 
    } 
  }
  
  private void randomize() {
    this.rotation.setAzimuth(this.ins.actitud.getAzimut());
    this.rotation.setElevation(this.ins.actitud.getElevacion());
    this.rotation.setWarp(this.ins.actitud.getAlabeo());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\RotationSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */