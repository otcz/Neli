package co.dynamicts.neli.core.sensors.events;

import co.dynamicts.neli.core.models.Rotation;

public class RotationChangeEvent extends AbstractEvent {
  private Rotation rotation;
  
  public RotationChangeEvent(Rotation rotation) {
    this.rotation = rotation;
  }
  
  public Rotation getRotation() {
    return this.rotation;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\RotationChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */