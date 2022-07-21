package co.dynamicts.neli.ui.utils;

public class MeasureExpression {
  public static String DISTANCE_METERS_105 = "^([0-9]|1[0-9]{4}|[1-9][0-9]{0,3}|45000)$";
  
  public static String DISTANCE_METERS_155 = "^([0-9]|1[0-9]{4}|2[0-9]{4}|3[0-9]{4}|4[0-4][0-9]{3}|[1-9][0-9]{0,3}|45000)$";
  
  public static String SPEED = "^((1[0-7][0-9]|[1-9]?[0-9])(\\.[0-9]{1,2})?|180(\\.[0-9]{1,2})?)$";
  
  public static String HEIGHT_KILOMETERS = "^(((1[0-2]|[0-9])((\\.[0-9]{1,2})?))|(13((\\.[0]{1,2})?)))$";
  
  public static String HEIGHT_METERS = "^(1[0-2][0-9]{3}|[1-9][0-9]{1,3}|[0-9]|13000)$";
  
  public static String ANGLE_DEGREES_LONGITUDE = "^((1[0-7][0-9]|[1-9]?[0-9])|180)$";
  
  public static String ANGLE_DEGREES_LATITUDE = "^(([1-8]?[0-9])|90)$";
  
  public static String ANGLE_MINUTES = "^[0-5]?[0-9]$";
  
  public static String ANGLE_SECONDS = "^[0-5]?[0-9]((\\.[0-9]{1,2})?)$";
  
  public static String AZIMUTH = "^(6[0-3][0-9]{2}|[1-5][0-9]{3}|[1-9][0-9]{1,2}|[0-9])((\\.[0-9]{1,2})?)$";
  
  public static String DEGREES_360 = "^(3[0-5][0-9]|[1-2]?[1-9][0-9]|[0-9])\\.[0-9]{2}$";
  
  public static String ELEVATION = "^((-([1-7][0-9]|[0-9])((\\.[0-9]{1,2})?)|-80((\\.[0]{1,2})?))|(1[0-1][0-9]{0,2})((\\.[0-9]{1,2})?)|([1-9][0-9]{1,2})((\\.[0-9]{1,2})?)|([0-9])((\\.[0-9]{1,2})?)|(1200((\\.[0]{1,2})?)))$";
  
  public static String ELEVATION_DEGREES = "^((-[0-3]\\.[0-9]|-4\\.[0-5])|((6[0-6]|[1-5][0-9]|[0-9])\\.[0-9]|67\\.[0-5]))$";
  
  public static String DELTA_EAST = "^(83399[0-1]|8339[0-8][0-9]|833[0-8][0-9]{2}|83[0-2][0-9]{1,4}|8[0-2][0-9]{1,5}|[1-7][0-9]{1,5}|[1-9][0-9]{1,4}|[0-9])$";
  
  public static String DELTA_NORTH = "^(932929[0-1]|93292[0-8][0-9]|9329[0-1][0-9]{2}|932[0-8][0-9]{3}|93[0-1][0-9]{4}|9[0-2][0-9]{5}|[1-9][0-9]{1,6}|[0-9])$";
  
  public static String UTM_USE = "^([1-5][0-9]|[1-9]|60)$";
  
  public static String UTM_ZONE = "^[CDEFGHJKLMNPQRSTUVWX]$";
  
  public static String CORRECTION = "^([1-9][0-9]{0,3}|0$)";
  
  public static String TEMPERATURE = "^((-(1[0-9]|[0-9])((\\.[0-9]{1})?)|-20((\\.0)?))|([1-4][0-9]{1}((\\.[0-9]{1})?))|([0-9]((\\.[0-9]{1})?))|(50((\\.0)?)))$";
  
  public static String NAME_RECORD = "^([A-Z0-9]{6})$";
  
  public static String REPORT_ZONE = "^(0[0-9]{0,4}|1[0-9]{4}|2[0-9]{4}|[1-9][0-9]{0,3}|30000)$";
  
  public static String REPORT_NUMBER = "^([0-9]{2})$";
  
  public static String REPORT_DIR_SPEED = "^([0-9]{3})$";
  
  public static String REPORT_TEMP_PRESS = "^([0-9]{4})$";
  
  public static String HOST = "^192\\.168\\.36\\.(1|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";
  
  public static String AMMO_ADD_NAME = "^[a-zA-Z0-9\\/\\-\\s]+$";
  
  public static String AMMO_ADD_NAME_FUZE = "^([a-zA-Z0-9\\-\\s]+)?$";
  
  public static String AMMO_ADD_LETERS = "^[a-zA-Z]+$";
  
  public static String AMMO_ADD_LETERS_FUZE = "^([a-zA-Z]+)?$";
  
  public static String AMMO_ADD_ZONE = "^([0-7])$";
  
  public static String AMMO_ADD_SQUARE = "^([0-5])$";
  
  public static String AMMO_ADD_TC = "^((1?[0-9])|20)$";
  
  public static String AMMO_ADD_POSITIVE_DOUBLE = "^\\d+(\\.\\d+)?$";
  
  public static String AMMO_ADD_POSITIVE_DOUBLE_FUZE = "^\\s|\\d+(\\.\\d+)?$";
  
  public static String AMMO_ADD_DOUBLE = "^-?\\d+(\\.\\d+)?$";
  
  public static String AMMO_ADD_INT = "^\\d+$";
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\u\\utils\MeasureExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */