package primitives;

public class Coordinate  
{
	// --------------- Fields --------------- //
	private double _coordinate;
	// --------------- Constructors --------------- // 
	public Coordinate() 
	{
		this._coordinate = 0.0;
	}
	public Coordinate(double _coordinate) 
	{
		this._coordinate = _coordinate;
	}
	public Coordinate(Coordinate coordinate) 
	{
		this._coordinate=coordinate._coordinate;
	}
	// --------------- Getters/Setters --------------- // 
	public double getCoordinate() 
	{
		return _coordinate;
	}
	public void setCoordinate(double _coordinate)
	{
		this._coordinate = _coordinate;
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordinate))
			return false;
		Coordinate other = (Coordinate) obj;
		return this._coordinate == other._coordinate;
	}
	@Override
	public String toString() 
	{
	return "Coordinate: _coordinate="+this._coordinate;
	}
	// --------------- Operations --------------- // 
	public void add (Coordinate arg0) 
	{
		this._coordinate+=arg0.getCoordinate();
	}
	public double addCoordinate(Coordinate _coordinate) 
	{
		return this._coordinate+ _coordinate._coordinate;
	}
	public void substrct  (Coordinate arg0) 
	{
		this._coordinate-=arg0.getCoordinate();
	}
	public double substructCoordinate(Coordinate _coordinate) 
	{
		return this._coordinate - _coordinate._coordinate;
	}
	public void mult(double multi)//change the coordinate
	{
		this._coordinate*=multi;
	}
	public double remult(Coordinate multi)//return the value
	{
		return this._coordinate*multi._coordinate;
	}
	public Coordinate reCoorMult(Coordinate multi)//return the coordinate
	{
		return new Coordinate(this._coordinate*multi._coordinate);
	}
	public void pow()
	{
		this._coordinate*=this._coordinate;
	}
}
