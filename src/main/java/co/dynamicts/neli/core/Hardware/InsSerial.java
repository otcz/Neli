package co.dynamicts.neli.core.Hardware;

import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.utilities.*;
import co.dynamicts.neli.core.utilities.declination.Declination;
import jssc.SerialPortException;

import java.util.Calendar;

public class InsSerial {
  private static InsSerial insSerial;
  
  public PuertoSerial COM_Navegador;
  
  public Ins.EstadoGPS estadoGPS;
  
  public Ins.EstadoINS estadoINS = Ins.EstadoINS.DISCONNECTED;
  
  public Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private boolean isZuptTiro = false;
  
  private short[] DatosDelNavegador = new short[1000];
  
  private short[] IniTramaAzimut = new short[] { 72, 69, 72, 68, 84, 44 };
  
  private short[] IniTramaPitchYRoll = new short[] { 
      80, 73, 88, 83, 69, 44, 65, 84, 73, 84, 
      85, 68, 44 };
  
  private short[] IniTramaPosicion = new short[] { 
      80, 73, 88, 83, 69, 44, 80, 79, 83, 73, 
      84, 73, 44 };
  
  private short[] IniTramaVelocidad = new short[] { 
      80, 73, 88, 83, 69, 44, 83, 80, 69, 69, 
      68, 95, 44 };
  
  private short[] IniTramaTiempo = new short[] { 
      80, 73, 88, 83, 69, 44, 84, 73, 77, 69, 
      95, 95, 44 };
  
  private short[] IniTramaEstado = new short[] { 
      80, 73, 88, 83, 69, 44, 83, 84, 65, 84, 
      85, 83, 44 };
  
  private short[] IniTramaAlgoritmos = new short[] { 
      80, 73, 88, 83, 69, 44, 65, 76, 71, 83, 
      84, 83, 44 };
  
  private short[] IniTramaUltimoDatoGPS = new short[] { 
      80, 73, 88, 83, 69, 44, 71, 80, 83, 73, 
      78, 95, 44 };
  
  private short[] TramaDespertar = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 87, 65, 75, 69, 85, 80, 
      42, 52, 48, 13, 10 };
  
  private short[] TramaZUP = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 90, 85, 80, 95, 95, 95, 
      44, 0, 42, 0, 0, 13, 10 };
  
  private short[] VerificarZUPT = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 90, 85, 80, 95, 95, 95, 
      44, 44, 42, 53, 68, 13, 10 };
  
  private short[] TramaSave = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 83, 65, 86, 69, 95, 95, 
      42, 53, 67, 13, 10 };
  
  private short[] TramaActGPSManual = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 71, 80, 77, 75, 70, 77, 
      44, 0, 42, 0, 0, 13, 10 };
  
  private short[] TramaGPSLecturaAut = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 71, 80, 83, 75, 70, 77, 
      44, 50, 42, 52, 55, 13, 10 };
  
  private short[] ManualGPS = new short[] { 
      36, 80, 73, 88, 83, 69, 44, 67, 79, 78, 
      70, 73, 71, 44, 77, 65, 78, 71, 80, 83, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      42, 0, 0, 13, 10 };
  
  private short[] TramaPrueba1 = new short[] { 
      36, 71, 80, 71, 71, 65, 44, 44, 44, 44, 
      44, 44, 48, 44, 44, 44, 44, 77, 44, 44, 
      77, 44, 44, 42, 54, 54, 13, 10 };
  
  private short[] TramaPrueba2 = new short[] { 
      36, 71, 80, 86, 84, 71, 44, 44, 84, 44, 
      44, 77, 44, 44, 78, 44, 44, 75, 44, 78, 
      42, 50, 67, 13, 10 };
  
  private short[] TramaPrueba3 = new short[] { 
      36, 71, 80, 90, 68, 65, 44, 44, 44, 44, 
      44, 44, 42, 52, 56, 13, 10 };
  
  private short[] TramaPrueba4 = new short[] { 
      36, 71, 80, 71, 83, 84, 44, 44, 44, 44, 
      44, 44, 44, 44, 42, 53, 55, 13, 10 };
  
  private short[] TramaPrueba5 = new short[] { 36, 83, 79, 70, 70, 13, 10 };
  
  public Actitud actitud = new Actitud();
  
  public PuntoGeograficas obusGeo = new PuntoGeograficas();
  
  public PuntoUTM obusUTM = new PuntoUTM();
  
  public PuntoGeograficas gpsGeo = new PuntoGeograficas();
  
  public PuntoUTM gpsUTM = new PuntoUTM();
  
  double magneticOrientation = 0.0D;
  
  public boolean rotationChange = false;
  
  public float velocidad_Oriente;
  
  public float velocidad_Norte;
  
  public float velocidad_Arriba;
  
  public float GPSIN_latitud;
  
  public float GPSIN_longitud;
  
  public float GPSIN_altura;
  
  public int GPSIN_hora;
  
  public int GPSIN_tiempo;
  
  public int GPSIN_minuto;
  
  public float GPSIN_segundo;
  
  public int GPSIN_calidad;
  
  public float tiempo;
  
  public int hora;
  
  public int minuto;
  
  public float segundo;
  
  public int tiempoSegundos;
  
  public int tiempoIniRapid = 0;
  
  public int tiempoIniAlinea = 0;
  
  public int tiempoIniAlinFino = 0;
  
  public int[] tiempoRegresivoRapid = new int[] { 0, 0 };
  
  public int[] tiempoRegresivoAlinea = new int[] { 0, 0 };
  
  public int[] tiempoRegresivoAlinFino = new int[] { 0, 0 };
  
  public boolean comunicacion = false;
  
  public boolean ComunicacionPuertoA = false;
  
  public boolean SalidaPuertoBFull = false;
  
  public boolean PulsosADetectados = false;
  
  public boolean PulsosBDetectados = false;
  
  public boolean GPS_Detectado = false;
  
  public boolean PPS_Detectado = false;
  
  public boolean EnFaseDeAlineamiento = false;
  
  public boolean AlineamientoFino = false;
  
  public boolean AlineamientoRapido = false;
  
  public boolean ZUPMode = false;
  
  public boolean ZUPTModeActivated = false;
  
  public boolean ZUPTModeValid = false;
  
  public boolean AutostaticBench = false;
  
  public boolean ManualGPSRecived = false;
  
  public boolean ManualGPSValid = false;
  
  public boolean EnFaseDeAlineamientoAnt = false;
  
  public boolean AlineamientoFinoAnt = false;
  
  public short ZUP_Modo_Navegador = 5;
  
  public short ZUP_Modo_Punto_fijo = 6;
  
  public short GPSAutomatico = 2;
  
  public short GPSManual = 0;
  
  private boolean[] BanderasEstado = new boolean[64];
  
  private boolean[] BanderasAlgoritmo = new boolean[64];
  
  public InsSerial() {
    tomarPuerto();
  }
  
  public void updateInsSerial() {
    this.rotationChange = true;
    for (int h = 0; h < 1000; h++)
      this.DatosDelNavegador[h] = 0; 
    int EsAzimuth = 0;
    int EsPitch = 0;
    int EsRoll = 0;
    int EsLatitud = 0;
    int EsLongitud = 0;
    int EsAltura = 0;
    int EsVelocidadOriente = 0;
    int EsVelocidadNorte = 0;
    int EsVelocidadArriba = 0;
    int EsTiempo = 0;
    int EsEstado = 0;
    int EsAlgoritmo = 0;
    int EsGPSIN_latitud = 0;
    int EsGPSIN_longitud = 0;
    int EsGPSIN_altura = 0;
    int EsGPSIN_hora = 0;
    int EsGPSIN_calidad = 0;
    int[] LargoNumero = { 0 };
    try {
      this.COM_Navegador.recibir(this.DatosDelNavegador);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    EsAzimuth = EncontrarTrama(this.DatosDelNavegador, this.IniTramaAzimut);
    EsRoll = EncontrarTrama(this.DatosDelNavegador, this.IniTramaPitchYRoll);
    EsLatitud = EncontrarTrama(this.DatosDelNavegador, this.IniTramaPosicion);
    EsTiempo = EncontrarTrama(this.DatosDelNavegador, this.IniTramaTiempo);
    EsVelocidadOriente = EncontrarTrama(this.DatosDelNavegador, this.IniTramaVelocidad);
    EsEstado = EncontrarTrama(this.DatosDelNavegador, this.IniTramaEstado);
    EsAlgoritmo = EncontrarTrama(this.DatosDelNavegador, this.IniTramaAlgoritmos);
    EsGPSIN_latitud = EncontrarTrama(this.DatosDelNavegador, this.IniTramaUltimoDatoGPS);
    if (EsAzimuth + EsRoll + EsLatitud + EsTiempo + EsVelocidadOriente + EsEstado + EsAlgoritmo + EsGPSIN_latitud == 0) {
      this.comunicacion = false;
    } else {
      this.comunicacion = true;
    } 
    if (EsAzimuth > 0) {
      this.actitud.setAzimut((De_Arreglo_A_Numero(this.DatosDelNavegador, EsAzimuth, LargoNumero) * 3200.0F / 180.0F));
      this.rotationChange = true;
      this.estadoINS = Ins.EstadoINS.CONNECTED_OK;
    } 
    if (EsRoll > 0) {
      this.actitud.setAlabeo((De_Arreglo_A_Numero(this.DatosDelNavegador, EsRoll, LargoNumero) * 3200.0F / 180.0F));
      EsPitch = EsRoll + LargoNumero[0] + 1;
      this.actitud.setElevacion((-De_Arreglo_A_Numero(this.DatosDelNavegador, EsPitch, LargoNumero) * 3200.0F / 180.0F));
      this.rotationChange = true;
      this.estadoINS = Ins.EstadoINS.CONNECTED_OK;
    } 
    if (EsLatitud > 0) {
      this.obusGeo.setLatitud(De_Arreglo_A_Numero(this.DatosDelNavegador, EsLatitud, LargoNumero), true);
      EsLongitud = EsLatitud + LargoNumero[0] + 1;
      this.rotationChange = true;
      double longitud = De_Arreglo_A_Numero(this.DatosDelNavegador, EsLongitud, LargoNumero);
      if (longitud > 180.0D)
        longitud = -180.0D + longitud - 180.0D; 
      this.obusGeo.setLongitud(longitud, true);
      this.rotationChange = true;
      EsAltura = EsLongitud + LargoNumero[0] + 1;
      this.obusGeo.setAltura((int)De_Arreglo_A_Numero(this.DatosDelNavegador, EsAltura, LargoNumero));
      this.rotationChange = true;
    } 
    if (EsTiempo > 0) {
      this.tiempo = De_Arreglo_A_Numero(this.DatosDelNavegador, EsTiempo, LargoNumero);
      this.hora = (int)(this.tiempo / 10000.0F);
      this.tiempo -= (this.hora * 10000);
      this.minuto = (int)(this.tiempo / 100.0F);
      this.tiempo -= (this.minuto * 100);
      this.segundo = this.tiempo;
      this.tiempo = 0.0F;
      this.tiempoSegundos = (int)((this.hora * 3600 + this.minuto * 60) + this.segundo);
      if (this.EnFaseDeAlineamiento && !this.EnFaseDeAlineamientoAnt) {
        this.EnFaseDeAlineamientoAnt = true;
        this.tiempoIniAlinea = this.tiempoSegundos;
      } 
      if (this.AlineamientoFino && !this.AlineamientoFinoAnt) {
        this.AlineamientoFinoAnt = true;
        this.tiempoIniAlinFino = this.tiempoSegundos;
      } 
      if (this.EnFaseDeAlineamiento) {
        Tiempo_Regresivo(this.tiempoIniAlinea, this.tiempoSegundos, 35, this.AlineamientoRapido, this.tiempoRegresivoRapid);
        Tiempo_Regresivo(this.tiempoIniAlinea, this.tiempoSegundos, 245, this.EnFaseDeAlineamiento, this.tiempoRegresivoAlinea);
        Tiempo_Regresivo(this.tiempoIniAlinea, this.tiempoSegundos, 605, this.AlineamientoFino, this.tiempoRegresivoAlinFino);
      } else if (this.AlineamientoFino) {
        this.tiempoRegresivoRapid[0] = 0;
        this.tiempoRegresivoRapid[1] = 0;
        this.tiempoRegresivoAlinea[0] = 0;
        this.tiempoRegresivoAlinea[1] = 0;
        Tiempo_Regresivo(this.tiempoIniAlinFino, this.tiempoSegundos, 365, this.AlineamientoFino, this.tiempoRegresivoAlinFino);
      } else {
        this.tiempoRegresivoAlinFino[0] = 0;
        this.tiempoRegresivoAlinFino[1] = 0;
      } 
    } 
    if (EsVelocidadOriente > 0) {
      this.velocidad_Oriente = De_Arreglo_A_Numero(this.DatosDelNavegador, EsVelocidadOriente, LargoNumero);
      EsVelocidadNorte = EsVelocidadOriente + LargoNumero[0] + 1;
      this.velocidad_Norte = De_Arreglo_A_Numero(this.DatosDelNavegador, EsVelocidadNorte, LargoNumero);
      EsVelocidadArriba = EsVelocidadNorte + LargoNumero[0] + 1;
      this.velocidad_Arriba = De_Arreglo_A_Numero(this.DatosDelNavegador, EsVelocidadArriba, LargoNumero);
    } 
    if (EsEstado > 0) {
      Tomar_Banderas(this.DatosDelNavegador, EsEstado, this.BanderasEstado);
      this.ComunicacionPuertoA = this.BanderasEstado[9];
      this.SalidaPuertoBFull = this.BanderasEstado[18];
      this.PulsosADetectados = this.BanderasEstado[27];
      this.PulsosBDetectados = this.BanderasEstado[28];
      this.GPS_Detectado = this.BanderasEstado[34];
      if (this.GPS_Detectado) {
        this.estadoGPS = Ins.EstadoGPS.CONNECTED_OK;
      } else {
        this.estadoGPS = Ins.EstadoGPS.DISCONNECTED;
      } 
      this.PPS_Detectado = this.BanderasEstado[43];
      this.ZUPMode = this.BanderasEstado[44];
    } 
    if (EsAlgoritmo > 0) {
      Tomar_Banderas(this.DatosDelNavegador, EsAlgoritmo, this.BanderasAlgoritmo);
      this.EnFaseDeAlineamiento = this.BanderasAlgoritmo[1];
      this.AlineamientoFino = this.BanderasAlgoritmo[2];
      this.AlineamientoRapido = this.BanderasAlgoritmo[54];
      this.ZUPTModeActivated = this.BanderasAlgoritmo[48];
      this.ZUPTModeValid = this.BanderasAlgoritmo[49];
      this.AutostaticBench = this.BanderasAlgoritmo[50];
      this.ManualGPSRecived = this.BanderasAlgoritmo[60];
      this.ManualGPSValid = this.BanderasAlgoritmo[61];
      if (!this.EnFaseDeAlineamiento)
        this.EnFaseDeAlineamientoAnt = false; 
      if (!this.AlineamientoFinoAnt)
        this.AlineamientoFinoAnt = false; 
    } 
    this.gpsGeo.setAltura(EsGPSIN_latitud);
    if (EsGPSIN_latitud > 0) {
      this.gpsGeo.setLatitud(De_Arreglo_A_Numero(this.DatosDelNavegador, EsGPSIN_latitud, LargoNumero), true);
      EsGPSIN_longitud = EsGPSIN_latitud + LargoNumero[0] + 1;
      this.gpsGeo.setLongitud(De_Arreglo_A_Numero(this.DatosDelNavegador, EsGPSIN_longitud, LargoNumero), true);
      if (this.GPSIN_longitud > 180.0F)
        this.GPSIN_longitud = -180.0F + this.GPSIN_longitud - 180.0F; 
      EsGPSIN_altura = EsGPSIN_longitud + LargoNumero[0] + 1;
      this.GPSIN_altura = De_Arreglo_A_Numero(this.DatosDelNavegador, EsGPSIN_altura, LargoNumero);
      EsGPSIN_hora = EsGPSIN_altura + LargoNumero[0] + 1;
      this.tiempo = (int)De_Arreglo_A_Numero(this.DatosDelNavegador, EsGPSIN_hora, LargoNumero);
      this.GPSIN_hora = (int)(this.tiempo / 10000.0F);
      this.tiempo -= (this.hora * 10000);
      this.GPSIN_minuto = (int)(this.tiempo / 100.0F);
      this.tiempo -= (this.minuto * 100);
      this.GPSIN_segundo = this.tiempo;
      this.tiempo = 0.0F;
      EsGPSIN_calidad = EsGPSIN_hora + LargoNumero[0] + 1;
      this.GPSIN_calidad = (int)De_Arreglo_A_Numero(this.DatosDelNavegador, EsGPSIN_calidad, LargoNumero);
    } 
    actualizaUtil();
  }
  
  void tomarPuerto() {
    this.COM_Navegador = new PuertoSerial("n", this.configuracion.PuertoSerialINS, 57600, 8, 2, 1);
  }
  
  public void ConfigurarModoZUP(short Modo) throws SerialPortException, InterruptedException {
    short cheksum = 0;
    short interm = 0;
    this.TramaZUP[21] = (short)(Modo + 48);
    cheksum = CheckSumXor(this.TramaZUP);
    if (cheksum >> 4 > 9) {
      this.TramaZUP[23] = (short)((cheksum >> 4) + 55);
    } else {
      this.TramaZUP[23] = (short)((cheksum >> 4) + 48);
    } 
    interm = (short)(cheksum << 4);
    interm = (short)((short)(interm >> 4) & 0xF);
    if (interm > 9) {
      this.TramaZUP[24] = (short)(interm + 55);
    } else {
      this.TramaZUP[24] = (short)(interm + 48);
    } 
    this.COM_Navegador.enviar(this.TramaDespertar, (short)25, false);
    Thread.sleep(100L);
    this.COM_Navegador.enviar(this.TramaZUP, (short)27, false);
    Thread.sleep(100L);
    this.COM_Navegador.enviar(this.VerificarZUPT, (short)27, false);
    Thread.sleep(100L);
    this.COM_Navegador.enviar(this.TramaSave, (short)25, false);
  }
  
  public void GPSmodo(int modoGPS) throws SerialPortException, InterruptedException {
    short cheksum = 0;
    short interm = 0;
    this.TramaActGPSManual[21] = (short)(modoGPS + 48);
    cheksum = CheckSumXor(this.TramaActGPSManual);
    if (cheksum >> 4 > 9) {
      this.TramaActGPSManual[23] = (short)((cheksum >> 4) + 55);
    } else {
      this.TramaActGPSManual[23] = (short)((cheksum >> 4) + 48);
    } 
    interm = (short)(cheksum << 4);
    interm = (short)((short)(interm >> 4) & 0xF);
    if (interm > 9) {
      this.TramaActGPSManual[24] = (short)(interm + 55);
    } else {
      this.TramaActGPSManual[24] = (short)(interm + 48);
    } 
    try {
      this.COM_Navegador.enviar(this.TramaActGPSManual, (short)27, false);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void GPSLecturaAut() throws SerialPortException, InterruptedException {
    try {
      this.COM_Navegador.enviar(this.TramaGPSLecturaAut, (short)27, false);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void FijarPosicionGPSManual(boolean isForced, double Man_latitud, double Man_longitud, double Man_altura, float Man_Std_desv_latitud, float Man_Std_desv_longitud, float Man_Std_desv_altura) {
    try {
      if (isForced) {
        int posicion = 21;
        short[] Numero = new short[9];
        float[] Datos = new float[6];
        Datos[0] = (float)Man_latitud;
        Datos[1] = (float)Man_longitud;
        Datos[2] = (float)Man_altura;
        Datos[3] = Man_Std_desv_latitud;
        Datos[4] = Man_Std_desv_longitud;
        Datos[5] = Man_Std_desv_altura;
        for (int j = 0; j < 6; j++) {
          De_Numero_A_Arreglo(Datos[j], Numero);
          for (int i = 0; i < 9; i++)
            this.ManualGPS[posicion + i] = Numero[i]; 
          posicion += 10;
        } 
        short cheksum = CheckSumXor(this.ManualGPS);
        if (cheksum >> 4 > 9) {
          this.ManualGPS[81] = (short)((cheksum >> 4) + 55);
        } else {
          this.ManualGPS[81] = (short)((cheksum >> 4) + 48);
        } 
        short interm = (short)(cheksum << 4);
        interm = (short)((short)(interm >> 4) & 0xF);
        if (interm > 9) {
          this.ManualGPS[82] = (short)(interm + 55);
        } else {
          this.ManualGPS[82] = (short)(interm + 48);
        } 
        this.COM_Navegador.enviar(this.ManualGPS, (short)85, false);
        Thread.sleep(100L);
      } 
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (SerialPortException e) {
      e.printStackTrace();
    } 
  }
  
  int EncontrarTrama(short[] TramaCompleta, short[] TramaABuscar) {
    boolean Encontrada = false;
    int posicion = 0;
    int posictem = 0;
    int LargoTramaCompleta = TramaCompleta.length;
    int LargoTramaABuscar = TramaABuscar.length;
    int conteocopia = 0;
    short checksumcalculado = 0;
    short checksumentrante = 0;
    short digitouno = 0;
    short digitodos = 0;
    short[] copiapedasodetrama = new short[75];
    for (int i = 0; i < LargoTramaCompleta && 
      TramaCompleta[i] != 0; i++) {
      if (TramaCompleta[i] == 36 && i + LargoTramaABuscar + 1 < LargoTramaCompleta) {
        conteocopia = 0;
        copiapedasodetrama[conteocopia] = TramaCompleta[i];
        conteocopia++;
        i++;
        for (int j = 0; j < LargoTramaABuscar; j++) {
          if (TramaCompleta[i] == TramaABuscar[j]) {
            copiapedasodetrama[conteocopia] = TramaCompleta[i];
            Encontrada = true;
          } else {
            Encontrada = false;
            break;
          } 
          conteocopia++;
          i++;
        } 
      } 
      if (Encontrada) {
        posictem = i;
        while (TramaCompleta[i] != 42 && TramaCompleta[i] != 0) {
          copiapedasodetrama[conteocopia] = TramaCompleta[i];
          conteocopia++;
          i++;
        } 
        copiapedasodetrama[conteocopia] = TramaCompleta[i];
        checksumcalculado = CheckSumXor(copiapedasodetrama);
        if (TramaCompleta[i + 1] >= 48 && TramaCompleta[i + 1] <= 57) {
          digitouno = (short)(TramaCompleta[i + 1] - 48);
        } else if (TramaCompleta[i + 1] >= 65 && TramaCompleta[i + 1] <= 70) {
          digitouno = (short)(TramaCompleta[i + 1] - 55);
        } 
        if (TramaCompleta[i + 2] >= 48 && TramaCompleta[i + 2] <= 57) {
          digitodos = (short)(TramaCompleta[i + 2] - 48);
        } else if (TramaCompleta[i + 2] >= 65 && TramaCompleta[i + 2] <= 70) {
          digitodos = (short)(TramaCompleta[i + 2] - 55);
        } 
        checksumentrante = (short)(digitouno * 16 + digitodos);
        if (checksumcalculado == checksumentrante)
          posicion = posictem; 
        break;
      } 
    } 
    return posicion;
  }
  
  short CheckSumXor(short[] Trama) {
    int LargoTrama = Trama.length;
    int Posic = 0;
    short checksum = 0;
    while (Trama[Posic] != 42 && Posic + 1 < LargoTrama) {
      if (Trama[Posic] != 36)
        checksum = (short)(checksum ^ Trama[Posic]); 
      Posic++;
    } 
    checksum = (short)(checksum & 0xFF);
    return checksum;
  }
  
  float De_Arreglo_A_Numero(short[] TramaCompleta, int Posicion, int[] Larg) {
    float numero = 0.0F;
    float multiplicador = 0.1F;
    int signo = 1;
    Larg[0] = 0;
    int LargoTramaCompleta = TramaCompleta.length;
    if (Posicion < LargoTramaCompleta)
      while (TramaCompleta[Posicion] != 46) {
        if (TramaCompleta[Posicion] == 45) {
          signo = -1;
        } else {
          numero *= 10.0F;
          numero += (TramaCompleta[Posicion] - 48);
        } 
        Posicion++;
        Larg[0] = Larg[0] + 1;
        if (Posicion >= LargoTramaCompleta)
          break; 
      }  
    Posicion++;
    Larg[0] = Larg[0] + 1;
    if (Posicion < LargoTramaCompleta) {
      while (TramaCompleta[Posicion] != 44) {
        numero += (TramaCompleta[Posicion] - 48) * multiplicador;
        multiplicador = (float)(multiplicador * 0.1D);
        Posicion++;
        Larg[0] = Larg[0] + 1;
        if (Posicion == LargoTramaCompleta)
          break; 
      } 
      numero *= signo;
    } 
    return numero;
  }
  
  void De_Numero_A_Arreglo(float dato, short[] Arreglo) {
    int posicion = 0;
    int entero = 0;
    int decimal = 0;
    int divisor = 0;
    boolean valido = false;
    entero = (int)dato;
    decimal = (int)((dato - entero) * 1.0E7F);
    if (entero < 0) {
      Arreglo[posicion] = 45;
      entero *= -1;
      decimal *= -1;
      posicion++;
    } 
    divisor = 1000;
    int i;
    for (i = 0; i < 4; i++) {
      int auxil = entero / divisor;
      if (auxil > 0 || valido) {
        Arreglo[posicion] = (short)(auxil + 48);
        entero -= auxil * divisor;
        posicion++;
        valido = true;
      } 
      divisor /= 10;
    } 
    Arreglo[posicion] = 46;
    posicion++;
    divisor = 1000000;
    for (i = 0; i < 7; ) {
      int auxil = decimal / divisor;
      if (posicion < 9) {
        Arreglo[posicion] = (short)(auxil + 48);
        decimal -= auxil * divisor;
        posicion++;
        divisor /= 10;
        i++;
      } 
    } 
  }
  
  void Tomar_Banderas(short[] TramaCompleta, int Posicion, boolean[] Banderas) {
    boolean[] BanderasCorta = new boolean[4];
    int LargoTramaCompleta = TramaCompleta.length;
    if (Posicion + 17 < LargoTramaCompleta)
      for (int k = 0; k < 2; k++) {
        for (int i = 7; i >= 0; i--) {
          De_Hexadecimal_A_ArregloBinario(TramaCompleta[Posicion], BanderasCorta);
          for (int j = 0; j < 4; j++)
            Banderas[k * 32 + i * 4 + j] = BanderasCorta[j]; 
          Posicion++;
        } 
        Posicion++;
      }  
  }
  
  void De_Hexadecimal_A_ArregloBinario(short Hexadecimal, boolean[] Binario) {
    short acumulador = 0;
    short exponec = 8;
    if (Hexadecimal >= 48 && Hexadecimal <= 57) {
      acumulador = (short)(Hexadecimal - 48);
    } else if (Hexadecimal >= 65 && Hexadecimal <= 70) {
      acumulador = (short)(Hexadecimal - 55);
    } 
    short i;
    for (i = 0; i < 4; i = (short)(i + 1)) {
      if (acumulador >= exponec) {
        Binario[3 - i] = true;
        acumulador = (short)(acumulador - exponec);
      } else {
        Binario[3 - i] = false;
      } 
      exponec = (short)(exponec / 2);
    } 
  }
  
  void Tiempo_Regresivo(int TiempIni, int TiempAct, int Diferen, boolean Bandera, int[] Regresivo) {
    int RegresivoSegundos, TiempoFinal = 0;
    TiempoFinal = TiempIni + Diferen;
    if (TiempoFinal > 86399)
      TiempoFinal -= 86399; 
    if (TiempoFinal < Diferen && TiempAct >= Diferen) {
      RegresivoSegundos = 86399 - TiempAct + TiempoFinal;
    } else {
      RegresivoSegundos = TiempoFinal - TiempAct;
    } 
    if (RegresivoSegundos <= 0)
      if (Bandera) {
        RegresivoSegundos = 1;
      } else {
        RegresivoSegundos = 0;
      }  
    Regresivo[0] = RegresivoSegundos / 60;
    Regresivo[1] = RegresivoSegundos - Regresivo[0] * 60;
  }
  
  private void actualizaUtil() {
    ConversorCoordenadas convierteCoordenadasObus = new ConversorCoordenadas();
    this.obusUTM = ConversorCoordenadas.convertirGeo_a_UTM(this.obusGeo, "WGS84");
    Calendar cal = Calendar.getInstance();
    int year = cal.get(1);
    Declination declination = new Declination();
    double declinacionMagnetica = DataTools.convierteGrados_a_Milesimas(declination.getDeclination(this.obusGeo.getLatitud(), this.obusGeo.getLongitud(), year, this.obusGeo.getAltura()));
    setMagneticOrientation(this.actitud.getAzimut() - declinacionMagnetica);
    actualizaGPS();
  }
  
  private void actualizaGPS() {
    this.gpsGeo.setLatitud(this.GPSIN_latitud, true);
    this.gpsGeo.setLongitud(this.GPSIN_longitud, true);
    this.gpsGeo.setAltura(this.GPSIN_altura);
  }
  
  public double getMagneticOrientation() {
    return this.magneticOrientation;
  }
  
  public void setMagneticOrientation(double magneticOrientation) {
    this.magneticOrientation = magneticOrientation;
  }
  
  public boolean isZuptTiro() {
    return this.isZuptTiro;
  }
  
  public void setZuptTiro(boolean zuptTiro) {
    this.isZuptTiro = zuptTiro;
  }
  
  public static InsSerial getSingletonInstance() {
    if (insSerial == null)
      insSerial = new InsSerial(); 
    return insSerial;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Hardware\InsSerial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */