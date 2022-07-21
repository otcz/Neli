package co.dynamicts.neli.core.stauts;

public class StatusNewMovingTarget {
  private String latDirection;
  
  private String longDirection;
  
  private String longDegrees;
  
  private String longInchs;
  
  private String longInch;
  
  private String latDegrees;
  
  private String latInchs;
  
  private String latInch;
  
  private String altura;
  
  private String azumut;
  
  private String velocidad;
  
  private StatusNewMovingTarget(String latDirection, String longDirection, String longDegrees, String longInchs, String longInch, String latDegrees, String latInchs, String latInch, String altura, String azumut, String velocidad) {
    this.latDirection = latDirection;
    this.longDirection = longDirection;
    this.longDegrees = longDegrees;
    this.longInchs = longInchs;
    this.longInch = longInch;
    this.latDegrees = latDegrees;
    this.latInchs = latInchs;
    this.latInch = latInch;
    this.altura = altura;
    this.azumut = azumut;
    this.velocidad = velocidad;
  }
  
  public String getLatDirection() {
    return this.latDirection;
  }
  
  public String getLongDirection() {
    return this.longDirection;
  }
  
  public String getLongDegrees() {
    return this.longDegrees;
  }
  
  public String getLongInchs() {
    return this.longInchs;
  }
  
  public String getLongInch() {
    return this.longInch;
  }
  
  public String getLatDegrees() {
    return this.latDegrees;
  }
  
  public String getLatInchs() {
    return this.latInchs;
  }
  
  public String getLatInch() {
    return this.latInch;
  }
  
  public String getAltura() {
    return this.altura;
  }
  
  public String getAzumut() {
    return this.azumut;
  }
  
  public String getVelocidad() {
    return this.velocidad;
  }
  
  public String toString() {
    return "StatusNewMovingTarget{Direction=" + this.latDirection + ", Direction=" + this.longDirection + ", longDegrees='" + this.longDegrees + '\'' + ", longInchs='" + this.longInchs + '\'' + ", longInch='" + this.longInch + '\'' + ", latDegrees='" + this.latDegrees + '\'' + ", latInchs='" + this.latInchs + '\'' + ", latInch='" + this.latInch + '\'' + ", altura='" + this.altura + '\'' + ", azumut='" + this.azumut + '\'' + ", velocidad='" + this.velocidad + '\'' + '}';
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private String latDirection;
    
    private String longDirection;
    
    private String longDegrees;
    
    private String longInchs;
    
    private String longInch;
    
    private String latDegrees;
    
    private String latInchs;
    
    private String latInch;
    
    private String altura;
    
    private String azumut;
    
    private String velocidad;
    
    private Builder() {}
    
    public static Builder aStatusNewMovingTarget() {
      return new Builder();
    }
    
    public Builder withLatDirection(String latDirection) {
      this.latDirection = latDirection;
      return this;
    }
    
    public Builder withLongDirection(String longDirection) {
      this.longDirection = longDirection;
      return this;
    }
    
    public Builder withLongDegrees(String longDegrees) {
      this.longDegrees = longDegrees;
      return this;
    }
    
    public Builder withLongInchs(String longInchs) {
      this.longInchs = longInchs;
      return this;
    }
    
    public Builder withLongInch(String longInch) {
      this.longInch = longInch;
      return this;
    }
    
    public Builder withLatDegrees(String latDegrees) {
      this.latDegrees = latDegrees;
      return this;
    }
    
    public Builder withLatInchs(String latInchs) {
      this.latInchs = latInchs;
      return this;
    }
    
    public Builder withLatInch(String latInch) {
      this.latInch = latInch;
      return this;
    }
    
    public Builder withAltura(String altura) {
      this.altura = altura;
      return this;
    }
    
    public Builder withAzumut(String azumut) {
      this.azumut = azumut;
      return this;
    }
    
    public Builder withVelocidad(String velocidad) {
      this.velocidad = velocidad;
      return this;
    }
    
    public StatusNewMovingTarget build() {
      return new StatusNewMovingTarget(this.latDirection, this.longDirection, this.longDegrees, this.longInchs, this.longInch, this.latDegrees, this.latInchs, this.latInch, this.altura, this.azumut, this.velocidad);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusNewMovingTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */