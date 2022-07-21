package co.dynamicts.neli.core.sensors.events;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {
  private Map<Class<? extends Event>, Handler<? extends Event>> handlers = new HashMap<>();
  
  public <E extends Event> void addEventHandler(Class<E> eventType, Handler<E> handler) {
    this.handlers.put(eventType, handler);
  }
  
  public <E extends Event> void dispatch(E event) {
    Handler<E> handler = (Handler<E>)this.handlers.get(event.getClass());
    if (handler != null)
      handler.onEvent(event); 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\EventDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */