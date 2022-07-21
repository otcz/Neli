package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.utilities.*;

import java.io.IOException;

public class Correcciones extends Tools {
  public PuntoGeograficas observador = new PuntoGeograficas();
  
  public PuntoUTM observadorUTM = new PuntoUTM();
  
  private Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private Principal principal = Principal.getSingletonInstance();
  
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  private Posicion posicion;
  
  private static Correcciones correcciones;
  
  boolean isOAIn;
  
  public void correccion(double alargar, double acortar, double derecha, double izquierda, double subir, double bajar) throws IOException {
    if (this.configuracion.getUnidadCoordenadas() == Configuracion.UnidadCoordenadas.UTM) {
      ConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();
      this.observador.punto(ConversorCoordenadas.convertirUTM_a_Geo(this.observadorUTM, "WGS84"));
    } 
    if (this.configuracion.getUnidadDistancia() == Configuracion.UnidadDistancia.KILOMETROS) {
      alargar = convierteKm_a_Metros(alargar);
      acortar = convierteKm_a_Metros(acortar);
      derecha = convierteKm_a_Metros(derecha);
      izquierda = convierteKm_a_Metros(izquierda);
    } 
    PuntoGeograficas blancoActual = this.datosCalculados.blancoDeseadoGeo;
    if (blancoActual.getLongitud() == 0.0D)
      sinBlancoDeseado(); 
    this.posicion = new Posicion(this.observador, blancoActual);
    double disOA_PR = this.posicion.getDistancia();
    if (disOA_PR <= 5000.0D) {
      setOAIn(true);
    } else {
      setOAIn(false);
    } 
    double AziOA_PR = this.posicion.getAzimut();
    double AnguloCorreccion = calculaAnguloCatetosMilesimas(derecha - izquierda, disOA_PR);
    double AzimutCorreccion = AziOA_PR + AnguloCorreccion;
    double DisCorreccioon = disOA_PR + alargar - acortar;
    double alturaCorr = blancoActual.getAltura() + subir - bajar;
    Posicion posicion2 = new Posicion(blancoActual, AzimutCorreccion, DisCorreccioon, blancoActual.getAltura());
    this.datosCalculados.blancoDeseadoGeo.punto(this.posicion.ubicaPolares(this.observador, AzimutCorreccion, DisCorreccioon, alturaCorr));
    this.datosCalculados.calcularDatosPorBlancoDeseado();
  }
  
  private void sinBlancoDeseado() {
    System.out.println("Por favor verifique el blanco deseado actual");
  }
  
  public static Correcciones getSingletonInstance() throws IOException {
    if (correcciones == null)
      correcciones = new Correcciones(); 
    return correcciones;
  }
  
  public boolean isOAIn() {
    return this.isOAIn;
  }
  
  public void setOAIn(boolean OAIn) {
    this.isOAIn = OAIn;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\Correcciones.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */