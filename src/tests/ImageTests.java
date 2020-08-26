package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import primitives.*;
import elements.*;
import geometries.*;
import renderer.*;
import scene.*;

public class ImageTests {
    @Test
    public void emmissionTest() {

        Scene scene = new Scene();

        scene.addGeometry(new Sphere(50., new Point3D(0.0, 0.0, -149), new Color(255, 0, 0)));

        Triangle triangle = new Triangle(new Point3D(100, 0, -149),
                new Point3D(0, 100, -149),
                new Point3D(100, 100, -149),
                new Color(0, 255, 0));

        Triangle triangle2 = new Triangle(new Point3D(100, 0, -149),
                new Point3D(0, -100, -149),
                new Point3D(100, -100, -149),
                new Color(0, 0, 255));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
                new Point3D(0, 100, -149),
                new Point3D(-100, 100, -149),
                new Color(255, 255, 0));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
                new Point3D(0, -100, -149),
                new Point3D(-100, -100, -149),
                new Color(255, 0, 255));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmition test1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }


    @Test
    public void spotLightTest20() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270),
                new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setNshininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), new Vector(new Point3D(2, 2, -3)),
                0.1, 0.00001, 0.000005));
        scene.addLight(new PointLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005)));
        ImageWriter imageWriter = new ImageWriter("Spot test 2-01", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest21() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-75, -175, -260),
                new Point3D(-175, -75, -260),
                new Point3D(-175, -175, -270),
                new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setNshininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), new Vector(new Point3D(2, 2, -3)),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2-1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest22() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-50, -150, -300),
                new Point3D(-150, -50, -300),
                new Point3D(-150, -150, -310),
                new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setNshininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), new Vector(new Point3D(2, 2, -3)),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2-2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest23() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270),
                new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setNshininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -175), new Vector(new Point3D(2, 2, -3)),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2-3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest24() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270),
                new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setNshininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -200), new Vector(new Point3D(2, 2, -3)),
                0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2-4", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                new Vector(new Point3D(2, 2, -3)), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }


    @Test
    public void pointLightTest() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(400., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test 0", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();


    }

    @Test
    public void pointLightTest1() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(400., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Sphere sphere2 = new Sphere(150., new Point3D(-150, -120, -500), new Color(0, 0, 100));
        Triangle triangle = new Triangle(new Point3D(900, 900, -1400),
                new Point3D(1300, 0, -1500),
                new Point3D(600, 0, -1500),
                new Color(0, 0, 100));
        Triangle triangle2 = new Triangle(new Point3D(-100, -100, -200),
                new Point3D(-50, -150, -220),
                new Point3D(-150, -150, -220),
                new Color(0, 0, 100));


        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        triangle.setMaterial(m);
        triangle2.setMaterial(m);
        sphere2.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(sphere2);
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(0, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test 0-1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();


    }

    @Test
    public void spotLightTest3() {

        Scene scene = new Scene();

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000),
                new Color(0, 0, 0));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000),
                new Color(0, 0, 0));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(new Point3D(-2, -2, -3)), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest4() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(300., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000),
                new Color(0, 0, 0));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000),
                new Color(0, 0, 0));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(new Point3D(-2, -2, -3)), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Spot test 4", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void pointLightTest2() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000),
                new Color(0, 0, 0));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000),
                new Color(0, 0, 0));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void directionTest() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new DirectionalLight(new Color(255, 100, 100), new Vector(new Point3D(-20, 20, -3))));

        ImageWriter imageWriter = new ImageWriter("Direction test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToimage();
    }


    @Test
    public void recursiveTest() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        m.setKt(0.5);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250., new Point3D(0.0, 0.0, -1000), new Color(100, 20, 20));
        Material m2 = new Material();
        m2.setNshininess(20);
        m2.setKt(0);
        sphere2.setMaterial(m2);
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void recursiveTest2() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300., new Point3D(-550, -500, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        m.setKt(0.5);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150., new Point3D(-550, -500, -1000), new Color(100, 20, 20));
        Material m2 = new Material();
        m2.setNshininess(20);
        m2.setKt(0);
        sphere2.setMaterial(m2);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(200, 200, -375),
                new Color(20, 20, 20));

        Triangle triangle2 = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(-1500, -1500, -1500),
                new Color(20, 20, 20));

        Material m3 = new Material();
        Material m4 = new Material();
        m3.setKr(1);
        m4.setKr(0.5);
        triangle.setMaterial(m3);
        triangle2.setMaterial(m4);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2.1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void recursiveTest3() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300., new Point3D(0, 0, -1000), new Color(0, 0, 100));
        Material m = new Material();
        m.setNshininess(20);
        m.setKt(0.5);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150., new Point3D(0, 0, -1000), new Color(100, 20, 20));
        Material m1 = new Material();
        m1.setNshininess(20);
        m1.setKt(0);
        sphere2.setMaterial(m1);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(2000, -1000, -1500),
                new Point3D(-1000, 2000, -1500),
                new Point3D(700, 700, -375),
                new Color(20, 20, 20));

        Triangle triangle2 = new Triangle(new Point3D(2000, -1000, -1500),
                new Point3D(-1000, 2000, -1500),
                new Point3D(-1000, -1000, -1500),
                new Color(20, 20, 20));

        Material m2 = new Material();
        m2.setKr(1);
        triangle.setMaterial(m2);

        Material m3 = new Material();
        m3.setKr(0.5);
        triangle2.setMaterial(m3);


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void RecursiveTest4() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500., new Point3D(500.0, -500.0, -1000), new Color(100, 50, 0), new Material(1, 1, 2, 0.8, 0));
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(500., new Point3D(-1000.0, -2000.0, -1000), new Color(0, 50, 100), new Material(1, 1, 20, 0, 0));
        scene.addGeometry(sphere2);
        Sphere sphere3 = new Sphere(200., new Point3D(-500.0, 500.0, -1000), new Color(100, 0, 0), new Material(1, 1, 2, 0.8, 0));

        scene.addGeometry(sphere3);
        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000),
                new Color(0, 0, 0), new Material(1, 1, 1, 0, 1));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000),
                new Color(0, 0, 0), new Material(1, 1, 1, 0, 1));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(new Point3D(-2, -2, -3)), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Recursive test 4", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }
}
