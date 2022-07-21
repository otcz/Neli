package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.core.stauts.StatusCoordinatesUTM;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CoordinateUTM extends VBox {
  @FXML
  private Label title;
  
  @FXML
  private Label northUTM;
  
  @FXML
  private Label eastUTM;
  
  @FXML
  private Label useUTM;
  
  @FXML
  private Label bandUTM;
  
  @FXML
  private Label height;
  
  @FXML
  public GridPane gridPane;
  
  @FXML
  private String innerBoxStyleClass;
  
  public CoordinateUTM() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/coordinate_utm.fxml"));
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
  
  public void setInnerBoxStyleClass(String innerBoxStyleClass) {
    this.innerBoxStyleClass = innerBoxStyleClass;
    this.gridPane.getStyleClass().add(innerBoxStyleClass);
  }
  
  public String getInnerBoxStyleClass() {
    return this.innerBoxStyleClass;
  }
  
  public void setText(String text) {
    this.title.setText(text);
  }
  
  public String getText() {
    return this.title.getText();
  }
  
  public void setPoint(PuntoUTM point) {
    this.northUTM.setText("" + (int)point.getDeltaNorte());
    this.eastUTM.setText("" + (int)point.getDeltaEste());
    this.useUTM.setText("" + (int)point.getHuso());
    this.bandUTM.setText(point.getBanda());
    this.height.setText("" + (int)point.getAltura());
  }
  
  public void setPoint(StatusCoordinatesUTM point) {
    this.northUTM.setText(point.getNorthUTM().toString());
    this.eastUTM.setText(point.getEastUTM().toString());
    this.useUTM.setText(point.getUseUTM().toString());
    this.bandUTM.setText(point.getBandUTM());
    this.height.setText(point.getHeight().toString());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\CoordinateUTM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */