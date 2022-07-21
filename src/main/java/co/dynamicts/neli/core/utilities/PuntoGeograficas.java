package co.dynamicts.neli.core.utilities;

public class PuntoGeograficas {
  double declinacion;
  
  double altura;
  
  double latitud;
  
  double longitud;
  
  double latGrados;
  
  double latMinutos;
  
  double latSegundos;
  
  double lonGrados;
  
  double lonMinutos;
  
  double lonSegundos;
  
  String signoLongitud;
  
  String signoLatitud;
  
  public double declinacionMagnetica;
  
  public PuntoGeograficas() {
    this.altura = 0.0D;
    this.signoLongitud = "W";
    this.signoLatitud = "N";
    setAltura(0.0D);
    setLongitud(0.0D, true);
    setLonGrados(0.0D);
    setLonMinutos(0.0D);
    setLonSegundos(0.0D);
    setLatitud(0.0D, true);
    setLatGrados(0.0D);
    setLatMinutos(0.0D);
    setLatSegundos(0.0D);
  }
  
  public PuntoGeograficas(double altura, double latitud, double longitud) {
    this.altura = 0.0D;
    this.signoLongitud = "W";
    this.signoLatitud = "N";
    setAltura(altura);
    setLatitud(latitud, true);
    setLongitud(longitud, true);
  }
  
  public double getDeclinacion() {
    return this.declinacion;
  }
  
  public void setDeclinacion(double declinacion) {
    this.declinacion = declinacion;
  }
  
  public double getAltura() {
    return this.altura;
  }
  
  public void setAltura(double altura) {
    this.altura = altura;
  }
  
  public double getLatitud() {
    return this.latitud;
  }
  
  public void setLatitud(double latitud, boolean descomponer) {
    if (descomponer == true) {
      if (latitud >= 0.0D) {
        setLatGrados(Math.floor(latitud));
        setLatMinutos(Math.floor((latitud - getLatGrados()) * 60.0D));
        setLatSegundos(((latitud - getLatGrados()) * 60.0D - getLatMinutos()) * 60.0D);
        if (getLatSegundos() > 60.0D) {
          setLatSegundos(0.0D);
          setLatMinutos(getLatMinutos() + 1.0D);
        } else if (getLatMinutos() > 60.0D) {
          setLatMinutos(0.0D);
          setLatGrados(getLatGrados() + 1.0D);
        } 
        setSignoLatitud("N");
      } else if (latitud < 0.0D) {
        setLatGrados(Math.ceil(latitud));
        setLatMinutos(Math.ceil((latitud - getLatGrados()) * 60.0D));
        setLatSegundos(((latitud - getLatGrados()) * 60.0D - getLatMinutos()) * 60.0D);
        if (getLatSegundos() > 60.0D) {
          setLatSegundos(0.0D);
          setLatMinutos(getLatMinutos() + 1.0D);
        } else if (getLatMinutos() > 60.0D) {
          setLatMinutos(0.0D);
          setLatGrados(getLatGrados() + 1.0D);
        } 
        setSignoLatitud("S");
      } 
    } else if (!descomponer) {
      this.latitud = latitud;
    } 
  }
  
  public void setLatitud(double grados, double minutos, double segundos) {
    double gradosCentecimales = 0.0D;
    gradosCentecimales = grados + minutos / 60.0D + segundos / 3600.0D;
    setLatitud(gradosCentecimales, false);
  }
  
  public double getLongitud() {
    return this.longitud;
  }
  
  public void setLongitud(double longitud, boolean descomponer) {
    if (descomponer == true) {
      if (longitud >= 0.0D) {
        setSignoLongitud("E");
        setLonGrados(Math.floor(longitud));
        setLonMinutos(Math.floor((longitud - getLonGrados()) * 60.0D));
        setLonSegundos(((longitud - getLonGrados()) * 60.0D - getLonMinutos()) * 60.0D);
        if (getLonSegundos() > 60.0D) {
          setLonMinutos(getLonMinutos() + Math.floor(getLonSegundos() / 60.0D));
          setLonSegundos(getLonSegundos() - 60.0D);
        } 
        if (getLonMinutos() > 60.0D) {
          setLonGrados(getLonGrados() + Math.floor(getLonMinutos() / 60.0D));
          setLonMinutos(getLonMinutos() - 60.0D);
        } 
      } else if (longitud < 0.0D) {
        setSignoLongitud("W");
        setLonGrados(Math.ceil(longitud));
        setLonMinutos(Math.ceil((longitud - getLonGrados()) * 60.0D));
        setLonSegundos(((longitud - getLonGrados()) * 60.0D - getLonMinutos()) * 60.0D);
        if (getLonMinutos() < -60.0D) {
          setLonGrados(getLonGrados() + Math.ceil(getLonMinutos() / 60.0D));
          setLonMinutos(getLonMinutos() - 60.0D);
        } 
        if (getLonSegundos() < -60.0D) {
          setLonMinutos(getLonMinutos() + Math.ceil(getLonSegundos() / 60.0D));
          setLonSegundos(getLonSegundos() - 60.0D);
        } 
      } 
    } else if (!descomponer) {
      this.longitud = longitud;
    } 
  }
  
  public void setLongitud(double grados, double minutos, double segundos) {
    double gradosCentecimales = 0.0D;
    gradosCentecimales = grados + minutos / 60.0D + segundos / 3600.0D;
    setLongitud(gradosCentecimales, false);
  }
  
  public double getLatGrados() {
    return this.latGrados;
  }
  
  public void setLatGrados(double latGrados) {
    this.latGrados = latGrados;
    setLatitud(latGrados, this.latMinutos, this.latSegundos);
  }
  
  public double getLatMinutos() {
    return this.latMinutos;
  }
  
  public void setLatMinutos(double latMinutos) {
    this.latMinutos = latMinutos;
    setLatitud(this.latGrados, latMinutos, this.latSegundos);
  }
  
  public double getLatSegundos() {
    return this.latSegundos;
  }
  
  public void setLatSegundos(double latSegundos) {
    this.latSegundos = latSegundos;
    setLatitud(this.latGrados, this.latMinutos, latSegundos);
  }
  
  public double getLonGrados() {
    return this.lonGrados;
  }
  
  public void setLonGrados(double lonGrados) {
    this.lonGrados = lonGrados;
    setLongitud(lonGrados, this.lonMinutos, this.lonSegundos);
  }
  
  public double getLonMinutos() {
    return this.lonMinutos;
  }
  
  public void setLonMinutos(double lonMinutos) {
    this.lonMinutos = lonMinutos;
    setLongitud(this.lonGrados, lonMinutos, this.lonSegundos);
  }
  
  public double getLonSegundos() {
    return this.lonSegundos;
  }
  
  public void setLonSegundos(double lonSegundos) {
    this.lonSegundos = lonSegundos;
    setLongitud(this.lonGrados, this.lonMinutos, lonSegundos);
  }
  
  public String getSignoLongitud() {
    return this.signoLongitud;
  }
  
  public void setSignoLongitud(String signoLongitud) {
    this.signoLongitud = signoLongitud;
    if (signoLongitud == "E") {
      if (getLongitud() < 0.0D)
        setLongitud(-getLongitud(), false); 
    } else if (signoLongitud == "W" && getLongitud() >= 0.0D) {
      setLongitud(-getLongitud(), false);
    } 
  }
  
  public String getSignoLatitud() {
    return this.signoLatitud;
  }
  
  public void setSignoLatitud(String signoLatitud) {
    if (signoLatitud == "N") {
      if (getLatitud() < 0.0D)
        setLatitud(-getLatitud(), true); 
    } else if (signoLatitud == "S" && 
      getLatitud() >= 0.0D) {
      setLatitud(-getLatitud(), true);
    } 
    this.signoLatitud = signoLatitud;
  }
  
  public void punto(PuntoGeograficas punto) {
    setLatitud(punto.getLatitud(), true);
    setLongitud(punto.getLongitud(), true);
    setAltura(punto.getAltura());
  }
  
  public double getDeclinacionMagnetica() {
    return this.declinacionMagnetica;
  }
  
  public void setDeclinacionMagnetica(double declinacionMagnetica) {
    this.declinacionMagnetica = declinacionMagnetica;
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\cor\\utilities\PuntoGeograficas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */