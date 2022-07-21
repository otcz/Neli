package co.dynamicts.neli.core.sensors.events;

import co.dynamicts.neli.core.models.Point;

public class LocationChangeEvent extends AbstractEvent {
  private Point point;
  
  public LocationChangeEvent(Point point) {
    this.point = point;
  }
  
  public Point getPoint() {
    return this.point;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\LocationChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */