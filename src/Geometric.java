public class Geometric extends Bernoulli{
    Geometric (double p) {
        super(p);
        setMean(1/getP());
        setVariance((1-getP())/(Math.pow(getP(),2)));
    }

    @Override
    public double calculateCDF(double x) {
        if (x  < 1) {
            return 0;
        }
        else {
            return 1 - Math.pow(1-getP(), Math.floor(x));
        }

    }

    @Override
    public double calculatePMF(long x) {
        return getP()*(Math.pow(1-getP(), x-1));
    }
}
