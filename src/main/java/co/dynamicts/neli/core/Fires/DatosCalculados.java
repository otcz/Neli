package co.dynamicts.neli.core.Fires;

import co.dynamicts.Main;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Limites;
import co.dynamicts.neli.core.municion.Zona;
import co.dynamicts.neli.core.trayectoria.Trayectoria;
import co.dynamicts.neli.core.utilities.*;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.StringUtil;

import java.io.IOException;

public class DatosCalculados {
  private static DatosCalculados datosCalculados;
  
  public Actitud actitudDeseadaMils = new Actitud();
  
  public PuntoGeograficas blancoDeseadoGeo = new PuntoGeograficas();
  
  public Posicion posicionDeseadaMetros = new Posicion();
  
  private boolean isBlancoSetting = false;
  
  public PuntoUTM blancoDeseadoUTM = new PuntoUTM();
  
  public Trayectoria trayectoriaDeseada = new Trayectoria();
  
  public Trayectoria trayectoriaAlturaExplosion = new Trayectoria();
  
  private Limites limites;
  
  private PuntoGeograficas obusGeo = new PuntoGeograficas();
  
  DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
  
  private Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private Ins ins = Ins.getSingletonInstance();
  
  Tools tools = new Tools();
  
  private boolean isPosible;
  
  private double graduacionEsp = 0.0D;
  
  public DatosCalculados() throws IOException {
    this.posicionDeseadaMetros.puntoA.punto(this.ins.obus);
    this.posicionDeseadaMetros.setAlturaMSNM_A(this.ins.obus.getAltura());
  }
  
  public void calcularDatosPorBlancoDeseado() {
    if (this.blancoDeseadoGeo.getLongitud() != 0.0D && this.blancoDeseadoGeo.getLatitud() != 0.0D) {
      setBlancoSetting(true);
      this.obusGeo = this.ins.obus;
      this.posicionDeseadaMetros = new Posicion(this.obusGeo, this.blancoDeseadoGeo);
      this.datosApuntados.setIntervalo(this.posicionDeseadaMetros.getIntervalo());
      this.datosApuntados.blancoApuntado.setAltura(this.blancoDeseadoGeo.getAltura());
      ConversorCoordenadas conversorCoordenadasBlancoDeseado = new ConversorCoordenadas();
      this.blancoDeseadoUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.blancoDeseadoGeo, "WGS84");
      if (this.configuracion.isRasante()) {
        calculoDesdePosicionRas();
      } else {
        calculoDesdePosicionGA();
      } 
      this.isBlancoSetting = true;
    } else {
      this.isBlancoSetting = false;
      this.posicionDeseadaMetros.setDistancia(0.0D);
    } 
  }
  
  public void calcularDatosBlancoMovil() {
    Posicion posicion = new Posicion(this.obusGeo, this.blancoDeseadoGeo);
    ConversorCoordenadas conversorCoordenadasBlancoDeseado = new ConversorCoordenadas();
    this.blancoDeseadoUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.blancoDeseadoGeo, "WGS84");
    if (this.configuracion.isRasante()) {
      maxRangeInZoneSelect();
      if (posicion.getDistancia() <= this.configuracion.municion.zonaSelec.getMaxRange()) {
        if (this.configuracion.municion.espoletaSelect.getEfecto().equals("TIME"))
          posicion.puntoB.setAltura(this.blancoDeseadoGeo.getAltura() + this.configuracion.getAlturaExplosion_m()); 
        Trayectoria trayectoriaMovil = new Trayectoria();
        this.actitudDeseadaMils.setElevacion(trayectoriaMovil.calculaAnguloMilsRas(posicion));
        double DriftDeseado = trayectoriaMovil.getTDC();
        this.actitudDeseadaMils.setAzimut(Tools.restringeValores(posicion.getAzimut() + DriftDeseado, 6400.0D, 0.0D));
        setPosible(trayectoriaMovil.isPosible());
        this.configuracion.setTipoCalculo(Configuracion.TipoCalculo.MOVIL);
        CPA.getSingletonInstance().setAppointindSignal(false);
      } else {
        this.actitudDeseadaMils.setElevacion(0.0D);
        targetImpossible();
      } 
    } 
  }
  
  public void calcularDatosPorPolares() throws IOException {
    this.datosApuntados.setIntervalo(this.posicionDeseadaMetros.getIntervalo());
    this.datosApuntados.blancoApuntado.setAltura(this.blancoDeseadoGeo.getAltura());
    if (this.configuracion.isRasante()) {
      calculoDesdePosicionRas();
    } else {
      calculoDesdePosicionGA();
    } 
  }
  
  public void calcularDatosPorDatosTiro(Actitud actitudDatosTiro, double alturaBlanco) throws IOException {
    this.obusGeo = this.ins.obus;
    this.actitudDeseadaMils = actitudDatosTiro;
    Trayectoria trayectoria = new Trayectoria();
    this.posicionDeseadaMetros.setDistancia(trayectoria.calculaDistancia(this.posicionDeseadaMetros, this.actitudDeseadaMils.getElevacion()));
    double drift = trayectoria.getTDC();
    this.posicionDeseadaMetros.setAzimut(this.actitudDeseadaMils.getAzimut() - drift);
    this.blancoDeseadoGeo.punto(this.posicionDeseadaMetros.ubicaPolares(this.obusGeo, this.posicionDeseadaMetros.getAzimut(), this.posicionDeseadaMetros.getDistancia(), alturaBlanco));
    this.blancoDeseadoGeo.setAltura(alturaBlanco);
    setPosible(true);
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
    Main.getAppController().setInfoMessage(StringUtil.translateKey("status.data"), "CONFIRMATION");
  }
  
  public void setCriterio() {
    if (this.ins.obus != null)
      setMaxRangeInZonas(); 
    if (this.configuracion.getCriterio() == Configuracion.Criterio.VIDA_CANON) {
      for (int i = 0; i < this.configuracion.municion.zonas.size(); i++) {
        Zona zona = (Zona) this.configuracion.municion.zonas.get(i);
        if (this.posicionDeseadaMetros.getDistancia() <= zona.getMaxRange()) {
          this.configuracion.municion.zonaSelec = zona;
          this.configuracion.setNumeroZona(zona.getNumero());
          setBlancoSetting(true);
          setPosible(true);
          break;
        } 
        setBlancoSetting(false);
        setPosible(false);
        System.out.println("Datos calculados.SetCargaCalculo: Distancia imposible:" + this.posicionDeseadaMetros.getDistancia());
      } 
    } else if (this.configuracion.getCriterio() == Configuracion.Criterio.SUPERVIVENCIA) {
      for (int i = this.configuracion.municion.zonas.size() - 1; i >= 0; i--) {
        Zona zona = (Zona) this.configuracion.municion.zonas.get(i);
        if (this.posicionDeseadaMetros.getDistancia() + 80.0D <= zona.getMaxRange()) {
          this.configuracion.municion.zonaSelec = zona;
          this.configuracion.setNumeroZona(zona.getNumero());
          setBlancoSetting(true);
          setPosible(true);
          break;
        } 
        setBlancoSetting(false);
        setPosible(false);
        System.out.println("Datos calculados.SetCargaCalculo: Distancia imposible:" + this.posicionDeseadaMetros.getDistancia());
      } 
    } else if (this.configuracion.getCriterio() == Configuracion.Criterio.AJUSTE_DISTANCIA) {
      for (int i = 0; i < this.configuracion.municion.zonas.size(); i++) {
        Zona zona = (Zona) this.configuracion.municion.zonas.get(i);
        if (this.posicionDeseadaMetros.getDistancia() + 1000.0D <= zona.getMaxRange()) {
          this.configuracion.municion.zonaSelec = zona;
          this.configuracion.setNumeroZona(zona.getNumero());
          setBlancoSetting(true);
          setPosible(true);
          break;
        } 
        setBlancoSetting(false);
        setPosible(false);
        System.out.println("Datos calculados.SetCargaCalculo: Distancia imposible:" + this.posicionDeseadaMetros.getDistancia());
      } 
    } else if (this.configuracion.getCriterio() == Configuracion.Criterio.MANUAL) {
      this.configuracion.actualizaConfiguracion();
    } 
  }
  
  private void calculoDesdePosicionRas() {
    setCriterio();
    Zona zonaSeleccionada = this.configuracion.municion.zonaSelec;
    maxRangeInZoneSelect();
    if (this.posicionDeseadaMetros.getDistancia() <= this.configuracion.municion.zonaSelec.getMaxRange()) {
      if (this.configuracion.municion.espoletaSelect.getEfecto().equals("TIME"))
        this.posicionDeseadaMetros.puntoB.setAltura(this.blancoDeseadoGeo.getAltura() + this.configuracion.getAlturaExplosion_m()); 
      this.actitudDeseadaMils.setElevacion(this.trayectoriaDeseada.calculaAnguloMilsRas(this.posicionDeseadaMetros));
      this.trayectoriaDeseada.calculaError(this.posicionDeseadaMetros, this.actitudDeseadaMils.getElevacion());
      ConversorCoordenadas conversorCoordenadasBlancoDeseado = new ConversorCoordenadas();
      double DriftDeseado = this.trayectoriaDeseada.getTDC();
      this.actitudDeseadaMils.setAzimut(Tools.restringeValores(this.posicionDeseadaMetros.getAzimut() + DriftDeseado, 6400.0D, 0.0D));
      this.blancoDeseadoUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.blancoDeseadoGeo, "WGS84");
      CPA.getSingletonInstance().setAppointindSignal(false);
      try {
        this.limites = Limites.getSingletonInstance();
      } catch (IOException e) {
        e.printStackTrace();
      } 
      this.limites.checkAutomatico();
      setPosible(this.trayectoriaDeseada.isPosible());
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
      Main.getAppController().setInfoMessage(StringUtil.translateKey("status.data"), "CONFIRMATION");
    } else {
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
      Main.getAppController().setInfoMessage(StringUtil.translateKey("alert.content.target.loaded.error"), "ERROR");
      this.actitudDeseadaMils.setElevacion(0.0D);
      targetImpossible();
    } 
  }
  
  private void calculoDesdePosicionGA() {
    setCriterio();
    maxRangeInZoneSelect();
    if (this.posicionDeseadaMetros.getDistancia() <= this.configuracion.municion.zonaSelec.getMaxRange()) {
      this.actitudDeseadaMils.setElevacion(this.trayectoriaDeseada.calculaAnguloMilsGA(this.posicionDeseadaMetros));
      this.trayectoriaDeseada.calculaError(this.posicionDeseadaMetros, this.actitudDeseadaMils.getElevacion());
      ConversorCoordenadas conversorCoordenadasBlancoDeseado = new ConversorCoordenadas();
      double DriftDeseado = this.trayectoriaDeseada.getTDC();
      this.actitudDeseadaMils.setAzimut(Tools.restringeValores(this.posicionDeseadaMetros.getAzimut() + DriftDeseado, 6400.0D, 0.0D));
      this.blancoDeseadoUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.blancoDeseadoGeo, "WGS84");
      CPA.getSingletonInstance().setAppointindSignal(false);
      try {
        this.limites = Limites.getSingletonInstance();
      } catch (IOException e) {
        e.printStackTrace();
      } 
      this.limites.checkAutomatico();
      setPosible(this.trayectoriaDeseada.isPosible());
      System.out.println("Datos Calculados: calculos exitosos, municion BB: " + this.configuracion.municion.isBB());
    } else {
      targetImpossible();
    } 
  }
  
  private void maxRangeInZoneSelect() {
    Zona zonaSeleccionada = this.configuracion.municion.zonaSelec;
    Trayectoria trayectoria = new Trayectoria();
    double distanciaMax = trayectoria.calculaDistancia(this.posicionDeseadaMetros, zonaSeleccionada.getQeMaxR());
    zonaSeleccionada.setMaxRange(distanciaMax);
    this.configuracion.municion.zonaSelec.setMaxRange(distanciaMax);
  }
  
  public void setMaxRangeInZonas() {
    Posicion posicionMax = new Posicion();
    posicionMax.setIntervalo(this.posicionDeseadaMetros.getIntervalo());
    posicionMax.puntoA.punto(this.posicionDeseadaMetros.puntoA);
    posicionMax.puntoB.punto(this.posicionDeseadaMetros.puntoB);
    posicionMax.setAlturaMSNM_A(this.ins.obus.getAltura());
    posicionMax.setAzimut(this.posicionDeseadaMetros.getAzimut());
    int nroZonaActual = this.configuracion.municion.zonaSelec.getNumero();
    Zona[] zonas = new Zona[this.configuracion.municion.getNumeroZonas()];
    int i;
    for (i = 0; i < this.configuracion.municion.getNumeroZonas(); i++) {
      Zona zona = (Zona) this.configuracion.municion.zonas.get(i);
      this.configuracion.setNumeroZona(zona.getNumero());
      this.configuracion.actualizaConfiguracion();
      Trayectoria trajectotyMaxRange = new Trayectoria();
      zona.setMaxRange(trajectotyMaxRange.calculaDistancia(posicionMax, zona.getQeMaxR()));
      zonas[i] = zona;
      this.configuracion.municion.zonas.set(i, zonas[i]);
    } 
    this.configuracion.setNumeroZona(nroZonaActual);
    for (i = 0; i < this.configuracion.municion.getNumeroZonas(); i++)
      this.configuracion.municion.zonas.set(i, zonas[i]); 
  }
  
  private void targetImpossible() {
    setPosible(false);
    setBlancoSetting(false);
    System.out.println("Datos Calculados:Alcance imposible: " + this.configuracion.municion.zonaSelec.getMaxRange() + " / " + this.posicionDeseadaMetros.getDistancia() + "(" + this.configuracion.municion.zonaSelec.getQeMaxR() + ") mils");
    if (this.posicionDeseadaMetros.getDistancia() > 48000.0D) {
      this.posicionDeseadaMetros.setDistancia(0.0D);
      try {
        this.limites = Limites.getSingletonInstance();
        this.limites.setLimitsTargetImpossible();
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
    Main.getAppController().setInfoMessage(StringUtil.translateKey("status.left.limit"), "INFO");
  }
  
  public void setPosible(boolean posible) {
    this.isPosible = posible;
  }
  
  public boolean isPosible() {
    return this.isPosible;
  }
  
  public double getGraduacionEsp() {
    return this.graduacionEsp;
  }
  
  public void setGraduacionEsp(double graduacionEsp) {
    this.graduacionEsp = graduacionEsp;
  }
  
  public void setBlancoSetting(boolean blancoSetting) {
    this.isBlancoSetting = blancoSetting;
  }
  
  public boolean isBlancoSetting() {
    return this.isBlancoSetting;
  }
  
  public static DatosCalculados getSingletonInstance() {
    if (datosCalculados == null)
      try {
        datosCalculados = new DatosCalculados();
      } catch (IOException e) {
        e.printStackTrace();
      }  
    return datosCalculados;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Fires\DatosCalculados.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */