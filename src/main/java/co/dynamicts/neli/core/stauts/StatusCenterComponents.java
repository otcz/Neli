package co.dynamicts.neli.core.stauts;

public class StatusCenterComponents {
  final Double alcance;
  
  final Double orientacion;
  
  final Double elevacion;
  
  final Double limiteIzquierda;
  
  final Double limiteDerecha;
  
  final Double alcanceDes;
  
  final Double azimut;
  
  final Double azimutDes;
  
  final Double orientacionDes;
  
  final Double elevacionDes;
  
  final Double limiteSuperior;
  
  final Double limiteInferior;
  
  final Boolean isXRigth;
  
  final Boolean isXLeft;
  
  final Boolean isYdown;
  
  final Boolean isYup;
  
  final Boolean isLimTiroDerIsBad;
  
  final Boolean isLimTiroIzqIsBad;
  
  final Boolean isLimTiroSupIsBad;
  
  final Boolean isLimTiroInfIsBad;
  
  final String colorElevacion;
  
  final String colorOrientacion;
  
  public StatusCenterComponents(Double azimutDes, Double alcance, Double orientacion, Double elevacion, Double limiteIzquierda, Double limiteDerecha, Double alcanceDes, Double azimut, Double orientacionDes, Double elevacionDes, Double limiteSuperior, Double limiteInferior, Boolean isXRigth, Boolean isXLeft, Boolean isYdown, Boolean isYup, Boolean isLimTiroDerIsBad, Boolean isLimTiroIzqIsBad, Boolean isLimTiroSupIsBad, Boolean isLimTiroInfIsBad, String colorElevacion, String colorOrientacion) {
    this.azimutDes = azimutDes;
    this.alcance = alcance;
    this.orientacion = orientacion;
    this.elevacion = elevacion;
    this.limiteIzquierda = limiteIzquierda;
    this.limiteDerecha = limiteDerecha;
    this.alcanceDes = alcanceDes;
    this.azimut = azimut;
    this.orientacionDes = orientacionDes;
    this.elevacionDes = elevacionDes;
    this.limiteSuperior = limiteSuperior;
    this.limiteInferior = limiteInferior;
    this.isXRigth = isXRigth;
    this.isXLeft = isXLeft;
    this.isYdown = isYdown;
    this.isYup = isYup;
    this.isLimTiroDerIsBad = isLimTiroDerIsBad;
    this.isLimTiroIzqIsBad = isLimTiroIzqIsBad;
    this.isLimTiroSupIsBad = isLimTiroSupIsBad;
    this.isLimTiroInfIsBad = isLimTiroInfIsBad;
    this.colorElevacion = colorElevacion;
    this.colorOrientacion = colorOrientacion;
  }
  
  public String getColorElevacion() {
    return this.colorElevacion;
  }
  
  public String getColorOrientacion() {
    return this.colorOrientacion;
  }
  
  public Double getAlcance() {
    return this.alcance;
  }
  
  public Double getOrientacion() {
    return this.orientacion;
  }
  
  public Double getElevacion() {
    return this.elevacion;
  }
  
  public Double getLimiteIzquierda() {
    return this.limiteIzquierda;
  }
  
  public Double getLimiteDerecha() {
    return this.limiteDerecha;
  }
  
  public Double getAlcanceDes() {
    return this.alcanceDes;
  }
  
  public Double getAzimut() {
    return this.azimut;
  }
  
  public Double getOrientacionDes() {
    return this.orientacionDes;
  }
  
  public Double getElevacionDes() {
    return this.elevacionDes;
  }
  
  public Double getLimiteSuperior() {
    return this.limiteSuperior;
  }
  
  public Double getLimiteInferior() {
    return this.limiteInferior;
  }
  
  public Boolean getXRigth() {
    return this.isXRigth;
  }
  
  public Boolean getXLeft() {
    return this.isXLeft;
  }
  
  public Boolean getYdown() {
    return this.isYdown;
  }
  
  public Boolean getYup() {
    return this.isYup;
  }
  
  public Boolean getLimTiroDerIsBad() {
    return this.isLimTiroDerIsBad;
  }
  
  public Boolean getLimTiroIzqIsBad() {
    return this.isLimTiroIzqIsBad;
  }
  
  public Boolean getLimTiroSupIsBad() {
    return this.isLimTiroSupIsBad;
  }
  
  public Boolean getLimTiroInfIsBad() {
    return this.isLimTiroInfIsBad;
  }
  
  public Double getAzimutDes() {
    return this.azimutDes;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    Double alcance;
    
    Double orientacion;
    
    Double elevacion;
    
    Double limiteIzquierda;
    
    Double limiteDerecha;
    
    Double alcanceDes;
    
    Double azimut;
    
    Double orientacionDes;
    
    Double elevacionDes;
    
    Double limiteSuperior;
    
    Double limiteInferior;
    
    Boolean isXRigth;
    
    Boolean isXLeft;
    
    Boolean isYdown;
    
    Boolean isYup;
    
    Boolean isLimTiroDerIsBad;
    
    Boolean isLimTiroIzqIsBad;
    
    Boolean isLimTiroSupIsBad;
    
    Boolean isLimTiroInfIsBad;
    
    Double azimutDes;
    
    String colorElevacion;
    
    String colorOrientacion;
    
    private Builder() {}
    
    public static Builder aStatusCenterComponents() {
      return new Builder();
    }
    
    public Builder withYStatus(String colorElevacion) {
      this.colorElevacion = colorElevacion;
      return this;
    }
    
    public Builder withXStatus(String colorOrientacion) {
      this.colorOrientacion = colorOrientacion;
      return this;
    }
    
    public Builder withAlcance(Double alcance) {
      this.alcance = alcance;
      return this;
    }
    
    public Builder withAzimutDes(Double azimutDes) {
      this.azimutDes = azimutDes;
      return this;
    }
    
    public Builder withOrientacion(Double orientacion) {
      this.orientacion = orientacion;
      return this;
    }
    
    public Builder withElevacion(Double elevacion) {
      this.elevacion = elevacion;
      return this;
    }
    
    public Builder withLimiteIzquierda(Double limiteIzquierda) {
      this.limiteIzquierda = limiteIzquierda;
      return this;
    }
    
    public Builder withLimiteDerecha(Double limiteDerecha) {
      this.limiteDerecha = limiteDerecha;
      return this;
    }
    
    public Builder withAlcanceDes(Double alcanceDes) {
      this.alcanceDes = alcanceDes;
      return this;
    }
    
    public Builder withAzimut(Double azimut) {
      this.azimut = azimut;
      return this;
    }
    
    public Builder withOrientacionDes(Double orientacionDes) {
      this.orientacionDes = orientacionDes;
      return this;
    }
    
    public Builder withElevacionDes(Double elevacionDes) {
      this.elevacionDes = elevacionDes;
      return this;
    }
    
    public Builder withLimiteSuperior(Double limiteSuperior) {
      this.limiteSuperior = limiteSuperior;
      return this;
    }
    
    public Builder withLimiteInferior(Double limiteInferior) {
      this.limiteInferior = limiteInferior;
      return this;
    }
    
    public Builder withIsXRigth(Boolean isXRigth) {
      this.isXRigth = isXRigth;
      return this;
    }
    
    public Builder withIsXLeft(Boolean isXLeft) {
      this.isXLeft = isXLeft;
      return this;
    }
    
    public Builder withIsYdown(Boolean isYdown) {
      this.isYdown = isYdown;
      return this;
    }
    
    public Builder withIsYup(Boolean isYup) {
      this.isYup = isYup;
      return this;
    }
    
    public Builder withIsLimTiroDerIsBad(Boolean isLimTiroDerIsBad) {
      this.isLimTiroDerIsBad = isLimTiroDerIsBad;
      return this;
    }
    
    public Builder withIsLimTiroIzqIsBad(Boolean isLimTiroIzqIsBad) {
      this.isLimTiroIzqIsBad = isLimTiroIzqIsBad;
      return this;
    }
    
    public Builder withIsLimTiroSupIsBad(Boolean isLimTiroSupIsBad) {
      this.isLimTiroSupIsBad = isLimTiroSupIsBad;
      return this;
    }
    
    public Builder withIsLimTiroInfIsBad(Boolean isLimTiroInfIsBad) {
      this.isLimTiroInfIsBad = isLimTiroInfIsBad;
      return this;
    }
    
    public StatusCenterComponents build() {
      return new StatusCenterComponents(this.azimutDes, this.alcance, this.orientacion, this.elevacion, this.limiteIzquierda, this.limiteDerecha, this.alcanceDes, this.azimut, this.orientacionDes, this.elevacionDes, this.limiteSuperior, this.limiteInferior, this.isXRigth, this.isXLeft, this.isYdown, this.isYup, this.isLimTiroDerIsBad, this.isLimTiroIzqIsBad, this.isLimTiroSupIsBad, this.isLimTiroInfIsBad, this.colorElevacion, this.colorOrientacion);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusCenterComponents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */