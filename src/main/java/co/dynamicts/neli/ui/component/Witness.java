package co.dynamicts.neli.ui.component;

import co.dynamicts.neli.ui.utils.AppConfig;
import co.dynamicts.neli.ui.utils.StringUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

import java.io.IOException;

public class Witness extends VBox {
  @FXML
  private Label titleLabel;
  
  @FXML
  private Label statusLabel;
  
  @FXML
  private SVGPath iconPath;
  
  public static final String CONNECTED = "connected";
  
  public static final String DISCONNECTED = "disconnected";
  
  public static final String NO_SIGNAL = "no signal";
  
  public static final String HIDDEN = "hidden";
  
  public static final SimpleStringProperty status = new SimpleStringProperty();
  
  public Witness() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/witness.fxml"));
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
  
  public ObservableList<Node> getChildren() {
    return super.getChildren();
  }
  
  public StringProperty titleProperty() {
    return this.titleLabel.textProperty();
  }
  
  public StringProperty statusProperty() {
    return status;
  }
  
  public String getTitle() {
    return titleProperty().get();
  }
  
  public void setTitle(String title) {
    titleProperty().set(title);
  }
  
  public String getStatus() {
    return statusProperty().get();
  }
  
  public void setStatus(String status) {
    statusProperty().set(status);
    if ("connected".equals(status)) {
      getStyleClass().remove("disconnected");
      getStyleClass().remove("no-signal");
      getStyleClass().remove("hidden");
      getStyleClass().add("connected");
      this.iconPath.setContent(StringUtil.translateKey("svg.path.signal"));
      this.statusLabel.setText(StringUtil.translateKey("label.connected"));
    } else if ("disconnected".equals(status)) {
      getStyleClass().remove("connected");
      getStyleClass().remove("no-signal");
      getStyleClass().remove("hidden");
      getStyleClass().add("disconnected");
      this.iconPath.setContent(StringUtil.translateKey("svg.path.no_signal"));
      this.statusLabel.setText(StringUtil.translateKey("label.disconnected"));
    } else if ("no signal".equals(status)) {
      getStyleClass().remove("connected");
      getStyleClass().remove("disconnected");
      getStyleClass().remove("hidden");
      getStyleClass().add("no-signal");
      this.iconPath.setContent(StringUtil.translateKey("svg.path.no_signal"));
      this.statusLabel.setText(StringUtil.translateKey("label.no_signal"));
    } else {
      getStyleClass().remove("connected");
      getStyleClass().remove("disconnected");
      getStyleClass().remove("no-signal");
      getStyleClass().add("hidden");
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\Witness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */