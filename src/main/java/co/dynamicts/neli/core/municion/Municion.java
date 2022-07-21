package co.dynamicts.neli.core.municion;

import java.util.ArrayList;

public class Municion {
  private String tipo;
  
  private double diametro;
  
  private double acel_deflexion;
  
  public Coeficientes coeficientes;
  
  public BaseBleed baseBleed;
  
  private int numeroZonas;
  
  private double pesoProyectil;
  
  private int cuad_std_peso;
  
  private double camb_cuad_peso;
  
  public ArrayList zonas;
  
  public Zona zonaSelec;
  
  private int Cantidad;
  
  public Espoleta espoletaSelect;
  
  public ArrayList espoletas;
  
  double twist = 20.0D;
  
  private String efecto = "HE";
  
  public boolean isBB;
  
  private double ajVelocidadBoca;
  
  private double ajDrag;
  
  private double ajElevacion;
  
  private double ajA0;
  
  private double ajA1;
  
  private double desvUbicacion_Az;
  
  private double desvUbicacion_m;
  
  private double desvDistancia;
  
  private double desvAzimut;
  
  public Municion() {
    this.coeficientes = new Coeficientes();
    this.zonas = new ArrayList();
    this.espoletas = new ArrayList();
    this.baseBleed = new BaseBleed();
  }
  
  public double getPesoProyectil(int cuadros) {
    int diferenciaCuadros = cuadros - getCuad_std_peso();
    double nuevoPeso = getPesoProyectil() + diferenciaCuadros * getCamb_cuad_peso() + this.espoletaSelect.getPeso();
    return nuevoPeso;
  }
  
  public String getTipo() {
    return this.tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public double getDiametro() {
    return this.diametro;
  }
  
  public void setDiametro(double diametro) {
    this.diametro = diametro;
  }
  
  public double getAcel_deflexion() {
    return this.acel_deflexion;
  }
  
  public void setAcel_deflexion(double acel_deflexion) {
    this.acel_deflexion = acel_deflexion;
  }
  
  public Coeficientes getCoeficientes() {
    return this.coeficientes;
  }
  
  public void setCoeficientes(Coeficientes coeficientes) {
    this.coeficientes = coeficientes;
  }
  
  public int getNumeroZonas() {
    return this.numeroZonas;
  }
  
  public void setNumeroZonas(int numeroZonas) {
    this.numeroZonas = numeroZonas;
  }
  
  public double getPesoProyectil() {
    return this.pesoProyectil;
  }
  
  public void setPesoProyectil(double pesoProyectil) {
    this.pesoProyectil = pesoProyectil;
  }
  
  public int getCuad_std_peso() {
    return this.cuad_std_peso;
  }
  
  public void setCuad_std_peso(int cuad_std_peso) {
    this.cuad_std_peso = cuad_std_peso;
  }
  
  public double getCamb_cuad_peso() {
    return this.camb_cuad_peso;
  }
  
  public void setCamb_cuad_peso(double camb_cuad_peso) {
    this.camb_cuad_peso = camb_cuad_peso;
  }
  
  public int getCantidad() {
    return this.Cantidad;
  }
  
  public void setCantidad(int cantidad) {
    this.Cantidad = cantidad;
  }
  
  public double getAjVelocidadBoca() {
    return this.ajVelocidadBoca;
  }
  
  public void setAjVelocidadBoca(double ajVelocidadBoca) {
    this.ajVelocidadBoca = ajVelocidadBoca;
  }
  
  public double getAjDrag() {
    return this.ajDrag;
  }
  
  public void setAjDrag(double ajDrag) {
    this.ajDrag = ajDrag;
  }
  
  public double getAjElevacion() {
    return this.ajElevacion;
  }
  
  public void setAjElevacion(double ajElevacion) {
    this.ajElevacion = ajElevacion;
  }
  
  public double getAjA0() {
    return this.ajA0;
  }
  
  public void setAjA0(double ajA0) {
    this.ajA0 = ajA0;
  }
  
  public double getAjA1() {
    return this.ajA1;
  }
  
  public void setAjA1(double ajA1) {
    this.ajA1 = ajA1;
  }
  
  public double getDesvUbicacion_Az() {
    return this.desvUbicacion_Az;
  }
  
  public void setDesvUbicacion_Az(double desvOrientacion) {
    this.desvUbicacion_Az = desvOrientacion;
  }
  
  public double getDesvUbicacion_m() {
    return this.desvUbicacion_m;
  }
  
  public void setDesvUbicacion_m(double desvUbicacion_m) {
    this.desvUbicacion_m = desvUbicacion_m;
  }
  
  public double getDesvDistancia() {
    return this.desvDistancia;
  }
  
  public void setDesvDistancia(double desvDistancia) {
    this.desvDistancia = desvDistancia;
  }
  
  public double getDesvAzimut() {
    return this.desvAzimut;
  }
  
  public void setDesvAzimut(double desvAzimut) {
    this.desvAzimut = desvAzimut;
  }
  
  public boolean isBB() {
    return this.isBB;
  }
  
  public void setBB(boolean BB) {
    this.isBB = BB;
  }
  
  public double getTwist() {
    return this.twist;
  }
  
  public void setTwist(double twist) {
    this.twist = twist;
  }
  
  public String getEfecto() {
    return this.efecto;
  }
  
  public void setEfecto(String efecto) {
    this.efecto = efecto;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\municion\Municion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */