package co.dynamicts.neli.ui.component.home.state;

import co.dynamicts.neli.core.angle.Angle;

import java.util.Optional;

public final class GraficaDireccionState {
  private final Angle cannonLeftLimit;
  
  private final Angle cannonRightLimit;
  
  private final Angle diana;
  
  private final Optional<Angle> weaponLeftLimit;
  
  private final Optional<Angle> weaponRightLimit;
  
  private final Angle azimuth;
  
  private final Angle escalaExterna;
  
  private final Angle escalaInterna;
  
  private final Boolean trinca;
  
  public GraficaDireccionState(Angle cannonLeftLimit, Angle cannonRightLimit, Angle diana, Optional<Angle> weaponLeftLimit, Optional<Angle> weaponRightLimit, Angle azimuth, Angle escalaExterna, Angle escalaInterna, Boolean trinca) {
    this.cannonLeftLimit = cannonLeftLimit;
    this.cannonRightLimit = cannonRightLimit;
    this.diana = diana;
    this.weaponLeftLimit = weaponLeftLimit;
    this.weaponRightLimit = weaponRightLimit;
    this.azimuth = azimuth;
    this.escalaExterna = escalaExterna;
    this.escalaInterna = escalaInterna;
    this.trinca = trinca;
  }
  
  public Angle getCannonLeftLimit() {
    return this.cannonLeftLimit;
  }
  
  public Angle getCannonRightLimit() {
    return this.cannonRightLimit;
  }
  
  public Optional<Angle> getWeaponLeftLimit() {
    return this.weaponLeftLimit;
  }
  
  public Optional<Angle> getWeaponRightLimit() {
    return this.weaponRightLimit;
  }
  
  public Boolean getTrinca() {
    return this.trinca;
  }
  
  public Angle getAzimuth() {
    return this.azimuth;
  }
  
  public Angle getDiana() {
    return this.diana;
  }
  
  public Angle getEscalaExterna() {
    return this.escalaExterna;
  }
  
  public Angle getEscalaInterna() {
    return this.escalaInterna;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private Angle cannonLeftLimit;
    
    private Angle cannonRightLimit;
    
    private Angle diana;
    
    private Optional<Angle> weaponLeftLimit = Optional.empty();
    
    private Optional<Angle> weaponRightLimit = Optional.empty();
    
    private Angle azimuth;
    
    private Angle escalaExterna;
    
    private Angle escalaInterna;
    
    private Boolean trinca;
    
    public static Builder aGraficaDireccionState() {
      return new Builder();
    }
    
    public Builder withCannonLeftLimit(Angle cannonLeftLimit) {
      this.cannonLeftLimit = cannonLeftLimit;
      return this;
    }
    
    public Builder withCannonRightLimit(Angle cannonRightLimit) {
      this.cannonRightLimit = cannonRightLimit;
      return this;
    }
    
    public Builder withDiana(Angle diana) {
      this.diana = diana;
      return this;
    }
    
    public Builder withWeaponLeftLimit(Optional<Angle> weaponLeftLimit) {
      this.weaponLeftLimit = weaponLeftLimit;
      return this;
    }
    
    public Builder withWeaponRightLimit(Optional<Angle> weaponRightLimit) {
      this.weaponRightLimit = weaponRightLimit;
      return this;
    }
    
    public Builder withAzimuth(Angle azimuth) {
      this.azimuth = azimuth;
      return this;
    }
    
    public Builder withEscalaExterna(Angle escalaExterna) {
      this.escalaExterna = escalaExterna;
      return this;
    }
    
    public Builder withEscalaInterna(Angle escalaInterna) {
      this.escalaInterna = escalaInterna;
      return this;
    }
    
    public Builder withTrinca(Boolean trinca) {
      this.trinca = trinca;
      return this;
    }
    
    public GraficaDireccionState build() {
      return new GraficaDireccionState(this.cannonLeftLimit, this.cannonRightLimit, this.diana, this.weaponLeftLimit, this.weaponRightLimit, this.azimuth, this.escalaExterna, this.escalaInterna, this.trinca);
    }
    
    private Builder() {}
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\state\GraficaDireccionState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */