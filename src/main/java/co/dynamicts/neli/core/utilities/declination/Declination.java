package co.dynamicts.neli.core.utilities.declination;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.GregorianCalendar;

public class Declination {
  private static Logger logger = Logger.getLogger(Declination.class);
  
  private String[] input = new String[] { 
      "    2015.0            WMM-2015        12/15/2014", "  1  0  -29438.5       0.0       10.7        0.0", "  1  1   -1501.1    4796.2       17.9      -26.8", "  2  0   -2445.3       0.0       -8.6        0.0", "  2  1    3012.5   -2845.6       -3.3      -27.1", "  2  2    1676.6    -642.0        2.4      -13.3", "  3  0    1351.1       0.0        3.1        0.0", "  3  1   -2352.3    -115.3       -6.2        8.4", "  3  2    1225.6     245.0       -0.4       -0.4", "  3  3     581.9    -538.3      -10.4        2.3", 
      "  4  0     907.2       0.0       -0.4        0.0", "  4  1     813.7     283.4        0.8       -0.6", "  4  2     120.3    -188.6       -9.2        5.3", "  4  3    -335.0     180.9        4.0        3.0", "  4  4      70.3    -329.5       -4.2       -5.3", "  5  0    -232.6       0.0       -0.2        0.0", "  5  1     360.1      47.4        0.1        0.4", "  5  2     192.4     196.9       -1.4        1.6", "  5  3    -141.0    -119.4        0.0       -1.1", "  5  4    -157.4      16.1        1.3        3.3", 
      "  5  5       4.3     100.1        3.8        0.1", "  6  0      69.5       0.0       -0.5        0.0", "  6  1      67.4     -20.7       -0.2        0.0", "  6  2      72.8      33.2       -0.6       -2.2", "  6  3    -129.8      58.8        2.4       -0.7", "  6  4     -29.0     -66.5       -1.1        0.1", "  6  5      13.2       7.3        0.3        1.0", "  6  6     -70.9      62.5        1.5        1.3", "  7  0      81.6       0.0        0.2        0.0", "  7  1     -76.1     -54.1       -0.2        0.7", 
      "  7  2      -6.8     -19.4       -0.4        0.5", "  7  3      51.9       5.6        1.3       -0.2", "  7  4      15.0      24.4        0.2       -0.1", "  7  5       9.3       3.3       -0.4       -0.7", "  7  6      -2.8     -27.5       -0.9        0.1", "  7  7       6.7      -2.3        0.3        0.1", "  8  0      24.0       0.0        0.0        0.0", "  8  1       8.6      10.2        0.1       -0.3", "  8  2     -16.9     -18.1       -0.5        0.3", "  8  3      -3.2      13.2        0.5        0.3", 
      "  8  4     -20.6     -14.6       -0.2        0.6", "  8  5      13.3      16.2        0.4       -0.1", "  8  6      11.7       5.7        0.2       -0.2", "  8  7     -16.0      -9.1       -0.4        0.3", "  8  8      -2.0       2.2        0.3        0.0", "  9  0       5.4       0.0        0.0        0.0", "  9  1       8.8     -21.6       -0.1       -0.2", "  9  2       3.1      10.8       -0.1       -0.1", "  9  3      -3.1      11.7        0.4       -0.2", "  9  4       0.6      -6.8       -0.5        0.1", 
      "  9  5     -13.3      -6.9       -0.2        0.1", "  9  6      -0.1       7.8        0.1        0.0", "  9  7       8.7       1.0        0.0       -0.2", "  9  8      -9.1      -3.9       -0.2        0.4", "  9  9     -10.5       8.5       -0.1        0.3", " 10  0      -1.9       0.0        0.0        0.0", " 10  1      -6.5       3.3        0.0        0.1", " 10  2       0.2      -0.3       -0.1       -0.1", " 10  3       0.6       4.6        0.3        0.0", " 10  4      -0.6       4.4       -0.1        0.0", 
      " 10  5       1.7      -7.9       -0.1       -0.2", " 10  6      -0.7      -0.6       -0.1        0.1", " 10  7       2.1      -4.1        0.0       -0.1", " 10  8       2.3      -2.8       -0.2       -0.2", " 10  9      -1.8      -1.1       -0.1        0.1", " 10 10      -3.6      -8.7       -0.2       -0.1", " 11  0       3.1       0.0        0.0        0.0", " 11  1      -1.5      -0.1        0.0        0.0", " 11  2      -2.3       2.1       -0.1        0.1", " 11  3       2.1      -0.7        0.1        0.0", 
      " 11  4      -0.9      -1.1        0.0        0.1", " 11  5       0.6       0.7        0.0        0.0", " 11  6      -0.7      -0.2        0.0        0.0", " 11  7       0.2      -2.1        0.0        0.1", " 11  8       1.7      -1.5        0.0        0.0", " 11  9      -0.2      -2.5        0.0       -0.1", " 11 10       0.4      -2.0       -0.1        0.0", " 11 11       3.5      -2.3       -0.1       -0.1", " 12  0      -2.0       0.0        0.1        0.0", " 12  1      -0.3      -1.0        0.0        0.0", 
      " 12  2       0.4       0.5        0.0        0.0", " 12  3       1.3       1.8        0.1       -0.1", " 12  4      -0.9      -2.2       -0.1        0.0", " 12  5       0.9       0.3        0.0        0.0", " 12  6       0.1       0.7        0.1        0.0", " 12  7       0.5      -0.1        0.0        0.0", " 12  8      -0.4       0.3        0.0        0.0", " 12  9      -0.4       0.2        0.0        0.0", " 12 10       0.2      -0.9        0.0        0.0", " 12 11      -0.9      -0.2        0.0        0.0", 
      " 12 12       0.0       0.7        0.0        0.0" };
  
  private double alt = 0.0D;
  
  private double glat = 0.0D;
  
  private double glon = 0.0D;
  
  private double time = 0.0D;
  
  private double dec = 0.0D;
  
  private double dip = 0.0D;
  
  private double ti = 0.0D;
  
  private int maxdeg = 12;
  
  private int maxord;
  
  private double defaultDate = 2017.5D;
  
  private final double defaultAltitude = 0.0D;
  
  private double[][] c = new double[13][13];
  
  private double[][] cd = new double[13][13];
  
  private double[][] tc = new double[13][13];
  
  private double[][] dp = new double[13][13];
  
  private double[] snorm = new double[169];
  
  private double[] sp = new double[13];
  
  private double[] cp = new double[13];
  
  private double[] fn = new double[13];
  
  private double[] fm = new double[13];
  
  private double[] pp = new double[13];
  
  private double[][] k = new double[13][13];
  
  private double otime;
  
  private double oalt;
  
  private double olat;
  
  private double olon;
  
  private double epoch;
  
  private double bx;
  
  private double by;
  
  private double bz;
  
  private double bh;
  
  private double re;
  
  private double a2;
  
  private double b2;
  
  private double c2;
  
  private double a4;
  
  private double b4;
  
  private double c4;
  
  private double r;
  
  private double d;
  
  private double ca;
  
  private double sa;
  
  private double ct;
  
  private double st;
  
  public Declination() {
    initModel();
  }
  
  private void initModel() {
    this.glat = 0.0D;
    this.glon = 0.0D;
    this.maxord = this.maxdeg;
    this.sp[0] = 0.0D;
    this.pp[0] = 1.0D;
    this.snorm[0] = 1.0D;
    this.cp[0] = 1.0D;
    this.dp[0][0] = 0.0D;
    double a = 6378.137D;
    double b = 6356.7523142D;
    this.re = 6371.2D;
    this.a2 = a * a;
    this.b2 = b * b;
    this.c2 = this.a2 - this.b2;
    this.a4 = this.a2 * this.a2;
    this.b4 = this.b2 * this.b2;
    this.c4 = this.a4 - this.b4;
    try {
      InputStream input = getClass().getResourceAsStream("WMM.COF");
      if (input == null)
        throw new FileNotFoundException("WMM.COF not found"); 
      Reader is = new InputStreamReader(input);
      StreamTokenizer str = new StreamTokenizer(is);
      this.c[0][0] = 0.0D;
      this.cd[0][0] = 0.0D;
      str.nextToken();
      this.epoch = str.nval;
      this.defaultDate = this.epoch + 2.5D;
      logger.trace("Entering application.");
      logger.debug("Declination Epoch is: " + this.epoch);
      logger.debug("Declination default date is: " + this.defaultDate);
      str.nextToken();
      str.nextToken();
      while (true) {
        str.nextToken();
        if (str.nval >= 9999.0D)
          break; 
        int i = (int)str.nval;
        str.nextToken();
        int m = (int)str.nval;
        str.nextToken();
        double gnm = str.nval;
        str.nextToken();
        double hnm = str.nval;
        str.nextToken();
        double dgnm = str.nval;
        str.nextToken();
        double dhnm = str.nval;
        if (m <= i) {
          this.c[m][i] = gnm;
          this.cd[m][i] = dgnm;
          if (m != 0) {
            this.c[i][m - 1] = hnm;
            this.cd[i][m - 1] = dhnm;
          } 
        } 
      } 
      is.close();
    } catch (FileNotFoundException e) {
      String msg = "\nNOTICE      NOTICE      NOTICE      \nWMMCOF file not found in Declination.InitModel()\nThe input file WMM.COF was not found in the same\ndirectory as the application.\nThe magnetic field components are set to internal values.\n";
      logger.warn(msg, e);
      setCoeff();
    } catch (IOException e) {
      String msg = "\nNOTICE      NOTICE      NOTICE      \nProblem reading the WMMCOF file in Declination.InitModel()\nThe input file WMM.COF was found, but there was a problem \nreading the data.\nThe magnetic field components are set to internal values.";
      logger.warn(msg, e);
      setCoeff();
    } 
    this.snorm[0] = 1.0D;
    for (int n = 1; n <= this.maxord; n++) {
      this.snorm[n] = this.snorm[n - 1] * (2 * n - 1) / n;
      int j = 2;
      int m, D1, D2;
      for (m = 0, D1 = 1, D2 = (n - m + D1) / D1; D2 > 0; D2--, m += D1) {
        this.k[m][n] = ((n - 1) * (n - 1) - m * m) / ((2 * n - 1) * (2 * n - 3));
        if (m > 0) {
          double flnmj = ((n - m + 1) * j) / (n + m);
          this.snorm[n + m * 13] = this.snorm[n + (m - 1) * 13] * Math.sqrt(flnmj);
          j = 1;
          this.c[n][m - 1] = this.snorm[n + m * 13] * this.c[n][m - 1];
          this.cd[n][m - 1] = this.snorm[n + m * 13] * this.cd[n][m - 1];
        } 
        this.c[m][n] = this.snorm[n + m * 13] * this.c[m][n];
        this.cd[m][n] = this.snorm[n + m * 13] * this.cd[m][n];
      } 
      this.fn[n] = (n + 1);
      this.fm[n] = n;
    } 
    this.k[1][1] = 0.0D;
    this.otime = this.oalt = this.olat = this.olon = -1000.0D;
  }
  
