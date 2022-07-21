package co.dynamicts.neli.ui.provider.item;

public class SimpleComboBoxItem {
  private String text;
  
  private Object data;
  
  public SimpleComboBoxItem() {
    setText("undefined");
  }
  
  public SimpleComboBoxItem(String text, Object data) {
    setText(text);
    setData(data);
  }
  
  public String getText() {
    return this.text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public Object getData() {
    return this.data;
  }
  
  public void setData(Object data) {
    this.data = data;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\provider\item\SimpleComboBoxItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */