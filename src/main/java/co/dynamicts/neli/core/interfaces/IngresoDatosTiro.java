package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.utilities.Actitud;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.Tools;

import java.io.IOException;

public class IngresoDatosTiro extends Tools {
  private static IngresoDatosTiro ingresoDatosTiro;
  
  private Principal principal = Principal.getSingletonInstance();
  
  public PuntoGeograficas blancoDeseado = new PuntoGeograficas();
  
  private double alturaBlanco;
  
  private int carga;
  
  private DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  private int getCarga() {
    return this.carga;
  }
  
  public void setCarga(int carga) {
    this.carga = carga;
  }
  
  private double getAlturaBlanco() {
    return this.alturaBlanco;
  }
  
  public void setAlturaBlanco(double alturaBlanco) {
    this.alturaBlanco = alturaBlanco;
  }
  
  public Actitud actitud = new Actitud();
  
  private Configuracion configuracion;
  
  public IngresoDatosTiro() throws IOException {
    this.configuracion = Configuracion.getSingletonInstance();
  }
  
  public void setBlancoDeseado() throws IOException {
    verificaUnidades();
    this.datosCalculados.actitudDeseadaMils = this.actitud;
    this.datosCalculados.calcularDatosPorDatosTiro(this.actitud, getAlturaBlanco());
    this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.PUNTERIA);
  }
  
  private void verificaUnidades() {
    if (this.configuracion.getUnidadAngulo() == Configuracion.UnidadAngulo.GRADOS) {
      this.actitud.setAzimut(convierteGrados_a_Milesimas(this.actitud.getAzimut()));
      this.actitud.setElevacion(convierteGrados_a_Milesimas(this.actitud.getElevacion()));
    } 
    if (this.configuracion.getUnidadDistancia() == Configuracion.UnidadDistancia.KILOMETROS)
      setAlturaBlanco(convierteKm_a_Metros(getAlturaBlanco())); 
  }
  
  public static IngresoDatosTiro getSingletonInstance() throws IOException {
    if (ingresoDatosTiro == null)
      ingresoDatosTiro = new IngresoDatosTiro(); 
    return ingresoDatosTiro;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\IngresoDatosTiro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */