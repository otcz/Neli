package co.dynamicts.neli.ui.component.home;

import co.dynamicts.neli.core.ObusHW.Trinca;
import co.dynamicts.neli.core.angle.Angle;
import co.dynamicts.neli.ui.component.home.state.GraficaDireccionState;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;

import java.io.IOException;

public class GraficaDireccion extends VBox {
  @FXML
  private ImageView compass;
  
  @FXML
  private ImageView trinca;
  
  @FXML
  private ImageView sinTrinca;
  
  @FXML
  private Label labelEnTrinca;
  
  @FXML
  private ImageView azimuth;
  
  @FXML
  private ImageView vehicle;
  
  @FXML
  private Arc weaponArc;
  
  @FXML
  private Arc cannonArc;
  
  @FXML
  private StackPane canon;
  
  @FXML
  private StackPane componentWrapper;
  
  @FXML
  private AnchorPane arcPane;
  
  public GraficaDireccion() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/direction_graph.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  @FXML
  private void initialize() {
    updateArc(this.weaponArc, Angle.ofMillis(Double.valueOf(711.1111111111111D)), Angle.ofMillis(Double.valueOf(5688.888888888889D)));
    updateArc(this.cannonArc, Angle.ofMillis(Double.valueOf(200.0D)), Angle.ofMillis(Double.valueOf(6200.0D)));
    actualizarEstadoEnTrinca();
    Angle exampleTurn = Angle.ofDegrees(Double.valueOf(180.0D));
    canonTurn(exampleTurn);
    compassTurn(Angle.ofDegrees(Double.valueOf(0.0D)));
  }
  
  private void azimuthOrientation(Angle azimuthAngle) {
    double azimuthSize = this.azimuth.getFitWidth() / 4.0D;
    double radio = this.compass.getFitWidth() / 2.0D;
    double radioX = 95.0D;
    double coordX = radio * Math.cos(Math.toRadians(azimuthAngle.getDegrees().doubleValue() - 90.0D)) + radioX;
    double coordY = radio * Math.sin(Math.toRadians(azimuthAngle.getDegrees().doubleValue() - 90.0D)) + radio - 2.5D;
    this.azimuth.setLayoutX(coordX);
    this.azimuth.setLayoutY(coordY);
    this.azimuth.setRotate(azimuthAngle.getDegrees().doubleValue());
  }
  
  private void compassTurn(Angle turnAngle) {
    this.componentWrapper.setRotate(turnAngle.getDegrees().doubleValue());
    this.arcPane.setRotate(turnAngle.getDegrees().doubleValue());
    setAzimuthAngle(Angle.ofDegrees(Double.valueOf(this.azimuth.getRotate() + turnAngle.getDegrees().doubleValue())));
    canonTurn(Angle.ofDegrees(Double.valueOf(this.canon.getRotate() + turnAngle.getDegrees().doubleValue())));
  }
  
  private void canonTurn(Angle turnAngle) {
    this.canon.setRotate(turnAngle.getDegrees().doubleValue());
  }
  
  private void setAzimuthAngle(Angle azimuthAngle) {
    azimuthOrientation(azimuthAngle);
  }
  
  private void actualizarEstadoEnTrinca() {
    Trinca trincaBack = Trinca.getSingletonInstance();
    if (trincaBack.isTrincaPut()) {
      this.labelEnTrinca.setVisible(true);
      this.labelEnTrinca.setText("En Trinca");
      this.trinca.setVisible(true);
      this.sinTrinca.setVisible(false);
      if (trincaBack.isTrincaForzada()) {
        this.labelEnTrinca.setVisible(true);
        this.labelEnTrinca.setText("Trinca Forzada");
        this.trinca.setVisible(true);
        this.sinTrinca.setVisible(false);
      } 
    } else {
      this.labelEnTrinca.setVisible(false);
      this.trinca.setVisible(false);
      this.sinTrinca.setVisible(true);
    } 
  }
  
  private void updateArc(Arc arc, Angle startAngle, Angle endAngle) {
    if (startAngle != null && endAngle != null) {
      double startAngleGrados = 360.0D - startAngle.getDegrees().doubleValue() + 90.0D;
      double endAngleGrados = 360.0D - endAngle.getDegrees().doubleValue() + 90.0D;
      double arcLength = endAngleGrados - startAngleGrados;
      arc.setStartAngle(startAngleGrados);
      if (arcLength > 0.0D) {
        arc.setLength(arcLength);
      } else {
        arc.setLength(360.0D + arcLength);
      } 
    } 
  }
  
  public void updateState(GraficaDireccionState state) {
    if (state.getWeaponLeftLimit().isPresent() && state.getWeaponRightLimit().isPresent())
      updateArc(this.weaponArc, state.getWeaponRightLimit().get(), state.getWeaponLeftLimit().get()); 
    updateArc(this.cannonArc, state.getCannonRightLimit(), state.getCannonLeftLimit());
    setAzimuthAngle(state.getAzimuth());
    actualizarEstadoEnTrinca();
    canonTurn(state.getEscalaInterna());
    compassTurn(state.getEscalaExterna());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\GraficaDireccion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */