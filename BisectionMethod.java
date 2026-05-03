public class BisectionMethod {

    static double f(double x) {
        return x * x * x - x - 2; // f(x) = x^3 - x - 2
    }

    static void bisection(double a, double b, double tol) {
        if (f(a) * f(b) >= 0) {
            System.out.println("Invalid interval: f(a) and f(b) must have opposite signs.");
            return;
        }

        double mid = a;
        int iter = 0;

        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n",
                "Iter", "a", "b", "mid", "f(mid)");
        System.out.println("-".repeat(70));

        while ((b - a) / 2 > tol) {
            mid = (a + b) / 2;
            iter++;
            System.out.printf("%-10d %-15.6f %-15.6f %-15.6f %-15.6f%n",
                    iter, a, b, mid, f(mid));

            if (f(mid) == 0.0) break;
            else if (f(mid) * f(a) < 0) b = mid;
            else a = mid;
        }

        System.out.println("\nRoot = " + mid);
    }

    public static void main(String[] args) {
        double a = 1, b = 2, tol = 0.0001;
        System.out.println("Bisection Method for f(x) = x^3 - x - 2");
        System.out.println("Interval: [" + a + ", " + b + "], Tolerance: " + tol);
        System.out.println();
        bisection(a, b, tol);
    }
}
