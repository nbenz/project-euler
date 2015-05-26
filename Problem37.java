import java.util.ArrayList;

public class Problem37 {
   boolean[] np; //True if composite (not prime)
   
   public static void main(String[] args){
      Problem37 p = new Problem37();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   public void run(){
      np = sieve(1000000);
      ArrayList<Integer> truncPrimes = new ArrayList();

      for(int i=10; i<np.length; i++){
         if(!np[i] && rightTrunc(i) && leftTrunc(i)){
            truncPrimes.add(i);
         }
         //Only 11 truncatable primes exist.
         if(truncPrimes.size() == 11) break; 
      } 
      
      int sum = 0;
      for(int num : truncPrimes){
         sum += num;   
      }
      System.out.println("Sum: " + sum);
   }
   
   private boolean rightTrunc(int n){
      boolean prime = true;
      while(prime && (n/10)>0){
         n /= 10;
         prime = !np[n];
      }
      return prime;
   }
   private boolean leftTrunc(int n){
      boolean prime = true;
      while(prime && n%Math.pow(10,(int)Math.log10(n))>0){
         n %= Math.pow(10,(int)Math.log10(n));
         prime = !np[n];
      }
      return prime;
   }   
   
   private boolean[] sieve(int n){
      boolean[] np = new boolean[n];
      np[0] = true;
      np[1] = true;
      for(int i=2; i*i<n; i++){
         if(!np[i]){
            for(int j=i; i*j<n; j++){
               np[i*j] = true;
            }
         }
      }
      return np;
   }
}