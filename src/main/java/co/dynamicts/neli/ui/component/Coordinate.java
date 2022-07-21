package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.core.models.Point;
import co.dynamicts.neli.core.stauts.StatusCoordinates;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DecimalFormat;

public class Coordinate extends VBox {
  private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
  
  @FXML
  private Label title;
  
  @FXML
  private Label longitudeWE;
  
  @FXML
  private Label longitudeGrades;
  
  @FXML
  private Label longitudeMinutes;
  
  @FXML
  private Label longitudeSeconds;
  
  @FXML
  private Label latitudeNS;
  
  @FXML
  private Label latitudeGrades;
  
  @FXML
  private Label latitudeMinutes;
  
  @FXML
  private Label latitudeSeconds;
  
  @FXML
  private Label height;
  
  @FXML
  public GridPane gridPane;
  
  @FXML
  private String innerBoxStyleClass;
  
  private Point point;
  
  public void setInnerBoxStyleClass(String innerBoxStyleClass) {
    this.innerBoxStyleClass = innerBoxStyleClass;
    this.gridPane.getStyleClass().add(innerBoxStyleClass);
  }
  
  public String getInnerBoxStyleClass() {
    return this.innerBoxStyleClass;
  }
  
  public Coordinate() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/coordinate.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public void initialize() {}
  
  public void setText(String text) {
    this.title.setText(text);
  }
  
  public String getText() {
    return this.title.getText();
  }
  
  public void setStatus(StatusCoordinates point) {
    this.longitudeGrades.setText("" + Math.abs(point.getLongitudGrados().intValue()) + "˚");
    this.longitudeMinutes.setText("" + Math.abs(point.getLongitudMinutos().intValue()) + "'");
    this.longitudeSeconds.setText("" + DataTools.limitaDecimales(point.getLongitudSegundos().doubleValue()) + "\"");
    this.longitudeWE.setText(point.getCardinalidadLongitud());
    this.latitudeNS.setText(point.getCardinalidadLatitud());
    this.latitudeGrades.setText("" + Math.abs(point.getLatitudGrados().intValue()) + "˚");
    this.latitudeMinutes.setText("" + Math.abs(point.getLatitudMinutos().intValue()) + "'");
    this.latitudeSeconds.setText("" + DataTools.limitaDecimales(point.getLatitudSegundos().doubleValue()) + "\"");
    this.height.setText("" + Math.abs(point.getMetros().doubleValue()));
  }
  
  public void setPoint(Point point) {
    this.point = point;
    this.longitudeWE.setText(point.getLongitude().getHemisphere());
    this.longitudeGrades.setText("" + point.getLongitude().getDegrees() + "˚");
    this.longitudeMinutes.setText("" + point.getLongitude().getMinutes() + "'");
    this.longitudeSeconds.setText("" + Math.abs(DataTools.limitaDecimales(point.getLongitude().getSeconds())) + "\"");
    this.latitudeNS.setText(point.getLatitude().getHemisphere());
    this.latitudeGrades.setText("" + point.getLatitude().getDegrees() + "˚");
    this.latitudeMinutes.setText("" + point.getLatitude().getMinutes() + "'");
    this.latitudeSeconds.setText("" + Math.abs(DataTools.limitaDecimales(point.getLatitude().getSeconds())) + "\"");
    this.height.setText("" + point.getHeight());
  }
  
  public void setPoint(PuntoGeograficas point) {
    this.longitudeWE.setText(point.getSignoLongitud());
    this.latitudeGrades.setText("" + Math.abs((int)point.getLatGrados()) + "˚");
    this.latitudeMinutes.setText("" + Math.abs((int)point.getLatMinutos()) + "'");
    this.latitudeSeconds.setText("" + Math.abs(DataTools.limitaDecimales(point.getLatSegundos())) + "\"");
    this.latitudeNS.setText(point.getSignoLatitud());
    this.longitudeGrades.setText("" + Math.abs((int)point.getLonGrados()) + "˚");
    this.longitudeMinutes.setText("" + Math.abs((int)point.getLonMinutos()) + "'");
    this.longitudeSeconds.setText("" + Math.abs(DataTools.limitaDecimales(point.getLonSegundos())) + "\"");
    this.height.setText("" + (int)point.getAltura());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\Coordinate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */