package co.dynamicts.neli.core.local.model;

import com.j256.ormlite.field.DatabaseField;

public class Host {
  @DatabaseField(id = true)
  private String numberPart;
  
  public String getNumberPart() {
    return this.numberPart;
  }
  
  public void setNumberPart(String numberPart) {
    this.numberPart = numberPart;
  }
  
  public String getIP() {
    char[] cadenaAux = new char[5];
    cadenaAux = this.numberPart.toCharArray();
    return "192.168.36.1" + cadenaAux[4] + cadenaAux[5];
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Host.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */