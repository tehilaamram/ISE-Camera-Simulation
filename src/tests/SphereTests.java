package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import primitives.*;
import geometries.*;
public class SphereTests {

	@Test
	public void testGetNormal() 
	{
		Sphere s = new Sphere(10.2, new Point3D(12,2,0));
		Point3D p = new Point3D(16,4,2);
		Vector v = new Vector(s.getNormal(p));
		assertEquals(new Vector(2/Math.sqrt(6), 1/Math.sqrt(6), 1/Math.sqrt(6)), v);
	}
	
	@Test
	public void testFindIntersections()
	{
		//********** checks when there are intersections **********//
		Ray ray1 = new Ray(new Point3D(), new Vector(0, 1/Math.sqrt(5), -2/Math.sqrt(5)));
		Sphere sphere = new Sphere(200, new Point3D(0, 0,-400));
		ArrayList<Point3D> lst1 = new ArrayList<Point3D>(sphere.findIntersections(ray1));
		//check if there are 2 intersection points as needed
		assertEquals(2, lst1.size());
		//check the value of the first intersection point
		assertEquals("",0, lst1.get(0).getX().getCoordinate(),1e-10);
		assertEquals("",120, lst1.get(0).getY().getCoordinate(),1e-10);
		assertEquals("",-240, lst1.get(0).getZ().getCoordinate(),1e-10);
		//check the value of the second intersection point
		assertEquals("",0, lst1.get(1).getX().getCoordinate(),1e-10);
		assertEquals("",200, lst1.get(1).getY().getCoordinate(),1e-10);
		assertEquals("",-400, lst1.get(1).getZ().getCoordinate(),1e-10);
		//********** checks where there are no intersections **********//
		Ray ray2 = new 	Ray(new Point3D(), new Vector(1/Math.sqrt(6), 1/Math.sqrt(6), -1*Math.sqrt(2/3)));
		ArrayList<Point3D> lst2 = new ArrayList<Point3D>(sphere.findIntersections(ray2));
		assertEquals(0, lst2.size());
	}


}
