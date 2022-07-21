package co.dynamicts.neli.ui.block;

import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Pointing;
import co.dynamicts.neli.core.Hardware.InsEthernet;
import co.dynamicts.neli.core.Hardware.InsSerial;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.ObusHW.Trinca;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.models.Boletin;
import co.dynamicts.neli.core.stauts.StatusCoordinates;
import co.dynamicts.neli.core.stauts.StatusCoordinatesUTM;
import co.dynamicts.neli.ui.component.Coordinate;
import co.dynamicts.neli.ui.component.CoordinateUTM;
import co.dynamicts.neli.ui.component.common.MenuTitle;
import co.dynamicts.neli.ui.component.common.ToggleButton;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import jssc.SerialPortException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CoordinatesBlock extends BorderPane implements BaseUserInterface {
  @FXML
  private Label version;
  
  @FXML
  private Label date;
  
  @FXML
  private Label time;
  
  @FXML
  private Label number;
  
  @FXML
  private VBox systemGeo;
  
  @FXML
  private VBox systemUTM;
  
  @FXML
  private Coordinate wantedCoordinates;
  
  @FXML
  private Coordinate systemCoordinates;
  
  @FXML
  private Coordinate impactCoordinates;
  
  @FXML
  private CoordinateUTM wantedCoordinatesUTM;
  
  @FXML
  private CoordinateUTM systemCoordinatesUTM;
  
  @FXML
  private CoordinateUTM impactCoordinatesUTM;
  
  @FXML
  private ToggleButton toggleTrinca;
  
  @FXML
  private ToggleButton toggleTrayectoria;
  
  @FXML
  private ToggleButton toggleEstacion;
  
  @FXML
  private ToggleButton toggleZupt;
  
  @FXML
  private MenuTitle menuArea;
  
  @FXML
  private MenuTitle menuCriterio;
  
  private ToggleGroup zurpModeGroup = new ToggleGroup();
  
  private Principal principal;
  
  private Configuracion configuracion;
  
  private Boletin boletin;
  
  private FXMLLoader fxmlLoader;
  
  private DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  
  private DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
  
  private Ins ins = Ins.getSingletonInstance();
  
  private Pointing pointing = Pointing.getSingletonInstance();
  
  private Trinca trinca = Trinca.getSingletonInstance();
  
  public CoordinatesBlock() throws IOException {
    this.fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/blocks/coordinates.fxml"));
    this.fxmlLoader.setRoot(this);
    this.fxmlLoader.setController(this);
    this.fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      this.fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {
    this.principal = Principal.getSingletonInstance();
    this.configuracion = Configuracion.getSingletonInstance();
    this.boletin = Boletin.getSingletonInstance();
    initComponent();
    this.menuArea.setMenuTitleText(StringUtil.translateKey("menu.area"));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.boletin"), String.valueOf(0)));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.icao"), String.valueOf(1)));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.tropical"), String.valueOf(2)));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.subtropical"), String.valueOf(3)));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.templado"), String.valueOf(4)));
    this.menuArea.getMenu().getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("menu.area.polar"), String.valueOf(5)));
    Map<String, String> setupMenuCriterio = new TreeMap<>();
    setupMenuCriterio.put("0", StringUtil.translateKey("menu.criterio.vida"));
    setupMenuCriterio.put("1", StringUtil.translateKey("menu.criterio.supervivecia"));
    setupMenuCriterio.put("2", StringUtil.translateKey("menu.criterio.distancia"));
    setupMenuCriterio.put("3", StringUtil.translateKey("menu.criterio.manual"));
    this.menuCriterio.setMenuTitleText(StringUtil.translateKey("menu.criterio"));
    this.menuCriterio.setMenuItems(setupMenuCriterio);
    this.menuCriterio.getMenu().valueProperty().addListener((observable, oldValue, newValue) -> {
          if (((SimpleComboBoxItem)this.menuCriterio.getMenu().getSelectionModel().getSelectedItem()).getText().equals("Manual")) {
            this.configuracion.setActivaZone(false);
          } else {
            this.configuracion.setActivaZone(true);
          } 
          int criterio = Integer.parseInt(newValue.getData().toString());
          switch (criterio) {
            case 0:
              this.configuracion.setCriterio(Configuracion.Criterio.VIDA_CANON);
              break;
            case 1:
              this.configuracion.setCriterio(Configuracion.Criterio.SUPERVIVENCIA);
              break;
            case 2:
              this.configuracion.setCriterio(Configuracion.Criterio.AJUSTE_DISTANCIA);
              break;
            case 3:
              this.configuracion.setCriterio(Configuracion.Criterio.MANUAL);
              break;
            default:
              this.configuracion.setCriterio(Configuracion.Criterio.VIDA_CANON);
              break;
          } 
          DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
        });
    this.menuArea.getMenu().valueProperty().addListener((observable, oldValue, newValue) -> {
          System.out.println("SETTING AREA TO  " + newValue.getText());
          this.boletin.setArea(this.menuArea.getMenu().getSelectionModel().getSelectedIndex());
          DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
          System.out.println("boletin.getArea() = " + this.boletin.getArea());
          this.boletin.setArea(Integer.parseInt(newValue.getData().toString()));
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleTrinca.setOnOn(event -> {
          System.out.println("SETTING TRINCA TO ON ");
          this.trinca.setTrincaPut(true);
          this.toggleZupt.setValue(Boolean.valueOf(false));
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleTrinca.setOnOff(event -> {
          System.out.println("SETTING TRINCA TO FALSE ");
          this.trinca.setTrincaPut(false);
          this.toggleZupt.setValue(Boolean.valueOf(false));
          this.ins.setZuptTiro(false);
          if (this.ins.tipoComunicacion == Ins.TipoComunicacion.ETHERNET) {
            InsEthernet.getSingletonInstance(this.configuracion.isSimulado).setZuptTiro(false);
          } else if (this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
            InsSerial insSerial = InsSerial.getSingletonInstance();
            insSerial.setZuptTiro(false);
            try {
              insSerial.ConfigurarModoZUP(insSerial.ZUP_Modo_Navegador);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
          } 
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleTrayectoria.setOnOn(event -> {
          System.out.println("SETTING TRAYECTORIA TO ON ");
          this.configuracion.setRasante(Boolean.TRUE.booleanValue());
          DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleTrayectoria.setOnOff(event -> {
          System.out.println("SETTING TRAYECTORIA TO OFF ");
          this.configuracion.setRasante(Boolean.FALSE.booleanValue());
          DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleEstacion.setOnOn(event -> {
          System.out.println("SETTING ESTACION TO ON ");
          this.boletin.setVerano(Boolean.TRUE.booleanValue());
          DatosCalculados.getSingletonInstance().calcularDatosPorBlancoDeseado();
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleEstacion.setOnOff(event -> {
          System.out.println("SETTING ESTACION TO OFF ");
          this.boletin.setVerano(Boolean.FALSE.booleanValue());
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleZupt.setValue(Boolean.valueOf(false));
    if (this.ins.tipoComunicacion == Ins.TipoComunicacion.ETHERNET) {
      InsEthernet.getSingletonInstance(this.configuracion.isSimulado).setZuptTiro(false);
    } else if (this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
      InsSerial insSerial = InsSerial.getSingletonInstance();
      insSerial.setZuptTiro(false);
      try {
        insSerial.ConfigurarModoZUP(insSerial.ZUP_Modo_Punto_fijo);
      } catch (SerialPortException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
    this.toggleZupt.setOnOn(event -> {
          System.out.println("SETTING ZUPT TO ON ");
          if (this.ins.tipoComunicacion == Ins.TipoComunicacion.ETHERNET) {
            InsEthernet.getSingletonInstance(this.configuracion.isSimulado).setZuptTiro(true);
          } else if (this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
            InsSerial insSerial = InsSerial.getSingletonInstance();
            insSerial.setZuptTiro(true);
            try {
              insSerial.ConfigurarModoZUP(insSerial.ZUP_Modo_Punto_fijo);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
          } 
          System.out.println("SUCCESSFULLY SET  ");
        });
    this.toggleZupt.setOnOff(event -> {
          System.out.println("SETTING ZUPT TO OFF ");
          if (this.ins.tipoComunicacion == Ins.TipoComunicacion.ETHERNET) {
            InsEthernet.getSingletonInstance(this.configuracion.isSimulado).setZuptTiro(false);
          } else if (this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422) {
            InsSerial insSerial = InsSerial.getSingletonInstance();
            insSerial.setZuptTiro(false);
            try {
              insSerial.ConfigurarModoZUP(insSerial.ZUP_Modo_Navegador);
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
          } 
          System.out.println("SUCCESSFULLY SET  ");
        });
  }
  
  public void initComponent() {
    this.configuracion = Configuracion.getSingletonInstance();
    if (this.configuracion.getSistema().equals(Configuracion.Sistema.OBUS_155)) {
      this.version.setText(StringUtil.translateKey("label.general.version.155"));
    } else if (this.configuracion.getSistema().equals(Configuracion.Sistema.OBUS_105_LG)) {
      this.version.setText(StringUtil.translateKey("label.general.version.105.lg"));
    } else if (this.configuracion.getSistema().equals(Configuracion.Sistema.OBUS_105_L119)) {
      this.version.setText(StringUtil.translateKey("label.general.version.105.l199"));
    } 
    if (Configuracion.UnidadCoordenadas.GEOGRAFICAS.equals(this.configuracion.getUnidadCoordenadas())) {
      this.systemGeo.setVisible(true);
      this.systemUTM.setVisible(false);
    } else {
      this.systemGeo.setVisible(false);
      this.systemUTM.setVisible(true);
    } 
  }
  
  public void changeLanguage() {
    this.fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      this.fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void updateComponents() {
    Date objDate = new Date();
    String strDateFormat = "dd/MM/yyyy";
    String strTimeFormat = "HH:mm:ss";
    SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
    SimpleDateFormat objSTF = new SimpleDateFormat(strTimeFormat);
    this.date.setText(objSDF.format(objDate));
    this.time.setText(objSTF.format(objDate));
    this.number.setText("No. " + this.configuracion.getPieceNumber());
    if (Configuracion.UnidadCoordenadas.GEOGRAFICAS.equals(this.configuracion.getUnidadCoordenadas())) {
      this.wantedCoordinates.setStatus(StatusCoordinates.builder()
          .withCardinalidadLatitud(this.datosCalculados.blancoDeseadoGeo.getSignoLatitud())
          .withLatitudGrados(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLatGrados()))
          .withLatitudMinutos(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLatMinutos()))
          .withLatitudSegundos(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLatSegundos()))
          .withCardinalidadLongitud(this.datosCalculados.blancoDeseadoGeo.getSignoLongitud())
          .withLongitudGrados(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLonGrados()))
          .withLongitudMinutos(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLonMinutos()))
          .withLongitudSegundos(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getLonSegundos()))
          .withMetros(Double.valueOf(this.datosCalculados.blancoDeseadoGeo.getAltura()))
          .build());
      this.systemCoordinates.setStatus(StatusCoordinates.builder()
          .withCardinalidadLatitud(this.ins.obus.getSignoLatitud())
          .withLatitudGrados(Double.valueOf(this.ins.obus.getLatGrados()))
          .withLatitudMinutos(Double.valueOf(this.ins.obus.getLatMinutos()))
          .withLatitudSegundos(Double.valueOf(this.ins.obus.getLatSegundos()))
          .withCardinalidadLongitud(this.ins.obus.getSignoLongitud())
          .withLongitudGrados(Double.valueOf(this.ins.obus.getLonGrados()))
          .withLongitudMinutos(Double.valueOf(this.ins.obus.getLonMinutos()))
          .withLongitudSegundos(Double.valueOf(this.ins.obus.getLonSegundos()))
          .withMetros(Double.valueOf(this.ins.obus.getAltura()))
          .build());
      this.impactCoordinates.setStatus(StatusCoordinates.builder()
          .withCardinalidadLatitud(this.datosApuntados.blancoApuntado.getSignoLatitud())
          .withLatitudGrados(Double.valueOf(this.datosApuntados.blancoApuntado.getLatGrados()))
          .withLatitudMinutos(Double.valueOf(this.datosApuntados.blancoApuntado.getLatMinutos()))
          .withLatitudSegundos(Double.valueOf(this.datosApuntados.blancoApuntado.getLatSegundos()))
          .withCardinalidadLongitud(this.datosApuntados.blancoApuntado.getSignoLongitud())
          .withLongitudGrados(Double.valueOf(this.datosApuntados.blancoApuntado.getLonGrados()))
          .withLongitudMinutos(Double.valueOf(this.datosApuntados.blancoApuntado.getLonMinutos()))
          .withLongitudSegundos(Double.valueOf(this.datosApuntados.blancoApuntado.getLonSegundos()))
          .withMetros(Double.valueOf(this.datosApuntados.blancoApuntado.getAltura()))
          .build());
    } else {
      this.wantedCoordinatesUTM.setPoint(
          StatusCoordinatesUTM.builder()
          .withEastUTM(Integer.valueOf((int)this.datosCalculados.blancoDeseadoUTM.getDeltaEste()))
          .withNorthUTM(Integer.valueOf((int)this.datosCalculados.blancoDeseadoUTM.getDeltaNorte()))
          .withUseUTM(Integer.valueOf((int)this.datosCalculados.blancoDeseadoUTM.getHuso()))
          .withBandUTM(this.datosCalculados.blancoDeseadoUTM.getBanda())
          .withHeight(Integer.valueOf((int)this.datosCalculados.blancoDeseadoUTM.getAltura()))
          .build());
      this.systemCoordinatesUTM.setPoint(
          
          StatusCoordinatesUTM.builder()
          .withEastUTM(Integer.valueOf((int)this.ins.obusUTM.getDeltaEste()))
          .withNorthUTM(Integer.valueOf((int)this.ins.obusUTM.getDeltaNorte()))
          .withUseUTM(Integer.valueOf((int)this.ins.obusUTM.getHuso()))
          .withBandUTM(this.ins.obusUTM.getBanda())
          .withHeight(Integer.valueOf((int)this.ins.obusUTM.getAltura()))
          .build());
      this.impactCoordinatesUTM.setPoint(
          
          StatusCoordinatesUTM.builder()
          .withEastUTM(Integer.valueOf((int)this.datosApuntados.blancoApuntadoUTM.getDeltaEste()))
          .withNorthUTM(Integer.valueOf((int)this.datosApuntados.blancoApuntadoUTM.getDeltaNorte()))
          .withUseUTM(Integer.valueOf((int)this.datosApuntados.blancoApuntadoUTM.getHuso()))
          .withBandUTM(this.datosApuntados.blancoApuntadoUTM.getBanda())
          .withHeight(Integer.valueOf((int)this.datosApuntados.blancoApuntadoUTM.getAltura()))
          .build());
    } 
    this.toggleTrinca.setValue(Boolean.valueOf(this.trinca.isTrincaPut()));
    this.toggleTrayectoria.setValue(Boolean.valueOf(this.configuracion.isRasante()));
    this.toggleEstacion.setValue(Boolean.valueOf(this.boletin.isVerano()));
    this.menuArea.setSelectedValue(String.valueOf(this.boletin.getArea()));
    switch (this.configuracion.getCriterio()) {
      case VIDA_CANON:
        this.menuCriterio.setSelectedValue(String.valueOf(0));
        return;
      case SUPERVIVENCIA:
        this.menuCriterio.setSelectedValue(String.valueOf(1));
        return;
      case AJUSTE_DISTANCIA:
        this.menuCriterio.setSelectedValue(String.valueOf(2));
        return;
      case MANUAL:
        this.menuCriterio.setSelectedValue(String.valueOf(3));
        return;
    } 
    this.menuCriterio.setSelectedValue(String.valueOf(3));
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\block\CoordinatesBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */