package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Direccion;
import co.dynamicts.neli.core.trayectoria.Trayectoria;
import co.dynamicts.neli.core.utilities.Actitud;
import co.dynamicts.neli.core.utilities.Posicion;
import co.dynamicts.neli.core.utilities.Tools;

import java.io.IOException;

public class Limites extends Tools {
  private static Limites limites;
  
  Direccion direccion = Direccion.getSingletonInstance();
  
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  private double dist_X_Seguridad = 600.0D;
  
  private double dist_Z_Seguridad = 600.0D;
  
  double anguloHorizontal = 0.0D;
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  public Posicion posicionInicial;
  
  public Posicion posicionMaxima;
  
  public Posicion posicionMinima;
  
  public Actitud actitudRas_Max;
  
  public Actitud actitudRas_Min;
  
  public Actitud actitudGA_Max;
  
  public Actitud actitudGA_Min;
  
  public Limites() throws IOException {
    this.posicionInicial = new Posicion();
    this.posicionMaxima = new Posicion();
    this.posicionMinima = new Posicion();
    this.actitudRas_Max = new Actitud();
    this.actitudRas_Min = new Actitud();
    this.actitudGA_Max = new Actitud();
    this.actitudGA_Min = new Actitud();
  }
  
  public void limitesManual(double distMax, double disMin, double limDerecho, double limIzquierdo) {
    this.posicionMaxima.setDistancia(distMax);
    this.posicionMaxima.setAzimut(limDerecho);
    this.posicionMinima.setDistancia(disMin);
    this.posicionMinima.setAzimut(limIzquierdo);
    calculoLimitesManuales();
    setLimitesOnDireccion();
  }
  
  public void checkAutomatico() {
    this.posicionInicial = this.datosCalculados.posicionDeseadaMetros;
    this.dist_X_Seguridad = (this.datosCalculados.trayectoriaDeseada.getSigma_X_MPI() + this.datosCalculados.trayectoriaDeseada.getSigma_PX_PE()) * 4.0D;
    this.dist_Z_Seguridad = (this.datosCalculados.trayectoriaDeseada.getSigma_Z_MPI() + this.datosCalculados.trayectoriaDeseada.getSigma_PZ_PE()) * 4.0D;
    double distanciaInicial = this.posicionInicial.getDistancia();
    double azimutInicial = this.posicionInicial.getAzimut();
    this.anguloHorizontal = calculaAnguloCatetosMilesimas(this.dist_Z_Seguridad, distanciaInicial);
    this.posicionMaxima.puntoA.setAltura(this.posicionInicial.puntoA.getAltura());
    this.posicionMaxima.puntoB.setAltura(this.posicionInicial.puntoB.getAltura());
    this.posicionMaxima.setDistancia(distanciaInicial + this.dist_X_Seguridad);
    this.posicionMaxima.setAzimut(restringeValores(azimutInicial + this.anguloHorizontal, 6400.0D, 0.0D));
    this.posicionMaxima.setIntervalo(this.posicionInicial.getIntervalo());
    this.posicionMinima.puntoA.setAltura(this.posicionInicial.puntoA.getAltura());
    this.posicionMinima.puntoB.setAltura(this.posicionInicial.puntoB.getAltura());
    this.posicionMinima.setDistancia(distanciaInicial - this.dist_X_Seguridad);
    this.posicionMinima.setAzimut(restringeValores(azimutInicial - this.anguloHorizontal, 6400.0D, 0.0D));
    this.posicionMinima.setIntervalo(this.posicionInicial.getIntervalo());
    calculoLimitesAutomaticos();
    setLimitesOnDireccion();
    setLimitsTargetImpossible();
  }
  
  private void setLimitesOnDireccion() {
    if (this.configuracion.isRasante()) {
      this.direccion.setLimiteSuperiorTiro(this.actitudRas_Max.getElevacion());
      this.direccion.setLimiteInferiorTiro(this.actitudRas_Min.getElevacion());
      this.direccion.setLimiteDerechoTiro(this.actitudRas_Max.getAzimut());
      this.direccion.setLimiteIzquierdoTiro(this.actitudRas_Min.getAzimut());
    } else if (!this.configuracion.isRasante()) {
      this.direccion.setLimiteSuperiorTiro(this.actitudGA_Max.getElevacion());
      this.direccion.setLimiteInferiorTiro(this.actitudGA_Min.getElevacion());
      this.direccion.setLimiteDerechoTiro(this.actitudGA_Max.getAzimut());
      this.direccion.setLimiteIzquierdoTiro(this.actitudGA_Min.getAzimut());
    } 
  }
  
  private void calculoLimitesAutomaticos() {
    double vt = this.configuracion.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
    compruebaValoresCero();
    double distanciaInicial = this.posicionInicial.getDistancia();
    this.anguloHorizontal = calculaAnguloCatetosMilesimas(this.dist_Z_Seguridad, distanciaInicial);
    if (this.configuracion.isRasante()) {
      Trayectoria trayMaxRas = new Trayectoria();
      this.actitudRas_Max.setElevacion(trayMaxRas.calculaAnguloMilsRas(this.posicionMaxima));
      double orientacionInicial = this.datosCalculados.actitudDeseadaMils.getAzimut();
      this.actitudRas_Max.setAzimut(orientacionInicial + this.anguloHorizontal);
      Trayectoria trayMinRas = new Trayectoria();
      this.actitudRas_Min.setElevacion(trayMinRas.calculaAnguloMilsRas(this.posicionMinima));
      this.actitudRas_Min.setAzimut(orientacionInicial - this.anguloHorizontal);
      if (this.actitudRas_Max.getElevacion() == 0.0D)
        this.actitudRas_Max.setElevacion(800.0D); 
    } else {
      Trayectoria trayMaxGA = new Trayectoria();
      this.actitudGA_Max.setElevacion(trayMaxGA.calculaAnguloMilsGA(this.posicionMaxima));
      double derivaMaxGA = trayMaxGA.getTDC();
      this.actitudGA_Max.setAzimut(this.posicionMaxima.getAzimut() - derivaMaxGA);
      Trayectoria trayMinGA = new Trayectoria();
      this.actitudGA_Min.setElevacion(trayMinGA.calculaAnguloMilsGA(this.posicionMinima));
      double derivaMinGA = trayMinGA.getTDC();
      this.actitudGA_Min.setAzimut(this.posicionMinima.getAzimut() - derivaMinGA);
      if (this.actitudGA_Min.getElevacion() == 0.0D)
        this.actitudGA_Min.setElevacion(800.0D); 
    } 
    setLimitsTargetImpossible();
  }
  
  private void calculoLimitesManuales() {
    double vt = this.configuracion.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
    compruebaValoresCero();
    double distanciaInicial = this.posicionInicial.getDistancia();
    if (this.configuracion.isRasante()) {
      Trayectoria trayMaxRas = new Trayectoria();
      this.actitudRas_Max.setElevacion(trayMaxRas.calculaAnguloMilsRas(this.posicionMaxima));
      double orientacionInicial = this.datosCalculados.actitudDeseadaMils.getAzimut();
      this.actitudRas_Max.setAzimut(this.posicionMaxima.getAzimut());
      Trayectoria trayMinRas = new Trayectoria();
      this.actitudRas_Min.setElevacion(trayMinRas.calculaAnguloMilsRas(this.posicionMinima));
      this.actitudRas_Min.setAzimut(this.posicionMinima.getAzimut());
      if (this.actitudRas_Max.getElevacion() == 0.0D)
        this.actitudRas_Max.setElevacion(800.0D); 
    } else {
      Trayectoria trayMaxGA = new Trayectoria();
      this.actitudGA_Max.setElevacion(trayMaxGA.calculaAnguloMilsGA(this.posicionMaxima));
      double derivaMaxGA = trayMaxGA.getTDC();
      this.actitudGA_Max.setAzimut(this.posicionMaxima.getAzimut());
      Trayectoria trayMinGA = new Trayectoria();
      this.actitudGA_Min.setElevacion(trayMinGA.calculaAnguloMilsGA(this.posicionMinima));
      double derivaMinGA = trayMinGA.getTDC();
      this.actitudGA_Min.setAzimut(this.posicionMinima.getAzimut());
      if (this.actitudGA_Min.getElevacion() == 0.0D)
        this.actitudGA_Min.setElevacion(800.0D); 
    } 
    setLimitsTargetImpossible();
  }
  
  public void setLimitsTargetImpossible() {
    if (!this.datosCalculados.isPosible()) {
      this.actitudRas_Max.setElevacion(800.0D);
      this.actitudRas_Min.setElevacion(-10.0D);
      this.actitudGA_Max.setElevacion(1150.0D);
      this.actitudGA_Min.setElevacion(800.0D);
      this.actitudRas_Max.setAzimut(this.direccion.limiteDerechoFisico - 100.0D);
      this.actitudRas_Min.setAzimut(this.direccion.limiteIzquierdoFisico + 100.0D);
      this.actitudGA_Max.setAzimut(this.direccion.limiteDerechoTiro - 100.0D);
      this.actitudGA_Min.setAzimut(this.direccion.limiteIzquierdoFisico + 100.0D);
      setLimitesOnDireccion();
    } 
  }
  
  private void compruebaValoresCero() {
    double anguloHorizontal = calculaAnguloCatetosMilesimas(2000.0D, this.posicionInicial.getDistancia());
    if (this.posicionMinima.getDistancia() == 0.0D)
      this.posicionMinima.setDistancia(this.posicionInicial.getDistancia() - 2000.0D); 
    if (this.posicionMaxima.getDistancia() == 0.0D)
      this.posicionMaxima.setDistancia(this.posicionInicial.getDistancia() + 2000.0D); 
    if (this.posicionMinima.getAzimut() == 0.0D)
      this.posicionMinima.setAzimut(restringeValores(this.posicionInicial.getAzimut() - anguloHorizontal, 6400.0D, 0.0D)); 
    if (this.posicionMaxima.getAzimut() == 0.0D)
      this.posicionMaxima.setAzimut(restringeValores(this.posicionInicial.getAzimut() + anguloHorizontal, 6400.0D, 0.0D)); 
  }
  
  public static Limites getSingletonInstance() throws IOException {
    if (limites == null)
      limites = new Limites(); 
    return limites;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\Limites.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */