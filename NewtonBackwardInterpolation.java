public class NewtonBackwardInterpolation {

    static void newtonBackward(double[] x, double[] y, double value) {
        int n = x.length;
        double h = x[1] - x[0];
        double u = (value - x[n - 1]) / h;

        // Build backward difference table
        double[][] diff = new double[n][n];
        for (int i = 0; i < n; i++) diff[i][0] = y[i];

        for (int j = 1; j < n; j++)
            for (int i = j; i < n; i++)
                diff[i][j] = diff[i][j - 1] - diff[i - 1][j - 1];

        // Print difference table
        System.out.println("Backward Difference Table:");
        System.out.printf("%-10s %-12s", "x", "y");
        for (int j = 1; j < n; j++) System.out.printf(" %-12s", "∇" + j + "y");
        System.out.println();
        System.out.println("-".repeat(10 + 13 * n));

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.4f %-12.4f", x[i], diff[i][0]);
            for (int j = 1; j <= i; j++)
                System.out.printf(" %-12.4f", diff[i][j]);
            System.out.println();
        }

        // Newton Backward Interpolation formula
        double result = diff[n - 1][0];
        double uTerm  = 1.0;
        double factorial = 1.0;

        for (int k = 1; k < n; k++) {
            uTerm    *= (u + (k - 1));
            factorial *= k;
            result   += (uTerm / factorial) * diff[n - 1][k];
        }

        System.out.printf("%nInterpolated value at x = %.4f is y = %.6f%n", value, result);
    }

    public static void main(String[] args) {
        double[] x = {1891, 1901, 1911, 1921, 1931};
        double[] y = {46,   66,   81,   93,   101 };
        double value = 1929;

        System.out.println("Newton Backward Interpolation");
        System.out.println("Find population at year " + (int) value);
        System.out.println();
        newtonBackward(x, y, value);
    }
}
