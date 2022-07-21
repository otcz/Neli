package co.dynamicts.neli.core.Fires;

import co.dynamicts.Main;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.trayectoria.MetDesviacion;
import co.dynamicts.neli.core.trayectoria.Trayectoria;
import co.dynamicts.neli.core.utilities.*;
import co.dynamicts.neli.ui.utils.StringUtil;

import java.io.IOException;

public class DatosApuntados {
  private static DatosApuntados datosApuntados;
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  public Posicion posicionApuntadaMetros = new Posicion();
  
  public Posicion posicionCarta = new Posicion();
  
  Ins ins = Ins.getSingletonInstance();
  
  Tools tools = new Tools();
  
  public Trayectoria trayectoriaApuntada = new Trayectoria();
  
  MetDesviacion metDesviacion = new MetDesviacion();
  
  private double alturaMSNM = 0.0D;
  
  private double intervalo = 0.0D;
  
  private double alcance;
  
  private double ordMax;
  
  private double ordMaxFt;
  
  private double drift;
  
  private double tiempoVuelo;
  
  public PuntoGeograficas blancoApuntado = new PuntoGeograficas();
  
  public PuntoUTM blancoApuntadoUTM = new PuntoUTM();
  
  private double corrTotalDeflex;
  
  private double err_prec_Distancia;
  
  private double err_prec_Orientac;
  
  private double err_PMI_Distancia;
  
  private double err_PMI_Orientacion;
  
  double velBoca;
  
  public DatosApuntados() throws IOException {
    this.velBoca = this.configuracion.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
    this.blancoApuntado.setAltura((Ins.getSingletonInstance()).obus.getAltura());
  }
  
  public void calcularDatosPorActitudApuntada() {
    try {
      if (!DatosCalculados.getSingletonInstance().isBlancoSetting()) {
        this.blancoApuntado.setAltura(this.ins.obus.getAltura());
        this.posicionCarta.setDistancia(0.0D);
        this.posicionCarta.setAzimut(0.0D);
      } else {
        this.blancoApuntado.setAltura((DatosCalculados.getSingletonInstance()).blancoDeseadoGeo.getAltura());
        this.posicionCarta = new Posicion(this.ins.obus, (DatosCalculados.getSingletonInstance()).blancoDeseadoGeo);
      } 
      this.posicionApuntadaMetros.puntoA.punto(this.ins.obus);
      this.posicionApuntadaMetros.puntoB.punto(this.blancoApuntado);
      this.posicionApuntadaMetros.setAlturaMSNM_A(this.ins.obus.getAltura());
      this.posicionApuntadaMetros.setAzimut(this.ins.actitud.getAzimut());
      this.posicionApuntadaMetros.setDistancia(this.trayectoriaApuntada.calculaDistancia(this.posicionApuntadaMetros, this.ins.actitud.getElevacion()));
      this.corrTotalDeflex = this.trayectoriaApuntada.getTDC();
      this.blancoApuntado.punto(this.posicionApuntadaMetros.ubicaPolares(this.posicionApuntadaMetros.puntoA, this.ins.actitud.getAzimut() - this.corrTotalDeflex, this.posicionApuntadaMetros.getDistancia(), this.blancoApuntado.getAltura()));
      ConversorCoordenadas conversorCoordenadasBlancoApuntado = new ConversorCoordenadas();
      this.posicionApuntadaMetros.puntoB.punto(this.blancoApuntado);
      this.blancoApuntadoUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.blancoApuntado, "WGS84");
      this.drift = this.trayectoriaApuntada.getDrift_deflection_corr();
      this.tiempoVuelo = this.trayectoriaApuntada.getTime();
      this.alcance = this.posicionApuntadaMetros.getDistancia();
      this.ordMax = this.trayectoriaApuntada.getOrdMax();
      this.intervalo = this.posicionApuntadaMetros.getIntervalo();
      this.trayectoriaApuntada.calculaError(this.posicionApuntadaMetros, this.ins.actitud.getElevacion());
      this.err_PMI_Distancia = this.trayectoriaApuntada.getSigma_X_MPI();
      this.err_PMI_Orientacion = this.trayectoriaApuntada.getSigma_Z_MPI();
      this.err_prec_Distancia = this.trayectoriaApuntada.getSigma_PX_PE();
      this.err_prec_Orientac = this.trayectoriaApuntada.getSigma_PZ_PE();
    } catch (Exception e) {
      Main.getAppController().setInfoMessage(StringUtil.translateKey("status.ammo.bug"), "ERROR");
      return;
    } 
  }
  
  public void setAlturaMSNM(double alturaMSNM) {
    this.alturaMSNM = alturaMSNM;
  }
  
  public void setIntervalo(double intervalo) {
    this.intervalo = intervalo;
  }
  
  public double getAlcance() {
    return this.alcance;
  }
  
  public double getOrdMax() {
    return this.ordMax;
  }
  
  public double getOrdMaxFt() {
    return this.ordMaxFt;
  }
  
  public double getDrift() {
    return this.drift;
  }
  
  public double getCorrTotalDeflex() {
    return this.corrTotalDeflex;
  }
  
  public double getErr_prec_Distancia() {
    return this.err_prec_Distancia;
  }
  
  public double getErr_prec_Orientac() {
    return this.err_prec_Orientac;
  }
  
  public double getErr_PMI_Distancia() {
    return this.err_PMI_Distancia;
  }
  
  public double getErr_PMI_Orientacion() {
    return this.err_PMI_Orientacion;
  }
  
  public double getTiempoVuelo() {
    return this.tiempoVuelo;
  }
  
  public static DatosApuntados getSingletonInstance() {
    if (datosApuntados == null)
      try {
        datosApuntados = new DatosApuntados();
      } catch (IOException e) {
        e.printStackTrace();
      }  
    return datosApuntados;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Fires\DatosApuntados.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */