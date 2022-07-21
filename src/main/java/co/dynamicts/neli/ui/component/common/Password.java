package co.dynamicts.neli.ui.component.common;

import co.dynamicts.Main;
import co.dynamicts.neli.ui.block.MenuNavEnum;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Password extends StackPane {
  @FXML
  private Label textIngresarContrasena;
  
  @FXML
  private Label ingresar2;
  
  @FXML
  private Label textoAdvertencia;
  
  @FXML
  private PasswordField passwordField;
  
  @FXML
  private ButtonImage ingresarButton;
  
  @FXML
  private ButtonImage cancelarButton;
  
  @FXML
  private Button closeButton;
  
  private boolean contraseñaCorrecta = false;
  
  private String contraseña;
  
  private static Password password;
  
  public ButtonImage getIngresarButton() {
    return this.ingresarButton;
  }
  
  public ButtonImage getCancelarButton() {
    return this.cancelarButton;
  }
  
  public Label getIngresar2() {
    return this.ingresar2;
  }
  
  public void setTextIngresarContrasena(Label ingresar) {
    this.textIngresarContrasena = ingresar;
  }
  
  public void setIngresar2(Label ingresar2) {
    this.ingresar2 = ingresar2;
  }
  
  public void setTextoAdvertencia(Label textoAdvertencia) {
    this.textoAdvertencia = textoAdvertencia;
  }
  
  @FXML
  public void initialize() {
    setTitles();
    setContraseñaCorrecta(false);
    this.closeButton.setOnAction(event -> setVisible(false));
    this.cancelarButton.setOnAction(event -> setVisible(false));
    this.ingresarButton.setOnAction(event -> checkStatus());
  }
  
  public void setTitles() {
    this.textIngresarContrasena.setText("Ingresar contraseña para continuar");
    this.ingresar2.setText("Ingresar Contraseña");
    this.textoAdvertencia.setText("solo debe ingresar personal autorizado ");
    this.ingresarButton.setLabel("Ingresar");
    this.cancelarButton.setLabel("Cancelar");
  }
  
  public Password() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/components/common/password.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void checkStatus() {
    setContraseñaCorrecta(this.passwordField.getText().equals("123"));
    if (!isContraseñaCorrecta())
      setWrongStyle(); 
    if (isContraseñaCorrecta())
      Main.getAppController().changeUIWithOutMenu(MenuNavEnum.AMMO, "PAGINA_AJUSTES_155", false); 
    this.passwordField.setText("");
    setVisible(false);
  }
  
  public void setWrongStyle() {
    this.textoAdvertencia.setText("Clave incorrecta");
    this.passwordField.getStyleClass().clear();
    this.passwordField.getStyleClass().add("password-field-wrong");
    this.textoAdvertencia.getStyleClass().clear();
    this.textoAdvertencia.getStyleClass().add("texto-advertencia-wrong");
  }
  
  public void setNormalStyle(String textoAdvertencia) {
    this.textoAdvertencia.setText(textoAdvertencia);
    this.passwordField.getStyleClass().clear();
    this.passwordField.getStyleClass().add("password-field-wrong");
    this.textoAdvertencia.getStyleClass().clear();
    this.textoAdvertencia.getStyleClass().add("texto-advertencia");
  }
  
  public boolean isContraseñaCorrecta() {
    return this.contraseñaCorrecta;
  }
  
  public void setContraseñaCorrecta(boolean contraseñaCorrecta) {
    this.contraseñaCorrecta = contraseñaCorrecta;
  }
  
  public static Password getSingletonInstance() {
    if (password == null)
      password = new Password(); 
    return password;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\component\common\Password.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */