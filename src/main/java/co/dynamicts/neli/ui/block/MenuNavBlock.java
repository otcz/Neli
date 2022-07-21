package co.dynamicts.neli.ui.block;

import co.dynamicts.Main;
import co.dynamicts.neli.core.sensors.events.DisplayKeyEvent;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

import java.awt.*;
import java.io.IOException;
import java.util.Locale;

public class MenuNavBlock extends StackPane {
  @FXML
  private VBox buttonsBox;
  @FXML
  private ImageView arrowsEs;
  @FXML
  private ImageView arrowsEn;
  private MenuNavEnum currentOption;
  private Robot robot;

  public MenuNavBlock() {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/blocks/menu.fxml"), AppConfig.getInstance().getResouce());
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setResources(AppConfig.getInstance().getResouce());

    try {
      fxmlLoader.load();
    } catch (IOException var3) {
      throw new RuntimeException(var3);
    }
  }

  public void initialize() {
    this.renderMenu((MenuNavEnum)null, false);

    try {
      this.robot = new Robot();
    } catch (AWTException var2) {
      var2.printStackTrace();
    }

  }

  private void renderMenu(MenuNavEnum parent) {
    this.renderMenu(parent, false);
  }

  public void renderMenu(MenuNavEnum parent, boolean skipTwoLevelFlag) {
    while(this.buttonsBox.getChildren().size() > 0) {
      this.buttonsBox.getChildren().remove(0);
    }

    int count = 1;
    if (!skipTwoLevelFlag && parent != null && parent.getTwoLevels()) {
      parent = parent.getParent().getParent();
    }

    MenuNavEnum[] var4 = MenuNavEnum.values();
    int var5 = var4.length;

    for(int var6 = 0; var6 < var5; ++var6) {
      MenuNavEnum option = var4[var6];
      if (option.getParent() == parent && option.getPrint()) {
        Button button = this.createButton(option.getTitle(), option.getIconPath(), count, (double)option.getSize());
        ++count;
        button.setUserData(option);
        button.setOnAction((event) -> {
          this.menuOptionHandler(event);
        });
        this.buttonsBox.getChildren().add(button);
        if (this.currentOption == null && option.getMenuId().equals(MenuNavEnum.HOME.getMenuId())) {
          this.currentOption = MenuNavEnum.HOME;
          button.getStyleClass().add("selected");
        } else if (this.currentOption.getMenuId().equals(option.getMenuId())) {
          button.getStyleClass().add("selected");
        }
      }
    }

    if (this.buttonsBox.getChildren().size() == 0) {
      if (parent.getParent() != null) {
        this.renderMenu(parent.getParent());
      } else {
        this.renderMenu((MenuNavEnum)null);
      }
    }

    if (Locale.getDefault() == Locale.ENGLISH) {
      this.arrowsEn.setVisible(true);
      this.arrowsEs.setVisible(!this.arrowsEn.isVisible());
    } else {
      this.arrowsEs.setVisible(true);
      this.arrowsEn.setVisible(!this.arrowsEs.isVisible());
    }

    this.arrowsEs.setManaged(this.arrowsEs.isVisible());
    this.arrowsEn.setManaged(this.arrowsEn.isVisible());
  }

  public void processDisplayKeyEvent(DisplayKeyEvent keyEvent) {
    int code = -1;
    switch (keyEvent.getCode()) {
      case DKF1:
        code = 0;
        break;
      case DKF2:
        code = 1;
        break;
      case DKF3:
        code = 2;
        break;
      case DKF4:
        code = 3;
        break;
      case DKF5:
        code = 4;
        break;
      case DKF6:
        code = 5;
        break;
      case DKF7:
        code = 6;
        break;
      case DKF8:
        code = 7;
        break;
      case DKF9:
        code = 8;
        break;
      case DKF10:
        code = 9;
        break;
      case DKF11:
        code = 10;
        break;
      case DKF12:
        code = 11;
    }

    this.processKeyCode(code);
  }

  public void processKeyEvent(KeyEvent key) {
    int code = -1;
    switch (key.getCode()) {
      case F1:
        code = 0;
        break;
      case F2:
        code = 1;
        break;
      case F3:
        code = 2;
        break;
      case F4:
        code = 3;
        break;
      case F5:
        code = 4;
        break;
      case F6:
        code = 5;
        break;
      case F7:
        code = 6;
        break;
      case F8:
        code = 7;
        break;
      case F9:
        code = 8;
        break;
      case F10:
        code = 9;
        break;
      case F11:
        code = 10;
        break;
      case F12:
        code = 11;
    }

    this.processKeyCode(code);
  }

  public void processKeyCode(int code) {
    if (code >= 0 && code < this.buttonsBox.getChildren().size()) {
      Button button = (Button)this.buttonsBox.getChildren().get(code);
      MenuNavEnum userData = (MenuNavEnum)button.getUserData();
      this.currentOption = userData;
      if (userData.getMenuId().equals(MenuNavEnum.HOME.getMenuId())) {
        this.renderMenu((MenuNavEnum)null);
      } else {
        this.renderMenu(userData);
      }

      Main.getAppController().getMenuBlock().fireEvent(userData, true);
    } else {
      if (this.robot == null) {
        return;
      }
      int posX = (int)MouseInfo.getPointerInfo().getLocation().getX();
      int posY = (int)MouseInfo.getPointerInfo().getLocation().getY();
      boolean moveIt = true;
      switch (code) {
        case 7:
          posY -= 15;
          break;
        case 8:
          posY += 15;
          break;
        case 9:
          posX -= 15;
          break;
        case 10:
          posX += 15;
          break;
        case 11:
          Platform.runLater(() -> {
            this.robot.mousePress(1024);
            this.robot.mouseRelease(1024);
          });
          moveIt = false;
      }

      if (moveIt) {
        int finalPosX = posX;
        int finalPosY = posY;
        Platform.runLater(() -> {
          this.robot.mouseMove(finalPosX, finalPosY);
        });
      }
    }

  }

  private void menuOptionHandler(ActionEvent event) {
    Button button = (Button)event.getSource();
    MenuNavEnum userData = (MenuNavEnum)button.getUserData();
    this.currentOption = userData;
    if (userData.getMenuId().equals(MenuNavEnum.HOME.getMenuId())) {
      this.renderMenu((MenuNavEnum)null);
    } else {
      this.renderMenu(userData);
    }

    Main.getAppController().changeUI(userData);
  }

  public void fireEvent(MenuNavEnum menu) {
    this.currentOption = menu;
    this.fireEvent(menu, false);
  }

  public void fireEvent(MenuNavEnum menu, boolean force) {
    this.currentOption = menu;
    if (menu.getMenuId().equals(MenuNavEnum.HOME.getMenuId())) {
      this.renderMenu((MenuNavEnum)null);
    } else {
      this.renderMenu(menu);
    }

    Main.getAppController().changeUI(menu, force);
  }

  public void fireEvent(MenuNavEnum menu, boolean force, boolean skipTwoLevelFlag) {
    this.currentOption = menu;
    if (menu.getMenuId().equals(MenuNavEnum.HOME.getMenuId())) {
      this.renderMenu((MenuNavEnum)null);
    } else {
      this.renderMenu(menu, skipTwoLevelFlag);
    }

    Main.getAppController().changeUI(menu, force);
  }

  public Button createButton(String text, String path, int funcId, double size) {
    Button button = new Button();
    button.setText(text);
    button.getStyleClass().add("icon-button");
    button.getStyleClass().add("func");
    button.getStyleClass().add("func-" + funcId);
    SVGPath icon = new SVGPath();
    icon.getStyleClass().add("icon");
    icon.setContent(path);
    icon.setStyle("-fill: #d8d8d8;");
    icon.setScaleX(size);
    icon.setScaleY(size);
    button.setGraphic(icon);
    return button;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\block\MenuNavBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */