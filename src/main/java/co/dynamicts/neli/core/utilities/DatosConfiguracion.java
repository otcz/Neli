package co.dynamicts.neli.core.utilities;

import java.io.Serializable;

public class DatosConfiguracion implements Serializable {
  private String uniDistancia;
  
  private String uniAngulo;
  
  private String uniCoordenada;
  
  private String tipoMunicion;
  
  private int cargaMunicion;
  
  private int cuadrosMunicion;
  
  private String modoZUPT;
  
  private String lenguaje;
  
  public DatosConfiguracion(String uniDistancia, String uniAngulo, String uniCoordenada, String tipoMunicion, int cargaMunicion, int cuadrosMunicion, String modoZUPT, String lenguaje) {
    this.uniDistancia = uniDistancia;
    this.uniAngulo = uniAngulo;
    this.uniCoordenada = uniCoordenada;
    this.tipoMunicion = tipoMunicion;
    this.cargaMunicion = cargaMunicion;
    this.cuadrosMunicion = cuadrosMunicion;
    this.modoZUPT = modoZUPT;
    this.lenguaje = lenguaje;
  }
  
  public String getUniDistancia() {
    return this.uniDistancia;
  }
  
  public String getUniAngulo() {
    return this.uniAngulo;
  }
  
  public String getUniCoordenada() {
    return this.uniCoordenada;
  }
  
  public String getTipoMunicion() {
    return this.tipoMunicion;
  }
  
  public int getCargaMunicion() {
    return this.cargaMunicion;
  }
  
  public int getCuadrosMunicion() {
    return this.cuadrosMunicion;
  }
  
  public String getModoZUPT() {
    return this.modoZUPT;
  }
  
  public String getLenguaje() {
    return this.lenguaje;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\DatosConfiguracion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */