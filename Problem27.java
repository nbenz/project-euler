import java.util.Arrays;
//Runs in ~23ms
public class Problem27{
   public static void main(String[] args){
      Problem27 p = new Problem27();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      boolean[] primes = sieve(2000000);
      int max_n = 0;
      int x = 0; //Corresponds to the best 'a'
      int y = 0; //Corresponds to the best 'b'
      
      for(int b=2; b<1000; b++){
         if(primes[b]){ //Constant term in the quadratic must be prime for n=0 to work
            for(int a=1-b; a<b; a++){
               int n=1; //Don't need to start at 0 because 0^2 + 0*a + b = b and we know b is prime
               while(primes[Math.abs(n*n+a*n+b)]){
                  n++;
               }
               if(n>max_n){
                  max_n = n;
                  x = a;
                  y = b;
               }
            }
         }
      }
      System.out.println("Result: " + x*y);
   }
   
   public boolean[] sieve(int n){
      boolean[] primes = new boolean[n];
      Arrays.fill(primes,true);
      for(int i=2; i*i<primes.length;i++){
         if(primes[i]){
            for(int j=i; i*j<primes.length; j++){
               primes[i*j] = false;
            }
         }
      }
      return primes;
   }
}