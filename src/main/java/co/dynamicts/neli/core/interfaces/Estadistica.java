package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.utilities.DatosEstadistica;
import co.dynamicts.neli.core.utilities.Tools;

import java.io.*;

public class Estadistica extends Tools {
  public DatosEstadistica getObjdatosEstadistica() {
    return this.objdatosEstadistica;
  }
  
  public void setObjdatosEstadistica(DatosEstadistica objdatosEstadistica) {
    this.objdatosEstadistica = objdatosEstadistica;
  }
  
  private DatosEstadistica objdatosEstadistica = new DatosEstadistica(0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0D);
  
  public Estadistica() {
    actualizarEstadistica("105 mm - HE M1", 1, 23.23D);
    leerEstadistica();
  }
  
  public void leerEstadistica() {
    try {
      FileInputStream inputStream = new FileInputStream(getAppDataFile() + "Estadistica.dat");
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
      setObjdatosEstadistica((DatosEstadistica)objectInputStream.readObject());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } 
  }
  
  public void actualizarEstadistica(String tipocarga, int carga, double temperatura) {
    int[] estatistica = { this.objdatosEstadistica.getCarga1(), this.objdatosEstadistica.getCarga2(), this.objdatosEstadistica.getCarga3(), this.objdatosEstadistica.getCarga4(), this.objdatosEstadistica.getCarga5(), this.objdatosEstadistica.getCarga6(), this.objdatosEstadistica.getCarga7(), this.objdatosEstadistica.getRango1(), this.objdatosEstadistica.getRango2() };
    double desgasteEFC = this.objdatosEstadistica.getEfc();
    if (tipocarga.equals("105 mm - HE M1")) {
      if (carga == 1 || carga == 0) {
        estatistica[0] = estatistica[0] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.36D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.36D;
        } 
      } else if (carga == 2) {
        estatistica[1] = estatistica[1] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.36D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.36D;
        } 
      } else if (carga == 3) {
        estatistica[2] = estatistica[2] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.36D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.36D;
        } 
      } else if (carga == 4) {
        estatistica[3] = estatistica[3] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.55D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.45D;
        } 
      } else if (carga == 5) {
        estatistica[4] = estatistica[4] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.55D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.45D;
        } 
      } else if (carga == 6) {
        estatistica[5] = estatistica[5] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.64D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.55D;
        } 
      } else if (carga == 7) {
        estatistica[6] = estatistica[6] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 1.09D;
        } else if (temperatura < 35.0D) {
          desgasteEFC++;
        } 
      } 
    } else if (tipocarga.equals("105mm HE ER-50 ")) {
      if (carga == 1 || carga == 0) {
        estatistica[7] = estatistica[7] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 0.41D;
        } else if (temperatura < 35.0D) {
          desgasteEFC += 0.34D;
        } 
      } 
      if (carga == 2) {
        estatistica[8] = estatistica[8] + 1;
        if (temperatura >= 35.0D) {
          desgasteEFC += 1.2D;
        } else if (temperatura < 35.0D) {
          desgasteEFC++;
        } 
      } 
    } 
    this.objdatosEstadistica = new DatosEstadistica(0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0D);
    try {
      FileOutputStream outputStream = new FileOutputStream(getAppDataFile() + "Estadistica.dat");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
      objectOutputStream.writeObject(getObjdatosEstadistica());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    leerEstadistica();
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\Estadistica.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */