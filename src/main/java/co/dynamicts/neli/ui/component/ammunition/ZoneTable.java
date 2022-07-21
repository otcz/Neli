package co.dynamicts.neli.ui.component.ammunition;

import co.dynamicts.neli.core.stauts.StatusZona;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ZoneTable extends VBox {
  @FXML
  private Label headerTitle;
  
  @FXML
  private Label headerTitle0;
  
  @FXML
  private Label headerTitle1;
  
  @FXML
  private Label headerTitle2;
  
  @FXML
  private Label headerTitle3;
  
  @FXML
  private Label headerTitle4;
  
  @FXML
  private Label headerTitle5;
  
  @FXML
  private Label cdTitle;
  
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
  private Label cbTitle;
  
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
  private Label clTitle;
  
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
  private Label propNameTitle;
  
  @FXML
  private TextField propName0;
  
  @FXML
  private TextField propName1;
  
  @FXML
  private TextField propName2;
  
  @FXML
  private TextField propName3;
  
  @FXML
  private TextField propName4;
  
  @FXML
  private TextField propName5;
  
  @FXML
  private TextField propName6;
  
  @FXML
  private TextField propName7;
  
  @FXML
  private TextField propName8;
  
  @FXML
  private TextField propName9;
  
  @FXML
  private Label gradTempTitle;
  
  @FXML
  private TextField gradTemp0;
  
  @FXML
  private TextField gradTemp1;
  
  @FXML
  private TextField gradTemp2;
  
  @FXML
  private TextField gradTemp3;
  
  @FXML
  private TextField gradTemp4;
  
  @FXML
  private TextField gradTemp5;
  
  @FXML
  private TextField gradTemp6;
  
  @FXML
  private TextField gradTemp7;
  
  @FXML
  private TextField gradTemp8;
  
  @FXML
  private TextField gradTemp9;
  
  @FXML
  private TextField gradPesoVel0;
  
  @FXML
  private TextField gradPesoVel1;
  
  @FXML
  private TextField gradPesoVel2;
  
  @FXML
  private TextField gradPesoVel3;
  
  @FXML
  private TextField gradPesoVel4;
  
  @FXML
  private TextField gradPesoVel5;
  
  @FXML
  private TextField gradPesoVel6;
  
  @FXML
  private TextField gradPesoVel7;
  
  @FXML
  private TextField gradPesoVel8;
  
  @FXML
  private TextField gradPesoVel9;
  
  private TextField[] cbArray = new TextField[] { this.cb0, this.cb1, this.cb2, this.cb3, this.cb4, this.cb5, this.cb6, this.cb7, this.cb8, this.cb9 };
  
  private TextField[] cdArray = new TextField[] { this.cd0, this.cd1, this.cd2, this.cd3, this.cd4, this.cd5, this.cd6, this.cd7, this.cd8, this.cd9 };
  
  private TextField[] clArray = new TextField[] { this.cl0, this.cl1, this.cl2, this.cl3, this.cl4, this.cl5, this.cl6, this.cl7, this.cl8, this.cl9 };
  
  String[] v = new String[10];
  
  String[] cd = new String[10];
  
  String[] cl = new String[10];
  
  String[] propName = new String[10];
  
  String[] gradTemp = new String[10];
  
  String[] gradPesoVel = new String[10];
  
  @FXML
  public void initialize() {}
  
  public ZoneTable() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/ammunition/zone_table.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public StatusZona getStatus() {
    this.v[0] = this.cd0.getText();
    this.v[1] = this.cd1.getText();
    this.v[2] = this.cd2.getText();
    this.v[3] = this.cd3.getText();
    this.v[4] = this.cd4.getText();
    this.v[5] = this.cd5.getText();
    this.v[6] = this.cd6.getText();
    this.v[7] = this.cd7.getText();
    this.v[8] = this.cd8.getText();
    this.v[9] = this.cd9.getText();
    this.cd[0] = this.cb0.getText();
    this.cd[1] = this.cb1.getText();
    this.cd[2] = this.cb2.getText();
    this.cd[3] = this.cb3.getText();
    this.cd[4] = this.cb4.getText();
    this.cd[5] = this.cb5.getText();
    this.cd[6] = this.cb6.getText();
    this.cd[7] = this.cb7.getText();
    this.cd[8] = this.cb8.getText();
    this.cd[9] = this.cb9.getText();
    this.cl[0] = this.cl0.getText();
    this.cl[1] = this.cl1.getText();
    this.cl[2] = this.cl2.getText();
    this.cl[3] = this.cl3.getText();
    this.cl[4] = this.cl4.getText();
    this.cl[5] = this.cl5.getText();
    this.cl[6] = this.cl6.getText();
    this.cl[7] = this.cl7.getText();
    this.cl[8] = this.cl8.getText();
    this.cl[9] = this.cl9.getText();
    this.propName[0] = this.propName0.getText();
    this.propName[1] = this.propName1.getText();
    this.propName[2] = this.propName2.getText();
    this.propName[3] = this.propName3.getText();
    this.propName[4] = this.propName4.getText();
    this.propName[5] = this.propName5.getText();
    this.propName[6] = this.propName6.getText();
    this.propName[7] = this.propName7.getText();
    this.propName[8] = this.propName8.getText();
    this.propName[9] = this.propName9.getText();
    this.gradTemp[0] = this.gradTemp0.getText();
    this.gradTemp[1] = this.gradTemp1.getText();
    this.gradTemp[2] = this.gradTemp2.getText();
    this.gradTemp[3] = this.gradTemp3.getText();
    this.gradTemp[4] = this.gradTemp4.getText();
    this.gradTemp[5] = this.gradTemp5.getText();
    this.gradTemp[6] = this.gradTemp6.getText();
    this.gradTemp[7] = this.gradTemp7.getText();
    this.gradTemp[8] = this.gradTemp8.getText();
    this.gradTemp[9] = this.gradTemp9.getText();
    this.gradPesoVel[0] = this.gradPesoVel0.getText();
    this.gradPesoVel[1] = this.gradPesoVel1.getText();
    this.gradPesoVel[2] = this.gradPesoVel2.getText();
    this.gradPesoVel[3] = this.gradPesoVel3.getText();
    this.gradPesoVel[4] = this.gradPesoVel4.getText();
    this.gradPesoVel[5] = this.gradPesoVel5.getText();
    this.gradPesoVel[6] = this.gradPesoVel6.getText();
    this.gradPesoVel[7] = this.gradPesoVel7.getText();
    this.gradPesoVel[8] = this.gradPesoVel8.getText();
    this.gradPesoVel[9] = this.gradPesoVel9.getText();
    return StatusZona.builder()
      .withCbContent(this.v)
      .withCdContent(this.cd)
      .withClContent(this.cl)
      .build();
  }
  
  public void setValues() {
    this.cd0.setText(this.v[0]);
    this.cd1.setText(this.v[1]);
    this.cd2.setText(this.v[2]);
    this.cd3.setText(this.v[3]);
    this.cd4.setText(this.v[4]);
    this.cd5.setText(this.v[5]);
    this.cd6.setText(this.v[6]);
    this.cd7.setText(this.v[7]);
    this.cd8.setText(this.v[8]);
    this.cd9.setText(this.v[9]);
    this.cb0.setText(this.cd[0]);
    this.cb1.setText(this.cd[1]);
    this.cb2.setText(this.cd[2]);
    this.cb3.setText(this.cd[3]);
    this.cb4.setText(this.cd[4]);
    this.cb5.setText(this.cd[5]);
    this.cb6.setText(this.cd[6]);
    this.cb7.setText(this.cd[7]);
    this.cb8.setText(this.cd[8]);
    this.cb9.setText(this.cd[9]);
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
    this.propName0.setText(this.propName[0]);
    this.propName1.setText(this.propName[1]);
    this.propName2.setText(this.propName[2]);
    this.propName3.setText(this.propName[3]);
    this.propName4.setText(this.propName[4]);
    this.propName5.setText(this.propName[5]);
    this.propName6.setText(this.propName[6]);
    this.propName7.setText(this.propName[7]);
    this.propName8.setText(this.propName[8]);
    this.propName9.setText(this.propName[9]);
    this.gradTemp0.setText(this.gradTemp[0]);
    this.gradTemp1.setText(this.gradTemp[1]);
    this.gradTemp2.setText(this.gradTemp[2]);
    this.gradTemp3.setText(this.gradTemp[3]);
    this.gradTemp4.setText(this.gradTemp[4]);
    this.gradTemp5.setText(this.gradTemp[5]);
    this.gradTemp6.setText(this.gradTemp[6]);
    this.gradTemp7.setText(this.gradTemp[7]);
    this.gradTemp8.setText(this.gradTemp[8]);
    this.gradTemp9.setText(this.gradTemp[9]);
    this.gradPesoVel0.setText(this.gradPesoVel[0]);
    this.gradPesoVel1.setText(this.gradPesoVel[1]);
    this.gradPesoVel2.setText(this.gradPesoVel[2]);
    this.gradPesoVel3.setText(this.gradPesoVel[3]);
    this.gradPesoVel4.setText(this.gradPesoVel[4]);
    this.gradPesoVel5.setText(this.gradPesoVel[5]);
    this.gradPesoVel6.setText(this.gradPesoVel[6]);
    this.gradPesoVel7.setText(this.gradPesoVel[7]);
    this.gradPesoVel8.setText(this.gradPesoVel[8]);
    this.gradPesoVel9.setText(this.gradPesoVel[9]);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammunition\ZoneTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */