package co.dynamicts.neli.core.local.model;

import com.j256.ormlite.field.DatabaseField;

public class RadarHistory {
  @DatabaseField(id = true)
  private String date;
  
  @DatabaseField(canBeNull = false)
  private String ammo;
  
  @DatabaseField(canBeNull = false)
  private String effect;
  
  @DatabaseField(canBeNull = false)
  private String fuse;
  
  @DatabaseField(canBeNull = false)
  private int zone;
  
  @DatabaseField(canBeNull = false)
  private double temperature;
  
  @DatabaseField(canBeNull = false)
  private double velocity;
  
  public String getDate() {
    return this.date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public String getAmmo() {
    return this.ammo;
  }
  
  public void setAmmo(String ammo) {
    this.ammo = ammo;
  }
  
  public String getEffect() {
    return this.effect;
  }
  
  public void setEffect(String effect) {
    this.effect = effect;
  }
  
  public String getFuse() {
    return this.fuse;
  }
  
  public void setFuse(String fuse) {
    this.fuse = fuse;
  }
  
  public int getZone() {
    return this.zone;
  }
  
  public void setZone(int zone) {
    this.zone = zone;
  }
  
  public double getTemperature() {
    return this.temperature;
  }
  
  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }
  
  public double getVelocity() {
    return this.velocity;
  }
  
  public void setVelocity(double velocity) {
    this.velocity = velocity;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\RadarHistory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */