package co.dynamicts.neli.core.interfaces;

import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.Hardware.InsEthernet;
import co.dynamicts.neli.core.ObusHW.CMS;
import co.dynamicts.neli.core.ObusHW.CPA;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.ObusHW.Trinca;
import co.dynamicts.neli.core.trayectoria.Trayectoria;
import co.dynamicts.neli.core.utilities.Posicion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HWObus extends JFrame {
  private static HWObus hwObus;
  
  private JRadioButton INSRadioButton;
  
  private JRadioButton GPSRadioButton;
  
  private JRadioButton CPARadioButton;
  
  private JRadioButton radarBocaRadioButton;
  
  private JRadioButton OdoRadioButton;
  
  private JRadioButton HMSRadioButton;
  
  private JRadioButton CMSRadioButton;
  
  private JRadioButton ZUPTRadioButton;
  
  private JRadioButton trincaRadioButton;
  
  private JRadioButton apuntarRadioButton;
  
  private JRadioButton dispararRadioButton;
  
  private JComboBox comboBoxBandeja;
  
  private JComboBox comboBoxCalibracion;
  
  private JPanel Panel0;
  
  private JComboBox comboBoxTemperatura;
  
  private JTextField distReferencia;
  
  private JTextField textAjusteI;
  
  private JTextField textDriftReferencia;
  
  private JTextField textAjusteFL;
  
  private JLabel lbAjusteTemp;
  
  private JLabel lbAjusteRho;
  
  private JButton updateButton;
  
  public HWObus() {
    super("Simulación Hardware obús 155");

    setContentPane(this.Panel0);
    setBounds(1500, 400, 300, 600);
    setVisible(true);
    this.INSRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.INSRadioButton.isSelected()) {
              (Ins.getSingletonInstance()).estadoINS = Ins.EstadoINS.CONNECTED_OK;
            } else {
              (Ins.getSingletonInstance()).estadoINS = Ins.EstadoINS.DISCONNECTED;
            } 
          }
        });
    this.GPSRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.GPSRadioButton.isSelected()) {
              (Ins.getSingletonInstance()).estadoGPS = Ins.EstadoGPS.CONNECTED_OK;
            } else {
              (Ins.getSingletonInstance()).estadoGPS = Ins.EstadoGPS.DISCONNECTED;
            } 
          }
        });
    this.CPARadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.CPARadioButton.isSelected()) {
              CPA.getSingletonInstance().setCPA(true);
            } else {
              CPA.getSingletonInstance().setCPA(false);
            } 
          }
        });
    this.radarBocaRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {}
        });
    this.OdoRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.OdoRadioButton.isSelected()) {
              Ins.getSingletonInstance().setOdo(true);
            } else {
              Ins.getSingletonInstance().setOdo(false);
            } 
          }
        });
    this.HMSRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.HMSRadioButton.isSelected()) {
              CPA.getSingletonInstance().setHMS(true);
            } else {
              CPA.getSingletonInstance().setHMS(false);
            } 
          }
        });
    this.CMSRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.CMSRadioButton.isSelected()) {
              CMS.getSingletonInstance().setCMS(true);
            } else {
              CMS.getSingletonInstance().setCMS(false);
            } 
          }
        });
    this.ZUPTRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.ZUPTRadioButton.isSelected()) {
              InsEthernet.getSingletonInstance(true).setZuptTiro(true);
            } else {
              InsEthernet.getSingletonInstance(true).setZuptTiro(false);
            } 
          }
        });
    this.trincaRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.trincaRadioButton.isSelected()) {
              Trinca.getSingletonInstance().setTrincaPut(true);
            } else {
              Trinca.getSingletonInstance().setTrincaPut(false);
            } 
          }
        });
    this.apuntarRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.apuntarRadioButton.isSelected()) {
              CPA.getSingletonInstance().setBtnApuntar(true);
            } else {
              CPA.getSingletonInstance().setBtnApuntar(false);
            } 
            System.out.println("CPA.getSingletonInstance().isBtnApuntar() = " + CPA.getSingletonInstance().isBtnApuntar());
          }
        });
    this.dispararRadioButton.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if (HWObus.this.dispararRadioButton.isSelected());
            System.out.println("CPA.getSingletonInstance().isBtnDisparar() = " + CPA.getSingletonInstance().isBtnDisparar());
          }
        });
    String[] bandeja = { "Descargada", "Espera", "Cargada", "Interrumpida" };
    this.comboBoxBandeja.setModel(new DefaultComboBoxModel<>(bandeja));
    String[] calibracion = { "Ok", "Medium ", "Bad" };
    this.comboBoxCalibracion.setModel(new DefaultComboBoxModel<>(calibracion));
    String[] temperatura = { "Ok", "Medium ", "Bad" };
    this.comboBoxTemperatura.setModel(new DefaultComboBoxModel<>(temperatura));
    this.comboBoxBandeja.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            if (HWObus.this.comboBoxBandeja.getSelectedItem() == "Descargada") {
              CPA.getSingletonInstance().setHMS(0);
            } else if (HWObus.this.comboBoxBandeja.getSelectedItem() == "Espera") {
              CPA.getSingletonInstance().setHMS(1);
            } else if (HWObus.this.comboBoxBandeja.getSelectedItem() == "Cargada") {
              CPA.getSingletonInstance().setHMS(2);
            } else if (HWObus.this.comboBoxBandeja.getSelectedItem() == "Interrumpida") {
              CPA.getSingletonInstance().setHMS(3);
            } 
          }
        });
    this.comboBoxCalibracion.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            if (HWObus.this.comboBoxCalibracion.getSelectedItem() == "Ok") {
              CPA.getSingletonInstance().setIsCalibrated(0);
            } else if (HWObus.this.comboBoxCalibracion.getSelectedItem() == "Medium") {
              CPA.getSingletonInstance().setIsCalibrated(1);
            } else if (HWObus.this.comboBoxCalibracion.getSelectedItem() == "Bad") {
              CPA.getSingletonInstance().setIsCalibrated(2);
            } 
          }
        });
    this.comboBoxTemperatura.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            if (HWObus.this.comboBoxTemperatura.getSelectedItem() == "Ok") {
              CMS.getSingletonInstance().setTemCanonState(0);
            } else if (HWObus.this.comboBoxTemperatura.getSelectedItem() == "Medium") {
              CMS.getSingletonInstance().setTemCanonState(1);
            } else if (HWObus.this.comboBoxTemperatura.getSelectedItem() == "Bad") {
              CMS.getSingletonInstance().setTemCanonState(2);
            } 
          }
        });
    this.updateButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            double distRef = Double.parseDouble(HWObus.this.distReferencia.getText());
            double driftRef = Double.parseDouble(HWObus.this.textDriftReferencia.getText());
            Posicion posicion = (DatosApuntados.getSingletonInstance()).posicionApuntadaMetros;
            double elevacion = (Ins.getSingletonInstance()).actitud.getElevacion();
            double distancia = 0.0D;
            double iform = 2.0D;
            double fLift = 1.0D;
            fLift = Double.parseDouble(HWObus.this.textAjusteFL.getText());
            Trayectoria trayectoria = new Trayectoria();
            while (distancia < distRef) {
              iform -= 0.001D;
              distancia = trayectoria.calculaDistanciaIForm(posicion, elevacion, iform, fLift);
            } 
            double fL = 0.0D;
            double drift = 0.0D;
            Trayectoria trayectoria1 = new Trayectoria();
            while (drift > driftRef) {
              fL += 0.001D;
              trayectoria1.calculaDistanciaIForm(posicion, elevacion, iform, fL);
              drift = trayectoria1.getTDC();
            } 
            HWObus.this.textAjusteFL.setText(String.valueOf(fL));
            HWObus.this.textAjusteI.setText(String.valueOf(iform));
          }
        });
  }
  
  public static HWObus getSingletonInstance() {
    if (hwObus == null)
      hwObus = new HWObus(); 
    return hwObus;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\interfaces\HWObus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */