public class Bernoulli extends DiscreteRV {
    private double p;
    Bernoulli (double p) {
        super();
        this.p = p;
        setMean(this.p);
        setVariance(this.p - this.p*this.p);
    }
    public double calculateCDF(double x) {
        if (x < 0) {
            return 0;
        }
        else if (x < 1) {
            return (1 - this.p);
        }
        else{
            return 1;
        }

    }

    @Override
    public double calculatePMF(long x) {
        if (x == 1) {
            return this.p;
        }
        else if (x == 0) {
            return 1 - this.p;
        }
        else {
            return 0;
        }
    }

    public double getP() {
        return p;
    }
}
