package co.dynamicts.neli.core.municion;

public class Coeficientes {
  public double[] M;
  
  public double[] cD0;
  
  public double[] cDa2;
  
  public double[] cL;
  
  public double[] cL3;
  
  public double[] cma;
  
  public double[] cMag;
  
  public double[] cLp;
  
  public double[] cXbb;
  
  public double[] i0;
  
  public double[] iform;
  
  public double iX0 = 0.15027999877929688D;
  
  public double[] cM3;
  
  public Coeficientes(double[] m, double[] cD0, double[] cL, double[] cXbb) {
    this.M = m;
    this.cD0 = cD0;
    this.cL = cL;
    this.cXbb = cXbb;
  }
  
  public Coeficientes() {
    this.M = new double[] { 
        0.3D, 0.73D, 0.9D, 0.95D, 1.0D, 1.1D, 1.3D, 1.5D, 1.8D, 2.1D, 
        2.3D, 2.5D, 2.7D, 2.9D, 3.1D };
    this.cD0 = new double[] { 
        0.13D, 0.13D, 0.13D, 0.13D, 0.13D, 0.197D, 0.292D, 0.272D, 0.25D, 0.233D, 
        0.223D, 0.214D, 0.207D, 0.202D, 0.201D };
    this.cDa2 = new double[] { 
        3.62D, 3.62D, 3.62D, 3.62D, 3.62D, 3.68D, 3.75D, 4.12D, 4.45D, 4.7D, 
        4.87D, 5.0D, 5.1D, 5.15D, 5.1D };
    this.cL = new double[] { 
        1.68D, 1.68D, 1.68D, 1.69D, 1.71D, 1.68D, 1.63D, 1.79D, 1.98D, 2.13D, 
        2.2D, 2.25D, 2.29D, 2.349D, 2.35D };
    this.cL3 = new double[] { 
        0.98D, 0.746948D, 0.57314D, 0.52202D, 0.4709D, 0.36866D, 0.16418D, -0.0402999999999998D, -0.34702D, -0.65374D, 
        -0.85822D, -1.0627D, -1.26718D, -1.47166D, -1.47D };
    this.cma = new double[] { 
        3.02D, 3.02D, 3.02D, 3.02D, 3.02D, 3.15D, 3.33D, 3.37D, 3.81D, 3.6D, 
        3.49D, 3.55D, 3.6D, 3.65D, 3.65D };
    this.cM3 = new double[] { 
        2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 
        2.849D, 2.849D, 2.849D, 2.849D, 2.849D };
    this.cMag = new double[] { 
        -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, 
        -2.29D, -2.29D, -2.29D, -2.29D, -2.29D };
    this.cLp = new double[] { 
        -0.033D, -0.032D, -0.031D, -0.0305D, -0.0302D, -0.03D, -0.028D, -0.043D, -0.042D, -0.041D, 
        -0.04D, -0.039D, -0.039D, -0.039D, -0.039D };
    this.cXbb = new double[] { 
        0.016D, 0.016D, 0.016D, 0.016D, 0.02D, 0.072D, 0.093D, 0.0865D, 0.084D, 0.078D, 
        0.072D, 0.066D, 0.058D, 0.052D, 0.051D };
    this.i0 = new double[] { 
        0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 
        0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D };
    this.iform = new double[] { 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
  }
  
  public double Drag_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cD0[i] - this.cD0[i - 1]) + this.cD0[i - 1];
    } 
    return coef;
  }
  
  public double CDa2_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cDa2[i] - this.cDa2[i - 1]) + this.cDa2[i - 1];
    } 
    return coef;
  }
  
  public double lift_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cL[i] - this.cL[i - 1]) + this.cL[i - 1];
    } 
    return coef;
  }
  
  public double cL3_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cL3[i] - this.cL3[i - 1]) + this.cL3[i - 1];
    } 
    return coef;
  }
  
  public double Cma_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cma[i] - this.cma[i - 1]) + this.cma[i - 1];
    } 
    return coef;
  }
  
  public double CMag_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cMag[i] - this.cMag[i - 1]) + this.cMag[i - 1];
    } 
    return coef;
  }
  
  public double cLp_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cLp[i] - this.cLp[i - 1]) + this.cLp[i - 1];
    } 
    return coef;
  }
  
  public double base_coeff(double x) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < x) {
      i++;
      coef = (x - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cXbb[i] - this.cXbb[i - 1]) + this.cXbb[i - 1];
    } 
    return coef;
  }
  
  public double i0_coeff(double M) {
    double coef = 0.0D;
    int i = 0;
    while (this.M[i] < M) {
      i++;
      coef = (M - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.i0[i] - this.i0[i - 1]) + this.i0[i - 1];
    } 
    return coef;
  }
  
  public double cM3_coeff(double M) {
    double coef = 0.0D;
    int i = 0;
    try {
      while (this.M[i] < M) {
        i++;
        coef = (M - this.M[i - 1]) / (this.M[i] - this.M[i - 1]) * (this.cM3[i] - this.cM3[i - 1]) + this.cM3[i - 1];
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return coef;
  }
  
  public double getiX0() {
    return this.iX0;
  }
  
  public void setiX0(double iX0) {
    this.iX0 = iX0;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\municion\Coeficientes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */