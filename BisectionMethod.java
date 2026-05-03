public class BisectionMethod {
    public static double f(double x) { return x*x*x - x - 11; }

    public static void main(String[] args) {
        double a = 0, b = 0;
        
        while (f(b) < 0) { 
            a = b; 
            b++; 
        }

        double mid = 0;
        for (int i = 0; i < 20; i++) {
            mid = (a + b) / 2;
            if (f(mid) < 0) a = mid;
            else b = mid;
        }

        System.out.println(mid);
    }
}
