package co.dynamicts.neli.core.stauts;

public final class StatusCoordinates {
  private final String cardinalidadLongitud;
  
  private final String cardinalidadLatitud;
  
  private final Double latitudGrados;
  
  private final Double latitudMinutos;
  
  private final Double latitudSegundos;
  
  private final Double longitudGrados;
  
  private final Double longitudMinutos;
  
  private final Double longitudSegundos;
  
  private final Double metros;
  
  private StatusCoordinates(String cardinalidadLongitud, String cardinalidadLatitud, Double latitudGrados, Double latitudMinutos, Double latitudSegundos, Double longitudGrados, Double longitudMinutos, Double longitudSegundos, Double metros) {
    this.cardinalidadLongitud = cardinalidadLongitud;
    this.cardinalidadLatitud = cardinalidadLatitud;
    this.latitudGrados = latitudGrados;
    this.latitudMinutos = latitudMinutos;
    this.latitudSegundos = latitudSegundos;
    this.longitudGrados = longitudGrados;
    this.longitudMinutos = longitudMinutos;
    this.longitudSegundos = longitudSegundos;
    this.metros = metros;
  }
  
  public String getCardinalidadLatitud() {
    return this.cardinalidadLatitud;
  }
  
  public String getCardinalidadLongitud() {
    return this.cardinalidadLongitud;
  }
  
  public Double getLatitudGrados() {
    return this.latitudGrados;
  }
  
  public Double getLatitudMinutos() {
    return Double.valueOf(Math.abs(this.latitudMinutos.doubleValue()));
  }
  
  public Double getLatitudSegundos() {
    return Double.valueOf(Math.abs(this.latitudSegundos.doubleValue()));
  }
  
  public Double getLongitudGrados() {
    return this.longitudGrados;
  }
  
  public Double getLongitudMinutos() {
    return Double.valueOf(Math.abs(this.longitudMinutos.doubleValue()));
  }
  
  public Double getLongitudSegundos() {
    return Double.valueOf(Math.abs(this.longitudSegundos.doubleValue()));
  }
  
  public Double getMetros() {
    return this.metros;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private String cardinalidadLongitud;
    
    private String cardinalidadLatitud;
    
    private Double latitudGrados;
    
    private Double latitudMinutos;
    
    private Double latitudSegundos;
    
    private Double longitudGrados;
    
    private Double longitudMinutos;
    
    private Double longitudSegundos;
    
    private Double metros;
    
    private Builder() {}
    
    public Builder withCardinalidadLongitud(String cardinalidadLongitud) {
      this.cardinalidadLongitud = cardinalidadLongitud;
      return this;
    }
    
    public Builder withCardinalidadLatitud(String cardinalidadLatitud) {
      this.cardinalidadLatitud = cardinalidadLatitud;
      return this;
    }
    
    public Builder withLatitudGrados(Double latitudGrados) {
      this.latitudGrados = latitudGrados;
      return this;
    }
    
    public Builder withLatitudMinutos(Double latitudMinutos) {
      this.latitudMinutos = latitudMinutos;
      return this;
    }
    
    public Builder withLatitudSegundos(Double latitudSegundos) {
      this.latitudSegundos = latitudSegundos;
      return this;
    }
    
    public Builder withLongitudGrados(Double longitudGrados) {
      this.longitudGrados = longitudGrados;
      return this;
    }
    
    public Builder withLongitudMinutos(Double longitudMinutos) {
      this.longitudMinutos = longitudMinutos;
      return this;
    }
    
    public Builder withLongitudSegundos(Double longitudSegundos) {
      this.longitudSegundos = longitudSegundos;
      return this;
    }
    
    public Builder withMetros(Double metros) {
      this.metros = metros;
      return this;
    }
    
    public StatusCoordinates build() {
      return new StatusCoordinates(this.cardinalidadLongitud, this.cardinalidadLatitud, this.latitudGrados, this.latitudMinutos, this.latitudSegundos, this.longitudGrados, this.longitudMinutos, this.longitudSegundos, this.metros);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusCoordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */