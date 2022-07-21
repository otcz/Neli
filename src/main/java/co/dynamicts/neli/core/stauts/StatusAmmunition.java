package co.dynamicts.neli.core.stauts;

public class StatusAmmunition {
  private String ammunition;
  
  private String funFuse;
  
  private String propellant;
  
  private String zone;
  
  private String temperature;
  
  private String explosionHeight;
  
  private String squareQuanty;
  
  private StatusAmmunition(String ammunition, String funFuse, String propellant, String squareQuanty, String zone, String temperature, String explosionHeight) {
    this.ammunition = ammunition;
    this.funFuse = funFuse;
    this.propellant = propellant;
    this.squareQuanty = squareQuanty;
    this.zone = zone;
    this.explosionHeight = explosionHeight;
    this.temperature = temperature;
  }
  
  public String toString() {
    return "StatusAmmunition{ammunition='" + this.ammunition + '\'' + ", funFuse='" + this.funFuse + '\'' + ", propellant='" + this.propellant + '\'' + ", squareQuanty='" + this.squareQuanty + '\'' + ", zone='" + this.zone + '\'' + ", temperature='" + this.temperature + '\'' + ", explosionHeight='" + this.explosionHeight + '\'' + '}';
  }
  
  public String getAmmunition() {
    return this.ammunition;
  }
  
  public void setAmmunition(String ammunition) {
    this.ammunition = ammunition;
  }
  
  public String getFunFuse() {
    return this.funFuse;
  }
  
  public void setFunFuse(String funFuse) {
    this.funFuse = funFuse;
  }
  
  public String getPropellant() {
    return this.propellant;
  }
  
  public void setPropellant(String propellant) {
    this.propellant = propellant;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public void setZone(String zone) {
    this.zone = zone;
  }
  
  public String getAlturaExplosion() {
    return this.explosionHeight;
  }
  
  public void setAlturaExplosion(String explosionHeight) {
    this.explosionHeight = explosionHeight;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private String municion;
    
    private String espoleta;
    
    private String propelente;
    
    private String zona;
    
    private String temperatura;
    
    private String explosionHeight;
    
    private String squareQuanty;
    
    private Builder() {}
    
    public static Builder aStatusAmmunition() {
      return new Builder();
    }
    
    public Builder withAmmunition(String municion) {
      this.municion = municion;
      return this;
    }
    
    public Builder withGunFuse(String espoleta) {
      this.espoleta = espoleta;
      return this;
    }
    
    public Builder withPropellant(String propelente) {
      this.propelente = propelente;
      return this;
    }
    
    public Builder withZone(String zona) {
      this.zona = zona;
      return this;
    }
    
    public Builder withTemperature(String temperatura) {
      this.temperatura = temperatura;
      return this;
    }
    
    public Builder withSquare(String squares) {
      this.temperatura = this.temperatura;
      return this;
    }
    
    public Builder withExplosionHeight(String explosionHeight) {
      this.explosionHeight = explosionHeight;
      return this;
    }
    
    public StatusAmmunition build() {
      return new StatusAmmunition(this.municion, this.espoleta, this.propelente, this.squareQuanty, this.zona, this.temperatura, this.explosionHeight);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusAmmunition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */