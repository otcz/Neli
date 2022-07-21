package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Estadistica;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Statistics extends VBox implements BaseUserInterface, Initializable {
  @FXML
  BarChart<String, Number> barChart0;
  @FXML
  BarChart<String, Number> barChart1;
  @FXML
  TextField efcTextField;
  private XYChart.Series series0 = new XYChart.Series();
  private XYChart.Series series1 = new XYChart.Series();
  private int carga1 = 0;
  private int carga2 = 0;
  private int carga3 = 0;
  private int carga4 = 0;
  private int carga5 = 0;
  private int carga6 = 0;
  private int carga7 = 0;
  private int rango1 = 0;
  private int rango2 = 0;
  private double efc = 0.0;
  private Estadistica estadistica = new Estadistica();

  public Statistics() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/config_statistics.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
    this.estadistica.leerEstadistica();
    this.carga1 = this.estadistica.getObjdatosEstadistica().getCarga1();
    this.carga2 = this.estadistica.getObjdatosEstadistica().getCarga2();
    this.carga3 = this.estadistica.getObjdatosEstadistica().getCarga3();
    this.carga4 = this.estadistica.getObjdatosEstadistica().getCarga4();
    this.carga5 = this.estadistica.getObjdatosEstadistica().getCarga5();
    this.carga6 = this.estadistica.getObjdatosEstadistica().getCarga6();
    this.carga7 = this.estadistica.getObjdatosEstadistica().getCarga7();
    this.rango1 = this.estadistica.getObjdatosEstadistica().getRango1();
    this.rango2 = this.estadistica.getObjdatosEstadistica().getRango2();
    this.efc = this.estadistica.getObjdatosEstadistica().getEfc();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.barChart0.setLegendVisible(false);
    this.barChart0.getYAxis().setLabel("Número de Tiros");
    this.addSerie(this.series0, "1", this.carga1);
    this.addSerie(this.series0, "2", this.carga2);
    this.addSerie(this.series0, "3", this.carga3);
    this.addSerie(this.series0, "4", this.carga4);
    this.addSerie(this.series0, "5", this.carga5);
    this.addSerie(this.series0, "6", this.carga6);
    this.addSerie(this.series0, "7", this.carga7);
    this.barChart0.getData().add(this.series0);
    this.barChart1.setLegendVisible(false);
    this.barChart1.getYAxis().setLabel("Número de Tiros");
    this.addSerie(this.series1, "1", this.rango1);
    this.addSerie(this.series1, "2", this.rango2);
    this.barChart1.getData().add(this.series1);
    this.efcTextField.setText(String.valueOf(this.efc));
  }

  public void addSerie(XYChart.Series serie, String name, Number value) {
    final XYChart.Data<String, Number> data = new XYChart.Data("Carga " + name, value);
    data.nodeProperty().addListener(new ChangeListener<Node>() {
      public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node node) {
        if (node != null) {
          Statistics.this.displayLabelForData(data);
        }

      }
    });
    serie.getData().add(data);
  }

  private void displayLabelForData(XYChart.Data<String, Number> data) {
    Node node = data.getNode();
    final Text dataText = new Text(data.getYValue() + "");
    dataText.getStyleClass().add("value");
    node.parentProperty().addListener(new ChangeListener<Parent>() {
      public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
        Group parentGroup = (Group)parent;
        parentGroup.getChildren().add(dataText);
      }
    });
    node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
      public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
        dataText.setLayoutX((double)Math.round(bounds.getMinX() + bounds.getWidth() / 2.0 - dataText.prefWidth(-1.0) / 2.0));
        dataText.setLayoutY((double)Math.round(bounds.getMinY() - dataText.prefHeight(-1.0) * 0.5));
      }
    });
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Statistics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */