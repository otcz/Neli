package co.dynamicts.neli.core.municion;

public class BaseBleed {
  private double mcb0 = 0.012D;
  
  private double mFuell = 1.025D;
  
  private double vC0 = 1.43099999427795D;
  
  private double betaVc = 0.00139999995008111D;
  
  private double k = 3.71850006786189E-7D;
  
  private double nVc = 0.660000026226043D;
  
  private double propRho = 1525.0D;
  
  private double diamBase = 0.139300003647804D;
  
  private double adjustBB = 1.31D;
  
  private double xcg0 = 0.0D;
  
  private double xcgb = 0.0D;
  
  public double[] mcb;
  
  public double[] sc;
  
  private double[] fibb;
  
  private double[] tdi;
  
  private double[] tb = new double[4];
  
  private double kP = 1.33399999141693D;
  
  public BaseBleed() {
    this.fibb = new double[] { 0.974D, -2.00699996639741E-5D, 5.53086977106431E-7D, -4.04601990799946E-10D, 0.0D, 0.0D, 0.0D };
    this.tdi = new double[] { 0.0D, 0.0D, 0.0D, 0.0D };
    this.tb = new double[] { 0.0D, 0.0D, 0.0D, 0.0D };
    this.mcb = new double[] { 0.0D, 0.71D, 0.93D, 1.0D, 1.026D };
    this.sc = new double[] { 0.019D, 0.0184D, 0.01264D, 0.00637D, -1.7E-4D };
  }
  
  public double sc_coeff(double mcbValue) {
    double coef = 0.0D;
    int i = 0;
    while (this.mcb[i] < mcbValue) {
      try {
        i++;
        coef = (mcbValue - this.mcb[i - 1]) / (this.mcb[i] - this.mcb[i - 1]) * (this.sc[i] - this.sc[i - 1]) + this.sc[i - 1];
      } catch (Exception e) {
        System.out.println("Coeficientes: Error sc_coeff. mcb: " + mcbValue + "sc");
        e.printStackTrace();
      } 
    } 
    return coef;
  }
  
  public double getNumeroRevoluciones(int seleccion) {
    if (seleccion == 1)
      return 1200.0D; 
    if (seleccion == 2)
      return 2000.0D; 
    if (seleccion == 3)
      return 3000.0D; 
    return 4000.0D;
  }
  
  public void setNumeroRevoluciones(int seleccion) {
    if (seleccion == 1) {
      double velocidadLicuadora = 1200.0D;
    } else {
      if (seleccion == 2)
        return; 
      if (seleccion == 3) {
        double velocidadLicuadora = 3000.0D;
      } else {
        return;
      } 
    } 
  }
  
  public double getkP() {
    return this.kP;
  }
  
  public void setkP(double kP) {
    this.kP = kP;
  }
  
  public double getMcb0() {
    return this.mcb0;
  }
  
  public void setMcb0(double mcb0) {
    this.mcb0 = mcb0;
  }
  
  public double getmFuell() {
    return this.mFuell;
  }
  
  public void setmFuell(double mFuell) {
    this.mFuell = mFuell;
  }
  
  public double getvC0() {
    return this.vC0;
  }
  
  public void setvC0(double vC0) {
    this.vC0 = vC0;
  }
  
  public double getBetaVc() {
    return this.betaVc;
  }
  
  public void setBetaVc(double betaVc) {
    this.betaVc = betaVc;
  }
  
  public double getK() {
    return this.k;
  }
  
  public void setK(double k) {
    this.k = k;
  }
  
  public double getnVc() {
    return this.nVc;
  }
  
  public void setnVc(double nVc) {
    this.nVc = nVc;
  }
  
  public double getPropRho() {
    return this.propRho;
  }
  
  public void setPropRho(double propRho) {
    this.propRho = propRho;
  }
  
  public double getDiamBase() {
    return this.diamBase;
  }
  
  public void setDiamBase(double diamBase) {
    this.diamBase = diamBase;
  }
  
  public double getAdjustBB() {
    return this.adjustBB;
  }
  
  public void setAdjustBB(double adjustBB) {
    this.adjustBB = adjustBB;
  }
  
  public double getXcg0() {
    return this.xcg0;
  }
  
  public void setXcg0(double xcg0) {
    this.xcg0 = xcg0;
  }
  
  public double getXcgb() {
    return this.xcgb;
  }
  
  public void setXcgb(double xcgb) {
    this.xcgb = xcgb;
  }
  
  public double getFibb(double elevacion, double mT) {
    double ibb = this.fibb[0] + this.fibb[1] * elevacion + this.fibb[2] * Math.pow(elevacion, 2.0D) + this.fibb[3] * Math.pow(elevacion, 3.0D);
    double fiBB = ibb + this.fibb[4] * (mT - 21.0D) + this.fibb[5] * Math.pow(mT - 21.0D, 2.0D) + this.fibb[6] * Math.pow(mT - 21.0D, 3.0D);
    return fiBB;
  }
  
  public void setFibb(double[] fibb) {
    this.fibb = fibb;
  }
  
  public double[] getTdi() {
    return this.tdi;
  }
  
  public void setTdi(double[] tdi) {
    this.tdi = tdi;
  }
  
  public void setTb(double[] tb) {
    this.tb = tb;
  }
  
  public double getTb(double mT) {
    double tbOut = this.tb[0] + this.tb[1] * (mT - 21.0D) + this.tb[2] * Math.pow(mT - 21.0D, 2.0D) + this.tb[3] * Math.pow(mT - 21.0D, 3.0D);
    return tbOut;
  }
  
  public double getTdi(double mT) {
    double tdiOut = this.tdi[0] + this.tdi[1] * (mT - 21.0D) + this.tdi[2] * Math.pow(mT - 21.0D, 2.0D) + this.tdi[3] * Math.pow(mT - 21.0D, 3.0D);
    return tdiOut;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\municion\BaseBleed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */