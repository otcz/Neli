package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Direccion;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraphsTrajectory extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private LineChart<Number, Number> lineChart;
  private XYChart.Series shoot = new XYChart.Series();
  private XYChart.Series target = new XYChart.Series();
  private XYChart.Series maxLine = new XYChart.Series();
  private XYChart.Series verticalInterval = new XYChart.Series();
  private Direccion direccion = Direccion.getSingletonInstance();
  private Configuracion configuracion;
  DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
  DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
  Ins ins = Ins.getSingletonInstance();

  public GraphsTrajectory() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/graphs_trajectory.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().updateComponents();
    this.paintTrace();
  }

  private void paintTrace() {
    try {
      ArrayList<Double> rShoot = new ArrayList();
      ArrayList<Double> hShoot = new ArrayList();

      for(int i = 0; i <= this.datosApuntados.trayectoriaApuntada.r.size() - 21; i += 20) {
        rShoot.add(this.datosApuntados.trayectoriaApuntada.r.get(i));
        hShoot.add((Double)this.datosApuntados.trayectoriaApuntada.h.get(i) - this.ins.obus.getAltura());
      }

      ArrayList<Double> shootX = rShoot;
      ArrayList<Double> shootY = hShoot;
      ArrayList<Double> rTarget = new ArrayList();
      ArrayList<Double> hTarget = new ArrayList();

      for(int i = 0; i <= this.datosCalculados.trayectoriaDeseada.r.size() - 21; i += 20) {
        rTarget.add(this.datosCalculados.trayectoriaDeseada.r.get(i));
        hTarget.add((Double)this.datosCalculados.trayectoriaDeseada.h.get(i) - this.ins.obus.getAltura());
      }

      ArrayList<Double> targetX = rTarget;
      ArrayList<Double> targetY = hTarget;
      if (rTarget.size() != hTarget.size() || rShoot.size() != hShoot.size()) {
        Main.getAppController().setInfoMessage(StringUtil.translateKey("status.path"), "ERROR");
        return;
      }

      if (this.lineChart.getData().size() == 0) {
        this.shoot.setName("Shoot");
        this.target.setName("Target");
        this.maxLine.setName("Ordenada Maxima");
        this.verticalInterval.setName("Intervalo vertical");
        this.lineChart.getData().add(this.target);
        this.lineChart.getData().add(this.shoot);
        this.lineChart.getData().add(this.maxLine);
        this.lineChart.getData().add(this.verticalInterval);
      }

      if (!this.shoot.getData().isEmpty()) {
        this.shoot.getData().remove(0, this.shoot.getData().size());
      }

      if (!this.target.getData().isEmpty()) {
        this.target.getData().remove(0, this.target.getData().size());
      }

      this.target.getData().removeAll(this.target.getData());

      int i;
      for(i = 0; i < targetX.size(); ++i) {
        this.target.getData().add(new XYChart.Data(targetX.get(i), targetY.get(i)));
      }

      this.shoot.getData().removeAll(this.shoot.getData());

      for(i = 0; i < shootX.size(); ++i) {
        this.shoot.getData().add(new XYChart.Data(shootX.get(i), shootY.get(i)));
      }

      if (shootX.size() >= 2) {
        double ordenadaMaxima = this.datosApuntados.trayectoriaApuntada.getOrdMax() - this.ins.obus.getAltura();
        double ordenadaMaximaIzquierdo = (Double)shootX.get(0);
        double ordenadaMaximaDerecho = (Double)shootX.get(shootX.size() - 1);
        this.maxLine.getData().removeAll(this.maxLine.getData());
        this.maxLine.getData().add(new XYChart.Data(ordenadaMaximaIzquierdo, ordenadaMaxima));
        this.maxLine.getData().add(new XYChart.Data(ordenadaMaximaDerecho, ordenadaMaxima));
        double intervaloVertical = this.datosCalculados.posicionDeseadaMetros.getIntervalo();
        this.verticalInterval.getData().removeAll(this.verticalInterval.getData());
        if (intervaloVertical != 0.0) {
          double intervaloVerticalIzquierdo = (Double)shootX.get(0);
          double intervaloVerticalDerecho = (Double)shootX.get(shootX.size() - 1);
          this.verticalInterval.getData().add(new XYChart.Data(intervaloVerticalIzquierdo, intervaloVertical));
          this.verticalInterval.getData().add(new XYChart.Data(intervaloVerticalDerecho, intervaloVertical));
        }
      }
    } catch (Exception var21) {
      System.out.println("Error en grafica de trayectoria");
    }

  }

  public void initialize(URL location, ResourceBundle resources) {
    this.configuracion = Configuracion.getSingletonInstance();
    this.updateComponents();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\GraphsTrajectory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */