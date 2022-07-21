package co.dynamicts.neli.core.Fires;

import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.utilities.Actitud;

public class Pointing extends Thread {
  private static Pointing pointing;
  
  boolean ejecutarHilo = true;
  
  Actitud actitudDeseada = new Actitud();
  
  Actitud actitudApuntada = new Actitud();
  
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  Ins ins = Ins.getSingletonInstance();
  
  DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
  
  private double xPointingLog = 0.0D;
  
  private double yPointingLog = 0.0D;
  
  private double difx = 0.0D;
  
  private double dify = 0.0D;
  
  private boolean isXRigth = false;
  
  private boolean isXLeft = false;
  
  private boolean isYup = false;
  
  private boolean isYdown = false;
  
  private boolean isXbad = false;
  
  private boolean isXMed = false;
  
  private boolean isXOk = false;
  
  private boolean isXNone = true;
  
  private boolean isYbad = false;
  
  private boolean isYMed = false;
  
  private boolean isYOk = false;
  
  private boolean isYNone = true;
  
  public void run() {
    while (this.ejecutarHilo) {
      try {
        Thread.sleep(50L);
        appointing();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public void appointing() {
    this.actitudDeseada = this.datosCalculados.actitudDeseadaMils;
    this.actitudApuntada = this.ins.actitud;
    if (this.ins.isZuptTiro()) {
      this.difx = this.actitudDeseada.getAzimut() - this.actitudApuntada.getAzimut();
      this.dify = this.actitudDeseada.getElevacion() - this.actitudApuntada.getElevacion();
    } else {
      this.difx = this.datosApuntados.posicionCarta.getAzimut() - this.actitudApuntada.getAzimut();
    } 
    if (Math.abs(this.difx) > 3200.0D)
      this.difx = -this.difx; 
    if (this.difx >= 10.0D) {
      this.xPointingLog = 3.1D;
    } else if (this.difx <= -10.0D) {
      this.xPointingLog = -3.1D;
    } else {
      this.xPointingLog = this.difx * 0.3333D;
    } 
    if (this.dify >= 10.0D) {
      this.yPointingLog = 3.1D;
    } else if (this.dify <= -10.0D) {
      this.yPointingLog = -3.1D;
    } else {
      this.yPointingLog = this.dify * 0.333D;
    } 
    if (this.difx >= 0.5D) {
      this.isXRigth = true;
      this.isXLeft = false;
    } else if (this.difx <= -0.5D) {
      this.isXRigth = false;
      this.isXLeft = true;
    } else {
      this.isXRigth = false;
      this.isXLeft = false;
    } 
    if (this.dify >= 0.5D) {
      this.isYup = true;
      this.isYdown = false;
    } else if (this.dify <= -0.5D) {
      this.isYup = false;
      this.isYdown = true;
    } else {
      this.isYup = false;
      this.isYdown = false;
    } 
    if (Math.abs(this.difx) >= 4.0D) {
      this.isXbad = true;
      this.isXMed = false;
      this.isXOk = false;
      this.isXNone = false;
    } else if (Math.abs(this.difx) >= 2.0D && Math.abs(this.difx) < 4.0D) {
      this.isXbad = false;
      this.isXMed = true;
      this.isXOk = false;
      this.isXNone = false;
    } else if (Math.abs(this.difx) < 0.5D) {
      this.isXbad = false;
      this.isXMed = false;
      this.isXOk = true;
      this.isXNone = false;
    } 
    if (Math.abs(this.dify) >= 4.0D) {
      this.isYbad = true;
      this.isYMed = false;
      this.isYOk = false;
      this.isYNone = false;
    } else if (Math.abs(this.dify) >= 2.0D && Math.abs(this.dify) < 4.0D) {
      this.isYbad = false;
      this.isYMed = true;
      this.isYOk = false;
      this.isYNone = false;
    } else if (Math.abs(this.dify) < 0.5D) {
      this.isYbad = false;
      this.isYMed = false;
      this.isYOk = true;
      this.isYNone = false;
    } 
    if (!this.datosCalculados.isBlancoSetting()) {
      this.isXbad = false;
      this.isXMed = false;
      this.isXOk = false;
      this.isXNone = true;
      this.isYbad = false;
      this.isYMed = false;
      this.isYOk = false;
      this.isYNone = true;
    } 
  }
  
  public void setActitudDeseada(Actitud actitudDeseada) {
    this.actitudDeseada = actitudDeseada;
  }
  
  public void setActitudApuntada(Actitud actitudApuntada) {
    this.actitudApuntada = actitudApuntada;
  }
  
  public Actitud getActitudDeseada() {
    return this.actitudDeseada;
  }
  
  public double getxPointingLog() {
    return this.xPointingLog;
  }
  
  public double getyPointingLog() {
    return this.yPointingLog;
  }
  
  public boolean isXbad() {
    return this.isXbad;
  }
  
  public boolean isXMed() {
    return this.isXMed;
  }
  
  public boolean isXOk() {
    return this.isXOk;
  }
  
  public boolean isYbad() {
    return this.isYbad;
  }
  
  public boolean isYMed() {
    return this.isYMed;
  }
  
  public boolean isYOk() {
    return this.isYOk;
  }
  
  public boolean isXRigth() {
    return this.isXRigth;
  }
  
  public void setXRigth(boolean XRigth) {
    this.isXRigth = XRigth;
  }
  
  public boolean isXLeft() {
    return this.isXLeft;
  }
  
  public void setXLeft(boolean XLeft) {
    this.isXLeft = XLeft;
  }
  
  public boolean isYup() {
    return this.isYup;
  }
  
  public void setYup(boolean yup) {
    this.isYup = yup;
  }
  
  public boolean isYdown() {
    return this.isYdown;
  }
  
  public void setYdown(boolean ydown) {
    this.isYdown = ydown;
  }
  
  public boolean isXNone() {
    return this.isXNone;
  }
  
  public void setXNone(boolean XNone) {
    this.isXNone = XNone;
  }
  
  public boolean isYNone() {
    return this.isYNone;
  }
  
  public void setYNone(boolean YNone) {
    this.isYNone = YNone;
  }
  
  public double getDifx() {
    return this.difx;
  }
  
  public void setDifx(double difx) {
    this.difx = difx;
  }
  
  public double getDify() {
    return this.dify;
  }
  
  public void setDify(double dify) {
    this.dify = dify;
  }
  
  public static Pointing getSingletonInstance() {
    if (pointing == null)
      pointing = new Pointing(); 
    return pointing;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Fires\Pointing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */