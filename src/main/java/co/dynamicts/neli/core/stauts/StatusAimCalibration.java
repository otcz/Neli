package co.dynamicts.neli.core.stauts;

public class StatusAimCalibration {
  private boolean objetivoLocalizado;
  
  private boolean calibracionOrientacion;
  
  private boolean finalCarrera;
  
  private boolean errorComunicacion;
  
  private boolean primerMontajePieza;
  
  private boolean tuboFuera;
  
  private boolean alarmaMovimiento;
  
  private boolean objetivoNoLocalizado;
  
  private boolean calibracionElevacion;
  
  private boolean finalRecorrido;
  
  private boolean modoSincronizado;
  
  private boolean secuenciaComandar;
  
  private boolean matrizCalculada;
  
  private boolean errorDeOffset;
  
  public StatusAimCalibration() {
    this.objetivoLocalizado = true;
    this.calibracionOrientacion = false;
    this.finalCarrera = false;
    this.errorComunicacion = false;
    this.primerMontajePieza = false;
    this.tuboFuera = false;
    this.alarmaMovimiento = false;
    this.objetivoNoLocalizado = false;
    this.calibracionElevacion = false;
    this.finalRecorrido = false;
    this.modoSincronizado = false;
    this.secuenciaComandar = false;
    this.matrizCalculada = false;
    this.errorDeOffset = false;
  }
  
  private StatusAimCalibration(boolean objetivoLocalizado, boolean calibracionOrientacion, boolean finalCarrera, boolean errorComunicacion, boolean primerMontajePieza, boolean tuboFuera, boolean alarmaMovimiento, boolean objetivoNoLocalizado, boolean calibracionElevacion, boolean finalRecorrido, boolean modoSincronizado, boolean secuenciaComandar, boolean matrizCalculada, boolean errorDeOffset) {
    this.objetivoLocalizado = objetivoLocalizado;
    this.calibracionOrientacion = calibracionOrientacion;
    this.finalCarrera = finalCarrera;
    this.errorComunicacion = errorComunicacion;
    this.primerMontajePieza = primerMontajePieza;
    this.tuboFuera = tuboFuera;
    this.alarmaMovimiento = alarmaMovimiento;
    this.objetivoNoLocalizado = objetivoNoLocalizado;
    this.calibracionElevacion = calibracionElevacion;
    this.finalRecorrido = finalRecorrido;
    this.modoSincronizado = modoSincronizado;
    this.secuenciaComandar = secuenciaComandar;
    this.matrizCalculada = matrizCalculada;
    this.errorDeOffset = errorDeOffset;
  }
  
  public boolean isObjetivoLocalizado() {
    return this.objetivoLocalizado;
  }
  
  public boolean isCalibracionOrientacion() {
    return this.calibracionOrientacion;
  }
  
  public boolean isFinalCarrera() {
    return this.finalCarrera;
  }
  
  public boolean isErrorComunicacion() {
    return this.errorComunicacion;
  }
  
  public boolean isPrimerMontajePieza() {
    return this.primerMontajePieza;
  }
  
  public boolean isTuboFuera() {
    return this.tuboFuera;
  }
  
  public boolean isAlarmaMovimiento() {
    return this.alarmaMovimiento;
  }
  
  public boolean isObjetivoNoLocalizado() {
    return this.objetivoNoLocalizado;
  }
  
  public boolean isCalibracionElevacion() {
    return this.calibracionElevacion;
  }
  
  public boolean isFinalRecorrido() {
    return this.finalRecorrido;
  }
  
  public boolean isModoSincronizado() {
    return this.modoSincronizado;
  }
  
  public boolean isSecuenciaComandar() {
    return this.secuenciaComandar;
  }
  
  public boolean isMatrizCalculada() {
    return this.matrizCalculada;
  }
  
  public boolean isErrorDeOffset() {
    return this.errorDeOffset;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private boolean objetivoLocalizado;
    
    private boolean calibracionOrientacion;
    
    private boolean finalCarrera;
    
    private boolean errorComunicacion;
    
    private boolean primerMontajePieza;
    
    private boolean tuboFuera;
    
    private boolean alarmaMovimiento;
    
    private boolean objetivoNoLocalizado;
    
    private boolean calibracionElevacion;
    
    private boolean finalRecorrido;
    
    private boolean modoSincronizado;
    
    private boolean secuenciaComandar;
    
    private boolean matrizCalculada;
    
    private boolean errorDeOffset;
    
    private Builder() {}
    
    public static Builder aStatusAimCalibration() {
      return new Builder();
    }
    
    public Builder withObjetivoLocalizado(boolean objetivoLocalizado) {
      this.objetivoLocalizado = objetivoLocalizado;
      return this;
    }
    
    public Builder withCalibracionOrientacion(boolean calibracionOrientacion) {
      this.calibracionOrientacion = calibracionOrientacion;
      return this;
    }
    
    public Builder withFinalCarrera(boolean finalCarrera) {
      this.finalCarrera = finalCarrera;
      return this;
    }
    
    public Builder withErrorComunicacion(boolean errorComunicacion) {
      this.errorComunicacion = errorComunicacion;
      return this;
    }
    
    public Builder withPrimerMontajePieza(boolean primerMontajePieza) {
      this.primerMontajePieza = primerMontajePieza;
      return this;
    }
    
    public Builder withTuboFuera(boolean tuboFuera) {
      this.tuboFuera = tuboFuera;
      return this;
    }
    
    public Builder withAlarmaMovimiento(boolean alarmaMovimiento) {
      this.alarmaMovimiento = alarmaMovimiento;
      return this;
    }
    
    public Builder withObjetivoNoLocalizado(boolean objetivoNoLocalizado) {
      this.objetivoNoLocalizado = objetivoNoLocalizado;
      return this;
    }
    
    public Builder withCalibracionElevacion(boolean calibracionElevacion) {
      this.calibracionElevacion = calibracionElevacion;
      return this;
    }
    
    public Builder withFinalRecorrido(boolean finalRecorrido) {
      this.finalRecorrido = finalRecorrido;
      return this;
    }
    
    public Builder withModoSincronizado(boolean modoSincronizado) {
      this.modoSincronizado = modoSincronizado;
      return this;
    }
    
    public Builder withSecuenciaComandar(boolean secuenciaComandar) {
      this.secuenciaComandar = secuenciaComandar;
      return this;
    }
    
    public Builder withMatrizCalculada(boolean matrizCalculada) {
      this.matrizCalculada = matrizCalculada;
      return this;
    }
    
    public Builder withErrorDeOffset(boolean errorDeOffset) {
      this.errorDeOffset = errorDeOffset;
      return this;
    }
    
    public StatusAimCalibration build() {
      return new StatusAimCalibration(this.objetivoLocalizado, this.calibracionOrientacion, this.finalCarrera, this.errorComunicacion, this.primerMontajePieza, this.tuboFuera, this.alarmaMovimiento, this.objetivoNoLocalizado, this.calibracionElevacion, this.finalRecorrido, this.modoSincronizado, this.secuenciaComandar, this.matrizCalculada, this.errorDeOffset);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusAimCalibration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */