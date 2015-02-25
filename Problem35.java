import java.util.Arrays;

public class Problem35 {
   public static void main(String[] args){
      Problem35 p = new Problem35();
      long time = System.currentTimeMillis();
      p.run(1000000);
      System.out.println("Time: "+(System.currentTimeMillis()-time));
   }
   public void run(int n){
      boolean[] primes = sieve(n);
      boolean[] checked = new boolean[n]; //Don't want to double check numbers
      int count = 0;
      
      for(int i=2; i<n; i++){
         if(primes[i] && !checked[i]){
            boolean circle = true;
            int temp = circle(i);
            int sub_count = 1; //Counts the number of "circles" in a particular circular prime
            while(temp != i){ //This setup prevents a number like 11 from being counted twice, because the circles aren't distinct
               checked[temp] = true; //Number has been checked
               if(!primes[temp]){
                  circle = false;
                  break;
               }
               sub_count++;
               temp = circle(temp); //Get the next circle
            }
            if(circle)
               count += sub_count;
         }      
      }
      System.out.println("Circular primes below " +n+": "+count);
   }
   
   private int circle(int n){
      String str = String.valueOf(n);
      str = str.charAt(str.length()-1) + str.substring(0,str.length()-1);
      return Integer.parseInt(str);
   }
   
   //Sieve of primes k, s.t. 2 <= k < n
   private boolean[] sieve(int n){
      boolean[] primes = new boolean[n];
      Arrays.fill(primes,true);
      for(int i=2; i*i<n; i++){
         if(primes[i]){
            for(int j=i; i*j<n; j++){
               primes[i*j] = false;
            }
         }
      }
      return primes;
   }
}