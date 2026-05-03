public class JacobiMethod {
    public static void main(String[] args) {
        double[][] a = {
            {10, 2, 1},
            {1, 5, 1},
            {1, 1, 4}
        };
        double[] b = {7, -8, 12};
        int n = 3;

        double[] x = new double[n];   
        double[] xNew = new double[n]; 

        for (int iter = 0; iter < 10; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum -= a[i][j] * x[j];
                    }
                }
                xNew[i] = sum / a[i][i];
            }
            for (int i = 0; i < n; i++) {
                x[i] = xNew[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }
}
