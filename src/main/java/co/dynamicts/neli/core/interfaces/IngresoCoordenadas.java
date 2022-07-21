package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.utilities.ConversorCoordenadas;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.PuntoUTM;

import java.io.IOException;

public class IngresoCoordenadas {
  private Principal principal = Principal.getSingletonInstance();
  
  public PuntoGeograficas blancoDeseadoGeograficas = new PuntoGeograficas();
  
  public PuntoUTM blancoDeseadoUTM = new PuntoUTM();
  
  private Configuracion configuracion;
  
  private static IngresoCoordenadas ingresoCoordenadas;
  
  private DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  private IngresoCoordenadas() throws IOException {
    this.configuracion = Configuracion.getSingletonInstance();
  }
  
  public void setBlancoDeseado() throws IOException {
    if (this.configuracion.getUnidadCoordenadas() == Configuracion.UnidadCoordenadas.GEOGRAFICAS) {
      this.datosCalculados.blancoDeseadoGeo.punto(this.blancoDeseadoGeograficas);
    } else if (this.configuracion.getUnidadCoordenadas() == Configuracion.UnidadCoordenadas.UTM) {
      ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
      this.datosCalculados.blancoDeseadoGeo.punto(ConversorCoordenadas.convertirUTM_a_Geo(this.blancoDeseadoUTM, "WGS84"));
    } 
    this.datosCalculados.calcularDatosPorBlancoDeseado();
    this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.COORDENADAS);
  }
  
  public static IngresoCoordenadas getSingletonInstance() throws IOException {
    if (ingresoCoordenadas == null)
      ingresoCoordenadas = new IngresoCoordenadas(); 
    return ingresoCoordenadas;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\IngresoCoordenadas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */