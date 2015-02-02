public class Problem43 {
   long sum = 0;
   int[] primes = {0,2,3,5,7,11,13,17};
   
   public static void main(String[] args){
      Problem43 p = new Problem43();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      permutation("0123456789");
      System.out.println(sum);
   }
   
   public void permutation(String str) { 
      permutation("", str); 
   }

   private void permutation(String prefix, String str) {
      int n = str.length();
      
      if (n == 0) 
         test(prefix);
      
      else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
      }
   }
   
   public void test(String str){
      String temp;
      int n=0;
      boolean valid = true;
      
      for(int i=1; i<str.length()-2; i++){
         temp = str.substring(i,i+3);
         n = Integer.parseInt(temp);
         if(n%primes[i] != 0){
            valid = false;
         } 
      }
      if(valid)
         sum += Long.parseLong(str);   
   }
}