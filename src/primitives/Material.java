package primitives;

public class Material {
    // --------------- Fields --------------- //
    private double _Ks;
    private double _Kd;
    private double _Nshininess;
    private double _Kt;
    private double _Kr;

    // --------------- Constructors --------------- //
    public Material() {
        this._Ks = 1;
        this._Kd = 1;
        this._Nshininess = 1;
        this._Kt = 0;
        this._Kr = 0;
    }

    public Material(double _Ks, double _Kd, double _Nshininess) {
        this._Ks = _Ks;
        this._Kd = _Kd;
        this._Nshininess = _Nshininess;
    }

    public Material(double _Ks, double _Kd, double _Nshininess, double _Kt, double _Kr) {
        this._Ks = _Ks;
        this._Kd = _Kd;
        this._Nshininess = _Nshininess;
        this._Kt = _Kt;
        this._Kr = _Kr;
    }

    public Material(Material material) {
        this._Ks = material._Ks;
        this._Kd = material._Kd;
        this._Nshininess = material._Nshininess;
        this._Kt = material._Kt;
        this._Kr = material._Kr;
    }

    // --------------- Getters/Setters --------------- //
    public double getKs() {
        return _Ks;
    }

    public void setKs(double _Ks) {
        this._Ks = _Ks;
    }

    public double getKd() {
        return _Kd;
    }

    public void setKd(double _Kd) {
        this._Kd = _Kd;
    }

    public double getNshininess() {
        return _Nshininess;
    }

    public void setNshininess(double _Nshininess) {
        this._Nshininess = _Nshininess;
    }

    public double getKt() {
        return _Kt;
    }

    public void setKt(double _Kt) {
        this._Kt = _Kt;
    }

    public double getKr() {
        return _Kr;
    }

    public void setKr(double _Kr) {
        this._Kr = _Kr;
    }

    // --------------- Administration --------------- //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Material))
            return false;
        Material other = (Material) obj;
        return this._Kd == other._Kd &&
                this._Kr == other._Kr &&
                this._Ks == other._Ks &&
                this._Kt == other._Kt &&
                this._Nshininess == other._Nshininess;
    }

    @Override
    public String toString() {
        return "Material [ks=" + _Ks + ", kd=" + _Kd + ", n=" + _Nshininess + ", _Kt=" + _Kt + ", _Kr=" + _Kr + "]";
    }
    // --------------- Operations --------------- //
}
