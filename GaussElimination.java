public class Gauss {
    public static void main(String[] args) {
        // Augmented matrix: 3 rows, 4 columns (last column is the constant)
        double[][] a = {
            { 2,  1, -1,  8 },
            {-3, -1,  2, -11},
            {-2,  1,  2, -3 }
        };
        int n = 3;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                for (int k = i; k <= n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = a[i][n]; 
            for (int j = i + 1; j < n; j++) {
                x[i] -= a[i][j] * x[j]; 
            }
            x[i] = x[i] / a[i][i]; 
        }

        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }
}
