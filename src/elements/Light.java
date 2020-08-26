package elements;

import java.awt.Color;

import primitives.*;

public abstract class Light {
    // --------------- Fields --------------- //
    private Color _color;

    // --------------- Constructors --------------- //
    public Light() {
        this._color = new Color(255, 255, 255);
    }

    public Light(Color _color) {
        this._color = _color;
    }

    public Light(Light light) {
        this._color = light._color;
    }

    // --------------- Getters/Setters --------------- //
    public Color getColor() {
        return _color;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }

    // --------------- Administration --------------- //
    public abstract Color getIntensity(Point3D point);

    public abstract Vector getL(Point3D point);
}
