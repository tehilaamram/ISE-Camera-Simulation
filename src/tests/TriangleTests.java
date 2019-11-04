package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import geometries.*;
import primitives.*;
public class TriangleTests {
	@Test
	public void testFindIntersections() 
	{
		Triangle triangle = new Triangle(new Point3D(100,100,-200),
											new Point3D(-100,100,-200),
												new Point3D(0,-100,-200));
		Ray ray1 = new Ray(new Point3D(), new Vector(0, 1/Math.sqrt(5), -2/Math.sqrt(5)));
		ArrayList<Point3D> lst1 = new ArrayList<Point3D>(triangle.findIntersections(ray1));
		assertEquals(0, lst1.size());
		Ray ray2 = new 	Ray(new Point3D(), new Vector(1/Math.sqrt(6), 1/Math.sqrt(6), -1*Math.sqrt(2/3.0)));
		ArrayList<Point3D> lst2 = new ArrayList<Point3D>(triangle.findIntersections(ray2));
		assertEquals(0, lst2.size());
	}


}
