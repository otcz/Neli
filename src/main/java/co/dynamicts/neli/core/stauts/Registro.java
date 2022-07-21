package co.dynamicts.neli.core.stauts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Registro {
  private StringProperty municion;
  
  private StringProperty zona;
  
  private StringProperty fecha;
  
  private StringProperty temperatura;
  
  private StringProperty velocidad;
  
  public Registro(StringProperty municion, StringProperty zona, StringProperty fecha, StringProperty temperatura, StringProperty velocidad) {
    this.municion = municion;
    this.zona = zona;
    this.fecha = fecha;
    this.temperatura = temperatura;
    this.velocidad = velocidad;
  }
  
  public Registro(String municion, String zona, String fecha, String temperatura, String velocidad) {
    municionProperty();
    setMunicion(municion);
    zonaProperty();
    setZona(zona);
    fechaProperty();
    setFecha(fecha);
    temperaturaProperty();
    setTemperatura(temperatura);
    velocidadProperty();
    setVelocidad(velocidad);
  }
  
  public void setVelocidad(String value) {
    velocidadProperty().set(value);
  }
  
  public String getVelocidad() {
    return velocidadProperty().get();
  }
  
  public StringProperty velocidadProperty() {
    if (this.velocidad == null)
      this.velocidad = new SimpleStringProperty(this, "firstName"); 
    return this.velocidad;
  }
  
  public void setTemperatura(String value) {
    temperaturaProperty().set(value);
  }
  
  public String getTemperatura() {
    return temperaturaProperty().get();
  }
  
  public StringProperty temperaturaProperty() {
    if (this.temperatura == null)
      this.temperatura = new SimpleStringProperty(this, "firstName"); 
    return this.temperatura;
  }
  
  public void setFecha(String value) {
    fechaProperty().set(value);
  }
  
  public String getFecha() {
    return fechaProperty().get();
  }
  
  public StringProperty fechaProperty() {
    if (this.fecha == null)
      this.fecha = new SimpleStringProperty(this, "firstName"); 
    return this.fecha;
  }
  
  public void setZona(String value) {
    zonaProperty().set(value);
  }
  
  public String getZona() {
    return zonaProperty().get();
  }
  
  public StringProperty zonaProperty() {
    if (this.zona == null)
      this.zona = new SimpleStringProperty(this, "firstName"); 
    return this.zona;
  }
  
  public void setMunicion(String value) {
    municionProperty().set(value);
  }
  
  public String getMunicion() {
    return municionProperty().get();
  }
  
  public StringProperty municionProperty() {
    if (this.municion == null)
      this.municion = new SimpleStringProperty(this, "firstName"); 
    return this.municion;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\Registro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */