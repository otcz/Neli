package co.dynamicts.neli.core.models;

import co.dynamicts.neli.core.utilities.Number;

import java.util.Objects;

public class Longitude {
  public static final String NORTH = "N";
  
  public static final String SOUTH = "S";
  
  private double value;
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    Longitude longitude = (Longitude)o;
    return (Double.compare(longitude.value, this.value) == 0);
  }
  
  public int hashCode() {
    return Objects.hash(new Object[] { Double.valueOf(this.value) });
  }
  
  public Longitude(double value) {
    setValue(value);
  }
  
  public double getValue() {
    return this.value;
  }
  
  public void setValue(double value) {
    this.value = ((Double)Number.limit(Double.valueOf(value), Double.valueOf(-90.0D), Double.valueOf(90.0D))).doubleValue();
  }
  
  public String getHemisphere() {
    if (this.value < 0.0D)
      return "S"; 
    return "N";
  }
  
  public int getDegrees() {
    return (int)Math.abs(Math.floor(this.value));
  }
  
  public int getMinutes() {
    return (int)((Math.abs(this.value) - getDegrees()) * 60.0D);
  }
  
  public double getSeconds() {
    return Number.round((Math.abs(this.value) - getDegrees() - getMinutes() / 60.0D) * 3600.0D, 2);
  }
  
  public String toString() {
    return "Longitude{value=" + this.value + '}';
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Longitude.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */