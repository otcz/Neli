package co.dynamicts.neli.ui.component.home.top.menu;

import co.dynamicts.neli.core.ObusHW.*;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.ui.component.home.state.TopMenuState;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class TopMenu extends HBox implements BaseUserInterface {
  @FXML
  private TopMenuItem temperature;
  
  @FXML
  private TopMenuItem calibration;
  
  @FXML
  private TopMenuItem trinca;
  
  @FXML
  private TopMenuItem tray;
  
  @FXML
  private TopMenuItem ammunition;
  
  @FXML
  private TopMenuItem zupt;
  
  @FXML
  private TopMenuItem cms;
  
  @FXML
  private TopMenuItem hms;
  
  @FXML
  private TopMenuItem odometer;
  
  @FXML
  private TopMenuItem radar;
  
  @FXML
  private TopMenuItem aim;
  
  @FXML
  private TopMenuItem gps;
  
  @FXML
  private TopMenuItem ins;
  
  private FXMLLoader fxmlLoader;
  
  private Principal principal;
  
  private Configuracion configuracion;
  
  public TopMenu() {
    this.fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/top_menu/top_menu.fxml"));
    this.fxmlLoader.setRoot(this);
    this.fxmlLoader.setController(this);
    this.fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      this.fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  @FXML
  private void initialize() {
    this.principal = Principal.getSingletonInstance();
    this.configuracion = Configuracion.getSingletonInstance();
    initComponent();
  }
  
  public TopMenuItem getTemperatura() {
    return this.temperature;
  }
  
  public void setTemperatura(TopMenuItem temperature) {
    this.temperature = temperature;
  }
  
  public TopMenuItem getCalibration() {
    return this.calibration;
  }
  
  public void setCalibration(TopMenuItem calibration) {
    this.calibration = calibration;
  }
  
  public TopMenuItem getTrinca() {
    return this.trinca;
  }
  
  public void setTrinca(TopMenuItem trinca) {
    this.trinca = trinca;
  }
  
  public TopMenuItem getTray() {
    return this.tray;
  }
  
  public void setTray(TopMenuItem tray) {
    this.tray = tray;
  }
  
  public TopMenuItem getAmmunition() {
    return this.ammunition;
  }
  
  public void setAmmunition(TopMenuItem ammunition) {
    this.ammunition = ammunition;
  }
  
  public TopMenuItem getZupt() {
    return this.zupt;
  }
  
  public void setZupt(TopMenuItem zupt) {
    this.zupt = zupt;
  }
  
  public TopMenuItem getCms() {
    return this.cms;
  }
  
  public void setCms(TopMenuItem cms) {
    this.cms = cms;
  }
  
  public TopMenuItem getHms() {
    return this.hms;
  }
  
  public void setHms(TopMenuItem hms) {
    this.hms = hms;
  }
  
  public TopMenuItem getOdometer() {
    return this.odometer;
  }
  
  public void setOdometer(TopMenuItem odometer) {
    this.odometer = odometer;
  }
  
  public TopMenuItem getRadar() {
    return this.radar;
  }
  
  public void setRadar(TopMenuItem radar) {
    this.radar = radar;
  }
  
  public TopMenuItem getAim() {
    return this.aim;
  }
  
  public void setAim(TopMenuItem aim) {
    this.aim = aim;
  }
  
  public TopMenuItem getGps() {
    return this.gps;
  }
  
  public void setGps(TopMenuItem gps) {
    this.gps = gps;
  }
  
  public TopMenuItem getIns() {
    return this.ins;
  }
  
  public void setIns(TopMenuItem ins) {
    this.ins = ins;
  }
  
  public void updateState(TopMenuState state) {
    this.temperature.setTwoOptionStatus(state.getTemperatura());
    this.calibration.setTwoOptionStatus(state.getCalibracion());
    this.trinca.setStatus(state.getTrinca());
    this.tray.getText().setText(state.getStatusBandeja().getLabel());
    this.tray.setIconPath(state.getStatusBandeja().getSvgPath());
    this.tray.setStatus(state.getStatusBandeja().getStatus());
    this.ammunition.setValue(String.valueOf(state.getMunicion()));
    this.zupt.setStatus(state.getZupt());
    this.cms.setStatus(state.getCms());
    this.hms.setStatus(state.getHms());
    this.odometer.setStatus(state.getOdometro());
    this.radar.setStatus(state.getRadar());
    this.aim.setStatus(state.getPunteria());
    this.gps.setStatus(state.getGps());
    this.ins.setStatus(state.getIns());
  }
  
  public void updateComponents() {
    CMS cmsData = CMS.getSingletonInstance();
    CPA cpa = CPA.getSingletonInstance();
    Trinca trincaData = Trinca.getSingletonInstance();
    Ins ins = Ins.getSingletonInstance();
    MuzzleRadar muzzleRadar = MuzzleRadar.getSingletonInstance();
    ItemStatus insStatus = null;
    ItemStatus gpsStatus = null;
    if (ins.estadoINS == Ins.EstadoINS.DISCONNECTED) {
      insStatus = ItemStatus.BAD;
    } else if (ins.estadoINS == Ins.EstadoINS.CONNECTED_DISALIGMENT) {
      insStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoINS == Ins.EstadoINS.CONNECTED_OK) {
      insStatus = ItemStatus.OK;
    } 
    if (ins.estadoGPS == Ins.EstadoGPS.DISCONNECTED) {
      gpsStatus = ItemStatus.BAD;
    } else if (ins.estadoGPS == Ins.EstadoGPS.CONNECTED_MEDIUM) {
      gpsStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoGPS == Ins.EstadoGPS.CONNECTED_OK) {
      gpsStatus = ItemStatus.OK;
    } 
    updateState(
        
        TopMenuState.builder()
        .withTemperatura(ItemStatus.values()[cmsData.getTemCanonState()])
        .withCalibracion(ItemStatus.values()[cpa.getIsCalibrated()])
        .withTrinca(trincaData.isTrincaPut() ? ItemStatus.BAD : ItemStatus.OK)
        .withStatusBandeja(BandejaItemStatus.values()[cpa.getHMS()])
        .withBandeja(ItemStatus.values()[cpa.getHMS()])
        .withMunicion(Integer.valueOf(this.configuracion.municion.getCantidad()))
        .withZupt(ins.isZuptTiro() ? ItemStatus.OK : ItemStatus.BAD)
        .withCms(cmsData.isCMS() ? ItemStatus.OK : ItemStatus.BAD)
        .withHms(cpa.isHMS() ? ItemStatus.OK : ItemStatus.BAD)
        .withOdometro(ins.isOdo() ? ItemStatus.OK : ItemStatus.BAD)
        .withRadar(muzzleRadar.isRadarOk() ? ItemStatus.OK : ItemStatus.BAD)
        .withPunteria(cpa.isCPA() ? ItemStatus.OK : ItemStatus.BAD)
        .withGps(gpsStatus)
        .withIns(insStatus)
        .build());
  }
  
  public void initComponent() {
    if (this.configuracion.getSistema().equals(Configuracion.Sistema.OBUS_105_LG) || this.configuracion
      .getSistema().equals(Configuracion.Sistema.OBUS_105_L119)) {
      this.temperature.setVisible(false);
      this.calibration.setVisible(false);
      this.trinca.setVisible(false);
      this.tray.setVisible(false);
      this.cms.setVisible(false);
      this.hms.setVisible(false);
      this.aim.setVisible(false);
      this.radar.setVisible(false);
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
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\top\menu\TopMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */