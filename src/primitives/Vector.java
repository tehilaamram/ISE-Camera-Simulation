package primitives;

public class Vector {
    // --------------- Fields --------------- //
    private Point3D _head;

    // --------------- Constructors --------------- //
    public Vector() {
        this._head = new Point3D();
    }

    public Vector(Point3D _head) {
        this._head = new Point3D(_head);
    }

    public Vector(Point3D _head, Point3D tail) {
        Point3D t = new Point3D(tail);
        t.subtract(_head);
        this._head = t;
    }

    public Vector(Vector vec) {
        this._head = new Point3D(vec.getHead());
    }

    public Vector(double i, double j, double k) {
        this._head = new Point3D(i, j, k);
    }

    // --------------- Getters/Setters --------------- //
    public Point3D getHead() {
        return this._head;
    }

    public void setHead(Point3D _head) {
        this._head = new Point3D(_head);
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Vector))
            return false;
        Vector other = (Vector) obj;
        return this._head.equals(other._head);
    }

    @Override
    public String toString() {
        return "Vector: _head=(" + this._head.getX() + ", " + this._head.getY() + ", " + this._head.getZ() + ").";
    }

    // --------------- Operations --------------- //
    public void add(Vector vector) {
        this._head.getX().add(vector.getHead().getX());
        this._head.getY().add(vector.getHead().getY());
        this._head.getZ().add(vector.getHead().getZ());
    }

    public void subtract(Vector vector) {
        this._head.subtract(vector.getHead());
    }

    public Vector substructVector(Vector v1) {
        Vector v3 = new Vector();
        v3._head = _head.substructPoint(v1._head);
        return v3;
    }

    public void scale(double scalingFacor) {
        this._head.setX(new Coordinate(scalingFacor * _head.getX().getCoordinate()));
        this._head.setY(new Coordinate(scalingFacor * _head.getY().getCoordinate()));
        this._head.setZ(new Coordinate(scalingFacor * _head.getZ().getCoordinate()));
    }

    public Vector ScaledVector(double scalingFacor) {
        Vector v = new Vector(this);
        v._head.getX().setCoordinate(v._head.getX().getCoordinate() * scalingFacor);
        v._head.getY().setCoordinate(v._head.getY().getCoordinate() * scalingFacor);
        v._head.getZ().setCoordinate(v._head.getZ().getCoordinate() * scalingFacor);
        return v;
    }

    public double length() {
        Coordinate c1 = new Coordinate(this.getHead().getX());
        Coordinate c2 = new Coordinate(this.getHead().getY());
        Coordinate c3 = new Coordinate(this.getHead().getZ());
        c1.pow();
        c2.pow();
        c3.pow();
        return Math.sqrt(c1.getCoordinate() + c2.getCoordinate() + c3.getCoordinate());
    }

    public void normalize() {
        if (this.length() != 0)
            this.scale((double) (1 / this.length()));
    }

    public Vector crossProduct(Vector vector) {
        double u1 = this.getHead().getX().getCoordinate();
        double u2 = this.getHead().getY().getCoordinate();
        double u3 = this.getHead().getZ().getCoordinate();
        double v1 = vector.getHead().getX().getCoordinate();
        double v2 = vector.getHead().getY().getCoordinate();
        double v3 = vector.getHead().getZ().getCoordinate();
        Coordinate x = new Coordinate(u2 * v3 - u3 * v2);
        Coordinate y = new Coordinate(u3 * v1 - u1 * v3);
        Coordinate z = new Coordinate(u1 * v2 - u2 * v1);
        return new Vector(new Point3D(x, y, z));
    }

    public double dotProduct(Vector vector) {
        return (this.getHead().getX().remult(vector.getHead().getX()) + this.getHead().getY().remult(vector.getHead().getY()) + this.getHead().getZ().remult(vector.getHead().getZ()));
    }
	 /* public double magnitude() //the distance from the reshit(0,0,0)
	  {
	        Point3D p0 = new Point3D(0, 0, 0);
	        double x = _head.Distance(p0);
	        return x;
	    }*/
}

