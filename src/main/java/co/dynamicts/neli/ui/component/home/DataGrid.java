package co.dynamicts.neli.ui.component.home;

import co.dynamicts.neli.core.stauts.StatusDataGrid;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DataGrid extends GridPane {
  private static final DecimalFormatSymbols DECIMAL_SEPARATOR = DecimalFormatSymbols.getInstance();
  
  static {
    DECIMAL_SEPARATOR.setDecimalSeparator('.');
  }
  
  private static final DecimalFormat FORMAT_TWO_INTS = new DecimalFormat("###");
  
  private static final DecimalFormat FORMAT_S = new DecimalFormat("######.## s", DECIMAL_SEPARATOR);
  
  private static final DecimalFormat FORMAT_MS = new DecimalFormat("######.##m/s", DECIMAL_SEPARATOR);
  
  private static final DecimalFormat FORMAT_POSITIVE_DEGREES = new DecimalFormat("+ ####.## C°", DECIMAL_SEPARATOR);
  
  private static final DecimalFormat FORMAT_M = new DecimalFormat("######.## m", DECIMAL_SEPARATOR);
  
  private static final DecimalFormat FORMAT_MM = new DecimalFormat("######.## ₥", DECIMAL_SEPARATOR);
  
  private static final DecimalFormat FORMAT_INEXACT_M = new DecimalFormat("+/- ######.## m", DECIMAL_SEPARATOR);
  
  @FXML
  GridPane pane;
  
  @FXML
  private IconDataField cuadros;
  
  @FXML
  private IconDataField load;
  
  @FXML
  private IconDataField gunFuse;
  
  @FXML
  private IconDataField muzzleVelocity;
  
  @FXML
  private IconDataField propellantTemperature;
  
  @FXML
  private IconDataField drift;
  
  @FXML
  private IconDataField verticalInterval;
  
  @FXML
  private IconDataField totalDeflectionCorrection;
  
  @FXML
  private IconDataField explosionHeight;
  
  @FXML
  private IconDataField magneticOrientation;
  
  @FXML
  private DataField flightTime;
  
  @FXML
  private DataField accuracyDistanceError;
  
  @FXML
  private DataField accuracyOrientationError;
  
  @FXML
  private DataField pmiDistanceError;
  
  @FXML
  private DataField pmiOrientationError;
  
  public DataGrid() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/data_grid.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      var3.printStackTrace();
    } 
  }
  
  @FXML
  private void initialize() {
    StatusDataGrid statusDataGrid = StatusDataGrid.builder().withTipoMunicion(" ").withCuadros(Integer.valueOf(0)).withCarga(" ").withZona(Integer.valueOf(0)).withEspoleta(" ").withGraduacion(Double.valueOf(0.0D)).withVelocidadEnBoca(Double.valueOf(0.0D)).withTemperaturaPropelente(Double.valueOf(0.0D)).withDrift(Double.valueOf(0.0D)).withIntervaloVertical(Double.valueOf(1111.0D)).withCorreccionTotalDeflexion(Double.valueOf(0.0D)).withAlturaExplosion(Double.valueOf(0.0D)).withOrientacionMagnetica(Double.valueOf(0.0D)).withTiempoDeVuelo(Double.valueOf(0.0D)).withErrorPrecisionDistancia(Double.valueOf(0.0D)).withErrorPresicionOrient(Double.valueOf(0.0D)).withErrorPMIDistancia(Double.valueOf(0.0D)).withErrprPMIOrientacion(Double.valueOf(0.0D)).build();
    updateState(statusDataGrid);
  }
  
  public void updateState(StatusDataGrid statusDataGrid) {
    this.cuadros.setTitleText(statusDataGrid.getTipoMunicion());
    this.cuadros.setMeasureText(FORMAT_TWO_INTS.format(statusDataGrid.getCuadros()));
    this.load.setTitleText("Carga " + statusDataGrid.getCarga());
    this.load.setMeasureText(FORMAT_TWO_INTS.format(statusDataGrid.getZona()));
    this.gunFuse.setTitleText("Espoleta " + statusDataGrid.getEspoleta());
    this.gunFuse.setMeasureText(FORMAT_S.format(statusDataGrid.getGraduacion()));
    this.muzzleVelocity.setMeasureText(FORMAT_MS.format(statusDataGrid.getVelocidadEnBoca()));
    this.propellantTemperature.setMeasureText(FORMAT_POSITIVE_DEGREES.format(statusDataGrid.getTemperaturaPropelente()));
    this.drift.setMeasureText(FORMAT_MM.format(statusDataGrid.getDrift()));
    this.verticalInterval.setMeasureText(FORMAT_M.format(statusDataGrid.getIntervaloVertical()));
    this.totalDeflectionCorrection.setMeasureText(FORMAT_MM.format(statusDataGrid.getCorreccionTotalDeflexion()));
    this.explosionHeight.setMeasureText(FORMAT_M.format(statusDataGrid.getAlturaExplosion()));
    this.magneticOrientation.setMeasureText(FORMAT_MM.format(statusDataGrid.getOrientacionMagnetica()));
    this.flightTime.setMeasureText(FORMAT_S.format(statusDataGrid.getTiempoDeVuelo()));
    this.accuracyDistanceError.setMeasureText(FORMAT_INEXACT_M.format(statusDataGrid.getErrorPrecisionDistancia()));
    this.accuracyOrientationError.setMeasureText(FORMAT_INEXACT_M.format(statusDataGrid.getErrorPresicionOrient()));
    this.pmiDistanceError.setMeasureText(FORMAT_INEXACT_M.format(statusDataGrid.getErrorPMIDistancia()));
    this.pmiOrientationError.setMeasureText(FORMAT_INEXACT_M.format(statusDataGrid.getErrprPMIOrientacion()));
  }
  
  public IconDataField getCuadros() {
    return this.cuadros;
  }
  
  public void setCuadros(IconDataField cuadros) {
    this.cuadros = cuadros;
  }
  
  public IconDataField getLoad() {
    return this.load;
  }
  
  public void setLoad(IconDataField load) {
    this.load = load;
  }
  
  public IconDataField getGunFuse() {
    return this.gunFuse;
  }
  
  public void setGunFuse(IconDataField gunFuse) {
    this.gunFuse = gunFuse;
  }
  
  public IconDataField getMuzzleVelocity() {
    return this.muzzleVelocity;
  }
  
  public void setMuzzleVelocity(IconDataField muzzleVelocity) {
    this.muzzleVelocity = muzzleVelocity;
  }
  
  public IconDataField getTemperaturaPropelente() {
    return this.propellantTemperature;
  }
  
  public void setTemperaturaPropelente(IconDataField temperaturePropelente) {
    this.propellantTemperature = temperaturePropelente;
  }
  
  public IconDataField getDrift() {
    return this.drift;
  }
  
  public void setDrift(IconDataField drift) {
    this.drift = drift;
  }
  
  public IconDataField getVerticalInterval() {
    return this.verticalInterval;
  }
  
  public void setVerticalInterval(IconDataField verticalInterval) {
    this.verticalInterval = verticalInterval;
  }
  
  public IconDataField getTotalDeflectionCorrection() {
    return this.totalDeflectionCorrection;
  }
  
  public void setTotalDeflectionCorrection(IconDataField totalDeflectionCorrection) {
    this.totalDeflectionCorrection = totalDeflectionCorrection;
  }
  
  public IconDataField getAlturaExplosion() {
    return this.explosionHeight;
  }
  
  public void setAlturaExplosion(IconDataField explosionHeight) {
    this.explosionHeight = explosionHeight;
  }
  
  public IconDataField getMagneticOrientation() {
    return this.magneticOrientation;
  }
  
  public void setMagneticOrientation(IconDataField magneticOrientation) {
    this.magneticOrientation = magneticOrientation;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\DataGrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */