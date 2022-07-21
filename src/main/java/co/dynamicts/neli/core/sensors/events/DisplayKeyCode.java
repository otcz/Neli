package co.dynamicts.neli.core.sensors.events;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public enum DisplayKeyCode {
  DKF1(10, "DKF1", 1),
  DKF2(10, "DKF2", 1),
  DKF3(10, "DKF3", 1),
  DKF4(10, "DKF4", 1),
  DKF5(10, "DKF5", 1),
  DKF6(10, "DKF6", 1),
  DKF7(10, "DKF7", 1),
  DKF8(10, "DKF8", 1),
  DKF9(10, "DKF9", 1),
  DKF10(10, "DKF10", 1),
  DKF11(10, "DKF11", 1),
  DKF12(10, "DKF12", 1),
  UNDEFINED(0, "Undefined",0);
  
  final int code;
  
  final String ch;
  
  final String name;
  
  private int mask;
  
  private static final Map<String, DisplayKeyCode> nameMap;
  
  private static class KeyCodeClass {
    private static final int FUNCTION = 1;
    
    private static final int NAVIGATION = 2;
    
    private static final int ARROW = 4;
    
    private static final int MODIFIER = 8;
    
    private static final int LETTER = 16;
    
    private static final int DIGIT = 32;
    
    private static final int KEYPAD = 64;
    
    private static final int WHITESPACE = 128;
    
    private static final int MEDIA = 256;
  }
  
  DisplayKeyCode(int code, String name, int mask) {
    this.code = code;
    this.name = name;
    this.mask = mask;
    this.ch = String.valueOf((char)code);
  }
  
  public final boolean isFunctionKey() {
    return ((this.mask & 0x1) != 0);
  }
  
  public final String getName() {
    return this.name;
  }
  
  static {
    nameMap = new HashMap<>((KeyCode.values()).length);
    for (DisplayKeyCode c : values())
      nameMap.put(c.name, c); 
  }
  
  public static DisplayKeyCode getKeyCode(String name) {
    return nameMap.get(name);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\events\DisplayKeyCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */