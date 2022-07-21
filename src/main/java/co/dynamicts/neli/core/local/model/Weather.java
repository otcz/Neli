package co.dynamicts.neli.core.local.model;

import com.j256.ormlite.field.DatabaseField;

public class Weather {
  @DatabaseField(id = true)
  private int lineNumber;
  
  @DatabaseField(canBeNull = false)
  private int zone;
  
  @DatabaseField(canBeNull = false)
  private int windDirection;
  
  @DatabaseField(canBeNull = false)
  private int windSpeed;
  
  @DatabaseField(canBeNull = false)
  private double temperature;
  
  @DatabaseField(canBeNull = false)
  private int pressure;
  
  public int getLineNumber() {
    return this.lineNumber;
  }
  
  public void setLineNumber(String lineNumber) {
    this.lineNumber = Integer.parseInt(lineNumber);
  }
  
  public int getZone() {
    return this.zone;
  }
  
  public void setZone(String zone) {
    this.zone = Integer.parseInt(zone);
  }
  
  public int getWindDirection() {
    return this.windDirection;
  }
  
  public void setWindDirection(String windDirection) {
    this.windDirection = Integer.parseInt(windDirection) * 10;
  }
  
  public int getWindSpeed() {
    return this.windSpeed;
  }
  
  public void setWindSpeed(String windSpeed) {
    this.windSpeed = Integer.parseInt(windSpeed);
  }
  
  public double getTemperature() {
    return this.temperature;
  }
  
  public void setTemperature(String temperature) {
    this.temperature = Double.parseDouble(temperature) / 10.0D;
  }
  
  public int getPressure() {
    return this.pressure;
  }
  
  public void setPressure(String pressure) {
    this.pressure = Integer.parseInt(pressure);
  }
  
  public String getStringLineNumber() {
    String auxtex = String.valueOf(getLineNumber());
    if (auxtex.length() == 1)
      auxtex = "0" + auxtex; 
    return auxtex;
  }
  
  public String getStringWindDirection() {
    String auxtex = String.valueOf(getWindDirection() / 10);
    if (auxtex.length() == 1) {
      auxtex = "00" + auxtex;
    } else if (auxtex.length() == 2) {
      auxtex = "0" + auxtex;
    } 
    return auxtex;
  }
  
  public String getStringWindSpeed() {
    String auxtex = String.valueOf(getWindSpeed());
    if (auxtex.length() == 1) {
      auxtex = "00" + auxtex;
    } else if (auxtex.length() == 2) {
      auxtex = "0" + auxtex;
    } 
    return auxtex;
  }
  
  public String getStringTemperature() {
    int aux = (int)(getTemperature() * 10.0D);
    String auxtex = String.valueOf(aux);
    if (auxtex.length() == 3) {
      auxtex = "0" + auxtex;
    } else if (auxtex.length() == 2) {
      auxtex = "00" + auxtex;
    } else if (auxtex.length() == 1) {
      auxtex = "000" + auxtex;
    } 
    return auxtex;
  }
  
  public String getStringPressure() {
    String auxtex = String.valueOf(getPressure());
    if (auxtex.length() == 3) {
      auxtex = "0" + auxtex;
    } else if (auxtex.length() == 2) {
      auxtex = "00" + auxtex;
    } else if (auxtex.length() == 1) {
      auxtex = "000" + auxtex;
    } 
    return auxtex;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Weather.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */