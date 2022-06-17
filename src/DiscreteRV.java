public abstract class DiscreteRV {

    // Attributes
    private double mean;
    private double variance;
    DiscreteRV () {
    }

    // Method abstract untuk CDF dan PMF
    public abstract double calculateCDF (double x);
    public abstract double calculatePMF (long x);

    // Method menghitung peluang khusus (mencakup semua kemungkinan)

    // P(X < x)
    public double lessThan (double x) {
        if (x == Math.floor(x)) {
            return calculateCDF(x-1);
        }
        return calculateCDF(Math.floor(x));
    }

    // P(a < X < b)
    public double xLessThanBMoreThanA (double a, double b) {
        int newA;
        int newB;
        if (a == Math.ceil(a)) {
            newA = (int) a + 1;
        }
        else {
            newA = (int) Math.ceil(a);
        }
        if (b == Math.floor(b)) {
            newB = (int) b - 1;
        }
        else {
            newB = (int) Math.floor(b);
        }
        double sum = 0;
        for (int i = newA; i <= newB; i++) {
            sum += calculatePMF(i);
        }
        return sum;
    }

    // P(a <= X < b)
    public double xLessThanBMoreThanEqualA (double a, double b) {
        int newB;
        int newA = (int) Math.ceil(a);
        if (b == Math.floor(b)) {
            newB = (int) b - 1;
        }
        else {
            newB = (int) Math.floor(b);
        }
        double sum = 0;
        for (int i = newA; i <= newB; i++) {
            sum += calculatePMF(i);
        }
        return sum;
    }

    // P(a < X <= b)
    public double xLessThanEqualBMoreThanA (double a, double b) {
        int newA;
        int newB = (int) Math.floor(b);
        if (a == Math.ceil(a)) {
            newA = (int) a + 1;
        }
        else {
            newA = (int) Math.ceil(a);
        }
        double sum = 0;
        for (int i = newA; i <= newB; i++) {
            sum += calculatePMF(i);
        }
        return sum;
    }

    // P(a <= X <= b)
    public double xLessThanEqualBMoreThanEqualA (double a, double b) {
        int newA = (int) Math.ceil(a);
        int newB = (int) Math.ceil(b);
        double sum = 0;
        for (int i = newA; i <= newB; i++) {
            sum += calculatePMF(i);
        }
        return sum;
    }

    // P(X > x)
    public double moreThanX (double x) {
        return 1 - calculateCDF(x);
    }

    // P(X >= x)
    public double moreThanEqualX (double x) {
        return 1 - lessThan(x);
    }


    // Method setter dan getter
    public double getMean() {
        return mean;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    // Method menghitung kombinasi (lebih efisien dan cocok untuk bilangan yang besar)
    // Method ini diambil dari:
    // https://stackoverflow.com/questions/2201113/combinatoric-n-choose-r-in-java-math
    public static long kombinasi(long n, long k) {
        long penyebut = 1;
        long pembilang = 1;

        for (long i = n; i >= (n - k + 1); i--) {
            penyebut *= i;
        }

        for (long i = k; i >= 1; i--) {
            pembilang *= i;
        }

        return (penyebut / pembilang);
    }
}
