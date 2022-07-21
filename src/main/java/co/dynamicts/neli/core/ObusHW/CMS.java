package co.dynamicts.neli.core.ObusHW;

import co.dynamicts.neli.core.Hardware.FuncionesCPA;

public class CMS {
  private static CMS cms;
  
  private double tempCanon = 30.0D;
  
  private int temCanonState = 0;
  
  private double retroCanon_m = 1.2D;
  
  private boolean IsCMS;
  
  public void updateTemCanonState() {
    double tempCorte = FuncionesCPA.CMS_TempCorte;
    this.tempCanon = FuncionesCPA.CMS_TempTubo;
    double difTemp = this.tempCanon - tempCorte;
    if (difTemp <= -5.0D) {
      this.temCanonState = 0;
    } else if (difTemp > -5.0D && difTemp < 0.0D) {
      this.temCanonState = 1;
    } else if (difTemp >= 0.0D) {
      this.temCanonState = 2;
    } 
  }
  
  public double getTempCanon() {
    return this.tempCanon;
  }
  
  public void setTempCanon(double tempCanon) {
    this.tempCanon = tempCanon;
  }
  
  public double getRetroCanon_m() {
    return this.retroCanon_m;
  }
  
  public void setRetroCanon_m(double retroCanon_m) {
    this.retroCanon_m = retroCanon_m;
  }
  
  public int getTemCanonState() {
    return this.temCanonState;
  }
  
  public void setTemCanonState(int temCanonState) {
    this.temCanonState = temCanonState;
  }
  
  public boolean isCMS() {
    return this.IsCMS;
  }
  
  public void setCMS(boolean bool) {
    this.IsCMS = bool;
  }
  
  public static CMS getSingletonInstance() {
    if (cms == null)
      cms = new CMS(); 
    return cms;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\ObusHW\CMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */