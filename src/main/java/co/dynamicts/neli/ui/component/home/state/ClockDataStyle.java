package co.dynamicts.neli.ui.component.home.state;

public enum ClockDataStyle {
  NEUTRAL("defaultData"),
  ERROR("badData"),
  WARNING("medData"),
  READY("okData");
  
  private final String styleClass;
  
  public String getStyleClass() {
    return this.styleClass;
  }
  
  ClockDataStyle(String code) {
    this.styleClass = code;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\state\ClockDataStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */