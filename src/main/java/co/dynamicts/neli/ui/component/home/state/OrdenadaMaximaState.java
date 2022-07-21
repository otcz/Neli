package co.dynamicts.neli.ui.component.home.state;

public final class OrdenadaMaximaState {
  private final Double ordMax;
  
  private final Double ordMaxFt;
  
  private OrdenadaMaximaState(Double ordMax, Double ordMaxFt) {
    if (ordMax != null || ordMaxFt == null)
      ordMaxFt = metrosAPies(ordMax); 
    if (ordMax == null || ordMaxFt == null)
      throw new UnsupportedOperationException("ordMax y ordMaxFt son requeridos, recibidos: " + 
          String.valueOf(ordMax) + " " + String.valueOf(ordMaxFt)); 
    this.ordMax = ordMax;
    this.ordMaxFt = ordMaxFt;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public Double getOrdMax() {
    return this.ordMax;
  }
  
  public Double getOrdMaxFt() {
    return this.ordMaxFt;
  }
  
  public static final class Builder {
    private Double ordMax;
    
    private Double ordMaxFt;
    
    private Builder() {}
    
    public Builder withOrdMax(Double ordMax) {
      this.ordMax = ordMax;
      return this;
    }
    
    public Builder withOrdMaxFt(Double ordMaxFt) {
      this.ordMaxFt = ordMaxFt;
      return this;
    }
    
    public OrdenadaMaximaState build() {
      return new OrdenadaMaximaState(this.ordMax, this.ordMaxFt);
    }
  }
  
  public Double metrosAPies(Double metros) {
    return Double.valueOf(metros.doubleValue() * 3.28084D);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\state\OrdenadaMaximaState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */