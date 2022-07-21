package co.dynamicts.neli.ui.component.moving_target;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NewMovingTargetCoordinates extends VBox {
  @FXML
  private Label titleLatitudLongitud;
  
  @FXML
  private Label orientationLeft;
  
  @FXML
  private Label orientationRight;
  
  @FXML
  private TextField degrees;
  
  @FXML
  private TextField inch;
  
  @FXML
  private TextField inchs;
  
  @FXML
  private HBox orientationHBox;
  
  private boolean eastOrNorth;
  
  public NewMovingTargetCoordinates() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/objetivoMovil/coordenada_NOM.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  @FXML
  public void initialize() {
    updateDirection(this.eastOrNorth);
  }
  
  public boolean isEastOrNorth() {
    return this.eastOrNorth;
  }
  
  public void setEastOrNorth(boolean eastOrNorth) {
    this.eastOrNorth = eastOrNorth;
    this.orientationLeft.getStyleClass().clear();
    this.orientationRight.getStyleClass().clear();
    if (eastOrNorth) {
      this.orientationLeft.getStyleClass().add("orientationYellow");
      this.orientationRight.getStyleClass().add("orientationGray");
    } else {
      this.orientationRight.getStyleClass().add("orientationYellow");
      this.orientationLeft.getStyleClass().add("orientationGray");
    } 
  }
  
  public void setLabelText(Label label, String text) {
    label.setText(text);
  }
  
  public Label getTitleLatitudLongitud() {
    return this.titleLatitudLongitud;
  }
  
  public void setTitleLatitudLongitud(Label titleLatitudLongitud) {
    this.titleLatitudLongitud = titleLatitudLongitud;
  }
  
  public void setTitleLatitudLongitud(String title) {
    if (title.trim().toLowerCase().equals("longitud")) {
      this.titleLatitudLongitud.setStyle("-fx-text-fill: #fcb400");
    } else {
      this.titleLatitudLongitud.setStyle("-fx-text-fill: #d8d8d8");
    } 
    setLabelText(this.titleLatitudLongitud, title);
  }
  
  public HBox getOrientationHBox() {
    return this.orientationHBox;
  }
  
  public Label getOrientationLeft() {
    return this.orientationLeft;
  }
  
  public void setOrientationLeft(Label orientationLeft) {
    this.orientationLeft = orientationLeft;
  }
  
  public void setOrientationLeft(String text) {
    this.orientationLeft.setText(text);
  }
  
  public void setOrientationRight(String text) {
    this.orientationRight.setText(text);
  }
  
  public Label getOrientationRight() {
    return this.orientationRight;
  }
  
  public void setOrientationRight(Label orientationRight) {
    this.orientationRight = orientationRight;
  }
  
  public TextField getDegrees() {
    return this.degrees;
  }
  
  public void setDegrees(String degrees) {
    this.degrees.setText(degrees);
  }
  
  public TextField getInch() {
    return this.inch;
  }
  
  public void setInch(String inch) {
    this.inch.setText(inch);
  }
  
  public TextField getInchs() {
    return this.inchs;
  }
  
  public void setInchs(String inchs) {
    this.inchs.setText(inchs);
  }
  
  public void updateDirection(boolean eastOrNorth) {
    setEastOrNorth(eastOrNorth);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\moving_target\NewMovingTargetCoordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */