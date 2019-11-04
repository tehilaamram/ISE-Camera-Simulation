package primitives;

public class Ray 
{
	// --------------- Fields --------------- //
	private Point3D _POO;
	private Vector _direction;
	// --------------- Constructors --------------- // 
	public Ray() 
	{
		this._POO = new Point3D();
		this._direction = new Vector();
		this._direction.normalize();
	}
	public Ray(Point3D _POO, Vector _direction) 
	{
		this._POO = new Point3D(_POO);
		this._direction = new Vector(_direction);
		this._direction.normalize();
	}
	public Ray(Ray ray) 
	{
		this._POO = new Point3D(ray._POO);
		this._direction = new Vector (ray._direction);
		this._direction.normalize();
	}
	// --------------- Getters/Setters --------------- // 
	public Point3D getPOO() 
	{
		return new Point3D(_POO);
	}
	public void setPOO(Point3D _POO) 
	{
		this._POO = new Point3D(_POO);
	}
	public Vector getDirection() 
	{
		return new Vector(this._direction);
	}
	public void setDirection(Vector _direction) 
	{
		this._direction = new Vector(_direction);
		this._direction.normalize();
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return this._direction.equals(other._direction) &&
				this._POO.equals(other._POO);	
	}
	@Override
	public String toString() 
	{
		return "Ray [point=" + _POO + ", vector=" + _direction + "]";
	}
	// --------------- Operations --------------- // 
}


