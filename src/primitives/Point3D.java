package primitives;

public class Point3D extends Point2D 
{
	// --------------- Fields --------------- //
	private Coordinate _z;
	// --------------- Constructors --------------- // 
	public Point3D() 
	{
		super();
		this._z = new Coordinate();
	}
	public Point3D(double _x, double _y,double _z)
	{
		super(_x,_y);
		this._z = new Coordinate(_z);
	}
	public Point3D(Coordinate _x, Coordinate _y,Coordinate _z)
	{
		super(_x,_y);
		this._z = new Coordinate(_z);
	}
	public Point3D(Point3D point3D) 
	{
		super(point3D);
		this._z =new Coordinate(point3D._z);
	}
	// --------------- Getters/Setters --------------- // 	
	public Coordinate getZ() 
	{
		return this._z;
	}
	public void setZ(Coordinate _z)
	{
		this._z = new Coordinate(_z);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point3D))
			return false;
		Point3D other = (Point3D) obj;
		return super.equals(other) &&
				this._z.equals(other._z);
	}
	@Override
	public String toString() 
	{
		return "Point3D: _x="+this.getX()+", _y="+ this.getY()+", _z="+this._z+".";
	}
	// --------------- Operations --------------- // 
	public double Distance(Point3D point)
	{
		double dis= Math.sqrt(Math.pow((this.getX().getCoordinate()-point.getX().getCoordinate()),2)+Math.pow((this.getY().getCoordinate()-point.getY().getCoordinate()),2)+Math.pow((this.getZ().getCoordinate()-point.getZ().getCoordinate()),2));
		return dis;
	}
	public void add(Point3D point3D) 
	{
		super.add(point3D);
		this._z.add(point3D._z);		
	}
	public void add(Vector vector) 
	{
		super.add(vector.getHead());
		this._z.add(vector.getHead()._z);
	}
	public Point3D addPoint(Point3D p1) 
	{
	     double _x = this.getX().addCoordinate(p1.getX());
	     double _y = this.getY().addCoordinate(p1.getY());
	     double _z = this.getZ().addCoordinate(p1.getZ());
	     Point3D p = new Point3D(_x, _y, _z);
	     return p;
	}
	public void subtract (Point3D Point )
	{
		this.getX().substrct(Point.getX());
		this.getY().substrct(Point.getY());
		this.getZ().substrct(Point.getZ());
	}
	public Point3D substructPoint(Point3D p1) 
	{
		double _x = this.getX().substructCoordinate(p1.getX());
        double _y = this.getY().substructCoordinate(p1.getY());
        double _z = this.getZ().substructCoordinate(p1.getZ());
        Point3D p = new Point3D(_x, _y, _z);
        return p;
	}
	public Point3D mult(double num) 
	{
		setX(new Coordinate(getX().getCoordinate() * num));
	    setY(new Coordinate(getY().getCoordinate() * num));
	    setZ(new Coordinate(getZ().getCoordinate() * num));	
	    return new Point3D(this);
	}
}
