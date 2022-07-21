package co.dynamicts.neli.core.Hardware;

import co.dynamicts.neli.core.interfaces.Configuracion;
import jssc.SerialPortException;

import java.util.Calendar;

public class FuncionesRadar extends Thread {
  public static FuncionesRadar funcionesRadar;
  
  public static PuertoSerial COM_Radar;
  
  public static String IDPuertoRadar = (Configuracion.getSingletonInstance()).PuertoSerialRadar;
  
  private short[] RespuestaMVR = new short[100];
  
  private short[] MensajeRemoto = new short[] { 114, 101, 109, 111, 116, 101, 13 };
  
  private short[] MensajeLimpiarBuffer = new short[] { 83, 79, 70, 84, 82, 69, 83, 69, 84, 13 };
  
  private short[] MensajeFecha = new short[] { 
      68, 65, 84, 69, 32, 0, 0, 0, 0, 0, 
      0, 13 };
  
  private short[] MensajeHora = new short[] { 
      84, 73, 77, 69, 32, 0, 0, 58, 0, 0, 
      58, 0, 0, 13 };
  
  private short[] MensajeForzarAutocalulo = new short[] { 
      65, 85, 84, 79, 67, 65, 76, 67, 32, 49, 
      13 };
  
  private short[] MensajeModoDeMedidas = new short[] { 
      77, 69, 65, 83, 77, 79, 68, 69, 32, 49, 
      13 };
  
  private short[] MensajeDesalineacionAntena = new short[] { 
      65, 78, 84, 79, 70, 70, 83, 69, 84, 32, 
      48, 46, 54, 48, 13 };
  
  private short[] MensajeRetrocesoAntena = new short[] { 
      65, 78, 84, 83, 69, 84, 66, 65, 67, 75, 
      32, 54, 46, 53, 48, 13 };
  
  private short[] MensajeInicioMedida = new short[] { 77, 69, 65, 83, 85, 82, 69, 13 };
  
  private short[] MensajeEstado = new short[] { 83, 89, 83, 83, 84, 65, 84, 13 };
  
  private short[] MensajeNumeroDeMedidas = new short[] { 77, 69, 65, 83, 78, 85, 77, 13 };
  
  private short[] MensajeVelocidad = new short[] { 77, 85, 90, 90, 86, 69, 76, 13 };
  
  private short[] MensajeVelocidadMedia = new short[] { 
      77, 69, 65, 78, 77, 85, 90, 90, 86, 69, 
      76, 13 };
  
  private short[] MensajeVelocidadNormalizada = new short[] { 
      78, 79, 82, 77, 77, 85, 90, 90, 86, 69, 
      76, 13 };
  
  private short[] MensajeVelocidadMediaNormalizada = new short[] { 
      77, 69, 65, 78, 78, 79, 82, 77, 77, 85, 
      90, 90, 86, 69, 76, 13 };
  
  private short[] MensajePararMedidas = new short[] { 83, 84, 79, 80, 77, 69, 65, 83, 13 };
  
  private short[] TramaRespuestaNoError = new short[] { 78, 111, 32, 69, 114, 114, 111, 114, 115 };
  
  private short[] TramaRespuestaErrrorFueraDeRango = new short[] { 
      105, 115, 32, 111, 117, 116, 32, 111, 102, 32, 
      114, 97, 110, 103, 101 };
  
  private short[] TramaRespuestaErrrorValorInvalido = new short[] { 
      73, 110, 118, 97, 108, 105, 100, 32, 118, 97, 
      108, 117, 101 };
  
  private short[] TramaRespuestaNoErrror_O = new short[] { 79 };
  
  private short[] TramaRespuestaErrrorE = new short[] { 69, 13, 10 };
  
  private short[] TramaRespuestaErrrorU = new short[] { 85, 13, 10 };
  
  private short[] TramaRespuestaErrrorR = new short[] { 82, 13, 10 };
  
  private short[] TramaRespuestaErrrorS = new short[] { 83, 13, 10 };
  
  private short[] TramaRespuestaErrrorI = new short[] { 73, 13, 10 };
  
  private short[] TramaRespuestaErrrorN = new short[] { 78, 13, 10 };
  
  private short[] TramaRespuestaErrrorV = new short[] { 86, 13, 10 };
  
  private short[] TramaRespuestaErrrorW = new short[] { 87, 13, 10 };
  
  private short[] TramaRespuestaSysStat0 = new short[] { 48, 13, 10 };
  
  private short[] TramaRespuestaSysStat1 = new short[] { 49, 13, 10 };
  
  private short[] TramaRespuestaSysStat2 = new short[] { 50, 13, 10 };
  
  private short[] TramaRespuestaSysStat3 = new short[] { 51, 13, 10 };
  
  private short[] TramaRespuestaComandoRemoto = new short[] { 
      65, 108, 114, 101, 97, 100, 121, 32, 105, 110, 
      32, 82, 69, 77, 79, 84, 69, 32, 109, 111, 
      100, 101 };
  
  private short[] TramaRespuestaReset = new short[] { 
      84, 104, 101, 32, 98, 117, 102, 102, 101, 114, 
      32, 105, 115, 32, 99, 108, 101, 97, 114, 101, 
      100 };
  
  private short[] TramaRespuestaInicioMedia = new short[] { 
      84, 104, 101, 32, 109, 101, 97, 115, 117, 114, 
      101, 109, 101, 110, 116, 32, 105, 115, 32, 115, 
      116, 97, 114, 116, 101, 100 };
  
  private short[] TramaRespuestaParoMedidas = new short[] { 
      84, 104, 101, 32, 109, 101, 97, 115, 117, 114, 
      101, 109, 101, 110, 116, 32, 105, 115, 32, 115, 
      116, 111, 112, 112, 101, 100 };
  
  private short[] TramaRespuestaUnoEstado = new short[] { 77, 101, 97, 115, 117, 114, 105, 110, 103 };
  
  private short[] TramaRespuestaDosEstado = new short[] { 
      84, 114, 105, 103, 103, 101, 100, 46, 32, 40, 
      77, 101, 97, 115, 41 };
  
  private short[] TramaRespuestaTRESEstado = new short[] { 
      67, 97, 108, 99, 117, 108, 97, 116, 105, 110, 
      103, 46, 32, 40, 77, 101, 97, 115, 41 };
  
  private short[] TramaRespuestaCuatroEstado = new short[] { 73, 100, 108, 101 };
  
  private short[] TramaRespuesUnidadesDeVelociada = new short[] { 109, 47, 115 };
  
  private short[] NoRespuesta = new short[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private String RespuestaNoError = "No Errors";
  
  private String RespuestaErrrorFueraDeRango = "is out of range";
  
  private String RespuestaErrrorValorInvalido = "Invalid value";
  
  private String RespuestaErrrorO = "O";
  
  private String RespuestaErrrorE = "E";
  
  private String RespuestaErrrorU = "U";
  
  private String RespuestaErrrorR = "R";
  
  private String RespuestaErrrorS = "S";
  
  private String RespuestaErrrorI = "I";
  
  private String RespuestaErrrorN = "N";
  
  private String RespuestaErrrorV = "V";
  
  private String RespuestaComandoRemotoDos = "Already in REMOTE mode";
  
  private String RespuestaReset = "The buffer is cleared";
  
  private String RespuestaInicioMedia = "The measurement is started";
  
  private String RespuestaParoMedidas = "The measurement is stopped";
  
  private String RespuestaUnoEstado = "Measuring";
  
  private String RespuestaDosEstado = "Trigged. (Meas)";
  
  private String RespuestaTRESEstado = "Calculating. (Meas)";
  
  private String RespuestaCuatroEstado = "Idle";
  
  private String RespuesUnidadesDeVelociada = "m/s";
  
  private String EstadoRemotoOk = "Radar en remoto";
  
  private String EstadoRemotoerror = "Radar no esta en estado remoto";
  
  private String ResetOk = "Radar Resesteado";
  
  private String Reseterror = "No se reseto el radar";
  
  private String FechaError = "No se inicio la fecha";
  
  private String HoraError = "No se inicio la Hora";
  
  private String AutCalculoError = "No se inicio calculo automatico";
  
  private String ModoMedidasError = "No se inicio en modo medidas sensillo";
  
  private String AntenaOffsetsError = "No se inicio los OffSets";
  
  private String AntenaSetBackError = "No se inicio el SetBack";
  
  private String EstadoVelocidadTomadaOK = "Velocidad Tomada";
  
  private String EstadoVelocidadTomadaError = "Error al tomar la Velocidad";
  
  private short FinalDeMensaje = 13;
  
  private boolean EnMedicion = false;
  
  public double Velocidad;
  
  public double VelocidadMedia;
  
  public int NumeroDeMedidas = 0;
  
  public int AutoCalcModo;
  
  public int ModoDeMedida;
  
  public double OffSet;
  
  public double SetBack;
  
  public String Mensaje_error_Radar;
  
  public String Mensaje_estado_Radar;
  
  public short[] Unidad = new short[10];
  
  public boolean EstadoRemoto = false;
  
  public boolean SoftReset = false;
  
  public boolean SetFecha = false;
  
  public boolean SetHora = false;
  
  public boolean AutCalculo = false;
  
  public boolean ModoMedidas = false;
  
  public boolean SetAntenaOffsets = false;
  
  public boolean SetAntenaSetBack = false;
  
  public boolean EnEsperaDeTomaVelocida = false;
  
  public boolean MedidaParada = false;
  
  public boolean NumDeMedTomado = false;
  
  public boolean VelMedTomada = false;
  
  public boolean MedidaIniciada = false;
  
  public boolean Comunicacion = false;
  
  private FuncionesRadar() {
    TomarPuerto();
    try {
      IniciarRadar(true);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
  }
  
  public void run() {
    float numeroaux = 0.0F;
    float numerovelaux = 0.0F;
    try {
      IniciarRadar(false);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    for (int i = 0; i < 100; i++)
      this.RespuestaMVR[i] = 0; 
    try {
      COM_Radar.enviar(this.MensajeEstado, (short)8, false);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    try {
      Thread.sleep(50L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    try {
      COM_Radar.recibir(this.RespuestaMVR);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    if (CompararTramas(this.NoRespuesta, this.RespuestaMVR)) {
      this.Comunicacion = false;
    } else if (this.MedidaIniciada) {
      if (CompararTramas(this.TramaRespuestaUnoEstado, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaSysStat1, this.RespuestaMVR)) {
        this.EnEsperaDeTomaVelocida = false;
        this.Comunicacion = true;
        try {
          COM_Radar.enviar(this.MensajeNumeroDeMedidas, (short)8, false);
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
        try {
          Thread.sleep(50L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
        try {
          COM_Radar.recibir(this.RespuestaMVR);
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
        if (this.RespuestaMVR[0] >= 48 && this.RespuestaMVR[0] <= 57)
          numeroaux = DeRespuestaANumero(this.RespuestaMVR, this.Unidad); 
        if (this.Unidad[0] == 0) {
          if (numeroaux > this.NumeroDeMedidas) {
            this.NumeroDeMedidas = (int)numeroaux;
            try {
              COM_Radar.enviar(this.MensajeVelocidad, (short)8, false);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            try {
              Thread.sleep(50L);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            try {
              COM_Radar.recibir(this.RespuestaMVR);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            if (this.RespuestaMVR[0] >= 48 && this.RespuestaMVR[0] <= 57)
              numerovelaux = DeRespuestaANumero(this.RespuestaMVR, this.Unidad); 
            if (this.Unidad[0] == 77 || this.Unidad[0] == 109)
              this.Velocidad = numerovelaux; 
            try {
              COM_Radar.enviar(this.MensajeVelocidadMedia, (short)12, false);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            try {
              Thread.sleep(50L);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            try {
              COM_Radar.recibir(this.RespuestaMVR);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            if (this.RespuestaMVR[0] >= 48 && this.RespuestaMVR[0] <= 57)
              numerovelaux = DeRespuestaANumero(this.RespuestaMVR, this.Unidad); 
            this.VelocidadMedia = numerovelaux;
            this.Mensaje_estado_Radar = this.EstadoVelocidadTomadaOK;
          } 
        } else {
          this.Mensaje_estado_Radar = this.EstadoVelocidadTomadaError;
        } 
      } else {
        this.EnEsperaDeTomaVelocida = true;
      } 
    } 
  }
  
  public void TomarPuerto() {
    COM_Radar = new PuertoSerial("r", IDPuertoRadar, 9600, 8, 1, 0);
  }
  
  public void IniciarRadar(boolean reset_variables) throws SerialPortException, InterruptedException {
    if (reset_variables) {
      this.EstadoRemoto = false;
      this.SoftReset = false;
      this.SetFecha = false;
      this.SetHora = false;
      this.AutCalculo = false;
      this.ModoMedidas = false;
      this.SetAntenaOffsets = false;
      this.SetAntenaSetBack = false;
      this.EnEsperaDeTomaVelocida = false;
      this.MedidaParada = false;
      this.NumDeMedTomado = false;
      this.VelMedTomada = false;
      this.MedidaIniciada = false;
    } 
    if (!this.EstadoRemoto) {
      COM_Radar.enviar(this.MensajeRemoto, (short)7, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaErrrorW, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.EstadoRemoto = true;
      } else {
        this.EstadoRemoto = false;
      } 
    } 
    if (this.EstadoRemoto && !this.SoftReset) {
      COM_Radar.enviar(this.MensajeLimpiarBuffer, (short)10, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaReset, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.SoftReset = true;
      } else {
        this.SoftReset = false;
      } 
    } 
    if (this.SoftReset && !this.SetFecha) {
      Calendar c1 = Calendar.getInstance();
      String dia = Integer.toString(c1.get(5));
      String mes = Integer.toString(c1.get(2) + 1);
      String annio = Integer.toString(c1.get(1));
      AjustarTrama(dia, this.MensajeFecha, 5);
      AjustarTrama(mes, this.MensajeFecha, 7);
      AjustarTrama(annio, this.MensajeFecha, 9);
      COM_Radar.enviar(this.MensajeFecha, (short)12, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.SetFecha = true;
      } else {
        this.SetFecha = false;
      } 
    } 
    if (this.SetFecha && !this.SetHora) {
      Calendar c1 = Calendar.getInstance();
      String hora = Integer.toString(c1.get(11));
      String minuto = Integer.toString(c1.get(12));
      String segundo = Integer.toString(c1.get(13));
      AjustarTrama(hora, this.MensajeHora, 5);
      AjustarTrama(minuto, this.MensajeHora, 8);
      AjustarTrama(segundo, this.MensajeHora, 11);
      COM_Radar.enviar(this.MensajeHora, (short)14, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.SetHora = true;
      } else {
        this.SetHora = false;
      } 
    } 
    if (this.SetHora && !this.AutCalculo) {
      COM_Radar.enviar(this.MensajeForzarAutocalulo, (short)11, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.AutCalculo = true;
      } else {
        this.AutCalculo = false;
      } 
    } 
    if (this.AutCalculo && !this.ModoMedidas) {
      COM_Radar.enviar(this.MensajeModoDeMedidas, (short)11, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.ModoMedidas = true;
      } else {
        this.ModoMedidas = false;
      } 
    } 
    if (this.ModoMedidas && !this.SetAntenaOffsets) {
      COM_Radar.enviar(this.MensajeDesalineacionAntena, (short)15, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.SetAntenaOffsets = true;
      } else {
        this.SetAntenaOffsets = false;
      } 
    } 
    if (this.SetAntenaOffsets && !this.SetAntenaSetBack) {
      COM_Radar.enviar(this.MensajeRetrocesoAntena, (short)16, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (CompararTramas(this.TramaRespuestaNoError, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.SetAntenaSetBack = true;
      } else {
        this.SetAntenaSetBack = false;
      } 
    } 
    if (this.SetAntenaSetBack && !this.NumDeMedTomado) {
      COM_Radar.enviar(this.MensajeNumeroDeMedidas, (short)8, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (this.RespuestaMVR[0] >= 48 && this.RespuestaMVR[0] <= 57) {
        this.NumDeMedTomado = true;
        float numeroaux = (int)DeRespuestaANumero(this.RespuestaMVR, this.Unidad);
        if (this.Unidad[0] == 0) {
          this.NumeroDeMedidas = (int)numeroaux;
          if (this.NumeroDeMedidas == 0) {
            this.VelMedTomada = true;
            this.VelocidadMedia = 0.0D;
          } 
        } 
      } else {
        this.NumDeMedTomado = false;
      } 
    } 
    if (this.NumDeMedTomado && !this.VelMedTomada) {
      COM_Radar.enviar(this.MensajeVelocidadMedia, (short)12, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      if (this.RespuestaMVR[0] >= 48 && this.RespuestaMVR[0] <= 57) {
        this.VelMedTomada = true;
        float numeroaux = DeRespuestaANumero(this.RespuestaMVR, this.Unidad);
        this.VelocidadMedia = numeroaux;
      } else {
        this.VelMedTomada = false;
      } 
    } 
    if (this.VelMedTomada && !this.MedidaIniciada) {
      COM_Radar.enviar(this.MensajePararMedidas, (short)9, false);
      Thread.sleep(50L);
      COM_Radar.recibir(this.RespuestaMVR);
      try {
        COM_Radar.enviar(this.MensajeInicioMedida, (short)8, false);
      } catch (SerialPortException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
      try {
        Thread.sleep(50L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
      try {
        COM_Radar.recibir(this.RespuestaMVR);
      } catch (SerialPortException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
      if (CompararTramas(this.TramaRespuestaInicioMedia, this.RespuestaMVR) || CompararTramas(this.TramaRespuestaNoErrror_O, this.RespuestaMVR)) {
        this.MedidaIniciada = true;
      } else {
        this.MedidaIniciada = false;
      } 
    } 
  }
  
  void ResetBanderas() {
    this.EstadoRemoto = false;
    this.SoftReset = false;
    this.SetFecha = false;
    this.SetHora = false;
    this.AutCalculo = false;
    this.ModoMedidas = false;
    this.SetAntenaOffsets = false;
    this.SetAntenaSetBack = false;
    this.EnEsperaDeTomaVelocida = false;
    this.MedidaParada = false;
    this.NumDeMedTomado = false;
    this.VelMedTomada = false;
    this.MedidaIniciada = false;
  }
  
  boolean CompararTramas(short[] Esperado, short[] Recibido) {
    boolean iguales = true;
    int tamaño = Esperado.length;
    for (int i = 0; i < tamaño; i++) {
      if (Esperado[i] != Recibido[i]) {
        iguales = false;
        break;
      } 
    } 
    return iguales;
  }
  
  void AjustarTrama(String dato, short[] Arreglo, int posicion) {
    if (dato.length() == 1) {
      Arreglo[posicion] = 48;
      Arreglo[posicion + 1] = (short)(Short.parseShort(dato.substring(0, 1)) + 48);
    } else if (dato.length() == 2) {
      Arreglo[posicion] = (short)(Short.parseShort(dato.substring(0, 1)) + 48);
      Arreglo[posicion + 1] = (short)(Short.parseShort(dato.substring(1, 2)) + 48);
    } else if (dato.length() == 4) {
      Arreglo[posicion] = (short)(Short.parseShort(dato.substring(2, 3)) + 48);
      Arreglo[posicion + 1] = (short)(Short.parseShort(dato.substring(3, 4)) + 48);
    } 
  }
  
  float DeRespuestaANumero(short[] Respuesta, short[] Unidades) {
    float numero = 0.0F;
    float multiplicador = 0.1F;
    int Posicion = 0;
    int signo = 1;
    int j = 0;
    for (int i = 0; i < 10; i++)
      Unidades[i] = 0; 
    while (Respuesta[Posicion] != 46 && Respuesta[Posicion] != 13) {
      if (Respuesta[Posicion] == 45) {
        signo = -1;
      } else if (Respuesta[Posicion] >= 48 && Respuesta[Posicion] <= 57) {
        numero *= 10.0F;
        numero += (Respuesta[Posicion] - 48);
      } 
      Posicion++;
      if (Posicion >= 30)
        break; 
    } 
    Posicion++;
    if (Posicion < 30) {
      while (Respuesta[Posicion] >= 48 && Respuesta[Posicion] <= 57) {
        if (Posicion >= 30)
          break; 
        numero += (Respuesta[Posicion] - 48) * multiplicador;
        multiplicador = (float)(multiplicador * 0.1D);
        Posicion++;
      } 
      numero *= signo;
    } 
    Posicion++;
    if (Posicion < 30)
      while (Respuesta[Posicion] != 13 && Respuesta[Posicion] != 10 && Respuesta[Posicion] != 0) {
        if (Posicion >= 30)
          break; 
        if (Respuesta[Posicion] >= 65 && Respuesta[Posicion] <= 122) {
          Unidades[j] = Respuesta[Posicion];
          j++;
        } 
        Posicion++;
      }  
    return numero;
  }
  
  public static FuncionesRadar getSingletonInstance() {
    if (funcionesRadar == null)
      funcionesRadar = new FuncionesRadar(); 
    return funcionesRadar;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Hardware\FuncionesRadar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */