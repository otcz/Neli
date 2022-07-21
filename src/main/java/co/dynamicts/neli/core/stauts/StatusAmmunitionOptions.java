package co.dynamicts.neli.core.stauts;

import java.util.TreeMap;

public class StatusAmmunitionOptions {
  private TreeMap<String, String> ammunitionType;
  
  private TreeMap<String, String> gunFuseType;
  
  private TreeMap<String, String> propellantType;
  
  private TreeMap<String, String> zona;
  
  private TreeMap<String, String> explosionHeight;
  
  public StatusAmmunitionOptions(TreeMap<String, String> ammunitionType, TreeMap<String, String> gunFuseType, TreeMap<String, String> propellantType, TreeMap<String, String> zona, TreeMap<String, String> explosionHeight) {
    this.ammunitionType = ammunitionType;
    this.gunFuseType = gunFuseType;
    this.propellantType = propellantType;
    this.zona = zona;
    this.explosionHeight = explosionHeight;
  }
  
  public TreeMap<String, String> getAmmunitionType() {
    return this.ammunitionType;
  }
  
  public TreeMap<String, String> getTipoDeEspoleta() {
    return this.gunFuseType;
  }
  
  public TreeMap<String, String> getTipoDePropelente() {
    return this.propellantType;
  }
  
  public TreeMap<String, String> getZona() {
    return this.zona;
  }
  
  public TreeMap<String, String> getAlturaExplosion() {
    return this.explosionHeight;
  }
  
  static class StatusOpcionesMunicionBuilder {
    private TreeMap<String, String> ammunitionType;
    
    private TreeMap<String, String> gunFuseType;
    
    private TreeMap<String, String> propellantType;
    
    private TreeMap<String, String> zona;
    
    private TreeMap<String, String> explosionHeight;
    
    public StatusAmmunitionOptions createEstadoOpcionesMunicion() {
      return new StatusAmmunitionOptions(this.ammunitionType, this.gunFuseType, this.propellantType, this.zona, this.explosionHeight);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusAmmunitionOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */