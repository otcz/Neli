package co.dynamicts.neli.core.utilities;

public class Distancia {
  private static final double EARTH_RADIUS = 6371010.0D;
  
  public static PuntoGeograficas midPoint(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    double λ1 = Math.toRadians(standPoint.getLongitud());
    double λ2 = Math.toRadians(forePoint.getLongitud());
    double φ1 = Math.toRadians(standPoint.getLatitud());
    double φ2 = Math.toRadians(forePoint.getLatitud());
    double Bx = Math.cos(φ2) * Math.cos(λ2 - λ1);
    double By = Math.cos(φ2) * Math.sin(λ2 - λ1);
    double φ3 = Math.atan2(Math.sin(φ1) + Math.sin(φ2), Math.sqrt((Math.cos(φ1) + Bx) * (Math.cos(φ1) + Bx) + By * By));
    double λ3 = λ1 + Math.atan2(By, Math.cos(φ1) + Bx);
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLatitud(φ3 * 57.2958D, true);
    puntoGeograficas.setLongitud(λ3, true);
    return puntoGeograficas;
  }
  
  public static double gcdDistance(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    double diffLongitudes = Math.toRadians(Math.abs(forePoint.getLongitud() - standPoint.getLongitud()));
    double slat = Math.toRadians(standPoint.getLatitud());
    double flat = Math.toRadians(forePoint.getLatitud());
    double sphereCos = Math.sin(slat) * Math.sin(flat) + Math.cos(slat) * Math.cos(flat) * Math.cos(diffLongitudes);
    double c = Math.acos(Math.max(Math.min(sphereCos, 1.0D), -1.0D));
    return 6371010.0D * c;
  }
  
  public static double harvesineDistance(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    double diffLongitudes = Math.toRadians(Math.abs(forePoint.getLongitud() - standPoint.getLongitud()));
    double slat = Math.toRadians(standPoint.getLatitud());
    double flat = Math.toRadians(forePoint.getLatitud());
    double diffLatitudes = Math.toRadians(Math.abs(forePoint.getLatitud() - standPoint.getLatitud()));
    double a = Math.sin(diffLatitudes / 2.0D) * Math.sin(diffLatitudes / 2.0D) + Math.cos(slat) * Math.cos(flat) * Math.sin(diffLongitudes / 2.0D) * Math.sin(diffLongitudes / 2.0D);
    double c = 2.0D * Math.atan2(Math.sqrt(a), Math.sqrt(1.0D - a));
    return 6371010.0D * c;
  }
  
  private static Vincenty vincenty(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    double λʹ, cosSqα, σ, cos2σM, cosσ, sinσ, sinλ, cosλ, λ1 = Math.toRadians(standPoint.getLongitud());
    double λ2 = Math.toRadians(forePoint.getLongitud());
    double φ1 = Math.toRadians(standPoint.getLatitud());
    double φ2 = Math.toRadians(forePoint.getLatitud());
    double a = 6378137.0D;
    double b = 6356752.314245D;
    double f = 0.0033528106647474805D;
    double L = λ2 - λ1;
    double tanU1 = (1.0D - f) * Math.tan(φ1), cosU1 = 1.0D / Math.sqrt(1.0D + tanU1 * tanU1), sinU1 = tanU1 * cosU1;
    double tanU2 = (1.0D - f) * Math.tan(φ2), cosU2 = 1.0D / Math.sqrt(1.0D + tanU2 * tanU2), sinU2 = tanU2 * cosU2;
    double λ = L, iterationLimit = 100.0D;
    do {
      sinλ = Math.sin(λ);
      cosλ = Math.cos(λ);
      double sinSqσ = cosU2 * sinλ * cosU2 * sinλ + (cosU1 * sinU2 - sinU1 * cosU2 * cosλ) * (cosU1 * sinU2 - sinU1 * cosU2 * cosλ);
      sinσ = Math.sqrt(sinSqσ);
      if (sinσ == 0.0D)
        return new Vincenty(0.0D, 0.0D, 0.0D); 
      cosσ = sinU1 * sinU2 + cosU1 * cosU2 * cosλ;
      σ = Math.atan2(sinσ, cosσ);
      double sinα = cosU1 * cosU2 * sinλ / sinσ;
      cosSqα = 1.0D - sinα * sinα;
      cos2σM = cosσ - 2.0D * sinU1 * sinU2 / cosSqα;
      if (Double.isNaN(cos2σM))
        cos2σM = 0.0D; 
      double C = f / 16.0D * cosSqα * (4.0D + f * (4.0D - 3.0D * cosSqα));
      λʹ = λ;
      λ = L + (1.0D - C) * f * sinα * (σ + C * sinσ * (cos2σM + C * cosσ * (-1.0D + 2.0D * cos2σM * cos2σM)));
    } while (Math.abs(λ - λʹ) > 1.0E-12D && --iterationLimit > 0.0D);
    if (iterationLimit == 0.0D)
      throw new IllegalStateException("Formula failed to converge"); 
    double uSq = cosSqα * (a * a - b * b) / b * b;
    double A = 1.0D + uSq / 16384.0D * (4096.0D + uSq * (-768.0D + uSq * (320.0D - 175.0D * uSq)));
    double B = uSq / 1024.0D * (256.0D + uSq * (-128.0D + uSq * (74.0D - 47.0D * uSq)));
    double Δσ = B * sinσ * (cos2σM + B / 4.0D * (cosσ * (-1.0D + 2.0D * cos2σM * cos2σM) - B / 6.0D * cos2σM * (-3.0D + 4.0D * sinσ * sinσ) * (-3.0D + 4.0D * cos2σM * cos2σM)));
    double distance = b * A * (σ - Δσ);
    double initialBearing = Math.atan2(cosU2 * sinλ, cosU1 * sinU2 - sinU1 * cosU2 * cosλ);
    initialBearing = (initialBearing + 6.283185307179586D) % 6.283185307179586D;
    double finalBearing = Math.atan2(cosU1 * sinλ, -sinU1 * cosU2 + cosU1 * sinU2 * cosλ);
    finalBearing = (finalBearing + 6.283185307179586D) % 6.283185307179586D;
    return new Vincenty(distance, Math.toDegrees(initialBearing), Math.toDegrees(finalBearing));
  }
  
  public static double vincentyDistance(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    return (vincenty(standPoint, forePoint)).distance;
  }
  
  public static double vincentyBearing(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    return (vincenty(standPoint, forePoint)).initialBearing;
  }
  
  public static double vincentyFinalBearing(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    return (vincenty(standPoint, forePoint)).finalBearing;
  }
  
  public static PuntoGeograficas pointAt(PuntoGeograficas standPoint, double bearing, double distance) {
    bearing /= 17.7777777778D;
    double φ1 = Math.toRadians(standPoint.getLatitud());
    double λ1 = Math.toRadians(standPoint.getLongitud());
    double θ = Math.toRadians(bearing);
    double δ = distance / 6371010.0D;
    double φ2 = Math.asin(Math.sin(φ1) * Math.cos(δ) + Math.cos(φ1) * Math.sin(δ) * Math.cos(θ));
    double λ2 = λ1 + Math.atan2(Math.sin(θ) * Math.sin(δ) * Math.cos(φ1), Math.cos(δ) - Math.sin(φ1) * Math.sin(φ2));
    double λ2_harmonised = (λ2 + 9.42477796076938D) % 6.283185307179586D - Math.PI;
    PuntoGeograficas puntoGeograficas = new PuntoGeograficas();
    puntoGeograficas.setLongitud(λ2_harmonised * 57.2958D, true);
    puntoGeograficas.setLatitud(φ2 * 57.2958D, true);
    return puntoGeograficas;
  }
  
  public static double bearing(PuntoGeograficas standPoint, PuntoGeograficas forePoint) {
    double Δlong = Math.toRadians(forePoint.getLongitud() - standPoint.getLongitud());
    double y = Math.sin(Δlong) * Math.cos(Math.toRadians(forePoint.getLatitud()));
    double x = Math.cos(Math.toRadians(standPoint.getLatitud())) * Math.sin(Math.toRadians(forePoint.getLatitud())) - Math.sin(Math.toRadians(standPoint.getLatitud())) * Math.cos(Math.toRadians(forePoint.getLatitud())) * Math.cos(Δlong);
    double bearing = (Math.atan2(y, x) + 6.283185307179586D) % 6.283185307179586D;
    return Math.toDegrees(bearing * 17.7777777778D);
  }
  
  private static class Vincenty {
    final double distance;
    
    final double initialBearing;
    
    final double finalBearing;
    
    Vincenty(double distance, double initialBearing, double finalBearing) {
      this.distance = distance;
      this.initialBearing = initialBearing;
      this.finalBearing = finalBearing;
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\Distancia.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */