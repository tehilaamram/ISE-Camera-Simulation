package elements;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
    // --------------- Fields --------------- //
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vRight;
    private Vector _vTo;

    // --------------- Constructors --------------- //
    public Camera() {
        this._P0 = new Point3D();
        this._vUp = new Vector(new Point3D(0, 1, 0));
        this._vTo = new Vector(new Point3D(0, 0, -1));
        this._vRight = new Vector(new Point3D(1, 0, 0));
    }

    public Camera(Point3D _P0, Vector _vUp, Vector _vRight, Vector _vTo) {
        this._P0 = new Point3D(_P0);
        this._vUp = new Vector(_vUp);
        this._vRight = new Vector(_vRight);
        this._vTo = new Vector(_vTo);
    }

    public Camera(Camera camera) {
        this._P0 = new Point3D(camera._P0);
        this._vUp = new Vector(camera._vUp);
        this._vRight = new Vector(camera._vRight);
        this._vTo = new Vector(camera._vTo);
    }

    // --------------- Getters/Setters --------------- //
    public Point3D getP0() {
        return new Point3D(_P0);
    }

    public void setP0(Point3D _P0) {
        this._P0 = new Point3D(_P0);
    }

    public Vector getVup() {
        return new Vector(_vUp);
    }

    public void setVup(Vector _vUp) {
        this._vUp = new Vector(_vUp);
    }

    public Vector getVright() {
        return new Vector(_vRight);
    }

    public void setVright(Vector _vRight) {
        this._vRight = new Vector(_vRight);
    }

    public Vector getVto() {
        return new Vector(_vTo);
    }

    public void setVto(Vector _vTo) {
        _vTo = new Vector(_vTo);
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Camera))
            return false;
        Camera other = (Camera) obj;
        return this._P0.equals(other._P0) &&
                this._vRight.equals(other._vRight) &&
                this._vTo.equals(other._vTo) &&
                this._vUp.equals(other._vUp);
    }

    @Override
    public String toString() {
        return "Camera [center=" + _P0 + ", vup=" + _vUp + ", vright=" + _vRight + ", Vtoward=" + _vTo + "]";
    }
    // --------------- Operations --------------- //

    public Ray constructRayThroughPixel1(int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight) {
        Vector vto = new Vector(this._vTo);
        Vector vright = new Vector(this._vRight);
        Vector vup = new Vector(this._vUp);

        vto.scale(screenDist);

        Point3D pc = new Point3D(_P0);
        pc.add(vto.getHead());//pc

        double rx = screenWidth / Nx;
        double ry = screenHeight / Ny;

        vright.scale((x - Nx / 2.0) * rx + rx / 2.0);
        vup.scale((y - Ny / 2.0) * ry + ry / 2.0);

        vright.subtract(vup);
        pc.add(vright.getHead());

        Point3D p = new Point3D(pc);//p is pc after the changes
        Vector vec = new Vector(getP0(), p);
        vec.normalize();

        return new Ray(new Point3D(p), vec);


    }

    public List<Ray> constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist,
                                              double screenWidth, double screenHeight) {
        List<Ray> rays = new ArrayList<Ray>();
        Vector vToward = new Vector(this._vTo);
        vToward.scale(screenDist);
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;
        Point3D Pc = new Point3D(this._P0);
        Pc.add(vToward.getHead());
        Vector vRight = new Vector(this._vRight);
        Vector vUp = new Vector(this._vUp);
        vRight.scale(((x - (Nx / 2.0)) * Rx + Rx / 2.0));
        vUp.scale(((y - (Ny / 2.0)) * Ry + Ry / 2.0));
        vRight.subtract(vUp);
        Pc.add(vRight.getHead());
        Point3D P1 = new Point3D(Pc);
        //till here as the up one
        //constructing ray between P0 and the intersection point for super sampling
        Vector ray1 = new Vector(_P0, P1);
        Point3D P2 = new Point3D(P1.addPoint(new Point3D(0.25 * Rx, 0.25 * Ry, 0)));
        Vector ray2 = new Vector(_P0, P2);
        Point3D P3 = new Point3D(P1.addPoint(new Point3D(0.25 * Rx, (-0.25) * Ry, 0)));
        Vector ray3 = new Vector(_P0, P3);
        Point3D P4 = new Point3D(P1.addPoint(new Point3D((-0.25) * Rx, 0.25 * Ry, 0)));
        Vector ray4 = new Vector(_P0, P4);
        Point3D P5 = new Point3D(P1.addPoint(new Point3D((-0.25) * Rx, (-0.25) * Ry, 0)));
        Vector ray5 = new Vector(_P0, P5);
        Point3D P6 = new Point3D(P1.addPoint(new Point3D((0) * Rx, (-0.25) * Ry, 0)));
        Vector ray6 = new Vector(_P0, P5);
        Point3D P7 = new Point3D(P1.addPoint(new Point3D((0) * Rx, (0.25) * Ry, 0)));
        Vector ray7 = new Vector(_P0, P5);
        Point3D P8 = new Point3D(P1.addPoint(new Point3D((-0.25) * Rx, (0) * Ry, 0)));
        Vector ray8 = new Vector(_P0, P5);
        Point3D P9 = new Point3D(P1.addPoint(new Point3D((0.25) * Rx, (0) * Ry, 0)));
        Vector ray9 = new Vector(_P0, P5);
        ray1.normalize();
        ray2.normalize();
        ray3.normalize();
        ray4.normalize();
        ray5.normalize();
        ray6.normalize();
        ray7.normalize();
        ray8.normalize();
        ray9.normalize();
        rays.add(new Ray(P1, ray1));
		/*rays.add(new Ray(P2, ray2));
		rays.add(new Ray(P3, ray3));
		rays.add(new Ray(P4, ray4));
		rays.add(new Ray(P5, ray5));
		rays.add(new Ray(P6, ray6));
		rays.add(new Ray(P7, ray7));
		rays.add(new Ray(P8, ray8));
		rays.add(new Ray(P9, ray9));*/
        return rays;
    }
}
	


