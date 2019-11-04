package primitives;

public class Point2D  
{
	// --------------- Fields --------------- //
	private Coordinate _x;
	private Coordinate _y;	
	// --------------- Constructors --------------- // 
	public Point2D() 
	{
		this._x = new Coordinate();
		this._y = new Coordinate();
	}
	public Point2D(double _x, double _y)
	{
		this._x = new Coordinate(_x);
		this._y = new Coordinate(_y);
	}
	public Point2D(Coordinate _x, Coordinate _y) 
	{
		this._x = new Coordinate(_x);
		this._y = new Coordinate(_y);
	}
	public Point2D(Point2D point2D)
	{
		this._x = new Coordinate(point2D._x);
		this._y = new Coordinate(point2D._y);
	}
	// --------------- Getters/Setters --------------- // 	
	public Coordinate getX() 
	{
		return this._x;
	}
	public void setX(Coordinate _x) 
	{
		this._x = new Coordinate(_x);
	}
	public Coordinate getY() 
	{
		return this._y;
	}
	public void setY(Coordinate _y)
	{
		this._y = new Coordinate(_y);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point2D))
			return false;
		Point2D other = (Point2D) obj;
		return this._x.equals(other._x) &&
				this._y.equals(other._y);
	}
	@Override
	public String toString() 
	{
		return "Point2D: _x="+this._x+", _y="+this._y+".";
	}
	// --------------- Operations --------------- // 
	public void add(Point2D point2D) 
	{
		this._x.add(point2D._x);
		this._y.add(point2D._y);		
	}
}
