public class Problem3 {
   public static void main(String[] args){
      long n = new Long("600851475143");
      int highestPrimeFactor = 0;
      
      long time = System.currentTimeMillis();
      
      for(int i=2; i<=n; i++){
         while(n%i == 0){
            highestPrimeFactor = i;
            n /= i;
         }
      }
      System.out.println("Highest prime factor: " + highestPrimeFactor);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
}