  private void calcGeoMag(double fLat, double fLon, double year, double altitude) {
    this.glat = fLat;
    this.glon = fLon;
    this.alt = altitude;
    this.time = year;
    double dt = this.time - this.epoch;
    double pi = Math.PI;
    double dtr = pi / 180.0D;
    double rlon = this.glon * dtr;
    double rlat = this.glat * dtr;
    double srlon = Math.sin(rlon);
    double srlat = Math.sin(rlat);
    double crlon = Math.cos(rlon);
    double crlat = Math.cos(rlat);
    double srlat2 = srlat * srlat;
    double crlat2 = crlat * crlat;
    this.sp[1] = srlon;
    this.cp[1] = crlon;
    if (this.alt != this.oalt || this.glat != this.olat) {
      double q = Math.sqrt(this.a2 - this.c2 * srlat2);
      double q1 = this.alt * q;
      double q2 = (q1 + this.a2) / (q1 + this.b2) * (q1 + this.a2) / (q1 + this.b2);
      this.ct = srlat / Math.sqrt(q2 * crlat2 + srlat2);
      this.st = Math.sqrt(1.0D - this.ct * this.ct);
      double r2 = this.alt * this.alt + 2.0D * q1 + (this.a4 - this.c4 * srlat2) / q * q;
      this.r = Math.sqrt(r2);
      this.d = Math.sqrt(this.a2 * crlat2 + this.b2 * srlat2);
      this.ca = (this.alt + this.d) / this.r;
      this.sa = this.c2 * crlat * srlat / this.r * this.d;
    } 
    if (this.glon != this.olon)
      for (int m = 2; m <= this.maxord; m++) {
        this.sp[m] = this.sp[1] * this.cp[m - 1] + this.cp[1] * this.sp[m - 1];
        this.cp[m] = this.cp[1] * this.cp[m - 1] - this.sp[1] * this.sp[m - 1];
      }  
    double aor = this.re / this.r;
    double ar = aor * aor;
    double br = 0.0D, bt = 0.0D, bp = 0.0D, bpp = 0.0D;
    for (int n = 1; n <= this.maxord; n++) {
      ar *= aor;
      int m, D3, D4;
      for (m = 0, D3 = 1, D4 = (n + m + D3) / D3; D4 > 0; D4--, m += D3) {
        double temp1, temp2;
        if (this.alt != this.oalt || this.glat != this.olat) {
          if (n == m) {
            this.snorm[n + m * 13] = this.st * this.snorm[n - 1 + (m - 1) * 13];
            this.dp[m][n] = this.st * this.dp[m - 1][n - 1] + this.ct * this.snorm[n - 1 + (m - 1) * 13];
          } 
          if (n == 1 && m == 0) {
            this.snorm[n + m * 13] = this.ct * this.snorm[n - 1 + m * 13];
            this.dp[m][n] = this.ct * this.dp[m][n - 1] - this.st * this.snorm[n - 1 + m * 13];
          } 
          if (n > 1 && n != m) {
            if (m > n - 2)
              this.snorm[n - 2 + m * 13] = 0.0D; 
            if (m > n - 2)
              this.dp[m][n - 2] = 0.0D; 
            this.snorm[n + m * 13] = this.ct * this.snorm[n - 1 + m * 13] - this.k[m][n] * this.snorm[n - 2 + m * 13];
            this.dp[m][n] = this.ct * this.dp[m][n - 1] - this.st * this.snorm[n - 1 + m * 13] - this.k[m][n] * this.dp[m][n - 2];
          } 
        } 
        if (this.time != this.otime) {
          this.tc[m][n] = this.c[m][n] + dt * this.cd[m][n];
          if (m != 0)
            this.tc[n][m - 1] = this.c[n][m - 1] + dt * this.cd[n][m - 1]; 
        } 
        double par = ar * this.snorm[n + m * 13];
        if (m == 0) {
          temp1 = this.tc[m][n] * this.cp[m];
          temp2 = this.tc[m][n] * this.sp[m];
        } else {
          temp1 = this.tc[m][n] * this.cp[m] + this.tc[n][m - 1] * this.sp[m];
          temp2 = this.tc[m][n] * this.sp[m] - this.tc[n][m - 1] * this.cp[m];
        } 
        bt -= ar * temp1 * this.dp[m][n];
        bp += this.fm[m] * temp2 * par;
        br += this.fn[n] * temp1 * par;
        if (this.st == 0.0D && m == 1) {
          if (n == 1) {
            this.pp[n] = this.pp[n - 1];
          } else {
            this.pp[n] = this.ct * this.pp[n - 1] - this.k[m][n] * this.pp[n - 2];
          } 
          double parp = ar * this.pp[n];
          bpp += this.fm[m] * temp2 * parp;
        } 
      } 
    } 
    if (this.st == 0.0D) {
      bp = bpp;
    } else {
      bp /= this.st;
    } 
    this.bx = -bt * this.ca - br * this.sa;
    this.by = bp;
    this.bz = bt * this.sa - br * this.ca;
    this.bh = Math.sqrt(this.bx * this.bx + this.by * this.by);
    this.ti = Math.sqrt(this.bh * this.bh + this.bz * this.bz);
    this.dec = Math.atan2(this.by, this.bx) / dtr;
    logger.debug("Dec is: " + this.dec);
    this.dip = Math.atan2(this.bz, this.bh) / dtr;
    this.otime = this.time;
    this.oalt = this.alt;
    this.olat = this.glat;
    this.olon = this.glon;
  }
  
  public double getDeclination(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.dec;
  }
  
  public double getDeclination(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.dec;
  }
  
  public double getIntensity(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.ti;
  }
  
  public double getIntensity(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.ti;
  }
  
  public double getHorizontalIntensity(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.bh;
  }
  
  public double getHorizontalIntensity(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.bh;
  }
  
  public double getVerticalIntensity(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.bz;
  }
  
  public double getVerticalIntensity(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.bz;
  }
  
  public double getNorthIntensity(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.bx;
  }
  
  public double getNorthIntensity(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.bx;
  }
  
  public double getEastIntensity(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.by;
  }
  
  public double getEastIntensity(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.by;
  }
  
  public double getDipAngle(double dlat, double dlong) {
    calcGeoMag(dlat, dlong, this.defaultDate, 0.0D);
    return this.dip;
  }
  
  public double getDipAngle(double dlat, double dlong, double year, double altitude) {
    calcGeoMag(dlat, dlong, year, altitude);
    return this.dip;
  }
  
  private void setCoeff() {
    this.c[0][0] = 0.0D;
    this.cd[0][0] = 0.0D;
    this.epoch = Double.parseDouble(this.input[0].trim().split("[\\s]+")[0]);
    this.defaultDate = this.epoch + 2.5D;
    for (int i = 1; i < this.input.length; i++) {
      String[] tokens = this.input[i].trim().split("[\\s]+");
      int n = Integer.parseInt(tokens[0]);
      int m = Integer.parseInt(tokens[1]);
      double gnm = Double.parseDouble(tokens[2]);
      double hnm = Double.parseDouble(tokens[3]);
      double dgnm = Double.parseDouble(tokens[4]);
      double dhnm = Double.parseDouble(tokens[5]);
      if (m <= n) {
        this.c[m][n] = gnm;
        this.cd[m][n] = dgnm;
        if (m != 0) {
          this.c[n][m - 1] = hnm;
          this.cd[n][m - 1] = dhnm;
        } 
      } 
    } 
  }
  
  public double decimalYear(GregorianCalendar cal) {
    double daysInYear;
    int year = cal.get(1);
    if (cal.isLeapYear(year)) {
      daysInYear = 366.0D;
    } else {
      daysInYear = 365.0D;
    } 
    return year + cal.get(6) / daysInYear;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\declination\Declination.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */