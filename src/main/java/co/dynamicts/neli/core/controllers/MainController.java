package co.dynamicts.neli.core.controllers;

import co.dynamicts.neli.core.models.Neli;
import co.dynamicts.neli.core.sensors.LocationSensor;
import co.dynamicts.neli.core.sensors.RotationSensor;
import co.dynamicts.neli.core.sensors.events.AbstractEvent;
import co.dynamicts.neli.core.sensors.events.Handler;
import co.dynamicts.neli.core.sensors.events.LocationChangeEvent;
import co.dynamicts.neli.core.sensors.events.RotationChangeEvent;

public class MainController implements Handler<AbstractEvent> {
  private static MainController instance;
  
  private LocationSensor locationSensor;
  
  private RotationSensor rotationSensor;
  
  private MainController() {
    this.locationSensor = new LocationSensor();
    this.rotationSensor = new RotationSensor();
    setGlobalEvents();
  }
  
  public static MainController getInstance() {
    if (instance == null)
      instance = new MainController(); 
    return instance;
  }
  
  private void setGlobalEvents() {
    this.locationSensor.addEventHandler(AbstractEvent.class, this);
    this.rotationSensor.addEventHandler(AbstractEvent.class, this);
  }
  
  public LocationSensor getLocationSensor() {
    return this.locationSensor;
  }
  
  public RotationSensor getRotationSensor() {
    return this.rotationSensor;
  }
  
  public void onEvent(AbstractEvent event) {
    if (event instanceof LocationChangeEvent) {
      Neli.getInstance().getCurrent().setPoint(((LocationChangeEvent)event).getPoint());
    } else if (event instanceof RotationChangeEvent) {
      Neli.getInstance().getCurrent().setRotation(((RotationChangeEvent)event).getRotation());
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\controllers\MainController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */