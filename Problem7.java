import java.util.Arrays;

public class Problem7 {
   public static void main(String[] args){
      Problem7 p = new Problem7();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      int n = 10001;
      boolean[] primes = new boolean[n*15]; //A bit less than 1/10 these are prime, so n*15 will contain the nth prime (for n<=630000, approximately). 
      Arrays.fill(primes,true);
      int count = 0;
      
      for(long i=2; i<primes.length; i++){
         if(primes[(int)i]){
            count++;
            if(count == n){
               System.out.println(n+"st prime: " + i);
               break;
            }
            for(long j=i; i*j<primes.length; j++){
               primes[(int)(i*j)] = false;
            }
         }
      }
   }
}
