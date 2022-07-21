package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.utilities.Posicion;
import co.dynamicts.neli.core.utilities.Tools;

import java.io.IOException;

public class IngresoPolares extends Tools {
  private static IngresoPolares ingresoPolares;
  
  private Principal principal = Principal.getSingletonInstance();
  
  private Ins ins = Ins.getSingletonInstance();
  
  private double alturaBlanco;
  
  public Posicion posicion = new Posicion();
  
  private Configuracion configuracion;
  
  private DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  public IngresoPolares() throws IOException {
    this.configuracion = Configuracion.getSingletonInstance();
  }
  
  public void setBlancoDeseado() throws IOException {
    verificaUnidades();
    this.datosCalculados.blancoDeseadoGeo.punto(this.posicion.ubicaPolares(this.ins.obus, this.posicion.getAzimut(), this.posicion.getDistancia(), getAlturaBlanco()));
    this.datosCalculados.posicionDeseadaMetros = this.posicion;
    this.datosCalculados.calcularDatosPorPolares();
    this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.POLARES);
  }
  
  private void verificaUnidades() {
    if (this.configuracion.getUnidadAngulo() == Configuracion.UnidadAngulo.GRADOS)
      this.posicion.setAzimut(convierteGrados_a_Milesimas(this.posicion.getAzimut())); 
    if (this.configuracion.getUnidadDistancia() == Configuracion.UnidadDistancia.KILOMETROS) {
      this.posicion.setDistancia(convierteKm_a_Metros(this.posicion.getDistancia()));
      this.posicion.setIntervalo(convierteKm_a_Metros(this.posicion.getIntervalo()));
    } 
  }
  
  public static IngresoPolares getSingletonInstance() throws IOException {
    if (ingresoPolares == null)
      ingresoPolares = new IngresoPolares(); 
    return ingresoPolares;
  }
  
  private double getAlturaBlanco() {
    return this.alturaBlanco;
  }
  
  public void setAlturaBlanco(double alturaBlanco) {
    this.alturaBlanco = alturaBlanco;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\IngresoPolares.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */