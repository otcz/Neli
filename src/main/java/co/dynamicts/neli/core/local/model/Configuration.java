package co.dynamicts.neli.core.local.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Configuration {
  @DatabaseField(id = true)
  private String language;
  
  @DatabaseField(canBeNull = false)
  private boolean firstTime;
  
  @DatabaseField(canBeNull = false)
  private String sistema;
  
  @DatabaseField(canBeNull = false)
  private String pieceNumber;
  
  @DatabaseField(canBeNull = false)
  private String uniDistancia;
  
  @DatabaseField(canBeNull = false)
  private String uniAngulo;
  
  @DatabaseField(canBeNull = false)
  private String uniCoordenada;
  
  @DatabaseField(canBeNull = false)
  private String tipoMunicion;
  
  @DatabaseField(canBeNull = false)
  private int cantidadMunicion;
  
  @DatabaseField(canBeNull = false)
  private int indexEspoletaMunicion;
  
  @DatabaseField(canBeNull = false)
  private double alturaExplosionMunicion;
  
  @DatabaseField(canBeNull = false)
  private int indexCuadrosMunicion;
  
  @DatabaseField(canBeNull = false)
  private int numeroZona;
  
  @DatabaseField(canBeNull = false)
  private double tempMunicion;
  
  @DatabaseField(canBeNull = false)
  private String modoZUPT;
  
  @DatabaseField(dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss")
  private Date date;
  
  public String getLanguage() {
    return this.language;
  }
  
  public void setLanguage(String language) {
    this.language = language;
  }
  
  public boolean isFirstTime() {
    return this.firstTime;
  }
  
  public void setFirstTime(boolean firstTime) {
    this.firstTime = firstTime;
  }
  
  public String getSistema() {
    return this.sistema;
  }
  
  public void setSistema(String sistema) {
    this.sistema = sistema;
  }
  
  public String getPieceNumber() {
    return this.pieceNumber;
  }
  
  public void setPieceNumber(String pieceNumber) {
    this.pieceNumber = pieceNumber;
  }
  
  public String getUniDistancia() {
    return this.uniDistancia;
  }
  
  public void setUniDistancia(String uniDistancia) {
    this.uniDistancia = uniDistancia;
  }
  
  public String getUniAngulo() {
    return this.uniAngulo;
  }
  
  public void setUniAngulo(String uniAngulo) {
    this.uniAngulo = uniAngulo;
  }
  
  public String getUniCoordenada() {
    return this.uniCoordenada;
  }
  
  public void setUniCoordenada(String uniCoordenada) {
    this.uniCoordenada = uniCoordenada;
  }
  
  public String getTipoMunicion() {
    return this.tipoMunicion;
  }
  
  public void setTipoMunicion(String tipoMunicion) {
    this.tipoMunicion = tipoMunicion;
  }
  
  public int getCantidadMunicion() {
    return this.cantidadMunicion;
  }
  
  public void setCantidadMunicion(int cantidadMunicion) {
    this.cantidadMunicion = cantidadMunicion;
  }
  
  public int getIndexEspoletaMunicion() {
    return this.indexEspoletaMunicion;
  }
  
  public void setIndexEspoletaMunicion(int indexEspoletaMunicion) {
    this.indexEspoletaMunicion = indexEspoletaMunicion;
  }
  
  public double getAlturaExplosionMunicion() {
    return this.alturaExplosionMunicion;
  }
  
  public void setAlturaExplosionMunicion(double alturaExplosionMunicion) {
    this.alturaExplosionMunicion = alturaExplosionMunicion;
  }
  
  public int getIndexCuadrosMunicion() {
    return this.indexCuadrosMunicion;
  }
  
  public void setIndexCuadrosMunicion(int indexCuadrosMunicion) {
    this.indexCuadrosMunicion = indexCuadrosMunicion;
  }
  
  public int getNumeroZona() {
    return this.numeroZona;
  }
  
  public void setNumeroZona(int numeroZona) {
    this.numeroZona = numeroZona;
  }
  
  public double getTempMunicion() {
    return this.tempMunicion;
  }
  
  public void setTempMunicion(double tempMunicion) {
    this.tempMunicion = tempMunicion;
  }
  
  public String getModoZUPT() {
    return this.modoZUPT;
  }
  
  public void setModoZUPT(String modoZUPT) {
    this.modoZUPT = modoZUPT;
  }
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */