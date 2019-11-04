package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
//import primitives.Point2D;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends Geometry
{
	// --------------- Fields --------------- //
	private double _radius;
	private Point3D _center;
	// --------------- Constructors --------------- // 
	public Sphere() 
	{
		super();
		_radius=0;
		_center= new Point3D();
	}
	public Sphere(double _radius, Point3D _center)
	{
		super();
		this._radius = _radius;
		this._center = new Point3D(_center);
	}
	public Sphere(double _radius, Point3D _center,Color _emmission,Material _material)
	{
		super(_emmission,_material);
		this._radius = _radius;
		this._center = new Point3D(_center);
	}
	public Sphere(double _radius, Point3D _center,Color _emmission) 
	{
		super(_emmission);
		this._radius = _radius;
		this._center = new Point3D(_center);
	}
	public Sphere(Sphere sphere) 
	{
		super(sphere.getEmmission());
		this._radius = sphere.getRadius();
		this._center = new Point3D(sphere._center);
	}
	// --------------- Getters/Setters --------------- // 
	public double getRadius()
	{
		return _radius;
	}
	public void setRadius(double _radius)
	{
		this._radius = _radius;
	}
	public Point3D getCenter() 
	{
		return new Point3D(_center);
	}
	public void setCenter(Point3D _center)
	{
		this._center = new Point3D(_center);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Sphere))
			return false;
		Sphere other = (Sphere) obj;
		return this._center.equals(other._center) &&
				this._radius == other._radius;
	}
	@Override
	public String toString() 
	{
		return "Sphere [radiuos=" + _radius + ", _p=" + _center + ", color=" + getEmmission() + ", material=" + getMaterial()
			 + "]";
	}
	// --------------- Operations --------------- // 
	@Override
	public Vector getNormal(Point3D point) 
	{
		Vector v= new Vector(_center,point);
		v.normalize();
		return v;
	}
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) 
	{
		//ArrayList<Point3D> intersectionPoints= new ArrayList<Point3D>(2);
		ArrayList<Point3D> intersectionPoints= new ArrayList<Point3D>();
		Vector L = new Vector(ray.getPOO(), this.getCenter());
		double tm = L.dotProduct(ray.getDirection());
		double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));
		if (d > this.getRadius())
			return intersectionPoints;
		double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));
		double t1 = tm - th;
		double t2 = tm + th;
		if (t1 > 0)
		{
			Vector v = ray.getDirection();
			v.scale(t1);
			Point3D p1 = ray.getPOO();
			p1.add(v.getHead());
			intersectionPoints.add(p1);
		}
		if (t2 > 0)
		{
			Vector v = ray.getDirection();
			v.scale(t2);
			Point3D p2 = ray.getPOO();
			p2.add(v.getHead());
			intersectionPoints.add(p2);
		}
		return intersectionPoints;
	}
}
