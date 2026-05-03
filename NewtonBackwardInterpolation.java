public class NewtonBackwardInterpolation {
    public static void main(String[] args) {
        double[] x = {1891, 1901, 1911, 1921, 1931};
        double[] y = {46, 66, 81, 93, 101};
        double target = 1929;
        int n = x.length;

        double[][] diff = new double[n][n];
        for (int i = 0; i < n; i++) diff[i][0] = y[i];

        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) { 
                diff[i][j] = diff[i][j - 1] - diff[i - 1][j - 1];
            }
        }

        double h = x[1] - x[0];
        double u = (target - x[n - 1]) / h; 

        double result = y[n - 1]; 
        double uTerm = 1.0;
        double fact = 1.0;

        for (int k = 1; k < n; k++) {
            uTerm *= (u + (k - 1));
            fact *= k;
            result += (uTerm / fact) * diff[n - 1][k];
        }

        System.out.println("Value at " + target + " is " + result);
    }
}
