package co.dynamicts.neli.core.stauts;

public class StatusZona {
  private String[] velContent;
  
  private String[] cdContent;
  
  private String[] clContent;
  
  public StatusZona(String[] velContent, String[] cdContent, String[] clContent) {
    this.velContent = velContent;
    this.cdContent = cdContent;
    this.clContent = clContent;
  }
  
  public String[] getVelContent() {
    return this.velContent;
  }
  
  public String[] getCdContent() {
    return this.cdContent;
  }
  
  public String[] getClContent() {
    return this.clContent;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static final class Builder {
    private String[] velContent;
    
    private String[] cdContent;
    
    private String[] clContent;
    
    private Builder() {}
    
    public static Builder astatusZona() {
      return new Builder();
    }
    
    public Builder withCbContent(String[] cbContent) {
      this.velContent = cbContent;
      return this;
    }
    
    public Builder withCdContent(String[] cdContent) {
      this.cdContent = cdContent;
      return this;
    }
    
    public Builder withClContent(String[] clContent) {
      this.clContent = clContent;
      return this;
    }
    
    public StatusZona build() {
      return new StatusZona(this.velContent, this.cdContent, this.clContent);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusZona.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */