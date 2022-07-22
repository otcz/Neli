package co.dynamicts.neli.core.Hardware;

import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.sensors.events.EventDispatcher;
import co.dynamicts.neli.core.utilities.*;
import co.dynamicts.neli.core.utilities.declination.Declination;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

public class InsEthernet extends EventDispatcher {
  private static InsEthernet insEthernet;
  
  boolean isSimulado;
  
  private final int PUERTO = 8110;
  
  private boolean isZuptTiro = false;
  
  private boolean isOdo = true;
  
  public Time timeOn = new Time();
  
  public Ins.EstadoGPS estadoGPS;
  
  public Ins.EstadoINS estadoINS;
  
  private boolean isForcedCoordinates = false;
  
  private String HOST;
  
  protected String mensajeServidor;
  
  protected ServerSocket ss;
  
  public Socket cs;
  
  private DataOutputStream salidaServidor;
  
  private DataOutputStream salidaCliente;
  
  public Actitud actitud = new Actitud();
  
  public PuntoGeograficas obusGeo = new PuntoGeograficas();
  
  public PuntoGeograficas obusForzado = new PuntoGeograficas();
  
  public PuntoGeograficas gpsGeo = new PuntoGeograficas();
  
  public PuntoUTM obusUTM = new PuntoUTM();
  
  public PuntoUTM obusUTMForzado = new PuntoUTM();
  
  public PuntoUTM gpsUTM = new PuntoUTM();
  
  double magneticOrientation = 0.0D;
  
  boolean zuptflagChange = false;
  
  boolean forceCoordChange = false;
  
  DataInputStream entradaCliente;
  
  private String valorEntrada = "";
  
  private static ArrayList listeners;
  
  public InsEthernet(boolean isSimulado) throws IOException {
    this.isSimulado = isSimulado;
    if (isSimulado) {
      this.HOST = "localhost";
    } else {
      this.HOST = "192.168.36.153";
    } 
  }
  
  public void updateInsEhernet() {
    if (this.cs == null || this.cs.isClosed()) {
      this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
      this.estadoINS = Ins.EstadoINS.DISCONNECTED;
      try {
        this.cs = new Socket(this.HOST, 8110);
      } catch (IOException e) {
        this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
        this.estadoINS = Ins.EstadoINS.DISCONNECTED;
        System.out.println("Ins Desconectado en updateInsEthernet");
        e.printStackTrace();
        System.out.println("PRUEBA");
      } 
    } else {
      try {
        this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
        this.estadoINS = Ins.EstadoINS.DISCONNECTED;
        startClient();
      } catch (IOException e) {
        this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
        this.estadoINS = Ins.EstadoINS.DISCONNECTED;
        e.printStackTrace();
      } 
    } 
  }
  
  private void startClient() throws IOException {
    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.cs.getOutputStream())), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(this.cs.getInputStream()));
      this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
      this.estadoINS = Ins.EstadoINS.DISCONNECTED;
      if (this.cs.isConnected()) {
        this.estadoINS = Ins.EstadoINS.CONNECTED_OK;
        this.valorEntrada = in.readLine();
        String[] azimutParts = this.valorEntrada.split(",");
        if (!this.isSimulado) {
          if (azimutParts[0].equals("$HEHDT") && 
            this.actitud.getAzimut() != Double.parseDouble(azimutParts[1]))
            this.actitud.setAzimut(DataTools.convierteGrados_a_Milesimas(Double.parseDouble(azimutParts[1]))); 
        } else if (this.actitud.getAzimut() != Double.parseDouble(azimutParts[1])) {
          this.actitud.setAzimut(Double.parseDouble(azimutParts[1]));
        } 
        this.valorEntrada = in.readLine();
        String[] actitudParts = this.valorEntrada.split(",");
        if (!this.isSimulado) {
          if (actitudParts[1].equals("ATITUD")) {
            String[] partsActitudParts = actitudParts[3].split("\\*");
            if (this.actitud.getElevacion() != Double.parseDouble(partsActitudParts[0]))
              this.actitud.setElevacion(-DataTools.convierteGrados_a_Milesimas(Double.parseDouble(partsActitudParts[0]))); 
            if (this.actitud.getAlabeo() != Double.parseDouble(actitudParts[2]))
              this.actitud.setAlabeo(DataTools.convierteGrados_a_Milesimas(Double.parseDouble(actitudParts[2]))); 
          } 
        } else {
          String[] partsActitudParts = actitudParts[3].split("\\*");
          if (this.actitud.getElevacion() != Double.parseDouble(partsActitudParts[0]))
            this.actitud.setElevacion(Double.parseDouble(partsActitudParts[0])); 
          if (this.actitud.getAlabeo() != Double.parseDouble(actitudParts[2]))
            this.actitud.setAlabeo(Double.parseDouble(actitudParts[2])); 
        } 
        this.valorEntrada = in.readLine();
        String[] posicionParts = this.valorEntrada.split(",");
        if (!this.isSimulado) {
          if (posicionParts[1].equals("POSITI")) {
            if (this.obusGeo.getLatitud() != Double.parseDouble(posicionParts[2]))
              this.obusGeo.setLatitud(Double.parseDouble(posicionParts[2]), true); 
            if (this.obusGeo.getLongitud() != Double.parseDouble(posicionParts[3])) {
              this.obusGeo.setLongitud(Double.parseDouble(posicionParts[3]), true);
              if (!this.isSimulado)
                if (this.obusGeo.getLongitud() > 180.0D) {
                  this.obusGeo.setLongitud(this.obusGeo.getLongitud() - 360.0D, true);
                } else {
                  this.obusGeo.setLongitud(360.0D - this.obusGeo.getLongitud(), true);
                }  
            } 
            if (this.obusGeo.getAltura() != Double.parseDouble(posicionParts[4].substring(0, 4)))
              this.obusGeo.setAltura(Double.parseDouble(posicionParts[4].substring(0, 4))); 
          } 
        } else {
          if (this.obusGeo.getLatitud() != Double.parseDouble(posicionParts[2]))
            this.obusGeo.setLatitud(Double.parseDouble(posicionParts[2]), true); 
          if (this.obusGeo.getLongitud() != Double.parseDouble(posicionParts[3]))
            this.obusGeo.setLongitud(Double.parseDouble(posicionParts[3]), true); 
          if (this.obusGeo.getAltura() != Double.parseDouble(posicionParts[4].substring(0, 4)))
            this.obusGeo.setAltura(Double.parseDouble(posicionParts[4].substring(0, 4))); 
        } 
        if (!this.isSimulado && this.cs.isConnected()) {
          in.readLine();
          in.readLine();
          in.readLine();
          this.valorEntrada = in.readLine();
          String[] timeParts = this.valorEntrada.split(",");
          if (timeParts[1].equals("TIME__")) {
            this.timeOn.setHour(Integer.parseInt(timeParts[2].substring(0, 2)));
            this.timeOn.setMinutes(Integer.parseInt(timeParts[2].substring(2, 4)));
            this.timeOn.setSeconds(Integer.parseInt(timeParts[2].substring(4, 6)));
            if (this.timeOn.getMinutes() < 4)
              this.estadoINS = Ins.EstadoINS.CONNECTED_DISALIGMENT; 
          } 
          in.readLine();
          in.readLine();
          in.readLine();
          this.valorEntrada = in.readLine();
          String[] gpsParts = this.valorEntrada.split(",");
          if (gpsParts[1].equals("GPSIN_")) {
            System.out.println("valorEntrada = " + this.valorEntrada);
            this.gpsGeo.setLatitud(Double.parseDouble(gpsParts[2]), true);
            if (Double.parseDouble(gpsParts[3]) > 180.0D) {
              this.gpsGeo.setLongitud(Double.parseDouble(gpsParts[3]) - 360.0D, true);
            } else {
              this.gpsGeo.setLongitud(Double.parseDouble(gpsParts[3]), true);
            } 
            this.gpsGeo.setAltura(Double.parseDouble(gpsParts[4]));
            this.gpsUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.gpsGeo, "WGS84");
            in.readLine();
            this.valorEntrada = in.readLine();
            String[] statusParts = this.valorEntrada.split(",");
            if (statusParts[1].equals("STATUS"))
              if (statusParts[2].equals("00000200")) {
                this.estadoGPS = Ins.EstadoGPS.CONNECTED_OK;
              } else if (statusParts[2].equals("00000000")) {
                this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
              }  
          } else {
            this.valorEntrada = in.readLine();
            String[] statusParts = this.valorEntrada.split(",");
            if (statusParts[1].equals("STATUS"))
              if (statusParts[2].equals("00000200")) {
                this.estadoGPS = Ins.EstadoGPS.CONNECTED_MEDIUM;
              } else if (statusParts[2].equals("00000000")) {
                this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
              }  
          } 
          in.readLine();
          in.readLine();
        } else {
          this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
          this.estadoINS = Ins.EstadoINS.DISCONNECTED;
        } 
        setFrocedCoordinates(out);
        configZupt(out);
        actualizaUtil();
      } else {
        System.out.println("Ins no Conectado");
        this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
        this.estadoINS = Ins.EstadoINS.DISCONNECTED;
      } 
    } catch (Exception e) {
      this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
      this.estadoINS = Ins.EstadoINS.DISCONNECTED;
      System.out.println("INS desconectado: " + e.getMessage());
      this.cs.close();
      e.printStackTrace();
    } 
  }
  
  private void actualizaUtil() {
    ConversorCoordenadas convierteCoordenadasObus = new ConversorCoordenadas();
    this.obusUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.obusGeo, "WGS84");
    Calendar cal = Calendar.getInstance();
    int year = cal.get(1);
    Declination declination = new Declination();
    double declinacionMagnetica = DataTools.convierteGrados_a_Milesimas(declination.getDeclination(this.obusGeo.getLatitud(), this.obusGeo.getLongitud(), year, this.obusGeo.getAltura()));
    setMagneticOrientation(this.actitud.getAzimut() - declinacionMagnetica);
  }
  
  private void configZupt(PrintWriter out) {
    String tramaZupt = null;
    if (this.zuptflagChange != isZuptTiro()) {
      if (isZuptTiro()) {
        tramaZupt = "$PIXSE,CONFIG,ZUP___,6";
      } else if (!isZuptTiro()) {
        tramaZupt = "$PIXSE,CONFIG,ZUP___,3";
      } 
      out.println(tramaZupt + "*" + getSum(tramaZupt) + "<CR><LF>");
    } 
    this.zuptflagChange = isZuptTiro();
  }
  
  private void setFrocedCoordinates(PrintWriter out) {
    if (this.forceCoordChange != isForcedCoordinates())
      if (isForcedCoordinates()) {
        String tramaForced = null;
        tramaForced = "$PIXSE,CONFIG,MANGPS," + String.valueOf(this.obusForzado.getLatitud()) + "," + String.valueOf(this.obusForzado.getLongitud()) + "," + String.valueOf(this.obusForzado.getAltura()) + ",2.0,2.0,2.0*";
        out.println(tramaForced + getSum(tramaForced) + "<CR><LF>");
        out.println("$PIXSE,CONFIG,GPMKFM,0*5B <CR><LF>");
        this.obusGeo.setAltura(this.obusForzado.getAltura());
      } else {
        out.println("$PIXSE,CONFIG,GPMKFM,2*59 <CR><LF>");
        out.println("$PIXSE,CONFIG,GPSKFM,2*47<CR><LF>");
      }  
    this.forceCoordChange = isForcedCoordinates();
  }
  
  private static String getSum(String in) {
    int checksum = 0;
    if (in.startsWith("$"))
      in = in.substring(1, in.length()); 
    int end = in.indexOf('*');
    if (end == -1)
      end = in.length(); 
    for (int i = 0; i < end; i++)
      checksum ^= in.charAt(i); 
    String hex = Integer.toHexString(checksum);
    if (hex.length() == 1)
      hex = "0" + hex; 
    return hex.toUpperCase();
  }
  
  public boolean isZuptTiro() {
    return this.isZuptTiro;
  }
  
  public void setZuptTiro(boolean zuptTiro) {
    this.isZuptTiro = zuptTiro;
  }
  
  public boolean isOdo() {
    return this.isOdo;
  }
  
  public void setOdo(boolean odo) {
    this.isOdo = odo;
  }
  
  public double getMagneticOrientation() {
    return this.magneticOrientation;
  }
  
  public void setMagneticOrientation(double magneticOrientation) {
    this.magneticOrientation = magneticOrientation;
  }
  
  public boolean isForcedCoordinates() {
    return this.isForcedCoordinates;
  }
  
  public void setForcedCoordinates(boolean forcedCoordinates) {
    this.isForcedCoordinates = forcedCoordinates;
  }
  
  public String getHOST() {
    return this.HOST;
  }
  
  public static InsEthernet getSingletonInstance(boolean isSimulado) {
    if (insEthernet == null)
      try {
        insEthernet = new InsEthernet(isSimulado);
      } catch (IOException e) {
        e.printStackTrace();
      }  
    return insEthernet;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Hardware\InsEthernet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */