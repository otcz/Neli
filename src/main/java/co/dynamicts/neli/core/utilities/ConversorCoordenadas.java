package co.dynamicts.neli.core.utilities;

public class ConversorCoordenadas {
  public static PuntoUTM convertirGeo_a_UTM(PuntoGeograficas punto, String datum) {
    double a = getSemiejeMayor(datum);
    double b = getSemiejeMenor(datum);
    double e = Math.sqrt(Math.pow(a, 2.0D) - Math.pow(b, 2.0D)) / a;
    double e1 = Math.sqrt(Math.pow(a, 2.0D) - Math.pow(b, 2.0D)) / b;
    double e2 = Math.pow(e1, 2.0D);
    double c = Math.pow(a, 2.0D) / b;
    double lon = punto.getLongitud();
    double lat = punto.getLatitud();
    double lonRadianes = Math.toRadians(lon);
    double latRadianes = Math.toRadians(lat);
    double huso = Math.floor(lon / 6.0D + 31.0D);
    double MeridianoCentral = Math.toRadians(huso * 6.0D - 183.0D);
    double DistanciaAngular = lonRadianes - MeridianoCentral;
    double A = Math.cos(latRadianes) * Math.sin(DistanciaAngular);
    double Xi = 0.5D * Math.log((1.0D + A) / (1.0D - A));
    double Eta = Math.atan(Math.tan(latRadianes) / Math.cos(DistanciaAngular)) - latRadianes;
    double Ni = c / Math.sqrt(1.0D + e2 * Math.pow(Math.cos(latRadianes), 2.0D)) * 0.9996D;
    double zeta = e2 / 2.0D * Math.pow(Xi, 2.0D) * Math.pow(Math.cos(latRadianes), 2.0D);
    double A1 = Math.sin(2.0D * latRadianes);
    double A2 = A1 * Math.pow(Math.cos(latRadianes), 2.0D);
    double J2 = latRadianes + A1 / 2.0D;
    double J4 = (3.0D * J2 + A2) / 4.0D;
    double J6 = (5.0D * J4 + A2 * Math.pow(Math.cos(latRadianes), 2.0D)) / 3.0D;
    double alfa = 0.75D * e2;
    double beta = 1.6666666666666667D * Math.pow(alfa, 2.0D);
    double gamma = 1.2962962962962963D * Math.pow(alfa, 3.0D);
    double Bfi = 0.9996D * c * (latRadianes - alfa * J2 + beta * J4 - gamma * J6);
    double X = Xi * Ni * (1.0D + zeta / 3.0D) + 500000.0D;
    double Y = 0.0D;
    if (lat < 0.0D) {
      Y = Eta * Ni * (1.0D + zeta) + Bfi + 1.0E7D;
    } else {
      Y = Eta * Ni * (1.0D + zeta) + Bfi;
    } 
    PuntoUTM puntoUTM_Resultado = new PuntoUTM();
    puntoUTM_Resultado.setDeltaEste(X);
    puntoUTM_Resultado.setDeltaNorte(Y);
    puntoUTM_Resultado.setHuso(huso);
    puntoUTM_Resultado.setBanda(getBanda(punto));
    puntoUTM_Resultado.setAltura(punto.getAltura());
    return puntoUTM_Resultado;
  }
  
  private static double getSemiejeMayor(String datum) {
    double semiejeMayor = 0.0D;
    if (datum.equals("Airy 1830")) {
      semiejeMayor = 6377563.396D;
    } else if (datum.equals("Airy Modificado 1965")) {
      semiejeMayor = 6377340.189D;
    } else if (datum == "Bessel 1841") {
      semiejeMayor = 6377397.155D;
    } else if (datum == "Clarke 1866") {
      semiejeMayor = 6378206.4D;
    } else if (datum == "Clarke 1880") {
      semiejeMayor = 6378249.145D;
    } else if (datum == "Fischer 1960") {
      semiejeMayor = 6378166.0D;
    } else if (datum == "Fischer 1968") {
      semiejeMayor = 6378150.0D;
    } else if (datum == "GRS80 (Magna)") {
      semiejeMayor = 6378137.0D;
    } else if (datum == "Hayford 1909") {
      semiejeMayor = 6378388.0D;
    } else if (datum == "Helmert 1906") {
      semiejeMayor = 6378200.0D;
    } else if (datum == "Hough 1960") {
      semiejeMayor = 6378270.0D;
    } else if (datum == "Internacional 1909") {
      semiejeMayor = 6378388.0D;
    } else if (datum == "Internacional 1924") {
      semiejeMayor = 6378388.0D;
    } else if (datum == "Krasovsky 1940") {
      semiejeMayor = 6378245.0D;
    } else if (datum == "Mercury 1960") {
      semiejeMayor = 6378166.0D;
    } else if (datum == "Mercury Modificado 1968") {
      semiejeMayor = 6378150.0D;
    } else if (datum == "Nuevo International 1967") {
      semiejeMayor = 6378157.5D;
    } else if (datum == "Sudamericano 1969") {
      semiejeMayor = 6378160.0D;
    } else if (datum == "Walbeck 1817") {
      semiejeMayor = 6376896.0D;
    } else if (datum == "WGS66") {
      semiejeMayor = 6378145.0D;
    } else if (datum == "WGS72") {
      semiejeMayor = 6378135.0D;
    } else if (datum == "WGS84") {
      semiejeMayor = 6378137.0D;
    } 
    return semiejeMayor;
  }
  
  public static double getSemiejeMenor(String datum) {
    double semiejeMenor = 0.0D;
    if (datum == "Airy 1830") {
      semiejeMenor = 6356256.91D;
    } else if (datum == "Airy Modificado 1965") {
      semiejeMenor = 6356034.4479D;
    } else if (datum == "Bessel 1841") {
      semiejeMenor = 6356078.96284D;
    } else if (datum == "Clarke 1866") {
      semiejeMenor = 6356583.8D;
    } else if (datum == "Clarke 1880") {
      semiejeMenor = 6356514.86955D;
    } else if (datum == "Fischer 1960") {
      semiejeMenor = 6356784.28D;
    } else if (datum == "Fischer 1968") {
      semiejeMenor = 6356768.33D;
    } else if (datum == "GRS80 (Magna)") {
      semiejeMenor = 6356752.31414D;
    } else if (datum == "Hayford 1909") {
      semiejeMenor = 6356911.94613D;
    } else if (datum == "Helmert 1906") {
      semiejeMenor = 6356818.17D;
    } else if (datum == "Hough 1960") {
      semiejeMenor = 6356794.343479D;
    } else if (datum == "Internacional 1909") {
      semiejeMenor = 6356911.94613D;
    } else if (datum == "Internacional 1924") {
      semiejeMenor = 6356911.94613D;
    } else if (datum == "Krasovsky 1940") {
      semiejeMenor = 6356863.0188D;
    } else if (datum == "Mercury 1960") {
      semiejeMenor = 6356784.283666D;
    } else if (datum == "Mercury Modificado 1968") {
      semiejeMenor = 6356768.337303D;
    } else if (datum == "Nuevo International 1967") {
      semiejeMenor = 6356772.2D;
    } else if (datum == "Sudamericano 1969") {
      semiejeMenor = 6356774.72D;
    } else if (datum == "Walbeck 1817") {
      semiejeMenor = 6355834.8467D;
    } else if (datum == "WGS66") {
      semiejeMenor = 6356759.769356D;
    } else if (datum == "WGS72") {
      semiejeMenor = 6356750.519915D;
    } else if (datum == "WGS84") {
      semiejeMenor = 6356752.31424518D;
    } 
    return semiejeMenor;
  }
  
  public static String getBanda(PuntoGeograficas punto) {
    double latitud = punto.getLatitud();
    String banda = null;
    if (latitud >= 0.0D) {
      if (latitud > 0.0D && latitud <= 8.0D) {
        banda = "N";
      } else if (latitud > 8.0D && latitud <= 16.0D) {
        banda = "P";
      } else if (latitud > 16.0D && latitud <= 24.0D) {
        banda = "Q";
      } else if (latitud > 24.0D && latitud <= 32.0D) {
        banda = "R";
      } else if (latitud > 32.0D && latitud <= 40.0D) {
        banda = "S";
      } else if (latitud > 48.0D && latitud <= 56.0D) {
        banda = "T";
      } else if (latitud > 64.0D && latitud <= 72.0D) {
        banda = "U";
      } else if (latitud > 80.0D && latitud <= 88.0D) {
        banda = "V";
      } else if (latitud > 96.0D && latitud <= 104.0D) {
        banda = "W";
      } else if (latitud > 112.0D && latitud <= 120.0D) {
        banda = "X";
      } 
    } else if (latitud < 0.0D) {
      if (latitud < 0.0D && latitud >= -8.0D) {
        banda = "M";
      } else if (latitud < -8.0D && latitud >= -16.0D) {
        banda = "L";
      } else if (latitud < -16.0D && latitud >= -24.0D) {
        banda = "K";
      } else if (latitud < -24.0D && latitud >= -32.0D) {
        banda = "J";
      } else if (latitud < -32.0D && latitud >= -40.0D) {
        banda = "H";
      } else if (latitud < -48.0D && latitud >= -56.0D) {
        banda = "G";
      } else if (latitud < -64.0D && latitud >= -72.0D) {
        banda = "F";
      } else if (latitud < -80.0D && latitud >= -88.0D) {
        banda = "E";
      } else if (latitud < -96.0D && latitud >= -104.0D) {
        banda = "D";
      } else if (latitud < -112.0D && latitud >= -120.0D) {
        banda = "C";
      } 
    } 
    return banda;
  }
  
  public static PuntoGeograficas convertirUTM_a_Geo(PuntoUTM punto, String datum) {
    double EsteX = punto.getDeltaEste();
    double NorteY = punto.getDeltaNorte();
    double a = getSemiejeMayor(datum);
    double b = getSemiejeMenor(datum);
    double e = Math.sqrt(Math.pow(a, 2.0D) - Math.pow(b, 2.0D)) / a;
    double e1 = Math.sqrt(Math.pow(a, 2.0D) - Math.pow(b, 2.0D)) / b;
    double e2 = Math.pow(e1, 2.0D);
    double c = Math.pow(a, 2.0D) / b;
    String hemisferio = getHemisferio(punto.getBanda());
    double Yalsur = NorteY;
    if (hemisferio == "N") {
      Yalsur = NorteY;
    } else if (hemisferio == "S") {
      Yalsur = NorteY - 1.0E7D;
    } 
    double huso = punto.getHuso();
    double meridianoCentral = 6.0D * huso - 183.0D;
    double Fi = Yalsur / 6363651.2449104D;
    double Ni = c / Math.sqrt(1.0D + e2 * Math.pow(Math.cos(Fi), 2.0D)) * 0.9996D;
    double ai = (EsteX - 500000.0D) / Ni;
    double A1 = Math.sin(2.0D * Fi);
    double A2 = A1 * Math.pow(Math.cos(Fi), 2.0D);
    double J2 = Fi + A1 / 2.0D;
    double J4 = (3.0D * J2 + A2) / 4.0D;
    double J6 = (5.0D * J4 + A2 * Math.pow(Math.cos(Fi), 2.0D)) / 3.0D;
    double alfa = 0.75D * e2;
    double beta = 1.6666666666666667D * Math.pow(alfa, 2.0D);
    double gamma = 1.2962962962962963D * Math.pow(alfa, 3.0D);
    double Bfi = 0.9996D * c * (Fi - alfa * J2 + beta * J4 - gamma * J6);
    double bi = (Yalsur - Bfi) / Ni;
    double zeta = Math.pow(e2 * Math.pow(ai, 2.0D) / 2.0D * Math.cos(Fi), 2.0D);
    double Xi = ai * (1.0D - zeta / 3.0D);
    double Eta = bi * (1.0D - zeta) + Fi;
    double senhXi = (Math.exp(Xi) - Math.exp(-Xi)) / 2.0D;
    double deltaLambda = Math.atan(senhXi / Math.cos(Eta));
    double tau = Math.atan(Math.cos(deltaLambda) * Math.tan(Eta));
    double firad = Fi + (1.0D + e2 * Math.pow(Math.cos(Fi), 2.0D) - 1.0D * e2 * Math.sin(Fi) * Math.cos(Fi) * (tau - Fi)) * (tau - Fi);
    double Longitud = Math.toDegrees(deltaLambda) + meridianoCentral;
    double Latitud = Math.toDegrees(firad);
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLatitud(Latitud, true);
    puntoGeograficas.setLongitud(Longitud, true);
    puntoGeograficas.setAltura(punto.getAltura());
    return puntoGeograficas;
  }
  
  public static String getHemisferio(String banda) {
    String hemisferio = "N";
    if (banda == "C" || banda == "D" || banda == "E" || banda == "F" || banda == "G" || banda == "H" || banda == "J" || banda == "K" || banda == "L" || banda == "M") {
      hemisferio = "S";
    } else if (banda == "N" || banda == "P" || banda == "Q" || banda == "R" || banda == "S" || banda == "T" || banda == "U" || banda == "V" || banda == "W" || banda == "X") {
      hemisferio = "N";
    } 
    return hemisferio;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\ConversorCoordenadas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */