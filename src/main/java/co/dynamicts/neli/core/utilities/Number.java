package co.dynamicts.neli.core.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Number {
  public static <T extends Comparable<? super T>> T limit(T o, T min, T max) {
    if (o.compareTo(min) < 0)
      return min; 
    if (o.compareTo(max) > 0)
      return max; 
    return o;
  }
  
  public static double round(double value, int places) {
    if (places < 0)
      throw new IllegalArgumentException(); 
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\Number.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */