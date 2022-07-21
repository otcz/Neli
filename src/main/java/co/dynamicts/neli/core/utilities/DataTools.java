package co.dynamicts.neli.core.utilities;

import co.dynamicts.neli.core.interfaces.Configuracion;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.Arrays;

public class DataTools {
  public static double limitaDecimales(double valor) {
    return Math.round(valor * 100.0D) / 100.0D;
  }
  
  public static String toStringName(String name) {
    String auxtex = String.valueOf(name);
    if (auxtex.length() == 1) {
      auxtex = "000" + auxtex;
    } else if (auxtex.length() == 2) {
      auxtex = "00" + auxtex;
    } else if (auxtex.length() == 3) {
      auxtex = "0" + auxtex;
    } 
    return auxtex;
  }
  
  public static String toStringPoint(PuntoGeograficas punto, Configuracion.UnidadCoordenadas tipo) {
    if (Configuracion.UnidadCoordenadas.GEOGRAFICAS.equals(tipo))
      return punto.getSignoLatitud() + " " + (int)Math.abs(punto.getLatGrados()) + "° " + (int)Math.abs(punto.getLatMinutos()) + "’ " + 
        Math.abs(limitaDecimales(punto.getLatSegundos())) + "” " + punto.getSignoLongitud() + " " + (int)Math.abs(punto.getLonGrados()) + "° " + 
        (int)Math.abs(punto.getLonMinutos()) + "’ " + Math.abs(limitaDecimales(punto.getLonSegundos())) + "” " + 
        (int)punto.getAltura(); 
    ConversorCoordenadas conversorPunto = new ConversorCoordenadas();
    PuntoUTM puntoconvertido = ConversorCoordenadas.convertirGeo_a_UTM(punto, "WGS84");
    return "DE " + (int)puntoconvertido.getDeltaEste() + " DN " + (int)puntoconvertido.getDeltaNorte() + " " + puntoconvertido.getHuso() + " " + puntoconvertido
      .getBanda() + " " + (int)punto.getAltura();
  }
  
  public static double convierteGrados_a_Milesimas(double valorGrados) {
    return valorGrados * 6400.0D / 360.0D;
  }
  
  public static double convierteMetros_a_Km(double valorMetros) {
    return valorMetros / 1000.0D;
  }
  
  public static double convierteKm_a_Metros(double valorKm) {
    return valorKm * 1000.0D;
  }
  
  public static double convierteMilesimas_a_Grados(double valorMilesimas) {
    return valorMilesimas * 360.0D / 6400.0D;
  }
  
  public static String toCoordinatePoint(PuntoGeograficas punto, Configuracion.UnidadCoordenadas tipo) {
    if (Configuracion.UnidadCoordenadas.GEOGRAFICAS.equals(tipo))
      return punto.getSignoLongitud() + " " + (int)Math.abs(punto.getLonGrados()) + " " + (int)Math.abs(punto.getLonMinutos()) + " " + 
        Math.abs(limitaDecimales(punto.getLonSegundos())) + " " + punto.getSignoLatitud() + " " + (int)Math.abs(punto.getLatGrados()) + " " + 
        (int)Math.abs(punto.getLatMinutos()) + " " + Math.abs(limitaDecimales(punto.getLatSegundos())) + " " + (int)punto.getAltura(); 
    ConversorCoordenadas conversorPunto = new ConversorCoordenadas();
    PuntoUTM puntoconvertido = ConversorCoordenadas.convertirGeo_a_UTM(punto, "WGS84");
    return (int)puntoconvertido.getDeltaEste() + " " + (int)puntoconvertido.getDeltaNorte() + " " + puntoconvertido.getHuso() + " " + puntoconvertido
      .getBanda() + " " + (int)punto.getAltura();
  }
  
  public static String reverseSplit(String[] gArreglo, String delimiter) {
    return Arrays.toString((Object[])gArreglo).replace(", ", delimiter).replaceAll("[\\[\\]]", "");
  }
  
  public static void toTFArrayString(String cadena, TextField[] arrayTexto) {
    String[] arrayString = cadena.split(",");
    for (int i = 0; i < arrayTexto.length; i++)
      arrayTexto[i].setText(String.valueOf(arrayString[i])); 
  }
  
  public static String toStringTFArray(TextField[] arrayTf) {
    String[] arregloSalida = new String[arrayTf.length];
    for (int i = 0; i < arrayTf.length; i++)
      arregloSalida[i] = arrayTf[i].getText(); 
    return reverseSplit(arregloSalida, ",");
  }
  
  public static double[] toDoubleString(String cadena) {
    String[] arrayString = cadena.split(",");
    double[] arregloSalida = new double[arrayString.length];
    for (int i = 0; i < arrayString.length; i++)
      arregloSalida[i] = Double.parseDouble(arrayString[i]); 
    return arregloSalida;
  }
  
  public static String toStringDouble(double[] arrayDouble) {
    String[] arregloSalida = new String[arrayDouble.length];
    for (int i = 0; i < arrayDouble.length; i++)
      arregloSalida[i] = BigDecimal.valueOf(arrayDouble[i]).toPlainString(); 
    return reverseSplit(arregloSalida, ",");
  }
  
  public static int[] toIntString(String cadena) {
    String[] arrayString = cadena.split(",");
    int[] arregloSalida = new int[arrayString.length];
    for (int i = 0; i < arrayString.length; i++)
      arregloSalida[i] = Integer.parseInt(arrayString[i]); 
    return arregloSalida;
  }
  
  public static String toStringInt(int[] arrayInt) {
    String[] arregloSalida = new String[arrayInt.length];
    for (int i = 0; i < arrayInt.length; i++)
      arregloSalida[i] = String.valueOf(arrayInt[i]); 
    return reverseSplit(arregloSalida, ",");
  }
  
  public static String toVelPromVel(double[] arrayDouble) {
    String[] arregloSalida = new String[arrayDouble.length];
    String[] arregloAux = new String[10];
    for (int i = 0; i < arrayDouble.length; i++) {
      for (int j = 0; j < 10; j++)
        arregloAux[j] = String.valueOf(arrayDouble[i]); 
      arregloSalida[i] = reverseSplit(arregloAux, ",");
    } 
    return reverseSplit(arregloSalida, ";");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\DataTools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */