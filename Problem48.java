public class Problem48 {
   public static void main(String[] args){
      Problem48 p = new Problem48();
      long time = System.currentTimeMillis();
      p.run(1000);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(int n){
      long mod = new Long("10000000000");
      long sum = 0;
      for(int i=1; i<=n; i++){
         sum += power(i,i,mod);
         sum %= mod;
      }      
      System.out.println("Last 10 digits: " + sum);
   }
   
   //Calculates (a^b) mod n
   public long power(long a, long b, long n){
      long result = 1;
      for(long i=0; i<b; i++){
         result *= a;
         result %= n;
      }
      return result;
   }
}