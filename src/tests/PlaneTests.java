package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import geometries.*;
import primitives.*;
public class PlaneTests {

	@Test
	public void testGetNormal() 
	{
		Plane p = new Plane(new Point3D(),new Vector(5, 2, 1));
		assertEquals(new Vector(5, 2, 1),p.getN());
	}
	@Test
	public void testFindIntersections()
	{
		Plane plane = new Plane(new Point3D(0, 0, -200),new Vector(0, 0, 1));
		//********** checks first case with one intersection point **********//
		Ray ray1 = new Ray(new Point3D(), new Vector(0, 1/Math.sqrt(5), -2/Math.sqrt(5)));
		ArrayList<Point3D> lst1 = new ArrayList<Point3D>(plane.findIntersections(ray1));
		assertEquals(1, lst1.size());
		assertEquals("",0, lst1.get(0).getX().getCoordinate(),1e-10);
		assertEquals("",100, lst1.get(0).getY().getCoordinate(),1e-10);
		assertEquals("",-200, lst1.get(0).getZ().getCoordinate(),1e-10);				
		//********** checks second case with one intersection intersections **********//
		Ray ray2 = new 	Ray(new Point3D(), new Vector(1/Math.sqrt(6), 1/Math.sqrt(6), -1*Math.sqrt(2/3.0)));
		ArrayList<Point3D> lst2 = new ArrayList<Point3D>(plane.findIntersections(ray2));
		assertEquals(1, lst2.size());
		assertEquals("",100, lst2.get(0).getX().getCoordinate(),1e-10);
		assertEquals("",100, lst2.get(0).getY().getCoordinate(),1e-10);
		assertEquals("",-200, lst2.get(0).getZ().getCoordinate(),1e-10);
	}
}
