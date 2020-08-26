package elements;

import java.awt.Color;

import primitives.*;

public class PointLight extends Light {
    // --------------- Fields --------------- //
    private Point3D _position;
    private double _Kc;
    private double _Kl;
    private double _Kq;

    // --------------- Constructors --------------- //
    public PointLight() {
        super(new Color(255, 255, 255));
        this._position = new Point3D();
        this._Kc = 0;
        this._Kl = 0;
        this._Kq = 0;
    }

    public PointLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq) {
        super(_color);
        this._position = new Point3D(_position);
        this._Kc = _Kc;
        this._Kl = _Kl;
        this._Kq = _Kq;
    }

    public PointLight(PointLight pointLight) {
        super(pointLight.getColor());
        this._position = new Point3D(pointLight._position);
        this._Kc = pointLight._Kc;
        this._Kl = pointLight._Kl;
        this._Kq = pointLight._Kq;
    }

    // --------------- Getters/Setters --------------- //
    public Point3D getPosition() {
        return new Point3D(_position);
    }

    public void setPosition(Point3D _position) {
        this._position = new Point3D(_position);
    }

    public double getKc() {
        return _Kc;
    }

    public void setKc(double _Kc) {
        this._Kc = _Kc;
    }

    public double getKl() {
        return _Kl;
    }

    public void setKl(double _Kl) {
        this._Kl = _Kl;
    }

    public double getKq() {
        return _Kq;
    }

    public void setKq(double _Kq) {
        this._Kq = _Kq;
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PointLight))
            return false;
        PointLight other = (PointLight) obj;
        return this._Kc == other._Kc &&
                this._Kl == other._Kl &&
                this._Kq == other._Kq &&
                this._position.equals(other._position) &&
                this.getColor().equals(other.getColor());
    }

    @Override
    public String toString() {
        return "PointLight [position=" + _position + ", kc=" + _Kc + ", kl=" + _Kl + ", kq=" + _Kq + ", color=" + getColor()
                + "]";
    }

    // --------------- Operations --------------- //
    @Override
    public Color getIntensity(Point3D point) {
        double d = _position.Distance(point);
        float p = (float) (1 / (_Kc + _Kl * d + _Kq * Math.pow(d, 2)));
        if (p > 1)
            p = 1;
        return new Color((int) (getColor().getRed() * p),
                (int) (getColor().getGreen() * p),
                (int) (getColor().getBlue() * p));
    }

    @Override
    public Vector getL(Point3D point) {
        Vector v = new Vector(_position, point);
        return v;
    }
}
