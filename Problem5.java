import java.util.Arrays;

public class Problem5 {
   public static void main(String[] args){
      Problem5 p = new Problem5();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));   
   }
   public void run(){
      long[] nums = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
      System.out.println(lcm(nums)); //Smarter way, runs in less than 1ms.
    
    
    
    //Semi brute force, runs in about 120ms.     
    /*int n = 20;
      int product = 20;
      boolean found = false;
      
      while(!found){
         product+=20;
         found = true;
         for(int i=11; i<=n; i++){
            if(product%i != 0){
               found = false;
               break;
            }   
         }
      }
      System.out.println("Product: " + product);*/
   }
   
   public long lcm(long a, long b){
      return (a*b)/gcd(a,b);
   }
   
   public long lcm(long[] nums){
      long result = nums[0];
      for(int i=1; i<nums.length; i++){
         result = lcm(result, nums[i]);
      }
      return result;
   }
   public long gcd(long a, long b){
      long temp;
      while(b>0){
         temp = b; 
         b = a%b;
         a = temp;
      }
      return a;
   } 
}