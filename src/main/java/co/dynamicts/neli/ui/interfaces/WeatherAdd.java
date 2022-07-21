package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.local.model.Weather;
import co.dynamicts.neli.core.local.service.WeatherService;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.MeasureExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WeatherAdd extends VBox implements BaseUserInterface, Initializable {
  @FXML
  private TextField zone;
  @FXML
  private TextField lineCount;
  @FXML
  private TextField windDirection;
  @FXML
  private TextField windSpeed;
  @FXML
  private TextField temperature;
  @FXML
  private TextField pressure;
  @FXML
  private Button cancel;
  @FXML
  private Button accept;

  public WeatherAdd() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/weather_add.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void updateComponents() {
  }

  public void initialize(URL location, ResourceBundle resources) {
    this.updateComponents();
    this.zone.getProperties().put("vkType", "numeric");
    this.lineCount.getProperties().put("vkType", "numeric");
    this.windDirection.getProperties().put("vkType", "numeric");
    this.windSpeed.getProperties().put("vkType", "numeric");
    this.temperature.getProperties().put("vkType", "numeric");
    this.pressure.getProperties().put("vkType", "numeric");
    this.zone.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.zone, newValue);
    });
    this.lineCount.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.lineCount, newValue);
    });
    this.windDirection.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.windDirection, newValue);
    });
    this.windSpeed.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.windSpeed, newValue);
    });
    this.temperature.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.temperature, newValue);
    });
    this.pressure.focusedProperty().addListener((observable, oldValue, newValue) -> {
      this.validateField(this.pressure, newValue);
    });
    this.cancel.setOnMouseClicked((event) -> {
      this.clearForm();
      Main.getAppController().changeUI(MenuNavEnum.WEATHER, true);
    });
    this.accept.setOnMouseClicked((event) -> {
      if (this.validateForm()) {
        this.formSubmit();
      } else {
        Main.getAppController().setInfoMessage("El formulario no esta diligenciado correctamente", "ERROR");
      }

    });
    this.clearForm();
    Weather weather;
    if (AppConfig.getInstance().getWeatherLine() != null) {
      weather = AppConfig.getInstance().getWeatherLine();
      this.zone.setText(String.valueOf(weather.getZone()));
      this.lineCount.setText(String.valueOf(weather.getStringLineNumber()));
      this.windDirection.setText(weather.getStringWindDirection());
      this.windSpeed.setText(weather.getStringWindSpeed());
      this.temperature.setText(weather.getStringTemperature());
      this.pressure.setText(weather.getStringPressure());
      AppConfig.getInstance().setWeatherLine((Weather)null);
    }

    if (AppConfig.getInstance().getWeatherLastLine() != null) {
      weather = AppConfig.getInstance().getWeatherLastLine();
      if (weather.getZone() == 0) {
        this.zone.setText(String.valueOf(weather.getZone() + 200));
      } else if (weather.getZone() == 200) {
        this.zone.setText(String.valueOf(weather.getZone() + 300));
      } else if (weather.getZone() >= 500 && weather.getZone() <= 5000) {
        this.zone.setText(String.valueOf(weather.getZone() + 500));
      } else if (weather.getZone() > 5000) {
        this.zone.setText(String.valueOf(weather.getZone() + 1000));
      }

      this.lineCount.setText(String.valueOf(weather.getLineNumber() + 1));
      this.windDirection.setText("000");
      this.windSpeed.setText("000");
      this.temperature.setText("0000");
      this.pressure.setText("0000");
      AppConfig.getInstance().setWeatherLastLine((Weather)null);
    }

  }

  private void validateField(Node field, boolean newValue) {
    AppConfig config = AppConfig.getInstance();
    TextField textField = (TextField)field;
    textField.getStyleClass().remove("error");
    if (field == this.zone && !newValue && !textField.getText().matches(MeasureExpression.REPORT_ZONE)) {
      textField.getStyleClass().add("error");
    }

    if (field == this.lineCount && !newValue && !textField.getText().matches(MeasureExpression.REPORT_NUMBER)) {
      textField.getStyleClass().add("error");
    }

    if (field == this.windDirection && !newValue && !textField.getText().matches(MeasureExpression.REPORT_DIR_SPEED)) {
      textField.getStyleClass().add("error");
    }

    if (field == this.windSpeed && !newValue && !textField.getText().matches(MeasureExpression.REPORT_DIR_SPEED)) {
      textField.getStyleClass().add("error");
    }

    if (field == this.temperature && !newValue && !textField.getText().matches(MeasureExpression.REPORT_TEMP_PRESS)) {
      textField.getStyleClass().add("error");
    }

    if (field == this.pressure && !newValue && !textField.getText().matches(MeasureExpression.REPORT_TEMP_PRESS)) {
      textField.getStyleClass().add("error");
    }

  }

  private void clearForm() {
    this.zone.setText("00000");
    this.lineCount.setText("00");
    this.windDirection.setText("000");
    this.windSpeed.setText("000");
    this.temperature.setText("0000");
    this.pressure.setText("0000");
  }

  private boolean validateForm() {
    this.validateField(this.zone, false);
    this.validateField(this.lineCount, false);
    this.validateField(this.windDirection, false);
    this.validateField(this.windSpeed, false);
    this.validateField(this.temperature, false);
    this.validateField(this.pressure, false);
    return !this.zone.getStyleClass().contains("error") && !this.lineCount.getStyleClass().contains("error") && !this.windDirection.getStyleClass().contains("error") && !this.temperature.getStyleClass().contains("error") && !this.pressure.getStyleClass().contains("error");
  }

  private void formSubmit() {
    Weather weatherLine = new Weather();
    weatherLine.setZone(this.zone.getText());
    weatherLine.setLineNumber(this.lineCount.getText());
    weatherLine.setWindDirection(this.windDirection.getText());
    weatherLine.setWindSpeed(this.windSpeed.getText());
    weatherLine.setTemperature(this.temperature.getText());
    weatherLine.setPressure(this.pressure.getText());

    try {
      WeatherService weatherService = new WeatherService();
      weatherService.createTableIfNotExists(Weather.class);
      weatherService.createOrUpdate(weatherLine);
      Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
      Main.getAppController().changeUI(MenuNavEnum.WEATHER, true);
    } catch (ClassNotFoundException | SQLException var4) {
      var4.printStackTrace();
      Main.getAppController().setInfoMessage("Error al guardar el blancoGeograficas", "ERROR");
    }

    Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
  }
}