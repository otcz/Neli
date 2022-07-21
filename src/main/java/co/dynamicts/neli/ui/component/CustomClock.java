package co.dynamicts.neli.ui.component;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.beans.NamedArg;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.util.Duration;

public class CustomClock extends SubScene {
  private PerspectiveCamera camera;

  private Group root;

  private Cylinder cylinder;

  private PhongMaterial material;

  private double minValue = 0.0D;

  private double maxValue = 1.0D;

  private double correctionAngle = 0.0D;

  private double emptyAngle = 0.0D;

  private RotateTransition rotateTransition;

  public CustomClock(@NamedArg("width") double width, @NamedArg("height") double height, @NamedArg("radius") double radius, @NamedArg("thickness") double thickness, @NamedArg("zoom") double zoom) {
    super((Parent)new Group(new Node[] { (Node)new Group() }), width, height, false, SceneAntialiasing.BALANCED);
    this.root = new Group();
    setRoot((Parent)this.root);
    this.camera = new PerspectiveCamera();
    this.camera.setTranslateX(-width / 2.0D);
    this.camera.setTranslateY(-(height / 2.0D));
    this.camera.setTranslateZ(-(radius / zoom));
    setCamera((Camera)this.camera);
    this.material = new PhongMaterial();
    this.material.setDiffuseColor(new Color(1.0D, 1.0D, 1.0D, 1.0D));
    PointLight light = new PointLight();
    light.setColor(Color.WHITE);
    light.setTranslateX(0.0D);
    light.setTranslateY(0.0D);
    light.setTranslateZ(this.camera.getTranslateZ() - 200.0D);
    this.cylinder = new Cylinder(0.0D, thickness);
    this.root.getChildren().addAll(new Node[] { (Node)this.cylinder, (Node)light });
  }

  public void rotate(@NamedArg("angle") double angle) {
    this.root.setRotationAxis(new Point3D(0.0D, 0.0D, 1.0D));
    this.root.setRotate(angle);
  }

  public void setDiffuseMap(@NamedArg("diffuseMap") Image diffuseMap) {
    this.material.setDiffuseMap(diffuseMap);
    this.cylinder.setMaterial((Material)this.material);
  }

  public void enableDebug(@NamedArg("debug") boolean debug) {
    if (debug) {
      this.cylinder.setDrawMode(DrawMode.LINE);
    } else {
      this.cylinder.setDrawMode(DrawMode.FILL);
    }
  }

  public void clockRotate(double newValue) {
    if (newValue < this.minValue || newValue > this.maxValue)
      return;
    if (this.rotateTransition == null) {
      this.rotateTransition = new RotateTransition(Duration.millis(100.0D), (Node)this.cylinder);
      this.cylinder.setRotationAxis(new Point3D(0.0D, 1.0D, 0.0D));
    }
    if (this.rotateTransition.getStatus() == Animation.Status.RUNNING)
      this.rotateTransition.stop();
    this.rotateTransition.setFromAngle(this.cylinder.getRotate());
    this.rotateTransition.setToAngle(this.correctionAngle + (newValue - this.minValue) / (this.maxValue - this.minValue) * (1.0D - this.emptyAngle) * 360.0D);
    this.rotateTransition.play();
  }

  public double getMinValue() {
    return this.minValue;
  }

  public void setMinValue(double minValue) {
    this.minValue = minValue;
  }

  public double getMaxValue() {
    return this.maxValue;
  }

  public void setMaxValue(double maxValue) {
    this.maxValue = maxValue;
  }

  public double getCorrectionAngle() {
    return this.correctionAngle;
  }

  public void setCorrectionAngle(double correctionAngle) {
    this.correctionAngle = correctionAngle;
  }

  public double getEmptyAngle() {
    return this.emptyAngle;
  }

  public void setEmptyAngle(double emptyAngle) {
    if (emptyAngle >= 0.0D && emptyAngle < 1.0D)
      this.emptyAngle = emptyAngle;
  }
}
