package co.dynamicts.neli.ui.utils;

import co.dynamicts.neli.core.local.model.*;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.ui.interfaces.Limits;

import java.util.ResourceBundle;

public class AppConfig {
  private static AppConfig instance = new AppConfig();
  
  public static final String MODE_GEO = "GEOGRAPHICAL";
  
  public static final String MODE_UTM = "UTM";
  
  public static final String ANGLE_DEGEREES = "DEGREES";
  
  public static final String ANGLE_THOUSANDTHS = "THOUSANDTHS";
  
  public static final String DISTANCE_METERS = "METERS";
  
  public static final String DISTANCE_KILOMETERS = "KILOMETERS";
  
  private ResourceBundle resouce;
  
  private String mode = "";
  
  private String angle = "";
  
  private String distance = "";
  
  private Point point = null;
  
  private PuntoGeograficas observer = null;
  
  private Weather weatherLine = null;
  
  private Weather weatherLastLine = null;
  
  private Configuration configuration = null;
  
  private Ammunition ammunition = null;
  
  private PuntoGeograficas forcing = null;
  
  private PuntoGeograficas target = null;
  
  private Limits limits = null;
  
  private RadarHistory radarHistory = null;
  
  public ResourceBundle getResouce() {
    return this.resouce;
  }
  
  public void setResouce(ResourceBundle resouce) {
    this.resouce = resouce;
  }
  
  public static AppConfig getInstance() {
    if (instance == null)
      instance = new AppConfig(); 
    return instance;
  }
  
  private AppConfig() {
    setMode("GEOGRAPHICAL");
    setDistance("KILOMETERS");
    setAngle("DEGREES");
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public void setMode(String mode) {
    if ("GEOGRAPHICAL".equals(mode) || "UTM".equals(mode))
      this.mode = mode; 
  }
  
  public void toggleMode() {
    if ("GEOGRAPHICAL".equals(getMode())) {
      setMode("UTM");
    } else if ("UTM".equals(getMode())) {
      setMode("GEOGRAPHICAL");
    } 
  }
  
  public String getAngle() {
    return this.angle;
  }
  
  public void setAngle(String angle) {
    if ("DEGREES".equals(angle) || "THOUSANDTHS".equals(angle))
      this.angle = angle; 
  }
  
  public String getDistance() {
    return this.distance;
  }
  
  public void setDistance(String distance) {
    if ("METERS".equals(distance) || "KILOMETERS".equals(distance))
      this.distance = distance; 
  }
  
  public Point getPoint() {
    return this.point;
  }
  
  public PuntoGeograficas getObserver() {
    return this.observer;
  }
  
  public void setObserver(PuntoGeograficas observer) {
    this.observer = observer;
  }
  
  public void setPoint(Point point) {
    this.point = point;
  }
  
  public Weather getWeatherLine() {
    return this.weatherLine;
  }
  
  public void setWeatherLine(Weather weatherLine) {
    this.weatherLine = weatherLine;
  }
  
  public Weather getWeatherLastLine() {
    return this.weatherLastLine;
  }
  
  public void setWeatherLastLine(Weather weatherLastLine) {
    this.weatherLastLine = weatherLastLine;
  }
  
  public Configuration getConfiguration() {
    return this.configuration;
  }
  
  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }
  
  public Ammunition getAmmunition() {
    return this.ammunition;
  }
  
  public void setAmmunition(Ammunition ammunition) {
    this.ammunition = ammunition;
  }
  
  public PuntoGeograficas getForcing() {
    return this.forcing;
  }
  
  public void setForcing(PuntoGeograficas forcing) {
    this.forcing = forcing;
  }
  
  public PuntoGeograficas getTarget() {
    return this.target;
  }
  
  public void setTarget(PuntoGeograficas target) {
    this.target = target;
  }
  
  public Limits getLimits() {
    return this.limits;
  }
  
  public void setLimits(Limits limits) {
    this.limits = limits;
  }
  
  public RadarHistory getRadarHistory() {
    return this.radarHistory;
  }
  
  public void setRadarHistory(RadarHistory radarHistory) {
    this.radarHistory = radarHistory;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\u\\utils\AppConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */