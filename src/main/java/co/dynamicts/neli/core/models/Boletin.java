package co.dynamicts.neli.core.models;

import co.dynamicts.neli.core.local.model.Weather;
import co.dynamicts.neli.core.local.service.WeatherService;
import co.dynamicts.neli.ui.utils.AppConfig;

import java.sql.SQLException;
import java.util.ArrayList;

public class Boletin {
  private static Boletin boletin;
  
  private int area;
  
  private boolean verano = true;
  
  ArrayList<Double> z = new ArrayList<>();
  
  ArrayList<Double> t = new ArrayList<>();
  
  ArrayList<Double> p = new ArrayList<>();
  
  ArrayList<Double> r = new ArrayList<>();
  
  ArrayList<Double> wZ = new ArrayList<>();
  
  ArrayList<Double> wV = new ArrayList<>();
  
  private double rhoBoletin;
  
  private double tempBoletin;
  
  private double pressureBoletin;
  
  double velWindBoletin;
  
  double azWindBoletin;
  
  private double rhoGeneric;
  
  private double tempGeneric;
  
  private double pressureGeneric;
  
  double velWindGeneric;
  
  double azWindGeneric;
  
  ArrayList<Weather> weathers = new ArrayList<>();
  
  public Boletin() {
    setBoletin();
    this.area = 2;
  }
  
  public void setBoletin() {
    try {
      this.z.clear();
      this.t.clear();
      this.r.clear();
      this.p.clear();
      this.wV.clear();
      this.wZ.clear();
      WeatherService weatherService = new WeatherService();
      weatherService.createTableIfNotExists(Weather.class);
      this.weathers = (ArrayList<Weather>)weatherService.getList(Weather.class);
      if (this.weathers.isEmpty()) {
        int[] zone = { 
            0, 200, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 
            4500, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 
            14000, 15000, 16000, 17000, 18000, 19000, 20000, 21000, 22000, 23000, 
            24000, 25000 };
        int[] direction = { 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0 };
        int[] speed = { 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0 };
        double[] temp = { 
            2882.0D, 2868.0D, 2849.0D, 2816.0D, 2784.0D, 2751.0D, 2719.0D, 2686.0D, 2654.0D, 2621.0D, 
            2589.0D, 2556.0D, 2491.0D, 2426.0D, 2361.0D, 2296.0D, 2231.0D, 2166.0D, 2166.0D, 2166.0D, 
            2166.0D, 2166.0D, 2166.0D, 2166.0D, 2166.0D, 2166.0D, 2166.0D, 2166.0D, 216.0D, 2166.0D, 
            2231.0D, 2235.0D };
        int[] press = { 
            1013, 989, 954, 897, 842, 790, 740, 691, 645, 601, 
            559, 519, 444, 378, 318, 265, 219, 178, 152, 130, 
            111, 95, 81, 69, 59, 50, 43, 36, 31, 26, 
            22, 22 };
        for (int j = 0; j < zone.length; j++) {
          Weather weatherLine = new Weather();
          weatherLine.setZone(String.valueOf(zone[j]));
          weatherLine.setLineNumber(String.valueOf(j));
          weatherLine.setWindDirection(String.valueOf(direction[j]));
          weatherLine.setWindSpeed(String.valueOf(speed[j]));
          weatherLine.setTemperature(String.valueOf(temp[j]));
          weatherLine.setPressure(String.valueOf(press[j]));
          weatherService.createOrUpdate(weatherLine);
        } 
        this.weathers = (ArrayList<Weather>)weatherService.getList(Weather.class);
      } 
      int tamanioBoletin = weatherService.getList(Weather.class).size();
      for (int i = 0; i < tamanioBoletin - 1; i++) {
        try {
          AppConfig.getInstance().setWeatherLine((Weather)weatherService.getById(Weather.class, Integer.valueOf(i)));
          double alturaBoletin = AppConfig.getInstance().getWeatherLine().getZone();
          double pressure = AppConfig.getInstance().getWeatherLine().getPressure();
          double temp = AppConfig.getInstance().getWeatherLine().getTemperature();
          double azWind = AppConfig.getInstance().getWeatherLine().getWindDirection();
          double velWind = AppConfig.getInstance().getWeatherLine().getWindSpeed();
          this.z.add(i, Double.valueOf(alturaBoletin));
          this.wV.add(i, Double.valueOf(velWind));
          this.wZ.add(i, Double.valueOf(azWind));
          this.t.add(i, Double.valueOf(temp));
          this.p.add(i, Double.valueOf(pressure));
          this.r.add(i, Double.valueOf(getRho(((Double)this.p.get(i)).doubleValue(), ((Double)this.t.get(i)).doubleValue(), 1.0D)));
        } catch (Exception e) {
          System.out.println("Error en configuracion boletin");
          e.printStackTrace();
        } 
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public void setBoletinGenerico() {
    double[] zT = { 
        0.0D, 200.0D, 500.0D, 1000.0D, 1500.0D, 2000.0D, 2500.0D, 3000.0D, 3500.0D, 4000.0D, 
        4500.0D, 5000.0D, 6000.0D, 7000.0D, 8000.0D, 9000.0D, 10000.0D, 11000.0D, 12000.0D, 13000.0D, 
        14000.0D, 15000.0D, 16000.0D, 17000.0D, 18000.0D, 19000.0D, 20000.0D, 21000.0D, 22000.0D, 23000.0D, 
        24000.0D, 25000.0D, 26000.0D, 27000.0D, 28000.0D, 29000.0D, 30000.0D };
    double[] tT = { 
        288.15D, 286.85D, 284.9D, 281.65D, 278.4D, 275.15D, 271.9D, 268.65D, 265.4D, 262.15D, 
        258.9D, 255.65D, 249.15D, 242.65D, 236.15D, 229.65D, 223.15D, 216.65D, 216.65D, 216.65D, 
        216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 216.65D, 
        216.65D, 223.15D, 223.15D, 223.15D, 223.15D, 223.15D, 223.15D };
    double[] rT = { 
        1.22537867709369D, 1.2017D, 1.1673D, 1.11117D, 1.0581D, 1.0065D, 0.9568D, 0.90913D, 0.86324D, 0.81914D, 
        0.77678D, 0.73612D, 0.6597D, 0.5895D, 0.52517D, 0.46635D, 0.41271D, 0.36392D, 0.31083D, 0.26548D, 
        0.22675D, 0.19367D, 0.16542D, 0.14129D, 0.12058D, 0.10307D, 0.08803D, 0.0804243833718283D, 0.0804243833718283D, 0.0482545241518883D, 
        0.0482545241518883D, 0.0390406217967112D, 0.038603566D, 0.036995073D, 0.03538658D, 0.033778088D, 0.032169595D };
    double[] pT = { 
        1013.25D, 989.45D, 954.61D, 898.74D, 845.56D, 794.95D, 746.8D, 701.08D, 657.54D, 616.4D, 
        577.28D, 540.2D, 471.81D, 410.61D, 356.0D, 307.42D, 264.35D, 226.32D, 193.3D, 165.1D, 
        141.02D, 120.45D, 102.87D, 87.7D, 75.05D, 64.1D, 54.75D, 50.0D, 50.0D, 30.0D, 
        30.0D, 25.0D, 22.0D, 20.0D, 18.0D, 16.0D, 14.0D };
    double[] wZT = { 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
    double[] wVT = { 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
    this.z.clear();
    this.t.clear();
    this.r.clear();
    this.p.clear();
    this.wV.clear();
    this.wZ.clear();
    for (int i = 0; i < zT.length; i++) {
      try {
        this.z.add(i, Double.valueOf(zT[i]));
        double ajusteTemp = 0.0D;
        double ajustePress = 0.0D;
        if (this.verano) {
          switch (getArea()) {
            case 1:
              this.t.add(i, Double.valueOf(tT[i]));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 2:
              this.t.add(i, Double.valueOf(tT[i] * 1.05D));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 3:
              this.t.add(i, Double.valueOf(tT[i] * 1.05D));
              this.r.add(i, Double.valueOf(rT[i] * 0.99D));
              this.p.add(i, Double.valueOf(pT[i] * 0.99D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 4:
              this.t.add(i, Double.valueOf(tT[i] * 0.98D));
              this.r.add(i, Double.valueOf(rT[i] * 1.05D));
              this.p.add(i, Double.valueOf(pT[i] * 1.1D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 5:
              this.t.add(i, Double.valueOf(tT[i] * 0.95D));
              this.r.add(i, Double.valueOf(rT[i] * 1.1D));
              this.p.add(i, Double.valueOf(pT[i] * 1.2D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            default:
              this.t.add(i, Double.valueOf(tT[i]));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
          } 
        } else {
          switch (getArea()) {
            case 1:
              this.t.add(i, Double.valueOf(tT[i]));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 2:
              this.t.add(i, Double.valueOf(tT[i] * 1.01D));
              this.r.add(i, Double.valueOf(rT[i] * 0.99D));
              this.p.add(i, Double.valueOf(pT[i] * 0.97D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 3:
              this.t.add(i, Double.valueOf(tT[i] * 1.04D));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 4:
              this.t.add(i, Double.valueOf(tT[i] * 0.97D));
              this.r.add(i, Double.valueOf(rT[i] * 1.06D));
              this.p.add(i, Double.valueOf(pT[i] * 1.11D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            case 5:
              this.t.add(i, Double.valueOf(tT[i] * 0.94D));
              this.r.add(i, Double.valueOf(rT[i] * 1.12D));
              this.p.add(i, Double.valueOf(pT[i] * 1.22D));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
            default:
              this.t.add(i, Double.valueOf(tT[i]));
              this.r.add(i, Double.valueOf(rT[i]));
              this.p.add(i, Double.valueOf(pT[i]));
              this.wV.add(i, Double.valueOf(wVT[i]));
              this.wZ.add(i, Double.valueOf(wVT[i]));
              break;
          } 
        } 
      } catch (Exception e) {
        System.out.println("Error en configuracion de boletin");
        e.printStackTrace();
      } 
    } 
  }
  
  public double getTemp(double y, double varyTemp) {
    double temp = 0.0D;
    try {
      double tempCelciusMar = 15.0D;
      double gradiente = -0.0065D;
      if (getArea() == 1) {
        tempCelciusMar = 15.0D;
        gradiente = -0.0065D;
      } else if (getArea() == 2) {
        if (isVerano()) {
          tempCelciusMar = 26.0D;
          gradiente = -0.0065D;
        } else {
          tempCelciusMar = 18.0D;
          gradiente = -0.0065D;
        } 
      } else if (getArea() == 3) {
        if (isVerano()) {
          tempCelciusMar = 23.0D;
          gradiente = -0.0065D;
        } else {
          tempCelciusMar = 20.0D;
          gradiente = -0.0065D;
        } 
      } else if (getArea() == 4) {
        if (isVerano()) {
          tempCelciusMar = 12.0D;
          gradiente = -0.0055D;
        } else {
          tempCelciusMar = 9.0D;
          gradiente = -0.0055D;
        } 
      } else if (getArea() == 5) {
        if (isVerano()) {
          tempCelciusMar = -3.0D;
          gradiente = -0.005D;
        } else {
          tempCelciusMar = -6.0D;
          gradiente = -0.005D;
        } 
      } 
      double radioTerrestre = 6356766.0D;
      double h1 = y * radioTerrestre / (y + radioTerrestre);
      double R = 8.31432D;
      double t0 = 273.15D + tempCelciusMar;
      double g = 9.80665D;
      double md = 28.966D;
      temp = t0 - gradiente * h1 / 1000.0D;
      if (h1 >= 11000.0D)
        temp = 216.65D; 
    } catch (Exception exception) {}
    this.tempGeneric = temp * varyTemp;
    return this.tempGeneric;
  }
  
  public double getPressure(double y) {
    double temp = 0.0D;
    try {
      double tempCelciusMar = 15.0D;
      double p0 = 101325.0D;
      double gradiente = -0.0065D;
      if (getArea() == 1) {
        tempCelciusMar = 15.0D;
        p0 = 101325.0D;
        gradiente = -0.0065D;
      } else if (getArea() == 2) {
        if (isVerano()) {
          tempCelciusMar = 26.0D;
          p0 = 101100.0D;
          gradiente = -0.0065D;
        } else {
          tempCelciusMar = 19.0D;
          p0 = 101000.0D;
          gradiente = -0.0065D;
        } 
      } else if (getArea() == 3) {
        if (isVerano()) {
          tempCelciusMar = 23.0D;
          p0 = 100500.0D;
          gradiente = -0.0065D;
        } else {
          tempCelciusMar = 20.0D;
          p0 = 101300.0D;
          gradiente = -0.0065D;
        } 
      } else if (getArea() == 4) {
        if (isVerano()) {
          tempCelciusMar = 3.0D;
          p0 = 101300.0D;
          gradiente = -0.006D;
        } else {
          tempCelciusMar = 9.0D;
          p0 = 99000.0D;
          gradiente = -0.006D;
        } 
      } else if (getArea() == 5) {
        if (isVerano()) {
          tempCelciusMar = 1.0D;
          p0 = 96500.0D;
          gradiente = -0.005D;
        } else {
          tempCelciusMar = -6.0D;
          p0 = 99500.0D;
          gradiente = -0.005D;
        } 
      } 
      double radioTerrestre = 6356766.0D;
      double h1 = y * radioTerrestre / (y + radioTerrestre);
      double R = 8.31432D;
      double t0 = 273.15D + tempCelciusMar;
      double g = 9.80665D;
      double md = 28.966D;
      temp = t0 - gradiente * h1 / 1000.0D;
      if (h1 >= 11000.0D)
        temp = 216.65D; 
      double tm = (t0 + temp) / 2.0D;
      this.pressureGeneric = p0 / 100.0D / Math.exp(h1 * g / 287.04D * tm);
    } catch (Exception exception) {}
    return this.pressureGeneric;
  }
  
  public double getRho(double pressure, double temperature, double varyRho) {
    double density = (0.34848D * pressure - 0.0018D * Math.exp(0.061D * (temperature - 273.15D))) / temperature;
    this.rhoGeneric = density * varyRho;
    return this.rhoGeneric;
  }
  
  public void calculeAccoustic(double y) {
    try {
      int i = 0;
      while (((Double)this.z.get(i)).doubleValue() < y)
        i++; 
      this.rhoBoletin = (y - ((Double)this.z.get(i - 1)).doubleValue()) / (((Double)this.z.get(i)).doubleValue() - ((Double)this.z.get(i - 1)).doubleValue()) * (((Double)this.r.get(i)).doubleValue() - ((Double)this.r.get(i - 1)).doubleValue()) + ((Double)this.r.get(i - 1)).doubleValue();
      this.tempBoletin = (y - ((Double)this.z.get(i - 1)).doubleValue()) / (((Double)this.z.get(i)).doubleValue() - ((Double)this.z.get(i - 1)).doubleValue()) * (((Double)this.t.get(i)).doubleValue() - ((Double)this.t.get(i - 1)).doubleValue()) + ((Double)this.t.get(i - 1)).doubleValue();
      this.pressureBoletin = (y - ((Double)this.z.get(i - 1)).doubleValue()) / (((Double)this.z.get(i)).doubleValue() - ((Double)this.z.get(i - 1)).doubleValue()) * (((Double)this.p.get(i)).doubleValue() - ((Double)this.p.get(i - 1)).doubleValue()) + ((Double)this.p.get(i - 1)).doubleValue();
      this.velWindGeneric = (y - ((Double)this.z.get(i - 1)).doubleValue()) / (((Double)this.z.get(i)).doubleValue() - ((Double)this.z.get(i - 1)).doubleValue()) * (((Double)this.wV.get(i)).doubleValue() - ((Double)this.wV.get(i - 1)).doubleValue()) + ((Double)this.wV.get(i - 1)).doubleValue();
      this.azWindGeneric = (y - ((Double)this.z.get(i - 1)).doubleValue()) / (((Double)this.z.get(i)).doubleValue() - ((Double)this.z.get(i - 1)).doubleValue()) * (((Double)this.wZ.get(i)).doubleValue() - ((Double)this.wZ.get(i - 1)).doubleValue()) + ((Double)this.wZ.get(i - 1)).doubleValue();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Excepcion en altura del boletin");
    } 
  }
  
  public double getVelWindGeneric() {
    return this.velWindGeneric;
  }
  
  public void setVelWindGeneric(double velWindGeneric) {
    this.velWindGeneric = velWindGeneric;
  }
  
  public double getAzWindGeneric() {
    return this.azWindGeneric;
  }
  
  public void setAzWindGeneric(double azWindGeneric) {
    this.azWindGeneric = azWindGeneric;
  }
  
  public int getArea() {
    return this.area;
  }
  
  public void setArea(int area) {
    this.area = area;
  }
  
  public boolean isVerano() {
    return this.verano;
  }
  
  public void setVerano(boolean verano) {
    this.verano = verano;
  }
  
  public double getRhoBoletin() {
    return this.rhoBoletin;
  }
  
  public void setRhoBoletin(double rhoBoletin) {
    this.rhoBoletin = rhoBoletin;
  }
  
  public double getTempBoletin() {
    return this.tempBoletin;
  }
  
  public void setTempBoletin(double tempBoletin) {
    this.tempBoletin = tempBoletin;
  }
  
  public double getPressureBoletin() {
    return this.pressureBoletin;
  }
  
  public void setPressureBoletin(double pressureBoletin) {
    this.pressureBoletin = pressureBoletin;
  }
  
  public double getVelWindBoletin() {
    return this.velWindBoletin;
  }
  
  public void setVelWindBoletin(double velWindBoletin) {
    this.velWindBoletin = velWindBoletin;
  }
  
  public double getAzWindBoletin() {
    return this.azWindBoletin;
  }
  
  public void setAzWindBoletin(double azWindBoletin) {
    this.azWindBoletin = azWindBoletin;
  }
  
  public static Boletin getSingletonInstance() {
    if (boletin == null)
      boletin = new Boletin(); 
    return boletin;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\models\Boletin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */