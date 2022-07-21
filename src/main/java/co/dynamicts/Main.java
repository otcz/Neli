package co.dynamicts;

import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.local.model.Ammunition;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.controller.AppController;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

public class Main extends Application {
  private static AppController appController;
  
  private static Timer timer;
  
  private static final int TICK = 125;
  
  private Stage stage;
  
  private static Principal principal;
  
  private static Configuracion configuracion = Configuracion.getSingletonInstance();
  
  private Robot robot;
  
  Date objDate = new Date();
  
  String strDayFormat = "dd";
  
  String strMonthFormat = "MM";
  
  String strYearFormat = "yyyy";
  
  String strDateFormat = "dd/MM/yyyy";
  
  SimpleDateFormat formatDate = new SimpleDateFormat(this.strDateFormat);
  
  SimpleDateFormat formatDay = new SimpleDateFormat(this.strDayFormat);
  
  SimpleDateFormat formatMonth = new SimpleDateFormat(this.strMonthFormat);
  
  SimpleDateFormat formatYear = new SimpleDateFormat(this.strYearFormat);
  
  final String key = "NELI";
  
  String pass = "Neli";
  
  public void start(Stage stage) {
    if (Main.configuracion.isPassword) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      try {
        Date date1 = dateFormat.parse("15/04/2023");
        Date date2 = dateFormat.parse("30/04/2022");
        Date date3 = dateFormat.parse(this.formatDate.format(this.objDate));
        if (1==1) {
          this.pass = this.formatYear.format(this.objDate) + "|\\|eL!" + this.formatDay.format(this.objDate) + "V1.2-" + this.formatMonth.format(this.objDate);
          if (1==1)
            System.out.println("pass = " + this.pass); 
          try {
            this.stage = stage;
            principal = Principal.getSingletonInstance();
            Configuracion configuracion = Configuracion.getSingletonInstance();
            checkPassword();
            if (Configuracion.Language.ESP.equals(configuracion.getLanguage())) {
              Locale.setDefault(new Locale("es", ""));
            } else {
              Locale.setDefault(Locale.ENGLISH);
            } 
            AppConfig.getInstance().setResouce(ResourceBundle.getBundle("language", Locale.getDefault()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/app.fxml"));
            loader.setResources(AppConfig.getInstance().getResouce());
            Parent root = null;
            try {
              root = loader.<Parent>load();
            } catch (IOException e) {
              e.printStackTrace();
            } 
            appController = loader.<AppController>getController();
            if (configuracion.isProduction) {
              stage.setFullScreen(true);
              stage.initStyle(StageStyle.DECORATED);
            } 
            stage.setTitle("Neli");
            stage.setScene(new Scene(root, 1024.0D, 768.0D));
            stage.show();
            stage.setMinWidth(1024.0D);
            stage.setMinHeight(768.0D);
            getAppController().changeUI(MenuNavEnum.HOME);
            if (Configuracion.getSingletonInstance().isFirtTime()) {
              List<String> choices = new ArrayList<>();
              choices.add(String.valueOf(Configuracion.Sistema.OBUS_155));
              choices.add(String.valueOf(Configuracion.Sistema.OBUS_105_L119));
              choices.add(String.valueOf(Configuracion.Sistema.OBUS_105_LG));
              ChoiceDialog<String> dialog = new ChoiceDialog<>(String.valueOf(Configuracion.Sistema.OBUS_155), choices);
              dialog.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
              dialog.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
              dialog.initStyle(StageStyle.UNDECORATED);
              ImageView DIALOG_HEADER_ICON = new ImageView("/images/alert3x.png");
              DIALOG_HEADER_ICON.setFitHeight(20.0D);
              DIALOG_HEADER_ICON.setFitWidth(20.0D);
              dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
              dialog.setHeaderText(StringUtil.translateKey("dialog.first.header"));
              dialog.setContentText(StringUtil.translateKey("dialog.first.content"));
              Optional<String> result = dialog.showAndWait();
              if (result.isPresent()) {
                if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_155))) {
                  Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_155);
                  Configuracion.getSingletonInstance().setFirtTime(false);
                  Configuracion.getSingletonInstance().setAmmoListFirstTime();
                  Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
                  Configuracion.getSingletonInstance().actualizaConfiguracion();
                  getAppController().changeUI(MenuNavEnum.HOME, true);
                  appController.setTimer();
                } else if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_105_L119))) {
                  Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_105_L119);
                  Configuracion.getSingletonInstance().setFirtTime(false);
                  Configuracion.getSingletonInstance().setAmmoListFirstTime();
                  Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
                  Configuracion.getSingletonInstance().actualizaConfiguracion();
                  getAppController().changeUI(MenuNavEnum.HOME, true);
                  appController.setTimer();
                } else if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_105_LG))) {
                  Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_105_LG);
                  Configuracion.getSingletonInstance().setFirtTime(false);
                  Configuracion.getSingletonInstance().setAmmoListFirstTime();
                  Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
                  Configuracion.getSingletonInstance().actualizaConfiguracion();
                  getAppController().changeUI(MenuNavEnum.HOME, true);
                  appController.setTimer();
                } 
              } else {
                System.exit(0);
              } 
            } else {
              appController.setTimer();
            } 
            setTimer();
          } catch (Exception e) {
            e.printStackTrace();
          } 
        } else {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText("Error: Fecha fuera de curso");
          alert.setContentText("No se puede iniciar NELI");
          alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
          alert.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
          alert.initStyle(StageStyle.UNDECORATED);
          ImageView DIALOG_HEADER_ICON = new ImageView("/images/close3x.png");
          DIALOG_HEADER_ICON.setFitHeight(20.0D);
          DIALOG_HEADER_ICON.setFitWidth(20.0D);
          alert.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
          alert.showAndWait();
          System.exit(0);
        } 
      } catch (ParseException e) {
        e.printStackTrace();
      } 
    } else {
      try {
        this.stage = stage;
        principal = Principal.getSingletonInstance();
        Configuracion configuracion = Configuracion.getSingletonInstance();
        if (Configuracion.Language.ESP.equals(configuracion.getLanguage())) {
          Locale.setDefault(new Locale("es", ""));
        } else {
          Locale.setDefault(Locale.ENGLISH);
        } 
        AppConfig.getInstance().setResouce(ResourceBundle.getBundle("language", Locale.getDefault()));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/app.fxml"));
        loader.setResources(AppConfig.getInstance().getResouce());
        Parent root = null;
        try {
          root = loader.<Parent>load();
        } catch (IOException e) {
          e.printStackTrace();
        } 
        appController = loader.<AppController>getController();
        if (configuracion.isProduction) {
          stage.setFullScreen(true);
          stage.initStyle(StageStyle.DECORATED);
        } 
        stage.setTitle("Neli");
        stage.setScene(new Scene(root, 1024.0D, 768.0D));
        stage.show();
        stage.setMinWidth(1024.0D);
        stage.setMinHeight(768.0D);
        getAppController().changeUI(MenuNavEnum.HOME);
        if (Configuracion.getSingletonInstance().isFirtTime()) {
          List<String> choices = new ArrayList<>();
          choices.add(String.valueOf(Configuracion.Sistema.OBUS_155));
          choices.add(String.valueOf(Configuracion.Sistema.OBUS_105_L119));
          choices.add(String.valueOf(Configuracion.Sistema.OBUS_105_LG));
          ChoiceDialog<String> dialog = new ChoiceDialog<>(String.valueOf(Configuracion.Sistema.OBUS_155), choices);
          dialog.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
          dialog.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
          dialog.initStyle(StageStyle.UNDECORATED);
          ImageView DIALOG_HEADER_ICON = new ImageView("/images/alert3x.png");
          DIALOG_HEADER_ICON.setFitHeight(20.0D);
          DIALOG_HEADER_ICON.setFitWidth(20.0D);
          dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
          dialog.setHeaderText(StringUtil.translateKey("dialog.first.header"));
          dialog.setContentText(StringUtil.translateKey("dialog.first.content"));
          Optional<String> result = dialog.showAndWait();
          if (result.isPresent()) {
            if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_155))) {
              Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_155);
              Configuracion.getSingletonInstance().setFirtTime(false);
              Configuracion.getSingletonInstance().setAmmoListFirstTime();
              Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
              Configuracion.getSingletonInstance().actualizaConfiguracion();
              getAppController().changeUI(MenuNavEnum.HOME, true);
              appController.setTimer();
            } else if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_105_L119))) {
              Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_105_L119);
              Configuracion.getSingletonInstance().setFirtTime(false);
              Configuracion.getSingletonInstance().setAmmoListFirstTime();
              Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
              Configuracion.getSingletonInstance().actualizaConfiguracion();
              getAppController().changeUI(MenuNavEnum.HOME, true);
              appController.setTimer();
            } else if (((String)result.get()).equals(String.valueOf(Configuracion.Sistema.OBUS_105_LG))) {
              Configuracion.getSingletonInstance().setSistema(Configuracion.Sistema.OBUS_105_LG);
              Configuracion.getSingletonInstance().setFirtTime(false);
              Configuracion.getSingletonInstance().setAmmoListFirstTime();
              Configuracion.getSingletonInstance().setTipoMunicion(((Ammunition)(Configuracion.getSingletonInstance()).ammunitions.get(0)).getNombreMunicion());
              Configuracion.getSingletonInstance().actualizaConfiguracion();
              getAppController().changeUI(MenuNavEnum.HOME, true);
              appController.setTimer();
            } 
          } else {
            System.exit(0);
          } 
        } else {
          appController.setTimer();
        } 
        setTimer();
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public void checkPassword() {
    Dialog<Pair<String, String>> dialogPass = new Dialog<>();
    dialogPass.setTitle("Acceso a NELI");
    dialogPass.setHeaderText("Ingrese para iniciar el simulador de NELI");
    dialogPass.getDialogPane().getStylesheets().add(Main.class.getResource("/css/variables.css").toExternalForm());
    dialogPass.getDialogPane().getStylesheets().add(Main.class.getResource("/css/general.css").toExternalForm());
    dialogPass.initStyle(StageStyle.UNDECORATED);
    ButtonType loginButtonType = new ButtonType("Acceder", ButtonBar.ButtonData.OK_DONE);
    dialogPass.getDialogPane().getButtonTypes().addAll(new ButtonType[] { loginButtonType, ButtonType.CANCEL });
    GridPane grid = new GridPane();
    grid.setHgap(10.0D);
    grid.setVgap(10.0D);
    grid.setPadding(new Insets(20.0D, 150.0D, 10.0D, 10.0D));
    TextField username = new TextField();
    username.setText("Usuario");
    PasswordField password = new PasswordField();
    password.setPromptText("Contraseña");
    grid.add(new Label("Usuario:"), 0, 0);
    grid.add(username, 1, 0);
    grid.add(new Label("Contraseña:"), 0, 1);
    grid.add(password, 1, 1);
    Node loginButton = dialogPass.getDialogPane().lookupButton(loginButtonType);
    loginButton.setDisable(true);
    username.textProperty().addListener((observable, oldValue, newValue) -> {
          if (newValue.equals("NELI")) {
            loginButton.setDisable(newValue.trim().isEmpty());
          } else {
            loginButton.setDisable(true);
          } 
        });
    dialogPass.getDialogPane().setContent(grid);
    Platform.runLater(() -> username.requestFocus());
    dialogPass.setResultConverter(dialogButton -> {
          if (dialogButton == loginButtonType)
            return new Pair<>(username.getText(), password.getText()); 
          System.exit(0);
          return null;
        });
    Optional<Pair<String, String>> resultPass = dialogPass.showAndWait();
    resultPass.ifPresent(usernamePassword -> {
          if (!((String)usernamePassword.getKey()).equals("NELI") || !((String)usernamePassword.getValue()).equals(this.pass)) {
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
            checkPassword();
          } 
        });
  }
  
  public static void main(String[] args) {
    try {
      launch(args);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static AppController getAppController() {
    return appController;
  }
  
  public static void setTimer() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
          public void run() {
            Platform.runLater(() -> Main.setVirtualKeyboradCss());
          }
        },  125L, 125L);
  }
  
  private static void setVirtualKeyboradCss() {
    Iterator<Window> windows = Window.getWindows().listIterator();
    while (windows.hasNext()) {
      Window window = windows.next();
      if (window instanceof javafx.stage.Popup) {
        String vars = Main.class.getResource("/css/variables.css").toExternalForm();
        String embed = Main.class.getResource("/css/embeded.css").toExternalForm();
        FXVK keyboard = (FXVK)window.getScene().getRoot().lookup(".fxvk");
        if (keyboard != null && 
          !keyboard.getStylesheets().contains(embed)) {
          keyboard.getStylesheets().addAll(new String[] { vars, embed });
          timer.cancel();
          timer = null;
        } 
      } 
    } 
  }
  
  public void stop() {
    System.out.println("Stage is closing");
    System.exit(0);
  }
  
  public static Principal getPrincipal() {
    return principal;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */