package co.dynamicts.neli.core.local.model;

import co.dynamicts.neli.core.municion.Espoleta;
import co.dynamicts.neli.core.municion.Municion;
import co.dynamicts.neli.core.municion.Zona;
import co.dynamicts.neli.core.utilities.DataTools;
import com.j256.ormlite.field.DatabaseField;

public class Ammunition {
  @DatabaseField(id = true)
  private String nombreMunicion;
  
  @DatabaseField(id = false)
  private String efectoMunicion;
  
  @DatabaseField(canBeNull = false)
  private int indexMunicionPesoSTD;
  
  @DatabaseField(canBeNull = false)
  private int indexMunicionNumZonas;
  
  @DatabaseField(canBeNull = false)
  private String zonesSelected;
  
  @DatabaseField(canBeNull = false)
  private int municionBB;
  
  @DatabaseField(canBeNull = false)
  private int indexEspoletas;
  
  @DatabaseField(canBeNull = false)
  private String manejoMunicion;
  
  @DatabaseField(canBeNull = false)
  private String machArray;
  
  @DatabaseField(canBeNull = false)
  private String cdArray;
  
  @DatabaseField(canBeNull = false)
  private String cdaArray;
  
  @DatabaseField(canBeNull = false)
  private String clArray;
  
  @DatabaseField(canBeNull = false)
  private String claArray;
  
  @DatabaseField(canBeNull = false)
  private String cmArray;
  
  @DatabaseField(canBeNull = false)
  private String cmaArray;
  
  @DatabaseField(canBeNull = false)
  private String cmagArray;
  
  @DatabaseField(canBeNull = false)
  private String cspindArray;
  
  @DatabaseField(canBeNull = false)
  private String cxbbArray;
  
  @DatabaseField(canBeNull = false)
  private String iformArray;
  
  @DatabaseField(canBeNull = false)
  private String iArray;
  
  @DatabaseField(canBeNull = false)
  private String mcbArray;
  
  @DatabaseField(canBeNull = false)
  private String scArray;
  
  @DatabaseField(canBeNull = false)
  private String zoneArray;
  
  @DatabaseField(canBeNull = false)
  private String velArray;
  
  @DatabaseField(canBeNull = false)
  private String velPromArray;
  
  @DatabaseField(canBeNull = false)
  private String ajFDArray;
  
  @DatabaseField(canBeNull = false)
  private String ajFMagArray;
  
  @DatabaseField(canBeNull = false)
  private String ajFLA0Array;
  
  @DatabaseField(canBeNull = false)
  private String ajFLA1Array;
  
  @DatabaseField(canBeNull = false)
  private String ajFLA2Array;
  
  @DatabaseField(canBeNull = false)
  private String ajFLA3Array;
  
  @DatabaseField(canBeNull = false)
  private String ajFLA4Array;
  
  @DatabaseField(canBeNull = false)
  private String ajiA0Array;
  
  @DatabaseField(canBeNull = false)
  private String ajiA1Array;
  
  @DatabaseField(canBeNull = false)
  private String ajiA2Array;
  
  @DatabaseField(canBeNull = false)
  private String ajiA3Array;
  
  @DatabaseField(canBeNull = false)
  private String ajiA4Array;
  
  @DatabaseField(canBeNull = false)
  private String ajTimeA0Array;
  
  @DatabaseField(canBeNull = false)
  private String ajTimeA1Array;
  
  @DatabaseField(canBeNull = false)
  private String ajTimeA2Array;
  
  @DatabaseField(canBeNull = false)
  private String ajTimeA3Array;
  
  @DatabaseField(canBeNull = false)
  private String ajTimeA4Array;
  
  @DatabaseField(canBeNull = false)
  private String propArray;
  
  @DatabaseField(canBeNull = false)
  private String gradTempArray;
  
  @DatabaseField(canBeNull = false)
  private String pesoVelArray;
  
  @DatabaseField(canBeNull = false)
  private String qemaxrArray;
  
  @DatabaseField(canBeNull = false)
  private String kpArray;
  
  @DatabaseField(canBeNull = false)
  private String fibbA0Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbA1Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbA2Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbA3Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbB1Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbB2Array;
  
  @DatabaseField(canBeNull = false)
  private String fibbB3Array;
  
  @DatabaseField(canBeNull = false)
  private String tdiA0Array;
  
  @DatabaseField(canBeNull = false)
  private String tdiA1Array;
  
  @DatabaseField(canBeNull = false)
  private String tdiA2Array;
  
  @DatabaseField(canBeNull = false)
  private String tdiA3Array;
  
  @DatabaseField(canBeNull = false)
  private String tbA0Array;
  
  @DatabaseField(canBeNull = false)
  private String tbA1Array;
  
  @DatabaseField(canBeNull = false)
  private String tbA2Array;
  
  @DatabaseField(canBeNull = false)
  private String tbA3Array;
  
  @DatabaseField(canBeNull = false)
  private String espoletas;
  
  @DatabaseField(canBeNull = false)
  private String parametrosBB;
  
  @DatabaseField(canBeNull = false)
  private String ajustesPrecision;
  
  @DatabaseField(canBeNull = false)
  private String desviacionMPI;
  
  public String getNombreMunicion() {
    return this.nombreMunicion;
  }
  
  public void setNombreMunicion(String nombreMunicion) {
    this.nombreMunicion = nombreMunicion;
  }
  
  public String getEfectoMunicion() {
    return this.efectoMunicion;
  }
  
  public void setEfectoMunicion(String efectoMunicion) {
    this.efectoMunicion = efectoMunicion;
  }
  
  public int getIndexMunicionPesoSTD() {
    return this.indexMunicionPesoSTD;
  }
  
  public void setIndexMunicionPesoSTD(int indexMunicionPesoSTD) {
    this.indexMunicionPesoSTD = indexMunicionPesoSTD;
  }
  
  public int getIndexMunicionNumZonas() {
    return this.indexMunicionNumZonas;
  }
  
  public void setIndexMunicionNumZonas(int indexMunicionNumZonas) {
    this.indexMunicionNumZonas = indexMunicionNumZonas;
  }
  
  public String getZonesSelected() {
    return this.zonesSelected;
  }
  
  public void setZonesSelected(String zonesSelected) {
    this.zonesSelected = zonesSelected;
  }
  
  public int getMunicionBB() {
    return this.municionBB;
  }
  
  public void setMunicionBB(int municionBB) {
    this.municionBB = municionBB;
  }
  
  public int getIndexEspoletas() {
    return this.indexEspoletas;
  }
  
  public void setIndexEspoletas(int indexEspoletas) {
    this.indexEspoletas = indexEspoletas;
  }
  
  public String getManejoMunicion() {
    return this.manejoMunicion;
  }
  
  public void setManejoMunicion(String manejoMunicion) {
    this.manejoMunicion = manejoMunicion;
  }
  
  public String getMachArray() {
    return this.machArray;
  }
  
  public void setMachArray(String machArray) {
    this.machArray = machArray;
  }
  
  public String getCdArray() {
    return this.cdArray;
  }
  
  public void setCdArray(String cdArray) {
    this.cdArray = cdArray;
  }
  
  public String getCdaArray() {
    return this.cdaArray;
  }
  
  public void setCdaArray(String cdaArray) {
    this.cdaArray = cdaArray;
  }
  
  public String getClArray() {
    return this.clArray;
  }
  
  public void setClArray(String clArray) {
    this.clArray = clArray;
  }
  
  public String getClaArray() {
    return this.claArray;
  }
  
  public void setClaArray(String claArray) {
    this.claArray = claArray;
  }
  
  public String getCmArray() {
    return this.cmArray;
  }
  
  public void setCmArray(String cmArray) {
    this.cmArray = cmArray;
  }
  
  public String getCmaArray() {
    return this.cmaArray;
  }
  
  public void setCmaArray(String cmaArray) {
    this.cmaArray = cmaArray;
  }
  
  public String getCmagArray() {
    return this.cmagArray;
  }
  
  public void setCmagArray(String cmagArray) {
    this.cmagArray = cmagArray;
  }
  
  public String getCspindArray() {
    return this.cspindArray;
  }
  
  public void setCspindArray(String cspindArray) {
    this.cspindArray = cspindArray;
  }
  
  public String getCxbbArray() {
    return this.cxbbArray;
  }
  
  public void setCxbbArray(String cxbbArray) {
    this.cxbbArray = cxbbArray;
  }
  
  public String getIformArray() {
    return this.iformArray;
  }
  
  public void setIformArray(String iformArray) {
    this.iformArray = iformArray;
  }
  
  public String getiArray() {
    return this.iArray;
  }
  
  public void setiArray(String iArray) {
    this.iArray = iArray;
  }
  
  public String getMcbArray() {
    return this.mcbArray;
  }
  
  public void setMcbArray(String mcbArray) {
    this.mcbArray = mcbArray;
  }
  
  public String getScArray() {
    return this.scArray;
  }
  
  public void setScArray(String scArray) {
    this.scArray = scArray;
  }
  
  public String getZoneArray() {
    return this.zoneArray;
  }
  
  public void setZoneArray(String zoneArray) {
    this.zoneArray = zoneArray;
  }
  
  public String getVelArray() {
    return this.velArray;
  }
  
  public void setVelArray(String velArray) {
    this.velArray = velArray;
  }
  
  public String getVelPromArray() {
    return this.velPromArray;
  }
  
  public void setVelPromArray(String velPromArray) {
    this.velPromArray = velPromArray;
  }
  
  public String getAjFDArray() {
    return this.ajFDArray;
  }
  
  public void setAjFDArray(String ajFDArray) {
    this.ajFDArray = ajFDArray;
  }
  
  public String getAjFMagArray() {
    return this.ajFMagArray;
  }
  
  public void setAjFMagArray(String ajFMagArray) {
    this.ajFMagArray = ajFMagArray;
  }
  
  public String getAjFLA0Array() {
    return this.ajFLA0Array;
  }
  
  public void setAjFLA0Array(String ajFLA0Array) {
    this.ajFLA0Array = ajFLA0Array;
  }
  
  public String getAjFLA1Array() {
    return this.ajFLA1Array;
  }
  
  public void setAjFLA1Array(String ajFLA1Array) {
    this.ajFLA1Array = ajFLA1Array;
  }
  
  public String getAjFLA2Array() {
    return this.ajFLA2Array;
  }
  
  public void setAjFLA2Array(String ajFLA2Array) {
    this.ajFLA2Array = ajFLA2Array;
  }
  
  public String getAjFLA3Array() {
    return this.ajFLA3Array;
  }
  
  public void setAjFLA3Array(String ajFLA3Array) {
    this.ajFLA3Array = ajFLA3Array;
  }
  
  public String getAjFLA4Array() {
    return this.ajFLA4Array;
  }
  
  public void setAjFLA4Array(String ajFLA4Array) {
    this.ajFLA4Array = ajFLA4Array;
  }
  
  public String getAjiA0Array() {
    return this.ajiA0Array;
  }
  
  public void setAjiA0Array(String ajiA0Array) {
    this.ajiA0Array = ajiA0Array;
  }
  
  public String getAjiA1Array() {
    return this.ajiA1Array;
  }
  
  public void setAjiA1Array(String ajiA1Array) {
    this.ajiA1Array = ajiA1Array;
  }
  
  public String getAjiA2Array() {
    return this.ajiA2Array;
  }
  
  public void setAjiA2Array(String ajiA2Array) {
    this.ajiA2Array = ajiA2Array;
  }
  
  public String getAjiA3Array() {
    return this.ajiA3Array;
  }
  
  public void setAjiA3Array(String ajiA3Array) {
    this.ajiA3Array = ajiA3Array;
  }
  
  public String getAjiA4Array() {
    return this.ajiA4Array;
  }
  
  public void setAjiA4Array(String ajiA4Array) {
    this.ajiA4Array = ajiA4Array;
  }
  
  public String getAjTimeA0Array() {
    return this.ajTimeA0Array;
  }
  
  public void setAjTimeA0Array(String ajTimeA0Array) {
    this.ajTimeA0Array = ajTimeA0Array;
  }
  
  public String getAjTimeA1Array() {
    return this.ajTimeA1Array;
  }
  
  public void setAjTimeA1Array(String ajTimeA1Array) {
    this.ajTimeA1Array = ajTimeA1Array;
  }
  
  public String getAjTimeA2Array() {
    return this.ajTimeA2Array;
  }
  
  public void setAjTimeA2Array(String ajTimeA2Array) {
    this.ajTimeA2Array = ajTimeA2Array;
  }
  
  public String getAjTimeA3Array() {
    return this.ajTimeA3Array;
  }
  
  public void setAjTimeA3Array(String ajTimeA3Array) {
    this.ajTimeA3Array = ajTimeA3Array;
  }
  
  public String getAjTimeA4Array() {
    return this.ajTimeA4Array;
  }
  
  public void setAjTimeA4Array(String ajTimeA4Array) {
    this.ajTimeA4Array = ajTimeA4Array;
  }
  
  public String getPropArray() {
    return this.propArray;
  }
  
  public void setPropArray(String propArray) {
    this.propArray = propArray;
  }
  
  public String getGradTempArray() {
    return this.gradTempArray;
  }
  
  public void setGradTempArray(String gradTempArray) {
    this.gradTempArray = gradTempArray;
  }
  
  public String getPesoVelArray() {
    return this.pesoVelArray;
  }
  
  public void setPesoVelArray(String pesoVelArray) {
    this.pesoVelArray = pesoVelArray;
  }
  
  public String getQemaxrArray() {
    return this.qemaxrArray;
  }
  
  public void setQemaxrArray(String qemaxrArray) {
    this.qemaxrArray = qemaxrArray;
  }
  
  public String getKpArray() {
    return this.kpArray;
  }
  
  public void setKpArray(String kpArray) {
    this.kpArray = kpArray;
  }
  
  public String getFibbA0Array() {
    return this.fibbA0Array;
  }
  
  public void setFibbA0Array(String fibbA0Array) {
    this.fibbA0Array = fibbA0Array;
  }
  
  public String getFibbA1Array() {
    return this.fibbA1Array;
  }
  
  public void setFibbA1Array(String fibbA1Array) {
    this.fibbA1Array = fibbA1Array;
  }
  
  public String getFibbA2Array() {
    return this.fibbA2Array;
  }
  
  public void setFibbA2Array(String fibbA2Array) {
    this.fibbA2Array = fibbA2Array;
  }
  
  public String getFibbA3Array() {
    return this.fibbA3Array;
  }
  
  public void setFibbA3Array(String fibbA3Array) {
    this.fibbA3Array = fibbA3Array;
  }
  
  public String getFibbB1Array() {
    return this.fibbB1Array;
  }
  
  public void setFibbB1Array(String fibbB1Array) {
    this.fibbB1Array = fibbB1Array;
  }
  
  public String getFibbB2Array() {
    return this.fibbB2Array;
  }
  
  public void setFibbB2Array(String fibbB2Array) {
    this.fibbB2Array = fibbB2Array;
  }
  
  public String getFibbB3Array() {
    return this.fibbB3Array;
  }
  
  public void setFibbB3Array(String fibbB3Array) {
    this.fibbB3Array = fibbB3Array;
  }
  
  public String getTdiA0Array() {
    return this.tdiA0Array;
  }
  
  public void setTdiA0Array(String tdiA0Array) {
    this.tdiA0Array = tdiA0Array;
  }
  
  public String getTdiA1Array() {
    return this.tdiA1Array;
  }
  
  public void setTdiA1Array(String tdiA1Array) {
    this.tdiA1Array = tdiA1Array;
  }
  
  public String getTdiA2Array() {
    return this.tdiA2Array;
  }
  
  public void setTdiA2Array(String tdiA2Array) {
    this.tdiA2Array = tdiA2Array;
  }
  
  public String getTdiA3Array() {
    return this.tdiA3Array;
  }
  
  public void setTdiA3Array(String tdiA3Array) {
    this.tdiA3Array = tdiA3Array;
  }
  
  public String getTbA0Array() {
    return this.tbA0Array;
  }
  
  public void setTbA0Array(String tbA0Array) {
    this.tbA0Array = tbA0Array;
  }
  
  public String getTbA1Array() {
    return this.tbA1Array;
  }
  
  public void setTbA1Array(String tbA1Array) {
    this.tbA1Array = tbA1Array;
  }
  
  public String getTbA2Array() {
    return this.tbA2Array;
  }
  
  public void setTbA2Array(String tbA2Array) {
    this.tbA2Array = tbA2Array;
  }
  
  public String getTbA3Array() {
    return this.tbA3Array;
  }
  
  public void setTbA3Array(String tbA3Array) {
    this.tbA3Array = tbA3Array;
  }
  
  public String getEspoletas() {
    return this.espoletas;
  }
  
  public void setEspoletas(String espoletas) {
    this.espoletas = espoletas;
  }
  
  public String getParametrosBB() {
    return this.parametrosBB;
  }
  
  public void setParametrosBB(String parametrosBB) {
    this.parametrosBB = parametrosBB;
  }
  
  public String getAjustesPrecision() {
    return this.ajustesPrecision;
  }
  
  public void setAjustesPrecision(String ajustesPrecision) {
    this.ajustesPrecision = ajustesPrecision;
  }
  
  public String getDesviacionMPI() {
    return this.desviacionMPI;
  }
  
  public void setDesviacionMPI(String desviacionMPI) {
    this.desviacionMPI = desviacionMPI;
  }
  
  Municion municion = new Municion();
  
  public Municion getMunicion() {
    if (this.municionBB == 0) {
      this.municion.setBB(true);
    } else {
      this.municion.setBB(false);
    } 
    this.municion.setTipo(this.nombreMunicion);
    this.municion.setEfecto(this.efectoMunicion);
    this.municion.setNumeroZonas(this.indexMunicionNumZonas + 1);
    this.municion.setCuad_std_peso(this.indexMunicionPesoSTD + 1);
    this.municion.setDiametro(DataTools.toDoubleString(this.manejoMunicion)[0]);
    this.municion.setPesoProyectil(DataTools.toDoubleString(this.manejoMunicion)[1]);
    this.municion.setCamb_cuad_peso(DataTools.toDoubleString(this.manejoMunicion)[2]);
    this.municion.coeficientes.setiX0(DataTools.toDoubleString(this.manejoMunicion)[3]);
    this.municion.setTwist(DataTools.toDoubleString(this.manejoMunicion)[4]);
    int i;
    for (i = 0; i < (DataTools.toDoubleString(this.machArray)).length; i++) {
      this.municion.coeficientes.M[i] = DataTools.toDoubleString(this.machArray)[i];
      this.municion.coeficientes.cD0[i] = DataTools.toDoubleString(this.cdArray)[i];
      this.municion.coeficientes.cDa2[i] = DataTools.toDoubleString(this.cdaArray)[i];
      this.municion.coeficientes.cL[i] = DataTools.toDoubleString(this.clArray)[i];
      this.municion.coeficientes.cL3[i] = DataTools.toDoubleString(this.clArray)[i];
      this.municion.coeficientes.cma[i] = DataTools.toDoubleString(this.cmArray)[i];
      this.municion.coeficientes.cM3[i] = DataTools.toDoubleString(this.cmaArray)[i];
      this.municion.coeficientes.cMag[i] = DataTools.toDoubleString(this.cmagArray)[i];
      this.municion.coeficientes.cLp[i] = DataTools.toDoubleString(this.cspindArray)[i];
      this.municion.coeficientes.cXbb[i] = DataTools.toDoubleString(this.cxbbArray)[i];
      this.municion.coeficientes.iform[i] = DataTools.toDoubleString(this.iformArray)[i];
      this.municion.coeficientes.i0[i] = DataTools.toDoubleString(this.iArray)[i];
    } 
    for (i = 0; i < (DataTools.toDoubleString(this.mcbArray)).length; i++) {
      this.municion.baseBleed.mcb[i] = DataTools.toDoubleString(this.mcbArray)[i];
      this.municion.baseBleed.sc[i] = DataTools.toDoubleString(this.scArray)[i];
    } 
    String[] velPromAux = this.velPromArray.split(";");
    for (int j = 0; j < (this.zonesSelected.split(",")).length; j++) {
      for (int m = 1; m < 8; m++) {
        if (m == DataTools.toIntString(this.zonesSelected)[j]) {
          Zona zona = new Zona((int)DataTools.toDoubleString(this.zoneArray)[m - 1], this.propArray.split(",")[m - 1], DataTools.toDoubleString(this.velArray)[m - 1], DataTools.toDoubleString(velPromAux[m - 1]), DataTools.toDoubleString(this.ajFDArray)[m - 1], DataTools.toDoubleString(this.ajFLA0Array)[m - 1], DataTools.toDoubleString(this.ajiA0Array)[m - 1], DataTools.toDoubleString(this.ajFMagArray)[m - 1], DataTools.toDoubleString(this.gradTempArray)[m - 1], DataTools.toDoubleString(this.pesoVelArray)[m - 1], DataTools.toDoubleString(this.qemaxrArray)[m - 1]);
          zona.setAjusteFla0(DataTools.toDoubleString(this.ajFLA0Array)[m - 1]);
          zona.setAjusteFLa1(DataTools.toDoubleString(this.ajFLA1Array)[m - 1]);
          zona.setAjusteFLa2(DataTools.toDoubleString(this.ajFLA2Array)[m - 1]);
          zona.setAjusteFLa3(DataTools.toDoubleString(this.ajFLA3Array)[m - 1]);
          zona.setAjusteFLa4(DataTools.toDoubleString(this.ajFLA4Array)[m - 1]);
          zona.setAjusteIa0(DataTools.toDoubleString(this.ajiA0Array)[m - 1]);
          zona.setAjusteIa1(DataTools.toDoubleString(this.ajiA1Array)[m - 1]);
          zona.setAjusteIa2(DataTools.toDoubleString(this.ajiA2Array)[m - 1]);
          zona.setAjusteIa3(DataTools.toDoubleString(this.ajiA3Array)[m - 1]);
          zona.setAjusteIa4(DataTools.toDoubleString(this.ajiA4Array)[m - 1]);
          zona.setAjusteTa0(DataTools.toDoubleString(this.ajTimeA0Array)[m - 1]);
          zona.setAjusteTa1(DataTools.toDoubleString(this.ajTimeA1Array)[m - 1]);
          zona.setAjusteTa2(DataTools.toDoubleString(this.ajTimeA2Array)[m - 1]);
          zona.setAjusteTa3(DataTools.toDoubleString(this.ajTimeA3Array)[m - 1]);
          zona.setAjusteTa4(DataTools.toDoubleString(this.ajTimeA4Array)[m - 1]);
          zona.baseBleed.setkP(Double.parseDouble(this.kpArray.split(",")[m - 1]));
          double[] fibb = { Double.parseDouble(this.fibbA0Array.split(",")[m - 1]), Double.parseDouble(this.fibbA1Array.split(",")[m - 1]), Double.parseDouble(this.fibbA2Array.split(",")[m - 1]), Double.parseDouble(this.fibbA3Array.split(",")[m - 1]), Double.parseDouble(this.fibbB1Array.split(",")[m - 1]), Double.parseDouble(this.fibbB2Array.split(",")[m - 1]), Double.parseDouble(this.fibbB3Array.split(",")[m - 1]) };
          zona.baseBleed.setFibb(fibb);
          double[] tdi = { Double.parseDouble(this.tdiA0Array.split(",")[m - 1]), Double.parseDouble(this.tdiA1Array.split(",")[m - 1]), Double.parseDouble(this.tdiA2Array.split(",")[m - 1]), Double.parseDouble(this.tdiA3Array.split(",")[m - 1]) };
          zona.baseBleed.setTdi(tdi);
          double[] tb = { Double.parseDouble(this.tbA0Array.split(",")[m - 1]), Double.parseDouble(this.tbA1Array.split(",")[m - 1]), Double.parseDouble(this.tbA2Array.split(",")[m - 1]), Double.parseDouble(this.tbA3Array.split(",")[m - 1]) };
          zona.baseBleed.setTb(tb);
          if (this.municion.zonas.size() <= this.indexMunicionNumZonas) {
            this.municion.zonas.add(zona);
          } else {
            this.municion.zonas.set(j, zona);
          } 
        } 
      } 
    } 
    String[] espoletasAux = this.espoletas.split(",");
    for (int k = 0; k < this.indexEspoletas + 1; k++) {
      Espoleta espoleta = new Espoleta();
      espoleta.setNombre(espoletasAux[k * 3]);
      espoleta.setPeso(Double.parseDouble(espoletasAux[k * 3 + 1]));
      espoleta.setEfecto(espoletasAux[k * 3 + 2]);
      this.municion.espoletas.add(espoleta);
    } 
    this.municion.baseBleed.setMcb0(DataTools.toDoubleString(this.parametrosBB)[0]);
    this.municion.baseBleed.setmFuell(DataTools.toDoubleString(this.parametrosBB)[1]);
    this.municion.baseBleed.setPropRho(DataTools.toDoubleString(this.parametrosBB)[2]);
    this.municion.baseBleed.setXcg0(DataTools.toDoubleString(this.parametrosBB)[3]);
    this.municion.baseBleed.setXcgb(DataTools.toDoubleString(this.parametrosBB)[4]);
    this.municion.baseBleed.setvC0(DataTools.toDoubleString(this.parametrosBB)[5]);
    this.municion.baseBleed.setBetaVc(DataTools.toDoubleString(this.parametrosBB)[6]);
    this.municion.baseBleed.setK(DataTools.toDoubleString(this.parametrosBB)[7]);
    this.municion.baseBleed.setnVc(DataTools.toDoubleString(this.parametrosBB)[8]);
    this.municion.baseBleed.setDiamBase(DataTools.toDoubleString(this.parametrosBB)[9]);
    this.municion.baseBleed.setAdjustBB(DataTools.toDoubleString(this.parametrosBB)[10]);
    this.municion.setAjVelocidadBoca(DataTools.toDoubleString(this.ajustesPrecision)[0]);
    this.municion.setAjDrag(DataTools.toDoubleString(this.ajustesPrecision)[1]);
    this.municion.setAjElevacion(DataTools.toDoubleString(this.ajustesPrecision)[2]);
    this.municion.setAjA0(DataTools.toDoubleString(this.ajustesPrecision)[3]);
    this.municion.setAjA1(DataTools.toDoubleString(this.ajustesPrecision)[4]);
    this.municion.setDesvUbicacion_m(DataTools.toDoubleString(this.desviacionMPI)[0]);
    this.municion.setDesvAzimut(DataTools.toDoubleString(this.desviacionMPI)[1]);
    this.municion.setDesvUbicacion_m(DataTools.toDoubleString(this.desviacionMPI)[2]);
    this.municion.setDesvUbicacion_Az(DataTools.toDoubleString(this.desviacionMPI)[3]);
    return this.municion;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\model\Ammunition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */