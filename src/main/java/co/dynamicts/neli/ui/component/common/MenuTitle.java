package co.dynamicts.neli.ui.component.common;

import co.dynamicts.neli.ui.provider.item.SimpleComboBoxItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MenuTitle extends VBox {
  @FXML
  private Label menuTitle;
  @FXML
  private ComboBox<SimpleComboBoxItem> menu;
  @FXML
  private Double menuWidth;
  private Object selectedValue;

  @FXML
  public void initialize() {
    this.setMenuWidth(268.0);
    this.menu.setConverter(new StringConverter<SimpleComboBoxItem>() {
      public String toString(SimpleComboBoxItem object) {
        return object.getText();
      }

      public SimpleComboBoxItem fromString(String string) {
        return new SimpleComboBoxItem(string, (Object)null);
      }
    });
    this.menu.valueProperty().addListener((observable, oldValue, newValue) -> {
      this.selectedValue = newValue.getData();
    });
  }

  public Double getMenuWidth() {
    return this.menuWidth;
  }

  public void setMenuWidth(Double menuWidth) {
    this.menuWidth = menuWidth;
    this.menu.setMaxWidth(this.menuWidth);
    this.menu.setPrefWidth(this.menuWidth);
    this.menu.setMinWidth(this.menuWidth);
  }

  public void setMenuItems(Map<String, String> comboItems) {
    this.menu.getItems().addAll((Collection)comboItems.entrySet().stream().map((entry) -> {
      return new SimpleComboBoxItem((String)entry.getValue(), entry.getKey());
    }).collect(Collectors.toSet()));
  }

  public MenuTitle() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/components/common/menu_title.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      var3.printStackTrace();
    }

  }

  public Label getMenuTitle() {
    return this.menuTitle;
  }

  public void setMenuTitle(Label menuTitle) {
    this.menuTitle = menuTitle;
  }

  public void setMenuTitleText(String text) {
    this.menuTitle.setText(text);
  }

  public ComboBox<SimpleComboBoxItem> getMenu() {
    return this.menu;
  }

  public void setMenu(ComboBox<SimpleComboBoxItem> menu) {
    this.menu = menu;
  }

  public Object getSelectedValue() {
    return ((SimpleComboBoxItem)this.menu.getSelectionModel().getSelectedItem()).getText();
  }

  public void setSelectedValue(String selectedValue) {
    this.menu.setValue(this.menu.getItems().stream().filter((item) -> {
      return item.getData().toString().equals(selectedValue);
    }).findFirst().orElseGet((Supplier)null));
    this.selectedValue = selectedValue;
  }

  public String getValue() {
    return this.menu.getValue() == null ? null : ((SimpleComboBoxItem)this.menu.getValue()).getData().toString();
  }
}