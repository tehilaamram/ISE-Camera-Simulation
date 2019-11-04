package renderer;

import java.awt.Color;
import primitives.*;
import scene.Scene;

import java.util.Iterator;
import java.util.List;
//import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import elements.*;
import geometries.*;

public class Render 
{
	// --------------- Fields --------------- //
	private Scene scene;
	private ImageWriter imageWriter;
	private final int RECURSION_LEVEL=2;
	// --------------- Constructors --------------- // 	
	public Render(ImageWriter imageWriter, Scene scene)
	{
		this.imageWriter = imageWriter;
		this.scene = scene;
	}
	// --------------- Operations --------------- // 	
	public void renderImage()
	{
		for (int i = 0; i < imageWriter.getHeight(); i++)
		{
			for (int j = 0; j < imageWriter.getWidth(); j++)
			{
				List<Ray> listRay = scene.getCamera().constructRayThroughPixel(
						  imageWriter.getNx(), imageWriter.getNy(), j, i, 
						  scene.getScreenDistance(),
						  imageWriter.getWidth(), imageWriter.getHeight());
				int r=0,g=0,b=0;
				for (Ray ray : listRay)
				{
					Map<Geometry, List<Point3D>> intersectionPoints = findClosesntIntersection(ray);	
					if (intersectionPoints.isEmpty())
					{
						r+=scene.getBackground().getRed();
						g+=scene.getBackground().getGreen();
						b+=scene.getBackground().getBlue();
					} 
					else 
					{
						Entry<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
						Color c=calcColor(closestPoint.getKey(),closestPoint.getValue(), ray);
						r+=c.getRed();
						g+=c.getGreen();
						b+=c.getBlue();
					}
				
				}
				imageWriter.writePixel(j, i, new Color(r/listRay.size(),g/listRay.size(),b/listRay.size()));
			}
		}
		imageWriter.writeToimage();
	}
	private Map<Geometry,List<Point3D>> findClosesntIntersection(Ray ray) 
	{
		Iterator<Geometry> geometries = scene.getGeometriesIterator();
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>();
		while (geometries.hasNext())
		{
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
			if (!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry,geometryIntersectionPoints);
		}
		return intersectionPoints;
	}
	private Entry<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints) 
	{
		double distance = Double.MAX_VALUE;
		Point3D P0 = scene.getCamera().getP0();
		Map<Geometry,Point3D> minDistancePoint = new HashMap<Geometry,Point3D>();
		for (Entry<Geometry, List<Point3D>> entry:intersectionPoints.entrySet())
			for (Point3D point: entry.getValue())
				if (P0.Distance(point) < distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.Distance(point); 
				}
		Entry<Geometry, Point3D> entry = minDistancePoint.entrySet().iterator().next();
		return entry;
	}
	private Color calcColor(Geometry geometry, Point3D point, Ray ray)
	{
		return calcColor(geometry, point, ray, 0);
	}
	
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay,int level)
	{		
		if (level == RECURSION_LEVEL)
		{
				return new Color(0, 0, 0);
		}
		Color ambientLight = scene.getAmbient().getIntensity(point);
		Color emissionLight = geometry.getEmmission();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		Color reflected = new Color(0, 0, 0);		
		Color refracted = new Color(0, 0, 0);
		Iterator<Light> lights = scene.getLightsIterator();
		while (lights.hasNext())
		{		
			Light light = lights.next();
			if (!occluded(light, point, geometry))
			{
				Color lightIntensity = light.getIntensity(point);
				Color lightDiffuse = calcDiffusiveComp(geometry.getMaterial().getKd(),geometry.getNormal(point),light.getL(point), lightIntensity);
				diffuseLight=addColors(diffuseLight,lightDiffuse);
				Color lightSpecular = calcSpecularComp(geometry.getMaterial().getKs(),new Vector(point, scene.getCamera().getP0()),geometry.getNormal(point),light.getL(point),geometry.getMaterial().getNshininess(), lightIntensity);
				specularLight=addColors(specularLight,lightSpecular);
			}
		}	
		// Recursive call for a reflected ray
		Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
		Map<Geometry, List<Point3D>> reflectedIntersectionPoints = findClosesntIntersection(reflectedRay);
		if (!reflectedIntersectionPoints.isEmpty())
		{
			Entry<Geometry, Point3D> reflectedClosesEntry = getClosestPoint(reflectedIntersectionPoints);
			reflected = calcColor(reflectedClosesEntry.getKey(), reflectedClosesEntry.getValue(), reflectedRay, level+1);
			double kr = geometry.getMaterial().getKr();
			reflected = new Color ((int)(reflected.getRed() * kr), (int)(reflected.getGreen() * kr),(int)(reflected.getBlue() * kr));
		}
		// Recursive call for a refracted ray
		Ray refractedRay = constructRefractedRay(geometry, point, inRay);
		Map<Geometry, List<Point3D>> refractedIntersectionPoints = findClosesntIntersection(refractedRay);
		if (!refractedIntersectionPoints.isEmpty())
		{
			Entry<Geometry, Point3D> refractedEntry = getClosestPoint(refractedIntersectionPoints);
			refracted = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
			double kt = geometry.getMaterial().getKt();
			refracted = new Color ((int)(refracted.getRed() * kt), (int)(refracted.getGreen() * kt),(int)(refracted.getBlue() * kt));
		}
		Color finalColor = addColors(ambientLight, emissionLight);
		finalColor= addColors(finalColor, diffuseLight);
		finalColor= addColors(finalColor, specularLight);
		finalColor= addColors(finalColor, reflected);
		finalColor= addColors(finalColor, refracted);
		return finalColor;
	}
	private Color addColors(Color x,Color y)
	{
		int r=x.getRed()+y.getRed();
		if (r>255)
			r=255;
		int g=x.getGreen()+y.getGreen();
		if (g>255) 
			g=255;
		int b=x.getBlue()+y.getBlue();
		if (b>255)
			b=255;
		return new Color(r,g,b);
	}
	private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, double shininess, Color lightIntensity) 
	{
		v.normalize();
		normal.normalize();
		l.normalize();
		normal.scale(-2 * l.dotProduct(normal));
		l.add(normal);
		Vector R = new Vector(l);
		R.normalize();
		double k=0;
		if (v.dotProduct(R) > 0) 
			k = ks * Math.pow(v.dotProduct(R), shininess);
		int r=(int)(lightIntensity.getRed() * k);
	    int g=(int)(lightIntensity.getGreen() * k);
	    int b=(int)(lightIntensity.getBlue() * k);
        return new Color (r,g,b);	
	}
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity)
	{
		normal.normalize();
		l.normalize();
		double k = Math.abs(kd * normal.dotProduct(l));
        int r=(int)(lightIntensity.getRed() * k);
        int g=(int)(lightIntensity.getGreen() * k);
        int b=(int)(lightIntensity.getBlue() * k);
		return new Color (r,g,b);
	}
	private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay)
	{		
		Vector normal = geometry.getNormal(point);
		normal.scale(-2);
		point.add(normal);
		return new Ray (point, inRay.getDirection());
	}			
	private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay)
	{		
		Vector l = inRay.getDirection();
		l.normalize();
		normal.scale(-2 * l.dotProduct(normal));
		l.add(normal);
		Vector R = new Vector(l);
		R.normalize();
		point.add(normal);
		Ray reflectedRay = new Ray(point, R);
		return reflectedRay;
	}
	public void printGrid(int interval)
	{	
		for (int i = 0; i < imageWriter.getNx(); i++)
		{
			for (int j = 0; j < imageWriter.getNy(); j++)
			{	
				if (i % interval == 0 || j % interval == 0)
					imageWriter.writePixel(j, i, 255, 255, 255);
				
			}
		}
	}
	private boolean occluded(Light light, Point3D point, Geometry geometry)
	{	
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		lightDirection.normalize();	
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection); 
		Map<Geometry, List<Point3D>> intersectionPoints = findClosesntIntersection(lightRay);
		if (geometry instanceof FlatGeometry)
			intersectionPoints.remove(geometry);
		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
			if (entry.getKey().getMaterial().getKt() == 0)
				return true;
		return false;
	}
}

