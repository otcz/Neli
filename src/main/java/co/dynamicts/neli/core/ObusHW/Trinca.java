package co.dynamicts.neli.core.ObusHW;

public class Trinca {
  private static Trinca trinca;
  
  private double canonDirection = 0.0D;
  
  private double vehicleDirection = 0.0D;
  
  private boolean isTrincaPut = true;
  
  private boolean isTrincaForzada = false;
  
  public double getVehicleDirection() {
    if (!isTrincaPut()) {
      this.vehicleDirection = 0.0D;
    } else if (isTrincaPut() && isTrincaForzada()) {
      this.vehicleDirection = 3200.0D;
    } else if (isTrincaPut() && !isTrincaForzada()) {
      this.vehicleDirection = 3200.0D;
    } 
    return this.canonDirection;
  }
  
  public double getCanonDirection() {
    if (!isTrincaPut()) {
      this.canonDirection = 0.0D;
    } else if (isTrincaPut() && this.isTrincaForzada == true) {
      this.canonDirection = 3200.0D;
    } else if (isTrincaPut() && !this.isTrincaForzada) {
      this.canonDirection = 0.0D;
    } 
    return this.canonDirection;
  }
  
  public boolean isTrincaPut() {
    return this.isTrincaPut;
  }
  
  public void setTrincaPut(boolean trincaPut) {
    this.isTrincaPut = trincaPut;
  }
  
  public boolean isTrincaForzada() {
    return this.isTrincaForzada;
  }
  
  public void setTrincaForzada(boolean trincaForzada) {
    this.isTrincaForzada = trincaForzada;
  }
  
  public static Trinca getSingletonInstance() {
    if (trinca == null)
      trinca = new Trinca(); 
    return trinca;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\ObusHW\Trinca.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */