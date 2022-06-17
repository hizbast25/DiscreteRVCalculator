public class Hypergeometric extends DiscreteRV {
    private long n;
    private long r;
    private long capitalN;

    Hypergeometric (long n, long r, long capitalN) {
        super ();
        this.n = n;
        this.r = r;
        this.capitalN = capitalN;
        setMean((double)this.n*this.r/(double)this.capitalN);
        double var = (double)(this.n*this.r)*(this.capitalN - this.n)*(this.capitalN - this.r)/
                (double)(Math.pow(this.capitalN, 3)-Math.pow(this.capitalN, 2));
        setVariance(var);
    }

    @Override
    public double calculatePMF(long x) {
        double num     = kombinasi(this.r, x)*kombinasi(this.capitalN-this.r, this.n-x);
        double denum   = kombinasi(this.capitalN, this.n);
        return num/denum;
    }

    @Override
    public double calculateCDF(double x) {
        if (x < 0) {
            return 0;
        }
        int maxIter = (int) Math.floor(x);
        double sum = 0;
        for (int i = 0; i <= maxIter; i ++) {
            sum += calculatePMF(i);
        }
        return sum;

    }
}
