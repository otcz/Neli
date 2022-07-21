package co.dynamicts.neli.core.utilities;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
  public double interpola(double[] x, double[] y, double valor) {
    double m = 0.0D;
    double yo = 0.0D;
    double resultado = 0.0D;
    for (int i = 0; i < x.length - 1; i++) {
      if (x[i] >= valor && valor <= x[i + 1]) {
        m = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
        yo = y[i];
        return resultado = yo + m * (valor - x[i]);
      } 
    } 
    return resultado;
  }
  
  public static double restringeValores(double valor, double valorMaximo, double valorMinimo) {
    if (valor > valorMaximo) {
      valor -= valorMaximo;
    } else if (valor < valorMinimo) {
      valor += valorMaximo;
    } 
    return valor;
  }
  
  public double convierteGrados_a_Milesimas(double valorGrados) {
    valorGrados = valorGrados * 6400.0D / 360.0D;
    return valorGrados;
  }
  
  public double convierteMetros_a_Km(double valorMetros) {
    return valorMetros / 1000.0D;
  }
  
  public double convierteKm_a_Metros(double valorKm) {
    return valorKm * 1000.0D;
  }
  
  public double convierteMilesimas_a_Grados(double valorMilesimas) {
    valorMilesimas = valorMilesimas * 360.0D / 6400.0D;
    return valorMilesimas;
  }
  
  public double potencia(double numero, int exponente) {
    return Math.pow(numero, exponente);
  }
  
  public boolean isRank(double valor, double valorMaximo, double valorMinimo) {
    if (valor >= valorMinimo && valor <= valorMaximo)
      return true; 
    return false;
  }
  
  public double calculaAnguloCatetosMilesimas(double catetoOpuesto, double catetoAdyacente) {
    return convierteGrados_a_Milesimas(Math.toDegrees(Math.atan(catetoOpuesto / catetoAdyacente)));
  }
  
  public Posicion convertirPosicionMetros_a_Km(Posicion posicionMetros) {
    Posicion posicionKm = new Posicion();
    posicionKm.setDistancia(convierteMetros_a_Km(posicionMetros.getDistancia()));
    posicionKm.setIntervalo(convierteMetros_a_Km(posicionMetros.getIntervalo()));
    return posicionKm;
  }
  
  public Actitud convertirActitudMilesimas_a_Grados(Actitud actitudMils) {
    Actitud actitudGrados = new Actitud();
    actitudGrados.setAzimut(convierteMilesimas_a_Grados(actitudMils.getAzimut()));
    actitudGrados.setAlabeo(convierteMilesimas_a_Grados(actitudMils.getAlabeo()));
    actitudGrados.setElevacion(convierteMilesimas_a_Grados(actitudMils.getElevacion()));
    return actitudGrados;
  }
  
  public boolean sonValoresIguales(double valor1, double valor2) {
    if (valor1 == valor2)
      return true; 
    return false;
  }
  
  public double difCirculoAZ1_AZ2(double azimut1, double azimut2) {
    double diferencia = 0.0D;
    if (azimut1 > 4800.0D && azimut2 < 1600.0D) {
      diferencia = azimut1 - azimut2 + 6400.0D;
    } else if (azimut2 > 4800.0D && azimut1 < 1600.0D) {
      diferencia = azimut1 + 6400.0D - azimut2;
    } else {
      diferencia = azimut1 - azimut2;
    } 
    return diferencia;
  }
  
  public double limitaDecimales(double valor) {
    return Math.round(valor * 100.0D) / 100.0D;
  }
  
  public static String getAppDataFile() {
    String OS = System.getProperty("os.name").toUpperCase();
    if (OS.contains("WIN"))
      return System.getenv("AppData") + "\\co.dynamicts.Main\\Datos\\"; 
    return System.getProperty("user.home") + "/.dynamicts.co/Datos/";
  }
  
  public static String getSQLiteSDN(String name) {
    getUserFolder();
    return "jdbc:sqlite:" + getUserFolder() + name;
  }
  
  public static String getUserFolder() {
    String folder, OS = System.getProperty("os.name").toUpperCase();
    if (OS.contains("WIN")) {
      folder = System.getenv("AppData") + "\\Sky\\";
    } else {
      folder = System.getProperty("user.home") + "/.Sky/";
    } 
    return createFile(folder);
  }
  
  public static String getFolderRadar() {
    String OS = System.getProperty("os.name").toUpperCase();
    String radarFolder = getUserFolder();
    if (OS.contains("WIN")) {
      radarFolder = radarFolder + "Sky.Images\\";
    } else {
      radarFolder = radarFolder + "Sky.Images/";
    } 
    return createFile(radarFolder);
  }
  
  public static String createFile(String folder) {
    File file = new File(folder);
    if (!file.exists()) {
      file.mkdirs();
      File parent = file.getParentFile();
      if (!parent.exists() && !parent.mkdirs())
        throw new IllegalStateException("Couldn't create dir: " + parent); 
    } 
    return folder;
  }
  
  public static String verificaEmpty(String valor) {
    if (valor.isEmpty())
      return "0"; 
    return valor;
  }
  
  public static void capterImg(String name) throws Exception {
    Robot robot = new Robot();
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension dimensions = t.getScreenSize();
    Rectangle re = new Rectangle(dimensions.width, dimensions.height);
    BufferedImage screenCapture = robot.createScreenCapture(re);
    BufferedImage bufferedImage = screenCapture;
    WritableImage writableImage = SwingFXUtils.toFXImage(bufferedImage, null);
    ImageIO.write(bufferedImage, "png", new File(getFolderRadar() + name + ".png"));
  }
  
  public static String radarImageName() {
    Date objDate = new Date();
    String strDateFormat = "dd-MMM-yyyy";
    String strTimeFormat = "HH-mm-ss";
    SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
    SimpleDateFormat objSTF = new SimpleDateFormat(strTimeFormat);
    return objSDF.format(objDate) + " " + objSTF.format(objDate);
  }
  
  public static void deleteDir(File file) {
    File[] contents = file.listFiles();
    if (contents != null)
      for (File f : contents)
        deleteDir(f);  
    file.delete();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\Tools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */