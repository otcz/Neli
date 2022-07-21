package co.dynamicts.neli.ui.component.moving_target;

import co.dynamicts.neli.core.stauts.StatusNewMovingTarget;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import co.dynamicts.neli.ui.component.common.TextfieldTitle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NewMovingTarget extends VBox {
  @FXML
  private VBox nuevoObjetivoMovil;
  
  @FXML
  private NewMovingTargetCoordinates longitud;
  
  @FXML
  private NewMovingTargetCoordinates latitud;
  
  @FXML
  private HBox HBoxAltura;
  
  @FXML
  private TextField altura;
  
  @FXML
  private TextfieldTitle azumut;
  
  @FXML
  private TextfieldTitle velocidad;
  
  @FXML
  private HBox HBoxBotones;
  
  @FXML
  private ButtonImage aceptar;
  
  @FXML
  private ButtonImage cancelar;
  
  @FXML
  public void initialize() {
    setTitles();
  }
  
  public NewMovingTarget() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/objetivoMovil/nuevo_objetivo_movil.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    this.longitud.getOrientationHBox().setOnMouseClicked(event -> this.longitud.setEastOrNorth(!this.longitud.isEastOrNorth()));
    this.latitud.getOrientationHBox().setOnMouseClicked(event -> this.latitud.setEastOrNorth(!this.latitud.isEastOrNorth()));
    this.aceptar.setOnAction(event -> {
          getCurrentStatus();
          System.out.println(getCurrentStatus());
        });
  }
  
  public StatusNewMovingTarget getCurrentStatus() {
    String longDirection;
    String latDirection;
    if (this.longitud.isEastOrNorth()) {
      longDirection = "West";
    } else {
      longDirection = "East";
    } 
    if (this.latitud.isEastOrNorth()) {
      latDirection = "North";
    } else {
      latDirection = "South";
    } 
    return StatusNewMovingTarget.builder()
      .withVelocidad(this.velocidad.getMeasureLabelCMS().getText())
      .withAzumut(this.azumut.getMeasureLabelCMS().getText())
      .withAltura(this.altura.getText())
      .withLatDegrees(this.latitud.getDegrees().getText())
      .withLatInch(this.latitud.getInch().getText())
      .withLatInchs(this.latitud.getInchs().getText())
      .withLongDegrees(this.longitud.getDegrees().getText())
      .withLongInch(this.longitud.getInch().getText())
      .withLongInchs(this.longitud.getInchs().getText())
      
      .withLongDirection(longDirection)
      .withLatDirection(latDirection)
      
      .build();
  }
  
  private void setTitles() {
    this.longitud.setTitleLatitudLongitud("Longitud");
    this.longitud.setOrientationLeft("W");
    this.longitud.setOrientationRight("E");
    this.azumut.setTitleLabelCMS("Azumut[m]");
    this.velocidad.setTitleLabelCMS("Velocidad[m/s]");
    this.aceptar.setLabel("Aceptar");
    this.cancelar.setLabel("Cancelar");
    this.latitud.setTitleLatitudLongitud("Latitud");
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\moving_target\NewMovingTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */