package co.dynamicts.neli.core.stauts;

public class StatusDataGrid {
  private final String tipoMunicion;
  
  private final Integer cuadros;
  
  private final String carga;
  
  private final Integer zona;
  
  private final String espoleta;
  
  private final Double graduacion;
  
  private final Double velocidadEnBoca;
  
  private final Double temperaturaPropelente;
  
  private final Double drift;
  
  private final Double intervaloVertical;
  
  private final Double correccionTotalDeflexion;
  
  private final Double explosionHeight;
  
  private final Double orientacionMagnetica;
  
  private final Double tiempoDeVuelo;
  
  private final Double errorPrecisionDistancia;
  
  private final Double errorPresicionOrient;
  
  private final Double errorPMIDistancia;
  
  private final Double errprPMIOrientacion;
  
  private StatusDataGrid(String tipoMunicion, Integer cuadros, String carga, Integer zona, String espoleta, Double graduacion, Double velocidadEnBoca, Double temperaturaPropelente, Double drift, Double intervaloVertical, Double correccionTotalDeflexion, Double explosionHeight, Double orientacionMagnetica, Double tiempoDeVuelo, Double errorPrecisionDistancia, Double errorPresicionOrient, Double errorPMIDistancia, Double errprPMIOrientacion) {
    this.tipoMunicion = tipoMunicion;
    this.cuadros = cuadros;
    this.carga = carga;
    this.zona = zona;
    this.espoleta = espoleta;
    this.graduacion = graduacion;
    this.velocidadEnBoca = velocidadEnBoca;
    this.temperaturaPropelente = temperaturaPropelente;
    this.drift = drift;
    this.intervaloVertical = intervaloVertical;
    this.correccionTotalDeflexion = correccionTotalDeflexion;
    this.explosionHeight = explosionHeight;
    this.orientacionMagnetica = orientacionMagnetica;
    this.tiempoDeVuelo = tiempoDeVuelo;
    this.errorPrecisionDistancia = errorPrecisionDistancia;
    this.errorPresicionOrient = errorPresicionOrient;
    this.errorPMIDistancia = errorPMIDistancia;
    this.errprPMIOrientacion = errprPMIOrientacion;
  }
  
  public String getTipoMunicion() {
    return this.tipoMunicion;
  }
  
  public Integer getCuadros() {
    return this.cuadros;
  }
  
  public String getCarga() {
    return this.carga;
  }
  
  public Integer getZona() {
    return this.zona;
  }
  
  public String getEspoleta() {
    return this.espoleta;
  }
  
  public Double getGraduacion() {
    return this.graduacion;
  }
  
  public Double getVelocidadEnBoca() {
    return this.velocidadEnBoca;
  }
  
  public Double getTemperaturaPropelente() {
    return this.temperaturaPropelente;
  }
  
  public Double getDrift() {
    return this.drift;
  }
  
  public Double getIntervaloVertical() {
    return this.intervaloVertical;
  }
  
  public Double getCorreccionTotalDeflexion() {
    return this.correccionTotalDeflexion;
  }
  
  public Double getAlturaExplosion() {
    return this.explosionHeight;
  }
  
  public Double getOrientacionMagnetica() {
    return this.orientacionMagnetica;
  }
  
  public Double getTiempoDeVuelo() {
    return this.tiempoDeVuelo;
  }
  
  public Double getErrorPrecisionDistancia() {
    return this.errorPrecisionDistancia;
  }
  
  public Double getErrorPresicionOrient() {
    return this.errorPresicionOrient;
  }
  
  public Double getErrorPMIDistancia() {
    return this.errorPMIDistancia;
  }
  
  public Double getErrprPMIOrientacion() {
    return this.errprPMIOrientacion;
  }
  
  public static StatusDataGridBuilder builder() {
    return new StatusDataGridBuilder();
  }
  
  public static final class StatusDataGridBuilder {
    private String tipoMunicion;
    
    private Integer cuadros;
    
    private String carga;
    
    private Integer zona;
    
    private String espoleta;
    
    private Double graduacion;
    
    private Double velocidadEnBoca;
    
    private Double temperaturaPropelente;
    
    private Double drift;
    
    private Double intervaloVertical;
    
    private Double correccionTotalDeflexion;
    
    private Double explosionHeight;
    
    private Double orientacionMagnetica;
    
    private Double tiempoDeVuelo;
    
    private Double errorPrecisionDistancia;
    
    private Double errorPresicionOrient;
    
    private Double errorPMIDistancia;
    
    private Double errprPMIOrientacion;
    
    private StatusDataGridBuilder() {}
    
    public static StatusDataGridBuilder aStatusDataGrid() {
      return new StatusDataGridBuilder();
    }
    
    public StatusDataGridBuilder withTipoMunicion(String tipoMunicion) {
      this.tipoMunicion = tipoMunicion;
      return this;
    }
    
    public StatusDataGridBuilder withCuadros(Integer cuadros) {
      this.cuadros = cuadros;
      return this;
    }
    
    public StatusDataGridBuilder withCarga(String carga) {
      this.carga = carga;
      return this;
    }
    
    public StatusDataGridBuilder withZona(Integer zona) {
      this.zona = zona;
      return this;
    }
    
    public StatusDataGridBuilder withEspoleta(String espoleta) {
      this.espoleta = espoleta;
      return this;
    }
    
    public StatusDataGridBuilder withGraduacion(Double graduacion) {
      this.graduacion = graduacion;
      return this;
    }
    
    public StatusDataGridBuilder withVelocidadEnBoca(Double velocidadEnBoca) {
      this.velocidadEnBoca = velocidadEnBoca;
      return this;
    }
    
    public StatusDataGridBuilder withTemperaturaPropelente(Double temperaturaPropelente) {
      this.temperaturaPropelente = temperaturaPropelente;
      return this;
    }
    
    public StatusDataGridBuilder withDrift(Double drift) {
      this.drift = drift;
      return this;
    }
    
    public StatusDataGridBuilder withIntervaloVertical(Double intervaloVertical) {
      this.intervaloVertical = intervaloVertical;
      return this;
    }
    
    public StatusDataGridBuilder withCorreccionTotalDeflexion(Double correccionTotalDeflexion) {
      this.correccionTotalDeflexion = correccionTotalDeflexion;
      return this;
    }
    
    public StatusDataGridBuilder withAlturaExplosion(Double explosionHeight) {
      this.explosionHeight = explosionHeight;
      return this;
    }
    
    public StatusDataGridBuilder withOrientacionMagnetica(Double orientacionMagnetica) {
      this.orientacionMagnetica = orientacionMagnetica;
      return this;
    }
    
    public StatusDataGridBuilder withTiempoDeVuelo(Double tiempoDeVuelo) {
      this.tiempoDeVuelo = tiempoDeVuelo;
      return this;
    }
    
    public StatusDataGridBuilder withErrorPrecisionDistancia(Double errorPrecisionDistancia) {
      this.errorPrecisionDistancia = errorPrecisionDistancia;
      return this;
    }
    
    public StatusDataGridBuilder withErrorPresicionOrient(Double errorPresicionOrient) {
      this.errorPresicionOrient = errorPresicionOrient;
      return this;
    }
    
    public StatusDataGridBuilder withErrorPMIDistancia(Double errorPMIDistancia) {
      this.errorPMIDistancia = errorPMIDistancia;
      return this;
    }
    
    public StatusDataGridBuilder withErrprPMIOrientacion(Double errprPMIOrientacion) {
      this.errprPMIOrientacion = errprPMIOrientacion;
      return this;
    }
    
    public StatusDataGrid build() {
      return new StatusDataGrid(this.tipoMunicion, this.cuadros, this.carga, this.zona, this.espoleta, this.graduacion, this.velocidadEnBoca, this.temperaturaPropelente, this.drift, this.intervaloVertical, this.correccionTotalDeflexion, this.explosionHeight, this.orientacionMagnetica, this.tiempoDeVuelo, this.errorPrecisionDistancia, this.errorPresicionOrient, this.errorPMIDistancia, this.errprPMIOrientacion);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusDataGrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */