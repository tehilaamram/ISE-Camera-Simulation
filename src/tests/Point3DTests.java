package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import primitives.*;

public class Point3DTests {

    @Test
    public void testAdd() {
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D(new Coordinate(5), new Coordinate(5), new Coordinate(5));
        p2.add(new Vector(p1));
        assertEquals(new Point3D(5, 5, 5), p2);
    }

    @Test
    public void testSubtract() {
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D(new Coordinate(5), new Coordinate(5), new Coordinate(5));
        p2.subtract(p1);
        assertEquals(new Point3D(5, 5, 5), p2);
    }

}
