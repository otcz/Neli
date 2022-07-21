package co.dynamicts.neli.core.sensors;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Hardware.InsSerial;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import javafx.application.Platform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateIns extends Thread {
  private static UpdateIns updateIns;
  
  Ins ins = Ins.getSingletonInstance();
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  int acumulador = 1;
  
  public void run() {
    if (!this.configuracion.isSimulado) {
      Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              if (UpdateIns.this.ins.tipoComunicacion == Ins.TipoComunicacion.RS422)
                if ((InsSerial.getSingletonInstance()).comunicacion == true) {
                  UpdateIns.this.acumulador++;
                  if (UpdateIns.this.acumulador > 100)
                    UpdateIns.this.acumulador = 30; 
                  if (UpdateIns.this.acumulador < 0)
                    UpdateIns.this.acumulador = 30; 
                  UpdateIns.this.ins.estadoINS = Ins.EstadoINS.CONNECTED_OK;
                  if (UpdateIns.this.ins.timeOn.getHour() <= 0 && UpdateIns.this.ins.timeOn.getMinutes() <= 4)
                    UpdateIns.this.ins.estadoINS = Ins.EstadoINS.CONNECTED_DISALIGMENT; 
                } else {
                  UpdateIns.this.acumulador--;
                  if (UpdateIns.this.acumulador <= -100) {
                    UpdateIns.this.acumulador = -30;
                    Platform.runLater(() -> {
                          Main.getAppController().setInfoDialog("Error de Conexion", "Ins Desconectado, verifique cableado, energia y reinicie CDU", "ERROR");
                          UpdateIns.this.ins.estadoINS = Ins.EstadoINS.DISCONNECTED;
                        });
                  } 
                }  
            }
          });
      timer.start();
    } 
  }
  
  public static UpdateIns getSingletonInstance() {
    if (updateIns == null)
      updateIns = new UpdateIns(); 
    return updateIns;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\sensors\UpdateIns.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */