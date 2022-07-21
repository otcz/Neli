//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.local.service.WeatherService;
import co.dynamicts.neli.core.models.Boletin;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Weather extends VBox implements BaseUserInterface, Initializable {
    @FXML
    private TableView<co.dynamicts.neli.core.local.model.Weather> weatherTable;
    @FXML
    private Button add;
    @FXML
    private Button edit;
    ArrayList<co.dynamicts.neli.core.local.model.Weather> weathers = new ArrayList();

    public Weather() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/weather.fxml"), AppConfig.getInstance().getResouce());
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void updateComponents() {
        Main.getAppController().topMenu().setVisible(true);
        Main.getAppController().topMenu().updateComponents();
        Boletin.getSingletonInstance().setBoletin();
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.updateComponents();
        this.add.setOnMouseClicked((event) -> {
            AppConfig.getInstance().setWeatherLastLine((co.dynamicts.neli.core.local.model.Weather)this.weathers.get(this.weathers.size() - 1));
            Main.getAppController().changeUIWithOutMenu(MenuNavEnum.WEATHER, "WEATHER_ADD", false);
        });
        this.edit.setOnMouseClicked((event) -> {
            TableView.TableViewSelectionModel model = this.weatherTable.getSelectionModel();
            Object selectedItem = model.getSelectedItem();
            if (selectedItem != null && selectedItem instanceof co.dynamicts.neli.core.local.model.Weather) {
                co.dynamicts.neli.core.local.model.Weather weather = (co.dynamicts.neli.core.local.model.Weather)selectedItem;
                AppConfig.getInstance().setWeatherLine(weather);
                Main.getAppController().changeUIWithOutMenu(MenuNavEnum.WEATHER, "WEATHER_ADD", false);
            }

        });
        this.weatherTable.setOnMouseClicked((event) -> {
            co.dynamicts.neli.core.local.model.Weather weather = (co.dynamicts.neli.core.local.model.Weather)this.weatherTable.getSelectionModel().getSelectedItem();
            if (weather != null) {
            }

        });
        this.loadWeatherReport();
    }

    private void loadWeatherReport() {
        try {
            WeatherService weatherService = new WeatherService();
            weatherService.createTableIfNotExists(co.dynamicts.neli.core.local.model.Weather.class);
            this.weathers = (ArrayList)weatherService.getList(co.dynamicts.neli.core.local.model.Weather.class);
            this.weatherTable.getItems().remove(0, this.weatherTable.getItems().size());
            this.weatherTable.getItems().addAll(this.weathers);
            this.weatherTable.refresh();
        } catch (ClassNotFoundException | SQLException var2) {
            var2.printStackTrace();
        }

    }
}
