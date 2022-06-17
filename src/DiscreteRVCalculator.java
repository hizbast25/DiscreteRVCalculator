import java.util.*;
public class DiscreteRVCalculator {
    public static void nextMenu (DiscreteRV RV) {
        boolean valid = true;
        while (valid) {
            Scanner in = new Scanner(System.in);
            System.out.println("\nSilahkan pilih menu yang ingin anda lakukan");
            System.out.println("1. E[X]");
            System.out.println("2. Var(X)");
            System.out.println("3. P(X = a)");
            System.out.println("4. P(X <= a)");
            System.out.println("5. P(X < a)");
            System.out.println("6. P(a < X < b)");
            System.out.println("7. P(a <= X < b)");
            System.out.println("8. P(a < X <= b)");
            System.out.println("9. P(a <= X <= b)");
            System.out.println("10. P(X >= a)");
            System.out.println("11. P(X > a)");
            System.out.println("99. Kembali ke menu sebelumnya");
            System.out.print("Pilihan Anda: ");
            String input = in.nextLine();
            if (input.equals("99")) {
                valid = false;
            }
            else if (input.equals("1")) {
                System.out.printf("Nilai ekspektasi E[x] adalah %.2f\n", RV.getMean());
            }
            else if (input.equals("2")) {
                System.out.printf("Nilai variansi Var(X) adalah %.2f\n", RV.getVariance());

            }
            else if (input.equals("3")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                long a = in.nextLong();
                in.nextLine();
                System.out.printf("Nilai peluang P(X = %.2f) adalah: %.2f\n", (double)a, RV.calculatePMF(a));
            }
            else if (input.equals("4")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(X <= %.2f) adalah: %.2f\n", (double)a, RV.calculateCDF(a));

            }
            else if (input.equals("5")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(X < %.2f) adalah: %.2f\n", (double) a, RV.lessThan(a));

            }
            else if (input.equals("6")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.print("b = ");
                double b = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(%.2f < X < %.2f) adalah: %.2f\n", (double)a, (double)b, RV.xLessThanBMoreThanA(a,b));

            }
            else if (input.equals("7")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.print("b = ");
                double b = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(%.2f <= X < %.2f) adalah: %.2f\n", (double)a,(double)b, RV.xLessThanBMoreThanEqualA(a,b));

            }
            else if (input.equals("8")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.print("b = ");
                double b = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(%.2f < X <= %.2f) adalah: %.2f\n", (double)a,(double)b, RV.xLessThanEqualBMoreThanA(a,b));

            }
            else if (input.equals("8")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.print("b = ");
                double b = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(%.2f <= X <= %.2f) adalah: %.2f\n", (double)a,(double)b, RV.xLessThanEqualBMoreThanEqualA(a,b));
            }
            else if (input.equals("9")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(X >= %.2f) adalah: %.2f\n", (double)a, RV.moreThanEqualX(a));

            }
            else if (input.equals("10")) {
                System.out.println("Silahkan Masukkan Nilai!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                System.out.printf("Nilai peluang P(X > %.2f) adalah: %.2f\n", (double) a, RV.moreThanX(a));

            }
            else {
                System.out.println("Input Anda tidak valid!");
            }
            }
        }

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("\nSelamat datang di Discrete RV Calculator!");
            System.out.println("Silahkan pilih Discrete RV yang ingin dihitung");
            System.out.println("1. Bernoulli");
            System.out.println("2. Binomial");
            System.out.println("3. Geometric");
            System.out.println("4. Hypergeometric");
            System.out.println("5. Poisson");
            System.out.println("99. Keluar");
            Scanner in = new Scanner(System.in);
            System.out.print("Pilihan Anda: ");
            String input = in.nextLine();
            if (input.equals("99")) {
                System.out.println("\nTerima kasih telah menggunakan program ini!");
                run = false;
            }
            else if (input.equals("1")) {
                System.out.println("\nSilahkan Masukkan Paramater untuk Bernoulli!");
                System.out.print("p = ");
                double p = in.nextDouble();
                in.nextLine();
                nextMenu(new Bernoulli(p));
            }
            else if (input.equals("2")) {
                System.out.println("\nSilahkan Masukkan Paramater untuk Binomial!");
                System.out.print("p = ");
                double p = in.nextDouble();
                in.nextLine();
                System.out.print("n = ");
                long n = in.nextLong();
                in.nextLine();
                nextMenu(new Binomial(p, n));
            }
            else if (input.equals("3")) {
                System.out.println("\nSilahkan Masukkan Paramater untuk Geometric!");
                System.out.print("p = ");
                double p = in.nextDouble();
                in.nextLine();
                nextMenu(new Geometric(p));

            }
            else if (input.equals("4")) {
                System.out.println("\nSilahkan Masukkan Paramater untuk Hypergeometric!");
                System.out.print("n = ");
                long n = in.nextLong();
                in.nextLine();
                System.out.print("r = ");
                long r = in.nextLong();
                in.nextLine();
                System.out.print("N = ");
                long capitalN = in.nextLong();
                in.nextLine();
                nextMenu(new Hypergeometric(n, r, capitalN));
            }
            else if (input.equals("5")) {
                System.out.println("\nSilahkan Masukkan Paramater untuk Poisson!");
                System.out.print("a = ");
                double a = in.nextDouble();
                in.nextLine();
                nextMenu(new Poisson(a));

            }
            else {
                System.out.println("\nInput Anda tidak valid!");
            }
        }

    }
}
