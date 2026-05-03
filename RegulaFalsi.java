class Main {
    public static double equate(double x) {
        return x * Math.log10(x) - 1.2;
    }
    
    public static double approx(double x0, double x1) {
        return x0 - ((x1 - x0) / (equate(x1) - equate(x0))) * equate(x0);
    }
    
    public static void main(String[] args) {
        int i = 1;
        double positive = 0;
        double negative = 0;
        
        while (true) {
            if (equate(i) < 0) {
                negative = i;
            }
            else {
                positive = i;
                break;
            }
            i++;
        }
        
        double curr = 0;
        
        for (i = 0; i < 4; i++) {
            curr = approx(negative, positive);
            double root = equate(curr);
            
            if (root < 0) {
                negative = curr;
            }
            else if (root == 0) {
                break;
            }
            else {
                positive = curr;
            }
        }
        
        System.out.println(curr);
    }
}
