package co.dynamicts.neli.core.utilities;

public class Posicion extends Tools {
  public PuntoGeograficas puntoA = new PuntoGeograficas();
  
  public PuntoGeograficas puntoB = new PuntoGeograficas();
  
  private double distancia = 0.0D;
  
  private double azimut = 0.0D;
  
  private double intervalo = 0.0D;
  
  private double alturaMSNM_A = 0.0D;
  
  public Posicion() {}
  
  public Posicion(PuntoGeograficas puntoReferencia, double azimut, double distancia, double altura) {
    this.puntoA = puntoReferencia;
    this.puntoB = ubicaPolares(puntoReferencia, azimut, distancia, altura);
    this.azimut = azimut;
    this.distancia = distancia;
    this.alturaMSNM_A = puntoReferencia.getAltura();
    setIntervalo();
  }
  
  public Posicion(PuntoGeograficas puntoA, PuntoGeograficas puntoB) {
    this.puntoA = puntoA;
    this.puntoB = puntoB;
    this.alturaMSNM_A = puntoA.getAltura();
    calculaDistanciaCoordenadas();
    calculaAzimutCoordenadas();
    setIntervalo();
  }
  
  private void calculaAzimutCoordenadas() {
    this.azimut = Distancia.bearing(this.puntoA, this.puntoB);
  }
  
  private void calculaDistanciaCoordenadas() {
    double LonA = this.puntoA.getLongitud();
    double LatA = this.puntoA.getLatitud();
    double LonB = this.puntoB.getLongitud();
    double LatB = this.puntoB.getLatitud();
    this.alturaMSNM_A = this.puntoA.getAltura();
    this.distancia = Distancia.vincentyDistance(this.puntoA, this.puntoB);
  }
  
  public PuntoGeograficas ubicaPolares(PuntoGeograficas puntoOrigen, double azimut, double distancia, double altura) {
    PuntoGeograficas puntoDestino = new PuntoGeograficas();
    puntoDestino = Distancia.pointAt(puntoOrigen, azimut, distancia);
    double primeraDistancia = Distancia.vincentyDistance(puntoOrigen, puntoDestino);
    double difDistancia = distancia - primeraDistancia;
    while (Math.abs(difDistancia) >= 1.5D) {
      puntoDestino = Distancia.pointAt(puntoOrigen, azimut, distancia + difDistancia);
      double distanciaPuntoDestino = Distancia.vincentyDistance(puntoOrigen, puntoDestino);
      difDistancia = distancia - distanciaPuntoDestino;
    } 
    puntoDestino.setAltura(altura);
    this.puntoA.punto(puntoOrigen);
    this.puntoB.punto(puntoDestino);
    this.alturaMSNM_A = this.puntoA.getAltura();
    setIntervalo();
    return puntoDestino;
  }
  
  public void setIntervalo(double intervalo) {
    this.intervalo = intervalo;
  }
  
  public void setIntervalo() {
    this.intervalo = this.puntoB.getAltura() - this.puntoA.getAltura();
  }
  
  public double getIntervalo() {
    return this.intervalo;
  }
  
  public void setAzimut(double azimut) {
    this.azimut = azimut;
  }
  
  public double getAzimut() {
    return this.azimut;
  }
  
  public void setDistancia(double distancia) {
    this.distancia = distancia;
  }
  
  public double getDistancia() {
    if (this.distancia == 0.0D)
      calculaDistanciaCoordenadas(); 
    return this.distancia;
  }
  
  public void setAlturaMSNM_A(double alturaMSNM_A) {
    this.alturaMSNM_A = alturaMSNM_A;
  }
  
  public double getAlturaMSNM_A() {
    return this.alturaMSNM_A;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\Posicion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */