package co.dynamicts.neli.core.models;

import co.dynamicts.neli.core.utilities.Number;

import java.util.Objects;

public class Point {
  private Latitude latitude;
  
  private Longitude longitude;
  
  private int height;
  
  public Point() {
    setLatitude(new Latitude(0.0D));
    setLongitude(new Longitude(0.0D));
    setHeight(0);
  }
  
  public Point(Latitude latitude, Longitude longitude, int height) {
    setLatitude(latitude);
    setLongitude(longitude);
    setHeight(height);
  }
  
  public Point(String hemisphere, int zone) {}
  
  public Latitude getLatitude() {
    return this.latitude;
  }
  
  public void setLatitude(Latitude latitude) {
    this.latitude = latitude;
  }
  
  public Longitude getLongitude() {
    return this.longitude;
  }
  
  public void setLongitude(Longitude longitude) {
    this.longitude = longitude;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public void setHeight(int height) {
    this.height = ((Integer)Number.limit(Integer.valueOf(height), Integer.valueOf(0), Integer.valueOf(9999))).intValue();
  }
  
  public String getUTM() {
    return "";
  }
  
  public String getUTMZone() {
    return "";
  }
  
  public String getUTMHemisphere() {
    return "";
  }
  
  public String toString() {
    return "Point{latitude=" + this.latitude
      .toString() + ", longitude=" + this.longitude
      .toString() + ", height=" + this.height + '}';
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    Point point = (Point)o;
    return (this.height == point.height && this.latitude
      .equals(point.latitude) && this.longitude
      .equals(point.longitude));
  }
  
  public int hashCode() {
    return Objects.hash(new Object[] { this.latitude, this.longitude, Integer.valueOf(this.height) });
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Point.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */