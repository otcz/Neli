package co.dynamicts.neli.core.local.model;

import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Point {
  @DatabaseField(id = true)
  private String name;
  
  @DatabaseField(canBeNull = false)
  private double obusLatitude;
  
  @DatabaseField(canBeNull = false)
  private double obusLongitude;
  
  @DatabaseField(canBeNull = false)
  private double obusHeight;
  
  @DatabaseField(canBeNull = false)
  private double targetLatitude;
  
  @DatabaseField(canBeNull = false)
  private double targetLongitude;
  
  @DatabaseField(canBeNull = false)
  private double targetHeight;
  
  @DatabaseField(canBeNull = false)
  private boolean isActive;
  
  @DatabaseField(canBeNull = false)
  private double distance;
  
  @DatabaseField(canBeNull = false)
  private double azimuth;
  
  @DatabaseField(canBeNull = false)
  private double interval;
  
  @DatabaseField(dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss")
  private Date date;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public double getObusLatitude() {
    return this.obusLatitude;
  }
  
  public void setObusLatitude(double obusLatitude) {
    this.obusLatitude = obusLatitude;
  }
  
  public double getObusLongitude() {
    return this.obusLongitude;
  }
  
  public void setObusLongitude(double obusLongitude) {
    this.obusLongitude = obusLongitude;
  }
  
  public double getObusHeight() {
    return this.obusHeight;
  }
  
  public void setObusHeight(double obusHeight) {
    this.obusHeight = obusHeight;
  }
  
  public double getTargetLatitude() {
    return this.targetLatitude;
  }
  
  public void setTargetLatitude(double targetLatitude) {
    this.targetLatitude = targetLatitude;
  }
  
  public double getTargetLongitude() {
    return this.targetLongitude;
  }
  
  public void setTargetLongitude(double targetLongitude) {
    this.targetLongitude = targetLongitude;
  }
  
  public double getTargetHeight() {
    return this.targetHeight;
  }
  
  public void setTargetHeight(double targetHeight) {
    this.targetHeight = targetHeight;
  }
  
  public boolean isActive() {
    return this.isActive;
  }
  
  public void setActive(boolean active) {
    this.isActive = active;
  }
  
  public double getDistance() {
    if (Configuracion.getSingletonInstance().getUnidadDistancia().equals(Configuracion.UnidadDistancia.KILOMETROS))
      return DataTools.limitaDecimales(DataTools.convierteMetros_a_Km(this.distance)); 
    return DataTools.limitaDecimales(this.distance);
  }
  
  public void setDistance(double distance) {
    this.distance = distance;
  }
  
  public double getAzimuth() {
    if (Configuracion.getSingletonInstance().getUnidadAngulo().equals(Configuracion.UnidadAngulo.GRADOS))
      return DataTools.limitaDecimales(DataTools.convierteMilesimas_a_Grados(this.azimuth)); 
    return DataTools.limitaDecimales(this.azimuth);
  }
  
  public void setAzimuth(double azimuth) {
    this.azimuth = azimuth;
  }
  
  public double getInterval() {
    if (Configuracion.getSingletonInstance().getUnidadDistancia().equals(Configuracion.UnidadDistancia.KILOMETROS))
      return DataTools.limitaDecimales(DataTools.convierteMetros_a_Km(this.interval)); 
    return DataTools.limitaDecimales(this.interval);
  }
  
  public void setInterval(double interval) {
    this.interval = interval;
  }
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public String getTargetCoordinates() {
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLongitud(this.targetLongitude, true);
    puntoGeograficas.setLatitud(this.targetLatitude, true);
    puntoGeograficas.setAltura(this.targetHeight);
    return DataTools.toStringPoint(puntoGeograficas, Configuracion.getSingletonInstance().getUnidadCoordenadas());
  }
  
  public String getObusCoordinates() {
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLongitud(this.obusLongitude, true);
    puntoGeograficas.setLatitud(this.obusLatitude, true);
    puntoGeograficas.setAltura(this.obusHeight);
    return DataTools.toStringPoint(puntoGeograficas, Configuracion.getSingletonInstance().getUnidadCoordenadas());
  }
  
  public String getTargetCoordinatesFromDB() {
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLongitud(this.targetLongitude, true);
    puntoGeograficas.setLatitud(this.targetLatitude, true);
    puntoGeograficas.setAltura(this.targetHeight);
    return DataTools.toCoordinatePoint(puntoGeograficas, Configuracion.getSingletonInstance().getUnidadCoordenadas());
  }
  
  public String getObusCoordinatesFromDB() {
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLongitud(this.obusLongitude, true);
    puntoGeograficas.setLatitud(this.obusLatitude, true);
    puntoGeograficas.setAltura(this.obusHeight);
    return DataTools.toCoordinatePoint(puntoGeograficas, Configuracion.getSingletonInstance().getUnidadCoordenadas());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Point.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */