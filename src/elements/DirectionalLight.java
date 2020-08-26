package elements;

import java.awt.Color;

import primitives.*;

public class DirectionalLight extends Light {
    // --------------- Fields --------------- //
    private Vector direction;

    // --------------- Constructors --------------- //
    public DirectionalLight() {
        super(new Color(255, 255, 255));
        this.direction = new Vector();
    }

    public DirectionalLight(Color _color, Vector direction) {
        super(_color);
        this.direction = new Vector(direction);
    }

    public DirectionalLight(DirectionalLight directionalLight) {
        super(directionalLight.getColor());
        this.direction = new Vector(directionalLight.direction);
    }

    // --------------- Getters/Setters --------------- //
    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof DirectionalLight))
            return false;
        DirectionalLight other = (DirectionalLight) obj;
        return this.direction.equals(other.direction) &&
                this.getColor().equals(other.getColor());
    }

    @Override
    public String toString() {
        return "DirectionalLight [direction=" + direction + ", color=" + getColor() + "]";
    }

    // --------------- Operations --------------- //
    @Override
    public Vector getL(Point3D point) {
        return getDirection();
    }

    @Override
    public Color getIntensity(Point3D point) {
        return getColor();
    }
}
