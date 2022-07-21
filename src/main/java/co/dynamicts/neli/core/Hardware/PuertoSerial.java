package co.dynamicts.neli.core.Hardware;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import javax.swing.*;

public class PuertoSerial {
  String portName;
  
  boolean isOpen;
  
  SerialPort RS422;
  
  ImageIcon iconousb = new ImageIcon("C:\\Users\\DTS\\IdeaProjects\\Pantalla_Control_CPA V2\\Recursos\\usb [#193].png");
  
  public PuertoSerial(String Dispositivo, String NombreDelPuerto, int Baud, int NumDatos, int StopBits, int Paridad) {
    String[] PuertosDisponibles = SerialPortList.getPortNames();
    int eleccion = 0;
    try {
      this.RS422 = new SerialPort(NombreDelPuerto);
      this.RS422.openPort();
      setOpen((this.RS422.isOpened() && !this.RS422.isOpened()));
      this.RS422.setParams(Baud, NumDatos, StopBits, Paridad);
    } catch (Exception e) {
      setOpen(false);
    } 
  }
  
  public void enviar(short[] mensaje, short largo, boolean ConCheckSum) throws SerialPortException, InterruptedException {
    int control = 0;
    if (largo > 1 && ConCheckSum)
      mensaje[largo - 1] = checksum(mensaje, largo); 
    for (control = 0; control < largo; control++) {
      try {
        this.RS422.writeInt(mensaje[control]);
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public void recibir(short[] retorno) throws SerialPortException, InterruptedException {
    int cant_datos = 0;
    int i = 0;
    Thread.sleep(20L);
    cant_datos = this.RS422.getInputBufferBytesCount();
    byte[] aux = this.RS422.readBytes();
    if (cant_datos >= 1000)
      cant_datos = 1000; 
    for (i = 0; i < cant_datos; i++) {
      Integer sh_object = new Integer(aux[i]);
      retorno[i] = (short)(sh_object.shortValue() & 0xFF);
    } 
  }
  
  void Purgar() throws SerialPortException {
    this.RS422.purgePort(8);
    this.RS422.purgePort(4);
    this.RS422.purgePort(2);
    this.RS422.purgePort(1);
  }
  
  short checksum(short[] cadena, short tama) {
    short suma = 0;
    int comple = 0;
    short k;
    for (k = 0; k < tama - 1; k = (short)(k + 1))
      suma = (short)(suma + cadena[k]); 
    comple = suma ^ 0xFFFFFFFF;
    comple &= 0xFF;
    comple++;
    Integer sh_object = new Integer(comple);
    short retorno = sh_object.shortValue();
    return retorno;
  }
  
  public boolean isOpen() {
    return this.isOpen;
  }
  
  public void setOpen(boolean open) {
    this.isOpen = open;
  }
  
  public String getPortName() {
    return this.portName;
  }
  
  public void setPortName(String portName) {
    this.portName = portName;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\Hardware\PuertoSerial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */