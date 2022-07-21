package co.dynamicts.neli.core.local.model;

import co.dynamicts.neli.ui.utils.StringUtil;
import com.j256.ormlite.field.DatabaseField;

public class Ports {
  @DatabaseField(id = true)
  private String periferico;
  
  @DatabaseField(canBeNull = false)
  private String puerto;
  
  @DatabaseField(canBeNull = false)
  private int velocidad;
  
  @DatabaseField(canBeNull = false)
  private String paridad;
  
  @DatabaseField(canBeNull = false)
  private int bitStop;
  
  public String getPeriferico() {
    return this.periferico;
  }
  
  public void setPeriferico(String periferico) {
    this.periferico = periferico;
  }
  
  public String getPuerto() {
    return this.puerto;
  }
  
  public void setPuerto(String puerto) {
    this.puerto = puerto;
  }
  
  public int getVelocidad() {
    return this.velocidad;
  }
  
  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }
  
  public String getParidad() {
    return this.paridad;
  }
  
  public void setParidad(String paridad) {
    this.paridad = paridad;
  }
  
  public int getBitStop() {
    return this.bitStop;
  }
  
  public void setBitStop(int bitStop) {
    this.bitStop = bitStop;
  }
  
  public int getParidadAsInt() {
    int aux = 0;
    if (this.paridad.equals(StringUtil.translateKey("label.interface.ports.paridad.si"))) {
      aux = 1;
    } else if (this.paridad.equals(StringUtil.translateKey("label.interface.ports.paridad.no"))) {
      aux = 0;
    } 
    return aux;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Ports.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */