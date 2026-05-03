public class RegulaFalsi {
    static double f(double x) { return x * Math.log10(x) - 1.2; }

    public static void main(String[] args) {
        double a = 1, b = 1;
        while (f(b) < 0) {
            a = b;
            b++;
        }

        double c = 0;
        for (int i = 0; i < 10; i++) {
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));
            
            if (f(c) < 0) a = c;
            else b = c;       
        }

        System.out.println(c);
    }
}
