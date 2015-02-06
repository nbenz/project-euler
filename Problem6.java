public class Problem6{
   public static void main(String[] args){
      long num = 0; //Sort of confusing... This is (1 + 2 + ... + n)^2
      long numSquared = 0;        // While this is (1^2 + 2^2 +...+ n^2)
      
      long time = System.currentTimeMillis(); //Sort of trivial on this one
      
      for(int i=1; i<101; i++){
         num += i;
         numSquared += i*i;
      }
      System.out.println("Result: " + (num*num - numSquared));
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
}