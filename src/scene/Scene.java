package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;

public class Scene 
{
	// --------------- Fields --------------- //
	private String sceneName;
	private Color background;
	private List<Geometry> geometries = new ArrayList<Geometry>();
	private Camera camera;
	private double screenDistance = 100;
	private AmbientLight ambient;
	private List<Light> lights = new ArrayList<Light>();
	// --------------- Constructors --------------- // 
	public Scene() 
	{
		setBackground(Color.black);
	    geometries=new ArrayList<Geometry>();
	    camera=new Camera();
	    setScreenDistance(100);
	    ambient=new AmbientLight();
	    lights=new ArrayList<Light>();
	}
	public Scene(String n, Color c, List<Geometry> g, Camera cam, double d,AmbientLight a,ArrayList<Light> l)
	{
		setSceneName(n);
	    setBackground(c);
	    geometries=new ArrayList<Geometry>();
		for(int i=0;i<g.size();i++)
		{
		    geometries.add(g.get(i));
		}
	    setCamera(cam);
	    setScreenDistance(d);
	    this.ambient=new AmbientLight(a);
	    this.lights=new ArrayList<Light>();
	    for(int i=0;i<l.size();i++)
	    {
	        lights.add(l.get(i));
	    }
	}
	public Scene(Scene s) 
	{
		sceneName=s.sceneName;
	    background= s.background;
	    geometries=new ArrayList<Geometry>();
	    for(int i=0;i<s.geometries.size();i++)
		{
	     	geometries.add(s.geometries.get(i));
		}
	    camera=new Camera(s.camera);
	    setScreenDistance(s.screenDistance);
	    this.ambient= s.ambient;
	    this.lights=new ArrayList<Light>();
	    for(int i=0;i<s.lights.size();i++)
	    {
	        lights.add(s.lights.get(i));
	    }
	}
	public Scene(Color background,Camera camera,double screenDistance)
	{
	    this.background=background;
	    this.camera=new Camera(camera);
	    this.screenDistance=screenDistance;
	}
	// --------------- Getters/Setters --------------- // 
	public String getSceneName() 
	{
		return sceneName;
	}
	public void setSceneName(String sceneName)
	{
		this.sceneName = sceneName;
	}
	public Color getBackground()
	{
		return background;
	}
	public void setBackground(Color background)
	{
		this.background = background;
	}
	public List<Geometry> getGeometries() 
	{
		return new ArrayList<Geometry>(geometries);
	}
	public void setGeometries(List<Geometry> geometries)
	{
		this.geometries = geometries;
	}
	public Camera getCamera() 
	{
		return new Camera(camera);
	}
	public void setCamera(Camera camera)
	{
		this.camera =new Camera( camera);
	}
	public double getScreenDistance()
	{
		return screenDistance;
	}
	public void setScreenDistance(double screenDistance)
	{
		this.screenDistance = screenDistance;
	}
	public AmbientLight getAmbient() 
	{
		return new AmbientLight (ambient);
	}
	public void setAmbient(AmbientLight ambient)
	{
		this.ambient = new AmbientLight (ambient);
	}
	public List<Light> getLights() 
	{
		return new ArrayList<Light>(lights);
	}
	public void setLights(List<Light> lights) 
	{
		this.lights = lights;
	}
	// --------------- Administration --------------- // 
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (ambient == null) {
			if (other.ambient != null)
				return false;
		} else if (!ambient.equals(other.ambient))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (camera == null) {
			if (other.camera != null)
				return false;
		} else if (!camera.equals(other.camera))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (lights == null) {
			if (other.lights != null)
				return false;
		} else if (!lights.equals(other.lights))
			return false;
		if (sceneName == null) {
			if (other.sceneName != null)
				return false;
		} else if (!sceneName.equals(other.sceneName))
			return false;
		if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Scene [sceneName=" + sceneName + ", background=" + background + ", geometries=" + geometries
				+ ", camera=" + camera + ", screenDistance=" + screenDistance + ", ambient=" + ambient + ", lights="
				+ lights + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	// --------------- Operations --------------- // 
	public void addGeometry(Geometry g) 
	{
		if (g != null)
	    {
	        this.geometries.add(g);
	    }
	}
	public Iterator<Geometry>getGeometriesIterator()
	{
		return geometries.iterator();

	}
	public void addLight(Light l)
	{
		lights.add(l);
	}
	public Iterator<Light> getLightsIterator ()
	{
		return lights.iterator();
	}
}
