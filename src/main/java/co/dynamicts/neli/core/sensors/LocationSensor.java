package co.dynamicts.neli.core.sensors;

import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.models.Latitude;
import co.dynamicts.neli.core.models.Longitude;
import co.dynamicts.neli.core.models.Point;
import co.dynamicts.neli.core.sensors.events.Event;
import co.dynamicts.neli.core.sensors.events.EventDispatcher;
import co.dynamicts.neli.core.sensors.events.LocationChangeEvent;
import javafx.application.Platform;

public class LocationSensor extends EventDispatcher implements Runnable {
  private Point point;
  
  private Ins ins;
  
  public LocationSensor() {
    this.ins = Ins.getSingletonInstance();
    this.point = new Point(new Latitude(24.789D), new Longitude(4.23D), 1600);
    (new Thread(this)).start();
  }
  
  public void run() {
    synchronized (this) {
      while (true) {
        try {
          Thread.sleep(100L);
          Point lastKnownPoint = getLastLocationPoint();
          if (!lastKnownPoint.equals(this.point)) {
            this.point = lastKnownPoint;
            Platform.runLater(() -> dispatch((Event)new LocationChangeEvent(this.point)));
          } 
        } catch (InterruptedException ie) {
          System.out.println(ie);
          break;
        } 
      } 
      return;
    } 
  }
  
  private Point getLastLocationPoint() {
    return new Point(new Latitude(this.ins.obus.getLatitud()), new Longitude(this.ins.obus.getLongitud()), (int)this.ins.obus.getAltura());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\LocationSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */