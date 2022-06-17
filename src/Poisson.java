public class Poisson extends DiscreteRV{
    private double a;
    Poisson (double a) {
        super();
        this.a = a;
        setMean(this.a);
        setVariance(this.a);
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

    @Override
    public double calculatePMF(long x) {
        if (x >= 0) {
            double PMF = Math.exp(this.a*(-1))*Math.pow(this.a, x)/factorial(x);
            return PMF;
        }
        return 0;
    }

    public long factorial(long x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        return x*factorial(x-1);
    }
}
