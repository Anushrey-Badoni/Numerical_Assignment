public class NewtonRaphson {

    static double f(double x) {
        return x * x * x - x - 2; // f(x) = x^3 - x - 2
    }

    static double fPrime(double x) {
        return 3 * x * x - 1; // f'(x) = 3x^2 - 1
    }

    static void newtonRaphson(double x0, double tol) {
        int iter = 0;
        double x1;

        System.out.printf("%-10s %-15s %-15s %-15s%n", "Iter", "x0", "f(x0)", "f'(x0)");
        System.out.println("-".repeat(55));

        do {
            double fx  = f(x0);
            double fpx = fPrime(x0);

            if (Math.abs(fpx) < 1e-10) {
                System.out.println("Derivative too small. Method fails.");
                return;
            }

            x1 = x0 - fx / fpx;
            iter++;
            System.out.printf("%-10d %-15.6f %-15.6f %-15.6f%n", iter, x0, fx, fpx);
            x0 = x1;

            if (iter >= 100) break;
        } while (Math.abs(f(x0)) > tol);

        System.out.println("\nRoot = " + x0);
    }

    public static void main(String[] args) {
        double x0  = 1.5;
        double tol = 0.0001;
        System.out.println("Newton-Raphson Method for f(x) = x^3 - x - 2");
        System.out.println("Initial guess: " + x0 + ", Tolerance: " + tol);
        System.out.println();
        newtonRaphson(x0, tol);
    }
}
