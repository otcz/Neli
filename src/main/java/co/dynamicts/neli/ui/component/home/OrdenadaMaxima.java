package co.dynamicts.neli.ui.component.home;

import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.ui.component.common.Button;
import co.dynamicts.neli.ui.component.home.state.OrdenadaMaximaState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class OrdenadaMaxima extends VBox {
  public static final double REGLAWIDTH = 50.0D;
  
  public static final double REGLA_HEIGHT = 2828.0D;
  
  public static final int MAX_METERS = 27000;
  
  @FXML
  private ImageView reglaMetros;
  
  @FXML
  private ImageView reglaPies;
  
  @FXML
  private Text labelMetros;
  
  @FXML
  private Text labelFt;
  
  @FXML
  Button shotButton;
  
  @FXML
  Button aimButton;
  
  public Button getShotButton() {
    return this.shotButton;
  }
  
  public void setShotButton(Button shotButton) {
    this.shotButton = shotButton;
  }
  
  public Button getAimButton() {
    return this.aimButton;
  }
  
  public void setAimButton(Button aimButton) {
    this.aimButton = aimButton;
  }
  
  public OrdenadaMaxima() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/home/ordenada_maxima.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void updateState(OrdenadaMaximaState state) {
    double metrosPixel = 0.10474074074074075D;
    double calcularY = 2828.0D - metrosPixel * state.getOrdMax().doubleValue() - 70.0D;
    this.reglaMetros.setViewport(new Rectangle2D(0.0D, calcularY, 50.0D, 140.0D));
    double ftPixel = 2828.0D / state.metrosAPies(Double.valueOf(27000.0D)).doubleValue();
    double calcularYft = 2828.0D - ftPixel * state.getOrdMaxFt().doubleValue() - 70.0D;
    this.reglaPies.setViewport(new Rectangle2D(0.0D, calcularYft, 50.0D, 140.0D));
    String stringMetros = Integer.toString(state.getOrdMax().intValue());
    this.labelMetros.setText(stringMetros);
    String stringFt = Integer.toString(state.getOrdMaxFt().intValue());
    this.labelFt.setText(stringFt);
  }
  
  public ImageView getReglaMetros() {
    return this.reglaMetros;
  }
  
  public void setReglaMetros(ImageView reglaMetros) {
    this.reglaMetros = reglaMetros;
  }
  
  public ImageView getReglaPies() {
    return this.reglaPies;
  }
  
  public void setReglaPies(ImageView reglaPies) {
    this.reglaPies = reglaPies;
  }
  
  public Text getLabelMetros() {
    return this.labelMetros;
  }
  
  public void setLabelMetros(Text labelMetros) {
    this.labelMetros = labelMetros;
  }
  
  public Text getLabelFt() {
    return this.labelFt;
  }
  
  public void setLabelFt(Text labelFt) {
    this.labelFt = labelFt;
  }
  
  @FXML
  public void initialize() {
    this.shotButton.getButtonLabel().setText("Captura");
    this.aimButton.setText("Apuntar");
    this.shotButton.setImage("images/componentes/home/iconos/icono_disparar@2x.png");
    this.aimButton.setImage("images/componentes/home/iconos/icono_apuntar.png");
    if (!Configuracion.getSingletonInstance().getSistema().equals(Configuracion.Sistema.OBUS_155)) {
      this.shotButton.setVisible(false);
      this.aimButton.setVisible(false);
    } 
    updateState(
        OrdenadaMaximaState.builder()
        .withOrdMax(Double.valueOf(0.0D))
        .withOrdMax(Double.valueOf(0.0D))
        
        .build());
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\home\OrdenadaMaxima.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */