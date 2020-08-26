package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Triangle extends Geometry implements FlatGeometry {
    // --------------- Fields --------------- //
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    // --------------- Constructors --------------- //
    public Triangle() {
        super();
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        super();
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Color _emmission, Material _material) {
        super(_emmission, _material);
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Color _emmission) {
        super(_emmission);
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
    }

    public Triangle(Triangle triangle) {
        super(triangle.getEmmission(), triangle.getMaterial());
        this._p1 = new Point3D(triangle._p1);
        this._p2 = new Point3D(triangle._p2);
        this._p3 = new Point3D(triangle._p3);
    }

    // --------------- Getters/Setters --------------- //
    public Point3D getP1() {
        return new Point3D(_p1);
    }

    public void setP1(Point3D _p1) {
        this._p1 = new Point3D(_p1);
    }

    public Point3D getP2() {
        return new Point3D(_p2);
    }

    public void setP2(Point3D _p2) {
        this._p2 = new Point3D(_p2);
    }

    public Point3D getP3() {
        return new Point3D(_p3);
    }

    public void setP3(Point3D _p3) {
        this._p3 = new Point3D(_p3);
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Triangle))
            return false;
        Triangle other = (Triangle) obj;
        return this._p1.equals(other._p1) &&
                this._p2.equals(other._p2) &&
                this._p3.equals(other._p3);
    }

    @Override
    public String toString() {
        return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + ", color=" + getEmmission() + ", material=" + getMaterial()
                + "]";
    }

    // --------------- Operations --------------- //
    @Override
    public Vector getNormal(Point3D point) {
        Vector v1 = new Vector(_p1, _p2);
        Vector v2 = new Vector(_p1, _p3);
        Vector vec = new Vector(v1.crossProduct(v2));
        vec.normalize();
        vec.scale(-1);
        return vec;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>(); //1
        Point3D P0 = ray.getPOO();
        Vector N = getNormal(null);
        Plane plane = new Plane(_p3, N, new Color(0, 0, 0));
        if (plane.findIntersections(ray).isEmpty())
            return intersectionPoints;
        Point3D intersectionPlane = plane.findIntersections(ray).get(0);
        Vector P_P0 = new Vector(P0, intersectionPlane);
        Vector V1_1 = new Vector(P0, this._p1);
        Vector V2_1 = new Vector(P0, this._p2);
        Vector N1 = V1_1.crossProduct(V2_1);
        N1.normalize();
        double S1 = -P_P0.dotProduct(N1);
        Vector V1_2 = new Vector(P0, this._p2);
        Vector V2_2 = new Vector(P0, this._p3);
        Vector N2 = V1_2.crossProduct(V2_2);
        N2.normalize();
        double S2 = -P_P0.dotProduct(N2);
        Vector V1_3 = new Vector(P0, this._p3);
        Vector V2_3 = new Vector(P0, this._p1);
        Vector N3 = V1_3.crossProduct(V2_3);
        N3.normalize();
        double S3 = -P_P0.dotProduct(N3);
        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))) {
            intersectionPoints.add(intersectionPlane);
        }
        return intersectionPoints;
    }
}
