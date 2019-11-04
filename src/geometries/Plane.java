package geometries;

import java.awt.Color;
import java.util.ArrayList;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{
	// --------------- Fields --------------- //
	private Point3D _Q;
	private Vector _N;
	// --------------- Constructors --------------- // 
	public Plane() 
	{
		super();
		this._Q = new Point3D();
		this._N=new Vector();
	}
	public Plane(Point3D _Q, Vector _N) 
	{
		super();
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
	}
	public Plane(Point3D _Q, Vector _N,Color _emmission)
	{
		super(_emmission);
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
		this._N.normalize();
	}
	public Plane(Plane plane) 
	{
		super(plane.getEmmission(),plane.getMaterial());
		this._Q = new Point3D(plane._Q);
		this._N = plane.getNormal(null);
	}
	// --------------- Getters/Setters --------------- // 
	public Point3D getQ() 
	{
		return new Point3D(_Q);
	}
	public void setQ(Point3D _Q)
	{
		this._Q = new Point3D(_Q);
	}
	public Vector getN() 
	{
		return new Vector(_N);
	}
	public void setN(Vector _N)
	{
		this._N = new Vector(_N);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		Plane other = (Plane) obj;
		return this._N.equals(other._N) &&
				this._Q.equals(other._Q);
	}
	@Override
	public String toString() 
	{
		return "Plane [_p1=" + _Q + ", plumb=" + _N + ", color=" + getEmmission() + ", material=" + getMaterial()+"]";
	}
	// --------------- Operations --------------- // 
	@Override
	public Vector getNormal(Point3D point) 
	{
		Vector v=this.getN();	
		return v;
	}
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray)
	{	
		//ArrayList<Point3D> intersectionPoint = new ArrayList<Point3D>(1);	
		ArrayList<Point3D> intersectionPoint = new ArrayList<Point3D>();	
		Point3D P0 = ray.getPOO();
		Point3D Q0 = this.getQ();
		Vector N = this.getNormal(null);
		Vector V = ray.getDirection();
		Vector v = new Vector (Q0, P0);
		double t = (N.dotProduct(v) * -1) / N.dotProduct(V);
		if (t > 0){
			V.scale(t);
			P0.add(V.getHead());
			intersectionPoint.add(P0);
		}
		return intersectionPoint;
	}
}
