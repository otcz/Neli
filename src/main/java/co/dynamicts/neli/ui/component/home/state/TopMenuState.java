package co.dynamicts.neli.ui.component.home.state;

import co.dynamicts.neli.ui.component.home.top.menu.BandejaItemStatus;
import co.dynamicts.neli.ui.component.home.top.menu.ItemStatus;

public final class TopMenuState {
  private final ItemStatus temperature;
  
  private final ItemStatus calibracion;
  
  private final ItemStatus trinca;
  
  private final Integer municion;
  
  private final ItemStatus zupt;
  
  private final ItemStatus cms;
  
  private final ItemStatus hms;
  
  private final ItemStatus odometro;
  
  private final ItemStatus radar;
  
  private final ItemStatus punteria;
  
  private final ItemStatus gps;
  
  private final ItemStatus ins;
  
  private final BandejaItemStatus statusBandeja;
  
  public ItemStatus getTemperatura() {
    return this.temperature;
  }
  
  public ItemStatus getCalibracion() {
    return this.calibracion;
  }
  
  public ItemStatus getTrinca() {
    return this.trinca;
  }
  
  public Integer getMunicion() {
    return this.municion;
  }
  
  public ItemStatus getZupt() {
    return this.zupt;
  }
  
  public ItemStatus getCms() {
    return this.cms;
  }
  
  public ItemStatus getHms() {
    return this.hms;
  }
  
  public ItemStatus getOdometro() {
    return this.odometro;
  }
  
  public ItemStatus getRadar() {
    return this.radar;
  }
  
  public ItemStatus getPunteria() {
    return this.punteria;
  }
  
  public ItemStatus getGps() {
    return this.gps;
  }
  
  public ItemStatus getIns() {
    return this.ins;
  }
  
  public BandejaItemStatus getStatusBandeja() {
    return this.statusBandeja;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public TopMenuState(ItemStatus temperature, ItemStatus calibracion, ItemStatus trinca, Integer municion, ItemStatus zupt, ItemStatus cms, ItemStatus hms, ItemStatus odometro, ItemStatus radar, ItemStatus punteria, ItemStatus gps, ItemStatus ins, BandejaItemStatus statusBandeja) {
    this.temperature = temperature;
    this.calibracion = calibracion;
    this.trinca = trinca;
    this.municion = municion;
    this.zupt = zupt;
    this.cms = cms;
    this.hms = hms;
    this.odometro = odometro;
    this.radar = radar;
    this.punteria = punteria;
    this.gps = gps;
    this.ins = ins;
    this.statusBandeja = statusBandeja;
  }
  
  public static final class Builder {
    private ItemStatus temperature;
    
    private ItemStatus calibracion;
    
    private ItemStatus trinca;
    
    private ItemStatus bandeja;
    
    private Integer municion;
    
    private ItemStatus zupt;
    
    private ItemStatus cms;
    
    private ItemStatus hms;
    
    private ItemStatus odometro;
    
    private ItemStatus radar;
    
    private ItemStatus punteria;
    
    private ItemStatus gps;
    
    private ItemStatus ins;
    
    private BandejaItemStatus statusBandeja;
    
    private Builder() {}
    
    public Builder withTemperatura(ItemStatus temperature) {
      this.temperature = temperature;
      return this;
    }
    
    public Builder withCalibracion(ItemStatus calibracion) {
      this.calibracion = calibracion;
      return this;
    }
    
    public Builder withTrinca(ItemStatus trinca) {
      this.trinca = trinca;
      return this;
    }
    
    public Builder withBandeja(ItemStatus bandeja) {
      this.bandeja = bandeja;
      return this;
    }
    
    public Builder withMunicion(Integer municion) {
      this.municion = municion;
      return this;
    }
    
    public Builder withZupt(ItemStatus zupt) {
      this.zupt = zupt;
      return this;
    }
    
    public Builder withCms(ItemStatus cms) {
      this.cms = cms;
      return this;
    }
    
    public Builder withHms(ItemStatus hms) {
      this.hms = hms;
      return this;
    }
    
    public Builder withOdometro(ItemStatus odometro) {
      this.odometro = odometro;
      return this;
    }
    
    public Builder withRadar(ItemStatus radar) {
      this.radar = radar;
      return this;
    }
    
    public Builder withPunteria(ItemStatus punteria) {
      this.punteria = punteria;
      return this;
    }
    
    public Builder withGps(ItemStatus gps) {
      this.gps = gps;
      return this;
    }
    
    public Builder withIns(ItemStatus ins) {
      this.ins = ins;
      return this;
    }
    
    public Builder withStatusBandeja(BandejaItemStatus statusBandeja) {
      this.statusBandeja = statusBandeja;
      return this;
    }
    
    public TopMenuState build() {
      return new TopMenuState(this.temperature, this.calibracion, this.trinca, this.municion, this.zupt, this.cms, this.hms, this.odometro, this.radar, this.punteria, this.gps, this.ins, this.statusBandeja);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\state\TopMenuState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */