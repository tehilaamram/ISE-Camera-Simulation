package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class VectorTests {

    @Test
    public void testAdd() {
        Vector vec = new Vector(new Point3D(new Coordinate(1), new Coordinate(4), new Coordinate(3)));

        vec.add(new Vector(new Point3D(new Coordinate(0), new Coordinate(1), new Coordinate(2))));
        assertEquals(new Vector(new Point3D(new Coordinate(1), new Coordinate(5), new Coordinate(5))), vec);
    }

    @Test
    public void testSubtract() {
        Vector vec = new Vector(new Point3D(new Coordinate(0), new Coordinate(4), new Coordinate(3)));
        vec.subtract(new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(2))));
        assertEquals(new Vector(new Point3D(new Coordinate(-1), new Coordinate(3), new Coordinate(1))), vec);
    }

    @Test
    public void testScaling() {
        Vector vec = new Vector(new Point3D(new Coordinate(0), new Coordinate(4), new Coordinate(3)));
        vec.scale(5);
        assertEquals(new Vector(new Point3D(new Coordinate(0), new Coordinate(20), new Coordinate(15))), vec);
        vec.scale(0);
        assertEquals(new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0))), vec);
    }

    @Test
    public void testDotProduct() {
        Vector vec = new Vector(new Point3D(new Coordinate(0), new Coordinate(4), new Coordinate(3)));
        double d = vec.dotProduct(vec);
        assertEquals(d, 25.0, 0);
    }

    @Test
    public void testLength() {
        Vector vec = new Vector(new Point3D(new Coordinate(0), new Coordinate(4), new Coordinate(3)));
        double d = vec.length();
        assertEquals(d, 5.0, 0);
        vec.scale(0);
        d = vec.length();
        assertEquals(d, 0.0, 0);
    }

    @Test
    public void testNormalize() {
        Vector vec = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(2)));

        vec.normalize();
        assertEquals(vec, new Vector(new Point3D(new Coordinate((double) 1 / 3), new Coordinate((double) 2 / 3), new Coordinate((double) 2 / 3))));

    }

    @Test
    public void testCrossProduct() {
        Vector vec = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(3)));
        Vector vec2 = new Vector(new Point3D(new Coordinate(2), new Coordinate(1), new Coordinate(0)));
        Vector vec3 = vec2.crossProduct(vec);
        assertEquals(vec3, new Vector(new Point3D(new Coordinate(3), new Coordinate(-6), new Coordinate(3))));

    }


}
