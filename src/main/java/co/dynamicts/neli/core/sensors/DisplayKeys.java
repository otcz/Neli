package co.dynamicts.neli.core.sensors;

import co.dynamicts.neli.ui.block.MenuNavBlock;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import javafx.application.Platform;

public class DisplayKeys extends Thread {
  private static DisplayKeys displayKeys;
  
  UmsDLL umsdll = UmsDLL.INSTANCE;
  
  public DisplayKeys() {
    Pointer pUms = this.umsdll.UmsOpenUMS(null);
  }
  
  public void run() {
    startClient();
  }
  
  public void startClient() {
    while (true) {
      try {
        while (true) {
          Thread.sleep(10L);
          this.umsdll.UmsInitButtonCallback(new UmsDLL.eventCallback() {
              
              },  null);
        } 

      } catch (InterruptedException e) {
        System.out.println("e = " + e);
        e.printStackTrace();
      } 
    } 
  }
  
  public static interface UmsDLL extends Library {
    public static final UmsDLL INSTANCE = (UmsDLL)Native.loadLibrary("C:\\ums.dll", UmsDLL.class);
    
    Pointer UmsOpenUMS(String param1String);
    
    void UmsCloseUMS(Pointer param1Pointer);
    
    int UmsGetOnCounter(Pointer param1Pointer, IntByReference param1IntByReference);
    
    int UmsGetLibVersion(IntByReference param1IntByReference, String param1String);
    
    int UmsGetMBTemperature(Pointer param1Pointer, IntByReference param1IntByReference);
    
    void UmsInitButtonCallback(eventCallback param1eventCallback, Pointer param1Pointer);
    
    public static interface eventCallback extends Callback {
      static void ButtonCallback(int ButtonCode) {
        int code = -1;
        switch (ButtonCode) {
          case 256:
            code = 0;
            break;
          case 512:
            code = 1;
            break;
          case 1024:
            code = 2;
            break;
          case 2048:
            code = 3;
            break;
          case 4096:
            code = 4;
            break;
          case 8192:
            code = 5;
            break;
          case 1:
            code = 6;
            break;
          case 2:
            code = 7;
            break;
          case 4:
            code = 8;
            break;
          case 8:
            code = 9;
            break;
          case 16:
            code = 10;
            break;
          case 32:
            code = 11;
            break;
        } 
        int finalCode = code;
        Platform.runLater(() -> {
              MenuNavBlock menuNavBlock = new MenuNavBlock();
              menuNavBlock.processKeyCode(finalCode);
            });
      }
    }
  }
  
  public static interface eventCallback extends Callback {
    static void ButtonCallback(int ButtonCode) {
      int code = -1;
      switch (ButtonCode) {
        case 256:
          code = 0;
          break;
        case 512:
          code = 1;
          break;
        case 1024:
          code = 2;
          break;
        case 2048:
          code = 3;
          break;
        case 4096:
          code = 4;
          break;
        case 8192:
          code = 5;
          break;
        case 1:
          code = 6;
          break;
        case 2:
          code = 7;
          break;
        case 4:
          code = 8;
          break;
        case 8:
          code = 9;
          break;
        case 16:
          code = 10;
          break;
        case 32:
          code = 11;
          break;
      } 
      int finalCode = code;
      Platform.runLater(() -> {
            MenuNavBlock menuNavBlock = new MenuNavBlock();
            menuNavBlock.processKeyCode(finalCode);
          });
    }
  }
  
  public static DisplayKeys getSingletonInstance() {
    if (displayKeys == null)
      displayKeys = new DisplayKeys(); 
    return displayKeys;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\DisplayKeys.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */