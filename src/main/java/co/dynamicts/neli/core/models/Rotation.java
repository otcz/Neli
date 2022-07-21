package co.dynamicts.neli.core.models;

import co.dynamicts.neli.core.utilities.Number;

public class Rotation {
  private double azimuth;
  
  private double elevation;
  
  private double warp;
  
  public Rotation() {
    setAzimuth(0.0D);
    setElevation(0.0D);
    setWarp(0.0D);
  }
  
  public Rotation(double azimuth, double elevation, double warp) {
    setAzimuth(azimuth);
    setElevation(elevation);
    setWarp(warp);
  }
  
  public double getAzimuth() {
    return this.azimuth;
  }
  
  public void setAzimuth(double azimuth) {
    this.azimuth = ((Double)Number.limit(Double.valueOf(azimuth), Double.valueOf(0.0D), Double.valueOf(6400.0D))).doubleValue();
  }
  
  public double getElevation() {
    return this.elevation;
  }
  
  public void setElevation(double elevation) {
    this.elevation = elevation;
  }
  
  public double getWarp() {
    return this.warp;
  }
  
  public void setWarp(double warp) {
    this.warp = warp;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Rotation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */