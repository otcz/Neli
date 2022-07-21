package co.dynamicts.neli.core.ObusHW;

import co.dynamicts.neli.core.Hardware.FuncionesRadar;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.local.model.RadarHistory;
import co.dynamicts.neli.core.local.service.RadarHistoryService;
import co.dynamicts.neli.core.municion.Municion;
import co.dynamicts.neli.core.municion.Zona;
import co.dynamicts.neli.core.utilities.Tools;
import jssc.SerialPortException;

import java.sql.SQLException;
import java.util.Scanner;

public class MuzzleRadar extends Thread {
  private static MuzzleRadar muzzleRadar;
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  Municion municion = this.configuracion.municion;
  
  public FuncionesRadar funcionesRadar = FuncionesRadar.getSingletonInstance();
  
  private boolean isRadarOk = false;
  
  public double lastVelocity = 0.0D;
  
  private int countFires = 0;
  
  public int coutnAux;
  
  private void saveFire(double velocityFired) {
    System.out.println("Fire");
    if (isCofidenceInterval(desviacionTipica(this.municion.zonaSelec), velocityFired)) {
      System.out.println("Velocidad Registrada con exito");
      registraUltimaVelStd(this.municion.zonaSelec, velocityFired);
    } else {
      System.out.println("Velocidad ilogica");
    } 
    if (this.configuracion.municion.getCantidad() > 0) {
      this.configuracion.municion.setCantidad(this.configuracion.municion.getCantidad() - 1);
      this.configuracion.setCantidadMunicion(this.configuracion.municion.getCantidad());
      this.configuracion.actualizaConfiguracion();
    } 
  }
  
  private double getVelStandard(double tempProp, double velocityFired) {
    double variacion_m_s = this.municion.zonaSelec.getGradienteTemp() * (tempProp - 21.0D);
    double velBoca = variacion_m_s + velocityFired;
    return velBoca;
  }
  
  private double desviacionTipica(Zona zona) {
    double media = zona.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
    double varianza = 0.0D;
    double xi2_fi = 0.0D;
    double[] velocidades = zona.getVelocidades();
    for (int i = 0; i < velocidades.length; i++) {
      double rango = Math.pow(velocidades[i] - media, 2.0D);
      varianza += rango;
    } 
    varianza /= velocidades.length;
    double desviacion = Math.sqrt(varianza);
    return desviacion;
  }
  
  private boolean isCofidenceInterval(double rho, double velocityFired) {
    double vel_med = this.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
    double error = 5.0D;
    double limMenor = vel_med - error;
    double limMayor = vel_med + error;
    double velTiro = getVelStandard(this.configuracion.getTempProp(), velocityFired);
    if (velTiro >= limMenor && velTiro <= limMayor)
      return true; 
    return false;
  }
  
  private void registraUltimaVelStd(Zona zona, double velocityFired) {
    for (int i = zona.velocidades.length - 1; i > 0; i--)
      zona.velocidades[i] = zona.velocidades[i - 1]; 
    zona.velocidades[0] = getVelStandard(this.configuracion.getTempProp(), velocityFired);
    this.configuracion.municion.zonaSelec.velocidades = zona.velocidades;
    this.configuracion.editVelPromAmmo();
    this.configuracion.actualizaConfiguracion();
  }
  
  public void listenerFire() {
    this.countFires = this.funcionesRadar.NumeroDeMedidas;
    if (this.countFires > this.coutnAux) {
      saveFire(getLastVelocity());
      RadarHistory radarHistory = new RadarHistory();
      radarHistory.setDate(Tools.radarImageName());
      radarHistory.setAmmo(this.configuracion.municion.getTipo());
      radarHistory.setEffect(this.configuracion.municion.getEfecto());
      radarHistory.setFuse(this.configuracion.municion.espoletaSelect.getNombre());
      radarHistory.setTemperature(this.configuracion.getTempProp());
      radarHistory.setZone(this.configuracion.municion.zonaSelec.getNumero());
      radarHistory.setVelocity(getLastVelocity());
      try {
        Tools.capterImg(radarHistory.getDate());
      } catch (Exception e) {
        e.printStackTrace();
      } 
      try {
        RadarHistoryService radarHistoryService = new RadarHistoryService();
        radarHistoryService.createTableIfNotExists(RadarHistory.class);
        radarHistoryService.createOrUpdate(radarHistory);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
      this.coutnAux = this.countFires;
    } 
  }
  
  public void run() {
    if (this.configuracion.isSimulado) {
      String entradaTeclado = null;
      Scanner entradaEscaner = new Scanner(System.in);
      System.out.println("Radar is conected");
      while (true) {
        entradaTeclado = entradaEscaner.nextLine();
        System.out.println("Velocidad Medida en radar: \"" + entradaTeclado + "\"");
        this.coutnAux++;
        this.lastVelocity = Double.parseDouble(entradaTeclado);
        listenerFire();
      } 
    } 
    this.funcionesRadar.run();
    this.countFires = this.funcionesRadar.NumeroDeMedidas;
    this.coutnAux = this.countFires;
    while (true) {
      this.funcionesRadar.run();
      actualizarMVR();
      listenerFire();
    } 
  }
  
  void actualizarMVR() {
    if (!this.funcionesRadar.Comunicacion)
      try {
        this.funcionesRadar.IniciarRadar(true);
      } catch (SerialPortException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }  
    setRadarOk(this.funcionesRadar.Comunicacion);
    this.lastVelocity = this.funcionesRadar.Velocidad;
    this.countFires = this.funcionesRadar.NumeroDeMedidas;
  }
  
  public boolean isRadarOk() {
    return this.isRadarOk;
  }
  
  public void setRadarOk(boolean radarOk) {
    this.isRadarOk = radarOk;
  }
  
  public double getLastVelocity() {
    return this.lastVelocity;
  }
  
  public static MuzzleRadar getSingletonInstance() {
    if (muzzleRadar == null)
      muzzleRadar = new MuzzleRadar(); 
    return muzzleRadar;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\ObusHW\MuzzleRadar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */