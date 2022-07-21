package co.dynamicts.neli.core.sensors.events;

public abstract class AbstractEvent implements Event {
  public Class<? extends Event> getType() {
    return (Class)getClass();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\AbstractEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */