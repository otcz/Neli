package co.dynamicts.neli.ui.component.url;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.io.IOException;

public class ExternalURLSystemComponent extends AnchorPane {
  @FXML
  private Button refreshButton;
  
  @FXML
  private Button closeButton;
  
  @FXML
  private WebView urlWebView;
  
  @FXML
  private Label noUrlLabel;
  
  @FXML
  private ImageView refresh;
  
  @FXML
  private ImageView close;
  
  private String url;
  
  @FXML
  public void initialize() {
    this.url = "http://192.168.36.166";
    updateStatus();
    setLabel();
    this.refreshButton.setOnAction(event -> this.urlWebView.getEngine().reload());
    this.closeButton.setOnAction(event -> this.urlWebView.getEngine().reload());
  }
  
  public ExternalURLSystemComponent() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/sistemaURL/sistema_externo_url.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  private void setLabel() {
    StringBuilder text = new StringBuilder();
    text.append("Espacio para un iFrame.");
    text.append(",\n");
    text.append("Dirección por ser entregada");
    this.noUrlLabel.setText(text.toString());
  }
  
  public void updateStatus() {
    if (this.url == null || this.url.length() == 0) {
      this.urlWebView.setVisible(false);
      this.noUrlLabel.setVisible(true);
    } else {
      this.urlWebView.getEngine().load(this.url);
      this.urlWebView.setVisible(true);
      this.noUrlLabel.setVisible(false);
    } 
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\componen\\url\ExternalURLSystemComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */