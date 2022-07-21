package co.dynamicts.neli.ui.component.cms;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.FuncionesCPA;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.stauts.StatusCMS;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import co.dynamicts.neli.ui.component.common.LabelTitle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CMSComponent extends VBox {
  @FXML
  private LineChart<String, Number> lineChart;
  @FXML
  private CategoryAxis xAxis;
  @FXML
  private NumberAxis yAxis;
  @FXML
  private LabelTitle tubeTemperature;
  @FXML
  private LabelTitle maxRecoil;
  @FXML
  private LabelTitle muzzleVelocity;
  @FXML
  private LabelTitle tempCut;
  @FXML
  private LabelTitle mctTubeTemperature;
  @FXML
  private LabelTitle lastShotEfc;
  @FXML
  private LabelTitle shotAction;
  @FXML
  private LabelTitle totalEFC;
  @FXML
  private LabelTitle recoilDistance;
  @FXML
  private LabelTitle maxEfc;
  @FXML
  private LabelTitle tubeTotalShot;
  @FXML
  private ButtonImage changeTube;
  private StatusCMS cmsStatus;

  public CMSComponent() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/components/cms/content_cms.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      var3.printStackTrace();
    }

    this.setButtonChangeTube();
  }

  @FXML
  public void initialize() {
    XYChart.Series series = new XYChart.Series();
    this.cmsStatus = new StatusCMS();
    this.setTitles();
    this.setValues();
    this.setDataSeries(series);
    this.lineChart.getData().add(series);
  }

  private void setDataSeries(XYChart.Series series) {
    this.cmsStatus.getChartValues().entrySet().forEach((entry) -> {
      series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
    });
  }

  private void setValues() {
    CPA cpa = CPA.getSingletonInstance();
    FuncionesCPA var10001 = cpa.funcionesCPA;
    this.tubeTemperature.setMeasureLabelCMS((double)FuncionesCPA.CMS_TempTubo);
    var10001 = cpa.funcionesCPA;
    this.mctTubeTemperature.setMeasureLabelCMS((double)FuncionesCPA.CMS_TempIncrTubo);
    var10001 = cpa.funcionesCPA;
    this.maxRecoil.setMeasureLabelCMS((double)FuncionesCPA.CMS_MaxiRetroceso);
    var10001 = cpa.funcionesCPA;
    this.muzzleVelocity.setMeasureLabelCMS((double)FuncionesCPA.CMS_DispAccion);
    var10001 = cpa.funcionesCPA;
    this.tempCut.setMeasureLabelCMS((double)FuncionesCPA.CMS_TempCorte);
    var10001 = cpa.funcionesCPA;
    this.lastShotEfc.setMeasureLabelCMS((double)FuncionesCPA.CMS_EFCUltimoDisparo);
    var10001 = cpa.funcionesCPA;
    this.shotAction.setMeasureLabelCMS((double)FuncionesCPA.CMS_EFCAccion);
    var10001 = cpa.funcionesCPA;
    this.totalEFC.setMeasureLabelCMS((double)FuncionesCPA.CMS_EFCTotal);
    var10001 = cpa.funcionesCPA;
    this.recoilDistance.setMeasureLabelCMS((double)FuncionesCPA.CMS_DistanRetroceso);
    var10001 = cpa.funcionesCPA;
    this.maxEfc.setMeasureLabelCMS((double)FuncionesCPA.CMS_MaximoEFC);
    var10001 = cpa.funcionesCPA;
    this.tubeTotalShot.setMeasureLabelCMS((double)FuncionesCPA.CMS_DispTotalTubo);
  }

  private void setTitles() {
    this.mctTubeTemperature.setTitleLabelCMS("Temperatura Inc. Tubo");
    this.tubeTemperature.setTitleLabelCMS("Temperatura Tubo");
    this.maxRecoil.setTitleLabelCMS("Máximo Retroceso");
    this.muzzleVelocity.setTitleLabelCMS("Velocidad Boca");
    this.tempCut.setTitleLabelCMS("Temp. Corte");
    this.lastShotEfc.setTitleLabelCMS("EFC Último Disparo");
    this.shotAction.setTitleLabelCMS("Disp Acción");
    this.totalEFC.setTitleLabelCMS("EFC Total");
    this.recoilDistance.setTitleLabelCMS("Distancia Retroceso");
    this.maxEfc.setTitleLabelCMS("Máximo EFC");
    this.tubeTotalShot.setTitleLabelCMS("Disp Total Tubo");
    this.changeTube.setLabel("Cambio Tubo");
  }

  public ButtonImage getChangeTube() {
    return this.changeTube;
  }

  public void setChangeTube(ButtonImage changeTube) {
    this.changeTube = changeTube;
  }

  public CategoryAxis getxAxis() {
    return this.xAxis;
  }

  public void setxAxis(CategoryAxis xAxis) {
    this.xAxis = xAxis;
  }

  public NumberAxis getyAxis() {
    return this.yAxis;
  }

  public void setyAxis(NumberAxis yAxis) {
    this.yAxis = yAxis;
  }

  public LabelTitle getTemperaturaTubo() {
    return this.tubeTemperature;
  }

  public void setTemperaturaTubo(LabelTitle temperatureTubo) {
    this.tubeTemperature = temperatureTubo;
  }

  public LabelTitle getMaxRecoil() {
    return this.maxRecoil;
  }

  public void setMaxRecoil(LabelTitle maxRecoil) {
    this.maxRecoil = maxRecoil;
  }

  public LabelTitle getMuzzleVelocity() {
    return this.muzzleVelocity;
  }

  public void setMuzzleVelocity(LabelTitle muzzleVelocity) {
    this.muzzleVelocity = muzzleVelocity;
  }

  public LabelTitle getTempCut() {
    return this.tempCut;
  }

  public void setTempCut(LabelTitle tempCut) {
    this.tempCut = tempCut;
  }

  public LabelTitle getTemperaturaMCTubo() {
    return this.mctTubeTemperature;
  }

  public void setTemperaturaMCTubo(LabelTitle temperatureMCTubo) {
    this.mctTubeTemperature = temperatureMCTubo;
  }

  public LabelTitle getLastShotEfc() {
    return this.lastShotEfc;
  }

  public void setLastShotEfc(LabelTitle lastShotEfc) {
    this.lastShotEfc = lastShotEfc;
  }

  public LabelTitle getShotAction() {
    return this.shotAction;
  }

  public void setShotAction(LabelTitle shotAction) {
    this.shotAction = shotAction;
  }

  public LabelTitle getTotalEFC() {
    return this.totalEFC;
  }

  public void setTotalEFC(LabelTitle totalEFC) {
    this.totalEFC = totalEFC;
  }

  public LabelTitle getRecoilDistance() {
    return this.recoilDistance;
  }

  public void setRecoilDistance(LabelTitle recoilDistance) {
    this.recoilDistance = recoilDistance;
  }

  public LabelTitle getMaxEfc() {
    return this.maxEfc;
  }

  public void setMaxEfc(LabelTitle maxEfc) {
    this.maxEfc = maxEfc;
  }

  public LabelTitle getTubeTotalShot() {
    return this.tubeTotalShot;
  }

  public void setTubeTotalShot(LabelTitle tubeTotalShot) {
    this.tubeTotalShot = tubeTotalShot;
  }

  public LineChart getLineChart() {
    return this.lineChart;
  }

  public void setLineChart(LineChart lineChart) {
    this.lineChart = lineChart;
  }

  private void setButtonChangeTube() {
    this.changeTube.setOnAction((event) -> {
      if (Main.getAppController().setPasswordDialog()) {
        System.out.println("Change Button clicked!");
      }

    });
  }
}