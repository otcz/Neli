package co.dynamicts.neli.core.stauts;

public class StatusCPAParameters {
  private String fase0;
  
  private String fase1;
  
  private String fase2;
  
  private String fase3;
  
  private String lIzquierdo;
  
  private String lDerecho;
  
  private String minErrorIzquierda;
  
  private String minErrorDerecha;
  
  private String maxErrorIzquierda;
  
  private String maxErrorDerecha;
  
  private String cpAbajo;
  
  private String cpArriba;
  
  public StatusCPAParameters(String fase0, String fase1, String fase2, String fase3, String lIzquierdo, String lDerecho, String minErrorIzquierda, String minErrorDerecha, String maxErrorIzquierda, String maxErrorDerecha, String cpAbajo, String cpArriba) {
    this.fase0 = fase0;
    this.fase1 = fase1;
    this.fase2 = fase2;
    this.fase3 = fase3;
    this.lIzquierdo = lIzquierdo;
    this.lDerecho = lDerecho;
    this.minErrorIzquierda = minErrorIzquierda;
    this.minErrorDerecha = minErrorDerecha;
    this.maxErrorIzquierda = maxErrorIzquierda;
    this.maxErrorDerecha = maxErrorDerecha;
    this.cpAbajo = cpAbajo;
    this.cpArriba = cpArriba;
  }
  
  public String getFase0() {
    return this.fase0;
  }
  
  public String getFase1() {
    return this.fase1;
  }
  
  public String getFase2() {
    return this.fase2;
  }
  
  public String getFase3() {
    return this.fase3;
  }
  
  public String getlIzquierdo() {
    return this.lIzquierdo;
  }
  
  public String getlDerecho() {
    return this.lDerecho;
  }
  
  public String getMinErrorIzquierda() {
    return this.minErrorIzquierda;
  }
  
  public String getMinErrorDerecha() {
    return this.minErrorDerecha;
  }
  
  public String getMaxErrorIzquierda() {
    return this.maxErrorIzquierda;
  }
  
  public String getMaxErrorDerecha() {
    return this.maxErrorDerecha;
  }
  
  public String getCpAbajo() {
    return this.cpAbajo;
  }
  
  public String getCpArriba() {
    return this.cpArriba;
  }
  
  class StatusParametrosCPABuilder {
    private String fase0;
    
    private String fase1;
    
    private String fase2;
    
    private String fase3;
    
    private String lIzquierdo;
    
    private String lDerecho;
    
    private String minErrorIzquierda;
    
    private String minErrorDerecha;
    
    private String maxErrorIzquierda;
    
    private String maxErrorDerecha;
    
    private String cpAbajo;
    
    private String cpArriba;
    
    public StatusCPAParameters createStatusParametrosCPA() {
      return new StatusCPAParameters(this.fase0, this.fase1, this.fase2, this.fase3, this.lIzquierdo, this.lDerecho, this.minErrorIzquierda, this.minErrorDerecha, this.maxErrorIzquierda, this.maxErrorDerecha, this.cpAbajo, this.cpArriba);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusCPAParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */