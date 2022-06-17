public class Binomial extends Bernoulli{
    private long n;
    Binomial (double p, long n) {
        super(p);
        this.n = n;
        setMean(getMean()*n);
        setVariance(getVariance()*n);
    }

    @Override
    public double calculateCDF(double x) {
        if (x < 0) {
            return 0;
        }
        else if (x >= n) {
            return 1;
        }
        else {
            int maxIter = (int) Math.floor(x);
            double sum = 0;
            for (int i = 0; i <= maxIter; i++) {
                sum += calculatePMF(i);
            }
            return sum;
        }

    }

    @Override
    public double calculatePMF(long x) {
        double PMF = kombinasi(n,x)*(Math.pow(getP(), x))*(Math.pow(1-getP(), n-x));
        return PMF;
    }
}
