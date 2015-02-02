public class Problem50{
   int x = 10000000;
   int[] primes = new int[x/2];
   int next = 0;

   public static void main(String[] args){
      Problem50 p = new Problem50();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   public void run(){
      for(int i=0; i<x; i++){
         if(isPrime(i)){
            primes[next]=i;
            next++;
         }
      }
      int count = 0;
      int maxCount = 0;
      int sum = 0;
      int maxSum = 0;
      int j;
      
      for(int i=0; i<primes.length;i++){
         count = 0;
         sum = 0;
         j = i;
         
         while(primes[j]!=0 && (sum+primes[j])<x && j<(primes.length-1)){  //God that's ugly.
            sum += primes[j];
            count++;
            j++;
            if(count>maxCount && isPrime(sum)){
               maxCount = count;
               maxSum = sum;
            }  
         }
                
      }
      System.out.println("Prime: " + maxSum);
      System.out.println("Length: " + maxCount);
      
   }
   
   public boolean isPrime(int n){
      if(n<=1) return false;
      if(n==2 || n==3) return true;
   
      for(int i=2; i<=Math.sqrt(n); i++){
         if(n%i==0)
            return false;   
      }
      return true;
   }
}