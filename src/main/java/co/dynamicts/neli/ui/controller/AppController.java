package co.dynamicts.neli.ui.controller;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.Fires.Pointing;
import co.dynamicts.neli.core.Hardware.InsEthernet;
import co.dynamicts.neli.core.ObusHW.*;
import co.dynamicts.neli.core.controllers.MainController;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.sensors.events.DisplayKeyEvent;
import co.dynamicts.neli.core.sensors.events.Handler;
import co.dynamicts.neli.core.sensors.events.RotationChangeEvent;
import co.dynamicts.neli.ui.block.CoordinatesBlock;
import co.dynamicts.neli.ui.block.MenuNavBlock;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.component.common.Confirm;
import co.dynamicts.neli.ui.component.common.Loading;
import co.dynamicts.neli.ui.component.common.Password;
import co.dynamicts.neli.ui.component.common.Success;
import co.dynamicts.neli.ui.component.home.state.TopMenuState;
import co.dynamicts.neli.ui.component.home.top.menu.BandejaItemStatus;
import co.dynamicts.neli.ui.component.home.top.menu.ItemStatus;
import co.dynamicts.neli.ui.component.home.top.menu.TopMenu;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.interfaces.InterfaceBuilder;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class AppController implements Handler<RotationChangeEvent> {
  public static final String EVENT_CONFIG = "CONFIG_EVENT";
  
  public static final String MSG_DEFAULT = "DEFAULT";
  
  public static final String MSG_INFO = "INFO";
  
  public static final String MSG_CONFIRMATION = "CONFIRMATION";
  
  public static final String MSG_WARNING = "WARNING";
  
  public static final String MSG_ERROR = "ERROR";
  
  @FXML
  private StackPane splash;
  
  @FXML
  private StackPane interfacesPane;
  
  @FXML
  private MenuNavBlock menuBlock;
  
  @FXML
  private CoordinatesBlock coordinatesBlock;
  
  @FXML
  private HBox info;
  
  @FXML
  private Label infoBox;
  
  @FXML
  private ProgressBar progressBar;
  
  @FXML
  private Label countdown;
  
  @FXML
  private Loading loadingSplash;
  
  @FXML
  private Password password;
  
  @FXML
  private Success success;
  
  @FXML
  private Confirm confirm;
  
  @FXML
  private Button fine;
  
  @FXML
  private Button normal;
  
  @FXML
  private Button quick;
  
  @FXML
  private TopMenu topMenu;
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private Timer timer;
  
  private int interval = 240;
  
  private int fineTime = 600;
  
  private int normalTime = 240;
  
  private int quickTime = 30;
  
  private int auxTimer = this.fineTime;
  
  private int countTimer = 0;
  
  private long lastTick = 0L;
  
  private String user = "NELI";
  
  private String pass = "neli";
  
  public void initialize() {
    this.fine.setOnMouseClicked(event -> this.auxTimer = this.fineTime);
    this.normal.setOnMouseClicked(event -> this.auxTimer = this.normalTime);
    this.quick.setOnMouseClicked(event -> this.auxTimer = this.quickTime);
    stopLoading();
    hidePassword();
    hideSuccess();
    hideConfirm();
    this.confirm.setConfirm("/images/alert3x.png", "Texto de confirmación", "Confirmar");
    hideConfirm();
    if (this.configuracion.isSimulado)
      this.quickTime = 2; 
  }
  
  public Confirm getConfirm() {
    return this.confirm;
  }
  
  public Loading getLoadingSplash() {
    return this.loadingSplash;
  }
  
  public Password getPassword() {
    return this.password;
  }
  
  public Success getSuccess() {
    return this.success;
  }
  
  public void showSuccess() {
    this.success.setVisible(true);
  }
  
  public void hideSuccess() {
    this.success.setVisible(false);
  }
  
  public void showConfirm() {
    this.confirm.setVisible(true);
  }
  
  public void hideConfirm() {
    this.confirm.setVisible(false);
  }
  
  public void showSuccess(String text, String imageURL) {
    this.success.setComponents(text, imageURL);
  }
  
  public void stopLoading() {
    this.loadingSplash.stop();
    this.loadingSplash.setVisible(false);
  }
  
  public void showPassword() {
    this.password.setTitles();
    this.password.setVisible(true);
  }
  
  public void hidePassword() {
    this.password.setVisible(false);
  }
  
  public void loading() {
    this.loadingSplash.startLoading();
    this.loadingSplash.setVisible(true);
  }
  
  public MenuNavEnum changeUI(MenuNavEnum menuOption) {
    return changeUI(menuOption, false);
  }
  
  public MenuNavEnum changeUI(MenuNavEnum menuOption, boolean force) {
    setInfoMessage(" ", "DEFAULT");
    int minIndex = 1;
    if (force) {
      minIndex = 0;
      Platform.runLater(() -> {
            this.topMenu.initComponent();
            this.coordinatesBlock.initComponent();
          });
    } 
    while (this.interfacesPane.getChildren().size() > minIndex) {
      int lastIndex = this.interfacesPane.getChildren().size() - 1;
      this.interfacesPane.getChildren().remove(lastIndex);
    } 
    if (this.interfacesPane.getChildren().isEmpty()) {
      this.interfacesPane.getChildren().add((Node)MenuNavEnum.HOME.getInterface());
      if (MenuNavEnum.HOME.equals(menuOption)) {
        getMenuBlock().renderMenu(MenuNavEnum.HOME, true);
        return MenuNavEnum.HOME;
      } 
    } 
    if (!MenuNavEnum.HOME.equals(menuOption))
      this.interfacesPane.getChildren().add((Node)menuOption.getInterface()); 
    if (this.interfacesPane.getChildren().size() > 1) {
      ((Node)this.interfacesPane.getChildren().get(0)).setEffect(new BoxBlur(20.0D, 20.0D, 3));
    } else if (this.interfacesPane.getChildren().size() == 1) {
      ((Node)this.interfacesPane.getChildren().get(0)).setEffect(null);
    } 
    for (Node ui : this.interfacesPane.getChildren()) {
      if (ui instanceof BaseUserInterface)
        ((BaseUserInterface)ui).updateComponents(); 
    } 
    return menuOption;
  }
  
  public void setInfoMessage(String message, String type) {
    this.info.getStyleClass().removeAll(new String[] { "error", "info", "warning" });
    switch (type) {
      case "ERROR":
        this.info.getStyleClass().add("error");
        break;
      case "INFO":
        this.info.getStyleClass().add("info");
        break;
      case "WARNING":
        this.info.getStyleClass().add("warning");
        break;
    } 
    this.infoBox.setText(message);
  }
  
  public void setInfoDialog(String title, String content, String type) {
    Alert.AlertType alertType = null;
    String styleClass = null;
    switch (type) {
      case "ERROR":
        alertType = Alert.AlertType.ERROR;
        styleClass = "error";
        break;
      case "WARNING":
        alertType = Alert.AlertType.WARNING;
        styleClass = "warning";
        break;
      default:
        alertType = Alert.AlertType.INFORMATION;
        styleClass = "information";
        break;
    } 
    Alert alert = new Alert(alertType);
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
    alert.initStyle(StageStyle.UNDECORATED);
    alert.setHeaderText(title);
    alert.setContentText(content);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStyleClass().add(styleClass);
    ImageView DIALOG_HEADER_ICON = new ImageView("/images/alert3x.png");
    DIALOG_HEADER_ICON.setFitHeight(20.0D);
    DIALOG_HEADER_ICON.setFitWidth(20.0D);
    alert.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
    alert.showAndWait();
  }
  
  public boolean setPasswordDialog() {
    this.pass = "Neli " + InsEthernet.getSingletonInstance(this.configuracion.isSimulado).getHOST();
    System.out.println("pass = " + this.pass);
    Dialog<Pair<String, String>> dialogPass = new Dialog<>();
    dialogPass.setTitle("Desbloqueo");
    dialogPass.setHeaderText("Es necesario validar permiso");
    dialogPass.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
    dialogPass.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
    dialogPass.initStyle(StageStyle.UNDECORATED);
    ButtonType loginButtonType = new ButtonType("Acceder", ButtonBar.ButtonData.OK_DONE);
    dialogPass.getDialogPane().getButtonTypes().addAll(new ButtonType[] { loginButtonType, ButtonType.CANCEL });
    GridPane grid = new GridPane();
    grid.setHgap(10.0D);
    grid.setVgap(10.0D);
    grid.setPadding(new Insets(20.0D, 150.0D, 10.0D, 10.0D));
    PasswordField password = new PasswordField();
    password.setPromptText("Contraseña");
    grid.add(new Label("Contraseña:"), 0, 1);
    grid.add(password, 1, 1);
    Node loginButton = dialogPass.getDialogPane().lookupButton(loginButtonType);
    ImageView DIALOG_HEADER_ICON_PASS = new ImageView("/images/key3x.png");
    DIALOG_HEADER_ICON_PASS.setFitHeight(20.0D);
    DIALOG_HEADER_ICON_PASS.setFitWidth(20.0D);
    dialogPass.getDialogPane().setGraphic(DIALOG_HEADER_ICON_PASS);
    dialogPass.getDialogPane().setContent(grid);
    Platform.runLater(() -> password.requestFocus());
    dialogPass.setResultConverter(dialogButton -> {
          if (dialogButton == loginButtonType)
            return new Pair<>(this.user, password.getText()); 
          hidePassword();
          return null;
        });
    Optional<Pair<String, String>> resultPass = dialogPass.showAndWait();
    boolean[] isOk = { false };
    resultPass.ifPresent(usernamePassword -> {
          if (!((String)usernamePassword.getKey()).equals(this.user) || !((String)usernamePassword.getValue()).equals(this.pass)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error: Datos Incorrectos");
            alert.setContentText("Verifique los datos de acceso");
            alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
            alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
            alert.initStyle(StageStyle.UNDECORATED);
            ImageView DIALOG_HEADER_ICON = new ImageView("/images/close3x.png");
            DIALOG_HEADER_ICON.setFitHeight(20.0D);
            DIALOG_HEADER_ICON.setFitWidth(20.0D);
            alert.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
            alert.showAndWait();
            isOk[0] = false;
          } else {
            isOk[0] = true;
          } 
        });
    return isOk[0];
  }
  
  public boolean setConfirmationDialog(String title, String content) {
    Alert.AlertType alertType = Alert.AlertType.CONFIRMATION;
    String styleClass = "confirmation";
    Alert alert = new Alert(alertType);
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
    alert.initStyle(StageStyle.UNDECORATED);
    alert.setHeaderText(title);
    alert.setContentText(content);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStyleClass().add(styleClass);
    ImageView DIALOG_HEADER_ICON = new ImageView("/images/alert3x.png");
    DIALOG_HEADER_ICON.setFitHeight(20.0D);
    DIALOG_HEADER_ICON.setFitWidth(20.0D);
    alert.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK)
      return true; 
    return false;
  }
  
  public void setNoneDialog(String title, String content) {
    Alert.AlertType alertType = Alert.AlertType.NONE;
    String styleClass = "confirmation";
    Alert alert = new Alert(alertType);
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
    alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
    alert.initStyle(StageStyle.UNDECORATED);
    alert.setHeaderText(title);
    alert.setContentText(content);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStyleClass().add(styleClass);
    ImageView DIALOG_HEADER_ICON = new ImageView("/images/alert3x.png");
    DIALOG_HEADER_ICON.setFitHeight(20.0D);
    DIALOG_HEADER_ICON.setFitWidth(20.0D);
    alert.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
    alert.showAndWait();
  }
  
  public void processKeyEvent(KeyEvent key) {
    this.menuBlock.processKeyEvent(key);
  }
  
  public void processDisplayKeyCode(DisplayKeyEvent keyEvent) {
    this.menuBlock.processDisplayKeyEvent(keyEvent);
  }
  
  public void setTimer() {
    this.timer = new Timer();
    this.timer.scheduleAtFixedRate(new TimerTask() {
          public void run() {
            if (AppController.this.configuracion.isSimulado) {
              if (AppController.this.interval > 0) {
                Platform.runLater(() -> {
                      Date d = new Date(AppController.this.interval * 1000L);
                      SimpleDateFormat df = new SimpleDateFormat("mm:ss");
                      df.setTimeZone(TimeZone.getTimeZone("GMT"));
                      AppController.this.countdown.setText(df.format(d));
                    });
                AppController.this.interval--;
                AppController.this.countTimer++;
                if (AppController.this.auxTimer != 0) {
                  AppController.this.interval = AppController.this.auxTimer - AppController.this.countTimer;
                  if (AppController.this.countTimer > AppController.this.interval)
                    AppController.this.interval = 0; 
                  AppController.this.auxTimer = 0;
                } 
              } else {
                Platform.runLater(() -> AppController.this.transition());
                AppController.this.timer.cancel();
              } 
            } else {
              Ins ins = Ins.getSingletonInstance();
              double seconds = (ins.timeOn.getHour() * 3600 + ins.timeOn.getMinutes() * 60 + ins.timeOn.getSeconds());
              System.out.println("seconds = " + seconds);
              if (seconds < AppController.this.auxTimer) {
                Platform.runLater(() -> AppController.this.countdown.setText(String.valueOf(ins.timeOn.getHour()) + ":" + String.valueOf(ins.timeOn.getMinutes()) + ":" + String.valueOf(ins.timeOn.getSeconds())));
              } else {
                Platform.runLater(() -> AppController.this.transition());
                AppController.this.timer.cancel();
              } 
            } 
          }
        },  1000L, 1000L);
  }
  
  private void transition() {
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.0D), this.splash);
    fadeTransition.setFromValue(1.0D);
    fadeTransition.setToValue(0.0D);
    fadeTransition.setInterpolator(Interpolator.EASE_BOTH);
    fadeTransition.setOnFinished(event -> {
          ((StackPane)this.splash.getParent()).getChildren().remove(this.splash);
          MainController.getInstance().getRotationSensor().addEventHandler(RotationChangeEvent.class, this);
        });
    fadeTransition.play();
  }
  
  public MenuNavBlock getMenuBlock() {
    return this.menuBlock;
  }
  
  public CoordinatesBlock getCoordinatesBlock() {
    return this.coordinatesBlock;
  }
  
  public MenuNavEnum changeUIWithOutMenu(MenuNavEnum origin, String destination, boolean force) {
    setInfoMessage(" ", "DEFAULT");
    int minIndex = 1;
    if (force) {
      minIndex = 0;
      Platform.runLater(() -> this.coordinatesBlock.initComponent());
    } 
    while (this.interfacesPane.getChildren().size() > minIndex) {
      int lastIndex = this.interfacesPane.getChildren().size() - 1;
      this.interfacesPane.getChildren().remove(lastIndex);
    } 
    if (this.interfacesPane.getChildren().isEmpty()) {
      this.interfacesPane.getChildren().add((Node)MenuNavEnum.HOME.getInterface());
      if (MenuNavEnum.HOME.equals(origin))
        return MenuNavEnum.HOME; 
    } 
    if (!MenuNavEnum.HOME.equals(origin))
      this.interfacesPane.getChildren().add((Node)InterfaceBuilder.create(destination)); 
    if (this.interfacesPane.getChildren().size() > 1) {
      ((Node)this.interfacesPane.getChildren().get(0)).setEffect(new BoxBlur(20.0D, 20.0D, 3));
    } else if (this.interfacesPane.getChildren().size() == 1) {
      ((Node)this.interfacesPane.getChildren().get(0)).setEffect(null);
    } 
    for (Node ui : this.interfacesPane.getChildren()) {
      if (ui instanceof BaseUserInterface)
        ((BaseUserInterface)ui).updateComponents(); 
    } 
    return origin;
  }
  
  public void onEvent(RotationChangeEvent event) {
    if (Instant.now().toEpochMilli() - this.lastTick > 100L) {
      this.coordinatesBlock.updateComponents();
      for (Node ui : this.interfacesPane.getChildren()) {
        if (ui instanceof BaseUserInterface)
          ((BaseUserInterface)ui).updateComponents(); 
      } 
      this.lastTick = Instant.now().toEpochMilli();
      this.coordinatesBlock.updateComponents();
    } 
  }
  
  public void updateTopMenuState() {
    CMS cms = CMS.getSingletonInstance();
    CPA cpa = CPA.getSingletonInstance();
    Trinca trinca = Trinca.getSingletonInstance();
    Ins ins = Ins.getSingletonInstance();
    Principal principal = Principal.getSingletonInstance();
    Pointing pointing = Pointing.getSingletonInstance();
    DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
    Configuracion configuracion = Configuracion.getSingletonInstance();
    MuzzleRadar muzzleRadar = MuzzleRadar.getSingletonInstance();
    ItemStatus insStatus = null;
    ItemStatus gpsStatus = null;
    if (ins.estadoINS == Ins.EstadoINS.DISCONNECTED) {
      insStatus = ItemStatus.BAD;
    } else if (ins.estadoINS == Ins.EstadoINS.CONNECTED_DISALIGMENT) {
      insStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoINS == Ins.EstadoINS.CONNECTED_OK) {
      insStatus = ItemStatus.OK;
    } 
    if (ins.estadoGPS == Ins.EstadoGPS.DISCONNECTED) {
      gpsStatus = ItemStatus.BAD;
    } else if (ins.estadoGPS == Ins.EstadoGPS.CONNECTED_MEDIUM) {
      gpsStatus = ItemStatus.MEDIUM;
    } else if (ins.estadoGPS == Ins.EstadoGPS.CONNECTED_OK) {
      gpsStatus = ItemStatus.OK;
    } 
    this.topMenu.updateState(
        
        TopMenuState.builder()
        .withTemperatura(ItemStatus.values()[cms.getTemCanonState()])
        .withCalibracion(ItemStatus.values()[cpa.getIsCalibrated()])
        .withTrinca(trinca.isTrincaPut() ? ItemStatus.BAD : ItemStatus.OK)
        .withStatusBandeja(BandejaItemStatus.values()[2])
        .withBandeja(ItemStatus.values()[cpa.getHMS()])
        .withMunicion(Integer.valueOf(configuracion.municion.getCantidad()))
        .withZupt(ins.isZuptTiro() ? ItemStatus.OK : ItemStatus.BAD)
        .withCms(cms.isCMS() ? ItemStatus.OK : ItemStatus.BAD)
        .withHms(cpa.isHMS() ? ItemStatus.OK : ItemStatus.BAD)
        .withOdometro(ins.isOdo() ? ItemStatus.OK : ItemStatus.BAD)
        .withRadar(muzzleRadar.isRadarOk() ? ItemStatus.OK : ItemStatus.BAD)
        .withPunteria(cpa.isCPA() ? ItemStatus.OK : ItemStatus.BAD)
        .withGps(gpsStatus)
        .withIns(insStatus)
        .build());
  }
  
  public TopMenu topMenu() {
    return this.topMenu;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\controller\AppController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */