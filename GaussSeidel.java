public class GaussSeidel {

    static void gaussSeidel(double[][] A, double[] b, int n, double tol) {
        double[] x = new double[n]; // initial guess: all zeros
        int iter = 0;

        System.out.printf("%-10s", "Iter");
        for (int i = 0; i < n; i++) System.out.printf("  %-15s", "x[" + (i+1) + "]");
        System.out.println();
        System.out.println("-".repeat(10 + 17 * n));

        while (true) {
            iter++;
            double maxErr = 0;

            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++)
                    if (j != i) sum -= A[i][j] * x[j];

                double xNew = sum / A[i][i];
                maxErr = Math.max(maxErr, Math.abs(xNew - x[i]));
                x[i] = xNew; // update immediately (key difference from Jacobi)
            }

            System.out.printf("%-10d", iter);
            for (int i = 0; i < n; i++) System.out.printf("  %-15.6f", x[i]);
            System.out.println();

            if (maxErr < tol || iter >= 100) break;
        }

        System.out.println("\nSolution after " + iter + " iterations:");
        for (int i = 0; i < n; i++)
            System.out.printf("x[%d] = %.6f%n", i + 1, x[i]);
    }

    public static void main(String[] args) {
        // 10x + 2y + z  = 7
        //  x + 5y + z   = -8
        //  x + y + 4z   = 12
        double[][] A = {
            {10, 2,  1},
            { 1, 5,  1},
            { 1, 1,  4}
        };
        double[] b = {7, -8, 12};
        int n = 3;
        double tol = 0.0001;

        System.out.println("Gauss-Seidel Iterative Method");
        System.out.println("System: 10x+2y+z=7,  x+5y+z=-8,  x+y+4z=12");
        System.out.println("Tolerance: " + tol);
        System.out.println();
        gaussSeidel(A, b, n, tol);
    }
}
