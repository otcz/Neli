package co.dynamicts.neli.ui.component.home.state;

import java.util.Objects;

public class GraficaAlineacionState {
  private boolean okX;
  
  private boolean medX;
  
  private boolean badX;
  
  private boolean okY;
  
  private boolean medY;
  
  private boolean badY;
  
  private double coordinateX;
  
  private double coordinateY;
  
  public boolean isOkX() {
    return this.okX;
  }
  
  public boolean isMedX() {
    return this.medX;
  }
  
  public boolean isBadX() {
    return this.badX;
  }
  
  public boolean isOkY() {
    return this.okY;
  }
  
  public boolean isMedY() {
    return this.medY;
  }
  
  public boolean isBadY() {
    return this.badY;
  }
  
  public double getCoordinateX() {
    return this.coordinateX;
  }
  
  public double getCoordinateY() {
    return this.coordinateY;
  }
  
  public GraficaAlineacionState(boolean okX, boolean medX, boolean badX, boolean okY, boolean medY, boolean badY, double coordinateX, double coordinateY) {
    this.okX = okX;
    this.medX = medX;
    this.badX = badX;
    this.okY = okY;
    this.medY = medY;
    this.badY = badY;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }
  
  public static GraficaAlineacionStateBuilder builder() {
    return new GraficaAlineacionStateBuilder();
  }
  
  public static final class GraficaAlineacionStateBuilder {
    private boolean okX;
    
    private boolean medX;
    
    private boolean badX;
    
    private boolean okY;
    
    private boolean medY;
    
    private boolean badY;
    
    private double coordinateX;
    
    private double coordinateY;
    
    private GraficaAlineacionStateBuilder() {}
    
    public static GraficaAlineacionStateBuilder aGraficaAlineacionState() {
      return new GraficaAlineacionStateBuilder();
    }
    
    public GraficaAlineacionStateBuilder withOkX(boolean okX) {
      this.okX = okX;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withMedX(boolean medX) {
      this.medX = medX;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withBadX(boolean badX) {
      this.badX = badX;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withOkY(boolean okY) {
      this.okY = okY;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withMedY(boolean medY) {
      this.medY = medY;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withBadY(boolean badY) {
      this.badY = badY;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withCoordinateX(double coordinateX) {
      this.coordinateX = coordinateX;
      return this;
    }
    
    public GraficaAlineacionStateBuilder withCoordinateY(double coordinateY) {
      this.coordinateY = coordinateY;
      return this;
    }
    
    public GraficaAlineacionState build() {
      return new GraficaAlineacionState(this.okX, this.medX, this.badX, this.okY, this.medY, this.badY, this.coordinateX, this.coordinateY);
    }
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    GraficaAlineacionState that = (GraficaAlineacionState)o;
    return (this.okX == that.okX && this.medX == that.medX && this.badX == that.badX && this.okY == that.okY && this.medY == that.medY && this.badY == that.badY && 
      
      Double.compare(that.coordinateX, this.coordinateX) == 0 && 
      Double.compare(that.coordinateY, this.coordinateY) == 0);
  }
  
  public int hashCode() {
    return Objects.hash(new Object[] { Boolean.valueOf(this.okX), Boolean.valueOf(this.medX), Boolean.valueOf(this.badX), Boolean.valueOf(this.okY), Boolean.valueOf(this.medY), Boolean.valueOf(this.badY), Double.valueOf(this.coordinateX), Double.valueOf(this.coordinateY) });
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\state\GraficaAlineacionState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */