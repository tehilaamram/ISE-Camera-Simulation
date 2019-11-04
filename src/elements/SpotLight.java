package elements;

import java.awt.Color;

import primitives.*;

public class SpotLight extends PointLight
{
	// --------------- Fields --------------- //
	private Vector direction;
	// --------------- Constructors --------------- // 
	public SpotLight()
	{
		super();
		this.direction = new Vector();
	}
	public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) 
	{
		super(color, position, kc, kl, kq);
		this.direction = new Vector(direction);
		this.direction.normalize();
	}
	public SpotLight(SpotLight spotLight)
	{
		super(spotLight.getColor(), spotLight.getPosition(), spotLight.getKc(), spotLight.getKl(), spotLight.getKq());
		this.direction = new Vector(spotLight.direction);
		this.direction.normalize();
	}
	// --------------- Getters/Setters --------------- // 
	public Vector getDirection() 
	{
		return new Vector(direction);
	}
	public void setDirection(Vector direction)
	{
		this.direction = new Vector(direction);
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SpotLight))
			return false;
		SpotLight other = (SpotLight) obj;
		return this.direction.equals(other.direction);
	}
	@Override
	public String toString()
	{
		return "SpotLight [direction=" + direction + ", position=" + getPosition() + ", kc=" + getKc() + ", kl=" + getKl() + ", kq=" + getKq()
				+ ", color=" + getColor() + "]";
	}
	// --------------- Operations --------------- // 
	@Override
	public Color getIntensity(Point3D point) 
	{
		Color pointColor = super.getIntensity(point);
		Vector l = getL(point);
		l.normalize();
		double k = Math.abs(direction.dotProduct(l));
		if (k > 1) 
			k = 1; 
		return new Color((int)(pointColor.getRed()   * k),
			 		 	(int)(pointColor.getGreen() * k),
			 		 	(int)(pointColor.getBlue()  * k)); 
	}
}
