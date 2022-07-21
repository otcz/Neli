package co.dynamicts.neli.ui.component.ammo;

import co.dynamicts.Main;
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

public class ZonAmmoAdd extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField tipoMunicion;
  
  @FXML
  private TextField diametroMunicion;
  
  @FXML
  private TextField aceleracionMunicion;
  
  @FXML
  private TextField municionNumZonas;
  
  @FXML
  private TextField municionPesoProyectil;
  
  @FXML
  private TextField municionPesoSTD;
  
  @FXML
  private TextField cambioMunicionPeso;
  
  @FXML
  private TextField municionIx0;
  
  @FXML
  private TextField municionTc;
  
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
  
  private TextField[] machArray = new TextField[13];
  
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
  
  private TextField[] cdArray = new TextField[13];
  
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
  
  private TextField[] cdaArray = new TextField[13];
  
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
  
  private TextField[] clArray = new TextField[13];
  
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
  
  private TextField[] claArray = new TextField[13];
  
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
  
  private TextField[] cmArray = new TextField[13];
  
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
  
  private TextField[] cmaArray = new TextField[13];
  
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
  
  private TextField[] cmagArray = new TextField[13];
  
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
  
  private TextField[] cspinArray = new TextField[13];
  
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
  
  private TextField[] cxbbArray = new TextField[13];
  
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
  
  private TextField[] iformArray = new TextField[13];
  
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
  
  private TextField[] iArray = new TextField[13];
  
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
  
  private TextField[] mcbArray = new TextField[5];
  
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
  
  private TextField[] scArray = new TextField[5];
  
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
  
  @FXML
  private TextField zone0;
  
  @FXML
  private TextField zone1;
  
  @FXML
  private TextField zone2;
  
  @FXML
  private TextField zone3;
  
  @FXML
  private TextField zone4;
  
  @FXML
  private TextField zone5;
  
  @FXML
  private TextField zone6;
  
  private TextField[] zoneArray = new TextField[6];
  
  @FXML
  private TextField vel0;
  
  @FXML
  private TextField vel1;
  
  @FXML
  private TextField vel2;
  
  @FXML
  private TextField vel3;
  
  @FXML
  private TextField vel4;
  
  @FXML
  private TextField vel5;
  
  @FXML
  private TextField vel6;
  
  private TextField[] velArray = new TextField[6];
  
  @FXML
  private TextField ajCD0;
  
  @FXML
  private TextField ajCD1;
  
  @FXML
  private TextField ajCD2;
  
  @FXML
  private TextField ajCD3;
  
  @FXML
  private TextField ajCD4;
  
  @FXML
  private TextField ajCD5;
  
  @FXML
  private TextField ajCD6;
  
  private TextField[] ajCDArray = new TextField[6];
  
  @FXML
  private TextField ajCL0;
  
  @FXML
  private TextField ajCL1;
  
  @FXML
  private TextField ajCL2;
  
  @FXML
  private TextField ajCL3;
  
  @FXML
  private TextField ajCL4;
  
  @FXML
  private TextField ajCL5;
  
  @FXML
  private TextField ajCL6;
  
  private TextField[] ajCLArray = new TextField[6];
  
  @FXML
  private TextField ajK0;
  
  @FXML
  private TextField ajK1;
  
  @FXML
  private TextField ajK2;
  
  @FXML
  private TextField ajK3;
  
  @FXML
  private TextField ajK4;
  
  @FXML
  private TextField ajK5;
  
  @FXML
  private TextField ajK6;
  
  private TextField[] ajKArray = new TextField[6];
  
  @FXML
  private TextField ajFibb0;
  
  @FXML
  private TextField ajFibb1;
  
  @FXML
  private TextField ajFibb2;
  
  @FXML
  private TextField ajFibb3;
  
  @FXML
  private TextField ajFibb4;
  
  @FXML
  private TextField ajFibb5;
  
  @FXML
  private TextField ajFibb6;
  
  private TextField[] ajFibbArray = new TextField[6];
  
  @FXML
  private TextField prop0;
  
  @FXML
  private TextField prop1;
  
  @FXML
  private TextField prop2;
  
  @FXML
  private TextField prop3;
  
  @FXML
  private TextField prop4;
  
  @FXML
  private TextField prop5;
  
  @FXML
  private TextField prop6;
  
  private TextField[] propArray = new TextField[6];
  
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
  
  private TextField[] gradTempArray = new TextField[6];
  
  @FXML
  private TextField pesoVel0;
  
  @FXML
  private TextField pesoVel1;
  
  @FXML
  private TextField pesoVel2;
  
  @FXML
  private TextField pesoVel3;
  
  @FXML
  private TextField pesoVel4;
  
  @FXML
  private TextField pesoVel5;
  
  @FXML
  private TextField pesoVel6;
  
  private TextField[] pesoVelArray = new TextField[6];
  
  @FXML
  private TextField espoleta1;
  
  @FXML
  private TextField pesoEspoleta1;
  
  @FXML
  private TextField efectoEspoleta1;
  
  @FXML
  private TextField espoleta2;
  
  @FXML
  private TextField pesoEspoleta2;
  
  @FXML
  private TextField efectoEspoleta2;
  
  @FXML
  private TextField espoleta3;
  
  @FXML
  private TextField pesoEspoleta3;
  
  @FXML
  private TextField efectoEspoleta3;
  
  @FXML
  private TextField parametrosBbKP;
  
  @FXML
  private TextField parametrosBbMcb;
  
  @FXML
  private TextField parametrosBbMf;
  
  @FXML
  private TextField parametrosBbPp;
  
  @FXML
  private TextField parametrosBbSc;
  
  @FXML
  private TextField parametrosBbTdi;
  
  @FXML
  private TextField parametrosBbXcg;
  
  @FXML
  private TextField parametrosBbXcgb;
  
  @FXML
  private TextField parametrosBbVc;
  
  @FXML
  private TextField parametrosBbBeta;
  
  @FXML
  private TextField parametrosBbK;
  
  @FXML
  private TextField parametrosBbN;
  
  @FXML
  private TextField parametrosBbTb;
  
  @FXML
  private TextField parametrosBbI;
  
  @FXML
  private TextField parametrosBbDb;
  
  @FXML
  private TextField municionVelocidad;
  
  @FXML
  private TextField municionDrag;
  
  @FXML
  private TextField municionElevacion;
  
  @FXML
  private TextField municionA0;
  
  @FXML
  private TextField municionA1;
  
  @FXML
  private TextField municionDesviacionSuperficie;
  
  @FXML
  private TextField municionDesviacionAzimut;
  
  @FXML
  private TextField municionDesviacionUbicacionDistancia;
  
  @FXML
  private TextField municionDesviacionUbicacionAzimut;
  
  public ZonAmmoAdd() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/interfaces/ammo_add.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    updateComponents();
    initArrays();
    dataChange();
    clearForm();
  }
  
  private void initArrays() {
    int x;
    for (x = 0; x < 13; x++) {
      this.machArray[x] = new TextField();
      this.cdArray[x] = new TextField();
      this.cdaArray[x] = new TextField();
      this.clArray[x] = new TextField();
      this.claArray[x] = new TextField();
      this.cmArray[x] = new TextField();
      this.cmaArray[x] = new TextField();
      this.cmagArray[x] = new TextField();
      this.cspinArray[x] = new TextField();
      this.cxbbArray[x] = new TextField();
      this.iformArray[x] = new TextField();
      this.iArray[x] = new TextField();
    } 
    this.machArray = new TextField[] { 
        this.mach0, this.mach1, this.mach2, this.mach3, this.mach4, this.mach5, this.mach6, this.mach7, this.mach8, this.mach9, 
        this.mach10, this.mach11, this.mach12, this.mach13 };
    this.cdArray = new TextField[] { 
        this.cd0, this.cd1, this.cd2, this.cd3, this.cd4, this.cd5, this.cd6, this.cd7, this.cd8, this.cd9, 
        this.cd10, this.cd11, this.cd12, this.cd13 };
    this.cdaArray = new TextField[] { 
        this.cda0, this.cda1, this.cda2, this.cda3, this.cda4, this.cda5, this.cda6, this.cda7, this.cda8, this.cda9, 
        this.cda10, this.cda11, this.cda12, this.cda13 };
    this.clArray = new TextField[] { 
        this.cl0, this.cl1, this.cl2, this.cl3, this.cl4, this.cl5, this.cl6, this.cl7, this.cl8, this.cl9, 
        this.cl10, this.cl11, this.cl12, this.cl13 };
    this.claArray = new TextField[] { 
        this.cla0, this.cla1, this.cla2, this.cla3, this.cla4, this.cla5, this.cla6, this.cla7, this.cla8, this.cla9, 
        this.cla10, this.cla11, this.cla12, this.cla13 };
    this.cmArray = new TextField[] { 
        this.cm0, this.cm1, this.cm2, this.cm3, this.cm4, this.cm5, this.cm6, this.cm7, this.cm8, this.cm9, 
        this.cm10, this.cm11, this.cm12, this.cm13 };
    this.cmaArray = new TextField[] { 
        this.cma0, this.cma1, this.cma2, this.cma3, this.cma4, this.cma5, this.cma6, this.cma7, this.cma8, this.cma9, 
        this.cma10, this.cma11, this.cma12, this.cma13 };
    this.cmagArray = new TextField[] { 
        this.cmag0, this.cmag1, this.cmag2, this.cmag3, this.cmag4, this.cmag5, this.cmag6, this.cmag7, this.cmag8, this.cmag9, 
        this.cmag10, this.cmag11, this.cmag12, this.cmag13 };
    this.cspinArray = new TextField[] { 
        this.cspin0, this.cspin1, this.cspin2, this.cspin3, this.cspin4, this.cspin5, this.cspin6, this.cspin7, this.cspin8, this.cspin9, 
        this.cspin10, this.cspin11, this.cspin12, this.cspin13 };
    this.cxbbArray = new TextField[] { 
        this.cxbb0, this.cxbb1, this.cxbb2, this.cxbb3, this.cxbb4, this.cxbb5, this.cxbb6, this.cxbb7, this.cxbb8, this.cxbb9, 
        this.cxbb10, this.cxbb11, this.cxbb12, this.cxbb13 };
    this.iformArray = new TextField[] { 
        this.iform0, this.iform1, this.iform2, this.iform3, this.iform4, this.iform5, this.iform6, this.iform7, this.iform8, this.iform9, 
        this.iform10, this.iform11, this.iform12, this.iform13 };
    this.iArray = new TextField[] { 
        this.i0, this.i1, this.i2, this.i3, this.i4, this.i5, this.i6, this.i7, this.i8, this.i9, 
        this.i10, this.i11, this.i12, this.i13 };
    for (x = 0; x < 5; x++) {
      this.mcbArray[x] = new TextField();
      this.scArray[x] = new TextField();
    } 
    this.mcbArray = new TextField[] { this.mcb0, this.mcb1, this.mcb2, this.mcb3, this.mcb4, this.mcb5 };
    this.scArray = new TextField[] { this.sc0, this.sc1, this.sc2, this.sc3, this.sc4, this.sc5 };
    for (x = 0; x < 6; x++) {
      this.zoneArray[x] = new TextField();
      this.velArray[x] = new TextField();
      this.ajCDArray[x] = new TextField();
      this.ajCLArray[x] = new TextField();
      this.ajKArray[x] = new TextField();
      this.ajFibbArray[x] = new TextField();
      this.propArray[x] = new TextField();
      this.gradTempArray[x] = new TextField();
      this.pesoVelArray[x] = new TextField();
    } 
    this.zoneArray = new TextField[] { this.zone0, this.zone1, this.zone2, this.zone3, this.zone4, this.zone5, this.zone6 };
    this.velArray = new TextField[] { this.vel0, this.vel1, this.vel2, this.vel3, this.vel4, this.vel5, this.vel6 };
    this.ajCDArray = new TextField[] { this.ajCD0, this.ajCD1, this.ajCD2, this.ajCD3, this.ajCD4, this.ajCD5, this.ajCD6 };
    this.ajCLArray = new TextField[] { this.ajCL0, this.ajCL1, this.ajCL2, this.ajCL3, this.ajCL4, this.ajCL5, this.ajCL6 };
    this.ajKArray = new TextField[] { this.ajK0, this.ajK1, this.ajK2, this.ajK3, this.ajK4, this.ajK5, this.ajK6 };
    this.ajFibbArray = new TextField[] { this.ajFibb0, this.ajFibb1, this.ajFibb2, this.ajFibb3, this.ajFibb4, this.ajFibb5, this.ajFibb6 };
    this.propArray = new TextField[] { this.prop0, this.prop1, this.prop2, this.prop3, this.prop4, this.prop5, this.prop6 };
    this.gradTempArray = new TextField[] { this.gradTemp0, this.gradTemp1, this.gradTemp2, this.gradTemp3, this.gradTemp4, this.gradTemp5, this.gradTemp6 };
    this.pesoVelArray = new TextField[] { this.pesoVel0, this.pesoVel1, this.pesoVel2, this.pesoVel3, this.pesoVel4, this.pesoVel5, this.pesoVel6 };
  }
  
  private void dataChange() {
    this.tipoMunicion.getProperties().put("vkType", "numeric");
    this.diametroMunicion.getProperties().put("vkType", "numeric");
    this.aceleracionMunicion.getProperties().put("vkType", "numeric");
    this.municionNumZonas.getProperties().put("vkType", "numeric");
    this.municionPesoProyectil.getProperties().put("vkType", "numeric");
    this.municionPesoSTD.getProperties().put("vkType", "numeric");
    this.cambioMunicionPeso.getProperties().put("vkType", "numeric");
    this.municionIx0.getProperties().put("vkType", "numeric");
    this.municionTc.getProperties().put("vkType", "numeric");
    int x;
    for (x = 0; x < 14; x++) {
      this.machArray[x].getProperties().put("vkType", "numeric");
      this.cdArray[x].getProperties().put("vkType", "numeric");
      this.cdaArray[x].getProperties().put("vkType", "numeric");
      this.clArray[x].getProperties().put("vkType", "numeric");
      this.claArray[x].getProperties().put("vkType", "numeric");
      this.cmArray[x].getProperties().put("vkType", "numeric");
      this.cmaArray[x].getProperties().put("vkType", "numeric");
      this.cmagArray[x].getProperties().put("vkType", "numeric");
      this.cspinArray[x].getProperties().put("vkType", "numeric");
      this.cxbbArray[x].getProperties().put("vkType", "numeric");
      this.iformArray[x].getProperties().put("vkType", "numeric");
      this.iArray[x].getProperties().put("vkType", "numeric");
    } 
    for (x = 0; x < 6; x++) {
      this.mcbArray[x].getProperties().put("vkType", "numeric");
      this.scArray[x].getProperties().put("vkType", "numeric");
    } 
    this.municionCoeficienteA0.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA1.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA2.getProperties().put("vkType", "numeric");
    this.municionCoeficienteA3.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB1.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB2.getProperties().put("vkType", "numeric");
    this.municionCoeficienteB3.getProperties().put("vkType", "numeric");
    for (x = 0; x < 7; x++) {
      this.zoneArray[x].getProperties().put("vkType", "numeric");
      this.velArray[x].getProperties().put("vkType", "numeric");
      this.ajCDArray[x].getProperties().put("vkType", "numeric");
      this.ajCLArray[x].getProperties().put("vkType", "numeric");
      this.ajKArray[x].getProperties().put("vkType", "numeric");
      this.ajFibbArray[x].getProperties().put("vkType", "numeric");
      this.propArray[x].getProperties().put("vkType", "numeric");
      this.gradTempArray[x].getProperties().put("vkType", "numeric");
      this.pesoVelArray[x].getProperties().put("vkType", "numeric");
    } 
    this.espoleta1.getProperties().put("vkType", "numeric");
    this.pesoEspoleta1.getProperties().put("vkType", "numeric");
    this.efectoEspoleta1.getProperties().put("vkType", "numeric");
    this.espoleta2.getProperties().put("vkType", "numeric");
    this.pesoEspoleta2.getProperties().put("vkType", "numeric");
    this.efectoEspoleta2.getProperties().put("vkType", "numeric");
    this.espoleta3.getProperties().put("vkType", "numeric");
    this.pesoEspoleta3.getProperties().put("vkType", "numeric");
    this.efectoEspoleta3.getProperties().put("vkType", "numeric");
    this.parametrosBbKP.getProperties().put("vkType", "numeric");
    this.parametrosBbMcb.getProperties().put("vkType", "numeric");
    this.parametrosBbMf.getProperties().put("vkType", "numeric");
    this.parametrosBbPp.getProperties().put("vkType", "numeric");
    this.parametrosBbSc.getProperties().put("vkType", "numeric");
    this.parametrosBbTdi.getProperties().put("vkType", "numeric");
    this.parametrosBbXcg.getProperties().put("vkType", "numeric");
    this.parametrosBbXcgb.getProperties().put("vkType", "numeric");
    this.parametrosBbVc.getProperties().put("vkType", "numeric");
    this.parametrosBbBeta.getProperties().put("vkType", "numeric");
    this.parametrosBbK.getProperties().put("vkType", "numeric");
    this.parametrosBbN.getProperties().put("vkType", "numeric");
    this.parametrosBbTb.getProperties().put("vkType", "numeric");
    this.parametrosBbI.getProperties().put("vkType", "numeric");
    this.parametrosBbDb.getProperties().put("vkType", "numeric");
    this.municionVelocidad.getProperties().put("vkType", "numeric");
    this.municionDrag.getProperties().put("vkType", "numeric");
    this.municionElevacion.getProperties().put("vkType", "numeric");
    this.municionA0.getProperties().put("vkType", "numeric");
    this.municionA1.getProperties().put("vkType", "numeric");
    this.municionDesviacionSuperficie.getProperties().put("vkType", "numeric");
    this.municionDesviacionAzimut.getProperties().put("vkType", "numeric");
    this.municionDesviacionUbicacionDistancia.getProperties().put("vkType", "numeric");
    this.municionDesviacionUbicacionAzimut.getProperties().put("vkType", "numeric");
    this.tipoMunicion
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.tipoMunicion, newValue.booleanValue()));
    this.diametroMunicion
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.diametroMunicion, newValue.booleanValue()));
    this.aceleracionMunicion
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.aceleracionMunicion, newValue.booleanValue()));
    this.municionNumZonas
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionNumZonas, newValue.booleanValue()));
    this.municionPesoProyectil
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionPesoProyectil, newValue.booleanValue()));
    this.municionPesoSTD
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionPesoSTD, newValue.booleanValue()));
    this.cambioMunicionPeso
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.cambioMunicionPeso, newValue.booleanValue()));
    this.municionIx0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionIx0, newValue.booleanValue()));
    this.municionTc
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionTc, newValue.booleanValue()));
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
    this.zone0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone0, newValue.booleanValue()));
    this.zone1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone1, newValue.booleanValue()));
    this.zone2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone2, newValue.booleanValue()));
    this.zone3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone3, newValue.booleanValue()));
    this.zone4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone4, newValue.booleanValue()));
    this.zone5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone5, newValue.booleanValue()));
    this.zone6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.zone6, newValue.booleanValue()));
    this.vel0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel0, newValue.booleanValue()));
    this.vel1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel1, newValue.booleanValue()));
    this.vel2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel2, newValue.booleanValue()));
    this.vel3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel3, newValue.booleanValue()));
    this.vel4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel4, newValue.booleanValue()));
    this.vel5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel5, newValue.booleanValue()));
    this.vel6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.vel6, newValue.booleanValue()));
    this.ajCD0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD0, newValue.booleanValue()));
    this.ajCD1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD1, newValue.booleanValue()));
    this.ajCD2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD2, newValue.booleanValue()));
    this.ajCD3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD3, newValue.booleanValue()));
    this.ajCD4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD4, newValue.booleanValue()));
    this.ajCD5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD5, newValue.booleanValue()));
    this.ajCD6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCD6, newValue.booleanValue()));
    this.ajCL0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL0, newValue.booleanValue()));
    this.ajCL1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL1, newValue.booleanValue()));
    this.ajCL2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL2, newValue.booleanValue()));
    this.ajCL3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL3, newValue.booleanValue()));
    this.ajCL4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL4, newValue.booleanValue()));
    this.ajCL5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL5, newValue.booleanValue()));
    this.ajCL6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajCL6, newValue.booleanValue()));
    this.ajK0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK0, newValue.booleanValue()));
    this.ajK1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK1, newValue.booleanValue()));
    this.ajK2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK2, newValue.booleanValue()));
    this.ajK3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK3, newValue.booleanValue()));
    this.ajK4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK4, newValue.booleanValue()));
    this.ajK5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK5, newValue.booleanValue()));
    this.ajK6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajK6, newValue.booleanValue()));
    this.ajFibb0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb0, newValue.booleanValue()));
    this.ajFibb1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb1, newValue.booleanValue()));
    this.ajFibb2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb2, newValue.booleanValue()));
    this.ajFibb3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb3, newValue.booleanValue()));
    this.ajFibb4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb4, newValue.booleanValue()));
    this.ajFibb5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb5, newValue.booleanValue()));
    this.ajFibb6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.ajFibb6, newValue.booleanValue()));
    this.prop0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop0, newValue.booleanValue()));
    this.prop1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop1, newValue.booleanValue()));
    this.prop2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop2, newValue.booleanValue()));
    this.prop3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop3, newValue.booleanValue()));
    this.prop4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop4, newValue.booleanValue()));
    this.prop5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop5, newValue.booleanValue()));
    this.prop6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.prop6, newValue.booleanValue()));
    this.gradTemp0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp0, newValue.booleanValue()));
    this.gradTemp1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp1, newValue.booleanValue()));
    this.gradTemp2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp2, newValue.booleanValue()));
    this.gradTemp3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp3, newValue.booleanValue()));
    this.gradTemp4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp4, newValue.booleanValue()));
    this.gradTemp5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp5, newValue.booleanValue()));
    this.gradTemp6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.gradTemp6, newValue.booleanValue()));
    this.pesoVel0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel0, newValue.booleanValue()));
    this.pesoVel1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel1, newValue.booleanValue()));
    this.pesoVel2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel2, newValue.booleanValue()));
    this.pesoVel3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel3, newValue.booleanValue()));
    this.pesoVel4
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel4, newValue.booleanValue()));
    this.pesoVel5
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel5, newValue.booleanValue()));
    this.pesoVel6
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoVel6, newValue.booleanValue()));
    this.parametrosBbKP
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbKP, newValue.booleanValue()));
    this.parametrosBbMcb
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbMcb, newValue.booleanValue()));
    this.parametrosBbMf
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbMf, newValue.booleanValue()));
    this.parametrosBbPp
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbPp, newValue.booleanValue()));
    this.parametrosBbSc
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbSc, newValue.booleanValue()));
    this.parametrosBbTdi
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbTdi, newValue.booleanValue()));
    this.parametrosBbXcg
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbXcg, newValue.booleanValue()));
    this.parametrosBbXcgb
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbXcgb, newValue.booleanValue()));
    this.parametrosBbVc
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbVc, newValue.booleanValue()));
    this.parametrosBbBeta
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbBeta, newValue.booleanValue()));
    this.parametrosBbK
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbK, newValue.booleanValue()));
    this.parametrosBbN
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbN, newValue.booleanValue()));
    this.parametrosBbTb
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbTb, newValue.booleanValue()));
    this.parametrosBbI
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbI, newValue.booleanValue()));
    this.parametrosBbDb
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.parametrosBbDb, newValue.booleanValue()));
    this.espoleta1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.espoleta1, newValue.booleanValue()));
    this.pesoEspoleta1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoEspoleta1, newValue.booleanValue()));
    this.efectoEspoleta1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.efectoEspoleta1, newValue.booleanValue()));
    this.espoleta2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.espoleta2, newValue.booleanValue()));
    this.pesoEspoleta2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoEspoleta2, newValue.booleanValue()));
    this.efectoEspoleta2
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.efectoEspoleta2, newValue.booleanValue()));
    this.espoleta3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.espoleta3, newValue.booleanValue()));
    this.pesoEspoleta3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.pesoEspoleta3, newValue.booleanValue()));
    this.efectoEspoleta3
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.efectoEspoleta3, newValue.booleanValue()));
    this.municionVelocidad
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionVelocidad, newValue.booleanValue()));
    this.municionDrag
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionDrag, newValue.booleanValue()));
    this.municionElevacion
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionElevacion, newValue.booleanValue()));
    this.municionA0
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionA0, newValue.booleanValue()));
    this.municionA1
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionA1, newValue.booleanValue()));
    this.municionDesviacionSuperficie
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionDesviacionSuperficie, newValue.booleanValue()));
    this.municionDesviacionAzimut
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionDesviacionAzimut, newValue.booleanValue()));
    this.municionDesviacionUbicacionDistancia
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionDesviacionUbicacionDistancia, newValue.booleanValue()));
    this.municionDesviacionUbicacionAzimut
      .focusedProperty()
      .addListener((observable, oldValue, newValue) -> validateField(this.municionDesviacionUbicacionAzimut, newValue.booleanValue()));
  }
  
  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.tipoMunicion || textField == this.prop0 || textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6)
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME))
        textField.getStyleClass().add("error");  
    if (textField == this.municionNumZonas || textField == this.zone0 || textField == this.zone1 || textField == this.zone2 || textField == this.zone3 || textField == this.zone4 || textField == this.zone5 || textField == this.zone6)
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AMMO_ADD_ZONE))
        textField.getStyleClass().add("error");  
    if (textField == this.municionPesoSTD && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.AMMO_ADD_SQUARE))
      textField.getStyleClass().add("error"); 
    if (textField == this.municionTc && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.AMMO_ADD_TC))
      textField.getStyleClass().add("error"); 
    if (textField == this.diametroMunicion && 
      !newValue && 
      !textField.getText().matches(MeasureExpression.AMMO_ADD_INT))
      textField.getStyleClass().add("error"); 
    if (textField == this.municionPesoProyectil || textField == this.cambioMunicionPeso || textField == this.parametrosBbMcb || textField == this.parametrosBbMf || textField == this.parametrosBbPp || textField == this.parametrosBbSc || textField == this.parametrosBbTdi || textField == this.parametrosBbXcg || textField == this.parametrosBbXcgb || textField == this.parametrosBbVc || textField == this.parametrosBbTb)
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AMMO_ADD_POSITIVE_DOUBLE))
        textField.getStyleClass().add("error");  
    if (textField != this.tipoMunicion && textField != this.prop0 && textField != this.prop1 && textField != this.prop2 && textField != this.prop3 && textField != this.prop4 && textField != this.prop5 && textField != this.prop6 && textField != this.municionNumZonas && textField != this.zone0 && textField != this.zone1 && textField != this.zone2 && textField != this.zone3 && textField != this.zone4 && textField != this.zone5 && textField != this.zone6 && textField != this.municionPesoSTD && textField != this.municionTc && textField != this.diametroMunicion && textField != this.municionPesoProyectil && textField != this.cambioMunicionPeso && textField != this.parametrosBbMcb && textField != this.parametrosBbMf && textField != this.parametrosBbPp && textField != this.parametrosBbSc && textField != this.parametrosBbTdi && textField != this.parametrosBbXcg && textField != this.parametrosBbXcgb && textField != this.parametrosBbVc && textField != this.parametrosBbTb)
      if (!newValue && 
        !textField.getText().matches(MeasureExpression.AMMO_ADD_DOUBLE))
        textField.getStyleClass().add("error");  
  }
  
  private void clearForm() {
    this.tipoMunicion.setText("");
    this.diametroMunicion.setText("0");
    this.aceleracionMunicion.setText("-0.00");
    this.municionNumZonas.setText("0");
    this.municionPesoProyectil.setText("0.00");
    this.municionPesoSTD.setText("0");
    this.cambioMunicionPeso.setText("0.00");
    this.municionIx0.setText("-0.00");
    this.municionTc.setText("0");
    int x;
    for (x = 0; x < 14; x++) {
      this.machArray[x].setText("-0.00");
      this.cdArray[x].setText("-0.00");
      this.cdaArray[x].setText("-0.00");
      this.clArray[x].setText("-0.00");
      this.claArray[x].setText("-0.00");
      this.cmArray[x].setText("-0.00");
      this.cmaArray[x].setText("-0.00");
      this.cmagArray[x].setText("-0.00");
      this.cspinArray[x].setText("-0.00");
      this.cxbbArray[x].setText("-0.00");
      this.iformArray[x].setText("-0.00");
      this.iArray[x].setText("-0.00");
    } 
    for (x = 0; x < 6; x++) {
      this.mcbArray[x].setText("-0.00");
      this.scArray[x].setText("-0.00");
    } 
    this.municionCoeficienteA0.setText("-0.00");
    this.municionCoeficienteA1.setText("-0.00");
    this.municionCoeficienteA2.setText("-0.00");
    this.municionCoeficienteA3.setText("-0.00");
    this.municionCoeficienteB1.setText("-0.00");
    this.municionCoeficienteB2.setText("-0.00");
    this.municionCoeficienteB3.setText("-0.00");
    for (x = 0; x < 7; x++) {
      this.zoneArray[x].setText("0");
      this.velArray[x].setText("0");
      this.ajCDArray[x].setText("0");
      this.ajCLArray[x].setText("0");
      this.ajKArray[x].setText("0");
      this.ajFibbArray[x].setText("0");
      this.propArray[x].setText("");
      this.gradTempArray[x].setText("0");
      this.pesoVelArray[x].setText("0");
    } 
    this.espoleta1.setText("");
    this.pesoEspoleta1.setText("0.00");
    this.efectoEspoleta1.setText("");
    this.espoleta2.setText("");
    this.pesoEspoleta2.setText("0.00");
    this.efectoEspoleta2.setText("");
    this.espoleta3.setText("");
    this.pesoEspoleta3.setText("0.00");
    this.efectoEspoleta3.setText("");
    this.parametrosBbKP.setText("-0.00");
    this.parametrosBbMcb.setText("0.00");
    this.parametrosBbMf.setText("0.00");
    this.parametrosBbPp.setText("0.00");
    this.parametrosBbSc.setText("0.00");
    this.parametrosBbTdi.setText("0.00");
    this.parametrosBbXcg.setText("0.00");
    this.parametrosBbXcgb.setText("0.00");
    this.parametrosBbVc.setText("0.00");
    this.parametrosBbBeta.setText("-0.00");
    this.parametrosBbK.setText("-0.00");
    this.parametrosBbN.setText("-0.00");
    this.parametrosBbTb.setText("0.00");
    this.parametrosBbI.setText("-0.00");
    this.parametrosBbDb.setText("-0.00");
    this.municionVelocidad.setText("-0.00");
    this.municionDrag.setText("-0.00");
    this.municionElevacion.setText("-0.00");
    this.municionA0.setText("-0.00");
    this.municionA1.setText("-0.00");
    this.municionDesviacionSuperficie.setText("-0.00");
    this.municionDesviacionAzimut.setText("-0.00");
    this.municionDesviacionUbicacionDistancia.setText("-0.00");
    this.municionDesviacionUbicacionAzimut.setText("-0.00");
  }
  
  private boolean validateForm() {
    validateField(this.tipoMunicion, false);
    validateField(this.diametroMunicion, false);
    validateField(this.aceleracionMunicion, false);
    validateField(this.municionNumZonas, false);
    validateField(this.municionPesoProyectil, false);
    validateField(this.municionPesoSTD, false);
    validateField(this.cambioMunicionPeso, false);
    validateField(this.municionIx0, false);
    validateField(this.municionTc, false);
    int x;
    for (x = 0; x < 14; x++) {
      validateField(this.machArray[x], false);
      validateField(this.cdArray[x], false);
      validateField(this.cdaArray[x], false);
      validateField(this.clArray[x], false);
      validateField(this.claArray[x], false);
      validateField(this.cmArray[x], false);
      validateField(this.cmaArray[x], false);
      validateField(this.cmagArray[x], false);
      validateField(this.cspinArray[x], false);
      validateField(this.cxbbArray[x], false);
      validateField(this.iformArray[x], false);
      validateField(this.iArray[x], false);
    } 
    for (x = 0; x < 6; x++) {
      validateField(this.mcbArray[x], false);
      validateField(this.scArray[x], false);
    } 
    validateField(this.municionCoeficienteA0, false);
    validateField(this.municionCoeficienteA1, false);
    validateField(this.municionCoeficienteA2, false);
    validateField(this.municionCoeficienteA3, false);
    validateField(this.municionCoeficienteB1, false);
    validateField(this.municionCoeficienteB2, false);
    validateField(this.municionCoeficienteB3, false);
    for (x = 0; x < 7; x++) {
      validateField(this.zoneArray[x], false);
      validateField(this.velArray[x], false);
      validateField(this.ajCDArray[x], false);
      validateField(this.ajCLArray[x], false);
      validateField(this.ajKArray[x], false);
      validateField(this.ajFibbArray[x], false);
      validateField(this.propArray[x], false);
      validateField(this.gradTempArray[x], false);
      validateField(this.pesoVelArray[x], false);
    } 
    validateField(this.espoleta1, false);
    validateField(this.pesoEspoleta1, false);
    validateField(this.efectoEspoleta1, false);
    validateField(this.espoleta2, false);
    validateField(this.pesoEspoleta2, false);
    validateField(this.efectoEspoleta2, false);
    validateField(this.espoleta3, false);
    validateField(this.pesoEspoleta3, false);
    validateField(this.efectoEspoleta3, false);
    validateField(this.parametrosBbKP, false);
    validateField(this.parametrosBbMcb, false);
    validateField(this.parametrosBbMf, false);
    validateField(this.parametrosBbPp, false);
    validateField(this.parametrosBbSc, false);
    validateField(this.parametrosBbTdi, false);
    validateField(this.parametrosBbXcg, false);
    validateField(this.parametrosBbXcgb, false);
    validateField(this.parametrosBbVc, false);
    validateField(this.parametrosBbBeta, false);
    validateField(this.parametrosBbK, false);
    validateField(this.parametrosBbN, false);
    validateField(this.parametrosBbTb, false);
    validateField(this.parametrosBbI, false);
    validateField(this.parametrosBbDb, false);
    validateField(this.municionVelocidad, false);
    validateField(this.municionDrag, false);
    validateField(this.municionElevacion, false);
    validateField(this.municionA0, false);
    validateField(this.municionA1, false);
    validateField(this.municionDesviacionSuperficie, false);
    validateField(this.municionDesviacionAzimut, false);
    validateField(this.municionDesviacionUbicacionDistancia, false);
    validateField(this.municionDesviacionUbicacionAzimut, false);
    if (this.tipoMunicion
      .getStyleClass().contains("error") || this.diametroMunicion.getStyleClass().contains("error") || this.aceleracionMunicion
      .getStyleClass().contains("error") || this.municionNumZonas.getStyleClass().contains("error") || this.municionPesoProyectil
      .getStyleClass().contains("error") || this.municionPesoSTD.getStyleClass().contains("error") || this.cambioMunicionPeso
      .getStyleClass().contains("error") || this.municionIx0.getStyleClass().contains("error") || this.municionTc
      .getStyleClass().contains("error") || this.mach0
      
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
      .getStyleClass().contains("error") || this.zone0
      
      .getStyleClass().contains("error") || this.zone1.getStyleClass().contains("error") || this.zone2
      .getStyleClass().contains("error") || this.zone3.getStyleClass().contains("error") || this.zone4
      .getStyleClass().contains("error") || this.zone5.getStyleClass().contains("error") || this.zone6
      .getStyleClass().contains("error") || this.vel0
      
      .getStyleClass().contains("error") || this.vel1.getStyleClass().contains("error") || this.vel2
      .getStyleClass().contains("error") || this.vel3.getStyleClass().contains("error") || this.vel4
      .getStyleClass().contains("error") || this.vel5.getStyleClass().contains("error") || this.vel6
      .getStyleClass().contains("error") || this.ajCD0
      
      .getStyleClass().contains("error") || this.ajCD1.getStyleClass().contains("error") || this.ajCD2
      .getStyleClass().contains("error") || this.ajCD3.getStyleClass().contains("error") || this.ajCD4
      .getStyleClass().contains("error") || this.ajCD5.getStyleClass().contains("error") || this.ajCD6
      .getStyleClass().contains("error") || this.ajCL0
      
      .getStyleClass().contains("error") || this.ajCL1.getStyleClass().contains("error") || this.ajCL2
      .getStyleClass().contains("error") || this.ajCL3.getStyleClass().contains("error") || this.ajCL4
      .getStyleClass().contains("error") || this.ajCL5.getStyleClass().contains("error") || this.ajCL6
      .getStyleClass().contains("error") || this.ajK0
      
      .getStyleClass().contains("error") || this.ajK1.getStyleClass().contains("error") || this.ajK2
      .getStyleClass().contains("error") || this.ajK3.getStyleClass().contains("error") || this.ajK4
      .getStyleClass().contains("error") || this.ajK5.getStyleClass().contains("error") || this.ajK6
      .getStyleClass().contains("error") || this.ajFibb0
      
      .getStyleClass().contains("error") || this.ajFibb1.getStyleClass().contains("error") || this.ajFibb2
      .getStyleClass().contains("error") || this.ajFibb3.getStyleClass().contains("error") || this.ajFibb4
      .getStyleClass().contains("error") || this.ajFibb5.getStyleClass().contains("error") || this.ajFibb6
      .getStyleClass().contains("error") || this.prop0
      
      .getStyleClass().contains("error") || this.prop1.getStyleClass().contains("error") || this.prop2
      .getStyleClass().contains("error") || this.prop3.getStyleClass().contains("error") || this.prop4
      .getStyleClass().contains("error") || this.prop5.getStyleClass().contains("error") || this.prop6
      .getStyleClass().contains("error") || this.gradTemp0
      
      .getStyleClass().contains("error") || this.gradTemp1.getStyleClass().contains("error") || this.gradTemp2
      .getStyleClass().contains("error") || this.gradTemp3.getStyleClass().contains("error") || this.gradTemp4
      .getStyleClass().contains("error") || this.gradTemp5.getStyleClass().contains("error") || this.gradTemp6
      .getStyleClass().contains("error") || this.pesoVel0
      
      .getStyleClass().contains("error") || this.pesoVel1.getStyleClass().contains("error") || this.pesoVel2
      .getStyleClass().contains("error") || this.pesoVel3.getStyleClass().contains("error") || this.pesoVel4
      .getStyleClass().contains("error") || this.pesoVel5.getStyleClass().contains("error") || this.pesoVel6
      .getStyleClass().contains("error") || this.espoleta1
      
      .getStyleClass().contains("error") || this.pesoEspoleta1.getStyleClass().contains("error") || this.efectoEspoleta1
      .getStyleClass().contains("error") || this.espoleta2.getStyleClass().contains("error") || this.pesoEspoleta2
      .getStyleClass().contains("error") || this.efectoEspoleta2.getStyleClass().contains("error") || this.espoleta3
      .getStyleClass().contains("error") || this.pesoEspoleta3.getStyleClass().contains("error") || this.efectoEspoleta3
      .getStyleClass().contains("error") || this.parametrosBbKP
      
      .getStyleClass().contains("error") || this.parametrosBbMcb.getStyleClass().contains("error") || this.parametrosBbMf
      .getStyleClass().contains("error") || this.parametrosBbPp.getStyleClass().contains("error") || this.parametrosBbSc
      .getStyleClass().contains("error") || this.parametrosBbTdi.getStyleClass().contains("error") || this.parametrosBbXcg
      .getStyleClass().contains("error") || this.parametrosBbXcgb.getStyleClass().contains("error") || this.parametrosBbVc
      .getStyleClass().contains("error") || this.parametrosBbBeta.getStyleClass().contains("error") || this.parametrosBbK
      .getStyleClass().contains("error") || this.parametrosBbN.getStyleClass().contains("error") || this.parametrosBbTb
      .getStyleClass().contains("error") || this.parametrosBbI.getStyleClass().contains("error") || this.parametrosBbDb
      .getStyleClass().contains("error") || this.municionVelocidad
      
      .getStyleClass().contains("error") || this.municionDrag.getStyleClass().contains("error") || this.municionElevacion
      .getStyleClass().contains("error") || this.municionA0.getStyleClass().contains("error") || this.municionA1
      .getStyleClass().contains("error") || this.municionDesviacionSuperficie
      
      .getStyleClass().contains("error") || this.municionDesviacionAzimut.getStyleClass().contains("error") || this.municionDesviacionUbicacionDistancia
      .getStyleClass().contains("error") || this.municionDesviacionUbicacionAzimut.getStyleClass().contains("error"))
      return false; 
    return true;
  }
  
  private void formSubmit() {}
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\ammo\ZonAmmoAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */