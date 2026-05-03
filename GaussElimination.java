public class GaussElimination {

    static void gaussElimination(double[][] mat, int n) {
        // Forward Elimination
        for (int col = 0; col < n; col++) {
            // Find pivot
            int pivot = col;
            for (int row = col + 1; row < n; row++)
                if (Math.abs(mat[row][col]) > Math.abs(mat[pivot][col]))
                    pivot = row;

            double[] tmp = mat[col]; mat[col] = mat[pivot]; mat[pivot] = tmp;

            if (Math.abs(mat[col][col]) < 1e-10) {
                System.out.println("No unique solution.");
                return;
            }

            for (int row = col + 1; row < n; row++) {
                double factor = mat[row][col] / mat[col][col];
                for (int j = col; j <= n; j++)
                    mat[row][j] -= factor * mat[col][j];
            }
        }

        // Back Substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = mat[i][n];
            for (int j = i + 1; j < n; j++)
                x[i] -= mat[i][j] * x[j];
            x[i] /= mat[i][i];
        }

        System.out.println("Solution:");
        for (int i = 0; i < n; i++)
            System.out.printf("x[%d] = %.6f%n", i + 1, x[i]);
    }

    public static void main(String[] args) {
        // Augmented matrix [A|b]
        // 2x + y - z = 8
        // -3x - y + 2z = -11
        // -2x + y + 2z = -3
        double[][] mat = {
            { 2,  1, -1,  8 },
            {-3, -1,  2, -11},
            {-2,  1,  2, -3 }
        };
        int n = mat.length;

        System.out.println("Gauss Elimination Method");
        System.out.println("System of equations:");
        System.out.println(" 2x +  y -  z =  8");
        System.out.println("-3x -  y + 2z = -11");
        System.out.println("-2x +  y + 2z = -3");
        System.out.println();
        gaussElimination(mat, n);
    }
}
