package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class AmbientLight extends Light {
    // --------------- Fields --------------- //
    private double _Ka = 0.1;

    // --------------- Constructors --------------- //
    public AmbientLight() {
        super(new Color(255, 255, 255));
    }

    public AmbientLight(Color _color, double _Ka) {
        super(_color);
        this._Ka = _Ka;
    }

    public AmbientLight(AmbientLight ambientLight) {
        super(ambientLight.getColor());
        this._Ka = ambientLight.getKa();
    }

    // --------------- Getters/Setters --------------- //
    public double getKa() {
        return _Ka;
    }

    public void setKa(double _Ka) {
        this._Ka = _Ka;
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AmbientLight))
            return false;
        AmbientLight other = (AmbientLight) obj;
        return this.getColor().equals(other.getColor()) &&
                this._Ka == other._Ka;
    }

    @Override
    public String toString() {
        return "AmbientLight: _color=" + getColor().toString() + ", _Ka=" + _Ka;
    }

    // --------------- Operations --------------- //
    @Override
    public Color getIntensity(Point3D point) {
        return new Color((int) Math.min(255, getColor().getRed() * _Ka),
                (int) Math.min(255, getColor().getGreen() * _Ka),
                (int) Math.min(255, getColor().getBlue() * _Ka));
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector(point);
    }
}
