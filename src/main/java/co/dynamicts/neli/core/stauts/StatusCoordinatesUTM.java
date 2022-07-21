package co.dynamicts.neli.core.stauts;

public final class StatusCoordinatesUTM {
  private final Integer northUTM;
  
  private final Integer useUTM;
  
  private final String bandUTM;
  
  private final Integer height;
  
  private final Integer eastUTM;
  
  public StatusCoordinatesUTM(Integer northUTM, Integer useUTM, String bandUTM, Integer height, Integer eastUTM) {
    this.northUTM = northUTM;
    this.useUTM = useUTM;
    this.bandUTM = bandUTM;
    this.height = height;
    this.eastUTM = eastUTM;
  }
  
  public Integer getEastUTM() {
    return this.eastUTM;
  }
  
  public Integer getNorthUTM() {
    return this.northUTM;
  }
  
  public Integer getUseUTM() {
    return this.useUTM;
  }
  
  public String getBandUTM() {
    return this.bandUTM;
  }
  
  public Integer getHeight() {
    return this.height;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private Integer northUTM;
    
    private Integer useUTM;
    
    private String bandUTM;
    
    private Integer height;
    
    private Integer eastUTM;
    
    private Builder() {}
    
    public Builder withNorthUTM(Integer northUTM) {
      this.northUTM = northUTM;
      return this;
    }
    
    public Builder withUseUTM(Integer useUTM) {
      this.useUTM = useUTM;
      return this;
    }
    
    public Builder withBandUTM(String bandUTM) {
      this.bandUTM = bandUTM;
      return this;
    }
    
    public Builder withHeight(Integer height) {
      this.height = height;
      return this;
    }
    
    public Builder withEastUTM(Integer eastUTM) {
      this.eastUTM = eastUTM;
      return this;
    }
    
    public StatusCoordinatesUTM build() {
      return new StatusCoordinatesUTM(this.northUTM, this.useUTM, this.bandUTM, this.height, this.eastUTM);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusCoordinatesUTM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */