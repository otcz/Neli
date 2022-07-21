package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.utilities.Posicion;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.PuntoUTM;

import java.io.IOException;

public class MovilTarget implements Runnable {
  private static MovilTarget movilTarget;
  
  DatosCalculados datosCalculados;
  
  public PuntoGeograficas puntoPartidaGeo = new PuntoGeograficas();
  
  public PuntoGeograficas blancoActualGeo = new PuntoGeograficas();
  
  public PuntoUTM puntoPartidaUTM = new PuntoUTM();
  
  public PuntoUTM blancoActualUTM = new PuntoUTM();
  
  private Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private double velocidad;
  
  private double azimuth;
  
  private boolean seguir;
  
  private boolean takeTimeStart;
  
  long inicio = 0L;
  
  public void run() {
    following();
  }
  
  public void following() {
    if (this.takeTimeStart) {
      this.inicio = System.currentTimeMillis();
      this.takeTimeStart = false;
    } 
    this.datosCalculados = DatosCalculados.getSingletonInstance();
    FuncionesCPA funcionesCPA = FuncionesCPA.getSingletonInstance();
    Ins ins = Ins.getSingletonInstance();
    while (this.seguir) {
      long fin = System.currentTimeMillis();
      double tiempo = ((fin - this.inicio) / 1000L);
      setPointTime(tiempo);
      this.datosCalculados.blancoDeseadoGeo = this.blancoActualGeo;
      this.datosCalculados.calcularDatosBlancoMovil();
      FuncionesCPA.AzimuthObjetivo = (float)this.datosCalculados.actitudDeseadaMils.getAzimut();
      FuncionesCPA.PitchObjetivo = (float)this.datosCalculados.actitudDeseadaMils.getElevacion();
      funcionesCPA.Comando = FuncionesCPA.apuntar;
      this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.MOVIL);
    } 
  }
  
  private void setPointTime(double timeSeg) {
    double velocidad_m_x_s = this.velocidad * 1000.0D / 3600.0D;
    double distancia = velocidad_m_x_s * timeSeg;
    Posicion posicion = new Posicion();
    this.blancoActualGeo = posicion.ubicaPolares(this.puntoPartidaGeo, this.azimuth, distancia, this.puntoPartidaGeo.getAltura());
  }
  
  public double getVelocidad() {
    return this.velocidad;
  }
  
  public void setVelocidad(double velocidad) {
    this.velocidad = velocidad;
  }
  
  public double getAzimuth() {
    return this.azimuth;
  }
  
  public void setAzimuth(double azimuth) {
    this.azimuth = azimuth;
  }
  
  public boolean isSeguir() {
    return this.seguir;
  }
  
  public void setSeguir(boolean seguir) {
    this.seguir = seguir;
  }
  
  public boolean isTakeTimeStart() {
    return this.takeTimeStart;
  }
  
  public void setTakeTimeStart(boolean takeTimeStart) {
    this.takeTimeStart = takeTimeStart;
  }
  
  public static MovilTarget getSingletonInstance() throws IOException {
    if (movilTarget == null)
      movilTarget = new MovilTarget(); 
    return movilTarget;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\MovilTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */