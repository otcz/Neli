package co.dynamicts.neli.ui.component.ammo;

import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoefAmmoAdd extends VBox implements BaseUserInterface, Initializable {
  @FXML
  public TextField mach0;
  
  @FXML
  public TextField mach1;
  
  @FXML
  public TextField mach2;
  
  @FXML
  public TextField mach3;
  
  @FXML
  public TextField mach4;
  
  @FXML
  public TextField mach5;
  
  @FXML
  public TextField mach6;
  
  @FXML
  public TextField mach7;
  
  @FXML
  public TextField mach8;
  
  @FXML
  public TextField mach9;
  
  @FXML
  public TextField mach10;
  
  @FXML
  public TextField mach11;
  
  @FXML
  public TextField mach12;
  
  @FXML
  public TextField mach13;
  
  private TextField[] machTextFieldArray = new TextField[13];
  
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
  
  private TextField[] cdTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cda0;
  
  @FXML
  private TextField cda1;
  
  @FXML
  private TextField cda2;
  
  @FXML
  private TextField cda3;
  
  @FXML
  private TextField cda4;
  
  @FXML
  private TextField cda5;
  
  @FXML
  private TextField cda6;
  
  @FXML
  private TextField cda7;
  
  @FXML
  private TextField cda8;
  
  @FXML
  private TextField cda9;
  
  @FXML
  private TextField cda10;
  
  @FXML
  private TextField cda11;
  
  @FXML
  private TextField cda12;
  
  @FXML
  private TextField cda13;
  
  private TextField[] cdaTextFieldArray = new TextField[13];
  
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
  
  private TextField[] clTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cla0;
  
  @FXML
  private TextField cla1;
  
  @FXML
  private TextField cla2;
  
  @FXML
  private TextField cla3;
  
  @FXML
  private TextField cla4;
  
  @FXML
  private TextField cla5;
  
  @FXML
  private TextField cla6;
  
  @FXML
  private TextField cla7;
  
  @FXML
  private TextField cla8;
  
  @FXML
  private TextField cla9;
  
  @FXML
  private TextField cla10;
  
  @FXML
  private TextField cla11;
  
  @FXML
  private TextField cla12;
  
  @FXML
  private TextField cla13;
  
  private TextField[] claTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cm0;
  
  @FXML
  private TextField cm1;
  
  @FXML
  private TextField cm2;
  
  @FXML
  private TextField cm3;
  
  @FXML
  private TextField cm4;
  
  @FXML
  private TextField cm5;
  
  @FXML
  private TextField cm6;
  
  @FXML
  private TextField cm7;
  
  @FXML
  private TextField cm8;
  
  @FXML
  private TextField cm9;
  
  @FXML
  private TextField cm10;
  
  @FXML
  private TextField cm11;
  
  @FXML
  private TextField cm12;
  
  @FXML
  private TextField cm13;
  
  private TextField[] cmTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cma0;
  
  @FXML
  private TextField cma1;
  
  @FXML
  private TextField cma2;
  
  @FXML
  private TextField cma3;
  
  @FXML
  private TextField cma4;
  
  @FXML
  private TextField cma5;
  
  @FXML
  private TextField cma6;
  
  @FXML
  private TextField cma7;
  
  @FXML
  private TextField cma8;
  
  @FXML
  private TextField cma9;
  
  @FXML
  private TextField cma10;
  
  @FXML
  private TextField cma11;
  
  @FXML
  private TextField cma12;
  
  @FXML
  private TextField cma13;
  
  private TextField[] cmaTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cmag0;
  
  @FXML
  private TextField cmag1;
  
  @FXML
  private TextField cmag2;
  
  @FXML
  private TextField cmag3;
  
  @FXML
  private TextField cmag4;
  
  @FXML
  private TextField cmag5;
  
  @FXML
  private TextField cmag6;
  
  @FXML
  private TextField cmag7;
  
  @FXML
  private TextField cmag8;
  
  @FXML
  private TextField cmag9;
  
  @FXML
  private TextField cmag10;
  
  @FXML
  private TextField cmag11;
  
  @FXML
  private TextField cmag12;
  
  @FXML
  private TextField cmag13;
  
  private TextField[] cmagTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cspin0;
  
  @FXML
  private TextField cspin1;
  
  @FXML
  private TextField cspin2;
  
  @FXML
  private TextField cspin3;
  
  @FXML
  private TextField cspin4;
  
  @FXML
  private TextField cspin5;
  
  @FXML
  private TextField cspin6;
  
  @FXML
  private TextField cspin7;
  
  @FXML
  private TextField cspin8;
  
  @FXML
  private TextField cspin9;
  
  @FXML
  private TextField cspin10;
  
  @FXML
  private TextField cspin11;
  
  @FXML
  private TextField cspin12;
  
  @FXML
  private TextField cspin13;
  
  private TextField[] cspinTextFieldArray = new TextField[13];
  
  @FXML
  private TextField cxbb0;
  
  @FXML
  private TextField cxbb1;
  
  @FXML
  private TextField cxbb2;
  
  @FXML
  private TextField cxbb3;
  
  @FXML
  private TextField cxbb4;
  
  @FXML
  private TextField cxbb5;
  
  @FXML
  private TextField cxbb6;
  
  @FXML
  private TextField cxbb7;
  
  @FXML
  private TextField cxbb8;
  
  @FXML
  private TextField cxbb9;
  
  @FXML
  private TextField cxbb10;
  
  @FXML
  private TextField cxbb11;
  
  @FXML
  private TextField cxbb12;
  
  @FXML
  private TextField cxbb13;
  
  private TextField[] cxbbTextFieldArray = new TextField[13];
  
  @FXML
  private TextField iform0;
  
  @FXML
  private TextField iform1;
  
  @FXML
  private TextField iform2;
  
  @FXML
  private TextField iform3;
  
  @FXML
  private TextField iform4;
  
  @FXML
  private TextField iform5;
  
  @FXML
  private TextField iform6;
  
  @FXML
  private TextField iform7;
  
  @FXML
  private TextField iform8;
  
  @FXML
  private TextField iform9;
  
  @FXML
  private TextField iform10;
  
  @FXML
  private TextField iform11;
  
  @FXML
  private TextField iform12;
  
  @FXML
  private TextField iform13;
  
  private TextField[] iformTextFieldArray = new TextField[13];
  
  @FXML
  private TextField i0;
  
  @FXML
  private TextField i1;
  
  @FXML
  private TextField i2;
  
  @FXML
  private TextField i3;
  
  @FXML
  private TextField i4;
  
  @FXML
  private TextField i5;
  
  @FXML
  private TextField i6;
  
  @FXML
  private TextField i7;
  
  @FXML
  private TextField i8;
  
  @FXML
  private TextField i9;
  
  @FXML
  private TextField i10;
  
  @FXML
  private TextField i11;
  
  @FXML
  private TextField i12;
  
  @FXML
  private TextField i13;
  
  private TextField[] iTextFieldArray = new TextField[13];
  
  @FXML
  private TextField mcb0;
  
  @FXML
  private TextField mcb1;
  
  @FXML
  private TextField mcb2;
  
  @FXML
  private TextField mcb3;
  
  @FXML
  private TextField mcb4;
  
  @FXML
  private TextField mcb5;
  
  private TextField[] mcbTextFieldArray = new TextField[5];
  
  @FXML
  private TextField sc0;
  
  @FXML
  private TextField sc1;
  
  @FXML
  private TextField sc2;
  
  @FXML
  private TextField sc3;
  
  @FXML
  private TextField sc4;
  
  @FXML
  private TextField sc5;
  
  private TextField[] scTextFieldArray = new TextField[5];
  
  @FXML
  private TextField municionCoeficienteA0;
  
  @FXML
  private TextField municionCoeficienteA1;
  
  @FXML
  private TextField municionCoeficienteA2;
  
  @FXML
  private TextField municionCoeficienteA3;
  
  @FXML
  private TextField municionCoeficienteB1;
  
  @FXML
  private TextField municionCoeficienteB2;
  
  @FXML
  private TextField municionCoeficienteB3;
  
  double[] machArray;
  
  double[] cdArray;
  
  double[] cdaArray;
  
  double[] clArray;
  
  double[] claArray;
  
  double[] cmArray;
  
  double[] cmaArray;
  
  double[] cmagArray;
  
  double[] cspinArray;
  
  double[] cxbbArray;
  
  double[] iformArray;
  
  double[] iArray = new double[13];
  
  double[] mcbArray;
  
  double[] scArray = new double[5];
  
  double coeficienteA0;
  
  double coeficienteA1;
  
  double coeficienteA2;
  
  double coeficienteA3;
  
  double coeficienteB1;
  
  double coeficienteB2;
  
  double coeficienteB3;
  
  public CoefAmmoAdd() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/ammo/coef_ammo_add.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {}
  
  public void initialize(URL location, ResourceBundle resources) {
    updateComponents();
    initArrays();
    dataChange();
    clearForm();
  }
  
  public void initArrays() {
    int x;
    for (x = 0; x < 13; x++) {
      this.machTextFieldArray[x] = new TextField();
      this.cdTextFieldArray[x] = new TextField();
      this.cdaTextFieldArray[x] = new TextField();
      this.clTextFieldArray[x] = new TextField();
      this.claTextFieldArray[x] = new TextField();
      this.cmTextFieldArray[x] = new TextField();
      this.cmaTextFieldArray[x] = new TextField();
      this.cmagTextFieldArray[x] = new TextField();
      this.cspinTextFieldArray[x] = new TextField();
      this.cxbbTextFieldArray[x] = new TextField();
      this.iformTextFieldArray[x] = new TextField();
      this.iTextFieldArray[x] = new TextField();
    } 
    this.machTextFieldArray = new TextField[] { 
        this.mach0, this.mach1, this.mach2, this.mach3, this.mach4, this.mach5, this.mach6, this.mach7, this.mach8, this.mach9, 
        this.mach10, this.mach11, this.mach12, this.mach13 };
    this.cdTextFieldArray = new TextField[] { 
        this.cd0, this.cd1, this.cd2, this.cd3, this.cd4, this.cd5, this.cd6, this.cd7, this.cd8, this.cd9, 
        this.cd10, this.cd11, this.cd12, this.cd13 };
    this.cdaTextFieldArray = new TextField[] { 
        this.cda0, this.cda1, this.cda2, this.cda3, this.cda4, this.cda5, this.cda6, this.cda7, this.cda8, this.cda9, 
        this.cda10, this.cda11, this.cda12, this.cda13 };
    this.clTextFieldArray = new TextField[] { 
        this.cl0, this.cl1, this.cl2, this.cl3, this.cl4, this.cl5, this.cl6, this.cl7, this.cl8, this.cl9, 
        this.cl10, this.cl11, this.cl12, this.cl13 };
    this.claTextFieldArray = new TextField[] { 
        this.cla0, this.cla1, this.cla2, this.cla3, this.cla4, this.cla5, this.cla6, this.cla7, this.cla8, this.cla9, 
        this.cla10, this.cla11, this.cla12, this.cla13 };
    this.cmTextFieldArray = new TextField[] { 
        this.cm0, this.cm1, this.cm2, this.cm3, this.cm4, this.cm5, this.cm6, this.cm7, this.cm8, this.cm9, 
        this.cm10, this.cm11, this.cm12, this.cm13 };
    this.cmaTextFieldArray = new TextField[] { 
        this.cma0, this.cma1, this.cma2, this.cma3, this.cma4, this.cma5, this.cma6, this.cma7, this.cma8, this.cma9, 
        this.cma10, this.cma11, this.cma12, this.cma13 };
    this.cmagTextFieldArray = new TextField[] { 
        this.cmag0, this.cmag1, this.cmag2, this.cmag3, this.cmag4, this.cmag5, this.cmag6, this.cmag7, this.cmag8, this.cmag9, 
        this.cmag10, this.cmag11, this.cmag12, this.cmag13 };
    this.cspinTextFieldArray = new TextField[] { 
        this.cspin0, this.cspin1, this.cspin2, this.cspin3, this.cspin4, this.cspin5, this.cspin6, this.cspin7, this.cspin8, this.cspin9, 
        this.cspin10, this.cspin11, this.cspin12, this.cspin13 };
    this.cxbbTextFieldArray = new TextField[] { 
        this.cxbb0, this.cxbb1, this.cxbb2, this.cxbb3, this.cxbb4, this.cxbb5, this.cxbb6, this.cxbb7, this.cxbb8, this.cxbb9, 
        this.cxbb10, this.cxbb11, this.cxbb12, this.cxbb13 };
    this.iformTextFieldArray = new TextField[] { 
        this.iform0, this.iform1, this.iform2, this.iform3, this.iform4, this.iform5, this.iform6, this.iform7, this.iform8, this.iform9, 
        this.iform10, this.iform11, this.iform12, this.iform13 };
    this.iTextFieldArray = new TextField[] { 
        this.i0, this.i1, this.i2, this.i3, this.i4, this.i5, this.i6, this.i7, this.i8, this.i9, 
        this.i10, this.i11, this.i12, this.i13 };
    for (x = 0; x < 5; x++) {
      this.mcbTextFieldArray[x] = new TextField();
      this.scTextFieldArray[x] = new TextField();
    } 
    this.mcbTextFieldArray = new TextField[] { this.mcb0, this.mcb1, this.mcb2, this.mcb3, this.mcb4, this.mcb5 };
    this.scTextFieldArray = new TextField[] { this.sc0, this.sc1, this.sc2, this.sc3, this.sc4, this.sc5 };
  }
  
  public void dataChange() {
    int x;
    for (x = 0; x < 14; x++) {
      this.machTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cdTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cdaTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.clTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.claTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cmTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cmaTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cmagTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cspinTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.cxbbTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.iformTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.iTextFieldArray[x].getProperties().put("vkType", "numeric");
    } 
    for (x = 0; x < 6; x++) {
      this.mcbTextFieldArray[x].getProperties().put("vkType", "numeric");
      this.scTextFieldArray[x].getProperties().put("vkType", "numeric");
    } 
    this.municionCoeficienteA0.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA1.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA2.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA3.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB1.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB2.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB3.getProperties().put("vkType", "numeric");
    this.mach0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach0, newValue.booleanValue()));
    this.mach1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach1, newValue.booleanValue()));
    this.mach2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach2, newValue.booleanValue()));
    this.mach3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach3, newValue.booleanValue()));
    this.mach4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach4, newValue.booleanValue()));
    this.mach5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach5, newValue.booleanValue()));
    this.mach6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach6, newValue.booleanValue()));
    this.mach7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach7, newValue.booleanValue()));
    this.mach8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach8, newValue.booleanValue()));
    this.mach9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach9, newValue.booleanValue()));
    this.mach10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach10, newValue.booleanValue()));
    this.mach11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach11, newValue.booleanValue()));
    this.mach12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach12, newValue.booleanValue()));
    this.mach13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mach13, newValue.booleanValue()));
    this.cd0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd0, newValue.booleanValue()));
    this.cd1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd1, newValue.booleanValue()));
    this.cd2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd2, newValue.booleanValue()));
    this.cd3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd3, newValue.booleanValue()));
    this.cd4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd4, newValue.booleanValue()));
    this.cd5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd5, newValue.booleanValue()));
    this.cd6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd6, newValue.booleanValue()));
    this.cd7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd7, newValue.booleanValue()));
    this.cd8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd8, newValue.booleanValue()));
    this.cd9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd9, newValue.booleanValue()));
    this.cd10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd10, newValue.booleanValue()));
    this.cd11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd11, newValue.booleanValue()));
    this.cd12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd12, newValue.booleanValue()));
    this.cd13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cd13, newValue.booleanValue()));
    this.cda0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda0, newValue.booleanValue()));
    this.cda1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda1, newValue.booleanValue()));
    this.cda2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda2, newValue.booleanValue()));
    this.cda3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda3, newValue.booleanValue()));
    this.cda4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda4, newValue.booleanValue()));
    this.cda5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda5, newValue.booleanValue()));
    this.cda6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda6, newValue.booleanValue()));
    this.cda7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda7, newValue.booleanValue()));
    this.cda8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda8, newValue.booleanValue()));
    this.cda9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda9, newValue.booleanValue()));
    this.cda10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda10, newValue.booleanValue()));
    this.cda11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda11, newValue.booleanValue()));
    this.cda12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda12, newValue.booleanValue()));
    this.cda13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cda13, newValue.booleanValue()));
    this.cl0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl0, newValue.booleanValue()));
    this.cl1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl1, newValue.booleanValue()));
    this.cl2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl2, newValue.booleanValue()));
    this.cl3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl3, newValue.booleanValue()));
    this.cl4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl4, newValue.booleanValue()));
    this.cl5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl5, newValue.booleanValue()));
    this.cl6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl6, newValue.booleanValue()));
    this.cl7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl7, newValue.booleanValue()));
    this.cl8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl8, newValue.booleanValue()));
    this.cl9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl9, newValue.booleanValue()));
    this.cl10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl10, newValue.booleanValue()));
    this.cl11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl11, newValue.booleanValue()));
    this.cl12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl12, newValue.booleanValue()));
    this.cl13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cl13, newValue.booleanValue()));
    this.cla0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla0, newValue.booleanValue()));
    this.cla1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla1, newValue.booleanValue()));
    this.cla2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla2, newValue.booleanValue()));
    this.cla3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla3, newValue.booleanValue()));
    this.cla4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla4, newValue.booleanValue()));
    this.cla5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla5, newValue.booleanValue()));
    this.cla6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla6, newValue.booleanValue()));
    this.cla7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla7, newValue.booleanValue()));
    this.cla8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla8, newValue.booleanValue()));
    this.cla9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla9, newValue.booleanValue()));
    this.cla10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla10, newValue.booleanValue()));
    this.cla11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla11, newValue.booleanValue()));
    this.cla12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla12, newValue.booleanValue()));
    this.cla13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cla13, newValue.booleanValue()));
    this.cm0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm0, newValue.booleanValue()));
    this.cm1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm1, newValue.booleanValue()));
    this.cm2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm2, newValue.booleanValue()));
    this.cm3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm3, newValue.booleanValue()));
    this.cm4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm4, newValue.booleanValue()));
    this.cm5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm5, newValue.booleanValue()));
    this.cm6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm6, newValue.booleanValue()));
    this.cm7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm7, newValue.booleanValue()));
    this.cm8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm8, newValue.booleanValue()));
    this.cm9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm9, newValue.booleanValue()));
    this.cm10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm10, newValue.booleanValue()));
    this.cm11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm11, newValue.booleanValue()));
    this.cm12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm12, newValue.booleanValue()));
    this.cm13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cm13, newValue.booleanValue()));
    this.cma0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma0, newValue.booleanValue()));
    this.cma1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma1, newValue.booleanValue()));
    this.cma2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma2, newValue.booleanValue()));
    this.cma3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma3, newValue.booleanValue()));
    this.cma4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma4, newValue.booleanValue()));
    this.cma5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma5, newValue.booleanValue()));
    this.cma6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma6, newValue.booleanValue()));
    this.cma7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma7, newValue.booleanValue()));
    this.cma8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma8, newValue.booleanValue()));
    this.cma9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma9, newValue.booleanValue()));
    this.cma10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma10, newValue.booleanValue()));
    this.cma11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma11, newValue.booleanValue()));
    this.cma12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma12, newValue.booleanValue()));
    this.cma13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cma13, newValue.booleanValue()));
    this.cmag0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag0, newValue.booleanValue()));
    this.cmag1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag1, newValue.booleanValue()));
    this.cmag2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag2, newValue.booleanValue()));
    this.cmag3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag3, newValue.booleanValue()));
    this.cmag4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag4, newValue.booleanValue()));
    this.cmag5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag5, newValue.booleanValue()));
    this.cmag6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag6, newValue.booleanValue()));
    this.cmag7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag7, newValue.booleanValue()));
    this.cmag8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag8, newValue.booleanValue()));
    this.cmag9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag9, newValue.booleanValue()));
    this.cmag10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag10, newValue.booleanValue()));
    this.cmag11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag11, newValue.booleanValue()));
    this.cmag12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag12, newValue.booleanValue()));
    this.cmag13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cmag13, newValue.booleanValue()));
    this.cspin0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin0, newValue.booleanValue()));
    this.cspin1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin1, newValue.booleanValue()));
    this.cspin2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin2, newValue.booleanValue()));
    this.cspin3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin3, newValue.booleanValue()));
    this.cspin4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin4, newValue.booleanValue()));
    this.cspin5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin5, newValue.booleanValue()));
    this.cspin6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin6, newValue.booleanValue()));
    this.cspin7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin7, newValue.booleanValue()));
    this.cspin8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin8, newValue.booleanValue()));
    this.cspin9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin9, newValue.booleanValue()));
    this.cspin10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin10, newValue.booleanValue()));
    this.cspin11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin11, newValue.booleanValue()));
    this.cspin12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin12, newValue.booleanValue()));
    this.cspin13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cspin13, newValue.booleanValue()));
    this.cxbb0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb0, newValue.booleanValue()));
    this.cxbb1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb1, newValue.booleanValue()));
    this.cxbb2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb2, newValue.booleanValue()));
    this.cxbb3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb3, newValue.booleanValue()));
    this.cxbb4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb4, newValue.booleanValue()));
    this.cxbb5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb5, newValue.booleanValue()));
    this.cxbb6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb6, newValue.booleanValue()));
    this.cxbb7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb7, newValue.booleanValue()));
    this.cxbb8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb8, newValue.booleanValue()));
    this.cxbb9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb9, newValue.booleanValue()));
    this.cxbb10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb10, newValue.booleanValue()));
    this.cxbb11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb11, newValue.booleanValue()));
    this.cxbb12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb12, newValue.booleanValue()));
    this.cxbb13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cxbb13, newValue.booleanValue()));
    this.iform0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform0, newValue.booleanValue()));
    this.iform1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform1, newValue.booleanValue()));
    this.iform2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform2, newValue.booleanValue()));
    this.iform3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform3, newValue.booleanValue()));
    this.iform4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform4, newValue.booleanValue()));
    this.iform5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform5, newValue.booleanValue()));
    this.iform6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform6, newValue.booleanValue()));
    this.iform7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform7, newValue.booleanValue()));
    this.iform8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform8, newValue.booleanValue()));
    this.iform9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform9, newValue.booleanValue()));
    this.iform10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform10, newValue.booleanValue()));
    this.iform11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform11, newValue.booleanValue()));
    this.iform12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform12, newValue.booleanValue()));
    this.iform13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.iform13, newValue.booleanValue()));
    this.i0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i0, newValue.booleanValue()));
    this.i1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i1, newValue.booleanValue()));
    this.i2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i2, newValue.booleanValue()));
    this.i3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i3, newValue.booleanValue()));
    this.i4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i4, newValue.booleanValue()));
    this.i5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i5, newValue.booleanValue()));
    this.i6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i6, newValue.booleanValue()));
    this.i7
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i7, newValue.booleanValue()));
    this.i8
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i8, newValue.booleanValue()));
    this.i9
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i9, newValue.booleanValue()));
    this.i10
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i10, newValue.booleanValue()));
    this.i11
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i11, newValue.booleanValue()));
    this.i12
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i12, newValue.booleanValue()));
    this.i13
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.i13, newValue.booleanValue()));
    this.mcb0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb0, newValue.booleanValue()));
    this.mcb1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb1, newValue.booleanValue()));
    this.mcb2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb2, newValue.booleanValue()));
    this.mcb3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb3, newValue.booleanValue()));
    this.mcb4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb4, newValue.booleanValue()));
    this.mcb5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.mcb5, newValue.booleanValue()));
    this.sc0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc0, newValue.booleanValue()));
    this.sc1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc1, newValue.booleanValue()));
    this.sc2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc2, newValue.booleanValue()));
    this.sc3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc3, newValue.booleanValue()));
    this.sc4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc4, newValue.booleanValue()));
    this.sc5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.sc5, newValue.booleanValue()));
    this.municionCoeficienteA0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteA0, newValue.booleanValue()));
    this.municionCoeficienteA1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteA1, newValue.booleanValue()));
    this.municionCoeficienteA2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteA2, newValue.booleanValue()));
    this.municionCoeficienteA3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteA3, newValue.booleanValue()));
    this.municionCoeficienteB1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteB1, newValue.booleanValue()));
    this.municionCoeficienteB2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteB2, newValue.booleanValue()));
    this.municionCoeficienteB3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionCoeficienteB3, newValue.booleanValue()));
  }
  
  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (!newValue && 
      !textField.getText().matches(MeasureExpression.AMMO_ADD_DOUBLE))
      textField.getStyleClass().add("error"); 
  }
  
  public void clearForm() {
    int x;
    for (x = 0; x < 14; x++) {
      this.machTextFieldArray[x].setText("-0.00");
      this.cdTextFieldArray[x].setText("-0.00");
      this.cdaTextFieldArray[x].setText("-0.00");
      this.clTextFieldArray[x].setText("-0.00");
      this.claTextFieldArray[x].setText("-0.00");
      this.cmTextFieldArray[x].setText("-0.00");
      this.cmaTextFieldArray[x].setText("-0.00");
      this.cmagTextFieldArray[x].setText("-0.00");
      this.cspinTextFieldArray[x].setText("-0.00");
      this.cxbbTextFieldArray[x].setText("-0.00");
      this.iformTextFieldArray[x].setText("-0.00");
      this.iTextFieldArray[x].setText("-0.00");
    } 
    for (x = 0; x < 6; x++) {
      this.mcbTextFieldArray[x].setText("-0.00");
      this.scTextFieldArray[x].setText("-0.00");
    } 
    this.municionCoeficienteA0.setText("-0.00");
    this.municionCoeficienteA1.setText("-0.00");
    this.municionCoeficienteA2.setText("-0.00");
    this.municionCoeficienteA3.setText("-0.00");
    this.municionCoeficienteB1.setText("-0.00");
    this.municionCoeficienteB2.setText("-0.00");
    this.municionCoeficienteB3.setText("-0.00");
  }
  
  public boolean validateForm() {
    int x;
    for (x = 0; x < 14; x++) {
      validateField(this.machTextFieldArray[x], false);
      validateField(this.cdTextFieldArray[x], false);
      validateField(this.cdaTextFieldArray[x], false);
      validateField(this.clTextFieldArray[x], false);
      validateField(this.claTextFieldArray[x], false);
      validateField(this.cmTextFieldArray[x], false);
      validateField(this.cmaTextFieldArray[x], false);
      validateField(this.cmagTextFieldArray[x], false);
      validateField(this.cspinTextFieldArray[x], false);
      validateField(this.cxbbTextFieldArray[x], false);
      validateField(this.iformTextFieldArray[x], false);
      validateField(this.iTextFieldArray[x], false);
    } 
    for (x = 0; x < 6; x++) {
      validateField(this.mcbTextFieldArray[x], false);
      validateField(this.scTextFieldArray[x], false);
    } 
    validateField(this.municionCoeficienteA0, false);
    validateField(this.municionCoeficienteA1, false);
    validateField(this.municionCoeficienteA2, false);
    validateField(this.municionCoeficienteA3, false);
    validateField(this.municionCoeficienteB1, false);
    validateField(this.municionCoeficienteB2, false);
    validateField(this.municionCoeficienteB3, false);
    if (this.mach0
      .getStyleClass().contains("error") || this.mach1.getStyleClass().contains("error") || this.mach2
      .getStyleClass().contains("error") || this.mach3.getStyleClass().contains("error") || this.mach4
      .getStyleClass().contains("error") || this.mach5.getStyleClass().contains("error") || this.mach6
      .getStyleClass().contains("error") || this.mach7.getStyleClass().contains("error") || this.mach8
      .getStyleClass().contains("error") || this.mach9.getStyleClass().contains("error") || this.mach10
      .getStyleClass().contains("error") || this.mach11.getStyleClass().contains("error") || this.mach12
      .getStyleClass().contains("error") || this.mach13.getStyleClass().contains("error") || this.cd0
      
      .getStyleClass().contains("error") || this.cd1.getStyleClass().contains("error") || this.cd2
      .getStyleClass().contains("error") || this.cd3.getStyleClass().contains("error") || this.cd4
      .getStyleClass().contains("error") || this.cd5.getStyleClass().contains("error") || this.cd6
      .getStyleClass().contains("error") || this.cd7.getStyleClass().contains("error") || this.cd8
      .getStyleClass().contains("error") || this.cd9.getStyleClass().contains("error") || this.cd10
      .getStyleClass().contains("error") || this.cd11.getStyleClass().contains("error") || this.cd12
      .getStyleClass().contains("error") || this.cd13.getStyleClass().contains("error") || this.cda0
      
      .getStyleClass().contains("error") || this.cda1.getStyleClass().contains("error") || this.cda2
      .getStyleClass().contains("error") || this.cda3.getStyleClass().contains("error") || this.cda4
      .getStyleClass().contains("error") || this.cda5.getStyleClass().contains("error") || this.cda6
      .getStyleClass().contains("error") || this.cda7.getStyleClass().contains("error") || this.cda8
      .getStyleClass().contains("error") || this.cda9.getStyleClass().contains("error") || this.cda10
      .getStyleClass().contains("error") || this.cda11.getStyleClass().contains("error") || this.cda12
      .getStyleClass().contains("error") || this.cda13.getStyleClass().contains("error") || this.cl0
      
      .getStyleClass().contains("error") || this.cl1.getStyleClass().contains("error") || this.cl2
      .getStyleClass().contains("error") || this.cl3.getStyleClass().contains("error") || this.cl4
      .getStyleClass().contains("error") || this.cl5.getStyleClass().contains("error") || this.cl6
      .getStyleClass().contains("error") || this.cl7.getStyleClass().contains("error") || this.cl8
      .getStyleClass().contains("error") || this.cl9.getStyleClass().contains("error") || this.cl10
      .getStyleClass().contains("error") || this.cl11.getStyleClass().contains("error") || this.cl12
      .getStyleClass().contains("error") || this.cl13.getStyleClass().contains("error") || this.cla0
      
      .getStyleClass().contains("error") || this.cla1.getStyleClass().contains("error") || this.cla2
      .getStyleClass().contains("error") || this.cla3.getStyleClass().contains("error") || this.cla4
      .getStyleClass().contains("error") || this.cla5.getStyleClass().contains("error") || this.cla6
      .getStyleClass().contains("error") || this.cla7.getStyleClass().contains("error") || this.cla8
      .getStyleClass().contains("error") || this.cla9.getStyleClass().contains("error") || this.cla10
      .getStyleClass().contains("error") || this.cla11.getStyleClass().contains("error") || this.cla12
      .getStyleClass().contains("error") || this.cla13.getStyleClass().contains("error") || this.cm0
      
      .getStyleClass().contains("error") || this.cm1.getStyleClass().contains("error") || this.cm2
      .getStyleClass().contains("error") || this.cm3.getStyleClass().contains("error") || this.cm4
      .getStyleClass().contains("error") || this.cm5.getStyleClass().contains("error") || this.cm6
      .getStyleClass().contains("error") || this.cm7.getStyleClass().contains("error") || this.cm8
      .getStyleClass().contains("error") || this.cm9.getStyleClass().contains("error") || this.cm10
      .getStyleClass().contains("error") || this.cm11.getStyleClass().contains("error") || this.cm12
      .getStyleClass().contains("error") || this.cm13.getStyleClass().contains("error") || this.cma0
      
      .getStyleClass().contains("error") || this.cma1.getStyleClass().contains("error") || this.cma2
      .getStyleClass().contains("error") || this.cma3.getStyleClass().contains("error") || this.cma4
      .getStyleClass().contains("error") || this.cma5.getStyleClass().contains("error") || this.cma6
      .getStyleClass().contains("error") || this.cma7.getStyleClass().contains("error") || this.cma8
      .getStyleClass().contains("error") || this.cma9.getStyleClass().contains("error") || this.cma10
      .getStyleClass().contains("error") || this.cma11.getStyleClass().contains("error") || this.cma12
      .getStyleClass().contains("error") || this.cma13.getStyleClass().contains("error") || this.cmag0
      
      .getStyleClass().contains("error") || this.cmag1.getStyleClass().contains("error") || this.cmag2
      .getStyleClass().contains("error") || this.cmag3.getStyleClass().contains("error") || this.cmag4
      .getStyleClass().contains("error") || this.cmag5.getStyleClass().contains("error") || this.cmag6
      .getStyleClass().contains("error") || this.cmag7.getStyleClass().contains("error") || this.cmag8
      .getStyleClass().contains("error") || this.cmag9.getStyleClass().contains("error") || this.cmag10
      .getStyleClass().contains("error") || this.cmag11.getStyleClass().contains("error") || this.cmag12
      .getStyleClass().contains("error") || this.cmag13.getStyleClass().contains("error") || this.cspin0
      
      .getStyleClass().contains("error") || this.cspin1.getStyleClass().contains("error") || this.cspin2
      .getStyleClass().contains("error") || this.cspin3.getStyleClass().contains("error") || this.cspin4
      .getStyleClass().contains("error") || this.cspin5.getStyleClass().contains("error") || this.cspin6
      .getStyleClass().contains("error") || this.cspin7.getStyleClass().contains("error") || this.cspin8
      .getStyleClass().contains("error") || this.cspin9.getStyleClass().contains("error") || this.cspin10
      .getStyleClass().contains("error") || this.cspin11.getStyleClass().contains("error") || this.cspin12
      .getStyleClass().contains("error") || this.cspin13.getStyleClass().contains("error") || this.cxbb0
      
      .getStyleClass().contains("error") || this.cxbb1.getStyleClass().contains("error") || this.cxbb2
      .getStyleClass().contains("error") || this.cxbb3.getStyleClass().contains("error") || this.cxbb4
      .getStyleClass().contains("error") || this.cxbb5.getStyleClass().contains("error") || this.cxbb6
      .getStyleClass().contains("error") || this.cxbb7.getStyleClass().contains("error") || this.cxbb8
      .getStyleClass().contains("error") || this.cxbb9.getStyleClass().contains("error") || this.cxbb10
      .getStyleClass().contains("error") || this.cxbb11.getStyleClass().contains("error") || this.cxbb12
      .getStyleClass().contains("error") || this.cxbb13.getStyleClass().contains("error") || this.iform0
      
      .getStyleClass().contains("error") || this.iform1.getStyleClass().contains("error") || this.iform2
      .getStyleClass().contains("error") || this.iform3.getStyleClass().contains("error") || this.iform4
      .getStyleClass().contains("error") || this.iform5.getStyleClass().contains("error") || this.iform6
      .getStyleClass().contains("error") || this.iform7.getStyleClass().contains("error") || this.iform8
      .getStyleClass().contains("error") || this.iform9.getStyleClass().contains("error") || this.iform10
      .getStyleClass().contains("error") || this.iform11.getStyleClass().contains("error") || this.iform12
      .getStyleClass().contains("error") || this.iform13.getStyleClass().contains("error") || this.i0
      
      .getStyleClass().contains("error") || this.i1.getStyleClass().contains("error") || this.i2
      .getStyleClass().contains("error") || this.i3.getStyleClass().contains("error") || this.i4
      .getStyleClass().contains("error") || this.i5.getStyleClass().contains("error") || this.i6
      .getStyleClass().contains("error") || this.i7.getStyleClass().contains("error") || this.i8
      .getStyleClass().contains("error") || this.i9.getStyleClass().contains("error") || this.i10
      .getStyleClass().contains("error") || this.i11.getStyleClass().contains("error") || this.i12
      .getStyleClass().contains("error") || this.i13.getStyleClass().contains("error") || this.mcb0
      
      .getStyleClass().contains("error") || this.mcb1.getStyleClass().contains("error") || this.mcb2
      .getStyleClass().contains("error") || this.mcb3.getStyleClass().contains("error") || this.mcb4
      .getStyleClass().contains("error") || this.mcb5.getStyleClass().contains("error") || this.sc0
      
      .getStyleClass().contains("error") || this.sc1.getStyleClass().contains("error") || this.sc2
      .getStyleClass().contains("error") || this.sc3.getStyleClass().contains("error") || this.sc4
      .getStyleClass().contains("error") || this.sc5.getStyleClass().contains("error") || this.municionCoeficienteA0
      
      .getStyleClass().contains("error") || this.municionCoeficienteA1.getStyleClass().contains("error") || this.municionCoeficienteA2
      .getStyleClass().contains("error") || this.municionCoeficienteA3.getStyleClass().contains("error") || this.municionCoeficienteB1
      .getStyleClass().contains("error") || this.municionCoeficienteB2.getStyleClass().contains("error") || this.municionCoeficienteB3
      .getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  public double[] getMachArray() {
    this.machArray[0] = Double.parseDouble(this.mach0.getText());
    this.machArray[1] = Double.parseDouble(this.mach1.getText());
    this.machArray[2] = Double.parseDouble(this.mach2.getText());
    this.machArray[3] = Double.parseDouble(this.mach3.getText());
    this.machArray[4] = Double.parseDouble(this.mach4.getText());
    this.machArray[5] = Double.parseDouble(this.mach5.getText());
    this.machArray[6] = Double.parseDouble(this.mach6.getText());
    this.machArray[7] = Double.parseDouble(this.mach7.getText());
    this.machArray[8] = Double.parseDouble(this.mach8.getText());
    this.machArray[9] = Double.parseDouble(this.mach9.getText());
    this.machArray[10] = Double.parseDouble(this.mach10.getText());
    this.machArray[11] = Double.parseDouble(this.mach11.getText());
    this.machArray[12] = Double.parseDouble(this.mach12.getText());
    this.machArray[13] = Double.parseDouble(this.mach13.getText());
    return this.machArray;
  }
  
  public void setMachArray(double[] machArray) {
    this.machArray = machArray;
    this.mach0.setText(String.valueOf(machArray[0]));
    this.mach1.setText(String.valueOf(machArray[1]));
    this.mach2.setText(String.valueOf(machArray[2]));
    this.mach3.setText(String.valueOf(machArray[3]));
    this.mach4.setText(String.valueOf(machArray[4]));
    this.mach5.setText(String.valueOf(machArray[5]));
    this.mach6.setText(String.valueOf(machArray[6]));
    this.mach7.setText(String.valueOf(machArray[7]));
    this.mach8.setText(String.valueOf(machArray[8]));
    this.mach9.setText(String.valueOf(machArray[9]));
    this.mach10.setText(String.valueOf(machArray[10]));
    this.mach11.setText(String.valueOf(machArray[11]));
    this.mach12.setText(String.valueOf(machArray[12]));
    this.mach13.setText(String.valueOf(machArray[13]));
  }
  
  public double[] getCdArray() {
    this.cdArray[0] = Double.parseDouble(this.cd0.getText());
    this.cdArray[1] = Double.parseDouble(this.cd1.getText());
    this.cdArray[2] = Double.parseDouble(this.cd2.getText());
    this.cdArray[3] = Double.parseDouble(this.cd3.getText());
    this.cdArray[4] = Double.parseDouble(this.cd4.getText());
    this.cdArray[5] = Double.parseDouble(this.cd5.getText());
    this.cdArray[6] = Double.parseDouble(this.cd6.getText());
    this.cdArray[7] = Double.parseDouble(this.cd7.getText());
    this.cdArray[8] = Double.parseDouble(this.cd8.getText());
    this.cdArray[9] = Double.parseDouble(this.cd9.getText());
    this.cdArray[10] = Double.parseDouble(this.cd10.getText());
    this.cdArray[11] = Double.parseDouble(this.cd11.getText());
    this.cdArray[12] = Double.parseDouble(this.cd12.getText());
    this.cdArray[13] = Double.parseDouble(this.cd13.getText());
    return this.cdArray;
  }
  
  public void setCdArray(double[] cdArray) {
    this.cdArray = cdArray;
    this.cd0.setText(String.valueOf(cdArray[0]));
    this.cd1.setText(String.valueOf(cdArray[1]));
    this.cd2.setText(String.valueOf(cdArray[2]));
    this.cd3.setText(String.valueOf(cdArray[3]));
    this.cd4.setText(String.valueOf(cdArray[4]));
    this.cd5.setText(String.valueOf(cdArray[5]));
    this.cd6.setText(String.valueOf(cdArray[6]));
    this.cd7.setText(String.valueOf(cdArray[7]));
    this.cd8.setText(String.valueOf(cdArray[8]));
    this.cd9.setText(String.valueOf(cdArray[9]));
    this.cd10.setText(String.valueOf(cdArray[10]));
    this.cd11.setText(String.valueOf(cdArray[11]));
    this.cd12.setText(String.valueOf(cdArray[12]));
    this.cd13.setText(String.valueOf(cdArray[13]));
  }
  
  public double[] getCdaArray() {
    this.cdaArray[0] = Double.parseDouble(this.cda0.getText());
    this.cdaArray[1] = Double.parseDouble(this.cda1.getText());
    this.cdaArray[2] = Double.parseDouble(this.cda2.getText());
    this.cdaArray[3] = Double.parseDouble(this.cda3.getText());
    this.cdaArray[4] = Double.parseDouble(this.cda4.getText());
    this.cdaArray[5] = Double.parseDouble(this.cda5.getText());
    this.cdaArray[6] = Double.parseDouble(this.cda6.getText());
    this.cdaArray[7] = Double.parseDouble(this.cda7.getText());
    this.cdaArray[8] = Double.parseDouble(this.cda8.getText());
    this.cdaArray[9] = Double.parseDouble(this.cda9.getText());
    this.cdaArray[10] = Double.parseDouble(this.cda10.getText());
    this.cdaArray[11] = Double.parseDouble(this.cda11.getText());
    this.cdaArray[12] = Double.parseDouble(this.cda12.getText());
    this.cdaArray[13] = Double.parseDouble(this.cda13.getText());
    return this.cdaArray;
  }
  
  public void setCdaArray(double[] cdaArray) {
    this.cdaArray = cdaArray;
    this.cda0.setText(String.valueOf(cdaArray[0]));
    this.cda1.setText(String.valueOf(cdaArray[1]));
    this.cda2.setText(String.valueOf(cdaArray[2]));
    this.cda3.setText(String.valueOf(cdaArray[3]));
    this.cda4.setText(String.valueOf(cdaArray[4]));
    this.cda5.setText(String.valueOf(cdaArray[5]));
    this.cda6.setText(String.valueOf(cdaArray[6]));
    this.cda7.setText(String.valueOf(cdaArray[7]));
    this.cda8.setText(String.valueOf(cdaArray[8]));
    this.cda9.setText(String.valueOf(cdaArray[9]));
    this.cda10.setText(String.valueOf(cdaArray[10]));
    this.cda11.setText(String.valueOf(cdaArray[11]));
    this.cda12.setText(String.valueOf(cdaArray[12]));
    this.cda13.setText(String.valueOf(cdaArray[13]));
  }
  
  public double[] getClArray() {
    this.clArray[0] = Double.parseDouble(this.cl0.getText());
    this.clArray[1] = Double.parseDouble(this.cl1.getText());
    this.clArray[2] = Double.parseDouble(this.cl2.getText());
    this.clArray[3] = Double.parseDouble(this.cl3.getText());
    this.clArray[4] = Double.parseDouble(this.cl4.getText());
    this.clArray[5] = Double.parseDouble(this.cl5.getText());
    this.clArray[6] = Double.parseDouble(this.cl6.getText());
    this.clArray[7] = Double.parseDouble(this.cl7.getText());
    this.clArray[8] = Double.parseDouble(this.cl8.getText());
    this.clArray[9] = Double.parseDouble(this.cl9.getText());
    this.clArray[10] = Double.parseDouble(this.cl10.getText());
    this.clArray[11] = Double.parseDouble(this.cl11.getText());
    this.clArray[12] = Double.parseDouble(this.cl12.getText());
    this.clArray[13] = Double.parseDouble(this.cl13.getText());
    return this.clArray;
  }
  
  public void setClArray(double[] clArray) {
    this.clArray = clArray;
    this.cl0.setText(String.valueOf(clArray[0]));
    this.cl1.setText(String.valueOf(clArray[1]));
    this.cl2.setText(String.valueOf(clArray[2]));
    this.cl3.setText(String.valueOf(clArray[3]));
    this.cl4.setText(String.valueOf(clArray[4]));
    this.cl5.setText(String.valueOf(clArray[5]));
    this.cl6.setText(String.valueOf(clArray[6]));
    this.cl7.setText(String.valueOf(clArray[7]));
    this.cl8.setText(String.valueOf(clArray[8]));
    this.cl9.setText(String.valueOf(clArray[9]));
    this.cl10.setText(String.valueOf(clArray[10]));
    this.cl11.setText(String.valueOf(clArray[11]));
    this.cl12.setText(String.valueOf(clArray[12]));
    this.cl13.setText(String.valueOf(clArray[13]));
  }
  
  public double[] getClaArray() {
    this.claArray[0] = Double.parseDouble(this.cla0.getText());
    this.claArray[1] = Double.parseDouble(this.cla1.getText());
    this.claArray[2] = Double.parseDouble(this.cla2.getText());
    this.claArray[3] = Double.parseDouble(this.cla3.getText());
    this.claArray[4] = Double.parseDouble(this.cla4.getText());
    this.claArray[5] = Double.parseDouble(this.cla5.getText());
    this.claArray[6] = Double.parseDouble(this.cla6.getText());
    this.claArray[7] = Double.parseDouble(this.cla7.getText());
    this.claArray[8] = Double.parseDouble(this.cla8.getText());
    this.claArray[9] = Double.parseDouble(this.cla9.getText());
    this.claArray[10] = Double.parseDouble(this.cla10.getText());
    this.claArray[11] = Double.parseDouble(this.cla11.getText());
    this.claArray[12] = Double.parseDouble(this.cla12.getText());
    this.claArray[13] = Double.parseDouble(this.cla13.getText());
    return this.claArray;
  }
  
  public void setClaArray(double[] claArray) {
    this.claArray = claArray;
    this.cla0.setText(String.valueOf(claArray[0]));
    this.cla1.setText(String.valueOf(claArray[1]));
    this.cla2.setText(String.valueOf(claArray[2]));
    this.cla3.setText(String.valueOf(claArray[3]));
    this.cla4.setText(String.valueOf(claArray[4]));
    this.cla5.setText(String.valueOf(claArray[5]));
    this.cla6.setText(String.valueOf(claArray[6]));
    this.cla7.setText(String.valueOf(claArray[7]));
    this.cla8.setText(String.valueOf(claArray[8]));
    this.cla9.setText(String.valueOf(claArray[9]));
    this.cla10.setText(String.valueOf(claArray[10]));
    this.cla11.setText(String.valueOf(claArray[11]));
    this.cla12.setText(String.valueOf(claArray[12]));
    this.cla13.setText(String.valueOf(claArray[13]));
  }
  
  public double[] getCmArray() {
    this.cmArray[0] = Double.parseDouble(this.cm0.getText());
    this.cmArray[1] = Double.parseDouble(this.cm1.getText());
    this.cmArray[2] = Double.parseDouble(this.cm2.getText());
    this.cmArray[3] = Double.parseDouble(this.cm3.getText());
    this.cmArray[4] = Double.parseDouble(this.cm4.getText());
    this.cmArray[5] = Double.parseDouble(this.cm5.getText());
    this.cmArray[6] = Double.parseDouble(this.cm6.getText());
    this.cmArray[7] = Double.parseDouble(this.cm7.getText());
    this.cmArray[8] = Double.parseDouble(this.cm8.getText());
    this.cmArray[9] = Double.parseDouble(this.cm9.getText());
    this.cmArray[10] = Double.parseDouble(this.cm10.getText());
    this.cmArray[11] = Double.parseDouble(this.cm11.getText());
    this.cmArray[12] = Double.parseDouble(this.cm12.getText());
    this.cmArray[13] = Double.parseDouble(this.cm13.getText());
    return this.cmArray;
  }
  
  public void setCmArray(double[] cmArray) {
    this.cmArray = cmArray;
    this.cm0.setText(String.valueOf(cmArray[0]));
    this.cm1.setText(String.valueOf(cmArray[1]));
    this.cm2.setText(String.valueOf(cmArray[2]));
    this.cm3.setText(String.valueOf(cmArray[3]));
    this.cm4.setText(String.valueOf(cmArray[4]));
    this.cm5.setText(String.valueOf(cmArray[5]));
    this.cm6.setText(String.valueOf(cmArray[6]));
    this.cm7.setText(String.valueOf(cmArray[7]));
    this.cm8.setText(String.valueOf(cmArray[8]));
    this.cm9.setText(String.valueOf(cmArray[9]));
    this.cm10.setText(String.valueOf(cmArray[10]));
    this.cm11.setText(String.valueOf(cmArray[11]));
    this.cm12.setText(String.valueOf(cmArray[12]));
    this.cm13.setText(String.valueOf(cmArray[13]));
  }
  
  public double[] getCmaArray() {
    this.cmaArray[0] = Double.parseDouble(this.cma0.getText());
    this.cmaArray[1] = Double.parseDouble(this.cma1.getText());
    this.cmaArray[2] = Double.parseDouble(this.cma2.getText());
    this.cmaArray[3] = Double.parseDouble(this.cma3.getText());
    this.cmaArray[4] = Double.parseDouble(this.cma4.getText());
    this.cmaArray[5] = Double.parseDouble(this.cma5.getText());
    this.cmaArray[6] = Double.parseDouble(this.cma6.getText());
    this.cmaArray[7] = Double.parseDouble(this.cma7.getText());
    this.cmaArray[8] = Double.parseDouble(this.cma8.getText());
    this.cmaArray[9] = Double.parseDouble(this.cma9.getText());
    this.cmaArray[10] = Double.parseDouble(this.cma10.getText());
    this.cmaArray[11] = Double.parseDouble(this.cma11.getText());
    this.cmaArray[12] = Double.parseDouble(this.cma12.getText());
    this.cmaArray[13] = Double.parseDouble(this.cma13.getText());
    return this.cmaArray;
  }
  
  public void setCmaArray(double[] cmaArray) {
    this.cmaArray = cmaArray;
    this.cma0.setText(String.valueOf(cmaArray[0]));
    this.cma1.setText(String.valueOf(cmaArray[1]));
    this.cma2.setText(String.valueOf(cmaArray[2]));
    this.cma3.setText(String.valueOf(cmaArray[3]));
    this.cma4.setText(String.valueOf(cmaArray[4]));
    this.cma5.setText(String.valueOf(cmaArray[5]));
    this.cma6.setText(String.valueOf(cmaArray[6]));
    this.cma7.setText(String.valueOf(cmaArray[7]));
    this.cma8.setText(String.valueOf(cmaArray[8]));
    this.cma9.setText(String.valueOf(cmaArray[9]));
    this.cma10.setText(String.valueOf(cmaArray[10]));
    this.cma11.setText(String.valueOf(cmaArray[11]));
    this.cma12.setText(String.valueOf(cmaArray[12]));
    this.cma13.setText(String.valueOf(cmaArray[13]));
  }
  
  public double[] getCmagArray() {
    this.cmagArray[0] = Double.parseDouble(this.cmag0.getText());
    this.cmagArray[1] = Double.parseDouble(this.cmag1.getText());
    this.cmagArray[2] = Double.parseDouble(this.cmag2.getText());
    this.cmagArray[3] = Double.parseDouble(this.cmag3.getText());
    this.cmagArray[4] = Double.parseDouble(this.cmag4.getText());
    this.cmagArray[5] = Double.parseDouble(this.cmag5.getText());
    this.cmagArray[6] = Double.parseDouble(this.cmag6.getText());
    this.cmagArray[7] = Double.parseDouble(this.cmag7.getText());
    this.cmagArray[8] = Double.parseDouble(this.cmag8.getText());
    this.cmagArray[9] = Double.parseDouble(this.cmag9.getText());
    this.cmagArray[10] = Double.parseDouble(this.cmag10.getText());
    this.cmagArray[11] = Double.parseDouble(this.cmag11.getText());
    this.cmagArray[12] = Double.parseDouble(this.cmag12.getText());
    this.cmagArray[13] = Double.parseDouble(this.cmag13.getText());
    return this.cmagArray;
  }
  
  public void setCmagArray(double[] cmagArray) {
    this.cmagArray = cmagArray;
    this.cmag0.setText(String.valueOf(cmagArray[0]));
    this.cmag1.setText(String.valueOf(cmagArray[1]));
    this.cmag2.setText(String.valueOf(cmagArray[2]));
    this.cmag3.setText(String.valueOf(cmagArray[3]));
    this.cmag4.setText(String.valueOf(cmagArray[4]));
    this.cmag5.setText(String.valueOf(cmagArray[5]));
    this.cmag6.setText(String.valueOf(cmagArray[6]));
    this.cmag7.setText(String.valueOf(cmagArray[7]));
    this.cmag8.setText(String.valueOf(cmagArray[8]));
    this.cmag9.setText(String.valueOf(cmagArray[9]));
    this.cmag10.setText(String.valueOf(cmagArray[10]));
    this.cmag11.setText(String.valueOf(cmagArray[11]));
    this.cmag12.setText(String.valueOf(cmagArray[12]));
    this.cmag13.setText(String.valueOf(cmagArray[13]));
  }
  
  public double[] getCspinArray() {
    this.cspinArray[0] = Double.parseDouble(this.cspin0.getText());
    this.cspinArray[1] = Double.parseDouble(this.cspin1.getText());
    this.cspinArray[2] = Double.parseDouble(this.cspin2.getText());
    this.cspinArray[3] = Double.parseDouble(this.cspin3.getText());
    this.cspinArray[4] = Double.parseDouble(this.cspin4.getText());
    this.cspinArray[5] = Double.parseDouble(this.cspin5.getText());
    this.cspinArray[6] = Double.parseDouble(this.cspin6.getText());
    this.cspinArray[7] = Double.parseDouble(this.cspin7.getText());
    this.cspinArray[8] = Double.parseDouble(this.cspin8.getText());
    this.cspinArray[9] = Double.parseDouble(this.cspin9.getText());
    this.cspinArray[10] = Double.parseDouble(this.cspin10.getText());
    this.cspinArray[11] = Double.parseDouble(this.cspin11.getText());
    this.cspinArray[12] = Double.parseDouble(this.cspin12.getText());
    this.cspinArray[13] = Double.parseDouble(this.cspin13.getText());
    return this.cspinArray;
  }
  
  public void setCspinArray(double[] cspinArray) {
    this.cspinArray = cspinArray;
    this.cspin0.setText(String.valueOf(cspinArray[0]));
    this.cspin1.setText(String.valueOf(cspinArray[1]));
    this.cspin2.setText(String.valueOf(cspinArray[2]));
    this.cspin3.setText(String.valueOf(cspinArray[3]));
    this.cspin4.setText(String.valueOf(cspinArray[4]));
    this.cspin5.setText(String.valueOf(cspinArray[5]));
    this.cspin6.setText(String.valueOf(cspinArray[6]));
    this.cspin7.setText(String.valueOf(cspinArray[7]));
    this.cspin8.setText(String.valueOf(cspinArray[8]));
    this.cspin9.setText(String.valueOf(cspinArray[9]));
    this.cspin10.setText(String.valueOf(cspinArray[10]));
    this.cspin11.setText(String.valueOf(cspinArray[11]));
    this.cspin12.setText(String.valueOf(cspinArray[12]));
    this.cspin13.setText(String.valueOf(cspinArray[13]));
  }
  
  public double[] getCxbbArray() {
    this.cxbbArray[0] = Double.parseDouble(this.cxbb0.getText());
    this.cxbbArray[1] = Double.parseDouble(this.cxbb1.getText());
    this.cxbbArray[2] = Double.parseDouble(this.cxbb2.getText());
    this.cxbbArray[3] = Double.parseDouble(this.cxbb3.getText());
    this.cxbbArray[4] = Double.parseDouble(this.cxbb4.getText());
    this.cxbbArray[5] = Double.parseDouble(this.cxbb5.getText());
    this.cxbbArray[6] = Double.parseDouble(this.cxbb6.getText());
    this.cxbbArray[7] = Double.parseDouble(this.cxbb7.getText());
    this.cxbbArray[8] = Double.parseDouble(this.cxbb8.getText());
    this.cxbbArray[9] = Double.parseDouble(this.cxbb9.getText());
    this.cxbbArray[10] = Double.parseDouble(this.cxbb10.getText());
    this.cxbbArray[11] = Double.parseDouble(this.cxbb11.getText());
    this.cxbbArray[12] = Double.parseDouble(this.cxbb12.getText());
    this.cxbbArray[13] = Double.parseDouble(this.cxbb13.getText());
    return this.cxbbArray;
  }
  
  public void setCxbbArray(double[] cxbbArray) {
    this.cxbbArray = cxbbArray;
    this.cxbb0.setText(String.valueOf(cxbbArray[0]));
    this.cxbb1.setText(String.valueOf(cxbbArray[1]));
    this.cxbb2.setText(String.valueOf(cxbbArray[2]));
    this.cxbb3.setText(String.valueOf(cxbbArray[3]));
    this.cxbb4.setText(String.valueOf(cxbbArray[4]));
    this.cxbb5.setText(String.valueOf(cxbbArray[5]));
    this.cxbb6.setText(String.valueOf(cxbbArray[6]));
    this.cxbb7.setText(String.valueOf(cxbbArray[7]));
    this.cxbb8.setText(String.valueOf(cxbbArray[8]));
    this.cxbb9.setText(String.valueOf(cxbbArray[9]));
    this.cxbb10.setText(String.valueOf(cxbbArray[10]));
    this.cxbb11.setText(String.valueOf(cxbbArray[11]));
    this.cxbb12.setText(String.valueOf(cxbbArray[12]));
    this.cxbb13.setText(String.valueOf(cxbbArray[13]));
  }
  
  public double[] getIformArray() {
    this.iformArray[0] = Double.parseDouble(this.iform0.getText());
    this.iformArray[1] = Double.parseDouble(this.iform1.getText());
    this.iformArray[2] = Double.parseDouble(this.iform2.getText());
    this.iformArray[3] = Double.parseDouble(this.iform3.getText());
    this.iformArray[4] = Double.parseDouble(this.iform4.getText());
    this.iformArray[5] = Double.parseDouble(this.iform5.getText());
    this.iformArray[6] = Double.parseDouble(this.iform6.getText());
    this.iformArray[7] = Double.parseDouble(this.iform7.getText());
    this.iformArray[8] = Double.parseDouble(this.iform8.getText());
    this.iformArray[9] = Double.parseDouble(this.iform9.getText());
    this.iformArray[10] = Double.parseDouble(this.iform10.getText());
    this.iformArray[11] = Double.parseDouble(this.iform11.getText());
    this.iformArray[12] = Double.parseDouble(this.iform12.getText());
    this.iformArray[13] = Double.parseDouble(this.iform13.getText());
    return this.iformArray;
  }
  
  public void setIformArray(double[] iformArray) {
    this.iformArray = iformArray;
    this.iform0.setText(String.valueOf(iformArray[0]));
    this.iform1.setText(String.valueOf(iformArray[1]));
    this.iform2.setText(String.valueOf(iformArray[2]));
    this.iform3.setText(String.valueOf(iformArray[3]));
    this.iform4.setText(String.valueOf(iformArray[4]));
    this.iform5.setText(String.valueOf(iformArray[5]));
    this.iform6.setText(String.valueOf(iformArray[6]));
    this.iform7.setText(String.valueOf(iformArray[7]));
    this.iform8.setText(String.valueOf(iformArray[8]));
    this.iform9.setText(String.valueOf(iformArray[9]));
    this.iform10.setText(String.valueOf(iformArray[10]));
    this.iform11.setText(String.valueOf(iformArray[11]));
    this.iform12.setText(String.valueOf(iformArray[12]));
    this.iform13.setText(String.valueOf(iformArray[13]));
  }
  
  public double[] getiArray() {
    this.iArray[0] = Double.parseDouble(this.i0.getText());
    this.iArray[1] = Double.parseDouble(this.i1.getText());
    this.iArray[2] = Double.parseDouble(this.i2.getText());
    this.iArray[3] = Double.parseDouble(this.i3.getText());
    this.iArray[4] = Double.parseDouble(this.i4.getText());
    this.iArray[5] = Double.parseDouble(this.i5.getText());
    this.iArray[6] = Double.parseDouble(this.i6.getText());
    this.iArray[7] = Double.parseDouble(this.i7.getText());
    this.iArray[8] = Double.parseDouble(this.i8.getText());
    this.iArray[9] = Double.parseDouble(this.i9.getText());
    this.iArray[10] = Double.parseDouble(this.i10.getText());
    this.iArray[11] = Double.parseDouble(this.i11.getText());
    this.iArray[12] = Double.parseDouble(this.i12.getText());
    this.iArray[13] = Double.parseDouble(this.i13.getText());
    return this.iArray;
  }
  
  public void setiArray(double[] iArray) {
    this.iArray = iArray;
    this.i0.setText(String.valueOf(iArray[0]));
    this.i1.setText(String.valueOf(iArray[1]));
    this.i2.setText(String.valueOf(iArray[2]));
    this.i3.setText(String.valueOf(iArray[3]));
    this.i4.setText(String.valueOf(iArray[4]));
    this.i5.setText(String.valueOf(iArray[5]));
    this.i6.setText(String.valueOf(iArray[6]));
    this.i7.setText(String.valueOf(iArray[7]));
    this.i8.setText(String.valueOf(iArray[8]));
    this.i9.setText(String.valueOf(iArray[9]));
    this.i10.setText(String.valueOf(iArray[10]));
    this.i11.setText(String.valueOf(iArray[11]));
    this.i12.setText(String.valueOf(iArray[12]));
    this.i13.setText(String.valueOf(iArray[13]));
  }
  
  public double[] getMcbArray() {
    this.mcbArray[0] = Double.parseDouble(this.mcb0.getText());
    this.mcbArray[1] = Double.parseDouble(this.mcb1.getText());
    this.mcbArray[2] = Double.parseDouble(this.mcb2.getText());
    this.mcbArray[3] = Double.parseDouble(this.mcb3.getText());
    this.mcbArray[4] = Double.parseDouble(this.mcb4.getText());
    this.mcbArray[5] = Double.parseDouble(this.mcb5.getText());
    return this.mcbArray;
  }
  
  public void setMcbArray(double[] mcbArray) {
    this.mcbArray = mcbArray;
    this.mcb0.setText(String.valueOf(mcbArray[0]));
    this.mcb1.setText(String.valueOf(mcbArray[1]));
    this.mcb2.setText(String.valueOf(mcbArray[2]));
    this.mcb3.setText(String.valueOf(mcbArray[3]));
    this.mcb4.setText(String.valueOf(mcbArray[4]));
    this.mcb5.setText(String.valueOf(mcbArray[5]));
  }
  
  public double[] getScArray() {
    this.scArray[0] = Double.parseDouble(this.sc0.getText());
    this.scArray[1] = Double.parseDouble(this.sc1.getText());
    this.scArray[2] = Double.parseDouble(this.sc2.getText());
    this.scArray[3] = Double.parseDouble(this.sc3.getText());
    this.scArray[4] = Double.parseDouble(this.sc4.getText());
    this.scArray[5] = Double.parseDouble(this.sc5.getText());
    return this.scArray;
  }
  
  public void setScArray(double[] scArray) {
    this.scArray = scArray;
    this.sc0.setText(String.valueOf(scArray[0]));
    this.sc1.setText(String.valueOf(scArray[1]));
    this.sc2.setText(String.valueOf(scArray[2]));
    this.sc3.setText(String.valueOf(scArray[3]));
    this.sc4.setText(String.valueOf(scArray[4]));
    this.sc5.setText(String.valueOf(scArray[5]));
  }
  
  public double getCoeficienteA0() {
    this.coeficienteA0 = Double.parseDouble(this.municionCoeficienteA0.getText());
    return this.coeficienteA0;
  }
  
  public void setCoeficienteA0(double coeficienteA0) {
    this.coeficienteA0 = coeficienteA0;
    this.municionCoeficienteA0.setText(String.valueOf(coeficienteA0));
  }
  
  public double getCoeficienteA1() {
    this.coeficienteA1 = Double.parseDouble(this.municionCoeficienteA1.getText());
    return this.coeficienteA1;
  }
  
  public void setCoeficienteA1(double coeficienteA1) {
    this.coeficienteA1 = coeficienteA1;
    this.municionCoeficienteA1.setText(String.valueOf(coeficienteA1));
  }
  
  public double getCoeficienteA2() {
    this.coeficienteA2 = Double.parseDouble(this.municionCoeficienteA2.getText());
    return this.coeficienteA2;
  }
  
  public void setCoeficienteA2(double coeficienteA2) {
    this.coeficienteA2 = coeficienteA2;
    this.municionCoeficienteA2.setText(String.valueOf(coeficienteA2));
  }
  
  public double getCoeficienteA3() {
    this.coeficienteA3 = Double.parseDouble(this.municionCoeficienteA3.getText());
    return this.coeficienteA3;
  }
  
  public void setCoeficienteA3(double coeficienteA3) {
    this.coeficienteA3 = coeficienteA3;
    this.municionCoeficienteA3.setText(String.valueOf(coeficienteA3));
  }
  
  public double getCoeficienteB1() {
    this.coeficienteB1 = Double.parseDouble(this.municionCoeficienteB1.getText());
    return this.coeficienteB1;
  }
  
  public void setCoeficienteB1(double coeficienteB1) {
    this.coeficienteB1 = coeficienteB1;
    this.municionCoeficienteB1.setText(String.valueOf(coeficienteB1));
  }
  
  public double getCoeficienteB2() {
    this.coeficienteB2 = Double.parseDouble(this.municionCoeficienteB2.getText());
    return this.coeficienteB2;
  }
  
  public void setCoeficienteB2(double coeficienteB2) {
    this.coeficienteB2 = coeficienteB2;
    this.municionCoeficienteB2.setText(String.valueOf(coeficienteB2));
  }
  
  public double getCoeficienteB3() {
    this.coeficienteB3 = Double.parseDouble(this.municionCoeficienteB3.getText());
    return this.coeficienteB3;
  }
  
  public void setCoeficienteB3(double coeficienteB3) {
    this.coeficienteB3 = coeficienteB3;
    this.municionCoeficienteB3.setText(String.valueOf(coeficienteB3));
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammo\CoefAmmoAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */