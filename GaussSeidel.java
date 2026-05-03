public class GaussSeidel {
    public static void main(String[] args) {
        // Equation 1:  4x +  y + 2z = 13
        // Equation 2:   x + 3y +  z = 10
        // Equation 3:   x + 2y + 5z = 12
        double[][] a = {
            {4, 1, 2},
            {1, 3, 1},
            {1, 2, 5}
        };
        double[] b = {13, 10, 12};
        int n = 3;
        
        double[] x = new double[n]; 

        for (int iter = 0; iter < 10; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = b[i]; 
                
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum -= a[i][j] * x[j];
                    }
                }
                x[i] = sum / a[i][i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }
}
