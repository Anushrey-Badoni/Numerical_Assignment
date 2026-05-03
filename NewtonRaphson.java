class Main {
    public static double equate(double x) {
        return (x * x * x * x) - x - 10;
    }
    
    public static double derivative(double x){
        return 4 * (x * x * x) - 1;
    }
    
    public static double newtonRaphson(double x){
        return x - (equate(x)/derivative(x));
    }
    
    public static void main(String[] args) {
        double i = 0;
        double x = -1;
        while (x < 0){
            x = equate(i);
            i++;
        }
        
        for (i = 0; i < 4; i++) {
            x = newtonRaphson(x);
        }
        
        System.out.println(x);
    }
}
