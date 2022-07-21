package co.dynamicts.neli.core.municion;

public class Espoleta {
  private String Nombre;
  
  private double peso;
  
  private String efecto;
  
  public Espoleta(String nombre, double peso, String efecto) {
    this.Nombre = nombre;
    this.peso = peso;
    this.efecto = efecto;
  }
  
  public Espoleta() {}
  
  public String getNombre() {
    return this.Nombre;
  }
  
  public void setNombre(String nombre) {
    this.Nombre = nombre;
  }
  
  public double getPeso() {
    return this.peso;
  }
  
  public void setPeso(double peso) {
    this.peso = peso;
  }
  
  public String getEfecto() {
    return this.efecto;
  }
  
  public void setEfecto(String efecto) {
    this.efecto = efecto;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\municion\Espoleta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */