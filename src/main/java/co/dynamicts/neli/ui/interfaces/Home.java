package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Direccion;
import co.dynamicts.neli.core.Fires.Pointing;
import co.dynamicts.neli.core.ObusHW.*;
import co.dynamicts.neli.core.ObusHW.Ins.EstadoGPS;
import co.dynamicts.neli.core.ObusHW.Ins.EstadoINS;
import co.dynamicts.neli.core.ObusHW.Ins.TipoComunicacion;
import co.dynamicts.neli.core.angle.Angle;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadAngulo;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadDistancia;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.stauts.StatusCenterComponents;
import co.dynamicts.neli.core.stauts.StatusDataGrid;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.core.utilities.Tools;
import co.dynamicts.neli.ui.component.*;
import co.dynamicts.neli.ui.component.common.Confirm;
import co.dynamicts.neli.ui.component.home.DataGrid;
import co.dynamicts.neli.ui.component.home.GraficaAlineacion;
import co.dynamicts.neli.ui.component.home.GraficaDireccion;
import co.dynamicts.neli.ui.component.home.OrdenadaMaxima;
import co.dynamicts.neli.ui.component.home.state.*;
import co.dynamicts.neli.ui.component.home.top.menu.BandejaItemStatus;
import co.dynamicts.neli.ui.component.home.top.menu.ItemStatus;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.animation.RotateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.css.Styleable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Cylinder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Home extends VBox implements BaseUserInterface, Initializable {
  public static final String OK = "ok";
  public static final String MED = "med";
  public static final String BAD = "bad";
  public static final String DEFAULT = "default";
  @FXML
  private ReachClock reachClock;
  @FXML
  private ElevationClock elevationClock;
  @FXML
  private AzimuthClock azimuthClock;
  @FXML
  private HDataViewer lefLimit;
  @FXML
  private HDataViewer rightLimit;
  @FXML
  private DataViewer reachDataViewer;
  @FXML
  private DataViewer azimuthDataViewer;
  @FXML
  private DataViewer elevationDataViewer;
  @FXML
  private DataViewer orientacionDataViewer;
  @FXML
  private Confirm confirmarDisparo;
  @FXML
  private GraficaDireccion graficaDireccion;
  @FXML
  private OrdenadaMaxima ordenadaMaxima;
  @FXML
  private GraficaAlineacion graficaAlineacion;
  @FXML
  private DataGrid dataGrid;
  private RotateTransition rotateTransition;
  private RotateTransition azimuthRT;
  private DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
  private DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  private Ins ins = Ins.getSingletonInstance();
  private Pointing pointing = Pointing.getSingletonInstance();
  private Cylinder cylinder;
  private final transient DoubleProperty clockRotation = new SimpleDoubleProperty(0.0);
  private Principal principal;
  private XYChart.Series shoot = new XYChart.Series();
  private XYChart.Series target = new XYChart.Series();
  private XYChart.Series maxLine = new XYChart.Series();
  private XYChart.Series verticalInterval = new XYChart.Series();
  private Direccion direccion = Direccion.getSingletonInstance();
  FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/home.fxml"), AppConfig.getInstance().getResouce());

  public Home() {
    this.fxmlLoader.setRoot(this);
    this.fxmlLoader.setController(this);
    this.fxmlLoader.setResources(AppConfig.getInstance().getResouce());

    try {
      this.fxmlLoader.load();
    } catch (IOException var2) {
      throw new RuntimeException(var2);
    }
  }

  public void setCenterComponents(StatusCenterComponents status) {
    double azimuth = DataTools.limitaDecimales(status.getAzimut());
    double elevacion = status.getElevacion();
    double elevacionMaxima = DataTools.limitaDecimales(status.getLimiteSuperior());
    double elevacionMinima = DataTools.limitaDecimales(status.getLimiteInferior());
    double alcance = DataTools.limitaDecimales(status.getAlcance());
    double alcanceDeseado = DataTools.limitaDecimales(status.getAlcanceDes());
    double azimuthDeseado = DataTools.limitaDecimales(status.getAzimutDes());
    double elevacionDeseada = status.getElevacionDes();
    double orientacionDeseada = DataTools.limitaDecimales(status.getOrientacionDes());
    double limiteIzquierda = DataTools.limitaDecimales(status.getLimiteIzquierda());
    double limiteDerecha = DataTools.limitaDecimales(status.getLimiteDerecha());
    String colorOrientacion = status.getColorOrientacion();
    String colorElevacion = status.getColorElevacion();
    String colorLimiteDerecha = status.getLimTiroDerIsBad() ? "bad" : "ok";
    String colorLimiteIzquierda = status.getLimTiroIzqIsBad() ? "bad" : "ok";
    String colorLimiteSuperior = status.getLimTiroSupIsBad() ? "bad" : "ok";
    String colorLimiteInferior = status.getLimTiroInfIsBad() ? "bad" : "ok";
    this.setColor(this.azimuthClock.getValueLabel(), colorOrientacion);
    this.setColor(this.elevationClock.getValueLabel(), colorElevacion);
    this.setColor(this.rightLimit.getLeftLabel(), colorLimiteIzquierda);
    this.setColor(this.lefLimit.getRightLabel(), colorLimiteDerecha);
    this.setColor(this.elevationClock.maxLabel, colorLimiteSuperior);
    this.setColor(this.elevationClock.minLabel, colorLimiteInferior);
    this.azimuthClock.setValue(azimuth);
    this.elevationClock.setValue(elevacion);
    this.elevationClock.setMax("Max " + elevacionMaxima);
    this.elevationClock.setMin("Min " + elevacionMinima);
    if (Configuracion.getSingletonInstance().getUnidadDistancia().equals(UnidadDistancia.METROS)) {
      this.reachClock.setValue("meter", alcance);
    } else {
      this.reachClock.setValue("kilometer", alcance);
    }

    this.lefLimit.setRight(String.valueOf(limiteIzquierda));
    this.rightLimit.setLeft(String.valueOf(limiteDerecha));
    this.reachDataViewer.setValue(String.valueOf(alcanceDeseado));
    this.azimuthDataViewer.setValue(String.valueOf((int)azimuthDeseado));
    this.elevationDataViewer.setValue(String.valueOf(elevacionDeseada));
    this.orientacionDataViewer.setValue(String.valueOf(orientacionDeseada));
    if (status.getXRigth()) {
      this.azimuthClock.setArrow("RIGHT_ARROW");
    } else if (status.getXLeft()) {
      this.azimuthClock.setArrow("LEFT_ARROW");
    } else {
      this.azimuthClock.setArrow((String)null);
    }

    if (status.getYup()) {
      this.elevationClock.setArrow("UP_ARROW");
    } else if (status.getYdown()) {
      this.elevationClock.setArrow("DOWN_ARROW");
    } else {
      this.elevationClock.setArrow((String)null);
    }

    this.clearStatusStyleClass(this.azimuthClock);
    this.clearStatusStyleClass(this.azimuthDataViewer);
    this.clearStatusStyleClass(this.elevationClock);
    this.clearStatusStyleClass(this.reachClock);
    this.clearStatusStyleClass(this.elevationDataViewer);
    this.clearStatusStyleClass(this.reachDataViewer);
    if (this.pointing.isXOk()) {
      this.updateColorsAffectedByXStatus("ok");
    } else if (this.pointing.isXMed()) {
      this.updateColorsAffectedByXStatus("med");
    } else if (this.pointing.isXbad()) {
      this.updateColorsAffectedByXStatus("bad");
    } else if (this.pointing.isXNone()) {
      this.updateColorsAffectedByXStatus("");
    }

    if (this.pointing.isYOk()) {
      this.updateColorsAffectedByYStatus("ok");
    } else if (this.pointing.isYMed()) {
      this.updateColorsAffectedByYStatus("med");
    } else if (this.pointing.isYbad()) {
      this.updateColorsAffectedByYStatus("bad");
    } else if (this.pointing.isYNone()) {
      this.updateColorsAffectedByYStatus("");
    }

  }

  public void updateComponents() {
    if (this.pointing.isXbad()) {
      if (this.direccion.isLimTiroInfIsBad()) {
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.lower.limit"), "ERROR");
      } else if (this.direccion.isLimTiroSupIsBad()) {
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.upper.limit"), "ERROR");
      } else {
        Main.getAppController().setInfoMessage("", "DEFAULT");
      }
    }

    if (this.pointing.isYbad()) {
      if (this.direccion.isLimTiroIzqIsBad()) {
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.right.limit"), "ERROR");
      } else if (this.direccion.isLimTiroDerIsBad()) {
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.left.limit"), "ERROR");
      } else {
        Main.getAppController().setInfoMessage("", "DEFAULT");
      }
    }

    if (this.pointing.isXOk() && this.pointing.isYOk()) {
      Main.getAppController().setInfoMessage(StringUtil.translateKey("status.aim"), "INFO");
    }

    CMS cms = CMS.getSingletonInstance();
    CPA cpa = CPA.getSingletonInstance();
    Trinca trinca = Trinca.getSingletonInstance();
    Ins ins = Ins.getSingletonInstance();
    Principal principal = Principal.getSingletonInstance();
    Pointing pointing = Pointing.getSingletonInstance();
    Configuracion configuracion = Configuracion.getSingletonInstance();
    MuzzleRadar muzzleRadar = MuzzleRadar.getSingletonInstance();
    ItemStatus insStatus = null;
    ItemStatus gpsStatus = null;
    if (ins.estadoINS == EstadoINS.DISCONNECTED) {
      insStatus = ItemStatus.BAD;
    } else if (ins.estadoINS == EstadoINS.CONNECTED_DISALIGMENT) {
      insStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoINS == EstadoINS.CONNECTED_OK) {
      insStatus = ItemStatus.OK;
    }

    if (ins.estadoGPS == EstadoGPS.DISCONNECTED) {
      gpsStatus = ItemStatus.BAD;
    } else if (ins.estadoGPS == EstadoGPS.CONNECTED_MEDIUM) {
      gpsStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoGPS == EstadoGPS.CONNECTED_OK) {
      gpsStatus = ItemStatus.OK;
    }

    Main.getAppController().topMenu().updateState(TopMenuState.builder().withTemperatura(ItemStatus.values()[cms.getTemCanonState()]).withCalibracion(ItemStatus.values()[cpa.getIsCalibrated()]).withTrinca(trinca.isTrincaPut() ? ItemStatus.BAD : ItemStatus.OK).withStatusBandeja(BandejaItemStatus.values()[cpa.getHMS()]).withBandeja(ItemStatus.values()[cpa.getHMS()]).withMunicion(configuracion.municion.getCantidad()).withZupt(ins.isZuptTiro() ? ItemStatus.OK : ItemStatus.BAD).withCms(cms.isCMS() ? ItemStatus.OK : ItemStatus.OK).withHms(cpa.isCPA() ? ItemStatus.OK : ItemStatus.OK).withOdometro(ins.isOdo() ? ItemStatus.OK : ItemStatus.BAD).withRadar(muzzleRadar.isRadarOk() ? ItemStatus.OK : ItemStatus.BAD).withPunteria(cpa.isCPA() ? ItemStatus.OK : ItemStatus.BAD).withGps(gpsStatus).withIns(insStatus).build());
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
    this.graficaDireccion.updateState(GraficaDireccionState.builder().withAzimuth(Angle.ofMillis(DatosCalculados.getSingletonInstance().actitudDeseadaMils.getAzimut())).withCannonLeftLimit(Angle.ofMillis(this.direccion.getLimiteIzquierdoTiro())).withCannonRightLimit(Angle.ofMillis(this.direccion.getLimiteDerechoTiro())).withWeaponLeftLimit(Optional.of(Angle.ofMillis(this.direccion.getLimiteIzquierdoFisico()))).withWeaponRightLimit(Optional.of(Angle.ofMillis(this.direccion.getLimiteDerechoFisico()))).withTrinca(trinca.isTrincaPut()).withEscalaExterna(Angle.ofMillis(this.direccion.getOrientacionVehiculo())).withEscalaInterna(Angle.ofMillis(this.direccion.getOrientacionCanon())).withDiana(Angle.ofMillis(4000.0)).build());
    this.ordenadaMaxima.updateState(OrdenadaMaximaState.builder().withOrdMax(this.datosApuntados.getOrdMax()).withOrdMaxFt(this.datosApuntados.getOrdMaxFt()).build());
    this.actualizaBotonDisparar(cpa);
    this.actualizaBotonApuntar(cpa);
    this.dataGrid.updateState(StatusDataGrid.builder().withTipoMunicion(configuracion.municion.getTipo()).withCuadros(configuracion.getCuadros()).withCarga(configuracion.getTipoCarga()).withZona(configuracion.municion.zonaSelec.getNumero()).withEspoleta(configuracion.municion.espoletaSelect.getNombre()).withGraduacion(this.datosCalculados.getGraduacionEsp()).withVelocidadEnBoca(configuracion.municion.zonaSelec.getVelBoca(configuracion.getTempProp(), configuracion.getDifPeso())).withTemperaturaPropelente(configuracion.getTempProp()).withDrift(this.datosApuntados.getDrift()).withIntervaloVertical(this.datosCalculados.posicionDeseadaMetros.getIntervalo()).withCorreccionTotalDeflexion(this.datosApuntados.getCorrTotalDeflex()).withAlturaExplosion(configuracion.getAlturaExplosion_m()).withOrientacionMagnetica(ins.getMagneticOrientation()).withTiempoDeVuelo(this.datosApuntados.getTiempoVuelo()).withErrorPrecisionDistancia(this.datosApuntados.getErr_prec_Distancia()).withErrorPresicionOrient(this.datosApuntados.getErr_prec_Orientac()).withErrorPMIDistancia(this.datosApuntados.getErr_PMI_Distancia()).withErrprPMIOrientacion(this.datosApuntados.getErr_PMI_Orientacion()).build());
    this.graficaAlineacion.updateStatus(GraficaAlineacionState.builder().withOkX(pointing.isXOk()).withMedX(pointing.isXMed()).withBadX(pointing.isXbad()).withOkY(pointing.isYOk()).withMedY(pointing.isYMed()).withBadY(pointing.isYbad()).withCoordinateX(-pointing.getxPointingLog()).withCoordinateY(-pointing.getyPointingLog()).build());
    double orientacion = ins.actitud.getAzimut();
    if (Trinca.getSingletonInstance().isTrincaPut() && ins.tipoComunicacion == TipoComunicacion.RS422) {
      orientacion = Tools.restringeValores(ins.actitud.getAzimut() + 3200.0, 6400.0, 0.0);
    }

    this.setCenterComponents(StatusCenterComponents.builder().withAzimut(orientacion).withElevacion(ins.actitud.getElevacion()).withAlcance(this.datosApuntados.getAlcance()).withIsXRigth(pointing.isXRigth()).withIsXLeft(pointing.isXLeft()).withIsYdown(pointing.isYdown()).withIsYup(pointing.isYup()).withLimiteIzquierda(this.direccion.getLimiteIzquierdoTiro()).withLimiteDerecha(this.direccion.getLimiteDerechoTiro()).withLimiteSuperior(this.direccion.getLimiteSuperiorTiro()).withLimiteInferior(this.direccion.getLimiteInferiorTiro()).withIsLimTiroDerIsBad(this.direccion.isLimTiroDerIsBad()).withIsLimTiroIzqIsBad(this.direccion.isLimTiroIzqIsBad()).withIsLimTiroSupIsBad(this.direccion.isLimTiroSupIsBad()).withIsLimTiroInfIsBad(this.direccion.isLimTiroInfIsBad()).withAlcanceDes(this.datosCalculados.posicionDeseadaMetros.getDistancia()).withAzimutDes(this.datosCalculados.posicionDeseadaMetros.getAzimut()).withOrientacionDes(this.datosCalculados.actitudDeseadaMils.getAzimut()).withElevacionDes(this.datosCalculados.actitudDeseadaMils.getElevacion()).withXStatus(this.getStatus(pointing.isXOk(), pointing.isXMed(), pointing.isXbad())).withYStatus(this.getStatus(pointing.isYOk(), pointing.isYMed(), pointing.isYbad())).build());
    this.getStylesheets().add("/css/variablesDia.css");
  }

  private void pressButtonDisparar() {
    CPA cpa = CPA.getSingletonInstance();
    System.out.println("Doing Shot");
    cpa.disparar();
    System.out.println("Shooted");
  }

  private void actualizaBotonDisparar(CPA cpa) {
    this.ordenadaMaxima.getShotButton().getStyleClass().clear();
    if (cpa.isBtnDisparar()) {
      this.ordenadaMaxima.getShotButton().getStyleClass().add("rojoHabilitado");
    } else {
      if (this.confirmarDisparo.isVisible()) {
        System.out.println("WARNING:: Hiding confirm shoot as is now disabled");
        this.confirmarDisparo.setVisible(false);
      }

      this.ordenadaMaxima.getShotButton().getStyleClass().add("disabled-btn");
    }

  }

  private void pressButtonApuntar() {
    CPA cpa = CPA.getSingletonInstance();
    if (cpa.isBtnApuntar()) {
      cpa.apuntar();
    } else if (cpa.isBtnStop()) {
      cpa.parar();
    } else if (cpa.isBtnSeguir()) {
      cpa.seguir();
    }

  }

  private void actualizaBotonApuntar(CPA cpa) {
    this.ordenadaMaxima.getAimButton().getStyleClass().clear();
    if (cpa.isBtnApuntar()) {
      this.ordenadaMaxima.getAimButton().getStyleClass().add("amarilloHabilitado");
      this.ordenadaMaxima.getAimButton().getButtonLabel().setText(StringUtil.translateKey("button.home.aim"));
    } else if (cpa.isBtnStop()) {
      this.ordenadaMaxima.getAimButton().getStyleClass().add("rojoHabilitado");
      this.ordenadaMaxima.getAimButton().getButtonLabel().setText(StringUtil.translateKey("button.home.stop"));
    } else if (cpa.isBtnSeguir()) {
      this.ordenadaMaxima.getAimButton().getStyleClass().add("amarilloHabilitado");
      this.ordenadaMaxima.getAimButton().getButtonLabel().setText(StringUtil.translateKey("button.home.follow"));
    } else {
      this.ordenadaMaxima.getAimButton().getStyleClass().add("disabled-btn");
    }

  }

  private String getStatus(Boolean isOk, Boolean isMed, Boolean isBad) {
    if (isOk) {
      return "ok";
    } else if (isMed) {
      return "med";
    } else {
      return isBad ? "bad" : "default";
    }
  }

  private void updateColorsAffectedByXStatus(String colorOrientacion) {
    this.setColor(this.orientacionDataViewer.getValueLabel(), colorOrientacion);
    this.setColor(this.azimuthDataViewer.getValueLabel(), colorOrientacion);
  }

  private void updateColorsAffectedByYStatus(String colorElevacion) {
    this.setColor(this.reachClock.getValueLabel(), colorElevacion);
    this.setColor(this.elevationClock.getValueLabel(), colorElevacion);
    this.setColor(this.elevationDataViewer.getValueLabel(), colorElevacion);
    this.setColor(this.reachDataViewer.getValueLabel(), colorElevacion);
  }

  private void setElevationReachStyle(String styleClass) {
    this.elevationClock.getStyleClass().add(styleClass);
    this.reachClock.getStyleClass().add(styleClass);
    this.elevationDataViewer.setStausValue(styleClass);
    this.reachDataViewer.setStausValue(styleClass);
  }

  public void removeStyles(DataViewer toRemove) {
    this.clearStatusStyleClass(toRemove);
    toRemove.getStyleClass().add("defaultData");
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.confirmarDisparo.setConfirm("/images/alert3x.png", "Seguro de hacer captura?", "Captura");
    this.principal = Principal.getSingletonInstance();
    if (Configuracion.getSingletonInstance().getUnidadAngulo().equals(UnidadAngulo.GRADOS)) {
      this.azimuthClock.setClockType("degrees");
      this.elevationClock.setClockType("degrees");
    } else {
      this.azimuthClock.setClockType("mils");
      this.elevationClock.setClockType("mils");
    }

    if (Configuracion.getSingletonInstance().getUnidadDistancia().equals(UnidadDistancia.METROS)) {
      this.reachClock.setClockType("meter");
    } else {
      this.reachClock.setClockType("kilometer");
    }

    this.reachClock.setValue("meter", 0.0);
    Configuracion.getSingletonInstance().getLicencia();
    this.updateComponents();
    this.rightLimit.getLeftLabel().setAlignment(Pos.CENTER_RIGHT);
    this.lefLimit.getRightLabel().setAlignment(Pos.CENTER_LEFT);
    this.confirmarDisparo.getDisparar().setOnMouseClicked((eventoDisparo) -> {
      this.pressButtonDisparar();
    });
    this.ordenadaMaxima.getAimButton().setOnMouseClicked((eventoApuntar) -> {
      this.pressButtonApuntar();
    });
    this.ordenadaMaxima.getShotButton().setOnMouseClicked((event) -> {
      CPA cpa = CPA.getSingletonInstance();
      if (cpa.isBtnDisparar()) {
        this.confirmarDisparo.setLayoutY(-12.0);
        this.confirmarDisparo.setTranslateY(-12.0);
        this.confirmarDisparo.setVisible(true);
      }

    });
    this.graficaDireccion.updateState(GraficaDireccionState.builder().withAzimuth(Angle.ofMillis(3200.0)).withCannonLeftLimit(Angle.ofMillis(0.0)).withCannonRightLimit(Angle.ofMillis(1600.0)).withWeaponLeftLimit(Optional.of(Angle.ofMillis(0.0))).withWeaponRightLimit(Optional.of(Angle.ofMillis(3200.0))).withTrinca(false).withEscalaExterna(Angle.ofMillis(1600.0)).withEscalaInterna(Angle.ofMillis(800.0)).build());
  }

  private void clearStatusStyleClass(Styleable styleable) {
    styleable.getStyleClass().remove("ok");
    styleable.getStyleClass().remove("med");
    styleable.getStyleClass().remove("bad");
    styleable.getStyleClass().remove("okData");
    styleable.getStyleClass().remove("medData");
    styleable.getStyleClass().remove("badData");
  }

  public void setColor(Styleable toChange, String isOk) {
    this.clearStatusStyleClass(toChange);
    if ("ok".equals(isOk)) {
      toChange.getStyleClass().clear();
      toChange.getStyleClass().add(ClockDataStyle.READY.getStyleClass());
    } else if ("med".equals(isOk)) {
      toChange.getStyleClass().clear();
      toChange.getStyleClass().add(ClockDataStyle.WARNING.getStyleClass());
    } else if ("bad".equals(isOk)) {
      toChange.getStyleClass().clear();
      toChange.getStyleClass().add(ClockDataStyle.ERROR.getStyleClass());
    } else {
      toChange.getStyleClass().clear();
      toChange.getStyleClass().add(ClockDataStyle.NEUTRAL.getStyleClass());
    }

  }

  private void paintTrace() {
    ArrayList<Double> targetX = this.principal.trayectoriaDeseada.r;
    ArrayList<Double> targetY = this.principal.trayectoriaDeseada.h;
    ArrayList<Double> shootX = this.principal.trayectoriaApuntada.r;
    ArrayList<Double> shootY = this.principal.trayectoriaApuntada.h;
    if (targetX.size() == targetY.size() && shootX.size() == shootY.size()) {
      if (!this.shoot.getData().isEmpty()) {
        this.shoot.getData().remove(0, this.shoot.getData().size());
      }

      if (!this.target.getData().isEmpty()) {
        this.target.getData().remove(0, this.target.getData().size());
      }

      int i;
      for(i = 0; i < targetX.size(); ++i) {
      }

      this.shoot.getData().removeAll(this.shoot.getData());

      for(i = 0; i < shootX.size(); ++i) {
        this.shoot.getData().add(new XYChart.Data(shootX.get(i), shootY.get(i)));
      }

      if (shootX.size() >= 2) {
        double ordenadaMaxima = this.principal.trayectoriaApuntada.getOrdMax();
        double ordenadaMaximaIzquierdo = (Double)shootX.get(0);
        double ordenadaMaximaDerecho = (Double)shootX.get(shootX.size() - 1);
        this.maxLine.getData().removeAll(this.maxLine.getData());
        this.maxLine.getData().add(new XYChart.Data(ordenadaMaximaIzquierdo, ordenadaMaxima));
        this.maxLine.getData().add(new XYChart.Data(ordenadaMaximaDerecho, ordenadaMaxima));
        double intervaloVertical = 0.0;
        intervaloVertical = DatosCalculados.getSingletonInstance().posicionDeseadaMetros.getIntervalo();
        this.verticalInterval.getData().removeAll(this.verticalInterval.getData());
        if (intervaloVertical != 0.0) {
          double intervaloVerticalIzquierdo = (Double)shootX.get(0);
          double intervaloVerticalDerecho = (Double)shootX.get(shootX.size() - 1);
          this.verticalInterval.getData().add(new XYChart.Data(intervaloVerticalIzquierdo, intervaloVertical));
          this.verticalInterval.getData().add(new XYChart.Data(intervaloVerticalDerecho, intervaloVertical));
        }
      }

    } else {
      Main.getAppController().setInfoMessage("Los datos de trayectoria son asimetricos", "ERROR");
    }
  }
}