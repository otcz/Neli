package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.utilities.*;

import java.io.IOException;

public class IngresoOAPolares extends Tools {
  public String nombreOA = new String();
  
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  public PuntoGeograficas observador = new PuntoGeograficas();
  
  public PuntoUTM observadorUTM = new PuntoUTM();
  
  private static IngresoOAPolares ingresoPolares;
  
  private Principal principal = Principal.getSingletonInstance();
  
  private double alturaBlanco;
  
  public Posicion posicion = new Posicion();
  
  private Configuracion configuracion;
  
  public IngresoOAPolares() throws IOException {
    this.configuracion = Configuracion.getSingletonInstance();
  }
  
  public void setBlancoDeseado() throws IOException {
    verificaUnidades();
    this.datosCalculados.blancoDeseadoGeo.punto(this.posicion.ubicaPolares(this.observador, this.posicion.getAzimut(), this.posicion.getDistancia(), getAlturaBlanco()));
    this.datosCalculados.posicionDeseadaMetros = this.posicion;
    this.datosCalculados.calcularDatosPorBlancoDeseado();
    this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.COORDENADAS);
  }
  
  private void verificaUnidades() {
    if (this.configuracion.getUnidadCoordenadas() == Configuracion.UnidadCoordenadas.UTM) {
      ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
      this.observador.punto(ConversorCoordenadas.convertirUTM_a_Geo(this.observadorUTM, "WGS84"));
    } 
    if (this.configuracion.getUnidadAngulo() == Configuracion.UnidadAngulo.GRADOS)
      this.posicion.setAzimut(convierteGrados_a_Milesimas(this.posicion.getAzimut())); 
    if (this.configuracion.getUnidadDistancia() == Configuracion.UnidadDistancia.KILOMETROS) {
      this.posicion.setDistancia(convierteKm_a_Metros(this.posicion.getDistancia()));
      this.posicion.setIntervalo(convierteKm_a_Metros(this.posicion.getIntervalo()));
    } 
  }
  
  public static IngresoOAPolares getSingletonInstance() throws IOException {
    if (ingresoPolares == null)
      ingresoPolares = new IngresoOAPolares(); 
    return ingresoPolares;
  }
  
  private double getAlturaBlanco() {
    return this.alturaBlanco;
  }
  
  public void setAlturaBlanco(double alturaBlanco) {
    this.alturaBlanco = alturaBlanco;
  }
  
  public String getNombreOA() {
    return this.nombreOA;
  }
  
  public void setNombreOA(String nombreOA) {
    this.nombreOA = nombreOA;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\IngresoOAPolares.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */