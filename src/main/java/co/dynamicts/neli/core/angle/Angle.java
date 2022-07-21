package co.dynamicts.neli.core.angle;

public final class Angle {
  public static final Double MILLIS = Double.valueOf(6400.0D);
  
  public static final Double MILLIS_PER_DEGREE = Double.valueOf(MILLIS.doubleValue() / 360.0D);
  
  private final Double millis;
  
  private final Double degrees;
  
  private Angle(Double millis, Double degrees) {
    this.millis = millis;
    this.degrees = degrees;
  }
  
  public Double getMillis() {
    return this.millis;
  }
  
  public Double getDegrees() {
    return this.degrees;
  }
  
  public static Angle ofMillis(Double millis) {
    return new Angle(millis, Double.valueOf(millis.doubleValue() / MILLIS_PER_DEGREE.doubleValue()));
  }
  
  public static Angle ofDegrees(Double degrees) {
    return new Angle(Double.valueOf(degrees.doubleValue() * MILLIS_PER_DEGREE.doubleValue()), degrees);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\angle\Angle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */