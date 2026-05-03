public class RegulaFalsi {

    static double f(double x) {
        return x * x * x - x - 2; // f(x) = x^3 - x - 2
    }

    static void regulaFalsi(double a, double b, double tol) {
        if (f(a) * f(b) >= 0) {
            System.out.println("Invalid interval: f(a) and f(b) must have opposite signs.");
            return;
        }

        double c = a;
        int iter = 0;

        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n",
                "Iter", "a", "b", "c", "f(c)");
        System.out.println("-".repeat(70));

        while (Math.abs(f(c)) > tol) {
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));
            iter++;
            System.out.printf("%-10d %-15.6f %-15.6f %-15.6f %-15.6f%n",
                    iter, a, b, c, f(c));

            if (f(c) == 0.0) break;
            else if (f(c) * f(a) < 0) b = c;
            else a = c;

            if (iter >= 100) break;
        }

        System.out.println("\nRoot = " + c);
    }

    public static void main(String[] args) {
        double a = 1, b = 2, tol = 0.0001;
        System.out.println("Regula Falsi Method for f(x) = x^3 - x - 2");
        System.out.println("Interval: [" + a + ", " + b + "], Tolerance: " + tol);
        System.out.println();
        regulaFalsi(a, b, tol);
    }
}
