package co.dynamicts.neli.core.models;

import co.dynamicts.neli.core.utilities.Number;

import java.util.Objects;

public class Latitude {
  public static final String WEST = "W";
  
  public static final String EAST = "E";
  
  private double value;
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    Latitude latitude = (Latitude)o;
    return (Double.compare(latitude.value, this.value) == 0);
  }
  
  public int hashCode() {
    return Objects.hash(new Object[] { Double.valueOf(this.value) });
  }
  
  public Latitude(double value) {
    setValue(value);
  }
  
  public double getValue() {
    return this.value;
  }
  
  public void setValue(double value) {
    this.value = ((Double)Number.limit(Double.valueOf(value), Double.valueOf(-180.0D), Double.valueOf(180.0D))).doubleValue();
  }
  
  public String getHemisphere() {
    if (this.value < 0.0D)
      return "W"; 
    return "E";
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
    return "Latitude{value=" + this.value + '}';
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Latitude.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */