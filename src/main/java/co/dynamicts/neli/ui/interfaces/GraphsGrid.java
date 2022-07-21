package co.dynamicts.neli.ui.interfaces;

import co.dynamicts.Main;
import co.dynamicts.neli.core.Fires.DatosApuntados;
import co.dynamicts.neli.core.Fires.DatosCalculados;
import co.dynamicts.neli.core.ObusHW.Ins;
import co.dynamicts.neli.core.interfaces.Configuracion;
import co.dynamicts.neli.core.interfaces.Configuracion.UnidadCoordenadas;
import co.dynamicts.neli.core.interfaces.Correcciones;
import co.dynamicts.neli.core.interfaces.Principal;
import co.dynamicts.neli.core.utilities.PuntoGeograficas;
import co.dynamicts.neli.core.utilities.PuntoUTM;
import co.dynamicts.neli.ui.utils.AppConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class GraphsGrid extends VBox implements BaseUserInterface, Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Button zoomIn;
    @FXML
    private Button zoomOut;
    private Configuracion configuracion;
    private ArrayList<Punto> puntos = new ArrayList();
    private final double GRAPH_SIZE_WIDTH = 620.0;
    private final double GRAPH_SIZE_HEIGHT = 580.0;
    private final double ICON_SIZE = 30.0;
    private final double LABEL_Y_SIZE_GEO = 40.0;
    private final double LABEL_Y_SIZE_UTM = 25.0;
    private final double LABEL_X_SIZE = 25.0;
    private final double MARGIN = 2.0;
    private final double ZOOM_STEP = 0.2;
    private Principal principal = null;
    private Punto arma = null;
    private Punto blanco = null;
    private Punto blancoDeseado = null;
    private Punto observador = null;
    private static boolean rendering = false;
    private long lastTick = 0L;
    private double zoom = 0.25;
    private double displacementX = 0.0;
    private double displacementY = 0.0;
    DatosApuntados datosApuntados = DatosApuntados.getSingletonInstance();
    DatosCalculados datosCalculados = DatosCalculados.getSingletonInstance();
    Ins ins = Ins.getSingletonInstance();

    public GraphsGrid() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/interfaces/graphs_grid.fxml"), AppConfig.getInstance().getResouce());
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void updateComponents() {
        Main.getAppController().topMenu().updateComponents();
        if (Instant.now().toEpochMilli() - this.lastTick > 250L) {
            if (!rendering) {
                rendering = true;
                if (UnidadCoordenadas.GEOGRAFICAS == this.configuracion.getUnidadCoordenadas()) {
                    this.renderGeo();
                } else {
                    this.renderUTM();
                }

                rendering = false;
            }

            this.lastTick = Instant.now().toEpochMilli();
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        this.configuracion = Configuracion.getSingletonInstance();
        this.updateComponents();
        this.zoomIn.setOnMouseClicked((event) -> {
            if (this.zoom <= 1.8) {
                this.zoom += 0.2;
                this.updateComponents();
            }

        });
        this.zoomOut.setOnMouseClicked((event) -> {
            if (this.zoom >= 0.4) {
                this.zoom -= 0.2;
                this.updateComponents();
            }

        });
    }

    private void renderGeo() {
        this.principal = Principal.getSingletonInstance();
        if (this.arma == null) {
            this.arma = new Punto(this.ins.obus, "/images/graph-cannon.png");
            this.puntos.add(this.arma);
        }

        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0.0, 0.0, 1160.0, 1240.0);
        this.displacementX = this.arma.getPuntoGeograficas().getLongitud();
        this.displacementY = this.arma.getPuntoGeograficas().getLatitud();
        gc.setLineWidth(1.0);
        gc.setStroke(Color.web("#ACACAC"));
        double escala = 100.0;
        double ubicacionX = 290.0;
        double ubicacionY = 277.5;
        double posX;
        if (this.datosCalculados.isBlancoSetting()) {
            posX = this.datosCalculados.posicionDeseadaMetros.getDistancia();
            double azimut = this.datosCalculados.posicionDeseadaMetros.getAzimut();
            escala = 3240000.0 / posX;
            if ((!(azimut >= 6000.0) || !(azimut <= 6400.0)) && (!(azimut >= 0.0) || !(azimut <= 400.0))) {
                if (azimut > 400.0 && azimut < 1200.0) {
                    ubicacionY = 550.0;
                    ubicacionX = 30.0;
                } else if (azimut >= 1200.0 && azimut <= 2000.0) {
                    ubicacionY = 290.0;
                    ubicacionX = 30.0;
                } else if (azimut > 2000.0 && azimut < 2800.0) {
                    ubicacionY = 30.0;
                    ubicacionX = 30.0;
                } else if (azimut >= 2800.0 && azimut <= 3600.0) {
                    ubicacionY = 30.0;
                    ubicacionX = 310.0;
                } else if (azimut > 3600.0 && azimut < 4400.0) {
                    ubicacionY = 30.0;
                    ubicacionX = 590.0;
                } else if (azimut >= 4400.0 && azimut <= 5200.0) {
                    ubicacionY = 290.0;
                    ubicacionX = 590.0;
                } else if (azimut > 5200.0 && azimut < 6000.0) {
                    ubicacionY = 550.0;
                    ubicacionX = 590.0;
                }
            } else {
                ubicacionY = 550.0;
                ubicacionX = 310.0;
            }
        } else {
            escala = 100.0;
        }

        posX = 0.0;
        int labX = 0;

        double posY;
        for(posY = -(180.0 + this.displacementX); posY <= 180.0 - this.displacementX; posY += 0.016666666666666666) {
            posX = -posY * 60.0 * escala * this.zoom + ubicacionX;
            if (posX >= 0.0 && posX <= 578.0) {
                gc.strokeLine(posX + 0.5, 0.0, posX + 0.5, this.canvas.getHeight() - 27.0);
                if (this.zoom <= 0.5) {
                    if (this.zoom <= 0.3) {
                        if (labX % 3 == 0) {
                            gc.strokeText(this.getGeoLongitude(this.displacementX - posY), posX - 20.0, this.canvas.getHeight() - 12.5, 40.0);
                        }
                    } else if (labX % 2 == 0) {
                        gc.strokeText(this.getGeoLongitude(this.displacementX - posY), posX - 20.0, this.canvas.getHeight() - 12.5, 40.0);
                    }
                } else {
                    gc.strokeText(this.getGeoLongitude(this.displacementX - posY), posX - 20.0, this.canvas.getHeight() - 12.5, 40.0);
                }
            }

            ++labX;
        }

        posY = 0.0;

        for(double y = -(90.0 + this.displacementY); y <= 90.0 - this.displacementY; y += 0.016666666666666666) {
            posY = y * 60.0 * escala * this.zoom + ubicacionY;
            if (posY >= 0.0 && posY <= 553.0) {
                gc.strokeLine(0.0, posY + 0.5, this.canvas.getWidth() - 42.0, posY + 0.5);
                if (this.zoom <= 0.25) {
                    gc.strokeText(this.getGeoLatitude(this.displacementY - y), this.canvas.getWidth() - 40.0, posY + 5.0, 40.0);
                } else {
                    gc.strokeText(this.getGeoLatitude(this.displacementY - y), this.canvas.getWidth() - 40.0, posY + 5.0, 40.0);
                }
            }
        }

        if (this.datosApuntados.blancoApuntado.getLatitud() != 0.0 && this.datosApuntados.blancoApuntado.getLongitud() != 0.0 && this.blanco == null) {
            this.blanco = new Punto(this.datosApuntados.blancoApuntado, "/images/graph-target.png");
            this.puntos.add(this.blanco);
        }

        if (this.datosCalculados.blancoDeseadoGeo.getLatitud() != 0.0 && this.datosCalculados.blancoDeseadoGeo.getLongitud() != 0.0 && this.blancoDeseado == null) {
            this.blancoDeseado = new Punto(this.datosCalculados.blancoDeseadoGeo, "/images/graph-aimed.png");
            this.puntos.add(this.blancoDeseado);
        }

        Correcciones correcciones = null;

        try {
            correcciones = Correcciones.getSingletonInstance();
            if (correcciones.observador.getLatitud() != 0.0 && correcciones.observador.getLongitud() != 0.0 && this.observador == null) {
                this.observador = new Punto(correcciones.observador, "/images/graph-observer.png");
                this.puntos.add(this.observador);
            }
        } catch (IOException var16) {
            return;
        }

        Iterator var14 = this.puntos.iterator();

        while(var14.hasNext()) {
            Punto punto = (Punto)var14.next();
            posX = -(this.displacementX - punto.puntoGeograficas.getLongitud()) * 60.0 * escala * this.zoom + ubicacionX + 30.0;
            posY = (this.displacementY - punto.puntoGeograficas.getLatitud()) * 60.0 * escala * this.zoom + ubicacionY + 15.0;
            if (posX >= 0.0 && posX <= 620.0 && posY >= 0.0 && posY <= 580.0) {
                gc.drawImage(punto.getImage(), posX - 15.0, posY - 15.0, 30.0, 30.0);
            }
        }

    }

    private void renderUTM() {
        this.principal = Principal.getSingletonInstance();
        double escala = 1000.0;
        if (this.arma == null && this.ins.obusUTM.getBanda() != null) {
            this.arma = new Punto(this.ins.obusUTM, "/images/graph-cannon.png");
            this.puntos.add(this.arma);
        } else {
            this.arma.setPuntoUTM(this.ins.obusUTM);
        }

        double ubicacionX = 290.0;
        double ubicacionY = 277.5;
        if (this.datosCalculados.isBlancoSetting()) {
            double alcance = this.datosCalculados.posicionDeseadaMetros.getDistancia();
            double azimut = this.datosCalculados.posicionDeseadaMetros.getAzimut();
            escala = (alcance - 10000.0) * -75.0 / 20000.0 + 115.0;
            if (azimut >= 6000.0 && azimut <= 6400.0 || azimut >= 0.0 && azimut <= 400.0) {
                ubicacionY = 550.0;
                ubicacionX = 310.0;
            } else if (azimut > 400.0 && azimut < 1200.0) {
                ubicacionY = 550.0;
                ubicacionX = 30.0;
            } else if (azimut >= 1200.0 && azimut <= 2000.0) {
                ubicacionY = 290.0;
                ubicacionX = 30.0;
            } else if (azimut > 2000.0 && azimut < 2800.0) {
                ubicacionY = 30.0;
                ubicacionX = 30.0;
            } else if (azimut >= 2800.0 && azimut <= 3600.0) {
                ubicacionY = 30.0;
                ubicacionX = 310.0;
            } else if (azimut > 3600.0 && azimut < 4400.0) {
                ubicacionY = 30.0;
                ubicacionX = 590.0;
            } else if (azimut >= 4400.0 && azimut <= 5200.0) {
                ubicacionY = 290.0;
                ubicacionX = 590.0;
            } else if (azimut > 5200.0 && azimut < 6000.0) {
                ubicacionY = 550.0;
                ubicacionX = 590.0;
            }
        } else {
            escala = 100.0;
        }

        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0.0, 0.0, 1160.0, 1240.0);
        double deltaKmX = this.arma.getPuntoUTM().getDeltaEste() / 1000.0;
        double deltaKmY = this.arma.getPuntoUTM().getDeltaNorte() / 1000.0;
        gc.setLineWidth(1.0);
        gc.setStroke(Color.web("#ACACAC"));
        double posX = 0.0;
        int labX = 0;

        double posY;
        for(posY = 0.0; posY <= 700.0; ++posY) {
            posX = (posY - deltaKmX) * escala * this.zoom + ubicacionX;
            if (posX >= 0.0 && posX <= 593.0) {
                gc.strokeLine(posX + 0.5, 0.0, posX + 0.5, this.canvas.getHeight() - 27.0);
                if (this.zoom <= 0.5) {
                    if (this.zoom <= 0.3) {
                        if (labX % 3 == 0) {
                            gc.strokeText(this.getUTMeast(posY), posX - 13.0, this.canvas.getHeight() - 12.5, 40.0);
                        }
                    } else if (labX % 2 == 0) {
                        gc.strokeText(this.getUTMeast(posY), posX - 13.0, this.canvas.getHeight() - 12.5, 40.0);
                    }
                } else {
                    gc.strokeText(this.getUTMeast(posY), posX - 13.0, this.canvas.getHeight() - 12.5, 40.0);
                }

                ++labX;
            }
        }

        posY = 0.0;

        for(double y = 0.0; y <= 1000.0; ++y) {
            posY = (y - deltaKmY) * escala * this.zoom + 580.0 - ubicacionY;
            if (posY >= 27.0 && posY <= 580.0) {
                gc.strokeLine(0.0, 580.0 - posY + 0.5, this.canvas.getWidth() - 27.0, 580.0 - posY + 0.5);
                if (this.zoom <= 0.25) {
                    gc.strokeText(this.getUTMeast(y), this.canvas.getWidth() - 25.0, 580.0 - posY + 5.0, 40.0);
                } else {
                    gc.strokeText(this.getUTMeast(y), this.canvas.getWidth() - 25.0, 580.0 - posY + 5.0, 40.0);
                }
            }
        }

        if (this.datosApuntados.blancoApuntadoUTM.getDeltaEste() != 0.0 && this.datosApuntados.blancoApuntadoUTM.getDeltaNorte() != 0.0) {
            if (this.blanco == null) {
                this.blanco = new Punto(this.datosApuntados.blancoApuntadoUTM, "/images/graph-target.png");
                this.puntos.add(this.blanco);
            } else {
                this.blanco.setPuntoUTM(this.datosApuntados.blancoApuntadoUTM);
            }
        }

        if (this.datosCalculados.blancoDeseadoUTM.getDeltaEste() != 0.0 && this.datosCalculados.blancoDeseadoUTM.getDeltaNorte() != 0.0) {
            if (this.blancoDeseado == null) {
                this.blancoDeseado = new Punto(this.datosCalculados.blancoDeseadoUTM, "/images/graph-aimed.png");
                this.puntos.add(this.blancoDeseado);
            } else {
                this.blancoDeseado.setPuntoUTM(this.datosCalculados.blancoDeseadoUTM);
            }
        }

        Correcciones correcciones = null;

        try {
            correcciones = Correcciones.getSingletonInstance();
            if (correcciones.observadorUTM.getDeltaEste() != 0.0 && correcciones.observadorUTM.getDeltaNorte() != 0.0) {
                if (this.observador == null) {
                    this.observador = new Punto(correcciones.observadorUTM, "/images/graph-observer.png");
                    this.puntos.add(this.observador);
                } else {
                    this.observador.setPuntoUTM(correcciones.observadorUTM);
                }
            }
        } catch (IOException var20) {
            return;
        }

        Iterator var18 = this.puntos.iterator();

        while(var18.hasNext()) {
            Punto punto = (Punto)var18.next();
            posX = -(deltaKmX - punto.getPuntoUTM().getDeltaEste() / 1000.0) * escala * this.zoom + ubicacionX;
            posY = (deltaKmY - punto.getPuntoUTM().getDeltaNorte() / 1000.0) * escala * this.zoom + ubicacionY;
            if (posX >= 0.0 && posX <= 620.0 && posY >= 0.0 && posY <= 580.0) {
                gc.drawImage(punto.getImage(), posX - 15.0, posY - 15.0, 30.0, 30.0);
            }
        }

    }

    private double getZoneDisplacement(String band, int zone) {
        double bandDisplacement = this.getBandDisplacement(band);
        if (bandDisplacement == 0.0) {
            return 0.0;
        } else {
            bandDisplacement /= 1000000.0;
            return 0.0;
        }
    }

    private double getBandDisplacement(String band) {
        if ((double)band.length() != 0.0) {
            return 0.0;
        } else {
            String bandString = "CDEFGHJKLMNPQRSTUVWX";
            return (double)bandString.indexOf(band) * 1000000.0;
        }
    }

    private PuntoGeograficas mirrorGeoPoint(PuntoGeograficas arma, PuntoGeograficas other) {
        PuntoGeograficas mirror = new PuntoGeograficas();
        mirror.setLatitud(2.0 * arma.getLatitud() - other.getLatitud(), false);
        mirror.setLongitud(2.0 * arma.getLongitud() - other.getLongitud(), false);
        return mirror;
    }

    private PuntoUTM mirrorUTMPoint(PuntoUTM arma, PuntoUTM other) {
        PuntoUTM mirror = new PuntoUTM();
        mirror.setDeltaNorte(2.0 * arma.getDeltaNorte() - other.getDeltaNorte());
        mirror.setDeltaEste(2.0 * arma.getDeltaEste() - other.getDeltaEste());
        return mirror;
    }

    private String getGeoLatitude(double latitude) {
        double degrees = 0.0;
        double minutes = 0.0;
        String symbol = " ";
        String str = "%d° %d\" %s";
        if ((int)(latitude * 60000.0) == 0) {
            return String.format(str, Math.abs((int)degrees), Math.abs((int)minutes), symbol);
        } else {
            if (latitude > 0.0) {
                symbol = "N";
            } else {
                symbol = "S";
            }

            latitude = Math.abs(latitude);
            degrees = Math.floor(latitude);
            minutes = (double)Math.round((latitude - degrees) * 60.0);
            if (minutes == 60.0) {
                ++degrees;
                minutes = 0.0;
            }

            return String.format(str, Math.abs((int)degrees), Math.abs((int)minutes), symbol);
        }
    }

    private String getGeoLongitude(double longitude) {
        double degrees = 0.0;
        double minutes = 0.0;
        String symbol = " ";
        String str = "%d° %d\" %s";
        if ((int)(longitude * 60000.0) == 0) {
            return String.format(str, Math.abs((int)degrees), Math.abs((int)minutes), symbol);
        } else {
            if (longitude > 0.0) {
                symbol = "E";
            } else {
                symbol = "W";
            }

            longitude = Math.abs(longitude);
            degrees = Math.floor(longitude);
            minutes = (double)Math.round((longitude - degrees) * 60.0);
            if (minutes == 60.0) {
                ++degrees;
                minutes = 0.0;
            }

            return String.format(str, Math.abs((int)degrees), Math.abs((int)minutes), symbol);
        }
    }

    private String getUTMeast(double deltaEast) {
        deltaEast = Math.ceil(Math.ceil(deltaEast));
        String str = "%d";
        return String.format(str, (int)deltaEast);
    }

    private String getUTMnorth(double deltaNorth) {
        deltaNorth = Math.ceil(Math.ceil(deltaNorth) / 1000.0);
        String str = "%d";
        return String.format(str, (int)deltaNorth);
    }

    class Punto {
        private PuntoGeograficas puntoGeograficas;
        private PuntoUTM puntoUTM;
        private Image image;
        private boolean drawable = true;

        public Punto(PuntoGeograficas puntoGeograficas, String resource) {
            this.puntoGeograficas = puntoGeograficas;
            this.image = new Image(this.getClass().getResourceAsStream(resource));
        }

        public Punto(PuntoUTM puntoUTM, String resource) {
            this.puntoUTM = puntoUTM;
            this.image = new Image(this.getClass().getResourceAsStream(resource));
        }

        public PuntoGeograficas getPuntoGeograficas() {
            return this.puntoGeograficas;
        }

        public void setPuntoGeograficas(PuntoGeograficas puntoGeograficas) {
            this.puntoGeograficas = puntoGeograficas;
        }

        public PuntoUTM getPuntoUTM() {
            return this.puntoUTM;
        }

        public void setPuntoUTM(PuntoUTM puntoUTM) {
            this.puntoUTM = puntoUTM;
        }

        public Image getImage() {
            return this.image;
        }

        public void setImage(Image image) {
            this.image = image;
        }
    }
}