package co.dynamicts.neli.core.sensors.events;

import com.sun.javafx.tk.Toolkit;
import javafx.beans.NamedArg;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;

public class DisplayKeyEvent extends InputEvent {
  private static final long serialVersionUID = 25123107L;
  
  public static final EventType<DisplayKeyEvent> ANY = (EventType)new EventType<>(InputEvent.ANY, "KEY");
  
  public static final EventType<DisplayKeyEvent> KEY_PRESSED = new EventType<>(ANY, "KEY_PRESSED");
  
  public static final EventType<DisplayKeyEvent> KEY_RELEASED = new EventType<>(ANY, "KEY_RELEASED");
  
  public static final EventType<DisplayKeyEvent> KEY_TYPED = new EventType<>(ANY, "KEY_TYPED");
  
  public DisplayKeyEvent(@NamedArg("eventType") EventType<DisplayKeyEvent> eventType, @NamedArg("character") String character, @NamedArg("text") String text, @NamedArg("code") DisplayKeyCode code, @NamedArg("shiftDown") boolean shiftDown, @NamedArg("controlDown") boolean controlDown, @NamedArg("altDown") boolean altDown, @NamedArg("metaDown") boolean metaDown) {
    super((EventType)eventType);
    boolean isKeyTyped = (eventType == KEY_TYPED);
    this.character = isKeyTyped ? character : CHAR_UNDEFINED;
    this.text = isKeyTyped ? "" : text;
    this.code = isKeyTyped ? DisplayKeyCode.UNDEFINED : code;
    this.shiftDown = shiftDown;
    this.controlDown = controlDown;
    this.altDown = altDown;
    this.metaDown = metaDown;
  }
  
  public DisplayKeyEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget target, @NamedArg("eventType") EventType<DisplayKeyEvent> eventType, @NamedArg("character") String character, @NamedArg("text") String text, @NamedArg("code") DisplayKeyCode code, @NamedArg("shiftDown") boolean shiftDown, @NamedArg("controlDown") boolean controlDown, @NamedArg("altDown") boolean altDown, @NamedArg("metaDown") boolean metaDown) {
    super(source, target, (EventType)eventType);
    boolean isKeyTyped = (eventType == KEY_TYPED);
    this.character = isKeyTyped ? character : CHAR_UNDEFINED;
    this.text = isKeyTyped ? "" : text;
    this.code = isKeyTyped ? DisplayKeyCode.UNDEFINED : code;
    this.shiftDown = shiftDown;
    this.controlDown = controlDown;
    this.altDown = altDown;
    this.metaDown = metaDown;
  }
  
  public static final String CHAR_UNDEFINED = DisplayKeyCode.UNDEFINED.ch;
  
  private final String character;
  
  private final String text;
  
  private final DisplayKeyCode code;
  
  private final boolean shiftDown;
  
  private final boolean controlDown;
  
  private final boolean altDown;
  
  private final boolean metaDown;
  
  public final String getCharacter() {
    return this.character;
  }
  
  public final String getText() {
    return this.text;
  }
  
  public final DisplayKeyCode getCode() {
    return this.code;
  }
  
  public final boolean isShiftDown() {
    return this.shiftDown;
  }
  
  public final boolean isControlDown() {
    return this.controlDown;
  }
  
  public final boolean isAltDown() {
    return this.altDown;
  }
  
  public final boolean isMetaDown() {
    return this.metaDown;
  }
  
  public final boolean isShortcutDown() {
    switch (Toolkit.getToolkit().getPlatformShortcutKey()) {
      case SHIFT:
        return this.shiftDown;
      case CONTROL:
        return this.controlDown;
      case ALT:
        return this.altDown;
      case META:
        return this.metaDown;
    } 
    return false;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder("KeyEvent [");
    sb.append("source = ").append(getSource());
    sb.append(", target = ").append(getTarget());
    sb.append(", eventType = ").append(getEventType());
    sb.append(", consumed = ").append(isConsumed());
    sb.append(", character = ").append(getCharacter());
    sb.append(", text = ").append(getText());
    sb.append(", code = ").append(getCode());
    if (isShiftDown())
      sb.append(", shiftDown"); 
    if (isControlDown())
      sb.append(", controlDown"); 
    if (isAltDown())
      sb.append(", altDown"); 
    if (isMetaDown())
      sb.append(", metaDown"); 
    if (isShortcutDown())
      sb.append(", shortcutDown"); 
    return sb.append("]").toString();
  }
  
  public DisplayKeyEvent copyFor(Object newSource, EventTarget newTarget) {
    return (DisplayKeyEvent)super.copyFor(newSource, newTarget);
  }
  
  public DisplayKeyEvent copyFor(Object source, EventTarget target, EventType<DisplayKeyEvent> type) {
    DisplayKeyEvent e = copyFor(source, target);
    e.eventType = (EventType)type;
    return e;
  }
  
  public EventType<DisplayKeyEvent> getEventType() {
    return (EventType)super.getEventType();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\DisplayKeyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */