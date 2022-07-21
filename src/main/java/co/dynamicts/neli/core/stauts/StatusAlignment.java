package co.dynamicts.neli.core.stauts;

public final class StatusAlignment {
  final Double xPointing;
  
  final Double yPointing;
  
  final Boolean xbad;
  
  final Boolean xMed;
  
  final Boolean xOk;
  
  final Boolean ybad;
  
  final Boolean yMed;
  
  final Boolean yOk;
  
  public StatusAlignment(Double xPointing, Double yPointing, Boolean xbad, Boolean xMed, Boolean xOk, Boolean ybad, Boolean yMed, Boolean yOk) {
    this.xPointing = xPointing;
    this.yPointing = yPointing;
    this.xbad = xbad;
    this.xMed = xMed;
    this.xOk = xOk;
    this.ybad = ybad;
    this.yMed = yMed;
    this.yOk = yOk;
  }
  
  public static final class Builder {
    Double xPointing;
    
    Double yPointing;
    
    Boolean xbad;
    
    Boolean xMed;
    
    Boolean xOk;
    
    Boolean ybad;
    
    Boolean yMed;
    
    Boolean yOk;
    
    public static Builder builder() {
      return new Builder();
    }
    
    public Builder withXPointing(Double xPointing) {
      this.xPointing = xPointing;
      return this;
    }
    
    public Builder withYPointing(Double yPointing) {
      this.yPointing = yPointing;
      return this;
    }
    
    public Builder withXbad(Boolean xbad) {
      this.xbad = xbad;
      return this;
    }
    
    public Builder withXMed(Boolean xMed) {
      this.xMed = xMed;
      return this;
    }
    
    public Builder withXOk(Boolean xOk) {
      this.xOk = xOk;
      return this;
    }
    
    public Builder withYbad(Boolean ybad) {
      this.ybad = ybad;
      return this;
    }
    
    public Builder withYMed(Boolean yMed) {
      this.yMed = yMed;
      return this;
    }
    
    public Builder withYOk(Boolean yOk) {
      this.yOk = yOk;
      return this;
    }
    
    public StatusAlignment build() {
      return new StatusAlignment(this.xPointing, this.yPointing, this.xbad, this.xMed, this.xOk, this.ybad, this.yMed, this.yOk);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */