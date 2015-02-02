public class Problem12 {
    public static void main(String[] args) {
        Problem12 p = new Problem12();
        long time = System.currentTimeMillis();
        p.run();
        System.out.println("Time: " + (System.currentTimeMillis()-time));
    }
    
    public void run(){
      int divisors = 0;
      int triangle = 0; //Current triangular number
      int n = 1;    //Iteration tracker
      int threshold = 500; //Divisor threshold
      
      while(divisors <= threshold){
         triangle = n*(n+1)/2; //Standard closed formula for 1+2+3+...+n
         divisors = numDivisors(triangle);  
         n++;
     }
     System.out.println(triangle);
    }
    public int numDivisors(int n) {
        int num = 0;
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i==0) {
                num += 2; //Each divisor has a pair
            }
        }
        return num;
    }
}