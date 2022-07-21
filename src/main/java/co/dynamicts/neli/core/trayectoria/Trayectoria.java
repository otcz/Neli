package co.dynamicts.neli.core.trayectoria;

import co.dynamicts.Main;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.models.Boletin;
import co.dynamicts.neli.core.municion.Coeficientes;
import co.dynamicts.neli.core.municion.Municion;
import co.dynamicts.neli.core.utilities.Posicion;
import co.dynamicts.neli.ui.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collections;

public class Trayectoria {
  Municion municion;
  
  Configuracion configuracion = Configuracion.getSingletonInstance();
  
  Boletin boletin = Boletin.getSingletonInstance();
  
  private boolean isPosible;
  
  double time;
  
  double x = 0.0D;
  
  double y = 0.0D;
  
  double z = 0.0D;
  
  double ax = 0.0D;
  
  double ay = 0.0D;
  
  double az = 0.0D;
  
  double anguloAtaque = 0.0D;
  
  double anguloReposoX = 0.0D;
  
  double anguloReposoY = 0.0D;
  
  double anguloReposoZ = 0.0D;
  
  double vTotal;
  
  double ordMax;
  
  public ArrayList<Double> r = new ArrayList<>();
  
  public ArrayList<Double> h = new ArrayList<>();
  
  double Z_wind;
  
  public ArrayList<Double> Z_wind_array = new ArrayList<>();
  
  double Deflection_angle_corr;
  
  double Drift_deflection_corr;
  
  double TDC;
  
  double sigma_PX_PE = 0.0D;
  
  double sigma_PZ_PE = 0.0D;
  
  double sigma_X_MPI = 0.0D;
  
  double sigma_Z_MPI = 0.0D;
  
  public static double ajusteRho = 1.0D;
  
  public static double ajusteTemp = 1.0D;
  
  double vX;
  
  double vY;
  
  double vZ = 0.0D;
  
  int n = 0;
  
  double V_Z_wind;
  
  double temp;
  
  double rho;
  
  double pressure;
  
  double Vs;
  
  double angleInProjW0;
  
  double wx;
  
  double wz;
  
  double wNew;
  
  double PI = Math.PI;
  
  double G = 9.80665D;
  
  double R = 287.05D;
  
  double RGROUND = 6356766.0D;
  
  double KAPPA = 1.402D;
  
  double dt = 0.01D;
  
  double diametro;
  
  double acelDeflexion;
  
  public double projectileMass;
  
  double I = 0.0D;
  
  public double calculaDistanciaIForm(Posicion posicion, double elevacion, double iform, double forceL) {
    try {
      clear();
      this.municion = (Configuracion.getSingletonInstance()).municion;
      if (this.municion.zonaSelec.getVelBocaStd() != 0.0D) {
        this.diametro = this.municion.getDiametro() / 1000.0D;
        this.acelDeflexion = this.municion.getAcel_deflexion();
        this.projectileMass = this.municion.getPesoProyectil(this.configuracion.getCuadros());
        Coeficientes coeficientes = new Coeficientes();
        coeficientes = this.municion.coeficientes;
        double orientacionTiro = posicion.getAzimut();
        double u0 = this.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
        double cuadrante = elevacion * 9.8E-4D;
        double az0 = orientacionTiro * 9.8E-4D;
        double lat0 = Math.toRadians(posicion.puntoA.getLatitud());
        this.y = posicion.puntoA.getAltura() + 4.0D;
        if (u0 == 0.0D)
          u0 = this.municion.zonaSelec.getVelBocaStd(); 
        double ux0 = u0 * Math.cos(cuadrante);
        double uy0 = u0 * Math.sin(cuadrante);
        double angleW = this.boletin.getAzWindGeneric();
        this.angleInProjW0 = (angleW - orientacionTiro) * 9.81747E-4D;
        double speedW = this.boletin.getVelWindGeneric();
        speedW *= 0.514D;
        this.wx = speedW * Math.cos(this.angleInProjW0);
        this.wz = speedW * Math.sin(this.angleInProjW0);
        this.wNew = speedW;
        this.vX = ux0 - this.wx;
        this.vY = uy0;
        this.vZ = this.wz;
        this.vTotal = u0;
        this.V_Z_wind = 0.0D;
        this.Z_wind = 0.0D;
        double twist = this.municion.getTwist();
        double p = 2.0D * this.PI * u0 / twist * 0.155D;
        this.G = 9.80665D * (1.0D - 0.0026D * Math.cos(2.0D * lat0));
        this.h.add(Double.valueOf(this.y));
        this.r.add(Double.valueOf(this.x));
        double mcb0 = this.municion.baseBleed.getMcb0();
        double m = this.municion.isBB() ? (this.projectileMass - mcb0) : this.projectileMass;
        double tb = 0.0D;
        while (u0 >= 0.0D) {
          try {
            this.n++;
            if (this.boletin.getArea() == 0) {
              double alturaBoletin = this.y - posicion.puntoA.getAltura();
              if (alturaBoletin < 0.0D)
                alturaBoletin = 0.0D; 
              this.boletin.calculeAccoustic(this.y);
              this.temp = this.boletin.getTempBoletin();
              this.rho = this.boletin.getRhoBoletin();
              this.pressure = this.boletin.getPressureBoletin() * 100.0D;
            } else {
              this.temp = this.boletin.getTemp(this.y, 1.0D);
              this.rho = this.boletin.getRho(this.boletin.getPressure(this.y), this.boletin.getTemp(this.y, 1.0D), 1.0D);
              this.pressure = this.boletin.getPressure(this.y) * 100.0D;
            } 
            this.Vs = Math.sqrt(this.KAPPA * this.R * this.temp);
            double M = this.vTotal / this.Vs;
            double Ixx = this.municion.coeficientes.getiX0();
            double CM3 = this.municion.coeficientes.cM3_coeff(M);
            double Cd = coeficientes.Drag_coeff(M);
            double Cd2 = coeficientes.CDa2_coeff(M);
            double Cl = coeficientes.lift_coeff(M);
            double Cl3 = coeficientes.cL3_coeff(M);
            double cma = coeficientes.Cma_coeff(M);
            double Cxbb = coeficientes.base_coeff(M);
            double productoCruzX = this.vY * this.az - this.vZ * this.ay;
            double productoCruzY = this.vZ * this.ax - this.vX * this.az;
            double productoCruzZ = this.vX * this.ay - this.vY * this.ax;
            this.anguloReposoX = -8.0D * Ixx * p * productoCruzX / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            this.anguloReposoY = -8.0D * Ixx * p * productoCruzY / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            this.anguloReposoZ = -8.0D * Ixx * p * productoCruzZ / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            double magnitudAnguloReposo = Math.sqrt(Math.pow(this.anguloReposoX, 2.0D) + Math.pow(this.anguloReposoY, 2.0D) + Math.pow(this.anguloReposoZ, 2.0D));
            this.anguloAtaque = Math.asin(magnitudAnguloReposo);
            double vectorAtaqueX = 8.0D * Ixx * p * productoCruzX / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double vectorAtaqueY = 8.0D * Ixx * p * productoCruzY / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double vectorAtaqueZ = 8.0D * Ixx * p * productoCruzZ / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double ajusteCD = this.municion.zonaSelec.getAjusteCD();
            double ajustei = iform;
            double fD = -(this.PI * this.rho * ajustei * Math.pow(this.diametro, 2.0D) / 8.0D) * (Cd + Cd2 * ajusteCD * Math.pow(this.anguloAtaque, 2.0D)) * this.vTotal;
            double fDx = fD * this.vX;
            double fDy = fD * this.vY;
            double fDz = fD * this.vZ;
            double ajusteFl = forceL;
            double qM = this.municion.zonaSelec.getAjusteMag();
            double fL = this.PI * this.rho * Math.pow(this.diametro, 2.0D) * ajusteFl / 8.0D * (Cl + Cl3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 2.0D);
            double fLx = fL * vectorAtaqueX;
            double fLy = fL * vectorAtaqueY;
            double fLz = fL * vectorAtaqueZ;
            double CMag = coeficientes.CMag_coeff(M);
            double fM = Math.pow(this.diametro, 3.0D) * qM * p * this.rho * CMag / 8.0D;
            double fMx = fM * (vectorAtaqueY * this.vZ - vectorAtaqueZ * this.vY);
            double fMy = fM * (vectorAtaqueZ * this.vX - vectorAtaqueX * this.vZ);
            double fMz = fM * (vectorAtaqueX * this.vY - vectorAtaqueY * this.vX);
            double wx = 7.292115E-5D * Math.cos(lat0) * Math.cos(az0);
            double wy = 7.292115E-5D * Math.sin(lat0);
            double wz = -7.292115E-5D * Math.cos(lat0) * Math.sin(az0);
            double fCx = -2.0D * this.projectileMass * (wy * this.vZ - wz * this.vY);
            double fCy = -2.0D * this.projectileMass * (wz * this.vX - wx * this.vZ);
            double fCz = -2.0D * this.projectileMass * (wx * this.vY - wy * this.vX);
            double mT = this.configuracion.getTempProp();
            double BBfx = 0.0D;
            double BBfy = 0.0D;
            double BBfz = 0.0D;
            double dti = this.municion.zonaSelec.baseBleed.getTdi(mT);
            if (this.municion.isBB() && this.n * this.dt >= dti && this.n * this.dt < this.municion.zonaSelec.baseBleed.getTb(mT))
              try {
                double mb = this.projectileMass - this.municion.baseBleed.getmFuell();
                double fiBB = this.municion.zonaSelec.baseBleed.getFibb(elevacion, mT);
                double kP = this.municion.zonaSelec.baseBleed.getkP();
                double mcb = this.projectileMass - m;
                double sC = 0.0D;
                sC = this.municion.baseBleed.sc_coeff(mcb);
                double vC0 = this.municion.baseBleed.getvC0();
                double betaVc = this.municion.baseBleed.getBetaVc();
                double fmT = Math.exp(betaVc * (mT - 21.0D));
                double k = this.municion.baseBleed.getK();
                double nVc = this.municion.baseBleed.getnVc();
                double gp = k * Math.pow(this.pressure, nVc);
                double vC = vC0 * fmT * gp * kP * 0.85D;
                double propRho = this.municion.baseBleed.getPropRho();
                double diamBase = this.municion.baseBleed.getDiamBase();
                double I0 = coeficientes.i0_coeff(M);
                double fi = 0.0D;
                if (m > mb) {
                  double derivada_m = -vC * propRho * sC;
                  double m1 = derivada_m * this.dt + m;
                  m = m1;
                  tb = this.n * this.dt;
                  double derivada_mf = -derivada_m;
                  this.I = 4.0D * derivada_mf / this.PI * Math.pow(diamBase, 2.0D) * this.rho * this.vTotal;
                  fi = this.I / I0;
                } else {
                  fi = 0.0D;
                } 
                if (this.I > I0)
                  fi = 1.0D; 
                BBfx = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vX * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueX);
                BBfy = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vY * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueY);
                BBfz = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vZ * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueZ);
              } catch (Exception e) {
                System.out.println("Error en configuracion BB");
                break;
              }  
            this.ax = (fDx + fMx + fLx + BBfx + fCx) / m;
            this.ay = -this.G * (1.0D - 2.0D * this.x / this.RGROUND) + (fDy + fMy + fLy + BBfy + fCy) / m;
            this.az = (fDz + fLz + fMz + BBfz + fCz) / m;
            if (Double.isNaN(this.ay)) {
              System.out.println(" ay es nan");
              Main.getAppController().setInfoMessage(StringUtil.translateKey("status.ammo.bug"), "ERROR");
              System.out.println("error en configuracion de municion");
              return 0.0D;
            } 
            double vx1 = this.ax * this.dt + this.vX;
            double vy1 = this.ay * this.dt + this.vY;
            double vz1 = this.az * this.dt + this.vZ;
            double x1 = vx1 * this.dt + this.x;
            double y1 = vy1 * this.dt + this.y;
            double z1 = vz1 * this.dt + this.z + this.V_Z_wind;
            if (this.angleInProjW0 >= 0.0D && this.angleInProjW0 <= 180.0D) {
              fLz = fDz;
            } else {
              fDz = -fDz;
            } 
            this.x = x1;
            this.y = y1;
            this.z = z1;
            this.vX = vx1;
            this.vY = vy1;
            this.vZ = vz1;
            this.vTotal = Math.sqrt(Math.pow(this.vX, 2.0D) + Math.pow(this.vY, 2.0D) + Math.pow(this.vZ, 2.0D));
            double acelP = this.PI * this.rho * Math.pow(this.diametro, 4.0D) * p * this.vTotal * coeficientes.cLp_coeff(M) / 8.0D * Ixx;
            p += acelP * this.dt;
            this.h.add(Double.valueOf(this.y));
            this.r.add(Double.valueOf(this.x));
            this.Z_wind_array.add(Double.valueOf(this.Z_wind));
            if (((Double)this.h.get(this.n - 1)).doubleValue() > ((Double)this.h.get(this.n)).doubleValue())
              if (this.y <= posicion.puntoB.getAltura() + 4.0D)
                break;  
          } catch (Exception e) {
            System.out.println("Error en ciclo de calculo trayectoria");
            e.printStackTrace();
          } 
        } 
        this.time = this.n * this.dt;
        this.ordMax = ((Double)Collections.<Double>max(this.h)).doubleValue();
        this.Deflection_angle_corr = -this.Z_wind * 1018.59D / this.x;
        double Drift_deflection = this.z / getX() / 1000.0D;
        this.Drift_deflection_corr = Drift_deflection;
        this.TDC = this.Deflection_angle_corr + this.Drift_deflection_corr;
        setPosible(true);
      } 
    } catch (Exception e) {
      setPosible(false);
      System.out.println(" Error de clase trayectoria.calcula distancia: " + e);
      e.printStackTrace();
    } 
    double projectileRange = Math.sqrt(Math.pow(this.x, 2.0D) + Math.pow(this.z, 2.0D));
    return projectileRange;
  }
  
  public double calculaDistancia(Posicion posicion, double elevacion) {
    try {
      clear();
      this.municion = (Configuracion.getSingletonInstance()).municion;
      if (this.municion.zonaSelec.getVelBocaStd() != 0.0D) {
        this.diametro = this.municion.getDiametro() / 1000.0D;
        this.acelDeflexion = this.municion.getAcel_deflexion();
        this.projectileMass = this.municion.getPesoProyectil(this.configuracion.getCuadros());
        Coeficientes coeficientes = new Coeficientes();
        coeficientes = this.municion.coeficientes;
        double orientacionTiro = posicion.getAzimut();
        double u0 = this.municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
        double cuadrante = elevacion * 9.8E-4D;
        double az0 = orientacionTiro * 9.8E-4D;
        double lat0 = Math.toRadians(posicion.puntoA.getLatitud());
        this.y = posicion.puntoA.getAltura() + 4.0D;
        if (u0 == 0.0D)
          u0 = this.municion.zonaSelec.getVelBocaStd(); 
        double ux0 = u0 * Math.cos(cuadrante);
        double uy0 = u0 * Math.sin(cuadrante);
        double angleW = this.boletin.getAzWindGeneric();
        this.angleInProjW0 = (angleW - orientacionTiro) * 9.81747E-4D;
        double speedW = this.boletin.getVelWindGeneric();
        speedW *= 0.514D;
        this.wx = speedW * Math.cos(this.angleInProjW0);
        this.wz = speedW * Math.sin(this.angleInProjW0);
        this.wNew = speedW;
        this.vX = ux0 - this.wx;
        this.vY = uy0;
        this.vZ = this.wz;
        this.vTotal = u0;
        this.V_Z_wind = 0.0D;
        this.Z_wind = 0.0D;
        double twist = this.municion.getTwist();
        double p = 2.0D * this.PI * u0 / twist * 0.155D;
        this.G = 9.80665D * (1.0D - 0.0026D * Math.cos(2.0D * lat0));
        this.h.add(Double.valueOf(this.y));
        this.r.add(Double.valueOf(this.x));
        double mcb0 = this.municion.baseBleed.getMcb0();
        double m = this.municion.isBB() ? (this.projectileMass - mcb0) : this.projectileMass;
        double tb = 0.0D;
        while (u0 >= 0.0D) {
          try {
            this.n++;
            if (this.boletin.getArea() == 0) {
              double alturaBoletin = this.y - posicion.puntoA.getAltura();
              if (alturaBoletin < 0.0D)
                alturaBoletin = 0.0D; 
              this.boletin.calculeAccoustic(alturaBoletin);
              this.temp = this.boletin.getTempBoletin();
              this.rho = this.boletin.getRhoBoletin();
              this.pressure = this.boletin.getPressureBoletin() * 100.0D;
            } else {
              this.temp = this.boletin.getTemp(this.y, 1.0D);
              this.rho = this.boletin.getRho(this.boletin.getPressure(this.y), this.boletin.getTemp(this.y, 1.0D), 1.0D);
              this.pressure = this.boletin.getPressure(this.y) * 100.0D;
            } 
            this.Vs = Math.sqrt(this.KAPPA * this.R * this.temp);
            double M = this.vTotal / this.Vs;
            double Ixx = this.municion.coeficientes.getiX0();
            double CM3 = this.municion.coeficientes.cM3_coeff(M);
            double Cd = coeficientes.Drag_coeff(M);
            double Cd2 = coeficientes.CDa2_coeff(M);
            double Cl = coeficientes.lift_coeff(M);
            double Cl3 = coeficientes.cL3_coeff(M);
            double cma = coeficientes.Cma_coeff(M);
            double Cxbb = coeficientes.base_coeff(M);
            double productoCruzX = this.vY * this.az - this.vZ * this.ay;
            double productoCruzY = this.vZ * this.ax - this.vX * this.az;
            double productoCruzZ = this.vX * this.ay - this.vY * this.ax;
            this.anguloReposoX = -8.0D * Ixx * p * productoCruzX / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            this.anguloReposoY = -8.0D * Ixx * p * productoCruzY / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            this.anguloReposoZ = -8.0D * Ixx * p * productoCruzZ / this.rho * this.PI * Math.pow(this.diametro, 3.0D) * Math.pow(this.vTotal, 4.0D) * cma;
            double magnitudAnguloReposo = Math.sqrt(Math.pow(this.anguloReposoX, 2.0D) + Math.pow(this.anguloReposoY, 2.0D) + Math.pow(this.anguloReposoZ, 2.0D));
            this.anguloAtaque = Math.asin(magnitudAnguloReposo);
            double vectorAtaqueX = 8.0D * Ixx * p * productoCruzX / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double vectorAtaqueY = 8.0D * Ixx * p * productoCruzY / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double vectorAtaqueZ = 8.0D * Ixx * p * productoCruzZ / this.PI * this.rho * Math.pow(this.diametro, 3.0D) * (cma + CM3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 4.0D);
            double ajusteCD = this.municion.zonaSelec.getAjusteCD();
            double ajustei = this.municion.zonaSelec.getAjusteI(elevacion);
            double fD = ajusteCD * -(this.PI * this.rho * ajustei * Math.pow(this.diametro, 2.0D) / 8.0D) * (Cd + Cd2 * ajusteCD * Math.pow(this.anguloAtaque, 2.0D)) * this.vTotal;
            double fDx = fD * this.vX;
            double fDy = fD * this.vY;
            double fDz = fD * this.vZ;
            double ajusteFl = this.municion.zonaSelec.getAjusteFL(elevacion);
            double qM = this.municion.zonaSelec.getAjusteMag();
            double fL = qM * this.PI * this.rho * Math.pow(this.diametro, 2.0D) * ajusteFl / 8.0D * (Cl + Cl3 * Math.pow(this.anguloAtaque, 2.0D)) * Math.pow(this.vTotal, 2.0D);
            double fLx = fL * vectorAtaqueX;
            double fLy = fL * vectorAtaqueY;
            double fLz = fL * vectorAtaqueZ;
            double CMag = coeficientes.CMag_coeff(M);
            double fM = Math.pow(this.diametro, 3.0D) * qM * p * this.rho * CMag / 8.0D;
            double fMx = fM * (vectorAtaqueY * this.vZ - vectorAtaqueZ * this.vY);
            double fMy = fM * (vectorAtaqueZ * this.vX - vectorAtaqueX * this.vZ);
            double fMz = fM * (vectorAtaqueX * this.vY - vectorAtaqueY * this.vX);
            double wx = 7.292115E-5D * Math.cos(lat0) * Math.cos(az0);
            double wy = 7.292115E-5D * Math.sin(lat0);
            double wz = -7.292115E-5D * Math.cos(lat0) * Math.sin(az0);
            double fCx = -2.0D * this.projectileMass * (wy * this.vZ - wz * this.vY);
            double fCy = -2.0D * this.projectileMass * (wz * this.vX - wx * this.vZ);
            double fCz = -2.0D * this.projectileMass * (wx * this.vY - wy * this.vX);
            double mT = this.configuracion.getTempProp();
            double BBfx = 0.0D;
            double BBfy = 0.0D;
            double BBfz = 0.0D;
            double dti = this.municion.zonaSelec.baseBleed.getTdi(mT);
            if (this.municion.isBB() && this.n * this.dt >= dti && this.n * this.dt < this.municion.zonaSelec.baseBleed.getTb(mT))
              try {
                double mb = this.projectileMass - this.municion.baseBleed.getmFuell();
                double fiBB = this.municion.zonaSelec.baseBleed.getFibb(elevacion, mT);
                double kP = this.municion.zonaSelec.baseBleed.getkP();
                double mcb = this.projectileMass - m;
                double sC = 0.0D;
                sC = this.municion.baseBleed.sc_coeff(mcb);
                double vC0 = this.municion.baseBleed.getvC0();
                double betaVc = this.municion.baseBleed.getBetaVc();
                double fmT = Math.exp(betaVc * (mT - 21.0D));
                double k = this.municion.baseBleed.getK();
                double nVc = this.municion.baseBleed.getnVc();
                double gp = k * Math.pow(this.pressure, nVc);
                double vC = vC0 * fmT * gp * kP * 0.85D;
                double propRho = this.municion.baseBleed.getPropRho();
                double diamBase = this.municion.baseBleed.getDiamBase();
                double I0 = coeficientes.i0_coeff(M);
                double fi = 0.0D;
                if (m > mb) {
                  double derivada_m = -vC * propRho * sC;
                  double m1 = derivada_m * this.dt + m;
                  m = m1;
                  tb = this.n * this.dt;
                  double derivada_mf = -derivada_m;
                  this.I = 4.0D * derivada_mf / this.PI * Math.pow(diamBase, 2.0D) * this.rho * this.vTotal;
                  fi = this.I / I0;
                } else {
                  fi = 0.0D;
                } 
                if (this.I > I0)
                  fi = 1.0D; 
                BBfx = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vX * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueX);
                BBfy = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vY * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueY);
                BBfz = this.PI / 8.0D * this.rho * Math.pow(this.diametro, 2.0D) * Math.pow(this.vTotal, 2.0D) * Cxbb * fi * fiBB * (this.vZ * Math.cos(this.anguloAtaque) / this.vTotal + vectorAtaqueZ);
              } catch (Exception e) {
                System.out.println("Error en configuracion BB");
                break;
              }  
            this.ax = (fDx + fMx + fLx + BBfx + fCx) / m;
            this.ay = -this.G * (1.0D - 2.0D * this.x / this.RGROUND) + (fDy + fMy + fLy + BBfy + fCy) / m;
            this.az = (fDz + fLz + fMz + BBfz + fCz) / m;
            if (Double.isNaN(this.ay)) {
              System.out.println(" ay es nan");
              Main.getAppController().setInfoMessage(StringUtil.translateKey("status.ammo.bug"), "ERROR");
              System.out.println("error en configuracion de municion");
              return 0.0D;
            } 
            double vx1 = this.ax * this.dt + this.vX;
            double vy1 = this.ay * this.dt + this.vY;
            double vz1 = this.az * this.dt + this.vZ;
            double x1 = vx1 * this.dt + this.x;
            double y1 = vy1 * this.dt + this.y;
            double z1 = vz1 * this.dt + this.z + this.V_Z_wind;
            if (this.angleInProjW0 >= 0.0D && this.angleInProjW0 <= 180.0D) {
              fLz = fDz;
            } else {
              fDz = -fDz;
            } 
            this.x = x1;
            this.y = y1;
            this.z = z1;
            this.vX = vx1;
            this.vY = vy1;
            this.vZ = vz1;
            this.vTotal = Math.sqrt(Math.pow(this.vX, 2.0D) + Math.pow(this.vY, 2.0D) + Math.pow(this.vZ, 2.0D));
            double acelP = this.PI * this.rho * Math.pow(this.diametro, 4.0D) * p * this.vTotal * coeficientes.cLp_coeff(M) / 8.0D * Ixx;
            p += acelP * this.dt;
            this.h.add(Double.valueOf(this.y));
            this.r.add(Double.valueOf(this.x));
            this.Z_wind_array.add(Double.valueOf(this.Z_wind));
            if (((Double)this.h.get(this.n - 1)).doubleValue() > ((Double)this.h.get(this.n)).doubleValue())
              if (this.y <= posicion.puntoB.getAltura() + 4.0D)
                break;  
          } catch (Exception e) {
            System.out.println("Error en ciclo de calculo trayectoria");
            e.printStackTrace();
          } 
        } 
        this.time = this.n * this.dt;
        this.ordMax = ((Double)Collections.<Double>max(this.h)).doubleValue();
        this.Deflection_angle_corr = -this.Z_wind * 1018.59D / this.x;
        double Drift_deflection = this.z / getX() / 1000.0D;
        this.Drift_deflection_corr = Drift_deflection;
        this.TDC = this.Deflection_angle_corr + this.Drift_deflection_corr;
        setPosible(true);
      } 
    } catch (Exception e) {
      setPosible(false);
      System.out.println(" Error de clase trayectoria.calcula distancia: " + e);
      e.printStackTrace();
    } 
    double projectileRange = Math.sqrt(Math.pow(this.x, 2.0D) + Math.pow(this.z, 2.0D));
    return projectileRange;
  }
  
  public double calculaAnguloMilsRas(Posicion posicion) {
    double distancia = posicion.getDistancia();
    double elevacion = 0.0D;
    int elev1;
    for (elev1 = -100; elev1 < 1000; elev1 += 100) {
      if (calculaDistancia(posicion, elev1) < distancia && distancia < calculaDistancia(posicion, (elev1 + 100))) {
        int elev2;
        for (elev2 = 0; elev2 < 100; elev2 += 20) {
          if (calculaDistancia(posicion, (elev1 + elev2)) < distancia && distancia < calculaDistancia(posicion, (elev1 + elev2 + 20))) {
            int elev3;
            for (elev3 = 0; elev3 < 20; elev3 += 5) {
              if (calculaDistancia(posicion, (elev1 + elev2 + elev3)) < distancia && distancia < calculaDistancia(posicion, (elev1 + elev2 + elev3 + 5)))
                for (int elev4 = 0; elev4 < 5; elev4++) {
                  if (calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4)) < distancia && distancia < calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4 + 1))) {
                    double elev5;
                    for (elev5 = 0.0D; elev5 < 1.0D; elev5 += 0.1D) {
                      if (calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4) + elev5) < distancia && distancia < calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4) + elev5 + 0.1D)) {
                        elevacion = (elev1 + elev2 + elev3 + elev4) + elev5;
                        if (elevacion < this.municion.zonaSelec.getQeMaxR()) {
                          setPosible(true);
                          return elevacion;
                        } 
                        setPosible(false);
                      } 
                    } 
                  } 
                }  
            } 
          } 
        } 
      } 
    } 
    if (elevacion == 0.0D)
      setPosible(false); 
    return elevacion;
  }
  
  public double calculaAnguloMilsGA(Posicion posicion) {
    double distancia = posicion.getDistancia();
    double elevacion = 800.0D;
    int elev1;
    for (elev1 = 800; elev1 < 1300; elev1 += 100) {
      if (calculaDistancia(posicion, elev1) > distancia && distancia > calculaDistancia(posicion, (elev1 + 100))) {
        int elev2;
        for (elev2 = 0; elev2 < 100; elev2 += 20) {
          if (calculaDistancia(posicion, (elev1 + elev2)) > distancia && distancia > calculaDistancia(posicion, (elev1 + elev2 + 20))) {
            int elev3;
            for (elev3 = 0; elev3 < 20; elev3 += 5) {
              if (calculaDistancia(posicion, (elev1 + elev2 + elev3)) > distancia && distancia > calculaDistancia(posicion, (elev1 + elev2 + elev3 + 5)))
                for (int elev4 = 0; elev4 < 5; elev4++) {
                  if (calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4)) > distancia && distancia > calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4 + 1))) {
                    double elev5;
                    for (elev5 = 0.0D; elev5 < 1.0D; elev5 += 0.1D) {
                      if (calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4) + elev5) > distancia && distancia > calculaDistancia(posicion, (elev1 + elev2 + elev3 + elev4) + elev5 + 0.1D)) {
                        elevacion = (elev1 + elev2 + elev3 + elev4) + elev5;
                        if (elevacion > this.municion.zonaSelec.getQeMaxR() && elevacion < 1000.0D) {
                          setPosible(true);
                          return elevacion;
                        } 
                        setPosible(false);
                      } 
                    } 
                  } 
                }  
            } 
          } 
        } 
      } 
    } 
    if (elevacion == 800.0D)
      setPosible(false); 
    return elevacion;
  }
  
  public void calculaError(Posicion posicion, double elevacion) {
    double dR_dtheta = 0.0D;
    double dR_dVt = 0.0D;
    double dR_drho = 0.0D;
    double dR_dtemp = 0.0D;
    double dR_dwind = 0.0D;
    double dZ_dDrift = 0.0D;
    double dZ_dalpha = 0.0D;
    double dZ_dwind = 0.0D;
    double sigma_rho_MPI = 0.0D;
    double sigma_WIND_MPI = 0.0D;
    double sigma_TEMP_MPI = 0.0D;
    double vary_windspeed_x = 1.0D;
    double vary_windspeed_z = 1.0D;
    double vary_temp = 1.0D;
    double vary_rho = 1.0D;
    MetDesviacion metDesviacion = new MetDesviacion();
    metDesviacion.processMet(4.0D);
    sigma_rho_MPI = metDesviacion.getSigma_density();
    sigma_WIND_MPI = metDesviacion.getSigma_wind();
    sigma_TEMP_MPI = metDesviacion.getSigma_temp();
    double Vm_direction = (Ins.getSingletonInstance()).actitud.getAzimut();
    Boletin boletin = Boletin.getSingletonInstance();
    double Wind_direction = boletin.getAzWindGeneric();
    double Wind_speed = boletin.getVelWindGeneric();
    double Temp_variation = 1.0D;
    double Density_variation = 1.0D;
    Municion municion = this.configuracion.municion;
    double staleness_hour = 1.0D;
    double sigma_Vt_prec = 0.5D;
    double sigma_drag_prec = municion.getAjDrag();
    double sigma_theta_prec = municion.getAjElevacion();
    double a_0 = municion.getAjA0();
    double a_1 = municion.getAjA1();
    double sigma_Vt_MPI = municion.getAjVelocidadBoca();
    double sigma_DRAG_MPI = municion.getAjDrag();
    double sigma_LIFT_MPI = 1.0D;
    double sigma_AIM_EL_MPI = municion.getAjElevacion();
    double sigma_AIM_AZ_MPI = 0.5D;
    double sigma_LOC_X_MPI = municion.getDesvUbicacion_m();
    double sigma_LOC_Z_MPI = municion.getDesvAzimut();
    double sigma_CHART_X_MPI = municion.getDesvDistancia();
    double sigma_CHART_Z_MPI = municion.getDesvUbicacion_Az();
    try {
      double Vt = municion.zonaSelec.getVelBoca(this.configuracion.getTempProp(), this.configuracion.getDifPeso());
      double vary_theta = municion.getAjElevacion();
      double theta0 = elevacion;
      double theta1 = theta0;
      double x1 = calculo(Vt, theta1, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      double theta2 = theta0 + vary_theta;
      double x2 = calculo(Vt, theta2, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      dR_dtheta = (x2 - x1) / vary_theta;
      double vary_Vt = municion.getAjVelocidadBoca();
      double Vt01 = Vt;
      x1 = calculo(Vt01, theta1, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      double Vt02 = Vt + vary_Vt;
      x2 = calculo(Vt02, theta1, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      dR_dVt = (x2 - x1) / vary_Vt;
      vary_rho = 1.0D;
      x1 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      vary_rho = 1.1D;
      x2 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      dR_drho = (x2 - x1) / 10.0D;
      vary_temp = 1.0D;
      x1 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      vary_temp = 1.1D;
      x2 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      dR_dtemp = (x2 - x1) / 10.0D;
      double Z_deflection = 0.5D * this.acelDeflexion * Math.pow(getTime(), 2.0D);
      double Drift = Z_deflection * 1018.59D / getX();
      dZ_dDrift = Drift / 100.0D * getX() / 1018.59D;
      dZ_dalpha = getX() / 1018.59D;
      vary_windspeed_x = 1.0D;
      x1 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      vary_windspeed_x = 1.1D;
      x2 = calculo(Vt, theta0, vary_rho, vary_temp, vary_windspeed_x, vary_windspeed_z, Temp_variation, Density_variation, posicion);
      dR_dwind = (x2 - x1) / 5.144D;
      vary_windspeed_x = 0.0D;
      this.sigma_PX_PE = Math.sqrt(Math.pow(dR_dVt * sigma_Vt_prec, 2.0D) + Math.pow(dR_drho * sigma_drag_prec, 2.0D) + Math.pow(dR_dtheta * sigma_theta_prec, 2.0D));
      this.sigma_PZ_PE = a_0 / 1018.59D * a_1 * getX() / (a_1 - elevacion) / 0.6745D;
      this.sigma_X_MPI = Math.sqrt(Math.pow(dR_drho, 2.0D) * (Math.pow(sigma_rho_MPI, 2.0D) + Math.pow(sigma_DRAG_MPI, 2.0D)) + Math.pow(dR_dtemp * sigma_TEMP_MPI, 2.0D) + Math.pow(dR_dwind * sigma_WIND_MPI, 2.0D) + Math.pow(dR_dVt * sigma_Vt_MPI, 2.0D) + Math.pow(dR_dtheta * sigma_AIM_EL_MPI, 2.0D) + Math.pow(sigma_LOC_X_MPI, 2.0D) + Math.pow(sigma_CHART_X_MPI, 2.0D));
      this.sigma_Z_MPI = Math.sqrt(Math.pow(dZ_dwind * sigma_WIND_MPI, 2.0D) + Math.pow(dZ_dDrift * sigma_LIFT_MPI, 2.0D) + Math.pow(dZ_dalpha * sigma_AIM_AZ_MPI, 2.0D) + Math.pow(sigma_LOC_Z_MPI, 2.0D) + Math.pow(sigma_CHART_Z_MPI, 2.0D));
    } catch (Exception e) {
      System.out.println("error en: Trayectoria.calculaError");
    } 
  }
  
  public double calculo(double velocidad, double elevacion, double vary_rho, double vary_temp, double vary_windspeed_x, double vary_windspeed_z, double Temp_variation, double Density_variation, Posicion posicion) {
    double x = 0.0D;
    double z = 0.0D;
    try {
      this.boletin = Boletin.getSingletonInstance();
      Municion municion = this.configuracion.municion;
      double u0 = velocidad;
      double diametro = municion.getDiametro() / 1000.0D;
      double ACCLN_DEFLECTION = municion.getAcel_deflexion();
      double PROJECTILEMASS = municion.getPesoProyectil(this.configuracion.getCuadros());
      Coeficientes coeficientes = new Coeficientes();
      coeficientes = municion.coeficientes;
      double azimutTiro = posicion.getAzimut();
      double orientacionTiro = posicion.getAzimut();
      double theta0 = elevacion / 1000.0D;
      double Vt = velocidad;
      if (Vt == 0.0D)
        Vt = municion.zonaSelec.getVelBocaStd(); 
      double Vx = Vt * Math.cos(theta0);
      double Vy = Vt * Math.sin(theta0);
      double thetat = theta0;
      double V_Z_wind = 0.0D;
      double Z_wind = 0.0D;
      double y = posicion.puntoA.getAltura() + 4.0D;
      ArrayList<Double> r = new ArrayList<>();
      ArrayList<Double> h = new ArrayList<>();
      double vTotal = u0;
      V_Z_wind = 0.0D;
      Z_wind = 0.0D;
      double vY = 0.0D;
      double vX = 0.0D;
      double vZ = 0.0D;
      double angleW = this.boletin.getAzWindGeneric();
      this.angleInProjW0 = (angleW - orientacionTiro) * 9.81747E-4D;
      double speedW = this.boletin.getVelWindGeneric();
      speedW *= 0.514D;
      double cuadrante = elevacion * 9.8E-4D;
      double wx = speedW * Math.cos(this.angleInProjW0);
      double wz = speedW * Math.sin(this.angleInProjW0);
      double wNew = speedW;
      if (u0 == 0.0D)
        u0 = municion.zonaSelec.getVelBocaStd(); 
      double ux0 = u0 * Math.cos(cuadrante);
      double uy0 = u0 * Math.sin(cuadrante);
      vX = ux0 - wx;
      vY = uy0;
      vZ = wz;
      vTotal = u0;
      V_Z_wind = 0.0D;
      Z_wind = 0.0D;
      double ax = 0.0D;
      double ay = 0.0D;
      double az = 0.0D;
      double dt = 0.01D;
      double twist = municion.getTwist();
      double p = 2.0D * this.PI * u0 / twist * 0.155D;
      double az0 = orientacionTiro * 9.8E-4D;
      double lat0 = Math.toRadians(posicion.puntoA.getLatitud());
      double mcb0 = municion.baseBleed.getMcb0();
      double m = municion.isBB() ? (this.projectileMass - mcb0) : this.projectileMass;
      double tb = 0.0D;
      int n = 0;
      h.add(Double.valueOf(y));
      r.add(Double.valueOf(x));
      while (u0 >= 0.0D) {
        n++;
        if (this.boletin.getArea() == 0) {
          double alturaBoletin = y - posicion.puntoA.getAltura();
          if (alturaBoletin < 0.0D)
            alturaBoletin = 0.0D; 
          this.boletin.calculeAccoustic(alturaBoletin);
          this.temp = this.boletin.getTempBoletin();
          this.rho = this.boletin.getRhoBoletin();
          this.pressure = this.boletin.getPressureBoletin() * 100.0D;
        } else {
          this.temp = this.boletin.getTemp(y, 1.0D);
          this.rho = this.boletin.getRho(this.boletin.getPressure(y), this.boletin.getTemp(y, 1.0D), 1.0D);
          this.pressure = this.boletin.getPressure(y) * 100.0D;
        } 
        double Vs = Math.sqrt(this.KAPPA * this.R * this.temp);
        double M = vTotal / Vs;
        double Ixx = municion.coeficientes.getiX0();
        double CM3 = municion.coeficientes.cM3_coeff(M);
        double Cd = coeficientes.Drag_coeff(M);
        double Cd2 = coeficientes.CDa2_coeff(M);
        double Cl = coeficientes.lift_coeff(M);
        double Cl3 = coeficientes.cL3_coeff(M);
        double cma = coeficientes.Cma_coeff(M);
        double Cxbb = coeficientes.base_coeff(M);
        double productoCruzX = vY * az - vZ * ay;
        double productoCruzY = vZ * ax - vX * az;
        double productoCruzZ = vX * ay - vY * ax;
        double anguloReposoX = -8.0D * Ixx * p * productoCruzX / this.rho * this.PI * Math.pow(diametro, 3.0D) * Math.pow(vTotal, 4.0D) * cma;
        double anguloReposoY = -8.0D * Ixx * p * productoCruzY / this.rho * this.PI * Math.pow(diametro, 3.0D) * Math.pow(vTotal, 4.0D) * cma;
        double anguloReposoZ = -8.0D * Ixx * p * productoCruzZ / this.rho * this.PI * Math.pow(diametro, 3.0D) * Math.pow(vTotal, 4.0D) * cma;
        double magnitudAnguloReposo = Math.sqrt(Math.pow(anguloReposoX, 2.0D) + Math.pow(anguloReposoY, 2.0D) + Math.pow(anguloReposoZ, 2.0D));
        double anguloAtaque = Math.asin(magnitudAnguloReposo);
        double vectorAtaqueX = 8.0D * Ixx * p * productoCruzX / this.PI * this.rho * Math.pow(diametro, 3.0D) * (cma + CM3 * Math.pow(anguloAtaque, 2.0D)) * Math.pow(vTotal, 4.0D);
        double vectorAtaqueY = 8.0D * Ixx * p * productoCruzY / this.PI * this.rho * Math.pow(diametro, 3.0D) * (cma + CM3 * Math.pow(anguloAtaque, 2.0D)) * Math.pow(vTotal, 4.0D);
        double vectorAtaqueZ = 8.0D * Ixx * p * productoCruzZ / this.PI * this.rho * Math.pow(diametro, 3.0D) * (cma + CM3 * Math.pow(anguloAtaque, 2.0D)) * Math.pow(vTotal, 4.0D);
        double ajusteCD = municion.zonaSelec.getAjusteCD();
        double ajustei = municion.zonaSelec.getAjusteI(elevacion);
        double fD = -(this.PI * this.rho * ajustei * Math.pow(diametro, 2.0D) / 8.0D) * (Cd + Cd2 * ajusteCD * Math.pow(anguloAtaque, 2.0D)) * vTotal;
        double fDx = fD * vX;
        double fDy = fD * vY;
        double fDz = fD * vZ;
        double ajusteFl = municion.zonaSelec.getAjusteFL(elevacion);
        double fL = this.PI * this.rho * Math.pow(diametro, 2.0D) * ajusteFl / 8.0D * (Cl + Cl3 * Math.pow(anguloAtaque, 2.0D)) * Math.pow(vTotal, 2.0D);
        double fLx = fL * vectorAtaqueX;
        double fLy = fL * vectorAtaqueY;
        double fLz = fL * vectorAtaqueZ;
        double I = 0.0D;
        double angleInProjW0 = 0.0D;
        double CMag = coeficientes.CMag_coeff(M);
        double qM = municion.zonaSelec.getAjusteMag();
        double fM = Math.pow(diametro, 3.0D) * qM * p * this.rho * CMag / 8.0D;
        double fMx = fM * (vectorAtaqueY * vZ - vectorAtaqueZ * vY);
        double fMy = fM * (vectorAtaqueZ * vX - vectorAtaqueX * vZ);
        double fMz = fM * (vectorAtaqueX * vY - vectorAtaqueY * vX);
        double wX = 7.292115E-5D * Math.cos(lat0) * Math.cos(az0);
        double wY = 7.292115E-5D * Math.sin(lat0);
        double wZ = -7.292115E-5D * Math.cos(lat0) * Math.sin(az0);
        double fCx = -2.0D * this.projectileMass * (wY * vZ - wZ * vY);
        double fCy = -2.0D * this.projectileMass * (wZ * vX - wx * vZ);
        double fCz = -2.0D * this.projectileMass * (wZ * vY - wY * vX);
        double mT = this.configuracion.getTempProp();
        double BBfx = 0.0D;
        double BBfy = 0.0D;
        double BBfz = 0.0D;
        double dti = municion.zonaSelec.baseBleed.getTdi(mT);
        double tB = municion.zonaSelec.baseBleed.getTb(mT);
        if (municion.isBB() && n * dt >= dti && n * dt < tB)
          try {
            double mb = this.projectileMass - municion.baseBleed.getmFuell();
            double fiBB = municion.zonaSelec.baseBleed.getFibb(elevacion, mT);
            double kP = municion.zonaSelec.baseBleed.getkP();
            double mcb = this.projectileMass - m;
            double sC = 0.0D;
            sC = municion.baseBleed.sc_coeff(mcb);
            double vC0 = municion.baseBleed.getvC0();
            double betaVc = municion.baseBleed.getBetaVc();
            double fmT = Math.exp(betaVc * (mT - 21.0D));
            double k = municion.baseBleed.getK();
            double nVc = municion.baseBleed.getnVc();
            double gp = k * Math.pow(this.pressure, nVc);
            double vC = vC0 * fmT * gp * kP * 0.85D;
            double propRho = municion.baseBleed.getPropRho();
            double diamBase = municion.baseBleed.getDiamBase();
            double I0 = coeficientes.i0_coeff(M);
            double fi = 0.0D;
            if (m > mb) {
              double derivada_m = -vC * propRho * sC;
              double m1 = derivada_m * dt + m;
              m = m1;
              double derivada_mf = -derivada_m;
              I = 4.0D * derivada_mf / this.PI * Math.pow(diamBase, 2.0D) * this.rho * vTotal;
              fi = I / I0;
            } else {
              fi = 0.0D;
            } 
            if (I > I0)
              fi = 1.0D; 
            double ajusteBB = municion.zonaSelec.baseBleed.getAdjustBB();
            BBfx = ajusteBB * this.PI / 8.0D * this.rho * Math.pow(diametro, 2.0D) * Math.pow(vTotal, 2.0D) * Cxbb * fi * fiBB * (vX * Math.cos(anguloAtaque) / vTotal + vectorAtaqueX);
            BBfy = ajusteBB * this.PI / 8.0D * this.rho * Math.pow(diametro, 2.0D) * Math.pow(vTotal, 2.0D) * Cxbb * fi * fiBB * (vY * Math.cos(anguloAtaque) / vTotal + vectorAtaqueY);
            BBfz = ajusteBB * this.PI / 8.0D * this.rho * Math.pow(diametro, 2.0D) * Math.pow(vTotal, 2.0D) * Cxbb * fi * fiBB * (vZ * Math.cos(anguloAtaque) / vTotal + vectorAtaqueZ);
          } catch (Exception e) {
            System.out.println("Error en configuracion BB");
            e.printStackTrace();
            break;
          }  
        ax = (fDx + fMx + fLx + BBfx + fCx) / m;
        ay = -this.G * (1.0D - 2.0D * x / this.RGROUND) + (fDy + fMy + fLy + BBfy + fCy) / m;
        az = (fDz + fLz + fMz + BBfz + fCz) / m;
        if (Double.isNaN(ay)) {
          System.out.println(" ay es nan");
          System.out.println("error en trayectoria, Error probable");
          break;
        } 
        double vx1 = ax * dt + vX;
        double vy1 = ay * dt + vY;
        double vz1 = az * dt + vZ;
        double x1 = vx1 * dt + x;
        double y1 = vy1 * dt + y;
        double z1 = vz1 * dt + z + V_Z_wind;
        if (angleInProjW0 >= 0.0D && angleInProjW0 <= 180.0D) {
          fLz = fDz;
        } else {
          fDz = -fDz;
        } 
        x = x1;
        y = y1;
        z = z1;
        vX = vx1;
        vY = vy1;
        vZ = vz1;
        vTotal = Math.sqrt(Math.pow(vX, 2.0D) + Math.pow(vY, 2.0D) + Math.pow(vZ, 2.0D));
        double acelP = this.PI * this.rho * Math.pow(diametro, 4.0D) * p * vTotal * coeficientes.cLp_coeff(M) / 8.0D * Ixx;
        p += acelP * dt;
        h.add(Double.valueOf(y));
        r.add(Double.valueOf(x));
        if (((Double)h.get(n - 1)).doubleValue() > ((Double)h.get(n)).doubleValue())
          if (y <= posicion.puntoB.getAltura() + 4.0D)
            break;  
      } 
    } catch (Exception e) {
      System.out.println(" Error de clase trayectoria.calcula distancia: " + e);
      e.printStackTrace();
    } 
    double projectileRange = Math.sqrt(Math.pow(x, 2.0D) + Math.pow(z, 2.0D));
    return projectileRange;
  }
  
  public void clear() {
    this.time = 0.0D;
    this.x = 0.0D;
    this.y = 0.0D;
    this.z = 0.0D;
    this.anguloAtaque = 0.0D;
    this.vTotal = 0.0D;
    this.r.clear();
    this.h.clear();
    this.Z_wind = 0.0D;
    this.Z_wind_array.clear();
    this.Deflection_angle_corr = 0.0D;
    this.Drift_deflection_corr = 0.0D;
    this.TDC = 0.0D;
    this.vX = 0.0D;
    this.vY = 0.0D;
    this.vZ = 0.0D;
    this.n = 0;
    this.V_Z_wind = 0.0D;
    this.temp = 0.0D;
    this.rho = 0.0D;
    this.Vs = 0.0D;
    this.angleInProjW0 = 0.0D;
    this.wx = 0.0D;
    this.wz = 0.0D;
    this.wNew = 0.0D;
  }
  
  public double getTime() {
    return this.time;
  }
  
  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }
  
  public double getAnguloAtaque() {
    return this.anguloAtaque;
  }
  
  public double getvTotal() {
    return this.vTotal;
  }
  
  public double getZ_wind() {
    return this.Z_wind;
  }
  
  public double getDeflection_angle_corr() {
    return this.Deflection_angle_corr;
  }
  
  public double getDrift_deflection_corr() {
    return this.Drift_deflection_corr;
  }
  
  public double getTDC() {
    return this.TDC;
  }
  
  public double getOrdMax() {
    return this.ordMax;
  }
  
  public boolean isPosible() {
    return this.isPosible;
  }
  
  public void setPosible(boolean posible) {
    this.isPosible = posible;
  }
  
  public double getSigma_PX_PE() {
    return this.sigma_PX_PE;
  }
  
  public void setSigma_PX_PE(double sigma_PX_PE) {
    this.sigma_PX_PE = sigma_PX_PE;
  }
  
  public double getSigma_PZ_PE() {
    return this.sigma_PZ_PE;
  }
  
  public void setSigma_PZ_PE(double sigma_PZ_PE) {
    this.sigma_PZ_PE = sigma_PZ_PE;
  }
  
  public double getSigma_X_MPI() {
    return this.sigma_X_MPI;
  }
  
  public void setSigma_X_MPI(double sigma_X_MPI) {
    this.sigma_X_MPI = sigma_X_MPI;
  }
  
  public double getSigma_Z_MPI() {
    return this.sigma_Z_MPI;
  }
  
  public void setSigma_Z_MPI(double sigma_Z_MPI) {
    this.sigma_Z_MPI = sigma_Z_MPI;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\trayectoria\Trayectoria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */