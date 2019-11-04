package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import elements.Camera;

import primitives.*;public class CameraTests 
{

	@Test
	public void testRaysConstructRayThroughPixel() 
	{
		Camera camera = new Camera();
		camera.setP0(new Point3D());
		camera.setVright(new Vector(1, 0, 0));
		camera.setVup(new Vector(0, 1, 0));
		double screenDistance = 100;
		camera.setVto(new Vector(0, 0, -1));
		int Nx=3;
		int Ny = 3;
		 double screenWidth =150;
		 double screenHeight = 150;
		 int x=1;
		 int y=2;
		 Ray ray = new Ray(camera.constructRayThroughPixel1(Nx, Ny, x, y, screenDistance, screenWidth, screenHeight));
		 assertEquals("",0.0, ray.getPOO().getX().getCoordinate(),1e-10);
		 assertEquals("",-50, ray.getPOO().getY().getCoordinate(),1e-10);
		 assertEquals("",-100, ray.getPOO().getZ().getCoordinate(),1e-10);
		 assertEquals("",ray.getDirection().getHead().getX().getCoordinate(), 0,1e-10);
		 assertEquals("",-1/Math.sqrt(5), ray.getDirection().getHead().getY().getCoordinate(),1e-10);
		 assertEquals("",-2/Math.sqrt(5), ray.getDirection().getHead().getZ().getCoordinate(),1e-10);		 
	}


}
