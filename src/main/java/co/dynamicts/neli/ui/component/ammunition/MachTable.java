package co.dynamicts.neli.ui.component.ammunition;

import co.dynamicts.neli.core.stauts.StatusMach;
import co.dynamicts.neli.core.utilities.Tools;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MachTable extends VBox {
  @FXML
  private TextField mach0;
  
  @FXML
  private TextField mach1;
  
  @FXML
  private TextField mach2;
  
  @FXML
  private TextField mach3;
  
  @FXML
  private TextField mach4;
  
  @FXML
  private TextField mach5;
  
  @FXML
  private TextField mach6;
  
  @FXML
  private TextField mach7;
  
  @FXML
  private TextField mach8;
  
  @FXML
  private TextField mach9;
  
  @FXML
  private TextField mach10;
  
  @FXML
  private TextField mach11;
  
  @FXML
  private TextField mach12;
  
  @FXML
  private TextField mach13;
  
  @FXML
  private TextField cd0;
  
  @FXML
  private TextField cd1;
  
  @FXML
  private TextField cd2;
  
  @FXML
  private TextField cd3;
  
  @FXML
  private TextField cd4;
  
  @FXML
  private TextField cd5;
  
  @FXML
  private TextField cd6;
  
  @FXML
  private TextField cd7;
  
  @FXML
  private TextField cd8;
  
  @FXML
  private TextField cd9;
  
  @FXML
  private TextField cd10;
  
  @FXML
  private TextField cd11;
  
  @FXML
  private TextField cd12;
  
  @FXML
  private TextField cd13;
  
  @FXML
  private TextField cb0;
  
  @FXML
  private TextField cb1;
  
  @FXML
  private TextField cb2;
  
  @FXML
  private TextField cb3;
  
  @FXML
  private TextField cb4;
  
  @FXML
  private TextField cb5;
  
  @FXML
  private TextField cb6;
  
  @FXML
  private TextField cb7;
  
  @FXML
  private TextField cb8;
  
  @FXML
  private TextField cb9;
  
  @FXML
  private TextField cb10;
  
  @FXML
  private TextField cb11;
  
  @FXML
  private TextField cb12;
  
  @FXML
  private TextField cb13;
  
  @FXML
  private TextField cl0;
  
  @FXML
  private TextField cl1;
  
  @FXML
  private TextField cl2;
  
  @FXML
  private TextField cl3;
  
  @FXML
  private TextField cl4;
  
  @FXML
  private TextField cl5;
  
  @FXML
  private TextField cl6;
  
  @FXML
  private TextField cl7;
  
  @FXML
  private TextField cl8;
  
  @FXML
  private TextField cl9;
  
  @FXML
  private TextField cl10;
  
  @FXML
  private TextField cl11;
  
  @FXML
  private TextField cl12;
  
  @FXML
  private TextField cl13;
  
  private TextField[] machArray = new TextField[] { 
      this.mach0, this.mach1, this.mach2, this.mach3, this.mach4, this.mach5, this.mach6, this.mach7, this.mach8, this.mach9, 
      this.mach10, this.mach11, this.mach12, this.mach13 };
  
  private TextField[] cdArray = new TextField[] { 
      this.cd0, this.cd1, this.cd2, this.cd3, this.cd4, this.cd5, this.cd6, this.cd7, this.cd8, this.cd9, 
      this.cd10, this.cd11, this.cd12, this.cd13 };
  
  private TextField[] cbArray = new TextField[] { 
      this.cb0, this.cb1, this.cb2, this.cb3, this.cb4, this.cb5, this.cb6, this.cb7, this.cb8, this.cb9, 
      this.cb10, this.cb11, this.cb12, this.cb13 };
  
  private TextField[] clArray = new TextField[] { 
      this.cl0, this.cl1, this.cl2, this.cl3, this.cl4, this.cl5, this.cl6, this.cl7, this.cl8, this.cl9, 
      this.cl10, this.cl11, this.cl12, this.cl13 };
  
  String[] mach = new String[14];
  
  String[] cb = new String[14];
  
  String[] cd = new String[14];
  
  String[] cl = new String[14];
  
  public MachTable() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/ammunition/mach_table.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  public void initialize() {}
  
  public StatusMach getStatus() {
    this.mach[0] = Tools.verificaEmpty(this.mach0.getText());
    this.mach[1] = Tools.verificaEmpty(this.mach1.getText());
    this.mach[2] = Tools.verificaEmpty(this.mach2.getText());
    this.mach[3] = Tools.verificaEmpty(this.mach3.getText());
    this.mach[4] = Tools.verificaEmpty(this.mach4.getText());
    this.mach[5] = Tools.verificaEmpty(this.mach5.getText());
    this.mach[6] = Tools.verificaEmpty(this.mach6.getText());
    this.mach[7] = Tools.verificaEmpty(this.mach7.getText());
    this.mach[8] = Tools.verificaEmpty(this.mach8.getText());
    this.mach[9] = Tools.verificaEmpty(this.mach9.getText());
    this.mach[10] = Tools.verificaEmpty(this.mach10.getText());
    this.mach[11] = Tools.verificaEmpty(this.mach11.getText());
    this.mach[12] = Tools.verificaEmpty(this.mach12.getText());
    this.mach[13] = Tools.verificaEmpty(this.mach13.getText());
    this.cd[0] = Tools.verificaEmpty(this.cd0.getText());
    this.cd[1] = Tools.verificaEmpty(this.cd1.getText());
    this.cd[2] = Tools.verificaEmpty(this.cd2.getText());
    this.cd[3] = Tools.verificaEmpty(this.cd3.getText());
    this.cd[4] = Tools.verificaEmpty(this.cd4.getText());
    this.cd[5] = Tools.verificaEmpty(this.cd5.getText());
    this.cd[6] = Tools.verificaEmpty(this.cd6.getText());
    this.cd[7] = Tools.verificaEmpty(this.cd7.getText());
    this.cd[8] = Tools.verificaEmpty(this.cd8.getText());
    this.cd[9] = Tools.verificaEmpty(this.cd9.getText());
    this.cd[10] = Tools.verificaEmpty(this.cd10.getText());
    this.cd[11] = Tools.verificaEmpty(this.cd11.getText());
    this.cd[12] = Tools.verificaEmpty(this.cd12.getText());
    this.cd[13] = Tools.verificaEmpty(this.cd13.getText());
    this.cb[0] = Tools.verificaEmpty(this.cb0.getText());
    this.cb[1] = Tools.verificaEmpty(this.cb1.getText());
    this.cb[2] = Tools.verificaEmpty(this.cb2.getText());
    this.cb[3] = Tools.verificaEmpty(this.cb3.getText());
    this.cb[4] = Tools.verificaEmpty(this.cb4.getText());
    this.cb[5] = Tools.verificaEmpty(this.cb5.getText());
    this.cb[6] = Tools.verificaEmpty(this.cb6.getText());
    this.cb[7] = Tools.verificaEmpty(this.cb7.getText());
    this.cb[8] = Tools.verificaEmpty(this.cb8.getText());
    this.cb[9] = Tools.verificaEmpty(this.cb9.getText());
    this.cb[10] = Tools.verificaEmpty(this.cb10.getText());
    this.cb[11] = Tools.verificaEmpty(this.cb11.getText());
    this.cb[12] = Tools.verificaEmpty(this.cb12.getText());
    this.cb[13] = Tools.verificaEmpty(this.cb13.getText());
    this.cl[0] = Tools.verificaEmpty(this.cl0.getText());
    this.cl[1] = Tools.verificaEmpty(this.cl1.getText());
    this.cl[2] = Tools.verificaEmpty(this.cl2.getText());
    this.cl[3] = Tools.verificaEmpty(this.cl3.getText());
    this.cl[4] = Tools.verificaEmpty(this.cl4.getText());
    this.cl[5] = Tools.verificaEmpty(this.cl5.getText());
    this.cl[6] = Tools.verificaEmpty(this.cl6.getText());
    this.cl[7] = Tools.verificaEmpty(this.cl7.getText());
    this.cl[8] = Tools.verificaEmpty(this.cl8.getText());
    this.cl[9] = Tools.verificaEmpty(this.cl9.getText());
    this.cl[10] = Tools.verificaEmpty(this.cl10.getText());
    this.cl[11] = Tools.verificaEmpty(this.cl11.getText());
    this.cl[12] = Tools.verificaEmpty(this.cl12.getText());
    this.cl[13] = Tools.verificaEmpty(this.cl13.getText());
    return StatusMach.builder()
      .withMachContent(this.mach)
      .withCbContent(this.cb)
      .withCdContent(this.cd)
      .withClContent(this.cl)
      .build();
  }
  
  public void setValues() {
    this.mach0.setText(this.mach[0]);
    this.mach1.setText(this.mach[1]);
    this.mach2.setText(this.mach[2]);
    this.mach3.setText(this.mach[3]);
    this.mach4.setText(this.mach[4]);
    this.mach5.setText(this.mach[5]);
    this.mach6.setText(this.mach[6]);
    this.mach7.setText(this.mach[7]);
    this.mach8.setText(this.mach[8]);
    this.mach9.setText(this.mach[9]);
    this.mach10.setText(this.mach[10]);
    this.mach11.setText(this.mach[11]);
    this.mach12.setText(this.mach[12]);
    this.mach13.setText(this.mach[13]);
    this.cd0.setText(this.cd[0]);
    this.cd1.setText(this.cd[1]);
    this.cd2.setText(this.cd[2]);
    this.cd3.setText(this.cd[3]);
    this.cd4.setText(this.cd[4]);
    this.cd5.setText(this.cd[5]);
    this.cd6.setText(this.cd[6]);
    this.cd7.setText(this.cd[7]);
    this.cd8.setText(this.cd[8]);
    this.cd9.setText(this.cd[9]);
    this.cd10.setText(this.cd[10]);
    this.cd11.setText(this.cd[11]);
    this.cd12.setText(this.cd[12]);
    this.cd13.setText(this.cd[13]);
    this.cl0.setText(this.cl[0]);
    this.cl1.setText(this.cl[1]);
    this.cl2.setText(this.cl[2]);
    this.cl3.setText(this.cl[3]);
    this.cl4.setText(this.cl[4]);
    this.cl5.setText(this.cl[5]);
    this.cl6.setText(this.cl[6]);
    this.cl7.setText(this.cl[7]);
    this.cl8.setText(this.cl[8]);
    this.cl9.setText(this.cl[9]);
    this.cl10.setText(this.cl[10]);
    this.cl11.setText(this.cl[11]);
    this.cl12.setText(this.cl[12]);
    this.cl13.setText(this.cl[13]);
    this.cb0.setText(this.cb[0]);
    this.cb1.setText(this.cb[1]);
    this.cb2.setText(this.cb[2]);
    this.cb3.setText(this.cb[3]);
    this.cb4.setText(this.cb[4]);
    this.cb5.setText(this.cb[5]);
    this.cb6.setText(this.cb[6]);
    this.cb7.setText(this.cb[7]);
    this.cb8.setText(this.cb[8]);
    this.cb9.setText(this.cb[9]);
    this.cb10.setText(this.cb[10]);
    this.cb11.setText(this.cb[11]);
    this.cb12.setText(this.cb[12]);
    this.cb13.setText(this.cb[13]);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammunition\MachTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */