package co.dynamicts.neli.core.Hardware;

import co.dynamicts.neli.core.interfaces.Configuracion;
import jssc.SerialPortException;

import javax.swing.*;

public class FuncionesCPA extends Thread {
  private static FuncionesCPA funcionesCPA;
  
  public PuertoSerial COM_CPA;
  
  private boolean isCPA;
  
  public Configuracion configuracion = Configuracion.getSingletonInstance();
  
  public static String IDPuertoCPA = (Configuracion.getSingletonInstance()).PuertoSerialCPA;
  
  public static float AzimuthActual;
  
  public static float PitchActual;
  
  public static float Latitud;
  
  public static float Longitud;
  
  public static float AzimuthObjetivo;
  
  public static float PitchObjetivo;
  
  public static float OffSetUp;
  
  public static float OffSetDn;
  
  public static float OffSetLf;
  
  public static float OffSetRg;
  
  public static String Estado;
  
  public int Est_Conex = 0;
  
  public short Comando = 14;
  
  public static short TipodeComando;
  
  public static short ComandoLectura = 0;
  
  public static short ComandoEscritura = 12;
  
  public static boolean CMSCommAlarm;
  
  public static boolean MovementAlarm;
  
  public static boolean PositioningAlamrSW;
  
  public static boolean PositionAlamrHW;
  
  public static boolean CalibradoPitch;
  
  public static boolean CalibradoAzimuth;
  
  public static boolean TargetNotLocked;
  
  public static boolean TargetLocked;
  
  public static boolean SintonizingDevice;
  
  public static boolean PrimerMontajeCPA;
  
  public static boolean MatrizCalculada;
  
  public static boolean FueraDeConoApuntamiento;
  
  public static boolean OffsetsError;
  
  public static boolean ErrorCambioDePieza;
  
  public static boolean ErrorComunicacion;
  
  public static boolean ChecksumAlarma;
  
  public static boolean ReferenciaDeCalibracionEnElevacion;
  
  public static boolean ReferenciaDeCalibracionEnOrientacion;
  
  public static boolean EnMoviemiento;
  
  public static boolean CalibracionFinalizada;
  
  public static boolean AjustandoOffsets;
  
  public static boolean Apagada;
  
  public static boolean Desbloqueada;
  
  public static boolean Disparando;
  
  public static boolean final_carrera_arriba;
  
  public static boolean final_carrera_abajo;
  
  public static boolean final_carrera_izquierda;
  
  public static boolean final_carrera_derecha;
  
  public static boolean Sensor_calibracion_Orientacion;
  
  public static boolean Sensor_calibracion_Elevacion;
  
  public static boolean HMS_Enecendido = false;
  
  public static boolean HMS_PresionCorrecta = false;
  
  public static boolean HMS_PosiInicial = false;
  
  public static boolean HMS_ModoAuto = false;
  
  public static boolean HMS_SecAtacComp = false;
  
  public static boolean HMS_AtacaComp = false;
  
  public static boolean HMS_LimiteEleva = false;
  
  public static boolean HMS_FalloPosic = false;
  
  public static boolean HMS_PresAtaca = false;
  
  public static boolean HMS_TempAceit = false;
  
  public static boolean HMS_FalloElectr = false;
  
  public static boolean HMS_Preparado = false;
  
  public static boolean HMS_CierreAbierto = false;
  
  public static boolean HMS_CierrreCerrado = false;
  
  public static boolean HMS_PresionSistema = false;
  
  public static boolean HMS_Elev25 = false;
  
  public static boolean HMS_Eleva45 = false;
  
  public static boolean HMS_TejaDesal = false;
  
  public static boolean HMS_TejaAlineada = false;
  
  public static boolean HMS_TejaArriba = false;
  
  public static boolean HMS_TejaAbajo = false;
  
  public static boolean HMS_Bloqueado = false;
  
  public static boolean HMS_ProyectilEnTeja = false;
  
  public static int CMS_TempTubo;
  
  public static int CMS_DistanRetroceso;
  
  public static int CMS_EFCUltimoDisparo;
  
  public static int CMS_CargoUltimoDisparo;
  
  public static int CMS_DispAccion;
  
  public static int CMS_DispTotalTubo;
  
  public static int CMS_TempIncrTubo;
  
  public static int CMS_MaxiRetroceso;
  
  public static float CMS_MaximoEFC;
  
  public static float CMS_EFCAccion;
  
  public static float CMS_EFCTotal;
  
  public static int CMS_TempCorte;
  
  public static int Parametro_Fase0;
  
  public static int Parametro_Fase1;
  
  public static int Parametro_Fase2;
  
  public static int Parametro_Fase3;
  
  public static float Parametro_Alfa_Der;
  
  public static float Parametro_Alfa_Izq;
  
  public static int Parametro_M_Din_Der;
  
  public static int Parametro_M_Din_Izq;
  
  public static float Parametro_M_Err_Der;
  
  public static float Parametro_M_Err_Izq;
  
  public static float Parametro_Kp_Arriba;
  
  public static float Parametro_Kp_Abajo;
  
  private static short[] Trama = new short[] { 
      85, 14, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0 };
  
  private static short[] respuesta_CPA = new short[52];
  
  private static short[] respuesta_CPA_ESTADO = new short[] { 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0 };
  
  private static short[] respuesta_CMS_TEM = new short[] { 85, 116, 3, 20, 0, 0, 32 };
  
  private static short[] respuesta_CMS_DAT = new short[] { 
      85, 97, 28, 0, 63, 0, 63, 67, 11, 113, 
      105, 67, 11, 113, 105, 150, 100, 130, 70, 28, 
      63, 246, 0, 0, 0, 0, 0, 0, 8, 0, 
      30, 39 };
  
  private static short[] pos_act = new short[] { 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private static short[] pos_AUX = new short[] { 0, 0, 0, 0 };
  
  private static short[] pos_obj = new short[] { 0, 0, 0, 0 };
  
  private static short[] OffSetsArr = new short[] { 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private static short[] desblq = new short[] { 85, 210, 0, 217 };
  
  private static short[] TramaPedirEstado = new short[] { 84, 65, 14 };
  
  private static String[] MensajeEstado = new String[] { 
      "Apuntando", "Moviendo a Posicion", "En Espera", "Calibrando", "Trincando", "Destrincando", "CPA Bloqueada en Comunicacion", "CPA Bloqueada trinca", "Calibrando OFFSETS", "Disparando", 
      "Desconocido" };
  
  private static short LargoTrama = 4;
  
  public static boolean BotonCalibrarOffsets = false;
  
  public static short apagar = 211;
  
  public static short desbloquear = 210;
  
  public static short parar = 209;
  
  public static short disparar = 213;
  
  public static short apuntar = 161;
  
  public static short ir_a_posi = 162;
  
  public static short in_travel_LK = 163;
  
  public static short out_travel_LK = 164;
  
  public static short calibrar = 165;
  
  public static short CalibrarOffSets = 166;
  
  public static short GetCPAStat = 14;
  
  public short CambiarOffSets = 26;
  
  public static short TomarOffSets = 30;
  
  public static short SetCPAParamDos = 42;
  
  public static short GetCPAParamDos = 46;
  
  public static short SetParamControl1 = 58;
  
  public static short GetParamControl1 = 62;
  
  public static short GetCMSData = 65;
  
  public static short SetCMSData = 78;
  
  public static short RestartCMS = 212;
  
  public static short GetCMSTMP = 84;
  
  public static short SetParamControl2 = 90;
  
  public static short GetParamControl2 = 94;
  
  public static short GetParaRecorrTrincYDestric = 225;
  
  public static short SetParaRecorrTrincYDestric = 227;
  
  private static String[] TipoDePedido = new String[] { "GetCPAStat", "GetCPAParam", "GetCMSData", "GetCMSTMP", "GetPosActyPosObjCPA" };
  
  public static short NumeroDeMensajes = 0;
  
  public static int veces;
  
  private int Rotacion = 0;
  
  public void run() {
    ImageIcon IconoTomarDatos = new ImageIcon("C:\\Users\\DTS\\IdeaProjects\\Pantalla_CPA_V2\\Recursos\\remote [#220].png");
    short[] Pedio = { 14, 62, 65, 84, 225 };
    float[] ArrgOffsets = new float[4];
    int PuestInMedioDePosicActual = 7;
    int PuestoInicialPosicObjetivo = 11;
    boolean rev_fin_carrera = true;
    setCPA(true);
    decimal_a_hex((AzimuthObjetivo * 10.0F), (PitchObjetivo * 20.0F), pos_obj);
    decimal_a_hex((AzimuthActual * 10.0F), (PitchActual * 20.0F), pos_act);
    decimal_a_hex((Latitud * 10.0F), (Longitud * 10.0F), pos_AUX);
    int i;
    for (i = 0; i < 4; i++)
      pos_act[i + 4] = pos_AUX[i]; 
    if (this.Comando == GetCPAStat)
      TipodeComando = ComandoLectura; 
    if (Trama[1] == apagar) {
      TipodeComando = ComandoLectura;
      if (NumeroDeMensajes == 0) {
        Apagada = true;
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } else {
        NumeroDeMensajes = (short)(NumeroDeMensajes - 1);
      } 
    } 
    if (Trama[1] == desbloquear && respuesta_CPA[3] == 2) {
      TipodeComando = ComandoLectura;
      this.Comando = GetCPAStat;
      TipodeComando = ComandoLectura;
    } 
    if (Trama[1] == parar && respuesta_CPA[3] == 2) {
      TipodeComando = ComandoLectura;
      this.Comando = GetCPAStat;
      TipodeComando = ComandoLectura;
    } 
    if (Trama[1] == disparar && respuesta_CPA[3] == 9) {
      TipodeComando = ComandoLectura;
      this.Comando = GetCPAStat;
      TipodeComando = ComandoLectura;
    } 
    if (Trama[1] == TomarOffSets) {
      TipodeComando = ComandoLectura;
      if (respuesta_CPA[1] == 17) {
        OffsetsDeResADatos(ArrgOffsets, respuesta_CPA);
        OffSetUp = ArrgOffsets[2];
        OffSetDn = ArrgOffsets[3];
        OffSetLf = ArrgOffsets[1];
        OffSetRg = ArrgOffsets[0];
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == in_travel_LK) {
      TipodeComando = ComandoEscritura;
      PuestInMedioDePosicActual = 7;
      PuestoInicialPosicObjetivo = 11;
      if (respuesta_CPA[3] == 4) {
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == out_travel_LK) {
      TipodeComando = ComandoEscritura;
      PuestInMedioDePosicActual = 7;
      PuestoInicialPosicObjetivo = 11;
      if (respuesta_CPA[3] == 5) {
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == calibrar) {
      TipodeComando = ComandoEscritura;
      PuestInMedioDePosicActual = 7;
      PuestoInicialPosicObjetivo = 11;
      rev_fin_carrera = false;
      if (respuesta_CPA[6] == 248 && respuesta_CPA[7] == 48) {
        rev_fin_carrera = true;
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
      if ((respuesta_CPA[4] & 0x10) > 0 || (respuesta_CPA[4] & 0x40) > 0 || PitchActual < 0.0F) {
        AzimuthObjetivo = AzimuthActual;
        PitchObjetivo = PitchActual;
        for (i = 0; i < 3; i++) {
          try {
            this.COM_CPA.enviar(desblq, (short)4, true);
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } 
          try {
            this.COM_CPA.recibir(respuesta_CPA);
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } 
        } 
        if ((respuesta_CPA[7] & 0x1) > 0)
          PitchObjetivo -= 1200.0F; 
        if ((respuesta_CPA[7] & 0x2) > 0 || PitchActual < 0.0F)
          PitchObjetivo += 250.0F; 
        if ((respuesta_CPA[7] & 0x4) > 0) {
          AzimuthObjetivo += 750.0F;
          if (AzimuthObjetivo >= 6400.0F)
            AzimuthObjetivo -= 6400.0F; 
        } 
        if ((respuesta_CPA[7] & 0x8) > 0) {
          AzimuthObjetivo -= 570.0F;
          if (AzimuthObjetivo <= 0.0F)
            AzimuthObjetivo += 6400.0F; 
        } 
        this.Comando = ir_a_posi;
      } 
    } 
    if (Trama[1] == ir_a_posi || Trama[1] == apuntar) {
      TipodeComando = ComandoEscritura;
      PuestInMedioDePosicActual = 11;
      PuestoInicialPosicObjetivo = 7;
      if ((respuesta_CPA[4] & 0x10) > 0 && rev_fin_carrera) {
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
      if ((respuesta_CPA[4] & 0x1) > 0 && comp_aprox()) {
        if (Trama[1] == ir_a_posi) {
          if (rev_fin_carrera) {
            TargetLocked = true;
          } else {
            for (i = 0; i < 3; i++) {
              try {
                this.COM_CPA.enviar(desblq, (short)4, true);
              } catch (SerialPortException e) {
                e.printStackTrace();
              } catch (InterruptedException e) {
                e.printStackTrace();
              } 
              try {
                this.COM_CPA.recibir(respuesta_CPA);
              } catch (SerialPortException e) {
                e.printStackTrace();
              } catch (InterruptedException e) {
                e.printStackTrace();
              } 
            } 
            this.Comando = calibrar;
            TipodeComando = ComandoEscritura;
          } 
        } else if (Trama[1] == apuntar) {
          TargetLocked = true;
        } 
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == CalibrarOffSets) {
      TipodeComando = ComandoEscritura;
      PuestInMedioDePosicActual = 11;
      PuestoInicialPosicObjetivo = 7;
      if ((respuesta_CPA[4] & 0x10) > 0) {
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
      if (respuesta_CPA[3] == 8)
        BotonCalibrarOffsets = true; 
      if (respuesta_CPA[6] == 0 && respuesta_CPA[3] == 2 && BotonCalibrarOffsets) {
        JOptionPane.showMessageDialog(null, "OffSets Calibrados", "Estado", 1);
        CalibracionFinalizada = true;
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == this.CambiarOffSets) {
      TipodeComando = ComandoEscritura;
      short[] PrimeraParteOffSetsArr = { 0, 0, 0, 0 };
      short[] SegundaParteOffSetsArr = { 0, 0, 0, 0 };
      decimal_a_hex((OffSetRg * 10.0F), (OffSetLf * 10.0F), PrimeraParteOffSetsArr);
      decimal_a_hex((OffSetUp * 10.0F), (OffSetDn * 10.0F), SegundaParteOffSetsArr);
      int j;
      for (j = 0; j < 4; j++)
        Trama[j + 3] = PrimeraParteOffSetsArr[j]; 
      for (j = 0; j < 4; j++)
        Trama[j + 7] = SegundaParteOffSetsArr[j]; 
      if (veces == 0) {
        this.Comando = TomarOffSets;
        TipodeComando = ComandoLectura;
      } 
      veces--;
    } 
    if (Trama[1] == GetParaRecorrTrincYDestric) {
      TipodeComando = ComandoLectura;
      if (respuesta_CPA[1] == 229) {
        short[] AuxFases0_1 = new short[4];
        short[] AuxFases2_3 = new short[4];
        float[] Fases0_1 = new float[2];
        float[] Fases2_3 = new float[2];
        int j;
        for (j = 0; j < 4; j++)
          AuxFases0_1[j] = respuesta_CPA[j + 3]; 
        for (j = 0; j < 4; j++)
          AuxFases2_3[j] = respuesta_CPA[j + 7]; 
        hex_a_decimal(AuxFases0_1, Fases0_1);
        hex_a_decimal(AuxFases2_3, Fases2_3);
        Parametro_Fase0 = (int)Fases0_1[0];
        Parametro_Fase1 = (int)Fases0_1[1];
        Parametro_Fase2 = (int)Fases2_3[0];
        Parametro_Fase3 = (int)Fases2_3[1];
        this.Comando = GetParamControl1;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == GetParamControl1) {
      TipodeComando = ComandoLectura;
      if (respuesta_CPA[1] == 49) {
        short[] AuxAlfa = new short[4];
        short[] AuxMDin = new short[4];
        short[] AuxMErr = new short[4];
        float[] Alfa = new float[2];
        float[] MDin = new float[2];
        float[] MErr = new float[2];
        int j;
        for (j = 0; j < 4; j++)
          AuxAlfa[j] = respuesta_CPA[j + 3]; 
        for (j = 0; j < 4; j++)
          AuxMDin[j] = respuesta_CPA[j + 7]; 
        for (j = 0; j < 4; j++)
          AuxMErr[j] = respuesta_CPA[j + 11]; 
        hex_a_decimal(AuxAlfa, Alfa);
        hex_a_decimal(AuxMDin, MDin);
        hex_a_decimal(AuxMErr, MErr);
        Parametro_Alfa_Der = Alfa[0] / 10000.0F;
        Parametro_Alfa_Izq = Alfa[1] / 10000.0F;
        Parametro_M_Din_Der = (int)MDin[0];
        Parametro_M_Din_Izq = (int)MDin[1];
        Parametro_M_Err_Der = (int)(MErr[0] / 10.0F);
        Parametro_M_Err_Izq = (int)(MErr[1] / 10.0F);
        this.Comando = GetParamControl2;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == GetParamControl2) {
      TipodeComando = ComandoLectura;
      if (respuesta_CPA[1] == 81) {
        short[] AuxKp = new short[4];
        float[] Kp = new float[2];
        for (int j = 0; j < 4; j++)
          AuxKp[j] = respuesta_CPA[j + 3]; 
        hex_a_decimal(AuxKp, Kp);
        Parametro_Kp_Arriba = Kp[0] / 10000.0F;
        Parametro_Kp_Abajo = Kp[1] / 10000.0F;
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
    } 
    if (Trama[1] == SetParaRecorrTrincYDestric) {
      TipodeComando = 8;
      short[] ArrFase01 = { 0, 0, 0, 0 };
      short[] ArrFase23 = { 0, 0, 0, 0 };
      decimal_a_hex(Parametro_Fase0, Parametro_Fase1, ArrFase01);
      decimal_a_hex(Parametro_Fase2, Parametro_Fase3, ArrFase23);
      int j;
      for (j = 0; j < 4; j++)
        Trama[j + 3] = ArrFase01[j]; 
      for (j = 0; j < 4; j++)
        Trama[j + 7] = ArrFase23[j]; 
      if (veces == 0) {
        this.Comando = SetParamControl1;
        TipodeComando = ComandoEscritura;
        veces = 2;
      } else {
        veces--;
      } 
    } 
    if (Trama[1] == SetParamControl1) {
      TipodeComando = ComandoEscritura;
      short[] ArrAlfa = { 0, 0, 0, 0 };
      short[] ArrMDin = { 0, 0, 0, 0 };
      short[] ArrMErr = { 0, 0, 0, 0 };
      decimal_a_hex((Parametro_Alfa_Der * 10000.0F), (Parametro_Alfa_Izq * 10000.0F), ArrAlfa);
      decimal_a_hex(Parametro_M_Din_Der, Parametro_M_Din_Izq, ArrMDin);
      decimal_a_hex((Parametro_M_Err_Der * 10.0F), (Parametro_M_Err_Izq * 10.0F), ArrMErr);
      int j;
      for (j = 0; j < 4; j++)
        Trama[j + 3] = ArrAlfa[j]; 
      for (j = 0; j < 4; j++)
        Trama[j + 7] = ArrMDin[j]; 
      for (j = 0; j < 4; j++)
        Trama[j + 11] = ArrMErr[j]; 
      if (veces == 0) {
        this.Comando = SetParamControl2;
        TipodeComando = ComandoEscritura;
        veces = 2;
      } else {
        veces--;
      } 
    } 
    if (Trama[1] == SetParamControl2) {
      TipodeComando = 4;
      short[] ArrKp = { 0, 0, 0, 0 };
      decimal_a_hex((Parametro_Kp_Arriba * 10000.0F), (Parametro_Kp_Abajo * 10000.0F), ArrKp);
      for (int j = 0; j < 4; j++)
        Trama[j + 3] = ArrKp[j]; 
      if (veces == 0) {
        this.Comando = GetParaRecorrTrincYDestric;
        TipodeComando = ComandoLectura;
      } 
      veces--;
    } 
    if (this.Comando == SetCMSData) {
      short[] AuxSetCMS = new short[4];
      TipodeComando = ComandoEscritura;
      decimal_a_hex(CMS_DispAccion, CMS_DispTotalTubo, AuxSetCMS);
      int j;
      for (j = 0; j < 4; j++)
        Trama[j + 3] = AuxSetCMS[j]; 
      Trama[15] = (short)(CMS_MaxiRetroceso / 10);
      Trama[16] = (short)CMS_TempIncrTubo;
      Trama[17] = (short)CMS_TempCorte;
      for (j = 0; j < 9; j++)
        Trama[22 + j] = 0; 
      float_a_hex(CMS_EFCAccion, AuxSetCMS);
      for (j = 0; j < 4; j++)
        Trama[7 + j] = AuxSetCMS[j]; 
      float_a_hex(CMS_EFCTotal, AuxSetCMS);
      for (j = 0; j < 4; j++)
        Trama[11 + j] = AuxSetCMS[j]; 
      float_a_hex(CMS_MaximoEFC, AuxSetCMS);
      for (j = 0; j < 4; j++)
        Trama[18 + j] = AuxSetCMS[j]; 
      if (veces == 0) {
        this.Comando = GetCPAStat;
        TipodeComando = ComandoLectura;
      } 
      veces--;
    } 
    if (this.Comando != this.CambiarOffSets && this.Comando != GetCPAStat && this.Comando != SetCMSData && this.Comando != SetParaRecorrTrincYDestric && this.Comando != SetParamControl1 && this.Comando != SetParamControl2) {
      for (i = 0; i < 4; i++)
        Trama[3 + i] = pos_act[i]; 
      for (i = 0; i < 4; i++)
        Trama[PuestInMedioDePosicActual + i] = pos_act[i + 4]; 
      for (i = 0; i < 4; i++)
        Trama[PuestoInicialPosicObjetivo + i] = pos_obj[i]; 
    } 
    if (this.Comando == GetCPAStat) {
      LargoTrama = 4;
    } else if (this.Comando == SetParaRecorrTrincYDestric) {
      LargoTrama = 12;
    } else if (this.Comando == SetParamControl2) {
      LargoTrama = 8;
    } else if (TipodeComando == 0 && this.Comando != GetCPAStat) {
      LargoTrama = 4;
    } else if (TipodeComando == 12 && this.Comando != SetCMSData) {
      LargoTrama = 16;
    } else if (TipodeComando == 12 && this.Comando == SetCMSData) {
      LargoTrama = 32;
    } 
    if (this.Comando == GetCPAStat) {
      Trama[1] = TramaPedirEstado[this.Rotacion];
      this.Rotacion++;
      if (this.Rotacion >= 3)
        this.Rotacion = 0; 
    } else {
      Trama[1] = this.Comando;
    } 
    Trama[2] = TipodeComando;
    try {
      this.COM_CPA.enviar(Trama, LargoTrama, true);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    for (i = 0; i < 52; i++)
      respuesta_CPA[i] = 0; 
    try {
      this.COM_CPA.recibir(respuesta_CPA);
    } catch (SerialPortException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    int k;
    for (k = 0; k < 52; k++) {
      if (respuesta_CPA[k] == 85 && respuesta_CPA[k + 1] == 1 && k + 12 < 52) {
        for (int j = 0; j < 12; j++)
          respuesta_CPA_ESTADO[j] = respuesta_CPA[j + k]; 
        ActaulizarBanderasCPA();
        ActualizarBanderasHMS();
        break;
      } 
    } 
    if (this.Comando == GetCPAStat)
      for (k = 0; k < 52; k++) {
        if (respuesta_CPA[k] == 85 && respuesta_CPA[k + 1] == 116 && k + 7 < 52) {
          for (int j = 0; j < 7; j++)
            respuesta_CMS_TEM[j] = respuesta_CPA[j + k]; 
          ActualizarDatosCMS();
        } 
        if (respuesta_CPA[k] == 85 && respuesta_CPA[k + 1] == 97 && k + 32 < 52)
          for (int j = 0; j < 32; j++)
            respuesta_CMS_DAT[j] = respuesta_CPA[j + k];  
      }  
    Actualizar_estado();
  }
  
  public void TomarPuerto() {
    this.COM_CPA = new PuertoSerial("c", this.configuracion.PuertoSerialCPA, 19200, 8, 1, 0);
  }
  
  void Actualizar_estado() {
    this.Est_Conex = 0;
    if (respuesta_CPA[1] == 1) {
      setCPA(true);
      Apagada = false;
      if (respuesta_CPA[3] > 9) {
        Estado = MensajeEstado[10];
      } else {
        Estado = MensajeEstado[respuesta_CPA[3]];
      } 
      this.Est_Conex = 2;
      if (respuesta_CPA[3] == 6 || respuesta_CPA[3] == 7) {
        Desbloqueada = false;
        this.Est_Conex = 1;
      } else {
        Desbloqueada = true;
      } 
      if (respuesta_CPA[3] == 9) {
        Disparando = false;
      } else {
        Disparando = true;
      } 
    } else {
      setCPA(false);
    } 
  }
  
  static void ActaulizarBanderasCPA() {
    if ((respuesta_CPA_ESTADO[4] & 0x80) > 0) {
      CMSCommAlarm = true;
    } else {
      CMSCommAlarm = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x40) > 0) {
      MovementAlarm = true;
    } else {
      MovementAlarm = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x20) > 0) {
      PositioningAlamrSW = true;
    } else {
      PositioningAlamrSW = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x10) > 0) {
      PositionAlamrHW = true;
    } else {
      PositionAlamrHW = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x8) > 0) {
      CalibradoPitch = true;
    } else {
      CalibradoPitch = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x4) > 0) {
      CalibradoAzimuth = true;
    } else {
      CalibradoAzimuth = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x2) > 0) {
      TargetNotLocked = true;
    } else {
      TargetNotLocked = false;
    } 
    if ((respuesta_CPA_ESTADO[4] & 0x1) <= 0)
      TargetLocked = false; 
    if ((respuesta_CPA_ESTADO[5] & 0x80) > 0) {
      SintonizingDevice = true;
    } else {
      SintonizingDevice = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x40) > 0) {
      PrimerMontajeCPA = true;
    } else {
      PrimerMontajeCPA = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x20) > 0) {
      MatrizCalculada = true;
    } else {
      MatrizCalculada = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x10) > 0) {
      FueraDeConoApuntamiento = true;
    } else {
      FueraDeConoApuntamiento = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x8) > 0) {
      OffsetsError = true;
    } else {
      OffsetsError = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x4) > 0) {
      ErrorCambioDePieza = true;
    } else {
      ErrorCambioDePieza = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x2) > 0) {
      ErrorComunicacion = true;
    } else {
      ErrorComunicacion = false;
    } 
    if ((respuesta_CPA_ESTADO[5] & 0x1) > 0) {
      ChecksumAlarma = true;
    } else {
      ChecksumAlarma = false;
    } 
    if ((respuesta_CPA_ESTADO[6] & 0x80) > 0) {
      ReferenciaDeCalibracionEnElevacion = true;
    } else {
      ReferenciaDeCalibracionEnElevacion = false;
    } 
    if ((respuesta_CPA_ESTADO[6] & 0x40) > 0) {
      ReferenciaDeCalibracionEnOrientacion = true;
    } else {
      ReferenciaDeCalibracionEnOrientacion = false;
    } 
    if ((respuesta_CPA_ESTADO[6] & 0x20) > 0) {
      EnMoviemiento = true;
    } else {
      EnMoviemiento = false;
    } 
    if ((respuesta_CPA_ESTADO[6] & 0x8) <= 0)
      CalibracionFinalizada = false; 
    if ((respuesta_CPA_ESTADO[6] & 0x1) > 0) {
      AjustandoOffsets = true;
    } else {
      AjustandoOffsets = false;
    } 
    if ((respuesta_CPA[7] & 0x1) > 0) {
      final_carrera_arriba = true;
    } else {
      final_carrera_arriba = false;
    } 
    if ((respuesta_CPA[7] & 0x2) > 0) {
      final_carrera_abajo = true;
    } else {
      final_carrera_abajo = false;
    } 
    if ((respuesta_CPA[7] & 0x4) > 0) {
      final_carrera_izquierda = true;
    } else {
      final_carrera_izquierda = false;
    } 
    if ((respuesta_CPA[7] & 0x8) > 0) {
      final_carrera_derecha = true;
    } else {
      final_carrera_derecha = false;
    } 
    if ((respuesta_CPA[7] & 0x10) > 0) {
      Sensor_calibracion_Elevacion = true;
    } else {
      Sensor_calibracion_Elevacion = false;
    } 
    if ((respuesta_CPA[7] & 0x20) > 0) {
      Sensor_calibracion_Orientacion = true;
    } else {
      Sensor_calibracion_Orientacion = false;
    } 
  }
  
  static void ActualizarBanderasHMS() {
    if ((respuesta_CPA_ESTADO[8] & 0x1) > 0) {
      HMS_Enecendido = true;
    } else {
      HMS_Enecendido = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x2) > 0) {
      HMS_PresionCorrecta = true;
    } else {
      HMS_PresionCorrecta = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x4) > 0) {
      HMS_PosiInicial = true;
    } else {
      HMS_PosiInicial = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x8) > 0) {
      HMS_ModoAuto = true;
    } else {
      HMS_ModoAuto = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x10) > 0) {
      HMS_SecAtacComp = true;
    } else {
      HMS_SecAtacComp = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x20) > 0) {
      HMS_AtacaComp = true;
    } else {
      HMS_AtacaComp = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x40) > 0) {
      HMS_LimiteEleva = true;
    } else {
      HMS_LimiteEleva = false;
    } 
    if ((respuesta_CPA_ESTADO[8] & 0x80) > 0) {
      HMS_FalloPosic = true;
    } else {
      HMS_FalloPosic = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x1) > 0) {
      HMS_PresAtaca = true;
    } else {
      HMS_PresAtaca = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x2) > 0) {
      HMS_TempAceit = true;
    } else {
      HMS_TempAceit = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x4) > 0) {
      HMS_FalloElectr = true;
    } else {
      HMS_FalloElectr = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x8) > 0) {
      HMS_Preparado = true;
    } else {
      HMS_Preparado = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x10) > 0) {
      HMS_CierreAbierto = true;
    } else {
      HMS_CierreAbierto = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x20) > 0) {
      HMS_CierrreCerrado = true;
    } else {
      HMS_CierrreCerrado = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x40) > 0) {
      HMS_PresionSistema = true;
    } else {
      HMS_PresionSistema = false;
    } 
    if ((respuesta_CPA_ESTADO[9] & 0x80) > 0) {
      HMS_Elev25 = true;
    } else {
      HMS_Elev25 = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x1) > 0) {
      HMS_Eleva45 = true;
    } else {
      HMS_Eleva45 = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x2) > 0) {
      HMS_TejaDesal = true;
    } else {
      HMS_TejaDesal = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x4) > 0) {
      HMS_TejaAlineada = true;
    } else {
      HMS_TejaAlineada = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x8) > 0) {
      HMS_TejaArriba = true;
    } else {
      HMS_TejaArriba = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x10) > 0) {
      HMS_TejaAbajo = true;
    } else {
      HMS_TejaAbajo = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x20) > 0) {
      HMS_Bloqueado = true;
    } else {
      HMS_Bloqueado = false;
    } 
    if ((respuesta_CPA_ESTADO[10] & 0x40) > 0) {
      HMS_ProyectilEnTeja = true;
    } else {
      HMS_ProyectilEnTeja = false;
    } 
  }
  
  void ActualizarDatosCMS() {
    short[] aux = new short[4];
    float[] respaux = new float[2];
    CMS_TempTubo = respuesta_CMS_TEM[3];
    CMS_DistanRetroceso = respuesta_CMS_TEM[4];
    CMS_EFCUltimoDisparo = 0;
    CMS_CargoUltimoDisparo = 0;
    int i;
    for (i = 0; i < 4; i++)
      aux[i] = respuesta_CMS_DAT[i + 3]; 
    hex_a_decimal(aux, respaux);
    CMS_DispAccion = (int)respaux[0];
    CMS_DispTotalTubo = (int)respaux[1];
    CMS_TempIncrTubo = respuesta_CMS_DAT[16];
    CMS_MaxiRetroceso = respuesta_CMS_DAT[15] * 10;
    for (i = 0; i < 4; i++)
      aux[i] = respuesta_CMS_DAT[i + 18]; 
    CMS_MaximoEFC = hex_a_float(aux);
    for (i = 0; i < 4; i++)
      aux[i] = respuesta_CMS_DAT[i + 7]; 
    CMS_EFCAccion = hex_a_float(aux);
    for (i = 0; i < 4; i++)
      aux[i] = respuesta_CMS_DAT[i + 11]; 
    CMS_EFCTotal = hex_a_float(aux);
    CMS_TempCorte = respuesta_CMS_DAT[17];
  }
  
  static void OffsetsDeResADatos(float[] OffsetsDato, short[] OffsetsTrama) {
    short[] offset_orientacion = new short[4];
    short[] offset_elevacion = new short[4];
    float[] Offset_Orientacion_Decimal = new float[2];
    float[] Offset_Elevacion_Decimal = new float[2];
    float SignoUp = 1.0F;
    float SignoDn = 1.0F;
    float SignoLf = 1.0F;
    float SignoRg = 1.0F;
    int i;
    for (i = 0; i < 4; i++)
      offset_orientacion[i] = OffsetsTrama[3 + i]; 
    for (i = 0; i < 4; i++)
      offset_elevacion[i] = OffsetsTrama[7 + i]; 
    hex_a_decimal(offset_orientacion, Offset_Orientacion_Decimal);
    hex_a_decimal(offset_elevacion, Offset_Elevacion_Decimal);
    OffsetsDato[0] = Offset_Orientacion_Decimal[0] * SignoLf / 10.0F;
    OffsetsDato[1] = Offset_Orientacion_Decimal[1] * SignoRg / 10.0F;
    OffsetsDato[2] = Offset_Elevacion_Decimal[0] * SignoUp / 10.0F;
    OffsetsDato[3] = Offset_Elevacion_Decimal[1] * SignoDn / 10.0F;
  }
  
  static void hex_a_decimal(short[] hex_in, float[] decimal_out) {
    int comodin = 0;
    int[] Signo = { 1, 1 };
    int i;
    for (i = 0; i < 2; i++) {
      if ((hex_in[i * 2] & 0x80) > 0) {
        hex_in[i * 2 + 1] = (short)(hex_in[i * 2 + 1] - 1);
        hex_in[i * 2] = (short)(hex_in[i * 2] ^ 0xFFFFFFFF);
        hex_in[i * 2] = (short)(hex_in[i * 2] & 0xFF);
        hex_in[i * 2 + 1] = (short)(hex_in[i * 2 + 1] ^ 0xFFFFFFFF);
        hex_in[i * 2 + 1] = (short)(hex_in[i * 2 + 1] & 0xFF);
        Signo[i] = -1;
      } 
    } 
    for (i = 0; i < 2; i++) {
      comodin = hex_in[i * 2];
      decimal_out[i] = ((comodin << 8) + hex_in[i * 2 + 1]);
      decimal_out[i] = decimal_out[i] * Signo[i];
    } 
  }
  
  static void decimal_a_hex(double EntradaEnterosUno, double EntradaEnterosDos, short[] SalidaTrama) {
    short auxil = (short)(int)EntradaEnterosUno;
    SalidaTrama[0] = (short)(auxil >> 8 & 0xFF);
    auxil = (short)(auxil << 8);
    SalidaTrama[1] = (short)(auxil >> 8 & 0xFF);
    auxil = (short)(int)EntradaEnterosDos;
    SalidaTrama[2] = (short)(auxil >> 8 & 0xFF);
    auxil = (short)(auxil << 8);
    SalidaTrama[3] = (short)(auxil >> 8 & 0xFF);
  }
  
  float hex_a_float(short[] tramafloat) {
    float respuesta = 0.0F;
    float decimales = 0.0F;
    int signo = 1;
    int exponente = 0;
    int parteentera = 0;
    int partedecial = 0;
    int desplaza = 0;
    if ((tramafloat[0] & 0x80) > 0)
      signo = -1; 
    exponente = tramafloat[0] << 1;
    exponente += tramafloat[1] & 0x80;
    exponente -= 127;
    desplaza = 23 - exponente;
    tramafloat[1] = (short)(tramafloat[1] | 0x80);
    int i;
    for (i = 0; i < 3; i++)
      parteentera |= tramafloat[i + 1] << (2 - i) * 8; 
    partedecial = parteentera;
    if (exponente >= 0) {
      parteentera >>= desplaza;
      partedecial <<= exponente + 8;
      partedecial &= Integer.MAX_VALUE;
      partedecial >>= exponente + 8;
    } else {
      exponente *= -1;
      parteentera = 0;
      partedecial <<= exponente + 7;
      partedecial &= Integer.MAX_VALUE;
      partedecial >>= exponente - 1;
    } 
    for (i = 0; i < desplaza; i++) {
      int exp = 2;
      for (int j = 0; j < i; j++)
        exp *= 2; 
      if ((partedecial >> desplaza - i + 1 & 0x1) > 0)
        decimales += (1000 / exp); 
    } 
    decimales /= 1000.0F;
    respuesta = (parteentera + decimales) * signo;
    return respuesta;
  }
  
  void float_a_hex(float datofloat, short[] tramasalida) {
    int parteentera = 0;
    int partedecimal = 0;
    int exponente = 0;
    int signo = 1;
    int acumulador = 0;
    int division = 1000;
    int i;
    for (i = 0; i < 4; i++)
      tramasalida[i] = 0; 
    if (datofloat < 0.0F)
      signo = -1; 
    parteentera = (int)datofloat * signo;
    for (i = 0; i < 32; i++) {
      if (parteentera << i + 8 < 0) {
        exponente = 24 - i;
        break;
      } 
    } 
    acumulador = (int)(datofloat * 1000.0F) - parteentera * 1000;
    for (i = 0; i < 8; i++) {
      division /= 2;
      partedecimal <<= 1;
      if (acumulador >= division) {
        acumulador -= division;
        partedecimal |= 0x1;
      } 
    } 
    if (exponente <= 8) {
      tramasalida[1] = (short)(parteentera << 8 - exponente | partedecimal >> exponente);
      tramasalida[2] = (short)(partedecimal << 8 - exponente);
      tramasalida[2] = (short)(tramasalida[2] & 0xFF);
    } else if (exponente > 8 && exponente <= 16) {
      tramasalida[1] = (short)(parteentera >> exponente - 8);
      tramasalida[1] = (short)(tramasalida[1] & 0xFF);
      tramasalida[2] = (short)(parteentera << 16 - exponente | partedecimal >> exponente - 8);
      tramasalida[2] = (short)(tramasalida[2] & 0xFF);
      tramasalida[3] = (short)(partedecimal >> 16 - exponente);
      tramasalida[3] = (short)(tramasalida[3] & 0xFF);
    } else if (exponente > 16 && exponente <= 24) {
      tramasalida[1] = (short)(parteentera >> exponente - 8);
      tramasalida[1] = (short)(tramasalida[1] & 0xFF);
      tramasalida[2] = (short)(parteentera >> exponente - 16);
      tramasalida[2] = (short)(tramasalida[2] & 0xFF);
      tramasalida[3] = (short)(partedecimal << 16 - exponente | partedecimal >> 16 - exponente);
      tramasalida[3] = (short)(tramasalida[3] & 0xFF);
    } 
    exponente += 126;
    tramasalida[0] = (short)(exponente >> 1);
    tramasalida[0] = (short)(tramasalida[0] & 0xFF);
    if (signo == 1) {
      tramasalida[0] = (short)(tramasalida[0] & 0x7F);
    } else {
      tramasalida[0] = (short)(tramasalida[0] | 0x80);
    } 
    if ((exponente & 0x1) == 1) {
      tramasalida[1] = (short)(tramasalida[1] | 0x80);
    } else {
      tramasalida[1] = (short)(tramasalida[1] & 0x7F);
    } 
  }
  
  boolean comp_aprox(short[] Actual, short[] Objetivo, byte error) {
    boolean ok = true;
    float[] PosActDec = new float[2];
    float[] PosObjDec = new float[2];
    hex_a_decimal(Actual, PosActDec);
    hex_a_decimal(Objetivo, PosObjDec);
    float resta_ori = PosActDec[0] - PosObjDec[0];
    if (resta_ori < 0.0F)
      resta_ori *= -1.0F; 
    float resta_elev = PosActDec[1] - PosObjDec[1];
    if (resta_elev < 0.0F)
      resta_elev *= -1.0F; 
    if (resta_ori <= error && resta_elev <= error)
      ok = false; 
    return ok;
  }
  
  boolean comp_aprox() {
    boolean ok = false;
    float error = 10.0F;
    float resta_ori = AzimuthActual - AzimuthObjetivo;
    if (resta_ori < 0.0F)
      resta_ori *= -1.0F; 
    float resta_elev = PitchActual - PitchObjetivo;
    if (resta_elev < 0.0F)
      resta_elev *= -1.0F; 
    if (resta_ori <= error && resta_elev <= error)
      ok = true; 
    return ok;
  }
  
  public static String getIDPuertoCPA() {
    return IDPuertoCPA;
  }
  
  public static void setIDPuertoCPA(String IDPuertoCPA) {
    FuncionesCPA.IDPuertoCPA = IDPuertoCPA;
  }
  
  public boolean isCPA() {
    return this.isCPA;
  }
  
  public void setCPA(boolean CPA) {
    this.isCPA = CPA;
  }
  
  public static FuncionesCPA getSingletonInstance() {
    if (funcionesCPA == null)
      funcionesCPA = new FuncionesCPA(); 
    return funcionesCPA;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Hardware\FuncionesCPA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */