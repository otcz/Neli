package co.dynamicts.neli.core.utilities;

import java.io.Serializable;

public class DatosEstadistica extends Tools implements Serializable {
  private int carga1;
  
  private int carga2;
  
  private int carga3;
  
  private int carga4;
  
  private int carga5;
  
  private int carga6;
  
  private int carga7;
  
  private int rango1;
  
  private int rango2;
  
  private double efc;
  
  public DatosEstadistica(int carga1, int carga2, int carga3, int carga4, int carga5, int carga6, int carga7, int rango1, int rango2, double efc) {
    this.carga1 = carga1;
    this.carga2 = carga2;
    this.carga3 = carga3;
    this.carga4 = carga4;
    this.carga5 = carga5;
    this.carga6 = carga6;
    this.carga7 = carga7;
    this.rango1 = rango1;
    this.rango2 = rango2;
    this.efc = efc;
  }
  
  public int getCarga1() {
    return this.carga1;
  }
  
  public int getCarga2() {
    return this.carga2;
  }
  
  public int getCarga3() {
    return this.carga3;
  }
  
  public int getCarga4() {
    return this.carga4;
  }
  
  public int getCarga5() {
    return this.carga5;
  }
  
  public int getCarga6() {
    return this.carga6;
  }
  
  public int getCarga7() {
    return this.carga7;
  }
  
  public int getRango1() {
    return this.rango1;
  }
  
  public int getRango2() {
    return this.rango2;
  }
  
  public double getEfc() {
    return this.efc;
  }
  
  public String toEFCString() {
    return String.valueOf(limitaDecimales(getEfc()));
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\DatosEstadistica.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */