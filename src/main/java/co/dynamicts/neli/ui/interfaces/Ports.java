package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.PuertoSerial;
import co.dynamicts.neli.core.local.service.PortsService;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import jssc.SerialPortList;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Ports extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField ins;
  @FXML
  private TextField cpa;
  @FXML
  private TextField mvr;
  @FXML
  private ComboBox<SimpleComboBoxItem> numeroPuertoINS;
  @FXML
  private ComboBox<SimpleComboBoxItem> numeroPuertoCPA;
  @FXML
  private ComboBox<SimpleComboBoxItem> numeroPuertoMVR;
  @FXML
  private ComboBox<SimpleComboBoxItem> baudRateINS;
  @FXML
  private ComboBox<SimpleComboBoxItem> baudRateCPA;
  @FXML
  private ComboBox<SimpleComboBoxItem> baudRateMVR;
  @FXML
  private ComboBox<SimpleComboBoxItem> paridadINS;
  @FXML
  private ComboBox<SimpleComboBoxItem> paridadCPA;
  @FXML
  private ComboBox<SimpleComboBoxItem> paridadMVR;
  @FXML
  private ComboBox<SimpleComboBoxItem> bitsStopINS;
  @FXML
  private ComboBox<SimpleComboBoxItem> bitsStopCPA;
  @FXML
  private ComboBox<SimpleComboBoxItem> bitsStopMVR;
  @FXML
  private Button stopINS;
  @FXML
  private Button startINS;
  @FXML
  private Button stopCPA;
  @FXML
  private Button startCPA;
  @FXML
  private Button stopMVR;
  @FXML
  private Button startMVR;
  @FXML
  private Button edit;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public Ports() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/ports.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
    Main.getAppController().topMenu().setVisible(true);
    Main.getAppController().topMenu().updateComponents();
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    StringConverter<SimpleComboBoxItem> stringConverter = new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    };
    String[] puertos = SerialPortList.getPortNames();
    this.numeroPuertoINS.setConverter(stringConverter);
    this.numeroPuertoCPA.setConverter(stringConverter);
    this.numeroPuertoMVR.setConverter(stringConverter);

    for(int i = 0; i < puertos.length; ++i) {
      this.numeroPuertoINS.getItems().add(new SimpleComboBoxItem(puertos[i], i));
      this.numeroPuertoCPA.getItems().add(new SimpleComboBoxItem(puertos[i], i));
      this.numeroPuertoMVR.getItems().add(new SimpleComboBoxItem(puertos[i], i));
    }

    this.baudRateINS.setConverter(stringConverter);
    this.baudRateINS.getItems().add(new SimpleComboBoxItem("9600", 0));
    this.baudRateINS.getItems().add(new SimpleComboBoxItem("19200", 1));
    this.baudRateINS.getItems().add(new SimpleComboBoxItem("57600", 2));
    this.baudRateCPA.setConverter(stringConverter);
    this.baudRateCPA.getItems().add(new SimpleComboBoxItem("9600", 0));
    this.baudRateCPA.getItems().add(new SimpleComboBoxItem("19200", 1));
    this.baudRateCPA.getItems().add(new SimpleComboBoxItem("57600", 2));
    this.baudRateMVR.setConverter(stringConverter);
    this.baudRateMVR.getItems().add(new SimpleComboBoxItem("9600", 0));
    this.baudRateMVR.getItems().add(new SimpleComboBoxItem("19200", 1));
    this.baudRateMVR.getItems().add(new SimpleComboBoxItem("57600", 2));
    this.paridadINS.setConverter(stringConverter);
    this.paridadINS.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.si"), 0));
    this.paridadINS.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.no"), 1));
    this.paridadCPA.setConverter(stringConverter);
    this.paridadCPA.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.si"), 0));
    this.paridadCPA.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.no"), 1));
    this.paridadMVR.setConverter(stringConverter);
    this.paridadMVR.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.si"), 0));
    this.paridadMVR.getItems().add(new SimpleComboBoxItem(StringUtil.translateKey("label.interface.ports.paridad.no"), 1));
    this.bitsStopINS.setConverter(stringConverter);
    this.bitsStopINS.getItems().add(new SimpleComboBoxItem("0", 0));
    this.bitsStopINS.getItems().add(new SimpleComboBoxItem("1", 1));
    this.bitsStopCPA.setConverter(stringConverter);
    this.bitsStopCPA.getItems().add(new SimpleComboBoxItem("0", 0));
    this.bitsStopCPA.getItems().add(new SimpleComboBoxItem("1", 1));
    this.bitsStopMVR.setConverter(stringConverter);
    this.bitsStopMVR.getItems().add(new SimpleComboBoxItem("0", 0));
    this.bitsStopMVR.getItems().add(new SimpleComboBoxItem("1", 1));
    this.ins.getStyleClass().remove("error");
    this.cpa.getStyleClass().add("error");
    this.mvr.getStyleClass().remove("error");
    this.edit.setOnMouseClicked((event) -> {
      if (Main.getAppController().setPasswordDialog()) {
        this.accept.setDisable(false);
        this.numeroPuertoINS.setDisable(false);
        this.numeroPuertoCPA.setDisable(false);
        this.numeroPuertoMVR.setDisable(false);
        this.baudRateINS.setDisable(false);
        this.baudRateCPA.setDisable(false);
        this.baudRateMVR.setDisable(false);
        this.paridadINS.setDisable(false);
        this.paridadCPA.setDisable(false);
        this.paridadMVR.setDisable(false);
        this.bitsStopINS.setDisable(false);
        this.bitsStopCPA.setDisable(false);
        this.bitsStopMVR.setDisable(false);
        this.stopINS.setDisable(false);
        this.startINS.setDisable(false);
        this.stopCPA.setDisable(false);
        this.startCPA.setDisable(false);
        this.stopMVR.setDisable(false);
        this.startMVR.setDisable(false);
      }

    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
  }

  private void clearForm() {
  }

  private boolean validateForm() {
    return true;
  }

  private void formSubmit() {
    co.dynamicts.neli.core.local.model.Ports insInfo = new co.dynamicts.neli.core.local.model.Ports();
    co.dynamicts.neli.core.local.model.Ports cpaInfo = new co.dynamicts.neli.core.local.model.Ports();
    co.dynamicts.neli.core.local.model.Ports mvrInfo = new co.dynamicts.neli.core.local.model.Ports();
    insInfo.setPeriferico(this.ins.getText());
    insInfo.setPuerto(((SimpleComboBoxItem)this.numeroPuertoINS.getSelectionModel().getSelectedItem()).getText());
    insInfo.setVelocidad(Integer.parseInt(((SimpleComboBoxItem)this.baudRateINS.getSelectionModel().getSelectedItem()).getText()));
    insInfo.setParidad(((SimpleComboBoxItem)this.paridadINS.getSelectionModel().getSelectedItem()).getText());
    insInfo.setBitStop(Integer.parseInt(((SimpleComboBoxItem)this.bitsStopINS.getSelectionModel().getSelectedItem()).getText()));
    cpaInfo.setPeriferico(this.cpa.getText());
    cpaInfo.setPuerto(((SimpleComboBoxItem)this.numeroPuertoCPA.getSelectionModel().getSelectedItem()).getText());
    cpaInfo.setVelocidad(Integer.parseInt(((SimpleComboBoxItem)this.baudRateCPA.getSelectionModel().getSelectedItem()).getText()));
    cpaInfo.setParidad(((SimpleComboBoxItem)this.paridadCPA.getSelectionModel().getSelectedItem()).getText());
    cpaInfo.setBitStop(Integer.parseInt(((SimpleComboBoxItem)this.bitsStopCPA.getSelectionModel().getSelectedItem()).getText()));
    mvrInfo.setPeriferico(this.mvr.getText());
    mvrInfo.setPuerto(((SimpleComboBoxItem)this.numeroPuertoMVR.getSelectionModel().getSelectedItem()).getText());
    mvrInfo.setVelocidad(Integer.parseInt(((SimpleComboBoxItem)this.baudRateMVR.getSelectionModel().getSelectedItem()).getText()));
    mvrInfo.setParidad(((SimpleComboBoxItem)this.paridadMVR.getSelectionModel().getSelectedItem()).getText());
    mvrInfo.setBitStop(Integer.parseInt(((SimpleComboBoxItem)this.bitsStopMVR.getSelectionModel().getSelectedItem()).getText()));
    new PuertoSerial("c", insInfo.getPuerto(), insInfo.getVelocidad(), 8, insInfo.getBitStop(), insInfo.getParidadAsInt());

    try {
      PortsService portsService = new PortsService();
      portsService.createTableIfNotExists(co.dynamicts.neli.core.local.model.Ports.class);
      portsService.createOrUpdate(insInfo);
      portsService.createOrUpdate(cpaInfo);
      portsService.createOrUpdate(mvrInfo);
      Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      Main.getAppController().changeUI(MenuNavEnum.WEATHER, true);
    } catch (SQLException var7) {
      var7.printStackTrace();
      Main.getAppController().setInfoMessage("Error al guardar el blancoGeograficas", "ERROR");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME);
  }
}