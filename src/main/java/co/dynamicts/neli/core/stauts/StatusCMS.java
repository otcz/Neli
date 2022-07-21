package co.dynamicts.neli.core.stauts;

import java.util.TreeMap;

public class StatusCMS {
  private String temperaturaTubo;
  
  private String maximoRetroceso;
  
  private String velocidadBoca;
  
  private String tempCorte;
  
  private String temperaturaMCTubo;
  
  private String EFCUltimoDisparo;
  
  private String dispAccion;
  
  private String EFCTotal;
  
  private String distanciaRetroceso;
  
  private String maximoEFC;
  
  private String dispTotalTubo;
  
  private TreeMap<String, Double> chartValues;
  
  public StatusCMS() {
    this.temperaturaTubo = "0 ";
    this.maximoRetroceso = "0 ";
    this.velocidadBoca = "0 ";
    this.tempCorte = "0 ";
    this.temperaturaMCTubo = "0 ";
    this.EFCUltimoDisparo = "0 ";
    this.dispAccion = "0 ";
    this.EFCTotal = "0 ";
    this.distanciaRetroceso = "0 ";
    this.maximoEFC = "0 ";
    this.dispTotalTubo = "0 ";
    this.chartValues = new TreeMap<>();
    Double example = Double.valueOf(20.0D);
    this.chartValues.put("2020", example);
  }
  
  public TreeMap<String, Double> getChartValues() {
    return this.chartValues;
  }
  
  private StatusCMS(String temperaturaTubo, String maximoRetroceso, String velocidadBoca, String tempCorte, String temperaturaMCTubo, String EFCUltimoDisparo, String dispAccion, String EFCTotal, String distanciaRetroceso, String maximoEFC, String dispTotalTubo, TreeMap<String, Double> chartValues) {
    this.temperaturaTubo = temperaturaTubo;
    this.maximoRetroceso = maximoRetroceso;
    this.velocidadBoca = velocidadBoca;
    this.tempCorte = tempCorte;
    this.temperaturaMCTubo = temperaturaMCTubo;
    this.EFCUltimoDisparo = EFCUltimoDisparo;
    this.dispAccion = dispAccion;
    this.EFCTotal = EFCTotal;
    this.distanciaRetroceso = distanciaRetroceso;
    this.maximoEFC = maximoEFC;
    this.dispTotalTubo = dispTotalTubo;
    this.chartValues = chartValues;
  }
  
  public String getTemperaturaTubo() {
    return this.temperaturaTubo;
  }
  
  public String getMaximoRetroceso() {
    return this.maximoRetroceso;
  }
  
  public String getVelocidadBoca() {
    return this.velocidadBoca;
  }
  
  public String getTempCorte() {
    return this.tempCorte;
  }
  
  public String getTemperaturaMCTubo() {
    return this.temperaturaMCTubo;
  }
  
  public String getEFCUltimoDisparo() {
    return this.EFCUltimoDisparo;
  }
  
  public String getDispAccion() {
    return this.dispAccion;
  }
  
  public String getEFCTotal() {
    return this.EFCTotal;
  }
  
  public String getDistanciaRetroceso() {
    return this.distanciaRetroceso;
  }
  
  public String getMaximoEFC() {
    return this.maximoEFC;
  }
  
  public String getDispTotalTubo() {
    return this.dispTotalTubo;
  }
  
  static class StatusCMSBuilder {
    private String temperaturaTubo;
    
    private String maximoRetroceso;
    
    private String velocidadBoca;
    
    private String tempCorte;
    
    private String temperaturaMCTubo;
    
    private String efcUltimoDisparo;
    
    private String dispAccion;
    
    private String efcTotal;
    
    private String distanciaRetroceso;
    
    private String maximoEFC;
    
    private String dispTotalTubo;
    
    private TreeMap<String, Double> chartValues;
    
    public StatusCMS createStatusCMS() {
      return new StatusCMS(this.temperaturaTubo, this.maximoRetroceso, this.velocidadBoca, this.tempCorte, this.temperaturaMCTubo, this.efcUltimoDisparo, this.dispAccion, this.efcTotal, this.distanciaRetroceso, this.maximoEFC, this.dispTotalTubo, this.chartValues);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusCMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */