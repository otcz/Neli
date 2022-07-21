package co.dynamicts.neli.core.stauts;

public class StatusMach {
  private String[] machContent;
  
  private String[] cbContent;
  
  private String[] cdContent;
  
  private String[] clContent;
  
  public StatusMach(String[] machContent, String[] cbContent, String[] cdContent, String[] clContent) {
    this.machContent = machContent;
    this.cbContent = cbContent;
    this.cdContent = cdContent;
    this.clContent = clContent;
  }
  
  public String[] getMachContent() {
    return this.machContent;
  }
  
  public String[] getCbContent() {
    return this.cbContent;
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
    private String[] machContent;
    
    private String[] cbContent;
    
    private String[] cdContent;
    
    private String[] clContent;
    
    private Builder() {}
    
    public static Builder astatusMach() {
      return new Builder();
    }
    
    public Builder withMachContent(String[] machContent) {
      this.machContent = machContent;
      return this;
    }
    
    public Builder withCbContent(String[] cbContent) {
      this.cbContent = cbContent;
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
    
    public StatusMach build() {
      return new StatusMach(this.machContent, this.cbContent, this.cdContent, this.clContent);
    }
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\stauts\StatusMach.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */