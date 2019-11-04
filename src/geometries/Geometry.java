package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Vector;
import primitives.*;

public abstract class Geometry 
{
	// --------------- Fields --------------- //
	private Color _emmission;
	private Material _material;
	// --------------- Constructors --------------- // 
	public Geometry()
	{
		_emmission= new Color(0,0,0);
		_material=new Material();
	}
	public Geometry(Color _emmission)
	{
		this._emmission=new Color(_emmission.getRGB());
		this._material=new Material();
	}
	public Geometry(Color _emmission, Material _material) 
	{
		this._emmission = new Color(_emmission.getRGB());
		this._material=new Material(_material);
	}
	public Geometry(Geometry geometry) 
	{
		this._emmission = new Color(geometry._emmission.getRGB());
		this._material=new Material(geometry._material);

	}
	// --------------- Getters/Setters --------------- // 
	public Color getEmmission() 
	{
		return new Color(_emmission.getRGB());
	}
	public void setEmmission(Color _emmission) 
	{
		this._emmission = new Color(_emmission.getRGB());
	}
	public Material getMaterial() 
	{
		return new Material(this._material);
	}
	public void setMaterial(Material _material)
	{
		this._material = new Material(_material);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Geometry))
			return false;
		Geometry other = (Geometry) obj;
		return this._emmission.equals(other._emmission) &&
				this._material.equals(other._material);
	}
	@Override
	public String toString() 
	{
		return "Geometry [_emmission=" + _emmission + ", _material=" + _material + "]";
	}
	// --------------- Operations --------------- // 
	public abstract   Vector getNormal (Point3D point);
	public abstract   ArrayList<Point3D> findIntersections (Ray ray) ;
}