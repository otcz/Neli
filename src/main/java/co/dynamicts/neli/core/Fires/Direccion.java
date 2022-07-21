package co.dynamicts.neli.core.Fires;

import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.ObusHW.Trinca;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.utilities.Tools;

public class Direccion extends Thread {
  private static Direccion direccion;
  
  Ins ins = Ins.getSingletonInstance();
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  public Trinca trinca = Trinca.getSingletonInstance();
  
  Tools tools = new Tools();
  
  private double orientacionVehiculo = 0.0D;
  
  private double orientacionCanon = 0.0D;
  
  private boolean limMecanicoDerIsBad = true;
  
  private boolean limMecanicoIzqIsBad = true;
  
  public double limiteSuperiorTiro;
  
  public double limiteInferiorTiro;
  
  public double limiteIzquierdoTiro;
  
  public double limiteDerechoTiro;
  
  public double limiteDerechoFisico;
  
  public double limiteIzquierdoFisico;
  
  public boolean limTiroSupIsBad = false;
  
  public boolean limTiroInfIsBad = false;
  
  public boolean limTiroDerIsBad = false;
  
  public boolean limTiroIzqIsBad = false;
  
  public void run() {
    while (true) {
      try {
        Thread.sleep(300L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
      if (this.trinca.isTrincaPut()) {
        if (this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
          this.orientacionVehiculo = -Tools.restringeValores(this.ins.actitud.getAzimut() + 3200.0D, 6400.0D, 0.0D);
          this.orientacionCanon = Tools.restringeValores(this.ins.actitud.getAzimut() + 3200.0D, 6400.0D, 0.0D);
        } else {
          this.orientacionVehiculo = -this.ins.actitud.getAzimut();
          this.orientacionCanon = this.ins.actitud.getAzimut();
        } 
        this.limiteDerechoFisico = Tools.restringeValores(this.ins.actitud.getAzimut() + 534.0D + 3200.0D, 6400.0D, 0.0D);
        this.limiteIzquierdoFisico = Tools.restringeValores(this.ins.actitud.getAzimut() - 711.0D + 3200.0D, 6400.0D, 0.0D);
      } else if (!this.ins.isZuptTiro()) {
        this.orientacionVehiculo = -this.ins.actitud.getAzimut();
        this.orientacionCanon = Tools.restringeValores(this.ins.actitud.getAzimut() + 3200.0D, 6400.0D, 0.0D);
        this.limiteDerechoFisico = Tools.restringeValores(this.ins.actitud.getAzimut() + 534.0D, 6400.0D, 0.0D);
        this.limiteIzquierdoFisico = Tools.restringeValores(this.ins.actitud.getAzimut() - 711.0D, 6400.0D, 0.0D);
      } else {
        this.orientacionCanon = Tools.restringeValores(this.ins.actitud.getAzimut() + 3200.0D, 6400.0D, 0.0D);
      } 
      evaluaLimites();
    } 
  }
  
  public void evaluaLimites() {
    double elevacionCanon = this.ins.actitud.getElevacion();
    if (elevacionCanon >= this.limiteSuperiorTiro) {
      this.limTiroSupIsBad = true;
      this.limTiroInfIsBad = false;
    } 
    if (elevacionCanon <= this.limiteInferiorTiro) {
      this.limTiroSupIsBad = false;
      this.limTiroInfIsBad = true;
    } else if (elevacionCanon > this.limiteInferiorTiro && elevacionCanon < this.limiteSuperiorTiro) {
      this.limTiroSupIsBad = false;
      this.limTiroInfIsBad = false;
    } 
    if (this.ins.actitud.getAzimut() >= this.limiteDerechoTiro) {
      this.limTiroDerIsBad = false;
      this.limTiroIzqIsBad = true;
    } else if (this.ins.actitud.getAzimut() <= this.limiteIzquierdoTiro) {
      this.limTiroDerIsBad = true;
      this.limTiroIzqIsBad = false;
    } else if (this.ins.actitud.getAzimut() >= this.limiteIzquierdoTiro && this.ins.actitud.getAzimut() <= this.limiteDerechoTiro) {
      this.limTiroDerIsBad = false;
      this.limTiroIzqIsBad = false;
    } 
    double difLimiteFisicoDer = this.tools.difCirculoAZ1_AZ2(this.limiteDerechoFisico, Tools.restringeValores(this.orientacionCanon - 3200.0D, 6400.0D, 0.0D));
    double difLimiteFisicoIzq = this.tools.difCirculoAZ1_AZ2(this.limiteIzquierdoFisico, Tools.restringeValores(this.orientacionCanon - 3200.0D, 6400.0D, 0.0D));
    if (difLimiteFisicoDer >= 0.0D && difLimiteFisicoIzq <= 0.0D) {
      this.limMecanicoDerIsBad = false;
      this.limMecanicoIzqIsBad = false;
    } else {
      if (difLimiteFisicoDer <= 0.0D)
        this.limMecanicoDerIsBad = true; 
      if (difLimiteFisicoIzq >= 0.0D)
        this.limMecanicoIzqIsBad = true; 
    } 
  }
  
  public double getOrientacionVehiculo() {
    return this.orientacionVehiculo;
  }
  
  public void setOrientacionVehiculo(double orientacionVehiculo) {
    this.orientacionVehiculo = orientacionVehiculo;
  }
  
  public double getOrientacionCanon() {
    return this.orientacionCanon;
  }
  
  public void setOrientacionCanon(double orientacionCanon) {
    this.orientacionCanon = orientacionCanon;
  }
  
  public boolean isLimMecanicoDerIsBad() {
    return this.limMecanicoDerIsBad;
  }
  
  public void setLimMecanicoDerIsBad(boolean limMecanicoDerIsBad) {
    this.limMecanicoDerIsBad = limMecanicoDerIsBad;
  }
  
  public boolean isLimMecanicoIzqIsBad() {
    return this.limMecanicoIzqIsBad;
  }
  
  public void setLimMecanicoIzqIsBad(boolean limMecanicoIzqIsBad) {
    this.limMecanicoIzqIsBad = limMecanicoIzqIsBad;
  }
  
  public double getLimiteSuperiorTiro() {
    return this.limiteSuperiorTiro;
  }
  
  public void setLimiteSuperiorTiro(double limiteSuperiorTiro) {
    this.limiteSuperiorTiro = limiteSuperiorTiro;
  }
  
  public double getLimiteInferiorTiro() {
    return this.limiteInferiorTiro;
  }
  
  public void setLimiteInferiorTiro(double limiteInferiorTiro) {
    this.limiteInferiorTiro = limiteInferiorTiro;
  }
  
  public double getLimiteDerechoFisico() {
    return this.limiteDerechoFisico;
  }
  
  public void setLimiteDerechoFisico(double limiteDerechoFisico) {
    this.limiteDerechoFisico = limiteDerechoFisico;
  }
  
  public double getLimiteIzquierdoFisico() {
    return this.limiteIzquierdoFisico;
  }
  
  public void setLimiteIzquierdoFisico(double limiteIzquierdoFisico) {
    this.limiteIzquierdoFisico = limiteIzquierdoFisico;
  }
  
  public double getLimiteIzquierdoTiro() {
    return this.limiteIzquierdoTiro;
  }
  
  public void setLimiteIzquierdoTiro(double limiteIzquierdoTiro) {
    this.limiteIzquierdoTiro = limiteIzquierdoTiro;
  }
  
  public double getLimiteDerechoTiro() {
    return this.limiteDerechoTiro;
  }
  
  public void setLimiteDerechoTiro(double limiteDerechoTiro) {
    this.limiteDerechoTiro = limiteDerechoTiro;
  }
  
  public boolean isLimTiroSupIsBad() {
    return this.limTiroSupIsBad;
  }
  
  public boolean isLimTiroInfIsBad() {
    return this.limTiroInfIsBad;
  }
  
  public boolean isLimTiroDerIsBad() {
    return this.limTiroDerIsBad;
  }
  
  public boolean isLimTiroIzqIsBad() {
    return this.limTiroIzqIsBad;
  }
  
  public static Direccion getSingletonInstance() {
    if (direccion == null)
      direccion = new Direccion(); 
    return direccion;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Fires\Direccion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */