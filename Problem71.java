public class Problem71 {
   public static void main(String[] args){
      int d = 1000000;
      long r = 0;
      long s = 1;
      long p;
      
      long time = System.currentTimeMillis();
      
      for(int q=d; q>2; q--){
         p = (3*q-1)/7;
         if(p*s > r*q){
            r = p;
            s = q;
         }
      }
      
      System.out.println("Result: " + r + "/" + s);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
}