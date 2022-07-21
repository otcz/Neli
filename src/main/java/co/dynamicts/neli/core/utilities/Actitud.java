package co.dynamicts.neli.core.utilities;

import co.dynamicts.neli.core.ObusHW.Ins;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Actitud implements Observer {
  double azimut;
  
  double elevacion;
  
  double alabeo;
  
  Timer temporizador = new Timer();
  
  public double getAzimut() {
    return this.azimut;
  }
  
  public void setAzimut(double azimut) {
    this.azimut = restringeValores(azimut, 6400.0D, 0.0D);
  }
  
  public double getElevacion() {
    return this.elevacion;
  }
  
  public void setElevacion(double elevacion) {
    this.elevacion = elevacion;
  }
  
  public double getAlabeo() {
    return this.alabeo;
  }
  
  public void setAlabeo(double alabeo) {
    this.alabeo = alabeo;
  }
  
  public double restringeValores(double valor, double valorMaximo, double valorMinimo) {
    if (valor > valorMaximo) {
      valor -= valorMaximo;
    } else if (valor < valorMinimo) {
      valor += valorMaximo;
    } 
    return valor;
  }
  
  public void update(Observable o, Object arg) {
    if (arg instanceof Ins.ActitudEvent) {
      Ins.ActitudEvent evento = (Ins.ActitudEvent)arg;
      Ins.getSingletonInstance().setNumberOscilating(Ins.getSingletonInstance().getNumberOscilating() + 1);
    } else {
      Ins.getSingletonInstance().setNumberOscilating(Ins.getSingletonInstance().getNumberOscilating() - 1);
    } 
  }
  
  TimerTask tarea = new TimerTask() {
      public void run() {
        System.out.println("Conexion perdida");
      }
    };
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\Actitud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */