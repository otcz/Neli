package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.local.model.Ammunition;
import co.dynamicts.neli.core.local.model.Configuration;
import co.dynamicts.neli.core.local.service.AmmunitionService;
import co.dynamicts.neli.core.local.service.ConfigurationService;
import co.dynamicts.neli.core.municion.Espoleta;
import co.dynamicts.neli.core.municion.Municion;
import co.dynamicts.neli.core.municion.Zona;
import co.dynamicts.neli.core.utilities.DataTools;
import co.dynamicts.neli.ui.utils.AppConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Configuracion {
  private static Configuracion configuracion;
  
  public boolean isSimulado = true;
  
  public boolean isEthernet = true;
  
  public boolean isForPCSimulado = true;
  
  public boolean isPassword = false;
  
  public boolean isProduction = false;
  
  public String PuertoSerialINS = "COM7";
  
  public String PuertoSerialCPA = "COM14";
  
  public String PuertoSerialRadar = "COM13";
  
  private boolean isRasante = true;
  
  public double declinacionMagnetica = 100.0D;
  
  private UnidadDistancia unidadDistancia;
  
  private UnidadAngulo unidadAngulo;
  
  private UnidadCoordenadas unidadCoordenadas;
  
  private SensorModoZUPT sensorModoZUPT;
  
  private SensorGPS sensorGPS;
  
  private SensorOdometro sensorOdometro;
  
  private Language language;
  
  private TipoCalculo tipoCalculo;
  
  private Sistema sistema;
  
  private Criterio criterio;
  
  private String licencia = "EJC 001";
  
  public boolean firtTime = true;
  
  public String pieceNumber = "";
  
  public enum UnidadDistancia {
    METROS, KILOMETROS;
  }
  
  public enum UnidadAngulo {
    MILESIMAS, GRADOS;
  }
  
  public enum UnidadCoordenadas {
    GEOGRAFICAS, UTM;
  }
  
  public enum SensorModoZUPT {
    TIRO, TRANSPORTE, AEREO;
  }
  
  public enum SensorGPS {
    ACTIVO, INACTIVO;
  }
  
  public enum SensorOdometro {
    ACTIVO, INACTIVO;
  }
  
  public enum Language {
    ESP, ENG;
  }
  
  public enum TipoCalculo {
    NULL, COORDENADAS, POLARES, PUNTERIA, MOVIL;
  }
  
  public enum Sistema {
    OBUS_155, OBUS_105_LG, OBUS_105_L119;
  }
  
  public enum Criterio {
    VIDA_CANON, SUPERVIVENCIA, AJUSTE_DISTANCIA, MANUAL;
  }
  
  public Municion municion = new Municion();
  
  private double tempProp = 21.0D;
  
  private int cuadros = 3;
  
  private int cantidadMunicion = 1;
  
  private double alturaExplosion_m = 0.0D;
  
  private String tipoMunicion;
  
  private int indexEspoleta;
  
  private int indexCuadros = 2;
  
  private int indexMunicion;
  
  private int numeroZona;
  
  private boolean activaZone = false;
  
  double difPeso = 0.0D;
  
  private String tipoCarga = "M92";
  
  ArrayList<Configuration> configurations = new ArrayList<>();
  
  public ArrayList<Ammunition> ammunitions = new ArrayList<>();
  
  public Configuracion() {
    setUnidadAngulo(UnidadAngulo.MILESIMAS);
    setUnidadDistancia(UnidadDistancia.METROS);
    setUnidadCoordenadas(UnidadCoordenadas.GEOGRAFICAS);
    setUnidadAngulo(UnidadAngulo.MILESIMAS);
    setSensorModoZUPT(SensorModoZUPT.TIRO);
    setTipoCalculo(TipoCalculo.NULL);
    setLanguage(Language.ESP);
    setSistema(Sistema.OBUS_155);
    setCriterio(Criterio.VIDA_CANON);
    setAmmoList();
    setTipoMunicion(((Ammunition)this.ammunitions.get(0)).getNombreMunicion());
    setIndexEspoleta(0);
    setIndexCuadros(2);
    setNumeroZona(1);
    setPieceNumber("022");
    getSensorGPS();
    getSensorOdometro();
    cargaConfiguracionAlmacenada();
  }
  
  public void cargaConfiguracionAlmacenada() {
    try {
      ConfigurationService configurationService = new ConfigurationService();
      configurationService.createTableIfNotExists(Configuration.class);
      this.configurations = (ArrayList<Configuration>)configurationService.getList(Configuration.class);
      Configuration configuration = new Configuration();
      if (this.configurations.isEmpty()) {
        configuration.setLanguage(String.valueOf(getLanguage()));
        configuration.setFirstTime(isFirtTime());
        configuration.setSistema(String.valueOf(getSistema()));
        configuration.setPieceNumber(getPieceNumber());
        configuration.setUniCoordenada(String.valueOf(getUnidadCoordenadas()));
        configuration.setUniAngulo(String.valueOf(getUnidadAngulo()));
        configuration.setUniDistancia(String.valueOf(getUnidadDistancia()));
        configuration.setTipoMunicion(getTipoMunicion());
        configuration.setCantidadMunicion(getCantidadMunicion());
        configuration.setIndexEspoletaMunicion(getIndexEspoleta());
        configuration.setAlturaExplosionMunicion(getAlturaExplosion_m());
        configuration.setIndexCuadrosMunicion(getIndexCuadros());
        configuration.setNumeroZona(getNumeroZona());
        configuration.setTempMunicion(getTempProp());
        configuration.setModoZUPT(String.valueOf(getSensorModoZUPT()));
        configuration.setDate(new Date());
        configurationService.createOrUpdate(configuration);
        cargaConfiguracionAlmacenada();
      } else {
        configuration = this.configurations.get(0);
        AppConfig.getInstance().setConfiguration(configuration);
        if (AppConfig.getInstance().getConfiguration().getLanguage().equals(String.valueOf(Language.ESP))) {
          setLanguage(Language.ESP);
        } else if (AppConfig.getInstance().getConfiguration().getLanguage().equals(String.valueOf(Language.ENG))) {
          setLanguage(Language.ENG);
        } 
        if (AppConfig.getInstance().getConfiguration().isFirstTime()) {
          setFirtTime(true);
        } else if (!AppConfig.getInstance().getConfiguration().isFirstTime()) {
          setFirtTime(false);
        } 
        if (AppConfig.getInstance().getConfiguration().getSistema().equals(String.valueOf(Sistema.OBUS_155))) {
          setSistema(Sistema.OBUS_155);
        } else if (AppConfig.getInstance().getConfiguration().getSistema().equals(String.valueOf(Sistema.OBUS_105_LG))) {
          setSistema(Sistema.OBUS_105_LG);
        } else if (AppConfig.getInstance().getConfiguration().getSistema().equals(String.valueOf(Sistema.OBUS_105_L119))) {
          setSistema(Sistema.OBUS_105_L119);
        } 
        setPieceNumber(AppConfig.getInstance().getConfiguration().getPieceNumber());
        if (AppConfig.getInstance().getConfiguration().getUniDistancia().equals(String.valueOf(UnidadDistancia.METROS))) {
          setUnidadDistancia(UnidadDistancia.METROS);
        } else if (AppConfig.getInstance().getConfiguration().getUniDistancia().equals(String.valueOf(UnidadDistancia.KILOMETROS))) {
          setUnidadDistancia(UnidadDistancia.KILOMETROS);
        } 
        if (AppConfig.getInstance().getConfiguration().getUniAngulo().equals(String.valueOf(UnidadAngulo.MILESIMAS))) {
          setUnidadAngulo(UnidadAngulo.MILESIMAS);
        } else if (AppConfig.getInstance().getConfiguration().getUniAngulo().equals(String.valueOf(UnidadAngulo.GRADOS))) {
          setUnidadAngulo(UnidadAngulo.GRADOS);
        } 
        if (AppConfig.getInstance().getConfiguration().getUniCoordenada().equals(String.valueOf(UnidadCoordenadas.GEOGRAFICAS))) {
          setUnidadCoordenadas(UnidadCoordenadas.GEOGRAFICAS);
        } else if (AppConfig.getInstance().getConfiguration().getUniCoordenada().equals(String.valueOf(UnidadCoordenadas.UTM))) {
          setUnidadCoordenadas(UnidadCoordenadas.UTM);
        } 
        if (AppConfig.getInstance().getConfiguration().getModoZUPT().equals(String.valueOf(SensorModoZUPT.TRANSPORTE))) {
          setSensorModoZUPT(SensorModoZUPT.TRANSPORTE);
        } else if (AppConfig.getInstance().getConfiguration().getModoZUPT().equals(String.valueOf(SensorModoZUPT.AEREO))) {
          setSensorModoZUPT(SensorModoZUPT.AEREO);
        } else if (AppConfig.getInstance().getConfiguration().getModoZUPT().equals(String.valueOf(SensorModoZUPT.TIRO))) {
          setSensorModoZUPT(SensorModoZUPT.TIRO);
        } 
        int i;
        for (i = 0; i < this.ammunitions.size(); i++) {
          if (((Ammunition)this.ammunitions.get(i)).getNombreMunicion().equals(AppConfig.getInstance().getConfiguration().getTipoMunicion()))
            setIndexMunicion(i); 
        } 
        setMunicion(((Ammunition)this.ammunitions.get(getIndexMunicion())).getMunicion());
        this.municion.espoletaSelect = (Espoleta) this.municion.espoletas.get(AppConfig.getInstance().getConfiguration().getIndexEspoletaMunicion());
        for (i = 0; i < this.municion.zonas.size(); i++) {
          Zona zoneAux = (Zona) this.municion.zonas.get(i);
          if (AppConfig.getInstance().getConfiguration().getNumeroZona() == zoneAux.getNumero())
            this.municion.zonaSelec = (Zona) this.municion.zonas.get(i);
        } 
        this.municion.setCantidad(AppConfig.getInstance().getConfiguration().getCantidadMunicion());
        setCuadros(AppConfig.getInstance().getConfiguration().getIndexCuadrosMunicion() + 1);
        setTempProp(AppConfig.getInstance().getConfiguration().getTempMunicion());
        setIndexEspoleta(AppConfig.getInstance().getConfiguration().getIndexEspoletaMunicion());
        setCantidadMunicion(AppConfig.getInstance().getConfiguration().getCantidadMunicion());
        setNumeroZona(AppConfig.getInstance().getConfiguration().getNumeroZona());
        setTipoMunicion(AppConfig.getInstance().getConfiguration().getTipoMunicion());
        setTipoCarga(this.municion.zonaSelec.getPropName());
        double pesoProyectil = this.municion.getPesoProyectil(getCuadros());
        Espoleta espoletaStandar = (Espoleta) this.municion.espoletas.get(0);
        this.difPeso = pesoProyectil - this.municion.getPesoProyectil() + espoletaStandar.getPeso();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public void actualizaConfiguracion() {
    ConfigurationService configurationService = null;
    try {
      configurationService = new ConfigurationService();
      configurationService.createTableIfNotExists(Configuration.class);
      Configuration configuration = new Configuration();
      configuration.setLanguage(String.valueOf(getLanguage()));
      configuration.setFirstTime(isFirtTime());
      configuration.setSistema(String.valueOf(getSistema()));
      configuration.setPieceNumber(getPieceNumber());
      configuration.setUniCoordenada(String.valueOf(getUnidadCoordenadas()));
      configuration.setUniAngulo(String.valueOf(getUnidadAngulo()));
      configuration.setUniDistancia(String.valueOf(getUnidadDistancia()));
      configuration.setTipoMunicion(getTipoMunicion());
      configuration.setCantidadMunicion(getCantidadMunicion());
      configuration.setIndexEspoletaMunicion(getIndexEspoleta());
      configuration.setAlturaExplosionMunicion(getAlturaExplosion_m());
      configuration.setIndexCuadrosMunicion(getIndexCuadros());
      configuration.setNumeroZona(getNumeroZona());
      configuration.setTempMunicion(getTempProp());
      configuration.setModoZUPT(String.valueOf(getSensorModoZUPT()));
      configuration.setDate(new Date());
      configurationService.deleteById(Configuration.class, AppConfig.getInstance().getConfiguration().getLanguage());
      configurationService.createOrUpdate(configuration);
      AppConfig.getInstance().setConfiguration(configuration);
      cargaConfiguracionAlmacenada();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public void setAmmoList() {
    try {
      AmmunitionService ammunitionService = new AmmunitionService();
      ammunitionService.createTableIfNotExists(Ammunition.class);
      this.ammunitions = (ArrayList<Ammunition>)ammunitionService.getList(Ammunition.class);
      if (this.ammunitions.isEmpty()) {
        if (getSistema().equals(Sistema.OBUS_155)) {
          Ammunition ammunitionBT155 = new Ammunition();
          ammunitionBT155.setNombreMunicion("M1 ERFB BT");
          ammunitionBT155.setEfectoMunicion("HE");
          ammunitionBT155.setIndexMunicionPesoSTD(2);
          ammunitionBT155.setIndexMunicionNumZonas(5);
          ammunitionBT155.setZonesSelected(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6 }));
          ammunitionBT155.setMunicionBB(1);
          ammunitionBT155.setIndexEspoletas(2);
          ammunitionBT155.setManejoMunicion("155,44.09,0.5,0.145140007138252,20,0.00,0.00");
          ammunitionBT155.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.00999999977648258D, 0.800000011920928D, 0.899999976158142D, 0.949999988079071D, 1.0D, 1.02499997615814D, 1.04999995231628D, 1.10000002384185D, 1.20000004768371D, 1.5D, 
                  1.75D, 2.0D, 2.5D, 3.0D, 4.0D }));
          ammunitionBT155.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.156000000321865D, 0.150000004589557D, 0.154999998882412D, 0.215999994039526D, 0.265999972820282D, 0.289000010907648D, 0.29199998514354D, 0.293999999970197D, 0.285999997615815D, 0.257000070065259D, 
                  0.239999990910291D, 0.223999992012977D, 0.20299999974668D, 0.180999994277954D, 0.151000000536441D }));
          ammunitionBT155.setCdaArray(DataTools.toStringDouble(new double[] { 
                  1.48500001430511D, 1.83500002324581D, 2.21299987363816D, 2.43599998402596D, 2.66599988937378D, 2.83399972391128D, 3.00099948978422D, 3.33799953460694D, 3.65800021350381D, 2.83600473403931D, 
                  2.46700027585031D, 2.21800005435943D, 1.725999802351D, 1.43699997663497D, 1.16999995708466D }));
          ammunitionBT155.setClArray(DataTools.toStringDouble(new double[] { 
                  1.51999998092651D, 1.42499998521804D, 1.32999997615814D, 1.23500000715255D, 1.2829999923706D, 1.31099998068809D, 1.329999958992D, 1.37799999618529D, 1.52000001585482D, 1.90499992668628D, 
                  1.9479999653995D, 2.0900000333786D, 2.18500003218651D, 2.18499994277954D, 0.0D }));
          ammunitionBT155.setClaArray(DataTools.toStringDouble(new double[15]));
          ammunitionBT155.setCmArray(DataTools.toStringDouble(new double[] { 
                  3.51999998092651D, 4.29000003576278D, 4.61999985456466D, 4.61999988555908D, 4.50999999046326D, 4.46000027656555D, 4.40000009059907D, 4.28999993324282D, 4.1799999189377D, 4.02000050246715D, 
                  3.96000012382864D, 3.90999993681908D, 3.85000010207296D, 3.84999990463256D, 3.84999990463256D }));
          ammunitionBT155.setCmaArray(DataTools.toStringDouble(new double[] { 
                  2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 
                  2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D, 2.8499999046325684D }));
          ammunitionBT155.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -1.067999958992D, -1.067999958992D, -1.19199997657537D, -1.50099987769127D, -1.37700009346008D, -1.3140001540184D, -1.25399994373323D, -1.19199995422364D, -1.06799992370606D, -1.067999958992D, 
                  -1.067999958992D, -1.46799996495246D, -1.067999958992D, -1.067999958992D, -1.067999958992D }));
          ammunitionBT155.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, 
                  -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D, -0.0350000001490116D }));
          ammunitionBT155.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setiArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setMcbArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setScArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBT155.setVelArray(DataTools.toStringDouble(new double[] { 313.0D, 466.0D, 542.0D, 673.0D, 801.0D, 924.0D, 0.0D }));
          ammunitionBT155.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBT155.getVelArray())));
          ammunitionBT155.setAjFDArray(DataTools.toStringDouble(new double[] { 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 0.0D }));
          ammunitionBT155.setAjFMagArray(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.0D }));
          ammunitionBT155.setAjFLA0Array(DataTools.toStringDouble(new double[] { 5.02143495972667D, 3.0842583574455D, 3.09282371708675D, 3.50981758935327D, -0.00598871230544033D, 2.9302555849174D, 0.0D }));
          ammunitionBT155.setAjFLA1Array(DataTools.toStringDouble(new double[] { -0.0101971837717922D, -0.00124169443121745D, -0.00497157234831376D, -0.00886495071842432D, 0.0126518361143976D, -0.003302980376D, 0.0D }));
          ammunitionBT155.setAjFLA2Array(DataTools.toStringDouble(new double[] { 7.84650059511888E-6D, -9.86349028355375E-6D, 4.25942530985788E-6D, 1.6066742492675E-5D, -4.84080101802544E-5D, 7.29468828338727E-6D, 0.0D }));
          ammunitionBT155.setAjFLA3Array(DataTools.toStringDouble(new double[] { -1.76270218806E-9D, 1.536959162524E-8D, -1.74766262289E-9D, -1.368573580435E-8D, 7.78393737848E-8D, -8.01035001797E-9D, 0.0D }));
          ammunitionBT155.setAjFLA4Array(DataTools.toStringDouble(new double[] { 2.5487569E-13D, -6.03933686E-12D, 7.6913759E-13D, 4.55331078E-12D, -4.393050236E-11D, 3.30747765E-12D, 0.0D }));
          ammunitionBT155.setAjiA0Array(DataTools.toStringDouble(new double[] { 1.3979142082058D, 1.15113530010149D, 0.994400980236653D, 1.05325674125154D, 1.00575022892947D, 0.951823402023335D, 0.0D }));
          ammunitionBT155.setAjiA1Array(DataTools.toStringDouble(new double[] { -0.00165921256543319D, -3.63211532726752E-4D, 6.24587072498634E-4D, -1.67352222753047E-4D, -2.84861558776013E-4D, 4.23352332621047E-4D, 0.0D }));
          ammunitionBT155.setAjiA2Array(DataTools.toStringDouble(new double[] { 4.08916143198399E-6D, 7.841778474092E-7D, -1.92680076315591E-6D, 2.8028249361548E-7D, 1.68137771538164E-6D, -9.7880825685205E-7D, 0.0D }));
          ammunitionBT155.setAjiA3Array(DataTools.toStringDouble(new double[] { -4.74977689881E-9D, -8.4761437838E-10D, 2.4345230642E-9D, 1.4514117075E-10D, -3.63495534322E-9D, 1.0772689032E-9D, 0.0D }));
          ammunitionBT155.setAjiA4Array(DataTools.toStringDouble(new double[] { 2.04268604E-12D, 3.6526842E-13D, -1.049209E-12D, -2.3571559E-13D, 2.58772193E-12D, -4.3450267E-13D, 0.0D }));
          ammunitionBT155.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.0D }));
          ammunitionBT155.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setPropArray("M91,M91,M92,M92,M92,M92, ");
          ammunitionBT155.setGradTempArray(DataTools.toStringDouble(new double[] { 0.022D, 0.117D, 0.683D, 0.764D, 0.846D, 0.93D, 0.0D }));
          ammunitionBT155.setPesoVelArray(DataTools.toStringDouble(new double[] { -0.542D, -0.451D, -0.227D, -0.168D, -0.279D, -0.258D, 0.0D }));
          ammunitionBT155.setQemaxrArray(DataTools.toStringDouble(new double[] { 780.6D, 797.2D, 805.2D, 820.8D, 864.7D, 928.3D, 0.0D }));
          ammunitionBT155.setKpArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbB2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setFibbB3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setTbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT155.setEspoletas("M841A3,0.77,PDM,M9121,0.81,PROX,M9801,0.8,MOFA");
          ammunitionBT155.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D }));
          ammunitionBT155.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBT155.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBT155);
          Ammunition ammunitionBB155 = new Ammunition();
          ammunitionBB155.setNombreMunicion("M1 ERFB BB");
          ammunitionBB155.setEfectoMunicion("HE");
          ammunitionBB155.setIndexMunicionPesoSTD(2);
          ammunitionBB155.setIndexMunicionNumZonas(0);
          ammunitionBB155.setZonesSelected(DataTools.toStringInt(new int[] { 6 }));
          ammunitionBB155.setMunicionBB(0);
          ammunitionBB155.setIndexEspoletas(0);
          ammunitionBB155.setManejoMunicion("155,46.54,0.5,0.15027999877929688,20,0.00,0.00");
          ammunitionBB155.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.3D, 0.73D, 0.9D, 0.95D, 1.0D, 1.1D, 1.3D, 1.5D, 1.8D, 2.1D, 
                  2.3D, 2.5D, 2.7D, 2.9D, 3.1D }));
          ammunitionBB155.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.13D, 0.13D, 0.13D, 0.13D, 0.13D, 0.197D, 0.292D, 0.272D, 0.25D, 0.233D, 
                  0.223D, 0.214D, 0.207D, 0.202D, 0.201D }));
          ammunitionBB155.setCdaArray(DataTools.toStringDouble(new double[] { 
                  3.62D, 3.62D, 3.62D, 3.62D, 3.62D, 3.68D, 3.75D, 4.12D, 4.45D, 4.7D, 
                  4.87D, 5.0D, 5.1D, 5.15D, 5.1D }));
          ammunitionBB155.setClArray(DataTools.toStringDouble(new double[] { 
                  1.68D, 1.68D, 1.68D, 1.69D, 1.71D, 1.68D, 1.63D, 1.79D, 1.98D, 2.13D, 
                  2.2D, 2.25D, 2.29D, 2.349D, 2.35D }));
          ammunitionBB155.setClaArray(DataTools.toStringDouble(new double[] { 
                  0.98D, 0.746948D, 0.57314D, 0.52202D, 0.4709D, 0.36866D, 0.16418D, -0.0402999999999998D, -0.34702D, -0.65374D, 
                  -0.85822D, -1.0627D, -1.26718D, -1.47166D, -1.47D }));
          ammunitionBB155.setCmArray(DataTools.toStringDouble(new double[] { 
                  3.02D, 3.02D, 3.02D, 3.02D, 3.02D, 3.15D, 3.33D, 3.37D, 3.81D, 3.6D, 
                  3.49D, 3.55D, 3.6D, 3.65D, 3.65D }));
          ammunitionBB155.setCmaArray(DataTools.toStringDouble(new double[] { 
                  2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 2.849D, 
                  2.849D, 2.849D, 2.849D, 2.849D, 2.849D }));
          ammunitionBB155.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, -2.29D, 
                  -2.29D, -2.29D, -2.29D, -2.29D, -2.29D }));
          ammunitionBB155.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.033D, -0.032D, -0.031D, -0.0305D, -0.0302D, -0.03D, -0.028D, -0.043D, -0.042D, -0.041D, 
                  -0.04D, -0.039D, -0.039D, -0.039D, -0.039D }));
          ammunitionBB155.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.016D, 0.016D, 0.016D, 0.016D, 0.02D, 0.072D, 0.093D, 0.0865D, 0.084D, 0.078D, 
                  0.072D, 0.066D, 0.058D, 0.052D, 0.051D }));
          ammunitionBB155.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setiArray(DataTools.toStringDouble(new double[] { 
                  0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 
                  0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D, 0.0040000001899898D }));
          ammunitionBB155.setMcbArray(DataTools.toStringDouble(new double[] { 0.0D, 0.71D, 0.93D, 1.0D, 1.026D }));
          ammunitionBB155.setScArray(DataTools.toStringDouble(new double[] { 0.019D, 0.0184D, 0.01264D, 0.00637D, -1.7E-4D }));
          ammunitionBB155.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBB155.setVelArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 913.0D, 0.0D }));
          ammunitionBB155.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBB155.getVelArray())));
          ammunitionBB155.setAjFDArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.05D, 0.0D }));
          ammunitionBB155.setAjFMagArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.5D, 0.0D }));
          ammunitionBB155.setAjFLA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.82926434515516D, 0.0D }));
          ammunitionBB155.setAjFLA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.00399058662876683D, 0.0D }));
          ammunitionBB155.setAjFLA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -9.94795108323931E-6D, 0.0D }));
          ammunitionBB155.setAjFLA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.123970085622E-8D, 0.0D }));
          ammunitionBB155.setAjFLA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -4.56049421E-12D, 0.0D }));
          ammunitionBB155.setAjiA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.892193528990798D, 0.0D }));
          ammunitionBB155.setAjiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -1.06449960368835E-4D, 0.0D }));
          ammunitionBB155.setAjiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.82198116569903E-6D, 0.0D }));
          ammunitionBB155.setAjiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -3.34677420375E-9D, 0.0D }));
          ammunitionBB155.setAjiA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.66352799E-12D, 0.0D }));
          ammunitionBB155.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D }));
          ammunitionBB155.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setPropArray(" , , , , ,M92, ");
          ammunitionBB155.setGradTempArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.4564D, 0.0D }));
          ammunitionBB155.setPesoVelArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -0.52D, 0.0D }));
          ammunitionBB155.setQemaxrArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 915.4D, 0.0D }));
          ammunitionBB155.setKpArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.33399999141693D, 0.0D }));
          ammunitionBB155.setFibbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.974D, 0.0D }));
          ammunitionBB155.setFibbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -2.00699996639741E-5D, 0.0D }));
          ammunitionBB155.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 5.53086977106431E-7D, 0.0D }));
          ammunitionBB155.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -4.04601990799946E-10D, 0.0D }));
          ammunitionBB155.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setFibbB2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setFibbB3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 39.0D, 0.0D }));
          ammunitionBB155.setTbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setTbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB155.setEspoletas("M841A3,0.77,PDM,M9121,0.81,PROX,M9801,0.8,MOFA");
          ammunitionBB155.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.012D, 1.025D, 1525.0D, 0.618499D, 0.610499D, 1.43099999427795D, 0.00139999995008111D, 3.71850006786189E-7D, 0.660000026226043D, 0.139300003647804D, 
                  1.31D }));
          ammunitionBB155.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBB155.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBB155);
        } else if (getSistema().equals(Sistema.OBUS_105_LG)) {
          Ammunition ammunitionBT105LG = new Ammunition();
          ammunitionBT105LG.setNombreMunicion("HE-M1");
          ammunitionBT105LG.setEfectoMunicion("HE");
          ammunitionBT105LG.setIndexMunicionPesoSTD(2);
          ammunitionBT105LG.setIndexMunicionNumZonas(6);
          ammunitionBT105LG.setZonesSelected(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBT105LG.setMunicionBB(1);
          ammunitionBT105LG.setIndexEspoletas(0);
          ammunitionBT105LG.setManejoMunicion("105,14.97,0.28,0.0178932,16,0.00,0.00");
          ammunitionBT105LG.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.06D, 0.7D, 0.8D, 0.875D, 0.925D, 0.95D, 0.975D, 1.0D, 1.025D, 1.05D, 
                  1.1D, 1.35D, 1.75D, 2.25D, 3.0D }));
          ammunitionBT105LG.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.159D, 0.162D, 0.173D, 0.191D, 0.228D, 0.262D, 0.307D, 0.355D, 0.382D, 0.4D, 
                  0.398D, 0.364D, 0.322D, 0.278D, 0.238D }));
          ammunitionBT105LG.setCdaArray(DataTools.toStringDouble(new double[] { 
                  4.03D, 4.28D, 4.51D, 4.85D, 5.25D, 5.49D, 5.75D, 6.0D, 6.25D, 6.5D, 
                  7.05D, 7.12D, 6.29D, 5.58D, 4.77D }));
          ammunitionBT105LG.setClArray(DataTools.toStringDouble(new double[] { 
                  1.69D, 1.66D, 1.68D, 1.74D, 1.82D, 1.86D, 1.86D, 1.82D, 1.8D, 1.81D, 
                  1.87D, 2.11D, 2.37D, 2.57D, 2.57D }));
          ammunitionBT105LG.setClaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setCmArray(DataTools.toStringDouble(new double[] { 
                  2.807D, 2.825D, 2.918D, 3.074D, 3.309D, 3.409D, 3.414D, 3.34D, 3.249D, 3.199D, 
                  3.204D, 3.26D, 2.816D, 2.661D, 2.542D }));
          ammunitionBT105LG.setCmaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -0.69D, -0.7D, -0.72D, -0.75D, -0.87D, -0.99D, -0.88D, -0.81D, -0.77D, -0.74D, 
                  -0.69D, -0.56D, -0.52D, -0.48D, -0.48D }));
          ammunitionBT105LG.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.0214D, -0.0211D, -0.0209D, -0.0208D, -0.02D, -0.0198D, -0.02D, -0.0204D, -0.0201D, -0.0197D, 
                  -0.0189D, -0.0172D, -0.0151D, -0.0135D, -0.0113D }));
          ammunitionBT105LG.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setiArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setMcbArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setScArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBT105LG.setVelArray(DataTools.toStringDouble(new double[] { 202.0D, 220.0D, 241.0D, 274.0D, 314.0D, 381.0D, 485.0D }));
          ammunitionBT105LG.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBT105LG.getVelArray())));
          ammunitionBT105LG.setAjFDArray(DataTools.toStringDouble(new double[] { 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 1.03D }));
          ammunitionBT105LG.setAjFMagArray(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D }));
          ammunitionBT105LG.setAjFLA0Array(DataTools.toStringDouble(new double[] { 1.35389285713801D, 0.877272727270524D, 0.814121212118571D, 1.62260606060344D, 1.31027272727094D, 1.45557575757389D, 1.22715151514992D }));
          ammunitionBT105LG.setAjFLA1Array(DataTools.toStringDouble(new double[] { -0.0085234108946386D, -0.00140054972804365D, -0.00459013014761989D, -0.00796149184148134D, -0.00221226884226731D, -0.0031056468531449D, -2.81013986015113E-4D }));
          ammunitionBT105LG.setAjFLA2Array(DataTools.toStringDouble(new double[] { 4.80285984848255E-5D, 1.39569055943876E-5D, 2.83531759906441E-5D, 3.23579836829511E-5D, 7.45221445221368E-6D, 9.02922494172219E-6D, 3.368298368835E-8D }));
          ammunitionBT105LG.setAjFLA3Array(DataTools.toStringDouble(new double[] { -8.345328282828E-8D, -2.38063325563E-8D, -4.213500388495E-8D, -4.287529137525E-8D, -8.76029526029E-9D, -9.67307692307E-9D, 9.7552447553E-10D }));
          ammunitionBT105LG.setAjFLA4Array(DataTools.toStringDouble(new double[] { 4.5625E-11D, 1.14539627E-11D, 1.865675991E-11D, 1.78962704E-11D, 3.39160839E-12D, 3.48776224E-12D, -6.8764569E-13D }));
          ammunitionBT105LG.setAjiA0Array(DataTools.toStringDouble(new double[] { 0.490714285712218D, 0.0996969696958704D, 0.286303030301791D, 0.754606060604592D, 0.516454545453732D, 1.00227272727158D, 1.0778787878776D }));
          ammunitionBT105LG.setAjiA1Array(DataTools.toStringDouble(new double[] { -0.00629436147186032D, 0.00145576923076946D, 8.37698135199753E-4D, -0.00296698135197587D, 3.95034965033174E-4D, -0.0010159129759123D, -2.36546231547241E-4D }));
          ammunitionBT105LG.setAjiA2Array(DataTools.toStringDouble(new double[] { 3.8479166666669E-5D, 2.47004662004808E-6D, 2.85708041957819E-6D, 1.26253496503338E-5D, 6.9516317017012E-7D, 2.40448717948568E-6D, -2.1993006992399E-7D }));
          ammunitionBT105LG.setAjiA3Array(DataTools.toStringDouble(new double[] { -6.917424242425E-8D, -6.48251748252E-9D, -6.46911421911E-9D, -1.656410256408E-8D, -1.65034965035E-9D, -2.3411033411E-9D, 7.2338772339E-10D }));
          ammunitionBT105LG.setAjiA4Array(DataTools.toStringDouble(new double[] { 4.026515152E-11D, 3.33333333E-12D, 3.35955711E-12D, 6.96386946E-12D, 8.3333333E-13D, 8.3333333E-13D, -3.4965035E-13D }));
          ammunitionBT105LG.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D }));
          ammunitionBT105LG.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setPropArray("M67,M67,M67,M67,M67,M67,M67");
          ammunitionBT105LG.setGradTempArray(DataTools.toStringDouble(new double[] { 0.0719D, 0.08395084D, 0.09662286D, 0.115674782D, 0.141834706D, 0.181621957D, 0.244300431D }));
          ammunitionBT105LG.setPesoVelArray(DataTools.toStringDouble(new double[] { -1.7D, -1.9D, -2.0D, -1.9D, -1.9D, -2.1D, -2.6D }));
          ammunitionBT105LG.setQemaxrArray(DataTools.toStringDouble(new double[] { 782.0D, 786.0D, 791.0D, 789.0D, 779.0D, 789.0D, 792.0D }));
          ammunitionBT105LG.setKpArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbB2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setFibbB3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setTbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBT105LG.setEspoletas("M557,0.97,PDM, , , , , , ");
          ammunitionBT105LG.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D }));
          ammunitionBT105LG.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBT105LG.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBT105LG);
          Ammunition ammunitionBB105LG = new Ammunition();
          ammunitionBB105LG.setNombreMunicion("HE-ER50/BB");
          ammunitionBB105LG.setEfectoMunicion("HE");
          ammunitionBB105LG.setIndexMunicionPesoSTD(1);
          ammunitionBB105LG.setIndexMunicionNumZonas(1);
          ammunitionBB105LG.setZonesSelected(DataTools.toStringInt(new int[] { 1, 2 }));
          ammunitionBB105LG.setMunicionBB(0);
          ammunitionBB105LG.setIndexEspoletas(0);
          ammunitionBB105LG.setManejoMunicion("105,15.850,0.15,0.025658,16,0.00,0.00");
          ammunitionBB105LG.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.06D, 0.75D, 0.85D, 0.9D, 0.95D, 0.975D, 1.0D, 1.05D, 1.2D, 1.5D, 
                  1.75D, 2.0D, 2.25D, 2.5D, 3.0D }));
          ammunitionBB105LG.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.162D, 0.164D, 0.17D, 0.177D, 0.218D, 0.261D, 0.303D, 0.341D, 0.328D, 0.296D, 
                  0.272D, 0.253D, 0.236D, 0.219D, 0.196D }));
          ammunitionBB105LG.setCdaArray(DataTools.toStringDouble(new double[] { 
                  4.45D, 4.828D, 5.225D, 5.487D, 6.019D, 6.285D, 6.562D, 7.115D, 8.24D, 7.272D, 
                  6.797D, 6.314D, 6.048D, 5.792D, 5.259D }));
          ammunitionBB105LG.setClArray(DataTools.toStringDouble(new double[] { 
                  1.425D, 1.581D, 1.601D, 1.616D, 1.543D, 1.573D, 1.604D, 1.686D, 1.845D, 2.122D, 
                  2.273D, 2.421D, 2.513D, 2.605D, 2.567D }));
          ammunitionBB105LG.setClaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setCmArray(DataTools.toStringDouble(new double[] { 
                  2.214D, 2.704D, 2.871D, 3.006D, 2.847D, 2.957D, 3.067D, 3.201D, 3.392D, 3.429D, 
                  3.372D, 3.323D, 3.283D, 3.238D, 3.026D }));
          ammunitionBB105LG.setCmaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -0.445D, -0.445D, -0.47D, -0.5D, -0.635D, -0.61D, -0.58D, -0.525D, -0.445D, -0.445D, 
                  -0.445D, -0.445D, -0.445D, -0.445D, -0.445D }));
          ammunitionBB105LG.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.013D, -0.013D, -0.013D, -0.012D, -0.011D, -0.011D, -0.011D, -0.011D, -0.011D, -0.011D, 
                  -0.011D, -0.011D, -0.011D, -0.011D, -0.011D }));
          ammunitionBB105LG.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.076586D, 0.817025D, 0.924335D, 0.97799D, 0.152000000000001D, 0.175749999999994D, 0.224999999999998D, 0.232035875D, 0.2226D, 0.212625D, 
                  0.212734375D, 0.217D, 0.222140625D, 0.224875D, 0.21D }));
          ammunitionBB105LG.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setiArray(DataTools.toStringDouble(new double[] { 
                  3.5D, 4.6D, 5.7D, 6.3D, 6.7D, 7.7D, 18.4D, 18.5D, 23.0D, 31.3D, 
                  40.0D, 49.0D, 65.0D, 81.14D, 152.0D }));
          ammunitionBB105LG.setMcbArray(DataTools.toStringDouble(new double[] { 0.069D, 0.115D, 0.3D, 0.399D, 0.434D }));
          ammunitionBB105LG.setScArray(DataTools.toStringDouble(new double[] { 0.01571D, 0.01445D, 0.0113D, 0.00896D, 0.00171D }));
          ammunitionBB105LG.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBB105LG.setVelArray(DataTools.toStringDouble(new double[] { 537.0D, 630.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBB105LG.getVelArray())));
          ammunitionBB105LG.setAjFDArray(DataTools.toStringDouble(new double[] { 1.03D, 1.03D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFMagArray(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFLA0Array(DataTools.toStringDouble(new double[] { 0.993766205100258D, 0.925339855511095D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFLA1Array(DataTools.toStringDouble(new double[] { -7.80664798787585E-4D, 6.77858854714402E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFLA2Array(DataTools.toStringDouble(new double[] { 2.61377838498649E-6D, -2.06186987680283E-6D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFLA3Array(DataTools.toStringDouble(new double[] { -2.62064094847E-9D, 2.17920738202E-9D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjFLA4Array(DataTools.toStringDouble(new double[] { 9.2815573E-13D, -7.6352869E-13D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjiA0Array(DataTools.toStringDouble(new double[] { 0.822675396349736D, 0.836467088101796D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjiA1Array(DataTools.toStringDouble(new double[] { -1.7640618488121E-4D, -1.87702399704711E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjiA2Array(DataTools.toStringDouble(new double[] { 4.3855811683635E-7D, 5.5460517684325E-7D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjiA3Array(DataTools.toStringDouble(new double[] { -3.9507595054E-10D, -5.2873423486E-10D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjiA4Array(DataTools.toStringDouble(new double[] { 1.1696499E-13D, 1.6001521E-13D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setPropArray("M200A3,M200A3, , , , , ");
          ammunitionBB105LG.setGradTempArray(DataTools.toStringDouble(new double[] { 0.4D, 0.329D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setPesoVelArray(DataTools.toStringDouble(new double[] { -1.8D, -2.1D, 0.0D, 0.0D, 0.0D, -0.52D, 0.0D }));
          ammunitionBB105LG.setQemaxrArray(DataTools.toStringDouble(new double[] { 749.0D, 779.4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setKpArray(DataTools.toStringDouble(new double[] { 1.1207D, 1.3587D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbA0Array(DataTools.toStringDouble(new double[] { 1.13849D, 1.04581D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbA1Array(DataTools.toStringDouble(new double[] { -1.24818E-4D, -9.25257E-6D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.00181926D, 0.001353595D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbB2Array(DataTools.toStringDouble(new double[] { -2.178323E-5D, -4.336616E-5D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setFibbB3Array(DataTools.toStringDouble(new double[] { -9.013542E-8D, -3.721027E-7D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.012D, 0.012D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTbA0Array(DataTools.toStringDouble(new double[] { 24.8109D, 23.92624D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTbA1Array(DataTools.toStringDouble(new double[] { -0.1161527D, -0.1198521D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTbA2Array(DataTools.toStringDouble(new double[] { 3.026496E-4D, 9.090194E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setTbA3Array(DataTools.toStringDouble(new double[] { 1.040575E-5D, 1.285232E-5D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105LG.setEspoletas("M562G1,0.75,PDM,M564,0.75,TIME, , , ");
          ammunitionBB105LG.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.01D, 0.499D, 1540.0D, 0.02521D, 0.3537D, 9.8E-4D, 0.006889D, 0.037575D, 0.3D, 0.10059D, 
                  1.0D }));
          ammunitionBB105LG.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBB105LG.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBB105LG);
        } else if (getSistema().equals(Sistema.OBUS_105_L119)) {
          Ammunition ammunitionBTL119 = new Ammunition();
          ammunitionBTL119.setNombreMunicion("HE-M1");
          ammunitionBTL119.setEfectoMunicion("HE");
          ammunitionBTL119.setIndexMunicionPesoSTD(2);
          ammunitionBTL119.setIndexMunicionNumZonas(6);
          ammunitionBTL119.setZonesSelected(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBTL119.setMunicionBB(1);
          ammunitionBTL119.setIndexEspoletas(0);
          ammunitionBTL119.setManejoMunicion("105,14.97,0.28,0.0178932,16,0.00,0.00");
          ammunitionBTL119.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.2D, 0.7D, 0.8D, 0.875D, 0.925D, 0.95D, 0.975D, 1.0D, 1.025D, 1.05D, 
                  1.1D, 1.35D, 1.75D, 2.25D, 3.0D }));
          ammunitionBTL119.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.159D, 0.162D, 0.173D, 0.191D, 0.228D, 0.262D, 0.307D, 0.355D, 0.382D, 0.4D, 
                  0.398D, 0.364D, 0.322D, 0.278D, 0.238D }));
          ammunitionBTL119.setCdaArray(DataTools.toStringDouble(new double[] { 
                  4.03D, 4.28D, 4.51D, 4.85D, 5.25D, 5.49D, 5.75D, 6.0D, 6.25D, 6.5D, 
                  7.05D, 7.12D, 6.29D, 5.58D, 4.77D }));
          ammunitionBTL119.setClArray(DataTools.toStringDouble(new double[] { 
                  1.69D, 1.66D, 1.68D, 1.74D, 1.82D, 1.86D, 1.86D, 1.82D, 1.8D, 1.81D, 
                  1.87D, 2.11D, 2.37D, 2.57D, 2.57D }));
          ammunitionBTL119.setClaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setCmArray(DataTools.toStringDouble(new double[] { 
                  2.807D, 2.825D, 2.918D, 3.074D, 3.309D, 3.409D, 3.414D, 3.34D, 3.249D, 3.199D, 
                  3.204D, 3.26D, 2.816D, 2.661D, 2.542D }));
          ammunitionBTL119.setCmaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -0.69D, -0.7D, -0.72D, -0.75D, -0.87D, -0.99D, -0.88D, -0.81D, -0.77D, -0.74D, 
                  -0.69D, -0.56D, -0.52D, -0.48D, -0.48D }));
          ammunitionBTL119.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.0214D, -0.0211D, -0.0209D, -0.0208D, -0.02D, -0.0198D, -0.02D, -0.0204D, -0.0201D, -0.0197D, 
                  -0.0189D, -0.0172D, -0.0151D, -0.0135D, -0.0113D }));
          ammunitionBTL119.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setiArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setMcbArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setScArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBTL119.setVelArray(DataTools.toStringDouble(new double[] { 197.0D, 215.0D, 235.0D, 275.0D, 320.0D, 385.0D, 490.0D }));
          ammunitionBTL119.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBTL119.getVelArray())));
          ammunitionBTL119.setAjFDArray(DataTools.toStringDouble(new double[] { 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 1.03D, 0.0D }));
          ammunitionBTL119.setAjFMagArray(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D }));
          ammunitionBTL119.setAjFLA0Array(DataTools.toStringDouble(new double[] { 0.355151515150526D, 0.489090909090036D, 0.833030303028778D, 1.15028296207414D, 0.979999999998379D, 0.612424242422908D, 0.703939393938101D }));
          ammunitionBTL119.setAjFLA1Array(DataTools.toStringDouble(new double[] { 0.00720454545453646D, 0.00670823620822367D, 0.00150879953380025D, -0.0030296948085159D, 0.00128931623931163D, 0.00301210178709933D, 0.00242323232322785D }));
          ammunitionBTL119.setAjFLA2Array(DataTools.toStringDouble(new double[] { -2.29644522144216E-5D, -2.43968531468071E-5D, -5.0495337995327E-7D, 1.68750559595194E-5D, -3.24825174823321E-6D, -5.75495337994307E-6D, -5.67773892772385E-6D }));
          ammunitionBTL119.setAjFLA3Array(DataTools.toStringDouble(new double[] { 2.76223776223507E-8D, 3.31740481740073E-8D, -3.53729603729183E-9D, -2.47633492335717E-8D, 6.9308469308E-9D, 5.00194250193E-9D, 6.12665112664E-9D }));
          ammunitionBTL119.setAjFLA4Array(DataTools.toStringDouble(new double[] { -1.06643356643237E-11D, -1.42773892773769E-11D, 2.70979020978911E-12D, 1.07229966501554E-11D, -4.42890443E-12D, -1.77738928E-12D, -2.27272727E-12D }));
          ammunitionBTL119.setAjiA0Array(DataTools.toStringDouble(new double[] { -0.373636363637352D, 0.297575757575115D, -0.302121212121908D, 2.88047160345478D, 1.69484848484675D, 1.34984848484718D, 1.50454545454398D }));
          ammunitionBTL119.setAjiA1Array(DataTools.toStringDouble(new double[] { 0.00663315850815383D, 0.00402981740481144D, 0.00596773504273016D, -0.0102839319069588D, -0.00865510878010292D, -0.00238846930846908D, -0.00280843045843046D }));
          ammunitionBTL119.setAjiA2Array(DataTools.toStringDouble(new double[] { -1.28307109556922E-5D, -1.21121794871604E-5D, -1.33843240093078E-5D, 1.95498213155788E-5D, 2.55195221445054E-5D, 4.4998251748253E-6D, 6.08857808858059E-6D }));
          ammunitionBTL119.setAjiA3Array(DataTools.toStringDouble(new double[] { 1.1614219114201E-8D, 1.44191919191774E-8D, 1.3447940947924E-8D, -1.55321554825095E-8D, -2.933760683758E-8D, -3.7556332556E-9D, -5.92851592851E-9D }));
          ammunitionBTL119.setAjiA4Array(DataTools.toStringDouble(new double[] { -3.9918414918364E-12D, -5.68181818181252E-12D, -4.80769230768497E-12D, 4.4198351317629E-12D, 1.168414918E-11D, 1.26456876E-12D, 2.21445221E-12D }));
          ammunitionBTL119.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.0D }));
          ammunitionBTL119.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setPropArray("M67,M67,M67,M67,M67,M67,M67");
          ammunitionBTL119.setGradTempArray(DataTools.toStringDouble(new double[] { 0.0719D, 0.08395084D, 0.09662286D, 0.115674782D, 0.141834706D, 0.181621957D, 0.244300431D }));
          ammunitionBTL119.setPesoVelArray(DataTools.toStringDouble(new double[] { -1.7D, -1.9D, -2.0D, -1.9D, -1.9D, -2.1D, -2.6D }));
          ammunitionBTL119.setQemaxrArray(DataTools.toStringDouble(new double[] { 782.0D, 786.0D, 791.0D, 789.0D, 779.0D, 789.0D, 792.0D }));
          ammunitionBTL119.setKpArray(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbB2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setFibbB3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTbA0Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTbA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setTbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBTL119.setEspoletas("M557,0.97,PDM, , , , , , ");
          ammunitionBTL119.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D }));
          ammunitionBTL119.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBTL119.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBTL119);
          Ammunition ammunitionBB105L119 = new Ammunition();
          ammunitionBB105L119.setNombreMunicion("HE-ER50/BB");
          ammunitionBB105L119.setEfectoMunicion("HE");
          ammunitionBB105L119.setIndexMunicionPesoSTD(1);
          ammunitionBB105L119.setIndexMunicionNumZonas(1);
          ammunitionBB105L119.setZonesSelected(DataTools.toStringInt(new int[] { 1, 2 }));
          ammunitionBB105L119.setMunicionBB(0);
          ammunitionBB105L119.setIndexEspoletas(0);
          ammunitionBB105L119.setManejoMunicion("105,15.85,0.15,0.025658,16,0.00,0.00");
          ammunitionBB105L119.setMachArray(DataTools.toStringDouble(new double[] { 
                  0.06D, 0.75D, 0.85D, 0.9D, 0.95D, 0.975D, 1.0D, 1.05D, 1.2D, 1.5D, 
                  1.75D, 2.0D, 2.25D, 2.5D, 3.0D }));
          ammunitionBB105L119.setCdArray(DataTools.toStringDouble(new double[] { 
                  0.162D, 0.164D, 0.17D, 0.177D, 0.218D, 0.261D, 0.303D, 0.341D, 0.328D, 0.296D, 
                  0.272D, 0.253D, 0.236D, 0.219D, 0.196D }));
          ammunitionBB105L119.setCdaArray(DataTools.toStringDouble(new double[] { 
                  4.45D, 4.828D, 5.225D, 5.487D, 6.019D, 6.285D, 6.562D, 7.115D, 8.24D, 7.272D, 
                  6.797D, 6.314D, 6.048D, 5.792D, 5.259D }));
          ammunitionBB105L119.setClArray(DataTools.toStringDouble(new double[] { 
                  1.425D, 1.581D, 1.601D, 1.616D, 1.543D, 1.573D, 1.604D, 1.686D, 1.845D, 2.122D, 
                  2.273D, 2.421D, 2.513D, 2.605D, 2.567D }));
          ammunitionBB105L119.setClaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setCmArray(DataTools.toStringDouble(new double[] { 
                  2.214D, 2.704D, 2.871D, 3.006D, 2.847D, 2.957D, 3.067D, 3.201D, 3.392D, 3.429D, 
                  3.372D, 3.323D, 3.283D, 3.238D, 3.026D }));
          ammunitionBB105L119.setCmaArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setCmagArray(DataTools.toStringDouble(new double[] { 
                  -0.445D, -0.445D, -0.47D, -0.5D, -0.635D, -0.61D, -0.58D, -0.525D, -0.445D, -0.445D, 
                  -0.445D, -0.445D, -0.445D, -0.445D, -0.445D }));
          ammunitionBB105L119.setCspindArray(DataTools.toStringDouble(new double[] { 
                  -0.013D, -0.013D, -0.013D, -0.012D, -0.011D, -0.011D, -0.011D, -0.011D, -0.011D, -0.011D, 
                  -0.011D, -0.011D, -0.011D, -0.011D, -0.011D }));
          ammunitionBB105L119.setCxbbArray(DataTools.toStringDouble(new double[] { 
                  0.076586D, 0.817025D, 0.924335D, 0.97799D, 0.152000000000001D, 0.175749999999994D, 0.224999999999998D, 0.232035875D, 0.2226D, 0.212625D, 
                  0.212734375D, 0.217D, 0.222140625D, 0.224875D, 0.21D }));
          ammunitionBB105L119.setIformArray(DataTools.toStringDouble(new double[] { 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 
                  0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setiArray(DataTools.toStringDouble(new double[] { 
                  3.5D, 4.6D, 5.7D, 6.3D, 6.7D, 7.7D, 18.4D, 18.5D, 23.0D, 31.3D, 
                  40.0D, 49.0D, 65.0D, 81.14D, 152.0D }));
          ammunitionBB105L119.setMcbArray(DataTools.toStringDouble(new double[] { 0.069D, 0.115D, 0.3D, 0.399D, 0.434D }));
          ammunitionBB105L119.setScArray(DataTools.toStringDouble(new double[] { 0.01571D, 0.01445D, 0.0113D, 0.00896D, 0.00171D }));
          ammunitionBB105L119.setZoneArray(DataTools.toStringInt(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
          ammunitionBB105L119.setVelArray(DataTools.toStringDouble(new double[] { 537.0D, 630.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setVelPromArray(DataTools.toVelPromVel(DataTools.toDoubleString(ammunitionBB105L119.getVelArray())));
          ammunitionBB105L119.setAjFDArray(DataTools.toStringDouble(new double[] { 1.03D, 1.03D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFMagArray(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFLA0Array(DataTools.toStringDouble(new double[] { 1.1590000000018D, 1.06909090908955D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFLA1Array(DataTools.toStringDouble(new double[] { -0.00140257575757577D, 4.3993201243021E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFLA2Array(DataTools.toStringDouble(new double[] { 4.41174242423521E-6D, -1.54501748250791E-6D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFLA3Array(DataTools.toStringDouble(new double[] { -4.32575757575E-9D, 1.79118104118E-9D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjFLA4Array(DataTools.toStringDouble(new double[] { 1.32575758E-12D, -6.8473193E-13D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjiA0Array(DataTools.toStringDouble(new double[] { 0.814833333334701D, 0.835515151514117D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjiA1Array(DataTools.toStringDouble(new double[] { -4.30574980579016E-5D, -1.88162393162359E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjiA2Array(DataTools.toStringDouble(new double[] { -1.1535547785606E-7D, 5.7768065268313E-7D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjiA3Array(DataTools.toStringDouble(new double[] { 4.5435120435E-10D, -5.707070707E-10D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjiA4Array(DataTools.toStringDouble(new double[] { -3.1177156E-13D, 1.8065268E-13D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjTimeA0Array(DataTools.toStringDouble(new double[] { 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjTimeA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjTimeA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjTimeA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setAjTimeA4Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setPropArray("M200A3,M200A3, , , , , ");
          ammunitionBB105L119.setGradTempArray(DataTools.toStringDouble(new double[] { 0.4D, 0.329D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setPesoVelArray(DataTools.toStringDouble(new double[] { -1.8D, -2.1D, 0.0D, 0.0D, 0.0D, -0.52D, 0.0D }));
          ammunitionBB105L119.setQemaxrArray(DataTools.toStringDouble(new double[] { 749.0D, 779.4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setKpArray(DataTools.toStringDouble(new double[] { 1.1207D, 1.3587D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbA0Array(DataTools.toStringDouble(new double[] { 1.13849D, 1.04581D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbA1Array(DataTools.toStringDouble(new double[] { -1.24818E-4D, -9.25257E-6D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbB1Array(DataTools.toStringDouble(new double[] { 0.00181926D, 0.001353595D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbB2Array(DataTools.toStringDouble(new double[] { -2.178323E-5D, -4.336616E-5D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setFibbB3Array(DataTools.toStringDouble(new double[] { -9.013542E-8D, -3.721027E-7D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTdiA0Array(DataTools.toStringDouble(new double[] { 0.012D, 0.012D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTdiA1Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTdiA2Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTdiA3Array(DataTools.toStringDouble(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTbA0Array(DataTools.toStringDouble(new double[] { 24.8109D, 23.92624D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTbA1Array(DataTools.toStringDouble(new double[] { -0.1161527D, -0.1198521D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTbA2Array(DataTools.toStringDouble(new double[] { 3.026496E-4D, 9.090194E-4D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setTbA3Array(DataTools.toStringDouble(new double[] { 1.040575E-5D, 1.285232E-5D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }));
          ammunitionBB105L119.setEspoletas("M562G1,0.75,PDM,M564,0.75,TIME, , , ");
          ammunitionBB105L119.setParametrosBB(DataTools.toStringDouble(new double[] { 
                  0.01D, 0.499D, 1540.0D, 0.02521D, 0.3537D, 9.8E-4D, 0.006889D, 0.037575D, 0.3D, 0.10059D, 
                  1.0D }));
          ammunitionBB105L119.setAjustesPrecision(DataTools.toStringDouble(new double[] { 2.0D, 0.1D, 0.028125D, 0.1D, 2000.0D }));
          ammunitionBB105L119.setDesviacionMPI(DataTools.toStringDouble(new double[] { 20.0D, 0.5D, 20.0D, 0.028125D }));
          ammunitionService.createOrUpdate(ammunitionBB105L119);
        } 
        this.ammunitions = (ArrayList<Ammunition>)ammunitionService.getList(Ammunition.class);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public void setAmmoListFirstTime() {
    try {
      AmmunitionService ammunitionService = new AmmunitionService();
      ammunitionService.createTableIfNotExists(Ammunition.class);
      this.ammunitions = (ArrayList<Ammunition>)ammunitionService.getList(Ammunition.class);
      for (int i = 0; i < this.ammunitions.size(); i++)
        ammunitionService.deleteById(Ammunition.class, ((Ammunition)this.ammunitions.get(i)).getNombreMunicion()); 
      setAmmoList();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public ArrayList<Ammunition> getAmmoList() {
    return this.ammunitions;
  }
  
  public void editVelPromAmmo() {
    try {
      AmmunitionService ammunitionService = new AmmunitionService();
      ammunitionService.createTableIfNotExists(Ammunition.class);
      Ammunition ammunition = new Ammunition();
      ammunition = this.ammunitions.get(getIndexMunicion());
      String[] velPromAux = ammunition.getVelPromArray().split(";");
      String[] velaux = velPromAux[this.municion.zonaSelec.getNumero() - 1].split(",");
      for (int i = 0; i < 10; i++)
        velaux[i] = String.valueOf(this.municion.zonaSelec.velocidades[i]); 
      velPromAux[this.municion.zonaSelec.getNumero() - 1] = DataTools.reverseSplit(velaux, ",");
      ammunition.setVelPromArray(DataTools.reverseSplit(velPromAux, ";"));
      ammunitionService.createOrUpdate(ammunition);
      this.ammunitions = (ArrayList<Ammunition>)ammunitionService.getList(Ammunition.class);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public boolean isFirtTime() {
    return this.firtTime;
  }
  
  public void setFirtTime(boolean firtTime) {
    this.firtTime = firtTime;
  }
  
  public Municion getMunicion() {
    return this.municion;
  }
  
  public void setMunicion(Municion municion) {
    this.municion = municion;
  }
  
  public String getTipoMunicion() {
    return this.tipoMunicion;
  }
  
  public void setTipoMunicion(String tipoMunicion) {
    this.tipoMunicion = tipoMunicion;
  }
  
  public int getIndexEspoleta() {
    return this.indexEspoleta;
  }
  
  public void setIndexEspoleta(int indexEspoleta) {
    this.indexEspoleta = indexEspoleta;
  }
  
  public int getIndexCuadros() {
    return this.indexCuadros;
  }
  
  public void setIndexCuadros(int indexCuadros) {
    this.indexCuadros = indexCuadros;
  }
  
  public int getIndexMunicion() {
    return this.indexMunicion;
  }
  
  public void setIndexMunicion(int indexMunicion) {
    this.indexMunicion = indexMunicion;
  }
  
  public int getNumeroZona() {
    return this.numeroZona;
  }
  
  public void setNumeroZona(int numeroZona) {
    this.numeroZona = numeroZona;
  }
  
  public double getTempProp() {
    return this.tempProp;
  }
  
  public void setTempProp(double tempProp) {
    this.tempProp = tempProp;
  }
  
  public int getCuadros() {
    return this.cuadros;
  }
  
  public void setCuadros(int cuadros) {
    this.cuadros = cuadros;
  }
  
  public String getTipoCarga() {
    return this.tipoCarga;
  }
  
  public void setTipoCarga(String tipoCarga) {
    this.tipoCarga = tipoCarga;
  }
  
  public double getAlturaExplosion_m() {
    return this.alturaExplosion_m;
  }
  
  public void setAlturaExplosion_m(double alturaExplosion_m) {
    this.alturaExplosion_m = alturaExplosion_m;
  }
  
  public int getCantidadMunicion() {
    return this.cantidadMunicion;
  }
  
  public void setCantidadMunicion(int cantidadMunicion) {
    this.cantidadMunicion = cantidadMunicion;
  }
  
  public UnidadDistancia getUnidadDistancia() {
    return this.unidadDistancia;
  }
  
  public void setUnidadDistancia(UnidadDistancia unidadDistancia) {
    this.unidadDistancia = unidadDistancia;
  }
  
  public UnidadAngulo getUnidadAngulo() {
    return this.unidadAngulo;
  }
  
  public void setUnidadAngulo(UnidadAngulo unidadAngulo) {
    this.unidadAngulo = unidadAngulo;
  }
  
  public UnidadCoordenadas getUnidadCoordenadas() {
    return this.unidadCoordenadas;
  }
  
  public void setUnidadCoordenadas(UnidadCoordenadas unidadCoordenadas) {
    this.unidadCoordenadas = unidadCoordenadas;
  }
  
  public SensorModoZUPT getSensorModoZUPT() {
    return this.sensorModoZUPT;
  }
  
  public void setSensorModoZUPT(SensorModoZUPT sensorModoZUPT) {
    this.sensorModoZUPT = sensorModoZUPT;
  }
  
  public SensorGPS getSensorGPS() {
    return this.sensorGPS;
  }
  
  public void setSensorGPS(SensorGPS sensorGPS) {
    this.sensorGPS = sensorGPS;
  }
  
  public void setSensorOdometro(SensorOdometro sensorOdometro) {
    this.sensorOdometro = sensorOdometro;
  }
  
  public SensorOdometro getSensorOdometro() {
    return this.sensorOdometro;
  }
  
  public Language getLanguage() {
    return this.language;
  }
  
  public void setLanguage(Language language) {
    this.language = language;
  }
  
  public Sistema getSistema() {
    return this.sistema;
  }
  
  public void setSistema(Sistema sistema) {
    this.sistema = sistema;
  }
  
  public String getPieceNumber() {
    return this.pieceNumber;
  }
  
  public void setPieceNumber(String pieceNumber) {
    this.pieceNumber = pieceNumber;
  }
  
  public TipoCalculo getTipoCalculo() {
    return this.tipoCalculo;
  }
  
  public void setTipoCalculo(TipoCalculo tipoCalculo) {
    this.tipoCalculo = tipoCalculo;
  }
  
  public String getLicencia() {
    return this.licencia;
  }
  
  public void setLicencia(String licencia) {
    this.licencia = licencia;
  }
  
  public Criterio getCriterio() {
    return this.criterio;
  }
  
  public void setCriterio(Criterio criterio) {
    this.criterio = criterio;
  }
  
  public boolean isRasante() {
    return this.isRasante;
  }
  
  public void setRasante(boolean rasante) {
    this.isRasante = rasante;
  }
  
  public double getDifPeso() {
    return this.difPeso;
  }
  
  public void setDifPeso(double difPeso) {
    this.difPeso = difPeso;
  }
  
  public boolean isActivaZone() {
    return this.activaZone;
  }
  
  public void setActivaZone(boolean activaZone) {
    this.activaZone = activaZone;
  }
  
  public static Configuracion getSingletonInstance() {
    if (configuracion == null)
      configuracion = new Configuracion(); 
    return configuracion;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\Configuracion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */