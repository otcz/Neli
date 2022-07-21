package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language extends VBox implements BaseUserInterface, Initializable {
    @FXML
    private ComboBox<SimpleComboBoxItem> languageSelect;
    @FXML
    private Button cancel;
    @FXML
    private Button accept;

    public Language() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/language.fxml"), AppConfig.getInstance().getResouce());
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
        this.languageSelect.setConverter(stringConverter);
        this.languageSelect.getItems().add(new SimpleComboBoxItem("Español", Configuracion.Language.ESP));
        this.languageSelect.getItems().add(new SimpleComboBoxItem("English", Configuracion.Language.ENG));
        if (Configuracion.getSingletonInstance().getLanguage().equals(Configuracion.Language.ESP)) {
            this.languageSelect.getSelectionModel().select(0);
        } else if (Configuracion.getSingletonInstance().getLanguage().equals(Configuracion.Language.ENG)) {
            this.languageSelect.getSelectionModel().select(1);
        }

        this.cancel.setOnMouseClicked((event) -> {
            Main.getAppController().changeUI(MenuNavEnum.HOME);
        });
        this.accept.setOnMouseClicked((event) -> {
            Configuracion configuracion = Configuracion.getSingletonInstance();
            configuracion.setLanguage((Configuracion.Language)((SimpleComboBoxItem)this.languageSelect.getSelectionModel().getSelectedItem()).getData());
            configuracion.actualizaConfiguracion();
            if (Configuracion.Language.ESP.equals(configuracion.getLanguage())) {
                Locale.setDefault(new Locale("es", ""));
            } else {
                Locale.setDefault(new Locale("en", ""));
            }

            AppConfig.getInstance().setResouce(ResourceBundle.getBundle("language", Locale.getDefault()));
            Main.getAppController().getCoordinatesBlock().changeLanguage();
            Main.getAppController().topMenu().changeLanguage();
            Main.getAppController().getMenuBlock().fireEvent(MenuNavEnum.HOME, true);
            Main.getAppController().setInfoMessage("Datos procesados con exito", "INFO");
        });
    }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\interfaces\Language.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */