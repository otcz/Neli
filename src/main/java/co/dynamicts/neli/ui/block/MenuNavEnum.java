package co.dynamicts.neli.ui.block;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.Sistema;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadCoordenadas;
import co.dynamicts.neli.ui.interfaces.BaseUserInterface;
import co.dynamicts.neli.ui.interfaces.InterfaceBuilder;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.application.Platform;

public enum MenuNavEnum {
  HOME((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.home";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.home");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.home");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("HOME");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  AIMING((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.aiming";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.aiming");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.aiming");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("COORDINATES_GEO") : InterfaceBuilder.create("COORDINATES_UTM");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  BACK_HOME_AIM(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.home";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.return");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.return");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("HOME");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  COORDINATES(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.aiming";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.coordinates");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.coordinates");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("COORDINATES_GEO") : InterfaceBuilder.create("COORDINATES_UTM");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  POLARS(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.polars";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.polars");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.polars");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("POLARS");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  COORDINATES_OBSERVER(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.observer";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.aiming.observer");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.polars.observer");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("COORDINATES_GEO_OBSERVER") : InterfaceBuilder.create("COORDINATES_UTM_OBSERVER");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  SHOOT(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.shoot";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.shoot");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.shoot");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("SHOOT");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  MOVING_TARGET(AIMING) {
    public boolean getPrint() {
      return Configuracion.getSingletonInstance().getSistema().equals(Sistema.OBUS_155);
    }

    public String getMenuId() {
      return "menu.main.moving.target";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.moving.target");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.moving.target");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("COORDINATES_GEO_MOVING_TARGET") : InterfaceBuilder.create("COORDINATES_UTM_MOVING_TARGET");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  TARGET_LIST(AIMING) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.target";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.target");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.target");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("TARGETS");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  CORRECTIONS((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.corrections";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.corrections");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.corrections");
    }

    public BaseUserInterface getInterface() {
      if (DatosCalculados.getSingletonInstance().isBlancoSetting()) {
        return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("CORRECTIONS_GEO") : InterfaceBuilder.create("CORRECTIONS_UTM");
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "Para acceder a esta ventana, primero debe establecer un Objetivo", "ERROR");
        });
        return InterfaceBuilder.create("HOME");
      }
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  GRAPHS((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.graphs";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.graphs");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.graphs");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("GRAPHS_GRID");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  BACK_HOME_GRAPHS(GRAPHS) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.home";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.return");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.return");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("HOME");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  GRAPHS_GRID(GRAPHS) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.graphs";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.graphs.grid");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.graphs.grid");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("GRAPHS_GRID");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  GRAPHS_TRAJECTORY(GRAPHS) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.graphs.trajectory";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.graphs.trajectory");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.graphs.trajectory");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("GRAPHS_TRAJECTORY");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  WEATHER((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.weather";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.weather");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.weather");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("WEATHER");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  LIMITS((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.limits";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.limits");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.limits");
    }

    public BaseUserInterface getInterface() {
      if (DatosCalculados.getSingletonInstance().isBlancoSetting()) {
        return InterfaceBuilder.create("LIMITS");
      } else {
        Platform.runLater(() -> {
          Main.getAppController().setInfoDialog("Error", "Para acceder a esta ventana, primero debe establecer un Objetivo", "ERROR");
        });
        return InterfaceBuilder.create("HOME");
      }
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  CONFIGURATION((MenuNavEnum)null) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.configuration";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.configuration");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.configuration");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("AMMO");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  BACK_HOME_CONFIGURATION(CONFIGURATION) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.home";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.return");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.return");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("HOME");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  AMMO(CONFIGURATION) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.configuration";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.ammo");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.ammo");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("AMMO");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.TRUE;
    }
  },
  CALIBRACION(CONFIGURATION) {
    public boolean getPrint() {
      return Configuracion.getSingletonInstance().getSistema().equals(Sistema.OBUS_155);
    }

    public String getMenuId() {
      return "menu.main.aiming";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.calibracion");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.calibracion");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("PAGINA_CALIBRACION");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  CMS(CONFIGURATION) {
    public boolean getPrint() {
      return Configuracion.getSingletonInstance().getSistema().equals(Sistema.OBUS_155);
    }

    public String getMenuId() {
      return "menu.main.cms";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.cms");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.cms");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("PAGINA_CMS");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  MUR(CONFIGURATION) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.radar";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.mvr");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.radar");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("RADAR");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  CPA(CONFIGURATION) {
    public boolean getPrint() {
      return Configuracion.getSingletonInstance().getSistema().equals(Sistema.OBUS_155);
    }

    public String getMenuId() {
      return "menu.main.cpa";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.cpa");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.cpa");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("PAGINA_PARAMETROS_CPA");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  AJUSTES(CONFIGURATION) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.ajustes";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.ajustes");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.ajustes");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("FORCED_COORDINATES_GEO") : InterfaceBuilder.create("FORCED_COORDINATES_UTM");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  BACK_CONFIGURATION(AJUSTES) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.configuration";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.return");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.return");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("AMMO");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.TRUE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  FORCED_COORDINATES(AJUSTES) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.ajustes";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.forced.coordinates");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.forced");
    }

    public BaseUserInterface getInterface() {
      return Configuracion.getSingletonInstance().getUnidadCoordenadas().equals(UnidadCoordenadas.GEOGRAFICAS) ? InterfaceBuilder.create("FORCED_COORDINATES_GEO") : InterfaceBuilder.create("FORCED_COORDINATES_UTM");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  UNITIES(AJUSTES) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.unities";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.unities");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.unities");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("UNITIES");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  },
  POWEROFF(AJUSTES) {
    public boolean getPrint() {
      return true;
    }

    public String getMenuId() {
      return "menu.main.poweroff";
    }

    public String getTitle() {
      return this.getStringFromResourceBundle("menu.main.poweroff");
    }

    public String getIconPath() {
      return this.getStringFromResourceBundle("svg.path.poweroff");
    }

    public BaseUserInterface getInterface() {
      return InterfaceBuilder.create("POWER_OFF");
    }

    public float getSize() {
      return 0.75F;
    }

    public Boolean getTwoLevels() {
      return Boolean.FALSE;
    }

    public Boolean getForceSkipHandler() {
      return Boolean.FALSE;
    }
  };

  private MenuNavEnum parent;

  private MenuNavEnum(MenuNavEnum parent) {
    this.parent = null;
    this.parent = parent;
  }

  public abstract boolean getPrint();

  public abstract String getMenuId();

  public abstract String getTitle();

  public abstract String getIconPath();

  public abstract BaseUserInterface getInterface();

  public abstract float getSize();

  public MenuNavEnum getParent() {
    return this.parent;
  }

  String getStringFromResourceBundle(String key) {
    return AppConfig.getInstance().getResouce().getString(key);
  }

  public abstract Boolean getTwoLevels();

  public abstract Boolean getForceSkipHandler();
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\nel\\ui\block\MenuNavEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */