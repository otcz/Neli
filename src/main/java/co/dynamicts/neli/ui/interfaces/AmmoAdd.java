//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.local.model.Ammunition;
import co.dynamicts.neli.core.local.service.AmmunitionService;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AmmoAdd extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField nombreMunicion;
  @FXML
  private TextField diametroMunicion;
  @FXML
  private TextField municionPesoProyectil;
  @FXML
  private TextField cambioMunicionPeso;
  @FXML
  private TextField municionIx0;
  @FXML
  private TextField municionTc;
  @FXML
  private TextField alturaExplo;
  @FXML
  private TextField tiempoBengala;
  @FXML
  private ComboBox<SimpleComboBoxItem> municionNumZonas;
  @FXML
  private ComboBox<SimpleComboBoxItem> municionPesoSTD;
  @FXML
  private ComboBox<SimpleComboBoxItem> efectoMunicion;
  @FXML
  private ComboBox<SimpleComboBoxItem> municionBB;
  @FXML
  private ComboBox<SimpleComboBoxItem> espoletas;
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
  @FXML
  public TextField mach14;
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
  private TextField cd14;
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
  @FXML
  private TextField cda14;
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
  @FXML
  private TextField cl14;
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
  @FXML
  private TextField cla14;
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
  @FXML
  private TextField cm14;
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
  @FXML
  private TextField cma14;
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
  @FXML
  private TextField cmag14;
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
  @FXML
  private TextField cspin14;
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
  @FXML
  private TextField cxbb14;
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
  @FXML
  private TextField iform14;
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
  @FXML
  private TextField i14;
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
  private CheckBox checkZone0;
  @FXML
  private CheckBox checkZone1;
  @FXML
  private CheckBox checkZone2;
  @FXML
  private CheckBox checkZone3;
  @FXML
  private CheckBox checkZone4;
  @FXML
  private CheckBox checkZone5;
  @FXML
  private CheckBox checkZone6;
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
  @FXML
  private TextField ajFD0;
  @FXML
  private TextField ajFD1;
  @FXML
  private TextField ajFD2;
  @FXML
  private TextField ajFD3;
  @FXML
  private TextField ajFD4;
  @FXML
  private TextField ajFD5;
  @FXML
  private TextField ajFD6;
  @FXML
  private TextField ajFMag0;
  @FXML
  private TextField ajFMag1;
  @FXML
  private TextField ajFMag2;
  @FXML
  private TextField ajFMag3;
  @FXML
  private TextField ajFMag4;
  @FXML
  private TextField ajFMag5;
  @FXML
  private TextField ajFMag6;
  @FXML
  private TextField ajFLA00;
  @FXML
  private TextField ajFLA01;
  @FXML
  private TextField ajFLA02;
  @FXML
  private TextField ajFLA03;
  @FXML
  private TextField ajFLA04;
  @FXML
  private TextField ajFLA05;
  @FXML
  private TextField ajFLA06;
  @FXML
  private TextField ajFLA10;
  @FXML
  private TextField ajFLA11;
  @FXML
  private TextField ajFLA12;
  @FXML
  private TextField ajFLA13;
  @FXML
  private TextField ajFLA14;
  @FXML
  private TextField ajFLA15;
  @FXML
  private TextField ajFLA16;
  @FXML
  private TextField ajFLA20;
  @FXML
  private TextField ajFLA21;
  @FXML
  private TextField ajFLA22;
  @FXML
  private TextField ajFLA23;
  @FXML
  private TextField ajFLA24;
  @FXML
  private TextField ajFLA25;
  @FXML
  private TextField ajFLA26;
  @FXML
  private TextField ajFLA30;
  @FXML
  private TextField ajFLA31;
  @FXML
  private TextField ajFLA32;
  @FXML
  private TextField ajFLA33;
  @FXML
  private TextField ajFLA34;
  @FXML
  private TextField ajFLA35;
  @FXML
  private TextField ajFLA36;
  @FXML
  private TextField ajFLA40;
  @FXML
  private TextField ajFLA41;
  @FXML
  private TextField ajFLA42;
  @FXML
  private TextField ajFLA43;
  @FXML
  private TextField ajFLA44;
  @FXML
  private TextField ajFLA45;
  @FXML
  private TextField ajFLA46;
  @FXML
  private TextField ajiA00;
  @FXML
  private TextField ajiA01;
  @FXML
  private TextField ajiA02;
  @FXML
  private TextField ajiA03;
  @FXML
  private TextField ajiA04;
  @FXML
  private TextField ajiA05;
  @FXML
  private TextField ajiA06;
  @FXML
  private TextField ajiA10;
  @FXML
  private TextField ajiA11;
  @FXML
  private TextField ajiA12;
  @FXML
  private TextField ajiA13;
  @FXML
  private TextField ajiA14;
  @FXML
  private TextField ajiA15;
  @FXML
  private TextField ajiA16;
  @FXML
  private TextField ajiA20;
  @FXML
  private TextField ajiA21;
  @FXML
  private TextField ajiA22;
  @FXML
  private TextField ajiA23;
  @FXML
  private TextField ajiA24;
  @FXML
  private TextField ajiA25;
  @FXML
  private TextField ajiA26;
  @FXML
  private TextField ajiA30;
  @FXML
  private TextField ajiA31;
  @FXML
  private TextField ajiA32;
  @FXML
  private TextField ajiA33;
  @FXML
  private TextField ajiA34;
  @FXML
  private TextField ajiA35;
  @FXML
  private TextField ajiA36;
  @FXML
  private TextField ajiA40;
  @FXML
  private TextField ajiA41;
  @FXML
  private TextField ajiA42;
  @FXML
  private TextField ajiA43;
  @FXML
  private TextField ajiA44;
  @FXML
  private TextField ajiA45;
  @FXML
  private TextField ajiA46;
  @FXML
  private TextField ajTimeA00;
  @FXML
  private TextField ajTimeA01;
  @FXML
  private TextField ajTimeA02;
  @FXML
  private TextField ajTimeA03;
  @FXML
  private TextField ajTimeA04;
  @FXML
  private TextField ajTimeA05;
  @FXML
  private TextField ajTimeA06;
  @FXML
  private TextField ajTimeA10;
  @FXML
  private TextField ajTimeA11;
  @FXML
  private TextField ajTimeA12;
  @FXML
  private TextField ajTimeA13;
  @FXML
  private TextField ajTimeA14;
  @FXML
  private TextField ajTimeA15;
  @FXML
  private TextField ajTimeA16;
  @FXML
  private TextField ajTimeA20;
  @FXML
  private TextField ajTimeA21;
  @FXML
  private TextField ajTimeA22;
  @FXML
  private TextField ajTimeA23;
  @FXML
  private TextField ajTimeA24;
  @FXML
  private TextField ajTimeA25;
  @FXML
  private TextField ajTimeA26;
  @FXML
  private TextField ajTimeA30;
  @FXML
  private TextField ajTimeA31;
  @FXML
  private TextField ajTimeA32;
  @FXML
  private TextField ajTimeA33;
  @FXML
  private TextField ajTimeA34;
  @FXML
  private TextField ajTimeA35;
  @FXML
  private TextField ajTimeA36;
  @FXML
  private TextField ajTimeA40;
  @FXML
  private TextField ajTimeA41;
  @FXML
  private TextField ajTimeA42;
  @FXML
  private TextField ajTimeA43;
  @FXML
  private TextField ajTimeA44;
  @FXML
  private TextField ajTimeA45;
  @FXML
  private TextField ajTimeA46;
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
  @FXML
  private TextField qemaxr0;
  @FXML
  private TextField qemaxr1;
  @FXML
  private TextField qemaxr2;
  @FXML
  private TextField qemaxr3;
  @FXML
  private TextField qemaxr4;
  @FXML
  private TextField qemaxr5;
  @FXML
  private TextField qemaxr6;
  @FXML
  private TextField kp0;
  @FXML
  private TextField kp1;
  @FXML
  private TextField kp2;
  @FXML
  private TextField kp3;
  @FXML
  private TextField kp4;
  @FXML
  private TextField kp5;
  @FXML
  private TextField kp6;
  @FXML
  private TextField fibbA00;
  @FXML
  private TextField fibbA01;
  @FXML
  private TextField fibbA02;
  @FXML
  private TextField fibbA03;
  @FXML
  private TextField fibbA04;
  @FXML
  private TextField fibbA05;
  @FXML
  private TextField fibbA06;
  @FXML
  private TextField fibbA10;
  @FXML
  private TextField fibbA11;
  @FXML
  private TextField fibbA12;
  @FXML
  private TextField fibbA13;
  @FXML
  private TextField fibbA14;
  @FXML
  private TextField fibbA15;
  @FXML
  private TextField fibbA16;
  @FXML
  private TextField fibbA20;
  @FXML
  private TextField fibbA21;
  @FXML
  private TextField fibbA22;
  @FXML
  private TextField fibbA23;
  @FXML
  private TextField fibbA24;
  @FXML
  private TextField fibbA25;
  @FXML
  private TextField fibbA26;
  @FXML
  private TextField fibbA30;
  @FXML
  private TextField fibbA31;
  @FXML
  private TextField fibbA32;
  @FXML
  private TextField fibbA33;
  @FXML
  private TextField fibbA34;
  @FXML
  private TextField fibbA35;
  @FXML
  private TextField fibbA36;
  @FXML
  private TextField fibbB10;
  @FXML
  private TextField fibbB11;
  @FXML
  private TextField fibbB12;
  @FXML
  private TextField fibbB13;
  @FXML
  private TextField fibbB14;
  @FXML
  private TextField fibbB15;
  @FXML
  private TextField fibbB16;
  @FXML
  private TextField fibbB20;
  @FXML
  private TextField fibbB21;
  @FXML
  private TextField fibbB22;
  @FXML
  private TextField fibbB23;
  @FXML
  private TextField fibbB24;
  @FXML
  private TextField fibbB25;
  @FXML
  private TextField fibbB26;
  @FXML
  private TextField fibbB30;
  @FXML
  private TextField fibbB31;
  @FXML
  private TextField fibbB32;
  @FXML
  private TextField fibbB33;
  @FXML
  private TextField fibbB34;
  @FXML
  private TextField fibbB35;
  @FXML
  private TextField fibbB36;
  @FXML
  private TextField tdiA00;
  @FXML
  private TextField tdiA01;
  @FXML
  private TextField tdiA02;
  @FXML
  private TextField tdiA03;
  @FXML
  private TextField tdiA04;
  @FXML
  private TextField tdiA05;
  @FXML
  private TextField tdiA06;
  @FXML
  private TextField tdiA10;
  @FXML
  private TextField tdiA11;
  @FXML
  private TextField tdiA12;
  @FXML
  private TextField tdiA13;
  @FXML
  private TextField tdiA14;
  @FXML
  private TextField tdiA15;
  @FXML
  private TextField tdiA16;
  @FXML
  private TextField tdiA20;
  @FXML
  private TextField tdiA21;
  @FXML
  private TextField tdiA22;
  @FXML
  private TextField tdiA23;
  @FXML
  private TextField tdiA24;
  @FXML
  private TextField tdiA25;
  @FXML
  private TextField tdiA26;
  @FXML
  private TextField tdiA30;
  @FXML
  private TextField tdiA31;
  @FXML
  private TextField tdiA32;
  @FXML
  private TextField tdiA33;
  @FXML
  private TextField tdiA34;
  @FXML
  private TextField tdiA35;
  @FXML
  private TextField tdiA36;
  @FXML
  private TextField tbA00;
  @FXML
  private TextField tbA01;
  @FXML
  private TextField tbA02;
  @FXML
  private TextField tbA03;
  @FXML
  private TextField tbA04;
  @FXML
  private TextField tbA05;
  @FXML
  private TextField tbA06;
  @FXML
  private TextField tbA10;
  @FXML
  private TextField tbA11;
  @FXML
  private TextField tbA12;
  @FXML
  private TextField tbA13;
  @FXML
  private TextField tbA14;
  @FXML
  private TextField tbA15;
  @FXML
  private TextField tbA16;
  @FXML
  private TextField tbA20;
  @FXML
  private TextField tbA21;
  @FXML
  private TextField tbA22;
  @FXML
  private TextField tbA23;
  @FXML
  private TextField tbA24;
  @FXML
  private TextField tbA25;
  @FXML
  private TextField tbA26;
  @FXML
  private TextField tbA30;
  @FXML
  private TextField tbA31;
  @FXML
  private TextField tbA32;
  @FXML
  private TextField tbA33;
  @FXML
  private TextField tbA34;
  @FXML
  private TextField tbA35;
  @FXML
  private TextField tbA36;
  @FXML
  private TextField espoleta1;
  @FXML
  private TextField pesoEspoleta1;
  @FXML
  private TextField espoleta2;
  @FXML
  private TextField pesoEspoleta2;
  @FXML
  private TextField espoleta3;
  @FXML
  private TextField pesoEspoleta3;
  @FXML
  private ComboBox<SimpleComboBoxItem> efectoEspoleta1;
  @FXML
  private ComboBox<SimpleComboBoxItem> efectoEspoleta2;
  @FXML
  private ComboBox<SimpleComboBoxItem> efectoEspoleta3;
  @FXML
  private TextField parametrosBbMcb;
  @FXML
  private TextField parametrosBbMf;
  @FXML
  private TextField parametrosBbPp;
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
  private TextField parametrosBbDb;
  @FXML
  private TextField parametrosBbAjFibb;
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
  @FXML
  private Button accept;
  @FXML
  private Button cancel;
  public CheckBox[] checkZoneArray;
  public TextField[] tipoMunicion;
  public TextField[] manejoMunicion;
  public TextField[] machArray;
  public TextField[] cdArray;
  public TextField[] cdaArray;
  public TextField[] clArray;
  public TextField[] claArray;
  public TextField[] cmArray;
  public TextField[] cmaArray;
  public TextField[] cmagArray;
  public TextField[] cspindArray;
  public TextField[] cxbbArray;
  public TextField[] iformArray;
  public TextField[] iArray;
  public TextField[] mcbArray;
  public TextField[] scArray;
  public TextField[] zoneArray;
  public TextField[] velArray;
  public TextField[] ajFDArray;
  public TextField[] ajFMagArray;
  public TextField[] ajFLA0Array;
  public TextField[] ajFLA1Array;
  public TextField[] ajFLA2Array;
  public TextField[] ajFLA3Array;
  public TextField[] ajFLA4Array;
  public TextField[] ajiA0Array;
  public TextField[] ajiA1Array;
  public TextField[] ajiA2Array;
  public TextField[] ajiA3Array;
  public TextField[] ajiA4Array;
  public TextField[] ajTimeA0Array;
  public TextField[] ajTimeA1Array;
  public TextField[] ajTimeA2Array;
  public TextField[] ajTimeA3Array;
  public TextField[] ajTimeA4Array;
  public TextField[] propArray;
  public TextField[] gradTempArray;
  public TextField[] pesoVelArray;
  public TextField[] qemaxrArray;
  public TextField[] kpArray;
  public TextField[] fibbA0Array;
  public TextField[] fibbA1Array;
  public TextField[] fibbA2Array;
  public TextField[] fibbA3Array;
  public TextField[] fibbB1Array;
  public TextField[] fibbB2Array;
  public TextField[] fibbB3Array;
  public TextField[] tdiA0Array;
  public TextField[] tdiA1Array;
  public TextField[] tdiA2Array;
  public TextField[] tdiA3Array;
  public TextField[] tbA0Array;
  public TextField[] tbA1Array;
  public TextField[] tbA2Array;
  public TextField[] tbA3Array;
  public TextField[] espoletasArray;
  public TextField[] parametrosBB;
  public TextField[] ajustesPrecision;
  public TextField[] desviacionMPI;
  ArrayList variablesMAtrix = new ArrayList();
  boolean edit = false;
  int zonesBB = 1;
  int auxZoneBB = 0;
  int[] zonesBBSelected;
  String[] velPromArray;
  String auxVelArray;

  public AmmoAdd() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/ammo_add.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.initArrays();
    this.dataChange();
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.AMMO);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.checkZone0.selectedProperty().addListener(this.getBooleanChangeListener(0));
    this.checkZone1.selectedProperty().addListener(this.getBooleanChangeListener(1));
    this.checkZone2.selectedProperty().addListener(this.getBooleanChangeListener(2));
    this.checkZone3.selectedProperty().addListener(this.getBooleanChangeListener(3));
    this.checkZone4.selectedProperty().addListener(this.getBooleanChangeListener(4));
    this.checkZone5.selectedProperty().addListener(this.getBooleanChangeListener(5));
    this.checkZone6.selectedProperty().addListener(this.getBooleanChangeListener(6));
    this.clearForm();
    if (AppConfig.getInstance().getAmmunition() != null) {
      this.edit = true;
      Ammunition ammunition = AppConfig.getInstance().getAmmunition();
      this.auxVelArray = ammunition.getVelArray();
      int indexEfectoAux = 0;

      int i;
      for(i = 0; i < 3; ++i) {
        this.efectoMunicion.getSelectionModel().select(i);
        if (((SimpleComboBoxItem)this.efectoMunicion.getSelectionModel().getSelectedItem()).getText().equals(ammunition.getEfectoMunicion())) {
          indexEfectoAux = i;
        }
      }

      DataTools.toTFArrayString(ammunition.getNombreMunicion(), this.tipoMunicion);
      this.efectoMunicion.getSelectionModel().select(indexEfectoAux);
      this.municionPesoSTD.getSelectionModel().select(ammunition.getIndexMunicionPesoSTD());
      this.municionBB.getSelectionModel().select(ammunition.getMunicionBB());
      this.municionNumZonas.getSelectionModel().select(ammunition.getIndexMunicionNumZonas());
      this.espoletas.getSelectionModel().select(ammunition.getIndexEspoletas());
      DataTools.toTFArrayString(ammunition.getManejoMunicion(), this.manejoMunicion);
      DataTools.toTFArrayString(ammunition.getMachArray(), this.machArray);
      DataTools.toTFArrayString(ammunition.getCdArray(), this.cdArray);
      DataTools.toTFArrayString(ammunition.getCdaArray(), this.cdaArray);
      DataTools.toTFArrayString(ammunition.getClArray(), this.clArray);
      DataTools.toTFArrayString(ammunition.getClaArray(), this.claArray);
      DataTools.toTFArrayString(ammunition.getCmArray(), this.cmArray);
      DataTools.toTFArrayString(ammunition.getCmaArray(), this.cmaArray);
      DataTools.toTFArrayString(ammunition.getCmagArray(), this.cmagArray);
      DataTools.toTFArrayString(ammunition.getCspindArray(), this.cspindArray);
      DataTools.toTFArrayString(ammunition.getCxbbArray(), this.cxbbArray);
      DataTools.toTFArrayString(ammunition.getIformArray(), this.iformArray);
      DataTools.toTFArrayString(ammunition.getiArray(), this.iArray);
      DataTools.toTFArrayString(ammunition.getMcbArray(), this.mcbArray);
      DataTools.toTFArrayString(ammunition.getScArray(), this.scArray);
      if (this.municionBB.getSelectionModel().isSelected(0)) {
        for(i = 0; i < DataTools.toIntString(ammunition.getZonesSelected()).length; ++i) {
          this.checkZoneArray[DataTools.toIntString(ammunition.getZonesSelected())[i] - 1].setSelected(true);
        }
      }

      DataTools.toTFArrayString(ammunition.getVelArray(), this.velArray);
      this.velPromArray = ammunition.getVelPromArray().split(";");
      DataTools.toTFArrayString(ammunition.getAjFDArray(), this.ajFDArray);
      DataTools.toTFArrayString(ammunition.getAjFMagArray(), this.ajFMagArray);
      DataTools.toTFArrayString(ammunition.getAjFLA0Array(), this.ajFLA0Array);
      DataTools.toTFArrayString(ammunition.getAjFLA1Array(), this.ajFLA1Array);
      DataTools.toTFArrayString(ammunition.getAjFLA2Array(), this.ajFLA2Array);
      DataTools.toTFArrayString(ammunition.getAjFLA3Array(), this.ajFLA3Array);
      DataTools.toTFArrayString(ammunition.getAjFLA4Array(), this.ajFLA4Array);
      DataTools.toTFArrayString(ammunition.getAjiA0Array(), this.ajiA0Array);
      DataTools.toTFArrayString(ammunition.getAjiA1Array(), this.ajiA1Array);
      DataTools.toTFArrayString(ammunition.getAjiA2Array(), this.ajiA2Array);
      DataTools.toTFArrayString(ammunition.getAjiA3Array(), this.ajiA3Array);
      DataTools.toTFArrayString(ammunition.getAjiA4Array(), this.ajiA4Array);
      DataTools.toTFArrayString(ammunition.getAjTimeA0Array(), this.ajTimeA0Array);
      DataTools.toTFArrayString(ammunition.getAjTimeA1Array(), this.ajTimeA1Array);
      DataTools.toTFArrayString(ammunition.getAjTimeA2Array(), this.ajTimeA2Array);
      DataTools.toTFArrayString(ammunition.getAjTimeA3Array(), this.ajTimeA3Array);
      DataTools.toTFArrayString(ammunition.getAjTimeA4Array(), this.ajTimeA4Array);
      DataTools.toTFArrayString(ammunition.getPropArray(), this.propArray);
      DataTools.toTFArrayString(ammunition.getGradTempArray(), this.gradTempArray);
      DataTools.toTFArrayString(ammunition.getPesoVelArray(), this.pesoVelArray);
      DataTools.toTFArrayString(ammunition.getQemaxrArray(), this.qemaxrArray);
      DataTools.toTFArrayString(ammunition.getKpArray(), this.kpArray);
      DataTools.toTFArrayString(ammunition.getFibbA0Array(), this.fibbA0Array);
      DataTools.toTFArrayString(ammunition.getFibbA1Array(), this.fibbA1Array);
      DataTools.toTFArrayString(ammunition.getFibbA2Array(), this.fibbA2Array);
      DataTools.toTFArrayString(ammunition.getFibbA3Array(), this.fibbA3Array);
      DataTools.toTFArrayString(ammunition.getFibbB1Array(), this.fibbB1Array);
      DataTools.toTFArrayString(ammunition.getFibbB2Array(), this.fibbB2Array);
      DataTools.toTFArrayString(ammunition.getFibbB3Array(), this.fibbB3Array);
      DataTools.toTFArrayString(ammunition.getTdiA0Array(), this.tdiA0Array);
      DataTools.toTFArrayString(ammunition.getTdiA1Array(), this.tdiA1Array);
      DataTools.toTFArrayString(ammunition.getTdiA2Array(), this.tdiA2Array);
      DataTools.toTFArrayString(ammunition.getTdiA3Array(), this.tdiA3Array);
      DataTools.toTFArrayString(ammunition.getTbA0Array(), this.tbA0Array);
      DataTools.toTFArrayString(ammunition.getTbA1Array(), this.tbA1Array);
      DataTools.toTFArrayString(ammunition.getTbA2Array(), this.tbA2Array);
      DataTools.toTFArrayString(ammunition.getTbA3Array(), this.tbA3Array);
      String[] aux = ammunition.getEspoletas().split(",");
      String cadena = ammunition.getEspoletas().split(",")[0] + "," + ammunition.getEspoletas().split(",")[1] + "," + ammunition.getEspoletas().split(",")[3] + "," + ammunition.getEspoletas().split(",")[4] + "," + ammunition.getEspoletas().split(",")[6] + "," + ammunition.getEspoletas().split(",")[7];
      DataTools.toTFArrayString(cadena, this.espoletasArray);
      this.efectoEspoleta1.getSelectionModel().select(new SimpleComboBoxItem(aux[2], (Object)null));
      this.efectoEspoleta2.getSelectionModel().select(new SimpleComboBoxItem(aux[5], (Object)null));
      this.efectoEspoleta3.getSelectionModel().select(new SimpleComboBoxItem(aux[8], (Object)null));
      DataTools.toTFArrayString(ammunition.getParametrosBB(), this.parametrosBB);
      DataTools.toTFArrayString(ammunition.getAjustesPrecision(), this.ajustesPrecision);
      DataTools.toTFArrayString(ammunition.getDesviacionMPI(), this.desviacionMPI);
      AppConfig.getInstance().setAmmunition((Ammunition)null);
    }

  }

  public ChangeListener<Boolean> getBooleanChangeListener(int i) {
    return (ov, old_val, new_val) -> {
      if (new_val) {
        ++this.auxZoneBB;
      } else if (!new_val) {
        --this.auxZoneBB;
      }

      if (this.auxZoneBB <= this.zonesBB && new_val) {
        this.setEnableZone(i);
      } else if (this.auxZoneBB <= this.zonesBB && !new_val) {
        this.setDisableZone(i);
      } else if (this.auxZoneBB > this.zonesBB && new_val) {
        this.checkZoneArray[i].setSelected(false);
      }

    };
  }

  public void setDisableZone(int i) {
    this.velArray[i].setDisable(true);
    this.velArray[i].setText("0.00");
    this.ajFDArray[i].setDisable(true);
    this.ajFDArray[i].setText("0.00");
    this.ajFMagArray[i].setDisable(true);
    this.ajFMagArray[i].setText("0.00");
    this.ajFLA0Array[i].setDisable(true);
    this.ajFLA0Array[i].setText("0.00");
    this.ajFLA1Array[i].setDisable(true);
    this.ajFLA1Array[i].setText("0.00");
    this.ajFLA2Array[i].setDisable(true);
    this.ajFLA2Array[i].setText("0.00");
    this.ajFLA3Array[i].setDisable(true);
    this.ajFLA3Array[i].setText("0.00");
    this.ajFLA4Array[i].setDisable(true);
    this.ajFLA4Array[i].setText("0.00");
    this.ajiA0Array[i].setDisable(true);
    this.ajiA0Array[i].setText("0.00");
    this.ajiA1Array[i].setDisable(true);
    this.ajiA1Array[i].setText("0.00");
    this.ajiA2Array[i].setDisable(true);
    this.ajiA2Array[i].setText("0.00");
    this.ajiA3Array[i].setDisable(true);
    this.ajiA3Array[i].setText("0.00");
    this.ajiA4Array[i].setDisable(true);
    this.ajiA4Array[i].setText("0.00");
    this.ajTimeA0Array[i].setDisable(true);
    this.ajTimeA0Array[i].setText("0.00");
    this.ajTimeA1Array[i].setDisable(true);
    this.ajTimeA1Array[i].setText("0.00");
    this.ajTimeA2Array[i].setDisable(true);
    this.ajTimeA2Array[i].setText("0.00");
    this.ajTimeA3Array[i].setDisable(true);
    this.ajTimeA3Array[i].setText("0.00");
    this.ajTimeA4Array[i].setDisable(true);
    this.ajTimeA4Array[i].setText("0.00");
    this.propArray[i].setDisable(true);
    this.propArray[i].setText(" ");
    this.propArray[i].getStyleClass().remove("error");
    this.gradTempArray[i].setDisable(true);
    this.gradTempArray[i].setText("0.00");
    this.pesoVelArray[i].setDisable(true);
    this.pesoVelArray[i].setText("0.00");
    this.qemaxrArray[i].setDisable(true);
    this.qemaxrArray[i].setText("0.00");
    if (this.municionBB.getSelectionModel().isSelected(0)) {
      this.kpArray[i].setDisable(true);
      this.kpArray[i].setText("0.00");
      this.fibbA0Array[i].setDisable(true);
      this.fibbA0Array[i].setText("0.00");
      this.fibbA1Array[i].setDisable(true);
      this.fibbA1Array[i].setText("0.00");
      this.fibbA2Array[i].setDisable(true);
      this.fibbA2Array[i].setText("0.00");
      this.fibbA3Array[i].setDisable(true);
      this.fibbA3Array[i].setText("0.00");
      this.fibbB1Array[i].setDisable(true);
      this.fibbB1Array[i].setText("0.00");
      this.fibbB2Array[i].setDisable(true);
      this.fibbB2Array[i].setText("0.00");
      this.fibbB3Array[i].setDisable(true);
      this.fibbB3Array[i].setText("0.00");
      this.tdiA0Array[i].setDisable(true);
      this.tdiA0Array[i].setText("0.00");
      this.tdiA1Array[i].setDisable(true);
      this.tdiA1Array[i].setText("0.00");
      this.tdiA2Array[i].setDisable(true);
      this.tdiA2Array[i].setText("0.00");
      this.tdiA3Array[i].setDisable(true);
      this.tdiA3Array[i].setText("0.00");
      this.tbA0Array[i].setDisable(true);
      this.tbA0Array[i].setText("0.00");
      this.tbA1Array[i].setDisable(true);
      this.tbA1Array[i].setText("0.00");
      this.tbA2Array[i].setDisable(true);
      this.tbA2Array[i].setText("0.00");
      this.tbA3Array[i].setDisable(true);
      this.tbA3Array[i].setText("0.00");
    }

  }

  public void setEnableZone(int i) {
    this.velArray[i].setDisable(false);
    this.ajFDArray[i].setDisable(false);
    this.ajFMagArray[i].setDisable(false);
    this.ajFLA0Array[i].setDisable(false);
    this.ajFLA1Array[i].setDisable(false);
    this.ajFLA2Array[i].setDisable(false);
    this.ajFLA3Array[i].setDisable(false);
    this.ajFLA4Array[i].setDisable(false);
    this.ajiA0Array[i].setDisable(false);
    this.ajiA1Array[i].setDisable(false);
    this.ajiA2Array[i].setDisable(false);
    this.ajiA3Array[i].setDisable(false);
    this.ajiA4Array[i].setDisable(false);
    this.ajTimeA0Array[i].setDisable(false);
    this.ajTimeA1Array[i].setDisable(false);
    this.ajTimeA2Array[i].setDisable(false);
    this.ajTimeA3Array[i].setDisable(false);
    this.ajTimeA4Array[i].setDisable(false);
    this.propArray[i].setDisable(false);
    this.propArray[i].setText("");
    this.gradTempArray[i].setDisable(false);
    this.pesoVelArray[i].setDisable(false);
    this.qemaxrArray[i].setDisable(false);
    if (this.municionBB.getSelectionModel().isSelected(0)) {
      this.checkZoneArray[i].setDisable(false);
      this.kpArray[i].setDisable(false);
      this.fibbA0Array[i].setDisable(false);
      this.fibbA1Array[i].setDisable(false);
      this.fibbA2Array[i].setDisable(false);
      this.fibbA3Array[i].setDisable(false);
      this.fibbB1Array[i].setDisable(false);
      this.fibbB2Array[i].setDisable(false);
      this.fibbB3Array[i].setDisable(false);
      this.tdiA0Array[i].setDisable(false);
      this.tdiA1Array[i].setDisable(false);
      this.tdiA2Array[i].setDisable(false);
      this.tdiA3Array[i].setDisable(false);
      this.tbA0Array[i].setDisable(false);
      this.tbA1Array[i].setDisable(false);
      this.tbA2Array[i].setDisable(false);
      this.tbA3Array[i].setDisable(false);
    }

  }

  private void initArrays() {
    this.tipoMunicion = new TextField[]{this.nombreMunicion};
    this.manejoMunicion = new TextField[]{this.diametroMunicion, this.municionPesoProyectil, this.cambioMunicionPeso, this.municionIx0, this.municionTc, this.tiempoBengala, this.alturaExplo};
    this.machArray = new TextField[]{this.mach0, this.mach1, this.mach2, this.mach3, this.mach4, this.mach5, this.mach6, this.mach7, this.mach8, this.mach9, this.mach10, this.mach11, this.mach12, this.mach13, this.mach14};
    this.cdArray = new TextField[]{this.cd0, this.cd1, this.cd2, this.cd3, this.cd4, this.cd5, this.cd6, this.cd7, this.cd8, this.cd9, this.cd10, this.cd11, this.cd12, this.cd13, this.cd14};
    this.cdaArray = new TextField[]{this.cda0, this.cda1, this.cda2, this.cda3, this.cda4, this.cda5, this.cda6, this.cda7, this.cda8, this.cda9, this.cda10, this.cda11, this.cda12, this.cda13, this.cda14};
    this.clArray = new TextField[]{this.cl0, this.cl1, this.cl2, this.cl3, this.cl4, this.cl5, this.cl6, this.cl7, this.cl8, this.cl9, this.cl10, this.cl11, this.cl12, this.cl13, this.cl14};
    this.claArray = new TextField[]{this.cla0, this.cla1, this.cla2, this.cla3, this.cla4, this.cla5, this.cla6, this.cla7, this.cla8, this.cla9, this.cla10, this.cla11, this.cla12, this.cla13, this.cla14};
    this.cmArray = new TextField[]{this.cm0, this.cm1, this.cm2, this.cm3, this.cm4, this.cm5, this.cm6, this.cm7, this.cm8, this.cm9, this.cm10, this.cm11, this.cm12, this.cm13, this.cm14};
    this.cmaArray = new TextField[]{this.cma0, this.cma1, this.cma2, this.cma3, this.cma4, this.cma5, this.cma6, this.cma7, this.cma8, this.cma9, this.cma10, this.cma11, this.cma12, this.cma13, this.cma14};
    this.cmagArray = new TextField[]{this.cmag0, this.cmag1, this.cmag2, this.cmag3, this.cmag4, this.cmag5, this.cmag6, this.cmag7, this.cmag8, this.cmag9, this.cmag10, this.cmag11, this.cmag12, this.cmag13, this.cmag14};
    this.cspindArray = new TextField[]{this.cspin0, this.cspin1, this.cspin2, this.cspin3, this.cspin4, this.cspin5, this.cspin6, this.cspin7, this.cspin8, this.cspin9, this.cspin10, this.cspin11, this.cspin12, this.cspin13, this.cspin14};
    this.cxbbArray = new TextField[]{this.cxbb0, this.cxbb1, this.cxbb2, this.cxbb3, this.cxbb4, this.cxbb5, this.cxbb6, this.cxbb7, this.cxbb8, this.cxbb9, this.cxbb10, this.cxbb11, this.cxbb12, this.cxbb13, this.cxbb14};
    this.iformArray = new TextField[]{this.iform0, this.iform1, this.iform2, this.iform3, this.iform4, this.iform5, this.iform6, this.iform7, this.iform8, this.iform9, this.iform10, this.iform11, this.iform12, this.iform13, this.iform14};
    this.iArray = new TextField[]{this.i0, this.i1, this.i2, this.i3, this.i4, this.i5, this.i6, this.i7, this.i8, this.i9, this.i10, this.i11, this.i12, this.i13, this.i14};
    this.mcbArray = new TextField[]{this.mcb0, this.mcb1, this.mcb2, this.mcb3, this.mcb4};
    this.scArray = new TextField[]{this.sc0, this.sc1, this.sc2, this.sc3, this.sc4};
    this.checkZoneArray = new CheckBox[]{this.checkZone0, this.checkZone1, this.checkZone2, this.checkZone3, this.checkZone4, this.checkZone5, this.checkZone6};
    this.zoneArray = new TextField[]{this.zone0, this.zone1, this.zone2, this.zone3, this.zone4, this.zone5, this.zone6};
    this.velArray = new TextField[]{this.vel0, this.vel1, this.vel2, this.vel3, this.vel4, this.vel5, this.vel6};
    this.ajFDArray = new TextField[]{this.ajFD0, this.ajFD1, this.ajFD2, this.ajFD3, this.ajFD4, this.ajFD5, this.ajFD6};
    this.ajFMagArray = new TextField[]{this.ajFMag0, this.ajFMag1, this.ajFMag2, this.ajFMag3, this.ajFMag4, this.ajFMag5, this.ajFMag6};
    this.ajFLA0Array = new TextField[]{this.ajFLA00, this.ajFLA01, this.ajFLA02, this.ajFLA03, this.ajFLA04, this.ajFLA05, this.ajFLA06};
    this.ajFLA1Array = new TextField[]{this.ajFLA10, this.ajFLA11, this.ajFLA12, this.ajFLA13, this.ajFLA14, this.ajFLA15, this.ajFLA16};
    this.ajFLA2Array = new TextField[]{this.ajFLA20, this.ajFLA21, this.ajFLA22, this.ajFLA23, this.ajFLA24, this.ajFLA25, this.ajFLA26};
    this.ajFLA3Array = new TextField[]{this.ajFLA30, this.ajFLA31, this.ajFLA32, this.ajFLA33, this.ajFLA34, this.ajFLA35, this.ajFLA36};
    this.ajFLA4Array = new TextField[]{this.ajFLA40, this.ajFLA41, this.ajFLA42, this.ajFLA43, this.ajFLA44, this.ajFLA45, this.ajFLA46};
    this.ajiA0Array = new TextField[]{this.ajiA00, this.ajiA01, this.ajiA02, this.ajiA03, this.ajiA04, this.ajiA05, this.ajiA06};
    this.ajiA1Array = new TextField[]{this.ajiA10, this.ajiA11, this.ajiA12, this.ajiA13, this.ajiA14, this.ajiA15, this.ajiA16};
    this.ajiA2Array = new TextField[]{this.ajiA20, this.ajiA21, this.ajiA22, this.ajiA23, this.ajiA24, this.ajiA25, this.ajiA26};
    this.ajiA3Array = new TextField[]{this.ajiA30, this.ajiA31, this.ajiA32, this.ajiA33, this.ajiA34, this.ajiA35, this.ajiA36};
    this.ajiA4Array = new TextField[]{this.ajiA40, this.ajiA41, this.ajiA42, this.ajiA43, this.ajiA44, this.ajiA45, this.ajiA46};
    this.ajTimeA0Array = new TextField[]{this.ajTimeA00, this.ajTimeA01, this.ajTimeA02, this.ajTimeA03, this.ajTimeA04, this.ajTimeA05, this.ajTimeA06};
    this.ajTimeA1Array = new TextField[]{this.ajTimeA10, this.ajTimeA11, this.ajTimeA12, this.ajTimeA13, this.ajTimeA14, this.ajTimeA15, this.ajTimeA16};
    this.ajTimeA2Array = new TextField[]{this.ajTimeA20, this.ajTimeA21, this.ajTimeA22, this.ajTimeA23, this.ajTimeA24, this.ajTimeA25, this.ajTimeA26};
    this.ajTimeA3Array = new TextField[]{this.ajTimeA30, this.ajTimeA31, this.ajTimeA32, this.ajTimeA33, this.ajTimeA34, this.ajTimeA35, this.ajTimeA36};
    this.ajTimeA4Array = new TextField[]{this.ajTimeA40, this.ajTimeA41, this.ajTimeA42, this.ajTimeA43, this.ajTimeA44, this.ajTimeA45, this.ajTimeA46};
    this.propArray = new TextField[]{this.prop0, this.prop1, this.prop2, this.prop3, this.prop4, this.prop5, this.prop6};
    this.gradTempArray = new TextField[]{this.gradTemp0, this.gradTemp1, this.gradTemp2, this.gradTemp3, this.gradTemp4, this.gradTemp5, this.gradTemp6};
    this.pesoVelArray = new TextField[]{this.pesoVel0, this.pesoVel1, this.pesoVel2, this.pesoVel3, this.pesoVel4, this.pesoVel5, this.pesoVel6};
    this.qemaxrArray = new TextField[]{this.qemaxr0, this.qemaxr1, this.qemaxr2, this.qemaxr3, this.qemaxr4, this.qemaxr5, this.qemaxr6};
    this.kpArray = new TextField[]{this.kp0, this.kp1, this.kp2, this.kp3, this.kp4, this.kp5, this.kp6};
    this.fibbA0Array = new TextField[]{this.fibbA00, this.fibbA01, this.fibbA02, this.fibbA03, this.fibbA04, this.fibbA05, this.fibbA06};
    this.fibbA1Array = new TextField[]{this.fibbA10, this.fibbA11, this.fibbA12, this.fibbA13, this.fibbA14, this.fibbA15, this.fibbA16};
    this.fibbA2Array = new TextField[]{this.fibbA20, this.fibbA21, this.fibbA22, this.fibbA23, this.fibbA24, this.fibbA25, this.fibbA26};
    this.fibbA3Array = new TextField[]{this.fibbA30, this.fibbA31, this.fibbA32, this.fibbA33, this.fibbA34, this.fibbA35, this.fibbA36};
    this.fibbB1Array = new TextField[]{this.fibbB10, this.fibbB11, this.fibbB12, this.fibbB13, this.fibbB14, this.fibbB15, this.fibbB16};
    this.fibbB2Array = new TextField[]{this.fibbB20, this.fibbB21, this.fibbB22, this.fibbB23, this.fibbB24, this.fibbB25, this.fibbB26};
    this.fibbB3Array = new TextField[]{this.fibbB30, this.fibbB31, this.fibbB32, this.fibbB33, this.fibbB34, this.fibbB35, this.fibbB36};
    this.tdiA0Array = new TextField[]{this.tdiA00, this.tdiA01, this.tdiA02, this.tdiA03, this.tdiA04, this.tdiA05, this.tdiA06};
    this.tdiA1Array = new TextField[]{this.tdiA10, this.tdiA11, this.tdiA12, this.tdiA13, this.tdiA14, this.tdiA15, this.tdiA16};
    this.tdiA2Array = new TextField[]{this.tdiA20, this.tdiA21, this.tdiA22, this.tdiA23, this.tdiA24, this.tdiA25, this.tdiA26};
    this.tdiA3Array = new TextField[]{this.tdiA30, this.tdiA31, this.tdiA32, this.tdiA33, this.tdiA34, this.tdiA35, this.tdiA36};
    this.tbA0Array = new TextField[]{this.tbA00, this.tbA01, this.tbA02, this.tbA03, this.tbA04, this.tbA05, this.tbA06};
    this.tbA1Array = new TextField[]{this.tbA10, this.tbA11, this.tbA12, this.tbA13, this.tbA14, this.tbA15, this.tbA16};
    this.tbA2Array = new TextField[]{this.tbA20, this.tbA21, this.tbA22, this.tbA23, this.tbA24, this.tbA25, this.tbA26};
    this.tbA3Array = new TextField[]{this.tbA30, this.tbA31, this.tbA32, this.tbA33, this.tbA34, this.tbA35, this.tbA36};
    this.espoletasArray = new TextField[]{this.espoleta1, this.pesoEspoleta1, this.espoleta2, this.pesoEspoleta2, this.espoleta3, this.pesoEspoleta3};
    this.parametrosBB = new TextField[]{this.parametrosBbMcb, this.parametrosBbMf, this.parametrosBbPp, this.parametrosBbXcg, this.parametrosBbXcgb, this.parametrosBbVc, this.parametrosBbBeta, this.parametrosBbK, this.parametrosBbN, this.parametrosBbDb, this.parametrosBbAjFibb};
    this.ajustesPrecision = new TextField[]{this.municionVelocidad, this.municionDrag, this.municionElevacion, this.municionA0, this.municionA1};
    this.desviacionMPI = new TextField[]{this.municionDesviacionSuperficie, this.municionDesviacionAzimut, this.municionDesviacionUbicacionDistancia, this.municionDesviacionUbicacionAzimut};
    this.variablesMAtrix.add(this.tipoMunicion);
    this.variablesMAtrix.add(this.manejoMunicion);
    this.variablesMAtrix.add(this.machArray);
    this.variablesMAtrix.add(this.cdArray);
    this.variablesMAtrix.add(this.cdaArray);
    this.variablesMAtrix.add(this.clArray);
    this.variablesMAtrix.add(this.claArray);
    this.variablesMAtrix.add(this.cmArray);
    this.variablesMAtrix.add(this.cmaArray);
    this.variablesMAtrix.add(this.cmagArray);
    this.variablesMAtrix.add(this.cspindArray);
    this.variablesMAtrix.add(this.cxbbArray);
    this.variablesMAtrix.add(this.iformArray);
    this.variablesMAtrix.add(this.iArray);
    this.variablesMAtrix.add(this.mcbArray);
    this.variablesMAtrix.add(this.scArray);
    this.variablesMAtrix.add(this.velArray);
    this.variablesMAtrix.add(this.ajFDArray);
    this.variablesMAtrix.add(this.ajFMagArray);
    this.variablesMAtrix.add(this.ajFLA0Array);
    this.variablesMAtrix.add(this.ajFLA1Array);
    this.variablesMAtrix.add(this.ajFLA2Array);
    this.variablesMAtrix.add(this.ajFLA3Array);
    this.variablesMAtrix.add(this.ajFLA4Array);
    this.variablesMAtrix.add(this.ajiA0Array);
    this.variablesMAtrix.add(this.ajiA1Array);
    this.variablesMAtrix.add(this.ajiA2Array);
    this.variablesMAtrix.add(this.ajiA3Array);
    this.variablesMAtrix.add(this.ajiA4Array);
    this.variablesMAtrix.add(this.ajTimeA0Array);
    this.variablesMAtrix.add(this.ajTimeA1Array);
    this.variablesMAtrix.add(this.ajTimeA2Array);
    this.variablesMAtrix.add(this.ajTimeA3Array);
    this.variablesMAtrix.add(this.ajTimeA4Array);
    this.variablesMAtrix.add(this.propArray);
    this.variablesMAtrix.add(this.gradTempArray);
    this.variablesMAtrix.add(this.pesoVelArray);
    this.variablesMAtrix.add(this.qemaxrArray);
    this.variablesMAtrix.add(this.kpArray);
    this.variablesMAtrix.add(this.fibbA0Array);
    this.variablesMAtrix.add(this.fibbA1Array);
    this.variablesMAtrix.add(this.fibbA2Array);
    this.variablesMAtrix.add(this.fibbA3Array);
    this.variablesMAtrix.add(this.fibbB1Array);
    this.variablesMAtrix.add(this.fibbB2Array);
    this.variablesMAtrix.add(this.fibbB3Array);
    this.variablesMAtrix.add(this.tdiA0Array);
    this.variablesMAtrix.add(this.tdiA1Array);
    this.variablesMAtrix.add(this.tdiA2Array);
    this.variablesMAtrix.add(this.tdiA3Array);
    this.variablesMAtrix.add(this.tbA0Array);
    this.variablesMAtrix.add(this.tbA1Array);
    this.variablesMAtrix.add(this.tbA2Array);
    this.variablesMAtrix.add(this.tbA3Array);
    this.variablesMAtrix.add(this.espoletasArray);
    this.variablesMAtrix.add(this.parametrosBB);
    this.variablesMAtrix.add(this.ajustesPrecision);
    this.variablesMAtrix.add(this.desviacionMPI);
  }

  private void dataChange() {
    for(int i = 0; i < this.variablesMAtrix.size(); ++i) {
      TextField[] textFieldArray = (TextField[])((TextField[])this.variablesMAtrix.get(i));

      for(int j = 0; j < textFieldArray.length; ++j) {
        textFieldArray[j].getProperties().put("vkType", "numeric");
      }
    }

    this.nombreMunicion.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.nombreMunicion, newValue);
    });
    this.diametroMunicion.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.diametroMunicion, newValue);
    });
    this.municionPesoProyectil.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionPesoProyectil, newValue);
    });
    this.cambioMunicionPeso.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cambioMunicionPeso, newValue);
    });
    this.municionIx0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionIx0, newValue);
    });
    this.municionTc.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionTc, newValue);
    });
    this.alturaExplo.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.alturaExplo, newValue);
    });
    this.tiempoBengala.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tiempoBengala, newValue);
    });
    this.mach0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach0, newValue);
    });
    this.mach1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach1, newValue);
    });
    this.mach2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach2, newValue);
    });
    this.mach3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach3, newValue);
    });
    this.mach4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach4, newValue);
    });
    this.mach5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach5, newValue);
    });
    this.mach6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach6, newValue);
    });
    this.mach7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach7, newValue);
    });
    this.mach8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach8, newValue);
    });
    this.mach9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach9, newValue);
    });
    this.mach10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach10, newValue);
    });
    this.mach11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach11, newValue);
    });
    this.mach12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach12, newValue);
    });
    this.mach13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach13, newValue);
    });
    this.mach14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mach14, newValue);
    });
    this.cd0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd0, newValue);
    });
    this.cd1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd1, newValue);
    });
    this.cd2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd2, newValue);
    });
    this.cd3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd3, newValue);
    });
    this.cd4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd4, newValue);
    });
    this.cd5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd5, newValue);
    });
    this.cd6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd6, newValue);
    });
    this.cd7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd7, newValue);
    });
    this.cd8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd8, newValue);
    });
    this.cd9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd9, newValue);
    });
    this.cd10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd10, newValue);
    });
    this.cd11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd11, newValue);
    });
    this.cd12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd12, newValue);
    });
    this.cd13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd13, newValue);
    });
    this.cd14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cd14, newValue);
    });
    this.cda0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda0, newValue);
    });
    this.cda1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda1, newValue);
    });
    this.cda2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda2, newValue);
    });
    this.cda3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda3, newValue);
    });
    this.cda4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda4, newValue);
    });
    this.cda5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda5, newValue);
    });
    this.cda6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda6, newValue);
    });
    this.cda7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda7, newValue);
    });
    this.cda8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda8, newValue);
    });
    this.cda9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda9, newValue);
    });
    this.cda10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda10, newValue);
    });
    this.cda11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda11, newValue);
    });
    this.cda12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda12, newValue);
    });
    this.cda13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda13, newValue);
    });
    this.cda14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cda14, newValue);
    });
    this.cl0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl0, newValue);
    });
    this.cl1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl1, newValue);
    });
    this.cl2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl2, newValue);
    });
    this.cl3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl3, newValue);
    });
    this.cl4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl4, newValue);
    });
    this.cl5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl5, newValue);
    });
    this.cl6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl6, newValue);
    });
    this.cl7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl7, newValue);
    });
    this.cl8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl8, newValue);
    });
    this.cl9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl9, newValue);
    });
    this.cl10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl10, newValue);
    });
    this.cl11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl11, newValue);
    });
    this.cl12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl12, newValue);
    });
    this.cl13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl13, newValue);
    });
    this.cl14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cl14, newValue);
    });
    this.cla0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla0, newValue);
    });
    this.cla1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla1, newValue);
    });
    this.cla2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla2, newValue);
    });
    this.cla3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla3, newValue);
    });
    this.cla4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla4, newValue);
    });
    this.cla5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla5, newValue);
    });
    this.cla6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla6, newValue);
    });
    this.cla7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla7, newValue);
    });
    this.cla8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla8, newValue);
    });
    this.cla9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla9, newValue);
    });
    this.cla10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla10, newValue);
    });
    this.cla11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla11, newValue);
    });
    this.cla12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla12, newValue);
    });
    this.cla13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla13, newValue);
    });
    this.cla14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cla14, newValue);
    });
    this.cm0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm0, newValue);
    });
    this.cm1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm1, newValue);
    });
    this.cm2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm2, newValue);
    });
    this.cm3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm3, newValue);
    });
    this.cm4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm4, newValue);
    });
    this.cm5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm5, newValue);
    });
    this.cm6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm6, newValue);
    });
    this.cm7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm7, newValue);
    });
    this.cm8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm8, newValue);
    });
    this.cm9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm9, newValue);
    });
    this.cm10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm10, newValue);
    });
    this.cm11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm11, newValue);
    });
    this.cm12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm12, newValue);
    });
    this.cm13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm13, newValue);
    });
    this.cm14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cm14, newValue);
    });
    this.cma0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma0, newValue);
    });
    this.cma1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma1, newValue);
    });
    this.cma2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma2, newValue);
    });
    this.cma3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma3, newValue);
    });
    this.cma4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma4, newValue);
    });
    this.cma5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma5, newValue);
    });
    this.cma6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma6, newValue);
    });
    this.cma7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma7, newValue);
    });
    this.cma8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma8, newValue);
    });
    this.cma9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma9, newValue);
    });
    this.cma10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma10, newValue);
    });
    this.cma11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma11, newValue);
    });
    this.cma12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma12, newValue);
    });
    this.cma13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma13, newValue);
    });
    this.cma14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cma14, newValue);
    });
    this.cmag0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag0, newValue);
    });
    this.cmag1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag1, newValue);
    });
    this.cmag2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag2, newValue);
    });
    this.cmag3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag3, newValue);
    });
    this.cmag4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag4, newValue);
    });
    this.cmag5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag5, newValue);
    });
    this.cmag6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag6, newValue);
    });
    this.cmag7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag7, newValue);
    });
    this.cmag8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag8, newValue);
    });
    this.cmag9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag9, newValue);
    });
    this.cmag10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag10, newValue);
    });
    this.cmag11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag11, newValue);
    });
    this.cmag12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag12, newValue);
    });
    this.cmag13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag13, newValue);
    });
    this.cmag14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cmag14, newValue);
    });
    this.cspin0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin0, newValue);
    });
    this.cspin1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin1, newValue);
    });
    this.cspin2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin2, newValue);
    });
    this.cspin3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin3, newValue);
    });
    this.cspin4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin4, newValue);
    });
    this.cspin5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin5, newValue);
    });
    this.cspin6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin6, newValue);
    });
    this.cspin7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin7, newValue);
    });
    this.cspin8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin8, newValue);
    });
    this.cspin9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin9, newValue);
    });
    this.cspin10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin10, newValue);
    });
    this.cspin11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin11, newValue);
    });
    this.cspin12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin12, newValue);
    });
    this.cspin13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin13, newValue);
    });
    this.cspin14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cspin14, newValue);
    });
    this.cxbb0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb0, newValue);
    });
    this.cxbb1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb1, newValue);
    });
    this.cxbb2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb2, newValue);
    });
    this.cxbb3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb3, newValue);
    });
    this.cxbb4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb4, newValue);
    });
    this.cxbb5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb5, newValue);
    });
    this.cxbb6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb6, newValue);
    });
    this.cxbb7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb7, newValue);
    });
    this.cxbb8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb8, newValue);
    });
    this.cxbb9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb9, newValue);
    });
    this.cxbb10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb10, newValue);
    });
    this.cxbb11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb11, newValue);
    });
    this.cxbb12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb12, newValue);
    });
    this.cxbb13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb13, newValue);
    });
    this.cxbb14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.cxbb14, newValue);
    });
    this.iform0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform0, newValue);
    });
    this.iform1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform1, newValue);
    });
    this.iform2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform2, newValue);
    });
    this.iform3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform3, newValue);
    });
    this.iform4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform4, newValue);
    });
    this.iform5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform5, newValue);
    });
    this.iform6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform6, newValue);
    });
    this.iform7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform7, newValue);
    });
    this.iform8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform8, newValue);
    });
    this.iform9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform9, newValue);
    });
    this.iform10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform10, newValue);
    });
    this.iform11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform11, newValue);
    });
    this.iform12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform12, newValue);
    });
    this.iform13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform13, newValue);
    });
    this.iform14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.iform14, newValue);
    });
    this.i0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i0, newValue);
    });
    this.i1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i1, newValue);
    });
    this.i2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i2, newValue);
    });
    this.i3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i3, newValue);
    });
    this.i4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i4, newValue);
    });
    this.i5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i5, newValue);
    });
    this.i6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i6, newValue);
    });
    this.i7.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i7, newValue);
    });
    this.i8.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i8, newValue);
    });
    this.i9.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i9, newValue);
    });
    this.i10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i10, newValue);
    });
    this.i11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i11, newValue);
    });
    this.i12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i12, newValue);
    });
    this.i13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i13, newValue);
    });
    this.i14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.i14, newValue);
    });
    this.mcb0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mcb0, newValue);
    });
    this.mcb1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mcb1, newValue);
    });
    this.mcb2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mcb2, newValue);
    });
    this.mcb3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mcb3, newValue);
    });
    this.mcb4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.mcb4, newValue);
    });
    this.sc0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.sc0, newValue);
    });
    this.sc1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.sc1, newValue);
    });
    this.sc2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.sc2, newValue);
    });
    this.sc3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.sc3, newValue);
    });
    this.sc4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.sc4, newValue);
    });
    this.zone0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone0, newValue);
    });
    this.zone1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone1, newValue);
    });
    this.zone2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone2, newValue);
    });
    this.zone3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone3, newValue);
    });
    this.zone4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone4, newValue);
    });
    this.zone5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone5, newValue);
    });
    this.zone6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone6, newValue);
    });
    this.vel0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel0, newValue);
    });
    this.vel1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel1, newValue);
    });
    this.vel2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel2, newValue);
    });
    this.vel3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel3, newValue);
    });
    this.vel4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel4, newValue);
    });
    this.vel5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel5, newValue);
    });
    this.vel6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.vel6, newValue);
    });
    this.ajFD0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD0, newValue);
    });
    this.ajFD1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD1, newValue);
    });
    this.ajFD2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD2, newValue);
    });
    this.ajFD3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD3, newValue);
    });
    this.ajFD4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD4, newValue);
    });
    this.ajFD5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD5, newValue);
    });
    this.ajFD6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFD6, newValue);
    });
    this.ajFMag0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag0, newValue);
    });
    this.ajFMag1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag1, newValue);
    });
    this.ajFMag2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag2, newValue);
    });
    this.ajFMag3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag3, newValue);
    });
    this.ajFMag4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag4, newValue);
    });
    this.ajFMag5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag5, newValue);
    });
    this.ajFMag6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFMag6, newValue);
    });
    this.ajFLA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA00, newValue);
    });
    this.ajFLA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA01, newValue);
    });
    this.ajFLA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA02, newValue);
    });
    this.ajFLA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA03, newValue);
    });
    this.ajFLA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA04, newValue);
    });
    this.ajFLA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA05, newValue);
    });
    this.ajFLA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA06, newValue);
    });
    this.ajFLA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA10, newValue);
    });
    this.ajFLA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA11, newValue);
    });
    this.ajFLA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA12, newValue);
    });
    this.ajFLA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA13, newValue);
    });
    this.ajFLA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA14, newValue);
    });
    this.ajFLA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA15, newValue);
    });
    this.ajFLA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA16, newValue);
    });
    this.ajFLA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA20, newValue);
    });
    this.ajFLA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA21, newValue);
    });
    this.ajFLA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA22, newValue);
    });
    this.ajFLA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA23, newValue);
    });
    this.ajFLA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA24, newValue);
    });
    this.ajFLA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA25, newValue);
    });
    this.ajFLA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA26, newValue);
    });
    this.ajFLA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA30, newValue);
    });
    this.ajFLA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA31, newValue);
    });
    this.ajFLA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA32, newValue);
    });
    this.ajFLA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA33, newValue);
    });
    this.ajFLA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA34, newValue);
    });
    this.ajFLA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA35, newValue);
    });
    this.ajFLA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA36, newValue);
    });
    this.ajFLA40.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA40, newValue);
    });
    this.ajFLA41.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA41, newValue);
    });
    this.ajFLA42.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA42, newValue);
    });
    this.ajFLA43.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA43, newValue);
    });
    this.ajFLA44.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA44, newValue);
    });
    this.ajFLA45.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA45, newValue);
    });
    this.ajFLA46.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajFLA46, newValue);
    });
    this.ajiA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA00, newValue);
    });
    this.ajiA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA01, newValue);
    });
    this.ajiA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA02, newValue);
    });
    this.ajiA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA03, newValue);
    });
    this.ajiA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA04, newValue);
    });
    this.ajiA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA05, newValue);
    });
    this.ajiA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA06, newValue);
    });
    this.ajiA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA10, newValue);
    });
    this.ajiA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA11, newValue);
    });
    this.ajiA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA12, newValue);
    });
    this.ajiA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA13, newValue);
    });
    this.ajiA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA14, newValue);
    });
    this.ajiA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA15, newValue);
    });
    this.ajiA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA16, newValue);
    });
    this.ajiA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA20, newValue);
    });
    this.ajiA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA21, newValue);
    });
    this.ajiA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA22, newValue);
    });
    this.ajiA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA23, newValue);
    });
    this.ajiA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA24, newValue);
    });
    this.ajiA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA25, newValue);
    });
    this.ajiA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA26, newValue);
    });
    this.ajiA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA30, newValue);
    });
    this.ajiA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA31, newValue);
    });
    this.ajiA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA32, newValue);
    });
    this.ajiA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA33, newValue);
    });
    this.ajiA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA34, newValue);
    });
    this.ajiA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA35, newValue);
    });
    this.ajiA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA36, newValue);
    });
    this.ajiA40.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA40, newValue);
    });
    this.ajiA41.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA41, newValue);
    });
    this.ajiA42.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA42, newValue);
    });
    this.ajiA43.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA43, newValue);
    });
    this.ajiA44.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA44, newValue);
    });
    this.ajiA45.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA45, newValue);
    });
    this.ajiA46.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajiA46, newValue);
    });
    this.ajTimeA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA00, newValue);
    });
    this.ajTimeA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA01, newValue);
    });
    this.ajTimeA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA02, newValue);
    });
    this.ajTimeA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA03, newValue);
    });
    this.ajTimeA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA04, newValue);
    });
    this.ajTimeA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA05, newValue);
    });
    this.ajTimeA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA06, newValue);
    });
    this.ajTimeA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA10, newValue);
    });
    this.ajTimeA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA11, newValue);
    });
    this.ajTimeA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA12, newValue);
    });
    this.ajTimeA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA13, newValue);
    });
    this.ajTimeA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA14, newValue);
    });
    this.ajTimeA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA15, newValue);
    });
    this.ajTimeA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA16, newValue);
    });
    this.ajTimeA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA20, newValue);
    });
    this.ajTimeA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA21, newValue);
    });
    this.ajTimeA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA22, newValue);
    });
    this.ajTimeA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA23, newValue);
    });
    this.ajTimeA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA24, newValue);
    });
    this.ajTimeA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA25, newValue);
    });
    this.ajTimeA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA26, newValue);
    });
    this.ajTimeA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA30, newValue);
    });
    this.ajTimeA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA31, newValue);
    });
    this.ajTimeA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA32, newValue);
    });
    this.ajTimeA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA33, newValue);
    });
    this.ajTimeA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA34, newValue);
    });
    this.ajTimeA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA35, newValue);
    });
    this.ajTimeA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA36, newValue);
    });
    this.ajTimeA40.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA40, newValue);
    });
    this.ajTimeA41.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA41, newValue);
    });
    this.ajTimeA42.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA42, newValue);
    });
    this.ajTimeA43.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA43, newValue);
    });
    this.ajTimeA44.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA44, newValue);
    });
    this.ajTimeA45.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA45, newValue);
    });
    this.ajTimeA46.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.ajTimeA46, newValue);
    });
    this.prop0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop0, newValue);
    });
    this.prop1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop1, newValue);
    });
    this.prop2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop2, newValue);
    });
    this.prop3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop3, newValue);
    });
    this.prop4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop4, newValue);
    });
    this.prop5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop5, newValue);
    });
    this.prop6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.prop6, newValue);
    });
    this.gradTemp0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp0, newValue);
    });
    this.gradTemp1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp1, newValue);
    });
    this.gradTemp2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp2, newValue);
    });
    this.gradTemp3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp3, newValue);
    });
    this.gradTemp4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp4, newValue);
    });
    this.gradTemp5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp5, newValue);
    });
    this.gradTemp6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.gradTemp6, newValue);
    });
    this.pesoVel0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel0, newValue);
    });
    this.pesoVel1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel1, newValue);
    });
    this.pesoVel2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel2, newValue);
    });
    this.pesoVel3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel3, newValue);
    });
    this.pesoVel4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel4, newValue);
    });
    this.pesoVel5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel5, newValue);
    });
    this.pesoVel6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoVel6, newValue);
    });
    this.qemaxr0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr0, newValue);
    });
    this.qemaxr1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr1, newValue);
    });
    this.qemaxr2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr2, newValue);
    });
    this.qemaxr3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr3, newValue);
    });
    this.qemaxr4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr4, newValue);
    });
    this.qemaxr5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr5, newValue);
    });
    this.qemaxr6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.qemaxr6, newValue);
    });
    this.kp0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp0, newValue);
    });
    this.kp1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp1, newValue);
    });
    this.kp2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp2, newValue);
    });
    this.kp3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp3, newValue);
    });
    this.kp4.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp4, newValue);
    });
    this.kp5.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp5, newValue);
    });
    this.kp6.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.kp6, newValue);
    });
    this.fibbA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA00, newValue);
    });
    this.fibbA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA01, newValue);
    });
    this.fibbA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA02, newValue);
    });
    this.fibbA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA03, newValue);
    });
    this.fibbA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA04, newValue);
    });
    this.fibbA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA05, newValue);
    });
    this.fibbA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA06, newValue);
    });
    this.fibbA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA10, newValue);
    });
    this.fibbA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA11, newValue);
    });
    this.fibbA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA12, newValue);
    });
    this.fibbA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA13, newValue);
    });
    this.fibbA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA14, newValue);
    });
    this.fibbA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA15, newValue);
    });
    this.fibbA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA16, newValue);
    });
    this.fibbA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA20, newValue);
    });
    this.fibbA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA21, newValue);
    });
    this.fibbA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA22, newValue);
    });
    this.fibbA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA23, newValue);
    });
    this.fibbA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA24, newValue);
    });
    this.fibbA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA25, newValue);
    });
    this.fibbA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA26, newValue);
    });
    this.fibbA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA30, newValue);
    });
    this.fibbA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA31, newValue);
    });
    this.fibbA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA32, newValue);
    });
    this.fibbA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA33, newValue);
    });
    this.fibbA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA34, newValue);
    });
    this.fibbA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA35, newValue);
    });
    this.fibbA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbA36, newValue);
    });
    this.fibbB10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB10, newValue);
    });
    this.fibbB11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB11, newValue);
    });
    this.fibbB12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB12, newValue);
    });
    this.fibbB13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB13, newValue);
    });
    this.fibbB14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB14, newValue);
    });
    this.fibbB15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB15, newValue);
    });
    this.fibbB16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB16, newValue);
    });
    this.fibbB20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB20, newValue);
    });
    this.fibbB21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB21, newValue);
    });
    this.fibbB22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB22, newValue);
    });
    this.fibbB23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB23, newValue);
    });
    this.fibbB24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB24, newValue);
    });
    this.fibbB25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB25, newValue);
    });
    this.fibbB26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB26, newValue);
    });
    this.fibbB30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB30, newValue);
    });
    this.fibbB31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB31, newValue);
    });
    this.fibbB32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB32, newValue);
    });
    this.fibbB33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB33, newValue);
    });
    this.fibbB34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB34, newValue);
    });
    this.fibbB35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB35, newValue);
    });
    this.fibbB36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.fibbB36, newValue);
    });
    this.tdiA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA00, newValue);
    });
    this.tdiA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA01, newValue);
    });
    this.tdiA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA02, newValue);
    });
    this.tdiA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA03, newValue);
    });
    this.tdiA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA04, newValue);
    });
    this.tdiA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA05, newValue);
    });
    this.tdiA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA06, newValue);
    });
    this.tdiA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA10, newValue);
    });
    this.tdiA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA11, newValue);
    });
    this.tdiA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA12, newValue);
    });
    this.tdiA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA13, newValue);
    });
    this.tdiA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA14, newValue);
    });
    this.tdiA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA15, newValue);
    });
    this.tdiA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA16, newValue);
    });
    this.tdiA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA20, newValue);
    });
    this.tdiA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA21, newValue);
    });
    this.tdiA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA22, newValue);
    });
    this.tdiA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA23, newValue);
    });
    this.tdiA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA24, newValue);
    });
    this.tdiA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA25, newValue);
    });
    this.tdiA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA26, newValue);
    });
    this.tdiA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA30, newValue);
    });
    this.tdiA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA31, newValue);
    });
    this.tdiA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA32, newValue);
    });
    this.tdiA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA33, newValue);
    });
    this.tdiA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA34, newValue);
    });
    this.tdiA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA35, newValue);
    });
    this.tdiA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tdiA36, newValue);
    });
    this.tbA00.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA00, newValue);
    });
    this.tbA01.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA01, newValue);
    });
    this.tbA02.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA02, newValue);
    });
    this.tbA03.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA03, newValue);
    });
    this.tbA04.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA04, newValue);
    });
    this.tbA05.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA05, newValue);
    });
    this.tbA06.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA06, newValue);
    });
    this.tbA10.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA10, newValue);
    });
    this.tbA11.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA11, newValue);
    });
    this.tbA12.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA12, newValue);
    });
    this.tbA13.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA13, newValue);
    });
    this.tbA14.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA14, newValue);
    });
    this.tbA15.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA15, newValue);
    });
    this.tbA16.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA16, newValue);
    });
    this.tbA20.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA20, newValue);
    });
    this.tbA21.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA21, newValue);
    });
    this.tbA22.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA22, newValue);
    });
    this.tbA23.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA23, newValue);
    });
    this.tbA24.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA24, newValue);
    });
    this.tbA25.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA25, newValue);
    });
    this.tbA26.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA26, newValue);
    });
    this.tbA30.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA30, newValue);
    });
    this.tbA31.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA31, newValue);
    });
    this.tbA32.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA32, newValue);
    });
    this.tbA33.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA33, newValue);
    });
    this.tbA34.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA34, newValue);
    });
    this.tbA35.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA35, newValue);
    });
    this.tbA36.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.tbA36, newValue);
    });
    this.parametrosBbMcb.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbMcb, newValue);
    });
    this.parametrosBbMf.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbMf, newValue);
    });
    this.parametrosBbPp.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbPp, newValue);
    });
    this.parametrosBbXcg.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbXcg, newValue);
    });
    this.parametrosBbXcgb.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbXcgb, newValue);
    });
    this.parametrosBbVc.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbVc, newValue);
    });
    this.parametrosBbBeta.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbBeta, newValue);
    });
    this.parametrosBbK.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbK, newValue);
    });
    this.parametrosBbN.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbN, newValue);
    });
    this.parametrosBbDb.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbDb, newValue);
    });
    this.parametrosBbAjFibb.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.parametrosBbAjFibb, newValue);
    });
    this.espoleta1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.espoleta1, newValue);
    });
    this.pesoEspoleta1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoEspoleta1, newValue);
    });
    this.espoleta2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.espoleta2, newValue);
    });
    this.pesoEspoleta2.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoEspoleta2, newValue);
    });
    this.espoleta3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.espoleta3, newValue);
    });
    this.pesoEspoleta3.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pesoEspoleta3, newValue);
    });
    this.municionVelocidad.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionVelocidad, newValue);
    });
    this.municionDrag.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionDrag, newValue);
    });
    this.municionElevacion.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionElevacion, newValue);
    });
    this.municionA0.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionA0, newValue);
    });
    this.municionA1.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionA1, newValue);
    });
    this.municionDesviacionSuperficie.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionDesviacionSuperficie, newValue);
    });
    this.municionDesviacionAzimut.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionDesviacionAzimut, newValue);
    });
    this.municionDesviacionUbicacionDistancia.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionDesviacionUbicacionDistancia, newValue);
    });
    this.municionDesviacionUbicacionAzimut.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.municionDesviacionUbicacionAzimut, newValue);
    });
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    };
    this.municionPesoSTD.setConverter(stringConverter);

    int ij;
    for(ij = 0; ij < 5; ++ij) {
      String texto = "";

      for(int j = 0; j < ij + 1; ++j) {
        texto = texto + "◻";
      }

      this.municionPesoSTD.getItems().add(new SimpleComboBoxItem(texto, ij));
      texto = "";
    }

    this.efectoEspoleta1.setConverter(stringConverter);
    this.addItemsEfectoEspoleta(this.efectoEspoleta1);
    this.efectoEspoleta2.setConverter(stringConverter);
    this.addItemsEfectoEspoleta(this.efectoEspoleta2);
    this.efectoEspoleta3.setConverter(stringConverter);
    this.addItemsEfectoEspoleta(this.efectoEspoleta3);
    this.municionBB.setConverter(stringConverter);
    this.municionBB.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.municion.municionBB.si"), 1));
    this.municionBB.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.municion.municionBB.no"), 2));
    this.municionBB.valueProperty().addListener((observable, oldValue, newValue) -> {
      this.municionNumZonas.getItems().clear();
      this.municionNumZonas.setValue(null);
      int i;
      if (this.municionBB.getSelectionModel().isSelected(0)) {
        for(i = 0; i < this.cxbbArray.length; ++i) {
          this.cxbbArray[i].setDisable(false);
          this.iformArray[i].setDisable(false);
          this.iArray[i].setDisable(false);
        }

        for(i = 0; i < this.mcbArray.length; ++i) {
          this.mcbArray[i].setDisable(false);
          this.scArray[i].setDisable(false);
        }

        for(i = 0; i < this.parametrosBB.length; ++i) {
          this.parametrosBB[i].setDisable(false);
        }

        for(i = 0; i < this.checkZoneArray.length; ++i) {
          this.checkZoneArray[i].setDisable(false);
          this.kpArray[i].setDisable(false);
          this.fibbA0Array[i].setDisable(false);
          this.fibbA1Array[i].setDisable(false);
          this.fibbA2Array[i].setDisable(false);
          this.fibbA3Array[i].setDisable(false);
          this.fibbB1Array[i].setDisable(false);
          this.fibbB2Array[i].setDisable(false);
          this.fibbB3Array[i].setDisable(false);
          this.tdiA0Array[i].setDisable(false);
          this.tdiA1Array[i].setDisable(false);
          this.tdiA2Array[i].setDisable(false);
          this.tdiA3Array[i].setDisable(false);
          this.tbA0Array[i].setDisable(false);
          this.tbA1Array[i].setDisable(false);
          this.tbA2Array[i].setDisable(false);
          this.tbA3Array[i].setDisable(false);
        }
      } else if (this.municionBB.getSelectionModel().isSelected(1)) {
        for(i = 0; i < this.cxbbArray.length; ++i) {
          this.cxbbArray[i].setDisable(true);
          this.cxbbArray[i].setText("0.00");
          this.iformArray[i].setDisable(true);
          this.iformArray[i].setText("0.00");
          this.iArray[i].setDisable(true);
          this.iArray[i].setText("0.00");
        }

        for(i = 0; i < this.mcbArray.length; ++i) {
          this.mcbArray[i].setDisable(true);
          this.mcbArray[i].setText("0.00");
          this.scArray[i].setDisable(true);
          this.scArray[i].setText("0.00");
        }

        for(i = 0; i < this.parametrosBB.length; ++i) {
          this.parametrosBB[i].setDisable(true);
          this.parametrosBB[i].setText("0.00");
        }

        for(i = 0; i < this.checkZoneArray.length; ++i) {
          this.checkZoneArray[i].setSelected(false);
          this.checkZoneArray[i].setDisable(true);
          this.kpArray[i].setDisable(true);
          this.kpArray[i].setText("0.00");
          this.fibbA0Array[i].setDisable(true);
          this.fibbA0Array[i].setText("0.00");
          this.fibbA1Array[i].setDisable(true);
          this.fibbA1Array[i].setText("0.00");
          this.fibbA2Array[i].setDisable(true);
          this.fibbA2Array[i].setText("0.00");
          this.fibbA3Array[i].setDisable(true);
          this.fibbA3Array[i].setText("0.00");
          this.fibbB1Array[i].setDisable(true);
          this.fibbB1Array[i].setText("0.00");
          this.fibbB2Array[i].setDisable(true);
          this.fibbB2Array[i].setText("0.00");
          this.fibbB3Array[i].setDisable(true);
          this.fibbB3Array[i].setText("0.00");
          this.tdiA0Array[i].setDisable(true);
          this.tdiA0Array[i].setText("0.00");
          this.tdiA1Array[i].setDisable(true);
          this.tdiA1Array[i].setText("0.00");
          this.tdiA2Array[i].setDisable(true);
          this.tdiA2Array[i].setText("0.00");
          this.tdiA3Array[i].setDisable(true);
          this.tdiA3Array[i].setText("0.00");
          this.tbA0Array[i].setDisable(true);
          this.tbA0Array[i].setText("0.00");
          this.tbA1Array[i].setDisable(true);
          this.tbA1Array[i].setText("0.00");
          this.tbA2Array[i].setDisable(true);
          this.tbA2Array[i].setText("0.00");
          this.tbA3Array[i].setDisable(true);
          this.tbA3Array[i].setText("0.00");
        }
      }

      for(i = 1; i < 8; ++i) {
        this.municionNumZonas.getItems().add(new SimpleComboBoxItem(String.valueOf(i), i));
      }

      this.municionNumZonas.getSelectionModel().select(0);
    });
    this.efectoMunicion.setConverter(stringConverter);
    this.efectoMunicion.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.municion.efecto.municion.he"), 1));
    this.efectoMunicion.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.municion.efecto.municion.iluminacion"), 2));
    this.efectoMunicion.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.municion.efecto.municion.fumigena"), 3));
    this.efectoMunicion.valueProperty().addListener((observable, oldValue, newValue) -> {
      if (((SimpleComboBoxItem)this.efectoMunicion.getSelectionModel().getSelectedItem()).getText().equals(StringUtil.translateKey("label.municion.efecto.municion.iluminacion"))) {
        this.alturaExplo.setDisable(false);
        this.tiempoBengala.setDisable(false);
      } else {
        this.alturaExplo.setDisable(true);
        this.alturaExplo.setText("0.00");
        this.tiempoBengala.setDisable(true);
        this.tiempoBengala.setText("0.00");
      }

    });
    this.municionNumZonas.setConverter(stringConverter);
    this.municionNumZonas.valueProperty().addListener((observable, oldValue, newValue) -> {
      int i;
      if (this.municionBB.getSelectionModel().isSelected(1)) {
        if (this.municionNumZonas.getValue() != null) {
          this.zonesBB = Integer.parseInt(((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText());

          for(i = 0; i < 7; ++i) {
            this.setEnableZone(i);
          }

          for(i = (Integer)newValue.getData(); i < 7; ++i) {
            this.setDisableZone(i);
          }
        }
      } else if (this.municionBB.getSelectionModel().isSelected(0) && this.municionNumZonas.getValue() != null) {
        this.zonesBB = Integer.parseInt(((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText());

        for(i = 0; i < 7; ++i) {
          this.checkZoneArray[i].setSelected(false);
          this.setDisableZone(i);
        }
      }

    });
    this.espoletas.setConverter(stringConverter);

    for(ij = 1; ij < 4; ++ij) {
      this.espoletas.getItems().add(new SimpleComboBoxItem(String.valueOf(ij), ij));
    }

    this.espoletas.valueProperty().addListener((observable, oldValue, newValue) -> {
      if (Integer.parseInt(((SimpleComboBoxItem)this.espoletas.getSelectionModel().getSelectedItem()).getText()) == 1) {
        this.espoleta2.setDisable(true);
        this.espoleta2.getStyleClass().remove("error");
        this.espoleta2.setText("");
        this.pesoEspoleta2.setDisable(true);
        this.pesoEspoleta2.getStyleClass().remove("error");
        this.pesoEspoleta2.setText("0.00");
        this.efectoEspoleta2.setDisable(true);
        this.efectoEspoleta2.getSelectionModel().select(0);
        this.espoleta3.setDisable(true);
        this.espoleta3.getStyleClass().remove("error");
        this.espoleta3.setText("");
        this.pesoEspoleta3.setDisable(true);
        this.pesoEspoleta3.getStyleClass().remove("error");
        this.pesoEspoleta3.setText("0.00");
        this.efectoEspoleta3.setDisable(true);
        this.efectoEspoleta3.getSelectionModel().select(0);
      } else if (Integer.parseInt(((SimpleComboBoxItem)this.espoletas.getSelectionModel().getSelectedItem()).getText()) == 2) {
        this.espoleta2.setDisable(false);
        this.pesoEspoleta2.setDisable(false);
        this.efectoEspoleta2.setDisable(false);
        this.espoleta3.setDisable(true);
        this.espoleta3.getStyleClass().remove("error");
        this.espoleta3.setText("");
        this.pesoEspoleta3.setDisable(true);
        this.pesoEspoleta3.getStyleClass().remove("error");
        this.pesoEspoleta3.setText("0.00");
        this.efectoEspoleta3.setDisable(true);
        this.efectoEspoleta3.getSelectionModel().select(0);
      } else if (Integer.parseInt(((SimpleComboBoxItem)this.espoletas.getSelectionModel().getSelectedItem()).getText()) == 3) {
        this.espoleta2.setDisable(false);
        this.pesoEspoleta2.setDisable(false);
        this.efectoEspoleta2.setDisable(false);
        this.espoleta3.setDisable(false);
        this.pesoEspoleta3.setDisable(false);
        this.efectoEspoleta3.setDisable(false);
      }

    });
  }

  private void addItemsEfectoEspoleta(ComboBox<SimpleComboBoxItem> comboBox) {
    comboBox.getItems().add(new SimpleComboBoxItem("TIME", 1));
    comboBox.getItems().add(new SimpleComboBoxItem("DELAY", 2));
    comboBox.getItems().add(new SimpleComboBoxItem("PDM", 3));
    comboBox.getItems().add(new SimpleComboBoxItem("PROX", 4));
    comboBox.getItems().add(new SimpleComboBoxItem("MOFA", 5));
  }

  private void validateField(Node field, boolean newValue) {
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (textField == this.espoleta1 || textField == this.espoleta2 || textField == this.espoleta3) {
      if (this.espoletas.getSelectionModel().isSelected(0)) {
        if (textField == this.espoleta1 && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
          textField.getStyleClass().add("error");
        }

        if ((textField == this.espoleta2 || textField == this.espoleta3) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
          textField.getStyleClass().add("error");
        }
      }

      if (this.espoletas.getSelectionModel().isSelected(1)) {
        if ((textField == this.espoleta1 || textField == this.espoleta2) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
          textField.getStyleClass().add("error");
        }

        if (textField == this.espoleta3 && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
          textField.getStyleClass().add("error");
        }
      } else if (this.espoletas.getSelectionModel().isSelected(2) && (textField == this.espoleta1 || textField == this.espoleta2 || textField == this.espoleta3) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
        textField.getStyleClass().add("error");
      }
    }

    if ((textField == this.pesoEspoleta2 || textField == this.pesoEspoleta3) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_POSITIVE_DOUBLE_FUZE)) {
      textField.getStyleClass().add("error");
    }

    if (textField == this.nombreMunicion && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
      textField.getStyleClass().add("error");
    }

    if (textField == this.prop0 || textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6) {
      if (this.municionBB.getSelectionModel().isSelected(1)) {
        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("1")) {
          if (textField == this.prop0) {
            if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
              textField.getStyleClass().add("error");
            }
          } else if ((textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("2")) {
          if (textField != this.prop0 && textField != this.prop1) {
            if ((textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
              textField.getStyleClass().add("error");
            }
          } else if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("3")) {
          if (textField != this.prop0 && textField != this.prop1 && textField != this.prop2) {
            if ((textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
              textField.getStyleClass().add("error");
            }
          } else if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("4")) {
          if (textField != this.prop0 && textField != this.prop1 && textField != this.prop2 && textField != this.prop3) {
            if ((textField == this.prop4 || textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
              textField.getStyleClass().add("error");
            }
          } else if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("5")) {
          if (this.municionBB.getSelectionModel().getSelectedIndex() == 1) {
            if (textField != this.prop0 && textField != this.prop1 && textField != this.prop2 && textField != this.prop3 && textField != this.prop4) {
              if ((textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
                textField.getStyleClass().add("error");
              }
            } else if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
              textField.getStyleClass().add("error");
            }
          } else if (this.municionBB.getSelectionModel().getSelectedIndex() == 0) {
            if (textField == this.prop5) {
              if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
                textField.getStyleClass().add("error");
              }
            } else if ((textField == this.prop0 || textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
              textField.getStyleClass().add("error");
            }
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("6")) {
          if (this.municionBB.getSelectionModel().getSelectedIndex() == 1) {
            if (textField != this.prop0 && textField != this.prop1 && textField != this.prop2 && textField != this.prop3 && textField != this.prop4 && textField != this.prop5) {
              if (textField == this.prop6 && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
                textField.getStyleClass().add("error");
              }
            } else if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
              textField.getStyleClass().add("error");
            }
          } else if (this.municionBB.getSelectionModel().getSelectedIndex() == 0) {
            if (textField == this.prop5) {
              if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
                textField.getStyleClass().add("error");
              }
            } else if ((textField == this.prop0 || textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
              textField.getStyleClass().add("error");
            }
          }
        }

        if (((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText().equals("7") && (textField == this.prop0 || textField == this.prop1 || textField == this.prop2 || textField == this.prop3 || textField == this.prop4 || textField == this.prop5 || textField == this.prop6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
          textField.getStyleClass().add("error");
        }
      } else if (this.municionBB.getSelectionModel().isSelected(0)) {
        if (textField == this.prop0 && this.checkZone0.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop0 && !this.checkZone0.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop1 && this.checkZone1.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop1 && !this.checkZone1.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop2 && this.checkZone2.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop2 && !this.checkZone2.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop3 && this.checkZone3.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop3 && !this.checkZone3.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop4 && this.checkZone4.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop4 && !this.checkZone4.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop5 && this.checkZone5.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop5 && !this.checkZone5.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop6 && this.checkZone6.isSelected()) {
          if (!newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME)) {
            textField.getStyleClass().add("error");
          }
        } else if (textField == this.prop6 && !this.checkZone6.isSelected() && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_NAME_FUZE)) {
          textField.getStyleClass().add("error");
        }
      }
    }

    if (textField == this.municionTc && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_TC)) {
      textField.getStyleClass().add("error");
    }

    if (textField == this.diametroMunicion && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_INT)) {
      textField.getStyleClass().add("error");
    }

    if ((textField == this.municionPesoProyectil || textField == this.cambioMunicionPeso || textField == this.parametrosBbMcb || textField == this.parametrosBbMf || textField == this.parametrosBbPp || textField == this.parametrosBbXcg || textField == this.parametrosBbXcgb || textField == this.parametrosBbVc || textField == this.pesoEspoleta1 || textField == this.qemaxr0 || textField == this.qemaxr1 || textField == this.qemaxr2 || textField == this.qemaxr3 || textField == this.qemaxr4 || textField == this.qemaxr5 || textField == this.qemaxr6) && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_POSITIVE_DOUBLE)) {
      textField.getStyleClass().add("error");
    }

    if (textField != this.nombreMunicion && textField != this.prop0 && textField != this.prop1 && textField != this.prop2 && textField != this.prop3 && textField != this.prop4 && textField != this.prop5 && textField != this.prop6 && textField != this.qemaxr0 && textField != this.qemaxr1 && textField != this.qemaxr2 && textField != this.qemaxr3 && textField != this.qemaxr4 && textField != this.qemaxr5 && textField != this.qemaxr6 && textField != this.zone0 && textField != this.zone1 && textField != this.zone2 && textField != this.zone3 && textField != this.zone4 && textField != this.zone5 && textField != this.zone6 && textField != this.municionTc && textField != this.diametroMunicion && textField != this.municionPesoProyectil && textField != this.cambioMunicionPeso && textField != this.parametrosBbMcb && textField != this.parametrosBbMf && textField != this.parametrosBbPp && textField != this.parametrosBbXcg && textField != this.parametrosBbXcgb && textField != this.parametrosBbVc && textField != this.espoleta1 && textField != this.espoleta2 && textField != this.espoleta3 && textField != this.pesoEspoleta1 && textField != this.pesoEspoleta2 && textField != this.pesoEspoleta3 && !newValue && !textField.getText().matches(MeasureExpression.AMMO_ADD_DOUBLE)) {
      textField.getStyleClass().add("error");
    }

  }

  private void clearForm() {
    int i;
    for(i = 0; i < this.variablesMAtrix.size(); ++i) {
      TextField[] textFieldArray = (TextField[])((TextField[])this.variablesMAtrix.get(i));

      for(int j = 0; j < textFieldArray.length; ++j) {
        textFieldArray[j].setText("0.00");
      }
    }

    this.nombreMunicion.setText("");
    this.diametroMunicion.setText("0");
    this.municionPesoSTD.getSelectionModel().select(0);
    this.municionBB.getSelectionModel().select(1);
    this.municionNumZonas.getSelectionModel().select(0);
    this.efectoMunicion.getSelectionModel().select(0);
    this.municionTc.setText("0");

    for(i = 0; i < 7; ++i) {
      if (i == 0) {
        this.propArray[0].setText("");
      } else {
        this.propArray[i].setText(" ");
      }
    }

    this.espoletas.getSelectionModel().select(0);
    this.espoleta1.setText("");
    this.efectoEspoleta1.getSelectionModel().select(0);
    this.espoleta2.setText("");
    this.efectoEspoleta2.getSelectionModel().select(0);
    this.espoleta3.setText("");
    this.efectoEspoleta3.getSelectionModel().select(0);
  }

  private boolean validateForm() {
    int i;
    TextField[] textFieldArray;
    int j;
    for(i = 0; i < this.variablesMAtrix.size(); ++i) {
      textFieldArray = (TextField[])((TextField[])this.variablesMAtrix.get(i));

      for(j = 0; j < textFieldArray.length; ++j) {
        this.validateField(textFieldArray[j], false);
      }
    }

    for(i = 0; i < this.variablesMAtrix.size(); ++i) {
      textFieldArray = (TextField[])((TextField[])this.variablesMAtrix.get(i));

      for(j = 0; j < textFieldArray.length; ++j) {
        if (this.municionBB.getSelectionModel().isSelected(1)) {
          if (textFieldArray[j].getStyleClass().contains("error")) {
            return false;
          }
        } else if (this.municionBB.getSelectionModel().isSelected(0) && (textFieldArray[j].getStyleClass().contains("error") || this.zonesBB != this.auxZoneBB)) {
          return false;
        }
      }
    }

    return true;
  }

  private void formSubmit() {
    if (!this.nombreMunicion.getText().equals("")) {
      try {
        new Ammunition();
        AmmunitionService ammunitionService = new AmmunitionService();
        ammunitionService.createTableIfNotExists(Ammunition.class);
        Ammunition ammunitionExist = (Ammunition)ammunitionService.getById(Ammunition.class, this.nombreMunicion.getText());
        if (ammunitionExist == null) {
          this.setVelPromArray();
          this.addOrUpdateAmmunition(this.nombreMunicion.getText());
          Platform.runLater(() -> {
            Main.getAppController().setInfoDialog("Munición Creada", "La munición " + this.nombreMunicion.getText() + " se creó con éxito", "INFO");
          });
        } else if (this.edit) {
          if (!this.auxVelArray.equals(DataTools.toStringTFArray(this.velArray))) {
            this.setVelPromArray();
          }

          this.addOrUpdateAmmunition(this.nombreMunicion.getText());
          Platform.runLater(() -> {
            Main.getAppController().setInfoDialog("Munición Modificada", "La munición " + this.nombreMunicion.getText() + " se modificó con éxito", "INFO");
          });
        } else {
          Platform.runLater(() -> {
            Main.getAppController().setInfoDialog("Error Munición", "La munición " + this.nombreMunicion.getText() + " ya existe", "ERROR");
          });
        }

        Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.AMMO);
      } catch (SQLException var3) {
        var3.printStackTrace();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

  }

  private void setVelPromArray() {
    this.velPromArray = new String[this.zoneArray.length];
    double[] auxDouble = new double[10];

    for(int i = 0; i < this.zoneArray.length; ++i) {
      for(int j = 0; j < 10; ++j) {
        auxDouble[j] = Double.parseDouble(this.velArray[i].getText());
      }

      this.velPromArray[i] = DataTools.toStringDouble(auxDouble);
    }

  }

  public void addOrUpdateAmmunition(String ammoName) {
    int i;
    if (this.municionBB.getSelectionModel().isSelected(0)) {
      this.zonesBBSelected = new int[this.zonesBB];
      i = 0;

      for(int j = 0; j < this.checkZoneArray.length; ++j) {
        if (this.checkZoneArray[j].isSelected()) {
          this.zonesBBSelected[i] = j + 1;
          ++i;
        }
      }
    } else if (this.municionBB.getSelectionModel().isSelected(1)) {
      this.zonesBBSelected = new int[this.zonesBB];

      for(i = 0; i < this.zonesBBSelected.length; ++i) {
        this.zonesBBSelected[i] = i + 1;
      }
    }

    Ammunition ammunition = new Ammunition();
    ammunition.setZonesSelected(DataTools.toStringInt(this.zonesBBSelected));
    ammunition.setNombreMunicion(ammoName);
    ammunition.setEfectoMunicion(((SimpleComboBoxItem)this.efectoMunicion.getSelectionModel().getSelectedItem()).getText());
    ammunition.setIndexMunicionPesoSTD(this.municionPesoSTD.getSelectionModel().getSelectedIndex());
    ammunition.setIndexMunicionNumZonas(Integer.parseInt(((SimpleComboBoxItem)this.municionNumZonas.getSelectionModel().getSelectedItem()).getText()) - 1);
    ammunition.setMunicionBB(this.municionBB.getSelectionModel().getSelectedIndex());
    ammunition.setIndexEspoletas(this.espoletas.getSelectionModel().getSelectedIndex());
    ammunition.setManejoMunicion(DataTools.toStringTFArray(this.manejoMunicion));
    ammunition.setMachArray(DataTools.toStringTFArray(this.machArray));
    ammunition.setCdArray(DataTools.toStringTFArray(this.cdArray));
    ammunition.setCdaArray(DataTools.toStringTFArray(this.cdaArray));
    ammunition.setClArray(DataTools.toStringTFArray(this.clArray));
    ammunition.setClaArray(DataTools.toStringTFArray(this.claArray));
    ammunition.setCmArray(DataTools.toStringTFArray(this.cmArray));
    ammunition.setCmaArray(DataTools.toStringTFArray(this.cmaArray));
    ammunition.setCmagArray(DataTools.toStringTFArray(this.cmagArray));
    ammunition.setCspindArray(DataTools.toStringTFArray(this.cspindArray));
    ammunition.setCxbbArray(DataTools.toStringTFArray(this.cxbbArray));
    ammunition.setIformArray(DataTools.toStringTFArray(this.iformArray));
    ammunition.setiArray(DataTools.toStringTFArray(this.iArray));
    ammunition.setMcbArray(DataTools.toStringTFArray(this.mcbArray));
    ammunition.setScArray(DataTools.toStringTFArray(this.scArray));
    ammunition.setZoneArray(DataTools.toStringTFArray(this.zoneArray));
    ammunition.setVelArray(DataTools.toStringTFArray(this.velArray));
    ammunition.setVelPromArray(DataTools.reverseSplit(this.velPromArray, ";"));
    ammunition.setAjFDArray(DataTools.toStringTFArray(this.ajFDArray));
    ammunition.setAjFMagArray(DataTools.toStringTFArray(this.ajFMagArray));
    ammunition.setAjFLA0Array(DataTools.toStringTFArray(this.ajFLA0Array));
    ammunition.setAjFLA1Array(DataTools.toStringTFArray(this.ajFLA1Array));
    ammunition.setAjFLA2Array(DataTools.toStringTFArray(this.ajFLA2Array));
    ammunition.setAjFLA3Array(DataTools.toStringTFArray(this.ajFLA3Array));
    ammunition.setAjFLA4Array(DataTools.toStringTFArray(this.ajFLA4Array));
    ammunition.setAjiA0Array(DataTools.toStringTFArray(this.ajiA0Array));
    ammunition.setAjiA1Array(DataTools.toStringTFArray(this.ajiA1Array));
    ammunition.setAjiA2Array(DataTools.toStringTFArray(this.ajiA2Array));
    ammunition.setAjiA3Array(DataTools.toStringTFArray(this.ajiA3Array));
    ammunition.setAjiA4Array(DataTools.toStringTFArray(this.ajiA4Array));
    ammunition.setAjTimeA0Array(DataTools.toStringTFArray(this.ajTimeA0Array));
    ammunition.setAjTimeA1Array(DataTools.toStringTFArray(this.ajTimeA1Array));
    ammunition.setAjTimeA2Array(DataTools.toStringTFArray(this.ajTimeA2Array));
    ammunition.setAjTimeA3Array(DataTools.toStringTFArray(this.ajTimeA3Array));
    ammunition.setAjTimeA4Array(DataTools.toStringTFArray(this.ajTimeA4Array));
    ammunition.setPropArray(DataTools.toStringTFArray(this.propArray));
    ammunition.setGradTempArray(DataTools.toStringTFArray(this.gradTempArray));
    ammunition.setPesoVelArray(DataTools.toStringTFArray(this.pesoVelArray));
    ammunition.setQemaxrArray(DataTools.toStringTFArray(this.qemaxrArray));
    ammunition.setKpArray(DataTools.toStringTFArray(this.kpArray));
    ammunition.setFibbA0Array(DataTools.toStringTFArray(this.fibbA0Array));
    ammunition.setFibbA1Array(DataTools.toStringTFArray(this.fibbA1Array));
    ammunition.setFibbA2Array(DataTools.toStringTFArray(this.fibbA2Array));
    ammunition.setFibbA3Array(DataTools.toStringTFArray(this.fibbA3Array));
    ammunition.setFibbB1Array(DataTools.toStringTFArray(this.fibbB1Array));
    ammunition.setFibbB2Array(DataTools.toStringTFArray(this.fibbB2Array));
    ammunition.setFibbB3Array(DataTools.toStringTFArray(this.fibbB3Array));
    ammunition.setTdiA0Array(DataTools.toStringTFArray(this.tdiA0Array));
    ammunition.setTdiA1Array(DataTools.toStringTFArray(this.tdiA1Array));
    ammunition.setTdiA2Array(DataTools.toStringTFArray(this.tdiA2Array));
    ammunition.setTdiA3Array(DataTools.toStringTFArray(this.tdiA3Array));
    ammunition.setTbA0Array(DataTools.toStringTFArray(this.tbA0Array));
    ammunition.setTbA1Array(DataTools.toStringTFArray(this.tbA1Array));
    ammunition.setTbA2Array(DataTools.toStringTFArray(this.tbA2Array));
    ammunition.setTbA3Array(DataTools.toStringTFArray(this.tbA3Array));
    String[] espoletas = new String[]{this.espoleta1.getText(), this.pesoEspoleta1.getText(), ((SimpleComboBoxItem)this.efectoEspoleta1.getSelectionModel().getSelectedItem()).getText(), this.espoleta2.getText(), this.pesoEspoleta2.getText(), ((SimpleComboBoxItem)this.efectoEspoleta2.getSelectionModel().getSelectedItem()).getText(), this.espoleta3.getText(), this.pesoEspoleta3.getText(), ((SimpleComboBoxItem)this.efectoEspoleta3.getSelectionModel().getSelectedItem()).getText()};
    ammunition.setEspoletas(DataTools.reverseSplit(espoletas, ","));
    ammunition.setParametrosBB(DataTools.toStringTFArray(this.parametrosBB));
    ammunition.setAjustesPrecision(DataTools.toStringTFArray(this.ajustesPrecision));
    ammunition.setDesviacionMPI(DataTools.toStringTFArray(this.desviacionMPI));

    try {
      AmmunitionService ammunitionService = new AmmunitionService();
      ammunitionService.createTableIfNotExists(Ammunition.class);
      ammunitionService.createOrUpdate(ammunition);
    } catch (SQLException var6) {
      var6.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}