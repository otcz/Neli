package co.dynamicts.neli.core.ObusHW;

import co.dynamicts.neli.core.Hardware.InsEthernet;
import co.dynamicts.neli.core.Hardware.InsSerial;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.models.Rotation;
import co.dynamicts.neli.core.sensors.events.EventDispatcher;
import co.dynamicts.neli.core.utilities.Actitud;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.core.utilities.Time;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Ins extends EventDispatcher implements Runnable {
  private static Ins ins;
  
  public TipoComunicacion tipoComunicacion;
  
  public EstadoGPS estadoGPS;
  
  public EstadoINS estadoINS;
  
  public enum TipoComunicacion {
    ETHERNET, RS422;
  }
  
  public enum EstadoGPS {
    CONNECTED_OK, CONNECTED_MEDIUM, DISCONNECTED;
  }
  
  public enum EstadoINS {
    CONNECTED_OK, CONNECTED_DISALIGMENT, DISCONNECTED;
  }
  
  public Time timeOn = new Time();
  
  private Configuracion configuracion = Configuracion.getSingletonInstance();
  
  InsEthernet insEthernet = InsEthernet.getSingletonInstance(this.configuracion.isSimulado);
  
  InsSerial insSerial;
  
  private boolean isOscilating;
  
  private int numberOscilating = 0;
  
  private Rotation rotation;
  
  private boolean isZuptTiro = false;
  
  private boolean isOdo = false;
  
  private boolean isForcedCoordinates = false;
  
  public Actitud actitud = new Actitud();
  
  public PuntoGeograficas obus = new PuntoGeograficas();
  
  public PuntoGeograficas obusForzado = new PuntoGeograficas();
  
  public PuntoUTM obusUTMForzado = new PuntoUTM();
  
  public PuntoUTM obusUTM = new PuntoUTM();
  
  public PuntoGeograficas obusGPS = new PuntoGeograficas();
  
  public PuntoUTM obusUTM_GPS = new PuntoUTM();
  
  double magneticOrientation = 0.0D;
  
  DataInputStream entradaCliente;
  
  public Ins() throws IOException {
    if (this.configuracion.isEthernet) {
      this.tipoComunicacion = TipoComunicacion.ETHERNET;
    } else {
      this.tipoComunicacion = TipoComunicacion.RS422;
    } 
  }
  
  public void run() {
    getObservable().addObserver((Observer)this.actitud);
    while (true) {
      while (this.tipoComunicacion == TipoComunicacion.ETHERNET)
        updateInsEthernet(); 
      if (this.tipoComunicacion == TipoComunicacion.RS422)
        updateInsSerial(); 
    } 
  }
  
  private static final ActitudObservable OBSERVABLE = new ActitudObservable();
  
  public static Observable getObservable() {
    return OBSERVABLE;
  }
  
  private void updateInsEthernet() {
    this.insEthernet.updateInsEhernet();
    setZuptTiro(this.insEthernet.isZuptTiro());
    setOdo(this.insEthernet.isOdo());
    this.estadoINS = this.insEthernet.estadoINS;
    this.estadoGPS = this.insEthernet.estadoGPS;
    this.timeOn = this.insEthernet.timeOn;
    setMagneticOrientation(this.insEthernet.getMagneticOrientation());
    this.insEthernet.obusForzado = this.obusForzado;
    this.insEthernet.obusUTMForzado = this.obusUTMForzado;
    this.insEthernet.setForcedCoordinates(isForcedCoordinates());
    setActitud(this.insEthernet.actitud);
    this.obus = this.insEthernet.obusGeo;
    this.obusUTM = this.insEthernet.obusUTM;
    this.obusGPS = this.insEthernet.gpsGeo;
    this.obusUTM_GPS = this.insEthernet.gpsUTM;
  }
  
  private void updateInsSerial() {
    this.insSerial = InsSerial.getSingletonInstance();
    this.insSerial.updateInsSerial();
    setZuptTiro(this.insSerial.isZuptTiro());
    setOdo(this.insSerial.PulsosADetectados);
    this.estadoINS = this.insSerial.estadoINS;
    this.estadoGPS = this.insSerial.estadoGPS;
    this.timeOn.setHour(this.insSerial.hora);
    this.timeOn.setMinutes(this.insSerial.minuto);
    this.timeOn.setSeconds((int)this.insSerial.segundo);
    setMagneticOrientation(this.insSerial.getMagneticOrientation());
    this.insSerial.FijarPosicionGPSManual(this.isForcedCoordinates, this.obusForzado
        .getLatitud(), this.obusForzado
        .getLongitud(), this.obusForzado
        .getAltura(), 2.0F, 2.0F, 2.0F);
    setActitud(this.insSerial.actitud);
    this.obus = this.insSerial.obusGeo;
    this.obusUTM = this.insSerial.obusUTM;
    this.obusGPS = this.insSerial.gpsGeo;
    this.obusUTM_GPS = this.insSerial.gpsUTM;
  }
  
  public boolean isZuptTiro() {
    return this.isZuptTiro;
  }
  
  public void setZuptTiro(boolean zuptTiro) {
    this.isZuptTiro = zuptTiro;
  }
  
  public boolean isOdo() {
    return this.isOdo;
  }
  
  public void setOdo(boolean odo) {
    this.isOdo = odo;
  }
  
  public void setActitud(Actitud actitud) {
    ActitudEvent event = new ActitudEvent(this.actitud, actitud);
    this.actitud = actitud;
    synchronized (OBSERVABLE) {
      OBSERVABLE.setChanged();
      OBSERVABLE.notifyObservers(event);
    } 
  }
  
  public double getMagneticOrientation() {
    return this.magneticOrientation;
  }
  
  public void setMagneticOrientation(double magneticOrientation) {
    this.magneticOrientation = magneticOrientation;
  }
  
  public boolean isForcedCoordinates() {
    return this.isForcedCoordinates;
  }
  
  public void setForcedCoordinates(boolean forcedCoordinates) {
    this.isForcedCoordinates = forcedCoordinates;
  }
  
  public boolean isOscilating() {
    return this.isOscilating;
  }
  
  public void setOscilating(boolean oscilating) {
    this.isOscilating = oscilating;
  }
  
  public int getNumberOscilating() {
    return this.numberOscilating;
  }
  
  public void setNumberOscilating(int numberOscilating) {
    this.numberOscilating = numberOscilating;
  }
  
  public static Ins getSingletonInstance() {
    if (ins == null)
      try {
        ins = new Ins();
      } catch (IOException e) {
        e.printStackTrace();
      }  
    return ins;
  }
  
  public class ActitudEvent {
    private Actitud actitudAntiguo;
    
    private Actitud actitudNuevo;
    
    public ActitudEvent(Actitud actitudAntiguo, Actitud actitudNuevo) {
      this.actitudAntiguo = actitudAntiguo;
      this.actitudNuevo = actitudNuevo;
    }
  }
  
  private static class ActitudObservable extends Observable {
    private ActitudObservable() {}
    
    public synchronized void setChanged() {
      super.setChanged();
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\ObusHW\Ins.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */