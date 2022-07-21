package co.dynamicts.neli.ui.component.home.top.menu;

public enum BandejaItemStatus {
  DESCARGADA("M0 2h5.997v17.02H34.99V2H40V0h-7.01v17.02H7.997V0H0z", "Descargada", ItemStatus.MEDIUM),
  ESPERA("M3.375 8.25h3.5a.375.375 0 0 1 0 .75h-3.5a.375.375 0 0 1 0-.75zM7.25 3.717V7.75H3V3.717L4.884.142c.099-.19.383-.19.482 0L7.25 3.717zM0 5.75v-.5h2v4.255h6.248V5.25H10v.5H8.748v4.255H1.499V5.75H0z", "Espera", ItemStatus.NEUTRAL),
  CARGADA("M3.375 8.25h3.5a.375.375 0 0 1 0 .75h-3.5a.375.375 0 0 1 0-.75zM7.25 3.717V7.75H3V3.717L4.884.142c.099-.19.383-.19.482 0L7.25 3.717zM0 5.75v-.5h2v4.255h6.248V5.25H10v.5H8.748v4.255H1.499V5.75H0z", "Cargada", ItemStatus.OK),
  INTERRUMPIDA("M3.375 8.25h3.5a.375.375 0 0 1 0 .75h-3.5a.375.375 0 0 1 0-.75zM7.25 3.717V7.75H3V3.717L4.884.142c.099-.19.383-.19.482 0L7.25 3.717zM0 5.75v-.5h2v4.255h6.248V5.25H10v.5H8.748v4.255H1.499V5.75H0z", "Interrumpida", ItemStatus.BAD);
  
  private final String svgPath;
  
  private final String label;
  
  private final ItemStatus status;
  
  BandejaItemStatus(String svgPath, String label, ItemStatus status) {
    this.svgPath = svgPath;
    this.label = label;
    this.status = status;
  }
  
  public String getSvgPath() {
    return this.svgPath;
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public ItemStatus getStatus() {
    return this.status;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\top\menu\BandejaItemStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */