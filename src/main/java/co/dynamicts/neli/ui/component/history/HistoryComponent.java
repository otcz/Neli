package co.dynamicts.neli.ui.component.history;

import co.dynamicts.neli.core.stauts.Registro;
import co.dynamicts.neli.ui.component.common.ButtonImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HistoryComponent extends VBox {
  @FXML
  TableView<Registro> historialTable;
  
  @FXML
  private TableColumn columnaMunicion;
  
  @FXML
  private TableColumn columnaZona;
  
  @FXML
  private TableColumn columnaFecha;
  
  @FXML
  private TableColumn columnaTemperatura;
  
  @FXML
  private TableColumn columnaVelocidad;
  
  @FXML
  private Label labelTitulo;
  
  @FXML
  private ButtonImage resetHistorial;
  
  private final ObservableList<Registro> data = FXCollections.observableArrayList(new Registro[] { 
        new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), 
        new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), 
        new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), 
        new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), 
        new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]"), new Registro("MI BO", "5", "23:08 00/00/00", "21°", "820 [m/s]"), new Registro("MI BO", "4", "23:08 00/00/00", "18°", "0000 [m/s]") });
  
  @FXML
  public void initialize() {
    this.columnaMunicion.setCellValueFactory(new PropertyValueFactory<>("Municion"));
    this.columnaZona.setCellValueFactory(new PropertyValueFactory<>("Zona"));
    this.columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    this.columnaTemperatura.setCellValueFactory(new PropertyValueFactory<>("temperature"));
    this.columnaVelocidad.setCellValueFactory(new PropertyValueFactory<>("velocidad"));
    this.historialTable.setItems(this.data);
    this.columnaMunicion.setText("Municion");
    this.columnaZona.setText("Zona");
    this.columnaFecha.setText("Fecha");
    this.columnaTemperatura.setText("Temperatura");
    this.columnaVelocidad.setText("Velocidad [m/s] ");
    this.resetHistorial.setLabel("Reset History");
    this.resetHistorial.setOnAction(event -> this.data.clear());
  }
  
  public void addRegister(Registro toAdd) {
    this.data.add(toAdd);
  }
  
  public HistoryComponent() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/historial/historial.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\history\HistoryComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */