package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.neli.ui.component.ammunition.CPAParametersPage;
import co.dynamicts.neli.ui.component.calibration.CalibrationPage;
import co.dynamicts.neli.ui.component.cms.CMSPage;
import co.dynamicts.neli.ui.component.history.HistoryPage;
import co.dynamicts.neli.ui.component.moving_target.NewMovingTargetPage;
import co.dynamicts.neli.ui.interfaces.geo.*;

public class InterfaceBuilder {
  public static final String HOME = "HOME";
  public static final String AIM_COORDINATES_GEO = "COORDINATES_GEO";
  public static final String AIM_COORDINATES_UTM = "COORDINATES_UTM";
  public static final String AIM_COORDINATES_GEO_OBSERVER = "COORDINATES_GEO_OBSERVER";
  public static final String AIM_COORDINATES_UTM_OBSERVER = "COORDINATES_UTM_OBSERVER";
  public static final String AIM_POLARS = "POLARS";
  public static final String AIM_SHOOT = "SHOOT";
  public static final String AIM_COORDINATES_GEO_MOVING_TARGET = "COORDINATES_GEO_MOVING_TARGET";
  public static final String AIM_COORDINATES_UTM_MOVING_TARGET = "COORDINATES_UTM_MOVING_TARGET";
  public static final String TARGET_LIST = "TARGETS";
  public static final String TARGET_NAME = "TARGET_NAME";
  public static final String CORRECTIONS_GEO = "CORRECTIONS_GEO";
  public static final String CORRECTIONS_UTM = "CORRECTIONS_UTM";
  public static final String GRAPHS_TRAJECTORY = "GRAPHS_TRAJECTORY";
  public static final String GRAPHS_GRID = "GRAPHS_GRID";
  public static final String WEATHER = "WEATHER";
  public static final String WEATHER_ADD = "WEATHER_ADD";
  public static final String LIMITS = "LIMITS";
  public static final String CONFIG_AMMO = "AMMO";
  public static final String CONFIG_MAGNETIC_GEO = "MAGNETIC_GEO";
  public static final String CONFIG_MAGNETIC_UTM = "MAGNETIC_UTM";
  public static final String CONFIG_SENSOR = "SENSOR";
  public static final String CONFIG_STATISTICS = "STATISTICS";
  public static final String FORCED_COORDINATES_GEO = "FORCED_COORDINATES_GEO";
  public static final String FORCED_COORDINATES_UTM = "FORCED_COORDINATES_UTM";
  public static final String CONFIG_PORTS = "PORTS";
  public static final String CONFIG_HOST = "HOST";
  public static final String CONFIG_UNITIES = "UNITIES";
  public static final String CONFIG_LANGUAGE = "LANGUAGE";
  public static final String CONFIG_RADAR = "RADAR";
  public static final String CONFIG_RADAR_IMAGE = "IMAGE";
  public static final String POWEROFF = "POWER_OFF";
  public static final String PAGINA_CALIBRACION = "PAGINA_CALIBRACION";
  public static final String PAGINA_CPA_OFFSET = "PAGINA_CPA_OFFSET";
  public static final String PAGINA_HMS = "PAGINA_HMS";
  public static final String PAGINA_MUNICION = "PAGINA_MUNICION";
  public static final String PAGINA_EDITAR_MUNICION = "PAGINA_EDITAR_MUNICION";
  public static final String PAGINA_NUEVO_OBJETIVO_MOVIL = "PAGINA_NUEVO_OBJETIVO_MOVIL";
  public static final String PAGINA_PARAMETROS_CPA = "PAGINA_PARAMETROS_CPA";
  public static final String PAGINA_HISTORIAL = "PAGINA_HISTORIAL";
  public static final String PAGINA_CMS = "PAGINA_CMS";
  public static final String PAGINA_AJUSTES = "PAGINA_AJUSTES";
  public static final String PAGINA_EDITAR_MUNICION_155 = "PAGINA_AJUSTES_155";

  public InterfaceBuilder() {
  }

  public static BaseUserInterface create(String object) {
    if (object.equals("HOME")) {
      return new Home();
    } else if (object.equals("COORDINATES_GEO")) {
      return new Coordinates();
    } else if (object.equals("COORDINATES_UTM")) {
      return new co.dynamicts.neli.ui.interfaces.utm.Coordinates();
    } else if (object.equals("COORDINATES_GEO_OBSERVER")) {
      return new CoordinatesObserver();
    } else if (object.equals("COORDINATES_UTM_OBSERVER")) {
      return new co.dynamicts.neli.ui.interfaces.utm.CoordinatesObserver();
    } else if (object.equals("POLARS")) {
      return new Polars();
    } else if (object.equals("SHOOT")) {
      return new Shoot();
    } else if (object.equals("COORDINATES_GEO_MOVING_TARGET")) {
      return new CoordinatesMovilTarget();
    } else if (object.equals("COORDINATES_UTM_MOVING_TARGET")) {
      return new co.dynamicts.neli.ui.interfaces.utm.CoordinatesMovilTarget();
    } else if (object.equals("TARGETS")) {
      return new Targets();
    } else if (object.equals("TARGET_NAME")) {
      return new TargetName();
    } else if (object.equals("CORRECTIONS_GEO")) {
      return new Corrections();
    } else if (object.equals("CORRECTIONS_UTM")) {
      return new co.dynamicts.neli.ui.interfaces.utm.Corrections();
    } else if (object.equals("GRAPHS_TRAJECTORY")) {
      return new GraphsTrajectory();
    } else if (object.equals("GRAPHS_GRID")) {
      return new GraphsGrid();
    } else if (object.equals("WEATHER")) {
      return new Weather();
    } else if (object.equals("WEATHER_ADD")) {
      return new WeatherAdd();
    } else if (object.equals("LIMITS")) {
      return new Limits();
    } else if (object.equals("AMMO")) {
      return new Ammo();
    } else if (object.equals("MAGNETIC_GEO")) {
      return new Magnetic();
    } else if (object.equals("MAGNETIC_UTM")) {
      return new co.dynamicts.neli.ui.interfaces.utm.Magnetic();
    } else if (object.equals("SENSOR")) {
      return new Sensor();
    } else if (object.equals("STATISTICS")) {
      return new Statistics();
    } else if (object.equals("UNITIES")) {
      return new Units();
    } else if (object.equals("PORTS")) {
      return new Ports();
    } else if (object.equals("HOST")) {
      return new Host();
    } else if (object.equals("LANGUAGE")) {
      return new Language();
    } else if (object.equals("RADAR")) {
      return new Radar();
    } else if (object.equals("IMAGE")) {
      return new RadarHystoryView();
    } else if (object.equals("POWER_OFF")) {
      return new PowerOff();
    } else if (object.equals("PAGINA_CALIBRACION")) {
      return new CalibrationPage();
    } else if (object.equals("PAGINA_CPA_OFFSET")) {
      return new CPAOffset();
    } else if (object.equals("PAGINA_HMS")) {
      return new HMS();
    } else if (object.equals("PAGINA_NUEVO_OBJETIVO_MOVIL")) {
      return new NewMovingTargetPage();
    } else if (object.equals("PAGINA_PARAMETROS_CPA")) {
      return new CPAParametersPage();
    } else if (object.equals("PAGINA_HISTORIAL")) {
      return new HistoryPage();
    } else if (object.equals("PAGINA_CMS")) {
      return new CMSPage();
    } else if (object.equals("PAGINA_AJUSTES")) {
      return new Ajustes();
    } else if (object.equals("FORCED_COORDINATES_GEO")) {
      return new ForcedCoordinates();
    } else if (object.equals("FORCED_COORDINATES_UTM")) {
      return new co.dynamicts.neli.ui.interfaces.utm.ForcedCoordinates();
    } else {
      return object.equals("PAGINA_AJUSTES_155") ? new AmmoAdd() : null;
    }
  }
}