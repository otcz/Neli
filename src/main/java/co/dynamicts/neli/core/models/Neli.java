package co.dynamicts.neli.core.models;

public class Neli {
  private Cannon current = new Cannon();
  
  private Cannon pointed = new Cannon();
  
  private static Neli instance;
  
  public static Neli getInstance() {
    if (instance == null)
      instance = new Neli(); 
    return instance;
  }
  
  public Cannon getCurrent() {
    return this.current;
  }
  
  public Cannon getPointed() {
    return this.pointed;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Neli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */