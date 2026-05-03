public class JacobiMethod {

    static void jacobi(double[][] A, double[] b, int n, double tol) {
        double[] x    = new double[n]; // initial guess: all zeros
        double[] xNew = new double[n];
        int iter = 0;

        System.out.printf("%-10s", "Iter");
        for (int i = 0; i < n; i++) System.out.printf("  %-15s", "x[" + (i+1) + "]");
        System.out.println();
        System.out.println("-".repeat(10 + 17 * n));

        while (true) {
            iter++;
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++)
                    if (j != i) sum -= A[i][j] * x[j];
                xNew[i] = sum / A[i][i];
            }

            System.out.printf("%-10d", iter);
            for (int i = 0; i < n; i++) System.out.printf("  %-15.6f", xNew[i]);
            System.out.println();

            // Check convergence
            double maxErr = 0;
            for (int i = 0; i < n; i++)
                maxErr = Math.max(maxErr, Math.abs(xNew[i] - x[i]));

            System.arraycopy(xNew, 0, x, 0, n);
            if (maxErr < tol || iter >= 100) break;
        }

        System.out.println("\nSolution after " + iter + " iterations:");
        for (int i = 0; i < n; i++)
            System.out.printf("x[%d] = %.6f%n", i + 1, x[i]);
    }

    public static void main(String[] args) {
        // 10x + 2y + z  = 7
        //  x + 5y + z   = -8
        //  x + y + 4z   = 12  (diagonally dominant)
        double[][] A = {
            {10, 2,  1},
            { 1, 5,  1},
            { 1, 1,  4}
        };
        double[] b = {7, -8, 12};
        int n = 3;
        double tol = 0.0001;

        System.out.println("Jacobi's Iterative Method");
        System.out.println("System: 10x+2y+z=7,  x+5y+z=-8,  x+y+4z=12");
        System.out.println("Tolerance: " + tol);
        System.out.println();
        jacobi(A, b, n, tol);
    }
}
