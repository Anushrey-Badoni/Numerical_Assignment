class Main {
    public static double equate(double x) {
        return (x * x * x) - x - 11;
    }
    
    public static void main(String[] args) {
        int i = 0;
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
        
        for (i = 0; i < 10; i++) {
            curr = (negative + positive) / 2;
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
