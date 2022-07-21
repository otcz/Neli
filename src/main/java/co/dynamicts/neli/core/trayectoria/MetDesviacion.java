package co.dynamicts.neli.core.trayectoria;

public class MetDesviacion {
  double sigma_wind;
  
  double sigma_density;
  
  double sigma_temp;
  
  double[] z = new double[] { 0.0D, 1.0D, 2.0D, 4.0D, 5.0D };
  
  double[] s_wind = new double[] { 0.8D, 4.0D, 4.9D, 7.2D, 11.0D };
  
  double[] s_density = new double[] { 0.15D, 0.4D, 0.69D, 0.97D, 6.6D };
  
  double[] s_temp = new double[] { 0.25D, 0.3D, 0.57D, 0.79D, 3.0D };
  
  public void processMet(double staleness_hour) {
    int i = 0;
    while (this.z[i] < staleness_hour)
      i++; 
    this.sigma_wind = this.s_wind[i] * 0.5144444444D;
    this.sigma_density = this.s_density[i];
    this.sigma_temp = this.s_temp[i];
  }
  
  public double getSigma_wind() {
    return this.sigma_wind;
  }
  
  public double getSigma_density() {
    return this.sigma_density;
  }
  
  public double getSigma_temp() {
    return this.sigma_temp;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\trayectoria\MetDesviacion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */