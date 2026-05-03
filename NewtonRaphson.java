public class NewtonRaphson {
    static double f(double x) { return x*x*x*x - x - 10; }
    static double df(double x) { return 4*x*x*x - 1; }

    public static void main(String[] args) {
        double x = 0;
        
        while (f(x) < 0) x++;

        for (int i = 0; i < 5; i++) {
            x = x - f(x) / df(x);
        }

        System.out.println(x);
    }
}
