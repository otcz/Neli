package co.dynamicts.neli.core.municion;

public class Zona {
  private int numero;
  
  public double[] velocidades;
  
  private String propName;
  
  private double velBocaStd;
  
  private double velBoca;
  
  private double ajusteCD;
  
  private double ajusteMag;
  
  private double ajusteFL;
  
  private double ajusteFla0 = 1.0D;
  
  private double ajusteFLa1 = 0.0D;
  
  private double ajusteFLa2 = 0.0D;
  
  private double ajusteFLa3 = 0.0D;
  
  private double ajusteFLa4 = 0.0D;
  
  private double ajusteI;
  
  private double ajusteIa0 = 1.0D;
  
  private double ajusteIa1 = 0.0D;
  
  private double ajusteIa2 = 0.0D;
  
  private double ajusteIa3 = 0.0D;
  
  private double ajusteIa4 = 0.0D;
  
  private double ajusteT;
  
  private double ajusteTa0 = 1.0D;
  
  private double ajusteTa1 = 0.0D;
  
  private double ajusteTa2 = 0.0D;
  
  private double ajusteTa3 = 0.0D;
  
  private double ajusteTa4 = 0.0D;
  
  private double gradienteTemp;
  
  private double gradPeso_Vel;
  
  private double qeMaxR;
  
  private double maxRange;
  
  public BaseBleed baseBleed = new BaseBleed();
  
  public Zona(int numero, String propName, double velBocaStd, double[] velocidades, double ajusteCD, double ajustefL, double ajusteI, double ajusteMag, double gradienteTemp, double gradPeso_Vel, double qeMaxR) {
    this.numero = numero;
    this.propName = propName;
    this.velocidades = velocidades;
    this.ajusteCD = ajusteCD;
    this.ajusteFL = ajustefL;
    this.ajusteI = ajusteI;
    this.ajusteMag = ajusteMag;
    this.gradienteTemp = gradienteTemp;
    this.velBocaStd = velBocaStd;
    this.gradPeso_Vel = gradPeso_Vel;
    this.qeMaxR = qeMaxR;
  }
  
  public Zona() {
    this.velocidades = new double[5];
  }
  
  public double getVelBoca(double tempProp, double difPesoStd) {
    double acumulado = 0.0D;
    for (int i = 0; i < this.velocidades.length; i++) {
      if (this.velocidades[i] == 0.0D)
        this.velocidades[i] = getVelBocaStd(); 
      acumulado += this.velocidades[i];
    } 
    double velPromedio = acumulado / this.velocidades.length;
    double variacion_m_s = getGradienteTemp() * (tempProp - 21.0D);
    double velBoca = variacion_m_s + velPromedio;
    double velChange = getGradPeso_Vel() * 10.0D * difPesoStd;
    double velocidadResultante = velBoca + velChange;
    return velocidadResultante;
  }
  
  public double getAjusteI(double cuadrante) {
    double ajuste = getAjusteIa0() + getAjusteIa1() * cuadrante + getAjusteIa2() * Math.pow(cuadrante, 2.0D) + getAjusteIa3() * Math.pow(cuadrante, 3.0D) + getAjusteIa4() * Math.pow(cuadrante, 4.0D);
    this.ajusteI = ajuste;
    return this.ajusteI;
  }
  
  public double getAjusteFL(double cuadrante) {
    double ajuste = getAjusteFla0() + getAjusteFLa1() * cuadrante + getAjusteFLa2() * Math.pow(cuadrante, 2.0D) + getAjusteFLa3() * Math.pow(cuadrante, 3.0D) + getAjusteFLa4() * Math.pow(cuadrante, 4.0D);
    this.ajusteFL = ajuste;
    return this.ajusteFL;
  }
  
  public double getAjusteT(double cuadrante) {
    double ajuste = getAjusteTa0() + getAjusteTa1() * cuadrante + getAjusteTa2() * Math.pow(cuadrante, 2.0D) + getAjusteTa3() * Math.pow(cuadrante, 3.0D) + getAjusteTa4() * Math.pow(cuadrante, 4.0D);
    this.ajusteT = ajuste;
    return this.ajusteT;
  }
  
  public double[] getVelocidades() {
    return this.velocidades;
  }
  
  public void setVelocidades(double[] velocidades) {
    this.velocidades = velocidades;
  }
  
  public int getNumero() {
    return this.numero;
  }
  
  public void setNumero(int numero) {
    this.numero = numero;
  }
  
  public void setVelBocaStd(double velBocaStd) {
    this.velBocaStd = velBocaStd;
  }
  
  public double getVelBocaStd() {
    return this.velBocaStd;
  }
  
  public double getAjusteCD() {
    return this.ajusteCD;
  }
  
  public void setAjusteCD(double ajusteCD) {
    this.ajusteCD = ajusteCD;
  }
  
  public double getGradienteTemp() {
    return this.gradienteTemp;
  }
  
  public void setGradienteTemp(double gradienteTemp) {
    this.gradienteTemp = gradienteTemp;
  }
  
  public double getAjusteMag() {
    return this.ajusteMag;
  }
  
  public void setVelBoca(double velBoca) {
    this.velBoca = velBoca;
  }
  
  public String getPropName() {
    return this.propName;
  }
  
  public void setPropName(String propName) {
    this.propName = propName;
  }
  
  public double getGradPeso_Vel() {
    return this.gradPeso_Vel;
  }
  
  public void setGradPeso_Vel(double gradPeso_Vel) {
    this.gradPeso_Vel = gradPeso_Vel;
  }
  
  public double getQeMaxR() {
    return this.qeMaxR;
  }
  
  public void setQeMaxR(double qeMaxR) {
    this.qeMaxR = qeMaxR;
  }
  
  public double getMaxRange() {
    return this.maxRange;
  }
  
  public void setMaxRange(double maxRange) {
    this.maxRange = maxRange;
  }
  
  public double getAjusteFla0() {
    return this.ajusteFla0;
  }
  
  public void setAjusteFla0(double ajusteFla0) {
    this.ajusteFla0 = ajusteFla0;
  }
  
  public double getAjusteFLa1() {
    return this.ajusteFLa1;
  }
  
  public void setAjusteFLa1(double ajusteFLa1) {
    this.ajusteFLa1 = ajusteFLa1;
  }
  
  public double getAjusteFLa2() {
    return this.ajusteFLa2;
  }
  
  public void setAjusteFLa2(double ajusteFLa2) {
    this.ajusteFLa2 = ajusteFLa2;
  }
  
  public double getAjusteFLa3() {
    return this.ajusteFLa3;
  }
  
  public void setAjusteFLa3(double ajusteFLa3) {
    this.ajusteFLa3 = ajusteFLa3;
  }
  
  public double getAjusteFLa4() {
    return this.ajusteFLa4;
  }
  
  public void setAjusteFLa4(double ajusteFLa4) {
    this.ajusteFLa4 = ajusteFLa4;
  }
  
  public double getAjusteIa0() {
    return this.ajusteIa0;
  }
  
  public void setAjusteIa0(double ajusteIa0) {
    this.ajusteIa0 = ajusteIa0;
  }
  
  public double getAjusteIa1() {
    return this.ajusteIa1;
  }
  
  public void setAjusteIa1(double ajusteIa1) {
    this.ajusteIa1 = ajusteIa1;
  }
  
  public double getAjusteIa2() {
    return this.ajusteIa2;
  }
  
  public void setAjusteIa2(double ajusteIa2) {
    this.ajusteIa2 = ajusteIa2;
  }
  
  public double getAjusteIa3() {
    return this.ajusteIa3;
  }
  
  public void setAjusteIa3(double ajusteIa3) {
    this.ajusteIa3 = ajusteIa3;
  }
  
  public double getAjusteIa4() {
    return this.ajusteIa4;
  }
  
  public void setAjusteIa4(double ajusteIa4) {
    this.ajusteIa4 = ajusteIa4;
  }
  
  public double getAjusteTa0() {
    return this.ajusteTa0;
  }
  
  public void setAjusteTa0(double ajusteTa0) {
    this.ajusteTa0 = ajusteTa0;
  }
  
  public double getAjusteTa1() {
    return this.ajusteTa1;
  }
  
  public void setAjusteTa1(double ajusteTa1) {
    this.ajusteTa1 = ajusteTa1;
  }
  
  public double getAjusteTa2() {
    return this.ajusteTa2;
  }
  
  public void setAjusteTa2(double ajusteTa2) {
    this.ajusteTa2 = ajusteTa2;
  }
  
  public double getAjusteTa3() {
    return this.ajusteTa3;
  }
  
  public void setAjusteTa3(double ajusteTa3) {
    this.ajusteTa3 = ajusteTa3;
  }
  
  public double getAjusteTa4() {
    return this.ajusteTa4;
  }
  
  public void setAjusteTa4(double ajusteTa4) {
    this.ajusteTa4 = ajusteTa4;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\municion\Zona.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */